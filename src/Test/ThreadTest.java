package Test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
    //这个程序是线程不安全的，所以造成的结果count值可能小于200;
    private static int count = 0;
    //可以使用原子操作类，底层使用的是cas机制
    //AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        count++;
//                        count.incrementAndGet();
                    }
                }
            }).start();
        }
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public void implThread(){
        Thread thread = new Thread(new chatt(10));//线程传参
        thread.start();
    }

    static class chatt implements Runnable{

        @Override
        public void run() {
            System.out.println("ceshi run");
        }

        public chatt(int a){
            System.out.println("===="+a);
        }
    }
}
