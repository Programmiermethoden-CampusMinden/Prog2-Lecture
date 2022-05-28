package regexp;

/** Demo für String.split() */
public class StringSplit {
    /** Starter - use the debugger */
    public static void main(String[] args) {
        String a = "boo:and:foo";
        String[] e;
        boolean b;

        e = a.split(":");
        e = a.split("o");
        e = a.split("b");

        b = a.matches(" ");
        b = a.matches("boo:and:foo");
        b = a.matches("boo");
    }
}
