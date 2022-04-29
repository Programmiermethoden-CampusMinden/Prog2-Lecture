package stub;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

/**
 * Unsere Testklasse, die wir nutzen, um über unsere heißen Wuppistores alle Wuppis aus dem zuvor
 * erzeugten WuppiWarenlagerStub zu bestellen und diese Funktionalität testen zu können, obwohl noch
 * gar kein richtiges Warenlager existiert.
 */
public class WuppiWarenlagerStubTest {
    @Test
    public void testBestellungMitStub() {

        // Wir nutzen kurzerhand einen Stub des eigentlich noch nicht
        // fertiggestellten Warenlagers, um schon mal die Funktionalität zu testen.
        stub.IWuppiWarenlager lager = new stub.WuppiWarenlagerStub();

        // Unser neuer, brandheißer WuppiStore!
        stub.WuppiStore wuppiStore = new stub.WuppiStore(lager);

        // Bestelle alle Wuppis aus dem Lagerstub.
        List<String> bestellteWuppis = wuppiStore.bestelleAlleWuppis(lager);

        // Hat die Bestellung geklappt?
        assertEquals(2, bestellteWuppis.size());
    }
}
