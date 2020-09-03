//package Inheritance;

// Abstact class - can only be extended, can't be instantiated
public abstract class Parent {
    public abstract void aMethod(String value);
    public void aMethod2(String value){
        System.out.println("aMethod2: " + value);
    };
}