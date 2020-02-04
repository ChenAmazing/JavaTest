package FactoryTest;

public class makeKeyboard implements IFactory {
    @Override
    public Goods makeConf() {
        return new Keyboard();
    }
}
