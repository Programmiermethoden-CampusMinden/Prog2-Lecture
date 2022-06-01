package visitor.visit.intrav;

/** Zusammengesetzter Ausdruck: Addition zweier Ausdrücke */
public class AddExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    /** Erzeuge eine neue MulExpr-Instanz */
    public AddExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public void accept(ExprVisitor v) {
        e1.accept(v);
        e2.accept(v);
        v.visit(this);
    }
}
