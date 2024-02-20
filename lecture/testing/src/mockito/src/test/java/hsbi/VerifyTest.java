package hsbi;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class VerifyTest {
    @Test
    public void testAnmelden() {
        LSF lsf = mock(LSF.class);
        Studi studi = new Studi("Harald", lsf);

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
