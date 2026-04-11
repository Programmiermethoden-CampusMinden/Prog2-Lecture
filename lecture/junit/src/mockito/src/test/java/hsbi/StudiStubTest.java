package hsbi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StudiStubTest {
    Studi studi;
    LSF lsf;

    @Before
    public void setUp() {
        lsf = new LsfStub();
        studi = new Studi("Harald", lsf);
    }

    @Test
    public void testAnmelden() {
        assertTrue(studi.anmelden("PM-Dungeon"));
    }

    @Test
    public void testEinsicht() {
        assertTrue(studi.einsicht("PM-Dungeon"));
    }

    // Stub für das noch nicht fertige LSF
    class LsfStub extends LSF {
        public boolean anmelden(String name, String modul) {
            return true;
        }

        public int ergebnis(String name, String modul) {
            return 80;
        }
    }
}
