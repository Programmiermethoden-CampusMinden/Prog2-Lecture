package verify;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

public class VerifyFluppisListeTest {
    FluppisListe fluppisListe;

    @Before
    void setup() {
        fluppisListe = mock(FluppisListe.class);
        fluppisListe.add("Fluppi001");
    }

    @Test
    public void testVerifyGroesseVonFluppisListe() {
        fluppisListe.size();
        // Testet, ob die Groesse der Liste einmal überprüft wurde.
        verify(fluppisListe).size();
    }

    @Test
    public void testVerifyAnzahlDerInteraktionenMitFluppisListe() {
        fluppisListe.size();
        fluppisListe.size();
        fluppisListe.size();
        // Testet, ob die Groesse von fluppisListe 3-mal abgerufen wurde.
        verify(fluppisListe, times(3)).size();
    }

    @Test
    public void testVerifyObJemalsMitDemMockInteragiertWurde() {
        // Testet, ob jemals mit der gemockten Liste interagiert wurde.
        // (Dieser Test sollte fehlschlagen)
        verifyNoInteractions(fluppisListe);
    }

    @Test
    public void testVerifyObJemalsMitEinerBestimmtenMethodeInteragiertWurde() {
        // Testet, ob jemals die Methode get interagiert wurde.
        verify(fluppisListe, times(0)).get(0);
    }

    @Test
    public void testVerifyObNachEinemMethodenaufrufNochEinmalMitDemMockInteragiertWurde() {
        // Testet, ob nach dem spezifizierten Methodenaufruf noch auf eine
        // andere Art mit dem Mock interagiert wurde. (Dieser Test sollte
        // fehlschlagen)
        verify(fluppisListe).add("");
        verifyNoMoreInteractions(fluppisListe);
    }

    @Test
    public void testVerifyReihenfolgeDerInteraktionenMitDerFluppisListe() {
        // Testet, ob die Reihenfolge der spezifizierten Interaktionen
        // mit der Liste eingehalten wurde.
        fluppisListe.clear();
        InOrder reihenfolge = inOrder(fluppisListe);
        reihenfolge.verify(fluppisListe).add("Fluppi001");
        reihenfolge.verify(fluppisListe).clear();
    }

    @Test
    public void testVerifyDasKeineInteraktionMitDerListeStattgefundenHat() {
        // Testet, ob die spezifizierte Interaktion mit der Liste
        // nie stattgefunden hat.
        verify(fluppisListe, never()).clear();
    }

    @Test
    public void testVerifyDasMitDerListeZumindestXMalInteragiertWurde() {
        // Testet, ob mit der Liste mindestens die angegebene Anzahl an Malen
        // auf die spezifizierte Art interagiert wurde.
        fluppisListe.clear();
        verify(fluppisListe, atLeast(1)).clear();
    }

    @Test
    public void testVerifyDasMitDerListeHoechstensXMalInteragiertWurde() {
        // Testet, ob mit der Liste mindestens die angegebene Anzahl an Malen
        // auf die spezifizierte Art interagiert wurde.
        fluppisListe.clear();
        verify(fluppisListe, atMost(1)).clear();
    }

    @Test
    public void testVerifyObGenauWieAngegebenMitDerListeInteragiertWurde() {
        // Testet, ob exakt so wie angegeben mit FluppisListe interagiert wurde.
        verify(fluppisListe).add("Fluppi001");
    }

    @Test
    public void testVerifyFlexibleArgumenteBeimZugriffAufFluppisListe() {
        // Testet, ob schon jemals etwas zu der Liste hinzugefügt wurde.
        // Dabei ist es egal welcher String eingegeben wurde.
        verify(fluppisListe).add(anyString());
    }

    @Test
    public void testVerifyInteraktionenMitHilfeDesArgumentCaptor() {
        // Testet, welches Argument beim Methodenaufruf übergeben wurde.
        fluppisListe.addAll(Arrays.asList("BobDerBaumeister"));
        ArgumentCaptor<List> argumentMagnet = ArgumentCaptor.forClass(FluppisListe.class);
        verify(fluppisListe).addAll(argumentMagnet.capture());
        List<String> argumente = argumentMagnet.getValue();
        assertEquals("BobDerBaumeister", argumente.get(0));
    }
}
