package junit5;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * Beispiel-Testsuite mit JUnit 5 (via JUnit 4 Support)
 *
 * Support für Testsuiten ala JUnit4 funktioniert noch nicht wirklich, vgl.
 * https://github.com/junit-team/junit5/issues/1334
 * https://github.com/junit-team/junit5/issues/744
 *
 * Das hier gezeigte Vorgehen dient vor allem dem Laden von alten JUnit4-Tests
 * aus JUnit5 heraus.
 *
 * Für das Gruppieren von Testfällen kann man in der Zwischenzeit auf das
 * Kennzeichnen mit @Tag("xyz") und das Filtern beim Ausführen nach Tags
 * zurückgreifen.
 *
 * Alternativ sollte das Ausführen (und Gruppieren) über den ConsoleRunner
 * funktionieren:
 * java -jar junit-platform-console-standalone-1.4.2.jar <Options>
 */

@RunWith(JUnitPlatform.class)
@SelectClasses({
        // Hier kommen alle Testklassen rein
        Test5.class,
        TestValueSource.class
})
public class MyTestSuite5 {
    // bleibt leer!!!
}
