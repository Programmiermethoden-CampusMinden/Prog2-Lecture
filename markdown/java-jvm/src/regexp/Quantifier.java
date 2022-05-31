package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Demo für Quantifier */
public class Quantifier {
    /** Starter - use the debugger */
    public static void main(String[] args) {
        Pattern p = Pattern.compile("A.*A");
        // Pattern p = Pattern.compile("A.*?A");
        Matcher m = p.matcher("A 12 A 45 A");

        if (m.matches()) {
            // if (m.find()) {
            m.group(); // Text
            m.start(); // Startposition
            m.end(); // Endposition
        }
    }
}
