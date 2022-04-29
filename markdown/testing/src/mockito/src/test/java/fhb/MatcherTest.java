package fhb;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class MatcherTest {
    @Test
    public void testAnmelden() {
        LSF lsf = mock(LSF.class);
        Studi studi = new Studi("Harald", lsf);

        when(lsf.anmelden(anyString(), anyString())).thenReturn(false);
        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

        assertTrue(studi.anmelden("PM-Dungeon"));
        assertFalse(studi.anmelden("Wuppie?"));

        verify(lsf, times(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, times(1)).anmelden("Harald", "Wuppie?");

        verify(lsf, times(2)).anmelden(anyString(), anyString());

        // verify(lsf) is really verify(lsf, times(1)) ...
//        verify(lsf).anmelden(argThat(new MyHaraldMatcher()), anyString());
        verify(lsf, atLeastOnce()).anmelden(argThat(new MyHaraldMatcher()), anyString());
    }


    class MyHaraldMatcher implements ArgumentMatcher<String> {
        public boolean matches(String s) {
            return s.equals("Harald");
        }

        public String toString() {
            return "found Harald";
        }
    }
}
