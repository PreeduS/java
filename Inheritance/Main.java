//package Inheritance;

public class Main {
    public static void main (final String args[]){
        System.out.println("Hello world");
        Child child = new Child();
        child.method();
        child.aMethod("test");
        child.aMethod2("atest");

        Parent child2 = new Child();

        child2.aMethod("test2");
        child2.aMethod2("atest2");

        Iface child3 = new Child();
        child3.method();
    }
    
}
 
