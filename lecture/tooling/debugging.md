---
author: Carsten Gips (HSBI)
title: Debugging
---

::: tldr
TODO
:::

::: youtube
TODO
:::

# Java-Beispiel für die Debugging-Demo

Ziel: In der Demo sollen Studierende lernen,

1.  einen Crash (Exception) mit Stacktrace und Breakpoints zu analysieren und
2.  einen stillen Logikfehler mit Breakpoints, Steppen und Variablen-Inspektion
    aufzudecken.

``` java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class DebugDemo {

    public static void main(String[] args) {
        // Moderne Syntax: unveränderliche Liste
        List<Integer> numbers = List.of(2, 4, 6, 8, 10);

        int sum = sumEvenNumbers(numbers);
        System.out.println("Erwartete Summe: 30, berechnet: " + sum);

        int median = median(numbers);
        System.out.println("Erwarteter Median: 6, berechnet: " + median);
    }

    /**
     * Summiert alle geraden Zahlen in der Liste.
     * BUG: Die Schleife startet erst bei Index 1, Element mit Index 0 wird übersprungen.
     */
    static int sumEvenNumbers(List<Integer> numbers) {
        int sum = 0;
        // BUG: i startet bei 1, nicht bei 0
        for (int i = 1; i < numbers.size(); i++) {
            int n = numbers.get(i);
            if (n % 2 == 0) {
                sum += n;
            }
        }
        return sum;
    }

    /**
     * Berechnet den Median der Liste (vereinfachte Variante für ungerade Anzahl).
     * BUG: Es wird versucht, die unveränderliche List.of()-Liste zu sortieren.
     */
    static int median(List<Integer> numbers) {
        // BUG: numbers ist unveränderlich (List.of), sort führt zu UnsupportedOperationException
        Collections.sort(numbers);

        int middle = numbers.size() / 2;
        return numbers.get(middle);
    }
}
```

1.  Einen Crash (Exception + Stacktrace) zum Zeigen von:
    -   Stacktrace lesen
    -   Breakpoint in der Problem-Methode
    -   Call Stack im Debugger
    -   Schrittweises Ausführen (Step Over)
2.  Einen Logikfehler zum Zeigen von:
    -   Breakpoints in Schleifen
    -   Schrittweise Ausführung (Step Into, Step Over)
    -   Variablen-Werte beobachten (lokale Variablen, Watch/Expressions)
    -   ggf. bedingte Breakpoints (z.B. Bedingung auf `i`)

------------------------------------------------------------------------------------

# Ziele der Einheit

Nach dieser kurzen Einheit können Sie:

-   einen Fehler gezielt **reproduzieren**
-   eine **Exception** mit Hilfe des **Stacktraces** und des Debuggers analysieren
-   einen **Logikfehler** (falsches Ergebnis) mit Breakpoints und
    Schrittweise-Ausführung finden
-   die wichtigsten Debugger-Funktionen in Ihrer IDE benennen

# Warum Debuggen?

Typische Fehlerarten:

-   **Exceptions** (Programm bricht ab)
    -   z.B. `NullPointerException`, `IndexOutOfBoundsException`,
        `UnsupportedOperationException`
-   **Logikfehler**
    -   Programm läuft durch, Ergebnis ist aber falsch

Warum der Debugger besser ist als nur `System.out.println`:

-   Sie sehen **alle Variablenwerte** in einem Zustand
-   Sie können das Programm **Schritt für Schritt** ausführen
-   Sie sehen den **Call Stack** (Wer hat wen aufgerufen?)
-   Sie können komplexe Bedingungen setzen (z.B. **bedingte Breakpoints**)

# Die wichtigsten Debugger-Werkzeuge

Begriffe können je nach IDE (IntelliJ, Eclipse, VS Code, ...) leicht variieren.

-   **Breakpoint**
    -   Rotes Markierungssymbol an einer Codezeile
    -   Programm hält an dieser Stelle an
-   **Run / Debug**
    -   Programm im **Debug-Modus** starten (statt normalem Run)
-   **Step Over**
    -   Nächste Zeile ausführen, Methodenaufrufe werden "übersprungen"
-   **Step Into**
    -   In den aufgerufenen Methoden-Body hineinspringen
-   **Step Out**
    -   Aktuelle Methode bis zum Ende ausführen und zurück zur Aufrufer:in
-   **Variables / Watches**
    -   Aktuelle Werte von Variablen und Ausdrücken ansehen
-   **Call Stack**
    -   Liste der aktuell verschachtelten Methodenaufrufe

\[Hier Screenshot der Debug-Ansicht der IDE einfügen\]

# Standard-Vorgehen beim Debuggen

1.  **Fehler beobachten**
    -   Was genau passiert? Exception? Falsches Ergebnis?
2.  **Fehler reproduzierbar machen**
    -   Konkrete Eingaben / Szenario festlegen
3.  **Hypothese bilden**
    -   Was könnte im Code falsch laufen?
4.  **Breakpoint setzen**
    -   In einer relevanten Methode / vor einer verdächtigen Stelle
5.  **Im Debug-Modus starten**
    -   Programm läuft bis zum Breakpoint
6.  **Schrittweise ausführen & Variablen beobachten**
    -   `Step Over` / `Step Into`, Variablenfenster, ggf. Ausdrucksauswertung
7.  **Fehler lokalisieren und fixen**
    -   Code korrigieren, dann wieder bei Schritt 1 beginnen

## Demo 1: Exception beim Median (Crash)

Beispielmethode:

``` java
static int median(List<Integer> numbers) {
    Collections.sort(numbers);  // hier: UnsupportedOperationException
    int middle = numbers.size() / 2;
    return numbers.get(middle);
}
```

Situation:

-   `numbers` kommt aus `List.of(2, 4, 6, 8, 10);`
-   `List.of` liefert eine **unveränderliche** Liste
-   `Collections.sort(numbers)` versucht, die Liste zu ändern
-   -\> `java.lang.UnsupportedOperationException`

**Schritte in der Demo:**

1.  Programm normal ausführen -\> Absturz, Stacktrace ansehen
2.  Im Stacktrace die Zeile in `median` finden
3.  **Breakpoint** in `median` auf die Zeile mit `Collections.sort(...)` setzen
4.  Programm im **Debug-Modus** starten
5.  Im Debugger:
    -   Prüfen: Was ist der Typ von `numbers`?
    -   `Step Over` auf `Collections.sort(numbers);` -\> Exception tritt auf
    -   Call Stack ansehen (Wer hat `median` aufgerufen?)

**Anschließender Fix (live in der Demo):**

``` java
static int median(List<Integer> numbers) {
    // Kopie in eine veränderliche Liste
    List<Integer> copy = new ArrayList<>(numbers);
    Collections.sort(copy);

    int middle = copy.size() / 2;
    return copy.get(middle);
}
```

Dann Programm erneut im Debug-Modus starten und prüfen, ob der Crash behoben ist.

\[Hier 1-2 Screenshots: Stacktrace & Breakpoint in `median` einfügen\]

# Demo 2: Logikfehler bei der Summe (falsches Ergebnis)

Beispielmethode:

``` java
static int sumEvenNumbers(List<Integer> numbers) {
    int sum = 0;
    // BUG: Schleife startet bei 1, Element mit Index 0 (Wert 2) wird nie besucht
    for (int i = 1; i < numbers.size(); i++) {
        int n = numbers.get(i);
        if (n % 2 == 0) {
            sum += n;
        }
    }
    return sum;
}
```

Ausgabe in `main`:

``` java
int sum = sumEvenNumbers(numbers);
System.out.println("Erwartete Summe: 30, berechnet: " + sum);
```

Ergebnis: `Erwartete Summe: 30, berechnet: 28`

**Schritte in der Demo:**

1.  Breakpoint in der Zeile mit `int n = numbers.get(i);` (in der Schleife) setzen
2.  Programm im Debug-Modus starten
3.  Bei jedem Halt:
    -   `i`, `n` und `sum` im Variablenfenster beobachten
    -   Mit `Step Over` zur nächsten Zeile
4.  Fragen an die Studierenden:
    -   Welche Werte nimmt `i` an?
    -   Welche Elemente der Liste werden tatsächlich besucht?
    -   Warum wird die 2 (Index 0) nicht berücksichtigt?

**Fix (live in der Demo):**

``` java
for (int i = 0; i < numbers.size(); i++) {  // i startet jetzt bei 0
    int n = numbers.get(i);
    if (n % 2 == 0) {
        sum += n;
    }
}
```

Danach erneut im Debug-Modus ausführen und die Werte von `i`, `n` und `sum`
beobachten.

\[Hier Screenshot mit Variablenansicht und Breakpoint in der Schleife einfügen\]

# Tipps zum selbstständigen Üben

-   Probieren Sie in Ihrer IDE (z.B. IntelliJ, Eclipse, VS Code):
    -   Einen **Bedingten Breakpoint**
        -   z.B. in der Schleife von `sumEvenNumbers` nur halten, wenn `i == 0` oder
            `n > 5`
    -   Das **Ändern von Variablenwerten** im Debugger (wenn von der IDE
        unterstützt)
    -   Das **Auswerten von Ausdrücken** (Evaluate Expression)
-   Ersetzen Sie in `main` die Beispiel-Liste durch andere Daten:
    -   z.B. leere Liste, eine Liste mit nur einem Element, ungerade/gerade Anzahl
-   Ziel: Sie sollten das Gefühl haben, dass Sie den Debugger **aktiv steuern**
    können, statt nur "zuzuschauen".

# Wrap-Up

-   Debugger sind zentrale Werkzeuge für Informatik-Studierende und
    -Studierende:innen.
-   Wichtige Bausteine:
    -   Breakpoints, Step Over/Into/Out, Variablenansicht, Call Stack
-   Vorgehen:
    -   Fehler beobachten -\> reproduzieren -\> Hypothese -\> Breakpoint -\>
        schrittweise ausführen -\> fixen
-   Übungsidee:
    -   Nehmen Sie Ihren eigenen Code aus Übungen/Projekten und debuggen Sie bewusst
        ein paar Methoden, auch wenn (scheinbar) alles funktioniert.

::: readings
https://www.cs.cornell.edu/courses/cs4120/2019sp/ > Resources > Debugging

https://github.com/uds-se/debuggingbook
:::

::: outcomes
-   k2: Ich kann den Einsatz von Packages in Java erklären
:::

::: challenges
TODO
:::
