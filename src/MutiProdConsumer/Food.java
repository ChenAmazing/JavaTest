package MutiProdConsumer;

public class Food {
    static int target = 0;
    final static int max_value = 20;

    //生产
    //synchronized加锁，consumer线程启动时，获取不了target的值，处于阻塞状态，只有等待producter运行结束后才可以运行
    public  synchronized void produce(){
        while(target>=max_value){
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20);
            target++;
            System.out.println(Thread.currentThread().getName()+" 生产一个汉堡，当前汉堡数："+target);
            if(target==max_value){
                //单单notify的话只能唤醒自己，外层循环，依旧wait
                notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //消费
    public  synchronized void consume(){
        while(target<=0){
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20);
            target--;
            System.out.println(Thread.currentThread().getName()+" 消费一个汉堡，当前汉堡数："+target);
            if(target==0){
                //单单notify的话只能唤醒自己，外层循环，依旧wait
                notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
