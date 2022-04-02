Testen Sie die Methoden `nonEvilAdd`, `evilAdd` und `veryEvilAdd` der Klasse
`Utility.java` mit dem JUnit- und dem Mockito-Framework.

Vervollständigen Sie dazu die vorgegebene Klasse `UtilityTest.java`. Die Klassen
`Evil.java` und `Utility.java` dürfen Sie nicht ändern. Nutzen Sie Mocking mit
der Mockito-Bibliothek, um die Tests zum Laufen zu bringen. Die Tests dürfen Sie
verändern, aber die Aufrufe müssen erhalten bleiben.

*   `Evil.java`:

    ```java
    public class Evil {
        public void evilMethod() {
            throw new RuntimeException("bam! bam!");
        }
    }
    ```

*   `Utility.java`:

    ```java
    public class Utility {
        private int intResult = 0;
        private Evil evilClass;

        public Utility(Evil evilClass) {
            this.evilClass = evilClass;
        }

        public void evilMethod() {
            throw new RuntimeException("bam!");
        }

        public int nonEvilAdd(int a, int b) {
            return a + b;
        }

        public int evilAdd(int a, int b) {
            evilClass.evilMethod();
            return a + b;
        }

        public void veryEvilAdd(int a, int b) {
            evilMethod();
            evilClass.evilMethod();
            intResult = a + b;
        }

        public int getIntResult() {
            return intResult;
        }
    }
    ```

*   `UtilityTest.java`:

    ```java
    // Ergänzen Sie UtilityTest so, dass alle Testmethoden grün werden.
    // Die vorgegebenen Klassen dürfen nicht geändert werden.
    // Die Testaufrufe müssen auch erhalten bleiben.
    public class UtilityTest {
        private Utility utilityClass;
        // Initialisieren Sie die Attribute entsprechend vor jedem Test.

        @Test
        void test_nonEvilAdd() {
            Assertions.assertEquals(10, utilityClass.nonEvilAdd(9, 1));
        }

        @Test
        void test_evilAdd() {
            Assertions.assertEquals(10, utilityClass.evilAdd(9, 1));
        }

        @Test
        void test_veryEvilAdd() {
            utilityClass.veryEvilAdd(9, 1);
            Assertions.assertEquals(10, utilityClass.getIntResult());
        }
    }
    ```
