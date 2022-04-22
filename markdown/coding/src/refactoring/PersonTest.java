package refactoring;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PersonTest {
    @Test
    public void testPerson() {
        Person p = new Person();

        assertNotNull(p);
    }
}
