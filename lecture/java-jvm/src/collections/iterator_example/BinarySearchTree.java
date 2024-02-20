package iterator_example;

import java.util.Iterator;
import java.util.Optional;

/**
 * Implementierung eines BinarySearchTree mit Node als nested class
 *
 * @param <T> Typ der Daten die in den Nodes gespeichert werden
 */
public class BinarySearchTree<T extends Comparable<? super T>>
        implements Iterable<BinarySearchTree> {
    private Node root;

    /**
     * Legt einen neuen Eintrag im Tree an
     *
     * @param data Daten die gespeichert werden sollen
     */
    public void add(T data) {
        if (root == null) root = new Node(data);
        else root.add(data);
    }

    @Override
    public Iterator iterator() {
        return new InorderIterator(root);
    }

    class Node {
        private Node leftChild;
        private Node rightChild;
        private T data;

        private Node(T data) {
            this.data = data;
        }

        private void add(T data) {
            if (this.data.compareTo(data) >= 0) {
                if (leftChild == null) leftChild = new Node(data);
                else leftChild.add(data);
            } else {
                if (rightChild == null) rightChild = new Node(data);
                else rightChild.add(data);
            }
        }

        public T getData() {
            return data;
        }

        public Optional<Node> getLeftChild() {
            return Optional.ofNullable(leftChild);
        }

        public Optional<Node> getRightChild() {
            return Optional.ofNullable(rightChild);
        }
    }
}
