package visitor.visit.intrav;

import java.util.Stack;

/** Visitor zum Berechnen der Ausdrücke */
public class EvalVisitor implements ExprVisitor {
  private final Stack<Integer> erg = new Stack<>();

  @Override
  public void visit(NumExpr e) {
    erg.push(e.getValue());
  }

  @Override
  public void visit(MulExpr e) {
    erg.push(erg.pop() * erg.pop());
  }

  @Override
  public void visit(AddExpr e) {
    erg.push(erg.pop() + erg.pop());
  }

  /** Liefere das Ergebnis zurück */
  public int getResult() {
    assert erg.size() == 1
        : "end of interpretation - there should be exactly one element in the stack";
    return erg.peek();
  }
}
