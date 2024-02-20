package visitor.visit.intrav;

/** Einfachster Ausdruck: Ein (Integer-) Literal */
public class NumExpr implements Expr {
    private final int d;

    /** Erzeuge eine neue NumExpr-Instanz */
    public NumExpr(int d) {
        this.d = d;
    }

    @Override
    public void accept(ExprVisitor v) {
        v.visit(this);
    }

    /** Liefere den Wert zurück */
    public int getValue() {
        return d;
    }
}
