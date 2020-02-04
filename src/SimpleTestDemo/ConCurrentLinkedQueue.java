package SimpleTestDemo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class ConCurrentLinkedQueue {
    static ConCurrentLinkedQueue queue = new ConCurrentLinkedQueue();
    final static int NUM = 10;
    static CountDownLatch latch = new CountDownLatch(NUM);
    public static void main(String[] args) throws Exception {
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new ThreadTest(i));
            thread.start();
        }
        latch.await();

//        System.out.println(list.toString());
//        System.out.println(Arrays.asList(array));

    }
    static public class ThreadTest implements Runnable{
        int n = 0;
        public ThreadTest(int num){
            n = num;
        }
        @Override
        public void run() {
            latch.countDown();
//            queue
//            queue.offer(n);
        }
    }
}
