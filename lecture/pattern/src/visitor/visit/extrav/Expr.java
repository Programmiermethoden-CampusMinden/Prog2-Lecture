package visitor.visit.extrav;

/** Schnittstelle für einen Ausdruck */
public interface Expr {
    /** Akzeptiere einen Visitor für die Verarbeitung */
    void accept(ExprVisitor v);
}
