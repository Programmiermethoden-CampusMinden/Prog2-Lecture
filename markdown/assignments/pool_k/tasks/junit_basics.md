### JUnit-Basics

- Schreiben Sie eine JUnit Testklasse (JUnit 4.x oder 5.x) und testen Sie eine `ArrayList<String>`. Prüfen Sie dabei, ob das Einfügen und Entfernen wie erwartet funktioniert.

- Deklarieren Sie in der Testklasse ein Attribut für die zu testende Liste (`ArrayList<String>`) und Attribute für die Elemente (`String`), die eingefügt und geprüft werden sollen.

- Fügen Sie eine `init()`- und `tearDown()`-Methode hinzu. Die `init()`-Methode muss vor jedem Testfall ausgeführt werden, die `tearDown()`-Methode muss nach jedem Testfall ausgeführt werden.

- Initialisieren Sie in der `init()`-Methode die Liste und fügen Sie zwei Elemente ein. Stellen Sie mit `assume...` sicher, dass die Liste genau die zwei Elemente enthält.

- Setzen Sie in der `tearDown()`-Methode die Liste auf `null` und stellen Sie mit `assume...` sicher, dass die Liste tatsächlich wieder `null` ist.

- Schreiben Sie die Testmethode `test_add()`, fügen Sie darin ein weiteres Element hinzu und stellen Sie mit `assert...` sicher, dass die Liste nach dem Einfügen den gewünschten Zustand hat, das heißt, dass die Länge der Liste `3` beträgt und alle Elemente in der richtigen Reihenfolge eingefügt wurden.

- Schreiben Sie die Testmethode `test_remove_object()`, entfernen Sie darin ein vorhandenes Element und stellen Sie mit `assert...` sicher, dass die Liste nach dem Entfernen den gewünschten Zustand hat, das heißt, dass die Liste nur ein Element enthält.

- Schreiben Sie die Testmethode `test_remove_index()`, entfernen Sie darin ein vorhandenes Element und stellen Sie mit `assert...` sicher, dass die Liste nach dem Entfernen den gewünschten Zustand hat, das heißt, dass die Liste nur ein Element enthält. Nutzen Sie zum Entfernen die `remove(int)`-Methode der Liste.

- Schreiben Sie zusätzlich einen **parametrisierten JUnit-Test**. Testen Sie dafür die einzige Methode der folgenden Klasse:

```
import java.util.ArrayList;

public class SpecialArrayList extends ArrayList<String> {
    public void concatAddStrings(String a, String b) {
        this.add(a + b);
    }
}
```

- Testen Sie, ob die Methode `concatAddStrings` der Klasse `SpecialArrayList` zwei übergebene Strings konkateniert und in die Liste einfügt; das heißt, dass die Liste nur ein Element enthält und dieses Element dem erwarteten Parameter entspricht. Testen Sie dabei mit mindestens den folgenden Parameter-Tripeln:

| a     | b     | expected |
| ----- | ----- | -------- |
| ""    | ""    | ""       |
| ""    | "a"   | "a"      |
| "a"   | ""    | "a"      |
| "abc" | "123" | "abc123" |
