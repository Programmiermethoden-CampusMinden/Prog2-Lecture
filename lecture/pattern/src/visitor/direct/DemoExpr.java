package visitor.direct;

/** Demo: Parsetree (OHNE Visitor-Pattern) */
public class DemoExpr {
    /** Just to please Checkstyle */
    public static void main(final String... args) {
        // 5*4+3
        Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));

        int erg = e.eval();
        String s = e.print();
    }
}
