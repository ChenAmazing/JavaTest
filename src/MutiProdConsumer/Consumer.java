package MutiProdConsumer;

public class Consumer extends Thread {
    Food food;
    public Consumer(Food food){
        this.food = food;
    }

    @Override
    public void run() {
        while(true){
            food.consume();
        }
    }
}
