package mock;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unsere Testklasse die wir nutzen, um über unsere heißen Wuppistores alle Wuppis aus dem zuvor
 * erzeugten WuppiWarenlagerStub zu bestellen und diese funktionalität testen zu können, obwohl noch
 * gar kein richtiges Warenlager existiert. Aber dieses Mal nutzen wir dafür ein gemocktes Objekt
 * der klasse IWuppiWarenlager.
 */
public class WuppiWarenlagerMockTest {

    @Test
    public void testBestellungMitMock() {
        // Erstellen des Mocks
        IWuppiWarenlager lager = mock(IWuppiWarenlager.class);

        // Erstellen eines imaginären Lagerbestands.
        List<String> wuppisImLager = Arrays.asList("GruenerWuppi", "RoterWuppi");

        // Wenn Methoden des zuvor gemockten Objektes genutzt werden kann man
        // dies in Mockito nun überprüfen und darauf reagieren.
        when(lager.getAlleWuppis()).thenReturn(wuppisImLager);

        // Erzeugen des WuppiStores.
        WuppiStore wuppiStore = new WuppiStore(lager);

        // Bestelle alle Wuppis aus dem gemockten Lager.
        List<String> bestellteWuppis = wuppiStore.bestelleAlleWuppis(lager);

        // Hat die Bestellung geklappt?
        assertEquals(2, bestellteWuppis.size());
    }
}
