package challenges.regexp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class Lexer {
    private final List<Token> tokenizer = new ArrayList<>();

    public Lexer() {
        // Fügen Sie hier die einzelnen Token hinzu. Beispiel:
        // tokenizer.add(new Token(Pattern.compile("TODO"), 0, colors[0])); // einzeiliger Kommentar

        // TODO einzeiliger Kommentar
        // TODO mehrzeiliger Kommentar
        // TODO Java-Doc-Kommentar
        // TODO Strings
        // TODO CharacterContent

        // TODO KeyWords: package, import, class, public, private, final, return, null, new

        // TODO Annotation
    }

    public List<MyMatchResult> tokenize(String s) {
        List<MyMatchResult> results = new ArrayList<>();
        tokenizer.forEach(t -> results.addAll(t.test(s)));
        return results;
    }

    public static void main(String[] args) {
        LexerUI lexerUI = new LexerUI();
    }
}
