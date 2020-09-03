//package Lambda;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(final String args[]) {

        Printer printerLambda = (value) -> {
            System.out.println("lambda: " + value);         
            // this taken from parent, error in this case for static method
        };
        // Printer printerClass = new PrinterClass();
        Printer printerClass = new PrinterClass(){
            @Override
            public void print(String value) {
                System.out.println("class override: "+ value + ", this: " + this);
            }
        };

        test(printerLambda, "val");
        test(printerClass, "val2");

        // thread

        Thread threadClass = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread class");

            }
        });
        Thread threadLambda = new Thread(() -> System.out.println("thread lambda"));
        //Thread threadLambda = new Thread(Main::printMessage);


        threadClass.run();
        threadLambda.run();

     
        divide(2, 0, exceptionWrapper(
            (nr, nr2) -> System.out.println("Divide result: " + nr / nr2)
        ));

        // Method Reference
        Arrays.asList("A","B").forEach(Main::printMessage);

    }

    public static void test(Printer printer, String value) {
        printer.print(value);
    }


    
    public static void divide(int nr, int nr2, BiConsumer<Integer, Integer> consumer) {
        consumer.accept(nr, nr2);
    }
    public static BiConsumer<Integer, Integer> exceptionWrapper( BiConsumer<Integer, Integer> consumer){
        return (nr, nr2) -> {
            try{
                consumer.accept(nr, nr2);

            }catch(ArithmeticException e){
                System.out.println("ArithmeticException");
            }
    
        };
        // return consumer;
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
    public static void printMessage(){
        System.out.println("No Message");
    }

}

/*@FunctionalInterface
interface Printer {
    void print(String value);
}*/

// @FunctionalInterface - enforce one method

@FunctionalInterface
interface Printer<T> {

    void print(T value);
}

// Predicate<T>         // takes one arg, returns a boolean
// Function<T, R>       // takes one arg, returns a result
// Consumer<T>          // tages one arg, returns no result



// this inside lambda, references the parent instance





/*
https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3
Java 8 Lambda Basics            # 22/25

*/

