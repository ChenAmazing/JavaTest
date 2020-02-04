package ProxyTest;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Testmain {
    public static void main(String[] args) {
        GiveMoney p = new Person("zhangsan");
        InvocationHandler myInvocationHandler = new MyInvocationHandler(p);
        GiveMoney giveMoneyProxy = (GiveMoney) Proxy.newProxyInstance(GiveMoney.class.getClassLoader(), new Class[]{GiveMoney.class}, myInvocationHandler);
        giveMoneyProxy.giveMoney();
//        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler)；
    }

}
