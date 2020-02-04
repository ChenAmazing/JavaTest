package ProxyTest;

public class Person implements GiveMoney{
    public String name;

    public Person(String name){
        this.name = name;
    }
    @Override
    public void giveMoney() {
        System.out.println(name+"交了钱");
    }
}
