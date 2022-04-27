package stub;

import java.util.Arrays;
import java.util.List;

/**
 * Da es noch kein funktionierendes Lager mit Wuppis gibt, wir aber trotzdem schon einmal unser
 * Kassensystem erstellen wollen mit denen dann alle Wuppis bestellt werden können erzeugen wir uns
 * einfach einen Stub des später einmal existierenden Warenlagers um die Funktionalität des Lagers
 * testen zu können.
 */
public class IWuppiWarenlagerStub implements IWuppiWarenlager {

    /**
     * Gibt eine Liste mit allen Wuppis zurück die im Warenlager bestellt werden können.
     *
     * @return Alle Wuppis in unserem Warenlager
     */
    public List<String> getAlleWuppis() {

        return Arrays.asList("GruenerWuppi", "RoterWuppi");
    }
}
