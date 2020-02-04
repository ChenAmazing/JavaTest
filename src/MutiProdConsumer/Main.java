package MutiProdConsumer;

public class Main {
    public static void main(String[] args) {
        Food food = new Food();
        Thread Tproducter = new Producter(food);
        Thread Tproducter2 = new Producter(food);
        Thread Tconsumer = new Consumer(food);
        Thread Tconsumer2 = new Consumer(food);
        Tproducter.start();
        Tproducter2.start();
        Tconsumer.start();
        Tconsumer2.start();
    }
}
