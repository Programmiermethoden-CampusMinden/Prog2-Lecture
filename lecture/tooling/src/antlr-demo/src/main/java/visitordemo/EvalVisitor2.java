package visitordemo;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor2 extends MiniCalc2BaseVisitor<Integer> {

  // Symboltabelle: merkt sich Variablenwerte
  private final Map<String, Integer> memory = new HashMap<>();

  public Map<String, Integer> getMemory() {
    return memory;
  }

  /**
   * prog : stmt* EOF ;
   *
   * <p>Wir laufen einfach alle Statements durch, werten alle aus und geben den Wert des letzten
   * Statements zurück.
   */
  @Override
  public Integer visitProg(MiniCalc2Parser.ProgContext ctx) {
    Integer lastValue = null;
    for (MiniCalc2Parser.StmtContext stmtCtx : ctx.stmt()) lastValue = visit(stmtCtx);
    return lastValue;
  }

  /** stmt : ID '=' expr ';' | expr ';' */
  @Override
  public Integer visitStmt(MiniCalc2Parser.StmtContext ctx) {
    if (ctx.ID() != null) { // ID '=' expr ';'
      String name = ctx.ID().getText();
      Integer value = visit(ctx.expr());
      memory.put(name, value);
      return value;
    } else return visit(ctx.expr()); // expr ';'
  }

  /**
   * expr : INT ((PLUS | MINUS) INT)* ;
   *
   * <p>Achtung: INT ist hier ein Token, kein eigener Context.
   */
  @Override
  public Integer visitExpr(MiniCalc2Parser.ExprContext ctx) {
    // Erste Zahl ist immer da
    int value = Integer.parseInt(ctx.INT(0).getText());

    // Wir laufen über die Kinder: "op INT" ...
    for (int i = 1; i < ctx.getChildCount(); i += 2) {
      String op = ctx.getChild(i).getText(); // "+" oder "-"
      int n = Integer.parseInt(ctx.getChild(i + 1).getText());

      if (op.equals("+")) value += n;
      else value -= n;
    }

    return value;
  }
}
