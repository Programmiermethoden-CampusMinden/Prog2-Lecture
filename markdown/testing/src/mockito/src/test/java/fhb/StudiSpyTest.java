package fhb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class StudiSpyTest {
    Studi studi;
    LSF lsf;

    @Before
    public void setUp() {
        lsf = spy(LSF.class);
        studi = new Studi("Harald", lsf);
    }

    @Test
    public void testAnmelden() {
        // nutze die normale Methode LSF#anmelden()
        // Hinweis: Wird fehlschlagen, da diese Methode hier doch noch nicht implementiert ist
        assertTrue(studi.anmelden("PM-Dungeon"));
    }

    @Test
    public void testEinsichtI() {
        // nutze einen eigenen Rückgabewert beim Aufruf der Methode LSF#ergebnis()
        doReturn(80).when(lsf).ergebnis("Harald", "PM-Dungeon");

        assertTrue(studi.einsicht("PM-Dungeon"));
    }

    @Test
    public void testEinsichtII() {
        // nutze einen eigenen Rückgabewert beim Aufruf der Methode LSF#ergebnis()
        doReturn(40).when(lsf).ergebnis("Harald", "PM-Dungeon");

        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
