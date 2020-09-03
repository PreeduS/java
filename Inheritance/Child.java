//package Inheritance;

public class Child extends Parent implements Iface, Iface2{

    @Override
    public void method() {
       System.out.println("method");

    }

    @Override
    public void aMethod(String value) {
        System.out.println("aMethod: " + value);

    }
    
}