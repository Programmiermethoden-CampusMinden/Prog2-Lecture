package fhb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudiMockTest {
    Studi studi;
    LSF lsf;

    @Before
    public void setUp() {
        lsf = mock(LSF.class);
        studi = new Studi("Harald", lsf);
    }

    @Test
    public void testAnmelden() {
        when(lsf.anmelden(anyString(), anyString())).thenReturn(true);

        assertTrue(studi.anmelden("PM-Dungeon"));
    }

    @Test
    public void testEinsichtI() {
        when(lsf.ergebnis(anyString(), anyString())).thenReturn(80);

        assertTrue(studi.einsicht("PM-Dungeon"));
    }

    @Test
    public void testEinsichtII() {
        when(lsf.ergebnis(anyString(), anyString())).thenReturn(40);

        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
