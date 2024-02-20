package junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Beispiel-Testsuite mit JUnit 4
 */

@RunWith(Suite.class)
@SuiteClasses({
        // Hier kommen alle Testklassen rein
        Test4.class,
        SumTestConstructor.class
})

public class MyTestSuite4 {
    // bleibt leer!!!
}
