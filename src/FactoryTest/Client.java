package FactoryTest;

public class Client {
    public static void main(String[] args) {
        makeKeyboard mkb = new makeKeyboard();
        mkb.makeConf().gets();
    }
}
