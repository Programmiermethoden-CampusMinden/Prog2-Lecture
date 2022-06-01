package visitor.direct;

/** Einfachster Ausdruck: Ein (Integer-) Literal */
public class NumExpr implements Expr {
    private final int d;

    /** Erzeuge eine neue NumExpr-Instanz */
    public NumExpr(int d) {
        this.d = d;
    }

    @Override
    public int eval() {
        return d;
    }

    @Override
    public String print() {
        return "NumExpr(" + d + ")";
    }
}
