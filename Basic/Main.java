//package Basic;

public class Main {
    public static void main (final String args[]){
        final int intArr[] = new int[10];
        intArr[0] = 1;

        final int intArr2[] = {1,2,3};
        System.out.println("len: " + intArr2.length);

        print(new int[10]);
        print2(new int[]{1,2,3});

        final int intArr3[][] = {{1,2},{3,4}};
        System.out.println("[0][0] " + intArr3[0][0] );
    }
    static void print(int[] arr){
        System.out.println(arr);
    }
    static void print2(int... arr){
        System.out.println(arr);
        for(final int i : arr){
            System.out.println(i);
        }

    }
    
}
 
