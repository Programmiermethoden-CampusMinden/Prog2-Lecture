package spy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * Unsere Testklasse die wir nutzen, um über unsere heißen Wuppistores alle Wuppis aus dem zuvor
 * erzeugten WuppiWarenlagerStub zu bestellen und diese funktionalität testen zu können, obwohl noch
 * gar kein richtiges Warenlager existiert. Aber dieses Mal nutzen wir dafür ein gemocktes Objekt
 * der klasse IWuppiWarenlager.
 */
public class WuppiWarenlagerSpyTest {
    // Erstellen eines realen Warenlagers.
    WuppiWarenlager wuppiWarenlager;
    Wuppi normalerWuppi;

    @Before
    void setup() {
        // Spion erstellen der unser wuppiWarenlager überwacht.
        this.wuppiWarenlager = spy(WuppiWarenlager.class);

        // Erzeugen eines normalen Wuppi
        this.normalerWuppi = new Wuppi("NormalerWuppi");
    }

    @Test
    public void testBestellungMitSpion() {
        // Wuppi dem Warenlager hinzufügen. Dieser Vorgang von unserem Spion
        // beobachtet.
        wuppiWarenlager.addWuppi(normalerWuppi);

        // Wir können Methodenaufrufe an das reale Objekt abfangen und
        // nach Belieben umformen. Dabei sind beide hier gezeigten Methoden
        // dafür equivalent nutzbar. Sie machen beide dasselbe, verändern
        // dabei aber nicht das reale Objekt.
        doReturn(Arrays.asList("Wuppi007")).when(wuppiWarenlager).getAlleWuppis();
        when(wuppiWarenlager.getAlleWuppis()).thenReturn(Arrays.asList(new Wuppi("Wuppi007")));

        // hier können wir unseren Spion befragen, ob eine Interaktion mit der
        // Methode addWuppi mit dem realen Objekt stattgefunden hat.
        verify(wuppiWarenlager).addWuppi(normalerWuppi);

        // hiermit überprüfen wir, ob nach dem initialen Aufruf von `addWuppi()` keine weitere
        // Interaktion mit dem realen Objekt wuppiWarenlagerSpy stattgefunden
        // hat.
        verifyNoMoreInteractions(wuppiWarenlager);

        // Testen ob auch wirklich nur ein Wuppi in dem echten Warenlager
        // gelandet ist.
        assertEquals(1, wuppiWarenlager.lager.size());

        // Hier Sehen wir, dass der Name des Wuppis der tatsächlich im
        // Warenlager gelandet ist, gar nicht der ist den wir ursprünglich
        // als Wuppi unserem realen Objekt hinzufügen wollten, weil der Spion
        // das hinzufügen abgefangen und den Wuppi durch unseren WuppiAgenten
        // ersetzt hat. ("NormalerWuppi" vs. "Wuppi007")
        assertNotEquals(normalerWuppi.name, wuppiWarenlager.getAlleWuppis().get(0));
    }
}
