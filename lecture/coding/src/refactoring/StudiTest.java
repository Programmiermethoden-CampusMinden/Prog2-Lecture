package refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudiTest {
    @Test
    public void testStudi() {
        Kurs k = new Kurs("myKurs", 9);
        Studi s = new Studi("Werner", 3, k);

        assertEquals("Werner", s.n);
        assertEquals(3, s.c);
        assertEquals(k, s.k);
    }

    @Test
    public void testChangeNme() {
        Kurs k = new Kurs("myKurs", 9);
        Studi s = new Studi("Werner", 3, k);

        assertEquals("Werner", s.n);

        s.n = "Heini";
        assertEquals("Heini", s.n);
        assertEquals(3, s.c);
        assertEquals(k, s.k);
    }

    @Test
    public void testPrtIf() {
        Kurs k = new Kurs("myKurs", 9);
        Studi s = new Studi("Werner", 3, k);
    }
}
