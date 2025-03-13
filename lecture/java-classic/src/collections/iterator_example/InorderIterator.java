package iterator_example;

import iterator_example.BinarySearchTree.Node;
import java.util.*;

public class InorderIterator implements Iterator<Node> {

    // Nutz einen Stack um die Reihenfolge zu bestimmen
    public Stack<Node> traversal;

    /**
     * Iterator um Inorder ueber einen BinaryTree zu iterieren
     *
     * @param root Startknoten
     */
    InorderIterator(Node root) {
        traversal = new Stack<Node>();
        visitLeft(root);
    }

    private void visitLeft(Node current) {
        // gehe solange nach Links in den Baum, bis das Ende erreicht ist.
        while (current != null) {
            // lege jeden besuchten Node auf den Stack
            traversal.push(current);
            if (current.getLeftChild().isPresent()) current = (Node) current.getLeftChild().get();
            else current = null;
        }
    }

    public boolean hasNext() {
        // wenn der Stack leer ist, gibt es keine unbesuchten Nodes mehr
        return !traversal.isEmpty();
    }

    public Node next() {
        if (!hasNext()) throw new NoSuchElementException();
        // nimm den naechsten Node vom Stack
        Node current = traversal.pop();
        // wenn current ein rechten Child Node hat, dann legen diesen und dessen Kinder auf den
        // Stack
        if (current.getRightChild().isPresent()) {
            visitLeft((Node) current.getRightChild().get());
        }
        return current;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
