package fhb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class VerifyTest {
    Studi studi;
    LSF lsf;

    @Before
    public void setUp() {
        lsf = mock(LSF.class);
        studi = new Studi("Harald", lsf);
    }

    @Test
    public void testAnmelden() {
        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

        assertTrue(studi.anmelden("PM-Dungeon"));

        verify(lsf).anmelden("Harald", "PM-Dungeon");
        verify(lsf, times(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, atLeast(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, atMost(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, never()).ergebnis("Harald", "PM-Dungeon");
        verifyNoMoreInteractions(lsf);
    }
}
