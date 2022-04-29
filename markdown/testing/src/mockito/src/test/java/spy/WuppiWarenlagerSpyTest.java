package spy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * Wir nutzen einen Spy für unser Warenlager und biegen einige der implementierten Methoden um,
 * damit wir die Interaktion besser testen können.
 */
public class WuppiWarenlagerSpyTest {
    // Erstellen eines realen Warenlagers.
    spy.WuppiWarenlager wuppiWarenlager;
    spy.Wuppi normalerWuppi;

    @Before
    public void setup() {
        // Spion erstellen, der unser wuppiWarenlager überwacht.
        this.wuppiWarenlager = spy(spy.WuppiWarenlager.class);

        // Erzeugen eines normalen Wuppi
        this.normalerWuppi = new spy.Wuppi("NormalerWuppi");
    }

    @Test
    public void testBestellungMitSpion() {
        // Wuppi dem Warenlager hinzufügen. Dieser Vorgang wird von unserem Spion beobachtet.
        wuppiWarenlager.addWuppi(normalerWuppi);

        // Wir können Methodenaufrufe an das reale Objekt abfangen und nach Belieben umformen.
        // Dabei sind beide hier gezeigten Methoden dafür equivalent nutzbar. Sie machen beide
        // dasselbe, verändern dabei aber nicht das reale Objekt.
        doReturn(Arrays.asList("Wuppi007")).when(wuppiWarenlager).getAlleWuppis();
        when(wuppiWarenlager.getAlleWuppis()).thenReturn(Arrays.asList(new Wuppi("Wuppi007")));

        // Hier können wir unseren Spion befragen, ob eine Interaktion mit der
        // Methode addWuppi mit dem realen Objekt stattgefunden hat.
        verify(wuppiWarenlager).addWuppi(normalerWuppi);

        // Hiermit überprüfen wir, ob nach dem initialen Aufruf von `addWuppi()` keine weitere
        // Interaktion mit dem realen Objekt wuppiWarenlagerSpy stattgefunden hat.
        verifyNoMoreInteractions(wuppiWarenlager);

        // Testen, ob auch wirklich nur ein Wuppi in dem echten Warenlager gelandet ist.
        assertEquals(1, wuppiWarenlager.lager.size());

        // Hier sehen wir, dass der Name des Wuppis der tatsächlich im
        // Warenlager gelandet ist, gar nicht der ist den wir ursprünglich
        // als Wuppi unserem realen Objekt hinzufügen wollten, weil der Spion
        // das Hinzufügen abgefangen und den Wuppi durch unseren WuppiAgenten
        // ersetzt hat. ("NormalerWuppi" vs. "Wuppi007")
        assertNotEquals(normalerWuppi.name, wuppiWarenlager.getAlleWuppis().get(0));
    }
}
