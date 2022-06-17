package iterator_example;

import java.util.Iterator;
import java.util.Vector;

public class IteratorExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        Iterator<Integer> iterator = vector.iterator();
        System.out.println(iterator.next()); // 1
        iterator.forEachRemaining(x -> System.out.print(x)); // 23
        System.out.println("\n" + iterator.hasNext()); // false
        iterator.next(); // NoSuchElementException
    }
}
