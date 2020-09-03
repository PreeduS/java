//package Lambda;

// public class PrinterClass implements Printer{
public class PrinterClass implements Printer<String>{

    @Override
    public void print(String value) {
        System.out.println("class: "+ value);

    }
    
}