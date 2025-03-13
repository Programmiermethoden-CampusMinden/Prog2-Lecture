package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Demo für Pattern und Matcher */
public class MatchFind {
    /** Starter - use the debugger */
    public static void main(String[] args) {
        boolean e;

        Pattern p = Pattern.compile("Hello");

        Matcher m = p.matcher("Hello World");
        e = m.find();
        e = m.matches();

        m = p.matcher("Hello");
        e = m.find();
        e = m.matches();
    }
}
