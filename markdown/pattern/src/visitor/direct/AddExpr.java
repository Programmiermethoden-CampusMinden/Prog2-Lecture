package visitor.direct;

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
    public int eval() {
        return e1.eval() + e2.eval();
    }

    @Override
    public String print() {
        return "AddExpr(" + e1.print() + ", " + e2.print() + ")";
    }
}
