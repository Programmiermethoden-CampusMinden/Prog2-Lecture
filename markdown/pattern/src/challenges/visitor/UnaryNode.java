package challenges.visitor;

/**
 * A node representing a unary tree: just a leaf.
 *
 * @param data item to store in this node
 * @param <T>  parametric type of the tree elements
 */
public record UnaryNode<T>(T data) implements Node<T> {

    @Override
    public T accept(NodeVisitor<T> visitor) {
        throw new UnsupportedOperationException();
    }
}
