/**
 * Package fuer Code-Snippets in VL "Annotationen"
 */
package annotations;

import java.util.Date;

/**
 * Summary fuer Klasse B
 * <p>
 * <p>
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 *
 * @author Carsten Gips
 */

public class B extends A {

    /**
     * Kleines Testprogramm zur Demonstration von Annotationen
     *
     * @param args CLI-Parameter für main()
     */
    public static void main(String[] args) {
        B s = new B();

        System.out.println(s.getInfo());
        System.out.println(s.getInfo("Info: "));

        Date d; // Dummy zum schnellen Oeffnen von java.util.Date ... :)
    }

    /**
     * Methode ueberschreibt {@link A#getInfo()} und erweitert Parameter-String mit
     * Zeichenkette "Klasse B" ...
     * <p>
     * <p>
     * Es folgt die ausfuehrliche Beschreibung, die spaeter im Abschnitt "Method
     * Detail"
     * erscheint, aber nicht in der Uebersicht.
     *
     * @param s String, der verarbeitet werden soll
     * @return neuer String
     * @see A#getInfo()
     */
    // @Override
    public String getInfo(String s) {
        return s + "Klasse B";
    }

}
