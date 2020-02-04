package MutiProdConsumer;

public class Producter extends Thread{
    Food food;
    public Producter(Food food){
        this.food = food;
    }

    @Override
    public void run() {
        while(true){
            food.produce();
        }
    }
}
