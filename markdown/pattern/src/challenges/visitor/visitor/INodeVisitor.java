package challenges.visitor.visitor;

import tree.Node;

/**
 * Interface to implement the visitor pattern for a binary search tree.
 *
 * @param <T> parametric type of the binary search tree elements
 */
public interface INodeVisitor<T extends Comparable<T>> {

    /**
     * Visit a node.
     *
     * @param node to visit
     * @return the result of visiting the node (recursively)
     */
    String visit(Node<T> node);
}
