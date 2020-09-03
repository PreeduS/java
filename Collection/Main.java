
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main (final String args[]){

        // list
        List<String> list1 = Arrays.asList("A","B");
        List<String> list2 = List.of("A","B");
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new LinkedList<>();
        
        // list1.add("");
        // list1.get(index);
        // list1.remove(index);
        
        list1.forEach(System.out::println);
        
        // list4.add("");



        // set
        Set<Integer> set1 = Set.of(10,20,30);
        Set<Integer> set2 = new HashSet<>();            // not ordered, uses hashCode() / equals()
        Set<Integer> set3 = new LinkedHashSet<>();      // is ordered
        Set<Integer> set4 = new TreeSet<>();            // is ordered and sorted    // All elements inserted into the set must implement the Comparable interface
        
        // list             set
        // ordered          not always ordered
        // indexed          not indexed
        // duplicates       no duplicates
        
        
        for(Integer x : set1){
                System.out.println(x);
        }
        
        
        //set2.add(10);
        //set2.add(20);
        
        //set2.forEach(System.out::println);


        Set<Cat> customSet = new TreeSet<>();
        customSet.add( new Cat(1));
        customSet.add( new Cat(3));
        customSet.add( new Cat(2));
        for(Cat x : customSet){
            System.out.println(x);
        }

        // Comparable - internal way to compare - compareTo(Object o)
        // Comparator - external way to compare - compare(Object o, Object o2)
        
        Comparator<Dog> comparator = (o, o2) ->  o.getAge() - o2.getAge();
        Comparator<Dog> comparator2 = (o, o2) ->  o.getAge().compareTo( o2.getAge());

        Set<Dog> customSet2 = new TreeSet<>(comparator2);
        customSet2.add( new Dog(1));
        customSet2.add( new Dog(3));
        customSet2.add( new Dog(2));

        customSet2.forEach(System.out::println);



        // deque - double ended queue
        // elements can be added to or removed from either the front (head) or back (tail)
        Deque<Integer> d1 = new ArrayDeque<>();
        
        // d1.pop();    // removes and return the first element     // removeFirst, remove
        // d1.push();   // inserts an element at the head           // addFirst
        // d1.add();    // inserts an element at the tail
        // d1.removeLast()



        // deque -> stack - LIFO
        // deque -> queue - FIFO




        // map

        Map<Integer, String> m1 = new HashMap<>();                  // not ordered
        Map<Integer, String> m2 = new LinkedHashMap<>();            // is ordered
        Map<Integer, String> m3 = new TreeMap<>();                  // is ordered and sorted

        m1.put(1, "1");
        m1.put(1, "10");        // duplicates will override
        m1.put(2, "20");
        // m1.get(1);
 
        
        for(Map.Entry<Integer, String> entry : m1.entrySet()){
            // or m1.keySet() m1.values()
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        m1.forEach((k, v) -> System.out.println(k + " : " + v));
        
        
    }
}














/*
# Java Fundamentals - Lesson 34 - Collection Framework & Lists      # done
https://www.youtube.com/watch?v=9VsqnLaHHHI&list=PLEocw3gLFc8XWfGUO340uLA1p0WY-8H6a&index=44&t=0s
Java Fundamentals - Lesson 35 - Lists and Sets part 2               # done
Java Fundamentals - Lesson 36 - Comparable & Comparator             # done
Java Fundamentals - Lesson 37 - Deques and Maps                     # done
---


# java.util
Iterable<E> ---> Collection<E>

Collection<E> iface - root of collections of a single element
Collection<E> ---> List<E>, Set<E>, Deque<E>, Queue<E>

List<E> iface ---> ArrayList<E>, LinkedList<E>
Set<E> ---> HashSet<E>, LinkedHashSet<E>, TreeSet
Queue<E> ---> Deque<E>
Deque<E> ---> ArrayDeque<E>


---
Map<K,V> - multiple elements, tuples

Map<K,V> ---> HashMap<K,V>, LinkedHashMap<K,V>, TreeHashMap<K,V>


---

Collections - util class
Collection - interface


*/