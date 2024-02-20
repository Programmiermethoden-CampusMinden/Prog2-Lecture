package visitor.visit.extrav;

/** Schnittstelle für den Visitor */
public interface ExprVisitor {
    /** Besuche Knoten vom Typ NumExpr */
    void visit(NumExpr e);

    /** Besuche Knoten vom Typ MulExpr */
    void visit(MulExpr e);

    /** Besuche Knoten vom Typ AddExpr */
    void visit(AddExpr e);
}
