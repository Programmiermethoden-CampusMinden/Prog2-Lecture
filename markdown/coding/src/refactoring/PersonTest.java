package refactoring;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeTrue;

public class PersonTest {
    @Test
    public void testPerson() {
        Person p = new Person();

        assertNotNull(p);
    }
}
