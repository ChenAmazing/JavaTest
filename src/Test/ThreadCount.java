package Test;

import java.util.ArrayList;
import java.util.List;

public class ThreadCount {
    static int count = 0;
    public static synchronized void get(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count = 1000;
        System.out.println(count);
    }
    static Thread t1 = new Thread(new Runnable(){
        @Override
        public void run() {
           get();
        }
    });

    static Thread t2 = new Thread(new Runnable(){
        @Override
        public void run() {
            count = 2000;
            System.out.println(count);
        }
    });
    public static void main(String[] args) {
        t1.start();
        t2.start();
    }
}
