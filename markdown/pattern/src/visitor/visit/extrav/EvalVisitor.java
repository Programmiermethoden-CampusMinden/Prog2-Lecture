package visitor.visit.extrav;

import static org.junit.Assume.assumeTrue;

import java.util.Stack;

/** Visitor zum Berechnen der Ausdrücke */
public class EvalVisitor implements ExprVisitor {
    private final Stack<Integer> erg = new Stack<>();

    @Override
    public void visit(NumExpr e) {
        erg.push(e.getValue());
    }

    @Override
    public void visit(MulExpr e) {
        e.getE1().accept(this);
        e.getE1().accept(this);
        erg.push(erg.pop() * erg.pop());
    }

    @Override
    public void visit(AddExpr e) {
        e.getE1().accept(this);
        e.getE1().accept(this);
        erg.push(erg.pop() + erg.pop());
    }

    /** Liefere das Ergebnis zurück */
    public int getResult() {
        assumeTrue(erg.size() == 1);
        return erg.peek();
    }
}
