package visitor.visit.extrav;

import java.util.Stack;

/** Visitor für Pretty-Pring der Ausdrücke */
public class PrintVisitor implements ExprVisitor {
  private final Stack<String> erg = new Stack<>();

  @Override
  public void visit(NumExpr e) {
    erg.push("NumExpr(" + e.getValue() + ")");
  }

  @Override
  public void visit(MulExpr e) {
    // rechte Seite zuerst in den Stack, damit beim pop() als zweites Argument in die Operation
    // (hier nicht relevant, aber bei nicht-kommutativen Operationen wichtig)
    e.getE2().accept(this);
    e.getE1().accept(this);
    erg.push("MulExpr(" + erg.pop() + ", " + erg.pop() + ")");
  }

  @Override
  public void visit(AddExpr e) {
    e.getE2().accept(this);
    e.getE1().accept(this);
    erg.push("AddExpr(" + erg.pop() + ", " + erg.pop() + ")");
  }

  /** Liefere das Ergebnis zurück */
  public String getResult() {
    assert erg.size() == 1
        : "end of interpretation - there should be exactly one element in the stack";
    return erg.peek();
  }
}
