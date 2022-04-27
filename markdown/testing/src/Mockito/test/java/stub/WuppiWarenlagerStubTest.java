package stub;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unsere Testklasse die wir nutzen, um über unsere heißen Wuppistores alle Wuppis aus dem zuvor
 * erzeugten WuppiWarenlagerStub zu bestellen und diese funktionalität testen zu können, obwohl noch
 * gar kein richtiges Warenlager existiert.
 */
public class WuppiWarenlagerStubTest {
    @Test
    public void testBestellung() {

        // Wir nutzen kurzerhand einen Stub des eigentlich noch nicht
        // fertiggestellten Warenlagers, um schonmal die Funktionalität zu
        // testen.
        IWuppiWarenlager lager = new WuppiWarenlagerStub();

        // Unser neuer, brandheißer WuppiStore!
        WuppiStore wuppiStore = new WuppiStore(lager);

        // Bestelle alle Wuppis aus dem Lagerstub.
        List<String> bestellteWuppis = wuppiStore.bestelleAlleWuppis(lager);

        // Hat die Bestellung geklappt?
        assertEquals(2, bestellteWuppis.size());
    }
}
