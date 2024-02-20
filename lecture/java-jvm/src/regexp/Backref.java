package regexp;

/** Demo für Backreferences */
public class Backref {
    /** Starter - use the debugger */
    public static void main(String[] args) {
        boolean e;

        e = "1212".matches("(\\d\\d)\\1");
        e = "1223".matches("(\\d\\d)\\1");
        e = "1212".matches("(?<wuppi>\\d\\d)\\k<wuppi>");
    }
}
