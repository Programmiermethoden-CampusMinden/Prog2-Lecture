package visitor.visit.intrav;

import static org.junit.Assume.assumeTrue;

import java.util.Stack;

/** Visitor für Pretty-Pring der Ausdrücke */
public class PrintVisitor implements ExprVisitor {
    private final Stack<String> erg = new Stack<>();

    @Override
    public void visit(NumExpr e) {
        erg.push("NumExpr(" + e.getValue() + ")");
    }

    @Override
    public void visit(MulExpr e) {
        erg.push("MulExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }

    @Override
    public void visit(AddExpr e) {
        erg.push("AddExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }

    /** Liefere das Ergebnis zurück */
    public String getResult() {
        assumeTrue(erg.size() == 1);
        return erg.peek();
    }
}
