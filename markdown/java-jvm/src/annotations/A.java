/**
 * Package fuer Code-Snippets in VL "Annotationen"
 */
package annotations;

/**
 * Summary fuer Klasse A
 * <p>
 * <p>
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 *
 * @author Carsten Gips
 */

public class A {

    /**
     * Ein kurzer Satz, der im Abschnitt "Method Summary" stehen wird.
     * <p>
     * <p>
     * Es folgt die ausfuehrliche Beschreibung, die spaeter im Abschnitt
     * "Method Detail" erscheint, aber nicht in der Uebersicht.
     *
     * @deprecated As of wuppie fluppy, replaced by {@link #wuppiefluppie()}.
     */
    // @Deprecated
    public String getInfo() {
        return "Klasse A";
    }

    /**
     * Demo fuer Link-Ziel fuer Javadoc ... :)
     */
    public void wuppiefluppie() {
    }
}
