package visitordemo;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
  void main() {
    String text = "a = 1 + 2;";

    // show all token
    System.out.printf("Token for '%s':\n", text);
    dumpToken(text);

    // show parse tree
    System.out.printf("\nParse tree for '%s':\n", text);
    printParseTree(text);

    // visit parse tree
    System.out.printf("\nVisit parse tree for '%s':\n", text);
    visitParseTree(text);
  }

  private static void dumpToken(String text) {
    var input = CharStreams.fromString(text);
    var lexer = new MiniCalcLexer(input);
    var tokens = new CommonTokenStream(lexer);

    tokens.fill(); // fill stream (fetch all tokens from lexer)

    for (var t : tokens.getTokens()) {
      var tokenName = MiniCalcLexer.VOCABULARY.getSymbolicName(t.getType());
      System.out.printf(
          "%-10s line=%d col=%d text='%s'%n",
          tokenName, t.getLine(), t.getCharPositionInLine(), t.getText());
    }
  }

  private static void printParseTree(String text) {
    var input = CharStreams.fromString(text);
    var lexer = new MiniCalcLexer(input);
    var tokens = new CommonTokenStream(lexer);

    var parser = new MiniCalcParser(tokens);
    var tree = parser.prog(); // Wurzelknoten des Baums (Startregel der Grammatik)

    IO.println(tree.toStringTree(parser));
  }

  private static void visitParseTree(String text) {
    var input = CharStreams.fromString(text);
    var lexer = new MiniCalcLexer(input);
    var tokens = new CommonTokenStream(lexer);
    var parser = new MiniCalcParser(tokens);

    MiniCalcParser.ProgContext tree =
        parser.prog(); // Wurzelknoten des Baums (Startregel der Grammatik)

    var eval = new EvalVisitor();
    var result = eval.visit(tree);

    IO.println("Ergebnis des Programms: " + result);
    IO.println("Umgebung: " + eval.getMemory());
  }
}
