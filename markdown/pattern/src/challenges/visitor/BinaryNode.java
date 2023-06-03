package challenges.visitor;

/**
 * A node representing a binary tree.
 *
 * @param data  item to store in this node
 * @param left  left child of this node
 * @param right right child of this node
 * @param <T>   parametric type of the tree elements
 */
public record BinaryNode<T>(T data, BinaryNode<T> left, BinaryNode<T> right) implements Node<T> {

    @Override
    public T accept(NodeVisitor<T> visitor) {
        throw new UnsupportedOperationException();
    }
}
