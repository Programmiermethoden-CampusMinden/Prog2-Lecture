package challenges.visitor;

/**
 * Common interface of all nodes: accept a visitor.
 *
 * @param <T> parametric type of the tree elements
 */
public interface Node<T> {

    /**
     * Accept a visitor.
     *
     * @param visitor to accept
     * @return the result of visiting the node (recursively)
     */
    T accept(NodeVisitor<T> visitor);
}
