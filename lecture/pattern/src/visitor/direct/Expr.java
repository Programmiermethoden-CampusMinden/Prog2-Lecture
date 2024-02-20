package visitor.direct;

/** Schnittstelle für einen Ausdruck */
public interface Expr {
    /** Werte den Ausdruck aus */
    int eval();

    /** Erzeuge eine String-Repräsentation des Ausdrucks */
    String print();
}
