Schreiben Sie eine JUnit-Testklasse (JUnit 4.x oder 5.x) und testen Sie eine
`ArrayList<String>`. Prüfen Sie dabei, ob das Einfügen und Entfernen wie
erwartet funktioniert.

2.  Fügen Sie eine `setUp()`- und `tearDown()`-Methode zu Ihrer Testklasse hinzu.
    Die `setUp()`-Methode muss vor jedem Testfall ausgeführt werden, die
    `tearDown()`-Methode muss nach jedem Testfall ausgeführt werden.

3.  Initialisieren Sie in der `setUp()`-Methode die Liste und fügen Sie zwei
    Elemente ein. Stellen Sie mit einer passenden `assume*`-Methode sicher,
    dass die Liste genau diese beiden Elemente enthält.

4.  Setzen Sie in der `tearDown()`-Methode die Liste wieder auf `null` und
    stellen Sie mit einer passenden `assume*`-Methode sicher, dass die Liste
    tatsächlich `null` ist.

5.  Schreiben Sie die Testmethode `test_add()`, fügen Sie darin ein weiteres
    Element hinzu und prüfen Sie mit einer passenden `assert*`-Methode, ob die
    Liste nach dem Einfügen den gewünschten Zustand hat: Die Länge der Liste
    muss 3 Elemente betragen und alle Elemente müssen in der richtigen Reihenfolge
    in der Liste stehen.

6.  Schreiben Sie die Testmethode `test_remove_object()`, entfernen Sie darin
    ein vorhandenes Element (über die Referenz auf das Objekt) und prüfen Sie
    mit einer passenden `assert*`-Methode, ob die Liste nach dem Entfernen den
    gewünschten Zustand hat: Die Liste darf nur noch das verbleibende Element
    enthalten.

7.  Schreiben Sie die Testmethode `test_remove_index()`, entfernen Sie darin ein
    vorhandenes Element über dessen Index und prüfen Sie mit einer passenden
    `assert*`-Methode, ob die Liste nach dem Entfernen den gewünschten Zustand
    hat: Die Liste darf nur noch das verbleibende Element enthalten. (Nutzen Sie
    zum Entfernen die `remove(int)`-Methode der Liste.)

8.  Schreiben Sie zusätzlich einen **parametrisierten JUnit-Test**. Testen Sie
    darin die einzige Methode der folgenden Klasse:

    ```java
    import java.util.ArrayList;

    public class SpecialArrayList extends ArrayList<String> {
        public void concatAddStrings(String a, String b) {
            this.add(a + b);
        }
    }
    ```

    Testen Sie, ob die Methode `concatAddStrings` der Klasse `SpecialArrayList`
    die beiden übergebenen Strings korrekt konkateniert und das Ergebnis in die
    Liste einfügt. Testen Sie dabei mit mindestens den folgenden Parameter-Tripeln:

    |   a   |   b   | expected |
    |:-----:|:-----:|:--------:|
    |  ""   |  ""   |    ""    |
    |  ""   |  "a"  |   "a"    |
    |  "a"  |  ""   |   "a"    |
    | "abc" | "123" | "abc123" |
