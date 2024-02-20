package cli;

/** Teaser für die Slides */
public class Teaser {
    /** Hier gibt's nix zu sehen, gehen Sie weiter :) */
    public static void main(String[] args) {
        int x = 100;
        String answer = "";
        boolean debug = false;

        // Parameter: -x=10 -answer=hello -debug
        // => args = ["-x=10", "-answer=hello", "-debug"]
        for (String param : args) {
            if (param.startsWith("-x")) { x = Integer.parseInt(param.substring(3)); }
            if (param.startsWith("-a")) { answer = param.substring(8); }
            if (param.startsWith("-d")) { debug = true; }
        }
    }
}
