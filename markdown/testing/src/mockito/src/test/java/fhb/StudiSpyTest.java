package fhb;

import org.junit.Before;
import org.junit.Test;
import wuppie.spy.WuppiWarenlager;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class StudiSpyTest {
    Studi studi;
    LSF lsf;

    @Before
    public void setUp() {
        lsf = spy(LSF.class);
        studi = new Studi("Harald", lsf);
    }

    @Test
    public void anmelden() {
        // nutze die normale Methode LSF#anmelden()
        // Hinweis: Wird fehlschlagen, da diese Methode hier doch noch nicht implementiert ist
        assertTrue(studi.anmelden("PM-Dungeon"));
    }

    @Test
    public void klausurEinsichtI() {
        // nutze einen eigenen Rückgabewert beim Aufruf der Methode LSF#ergebnis()
        doReturn(80).when(lsf).ergebnis(anyString(), anyString());

        assertTrue(studi.klausurEinsicht("PM-Dungeon"));
    }

    @Test
    public void klausurEinsichtII() {
        // nutze einen eigenen Rückgabewert beim Aufruf der Methode LSF#ergebnis()
        doReturn(40).when(lsf).ergebnis(anyString(), anyString());

        assertFalse(studi.klausurEinsicht("PM-Dungeon"));
    }
}
