package challenges.visitor;

public class Main {
    public static void main(final String... args) {
        // 1. Ein Baum: K(A(, D(, )), R(, X(, )))
        BinaryNode<String> binaryTree = new BinaryNode<>("K",
                new BinaryNode<>("A", null, new BinaryNode<>("D", null, null)),
                new BinaryNode<>("R", null, new BinaryNode<>("X", null, null)));
/*
        BinaryNode<String> mixedTree = new BinaryNode<>("K",
                new BinaryNode<>("A", new UnaryNode<>(""), new UnaryNode<>("D")),
                new BinaryNode<>("R", new UnaryNode<>(""), new UnaryNode<>("X")));
*/
/*
        Node<String> tree = new BinaryNode<>("K",
                new BinaryNode<>("A", new UnaryNode<>(""), new UnaryNode<>("D")),
                new BinaryNode<>("R", new UnaryNode<>(""), new UnaryNode<>("X")));
*/


        // 2. Ein einfacher Visitor (als anonyme Klasse)
        NodeVisitor<String> nodeVisitor = new NodeVisitor<String>() {
            @Override
            public String visit(UnaryNode<String> node) {
                throw new UnsupportedOperationException();
            }

            @Override
            public String visit(final BinaryNode<String> node) {
                throw new UnsupportedOperationException();
            }
        };


        // 3. Verschiedene Aufrufe des Visitors mit den verschiedenen Bäumen
        String result;

        // a) Objekt binaryTree: Worin besteht der Unterschied der Aufrufe?
        result = binaryTree.accept(nodeVisitor);
        result = nodeVisitor.visit(binaryTree);

        // b) Objekt mixedTree: Worin besteht der Unterschied der Aufrufe?
//        result = mixedTree.accept(nodeVisitor);
//        result = nodeVisitor.visit(mixedTree);

        // c) Objekt tree: Worin besteht der Unterschied der Aufrufe?
//        result = tree.accept(nodeVisitor);
//        result = nodeVisitor.visit(tree);
    }
}
