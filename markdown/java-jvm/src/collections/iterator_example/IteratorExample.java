package iterator_example;

import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(4);
        tree.add(12);
        tree.add(5);
        tree.add(3);
        tree.add(9);
        tree.add(33);
        tree.add(-5);
        tree.add(2);
        // hol den iterator
        Iterator<BinarySearchTree.Node> iterator = tree.iterator();
        System.out.println(iterator.next().getData());
        iterator.forEachRemaining(n -> System.out.println(n.getData()));
        System.out.println(iterator.hasNext());
        //  iterator.next(); //NoSuchElement Exception
    }
}
