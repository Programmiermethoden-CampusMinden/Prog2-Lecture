package challenges.regexp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Token {
    public final Pattern pattern;
    public final int matchingGroup;
    public final Color color;

    /**
     * @param pattern       Ein compilierter Pattern mit Ihrem regulären Ausdruck, mit dem ein Matcher für den gesamten Inputtext erzeugt wird.
     * @param matchingGroup Die aus dem regulären Ausdruck verwendete Match-Gruppe, die später gehighlighted werden soll.
     * @param color         Die für die Highlighting verwendete Farbe für jeden Match.
     */
    public Token(Pattern pattern, int matchingGroup, Color color) {
        this.pattern = pattern;
        this.matchingGroup = matchingGroup;
        this.color = color;
    }

    /**
     * @param s Der Inputtext.
     * @return Gibt eine Liste mit allen Matches zurück, die für diesen Token/regulären Ausdruck gefunden wurden.
     */
    public List<MyMatchResult> test(String s) {
        List<MyMatchResult> results = new ArrayList<>();
        Matcher mat = pattern.matcher(s);
        while (mat.find()) {
            results.add(new MyMatchResult(this, mat.toMatchResult()));
        }
        return results;
    }
}
