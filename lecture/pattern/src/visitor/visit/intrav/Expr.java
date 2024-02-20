package visitor.visit.intrav;

/** Schnittstelle für einen Ausdruck */
public interface Expr {
    /** Akzeptiere einen Visitor für die Verarbeitung */
    void accept(ExprVisitor v);
}
