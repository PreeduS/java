//package Inheritance;

public interface Iface {
    Integer number = 100;                       // static final inferred, use not recommended
    void method();                              // public abstract inferred
    
    default void defaultMethod(){
        System.out.println("defaultMethod");
    }
    static void staticMethod(){
        System.out.println("staticMethod");
    }
    // private static void staticMethod2(){ }
}


// public interface Iface extends Iface2, Iface3

// default - mainly created to maintain backwards compatibility
