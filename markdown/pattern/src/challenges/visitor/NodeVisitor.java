package challenges.visitor;

/**
 * Visitor pattern for a search tree.
 *
 * @param <T> parametric type of the tree elements
 */
public interface NodeVisitor<T> {

    /**
     * Visit a unary search tree (leaf).
     *
     * @param node to visit
     * @return the result of visiting the node (recursively)
     */
    T visit(UnaryNode<T> node);

    /**
     * Visit a binary search tree.
     *
     * @param node to visit
     * @return the result of visiting the node (recursively)
     */
    T visit(BinaryNode<T> node);
}
