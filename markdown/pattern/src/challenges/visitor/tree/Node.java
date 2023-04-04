package challenges.visitor.tree;

import static java.util.Objects.requireNonNull;

import visitor.INodeVisitor;

/**
 * Node in a binary search tree.
 *
 * @param <T> parametric type of the node data
 */
public class Node<T extends Comparable<T>> {
    private Node<T> leftChild;
    private Node<T> rightChild;
    private T data;

    /**
     * Create a new node without children.
     *
     * @param data vehicle to store in the new node (must not be {@code null})
     * @throws NullPointerException if data is {@code null}
     */
    public Node(T data) {
        requireNonNull(data);

        this.data = data;
    }

    private static <T extends Comparable<T>> Node<T> addDataToSubTree(Node<T> node, T data) {
        if (node == null) {
            // Create a new node if this branch does not yet exist
            node = new Node<>(data);
        } else {
            // Otherwise, add data to this existing branch
            node.addData(data);
        }
        return node;
    }

    private static <T extends Comparable<T>> Node<T> clone(Node<T> node) {
        Node<T> clone = null;

        if (node != null) {
            clone = new Node<>(node.getData());
            clone.leftChild = clone(node.getLeftChild());
            clone.rightChild = clone(node.getRightChild());
        }

        return clone;
    }

    /**
     * Add a vehicle to the tree.
     *
     * <p>If the vehicle already exists in a node in the tree, the old vehicle is replaced by the
     * new vehicle in that node. Otherwise, a new node without children is created and added to the
     * correct position in the tree.
     *
     * @param data vehicle to be inserted (must not be {@code null})
     * @throws NullPointerException if data is {@code null}
     */
    public void addData(T data) {
        requireNonNull(data);

        final int compareVal = this.data.compareTo(data);

        if (compareVal == 0) {
            // Overwrite existing entry
            this.data = data;
        } else if (compareVal < 0) {
            // Search right subtree
            rightChild = addDataToSubTree(rightChild, data);
        } else {
            // Search left subtree
            leftChild = addDataToSubTree(leftChild, data);
        }
    }

    /**
     * Accept a visitor to this node.
     *
     * <p>The visitor needs to do all the heavy lifting, i.e. it needs to implement not only how to
     * process the node's data but also how to traverse the children of this node.
     *
     * @param visitor the visitor which will work on this node (must not be {@code null})
     * @return a string representation as result of the traversal process
     * @throws NullPointerException if visitor is {@code null}
     */
    public String accept(INodeVisitor<T> visitor) {
        requireNonNull(visitor);

        return visitor.visit(this);
    }

    /** Returns a copy of the left child node of this node. */
    public Node<T> getLeftChild() {
        return clone(leftChild);
    }

    /** Returns a copy of the right child node of this node. */
    public Node<T> getRightChild() {
        return clone(rightChild);
    }

    /** Returns the stored data in this node. */
    public T getData() {
        return data;
    }
}
