package visitor.visit.extrav;

/** Zusammengesetzter Ausdruck: Multiplikation zweier Ausdrücke */
public class MulExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    /** Erzeuge eine neue MulExpr-Instanz */
    public MulExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public void accept(ExprVisitor v) {
        v.visit(this);
    }

    /** Liefere das linke Kind zurück */
    public Expr getE1() {
        return e1;
    }

    /** Liefere das rechte Kind zurück */
    public Expr getE2() {
        return e2;
    }
}
