package SingleThreadReactor;

import SingleThreadReactor.Handler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

class Reactor implements Runnable
{
    final Selector selector;
    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException
    { //Reactor初始化
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        //非阻塞
        serverSocket.configureBlocking(false);

        //分步处理,第一步,接收accept事件
        //将accept接收到的连接注册到selector中
        //向Selector中注册感兴趣的事件
        //SelectionKey对象，该对象是用于跟踪这些被注册事件的句柄。
        SelectionKey sk =
                serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //attach callback object, Acceptor
        sk.attach(new Acceptor());
    }

    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                // Selector调用select()方法后，检测所有注册的通道，
                // 返回给Reactor(反应器)我们感兴趣的事件已经准备就绪的那些通道，
                // 然后Reactor分发给不同的handler处理(handlerAccept、handlerReader)。
                //这条语句会阻塞
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext())
                {
                    //Reactor负责dispatch收到的事件
                    dispatch((SelectionKey) (it.next()));
                }
                selected.clear();
            }
        } catch (IOException ex)
        { /* ... */ }
    }

    void dispatch(SelectionKey k)
    {
        Runnable r = (Runnable) (k.attachment());
        //调用之前注册的callback对象
        if (r != null)
        {
            r.run();
        }
    }

    // inner class
    class Acceptor implements Runnable
    {
        public void run()
        {
            try
            {
                SocketChannel channel = serverSocket.accept();
                if (channel != null)
                    new Handler(selector, channel);
            } catch (IOException ex)
            { /* ... */ }
        }
    }
}
