# JUnit4: Property based Testing & Approval Testing

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Approval Testing hilft Ihnen, komplexe Ausgaben wie Reports, HTML oder
> JSON praktikabel zu testen. Statt im Test einen riesigen
> `expected`-String manuell zusammenzubauen und zu pflegen, frieren Sie
> einmal einen geprüften Output als "approved" (in einer Textdatei) ein
> und lassen künftige Testläufe automatisch dagegen vergleichen.
> Änderungen sehen Sie als Diff im Repository und können bewusst
> entscheiden, ob das Verhalten gewollt angepasst wurde oder ein Fehler
> vorliegt - ideal auch als Sicherheitsnetz vor und nach Refactorings.
>
> Property-Based Testing (PTB) ergänzt klassische Beispieltests, indem
> es allgemeine Eigenschaften ("Für alle Eingaben aus diesem Bereich
> muss X gelten") über viele automatisch generierte Eingaben prüft. Die
> Äquivalenzklassenanalyse dient dabei als zentrales Denkwerkzeug: Sie
> strukturieren damit den Eingaberaum und formulieren daraus Properties
> für jqwik.
>
> Während die Idee von Approval Testing sehr überschaubar ist, können
> wir nur einen allerersten Blick in das Thema Property-Based Testing
> werfen.
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> Vorlesung \[[YT](https://youtu.be/vuvnmz58fIU)\],
> \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-junit4-property-based-testing-approval-testing/6f97fdeb6ff90c7de8b5c6488baaf270)\]
>
> </details>

## Motivation: Mehr als nur Beispieltests

-   Bisher: klassische Unit-Tests mit JUnit (`@Test`, `assertEquals`,
    ...)
-   Problem 1: Komplexe/umfangreiche Outputs sind schwer "per Hand" zu
    vergleichen
-   Problem 2: Einzelne Beispieltests decken nur wenige Eingaben ab

<!-- -->

-   Idee: Zwei Ergänzungen
    -   Approval Testing
    -   Property-Based Testing (PBT)

In klassischen Tests formulieren wir für ein paar ausgewählte Beispiele
"Eingabe X -\> erwartete Ausgabe Y". Das ist gut für Dokumentation und
einfache Funktionen, stößt aber an Grenzen, wenn Outputs lang/komplex
sind oder wenn wir viele verschiedene Eingaben testen wollen. Approval
Testing hilft beim Umgang mit komplexen Ausgaben, Property-Based Testing
beim automatisierten Durchprobieren vieler Eingaben anhand allgemeiner
Eigenschaften.

## Approval Testing: Idee und Einsatzgebiete

``` java
@Test
void report_looks_as_expected() {
    // given
    List<Order> orders = List.of(...); // !!!!
    String expected = "..."; // ???!

    // when
    String report = OrderReportGenerator.generateReport(orders);

    // then
    assertEquals(expected, report);
}
```

-   Grundidee:
    -   Einmal gültigen Output als "Goldstandard" abspeichern
        (`approved`)
    -   Zukünftig generierten Output automatisch dagegen vergleichen

<!-- -->

-   Gut geeignet für:
    -   Reports, Tabellen, formatierten Text
    -   HTML, JSON, Logs, Konsolen-Output
-   Typischer Einsatz:
    -   Refactoring ohne Verhaltensänderung absichern

Beim Approval Testing wird nicht im Test ein erwarteter String
**manuell** zusammengebaut. Stattdessen **prüft man einmalig einen
generierten Output**, "segnet ihn ab" und speichert ihn als "approved"
in einem String oder einer Datei. Künftige Testläufe erzeugen einen
"received"-Output und vergleichen ihn mit der "approved"-Version.
Unterschiede fallen als Diffs auf. Besonders beim Refactoring ist das
hilfreich: Wenn sich der Output nicht ändert, war das Refactoring
verhaltensgleich.

## Beispiel: Order-Report mit manuellen Approval-Tests

Produktionscode: Textreport aus Bestellungen erzeugen:

``` java
public record Order(String id, String customer, List<String> items) {}

public class OrderReportGenerator {
    public static String generateReport(List<Order> orders) {
        var sb = new StringBuilder();
        sb.append("=== ORDER REPORT ===\n");
        orders.forEach( o -> {
                sb.append("Order: ").append(o.id()).append("\n");
                sb.append("Customer: ").append(o.customer()).append("\n");
                sb.append("Items:\n");
                o.items().forEach(item -> sb.append(" - ").append(item).append("\n"));
                sb.append("\n");
            });
        sb.append("Total orders: ").append(orders.size()).append("\n");
        return sb.toString();
    }
}
```

Approval-Test:

1.  Test laufen lassen und Vergleich mit leerem String -\> rot
2.  Ausgabe von JUnit prüfen und als Erwartung übernehmen -\> grün

------------------------------------------------------------------------

Erster Lauf mit leerem "expected"-String:

``` java
class OrderReportGeneratorTest {

    @Test
    void report_looks_as_expected() {
        // given
        List<Order> orders = List.of(
                    new Order("A-001", "Alice", List.of("Keyboard", "Mouse")),
                    new Order("B-002", "Bob", List.of("Laptop")),
                    new Order("C-003", "Charlie", List.of("HDMI Cable", "USB Hub")));
        // 1. Test absichtlich fehlschlagen lassen, 2. Ausgabe übernehmen
        String expected = "..."; // ???!

        // when
        String report = OrderReportGenerator.generateReport(orders);

        // then
        assertEquals(expected, report);
    }
}
```

------------------------------------------------------------------------

Nach dem ersten Lauf Ergänzen des "expected"-Strings zu:

``` java
class OrderReportGeneratorTest {

    @Test
    void report_looks_as_expected() {
        // given
        List<Order> orders = List.of(
                    new Order("A-001", "Alice", List.of("Keyboard", "Mouse")),
                    new Order("B-002", "Bob", List.of("Laptop")),
                    new Order("C-003", "Charlie", List.of("HDMI Cable", "USB Hub")));
        String expected = """
            === ORDER REPORT ===
            Order: A-001
            Customer: Alice
            Items:
             - Keyboard
             - Mouse

            Order: B-002
            Customer: Bob
            Items:
             - Laptop

            Order: C-003
            Customer: Charlie
            Items:
             - HDMI Cable
             - USB Hub

            Total orders: 3
            """;

        // when
        String report = OrderReportGenerator.generateReport(orders);

        // then
        assertEquals(expected, report);
    }
}
```

## Beispiel: Order-Report mit Bibliothek "ApprovalTests"

Java-Bibliothek
[ApprovalTests.Java](https://github.com/approvals/ApprovalTests.Java)
zur Unterstützung von Approval Tests

-   vergleicht gesamten Report-String mit `*.approved`-Datei
-   kein manuelles Zusammensetzen eines langen "expected"-Strings nötig

Einbindung in Gradle:

``` groovy
dependencies {
    testImplementation 'com.approvaltests:approvaltests:30.1.1'
}
```

Assert im Test über den Aufruf `Approvals.verify(actual);`:

-   Legt die Ausgabe `actual` in einer Datei im Build-Ordner an:
    `<TESTCLASS>.<TESTMETHOD>.received.txt`
-   Inhalt einmalig manuell prüfen
-   Wenn ok: Datei verschieben in Testordner (parallel zur Test-Klasse):
    `<TESTCLASS>.<TESTMETHOD>.approved.txt`
-   Diese "\*.approved.txt"-Datei mit in Git einchecken
-   Folgende Testläufe vergleichen Output mit der
    "\*.approved.txt"-Datei

``` java
class OrderReportGeneratorTest {

    @Test
    void report_looks_as_expected() {
        // given
        List<Order> orders = List.of(
                    new Order("A-001", "Alice", List.of("Keyboard", "Mouse")),
                    new Order("B-002", "Bob", List.of("Laptop")),
                    new Order("C-003", "Charlie", List.of("HDMI Cable", "USB Hub")));

        // when
        String report = OrderReportGenerator.generateReport(orders);

        // then
        // ApprovalTests.Java: vergleicht gegen <TESTCLASS>.<TESTMETHOD>.approved.txt
        Approvals.verify(report);
    }
}
```

Der Approval-Test ruft die normale Produktionsmethode auf, erzeugt einen
kompletten Report und übergibt diesen an `Approvals.verify(report)`.
Beim ersten Lauf wird eine "received"-Datei erzeugt, das Sie manuell
überprüfen und (falls ok) als "approved"-Datei übernehmen. Die
Namenskonvention ist `<TESTCLASS>.<TESTMETHOD>.approved.txt` und muss
strikt eingehalten werden. Die "approved"-Datei muss "neben" der
Test-Klasse liegen, also im selben Ordner. Spätere Testläufe vergleichen
dann den aktuellen Output mit der "approved"-Version; bei Änderungen
zeigt ein Diff genau, was sich im Verhalten geändert hat. So müssen Sie
keinen langen `expected`-String im Test pflegen.

> [!TIP]
>
> Beachten Sie die Ausgabe in der Konsole bei der Ausführung des Tests -
> dort steht, wo Sie die zu prüfende Ausgabedatei
> `<TESTCLASS>.<TESTMETHOD>.received.txt` finden!

## Approval Testing & Git

-   Approved-Dateien werden im Repository versioniert
-   Diffs der Approved-Files zeigen Verhaltensänderungen im Code-Review
-   Workflow bei legitimer Änderung:
    -   Test schlägt fehl -\> Diff prüfen -\> neue Version als
        "approved" übernehmen

Da die "approved"-Ausgabedateien im Versionskontrollsystem liegen,
können Sie bei jedem Pull-Request sehen, wie genau sich der Output
geändert hat. Das ist besonders wertvoll, wenn formatiertes Text- oder
HTML-Output betroffen ist. Wenn sich eine Änderung als gewollt
herausstellt, aktualisieren Sie einfach die Approved-Datei und
dokumentieren damit die neue, korrekte Ausgabe.

## Property-Based Testing: Grundidee

-   Klassischer Test:
    -   "Für Eingabe X erwarte ich Ergebnis Y"
-   Property-Based Test:
    -   "Für alle Eingaben mit Eigenschaft E muss Eigenschaft P gelten"
-   Ein Framework (z.B. jqwik) generiert viele Eingaben automatisch
-   Fokus: Allgemeine Eigenschaften / Invarianten statt einzelner
    Beispiele

Beim Property-Based Testing überlegen Sie nicht mehr nur konkrete
Beispielwerte, sondern formulieren allgemeine Gesetze. Zum Beispiel:
"Sortieren liefert immer eine aufsteigend geordnete Liste mit denselben
Elementen" oder "Die Steuer steigt nie, wenn das Einkommen sinkt". jqwik
erzeugt dann viele unterschiedliche Testdaten, inklusive Grenzfällen,
und versucht aktiv, Gegenbeispiele zu finden. So werden mehr Teile des
Eingaberaums automatisch abgedeckt.

## Anknüpfung: Äquivalenzklassenanalyse

-   Äquivalenzklassenanalyse:
    -   Eingaberaum in Bereiche mit ähnlichem Verhalten aufteilen
    -   Je Klasse einige repräsentative Testfälle + Grenzwerte wählen
-   Property-Based Testing (PBT):
    -   Nutzt dieselben Bereiche/Eigenschaften
    -   Aber: Framework erzeugt viele Werte innerhalb der Bereiche

<!-- -->

-   Kein "doppelt genäht", sondern:
    -   Äquivalenzklassen = Denkwerkzeug
    -   PBT = automatisierte Stichproben über diese Klassen

Sie kennen bereits die Idee, den Eingaberaum in Äquivalenzklassen
aufzuteilen und pro Klasse typische sowie Grenzfälle zu testen.
Property-Based Testing (PBT) baut genau darauf auf: Sie formulieren
Eigenschaften, die für ganze Klassen (z.B. "Einkommen zwischen 10k und
20k") gelten müssen, und überlassen dem Framework die Auswahl vieler
konkreter Werte in diesen Bereichen. Das Denken in Bereichen und
Grenzwerten bleibt, wird aber automatisiert "ausgerollt".

## Durchgängiges Beispiel: Steuerfunktion - Spezifikation

-   Funktion: `calculateTax(int income)`
    -   Einkommen in ganzen Euro (`income >= 0`)
    -   Rückgabe: Steuerbetrag (ganze Euro, abgerundet)
-   Steuerregeln (vereinfacht):
    -   \< 10 000: 0 %
    -   10 000 - 20 000: 10 % auf den Teil über 10 000
    -   20 000 - 50 000: zusätzlich 20 % auf den Teil über 20 000
    -   \> 50 000: zusätzlich 30 % auf den Teil über 50 000
-   Negative Einkünfte: `IllegalArgumentException`

``` java
public class TaxCalculator {
    public static int calculateTax(int income) {
        if (income < 0) throw new IllegalArgumentException("Income must be >= 0");

        double tax = 0.0;

        if (income <= 10_000) tax = 0.0;
        else if (income <= 20_000) tax = 0.10 * (income - 10_000);
        else if (income <= 50_000) tax = 0.10 * 10_000 + 0.20 * (income - 20_000);
        else tax = 0.10 * 10_000 + 0.20 * 30_000 + 0.30 * (income - 50_000);

        return (int) Math.floor(tax);
    }
}
```

## Steuerfunktion: Äquivalenzklassen & Grenzwerte

-   Äquivalenzklassen:
    -   E1: `income < 0` (ungültig)
    -   E2: `0 <= income < 10000`
    -   E3: `10000 <= income <= 20000`
    -   E4: `20000 < income <= 50000`
    -   E5: `income > 50000`

<!-- -->

-   Wichtige Grenzwerte:
    -   Rund um 0: `-1`, `0`, `1`
    -   Rund um 10000: `9999`, `10000`, `10001`
    -   Rund um 20000: `19999`, `20000`, `20001`
    -   Rund um 50000: `49999`, `50000`, `50001`

**Jede Äquivalenzklasse beschreibt Bereiche, in denen die Steuerfunktion
dasselbe Rechenmuster nutzt.** Um diese Klassen herum identifizieren wir
Grenzwerte, an denen das Verhalten wechselt (z.B. 9999 vs. 10000). Das
ist die klassische Vorbereitung für systematische Tests - und
gleichzeitig eine gute Basis für Properties.

## Klassische JUnit-Tests: Beispiele aus den Klassen

-   Für jede Äquivalenzklasse einige repräsentative Werte testen
-   Zusätzlich Grenzfälle explizit prüfen
-   Negative Eingaben: Exception erwarten

``` java
// E1: Ungültige Eingabe
@Test
void negative_income_throws_exception() {
    assertThrows(IllegalArgumentException.class, () -> TaxCalculator.calculateTax(-1));
}

// E2: 0 <= income < 10_000
@Test
void income_below_10k_is_tax_free() {
    assertEquals(0, TaxCalculator.calculateTax(0));
    assertEquals(0, TaxCalculator.calculateTax(5_000));
    assertEquals(0, TaxCalculator.calculateTax(9_999));
}

// ...
```

Diese klassischen Tests setzen direkt die Äquivalenzklassenanalyse um:
Für jede Klasse und jeden Grenzbereich wählen wir einige typische
Einkünfte und erwarten einen exakt berechneten Steuerbetrag. Diese Tests
dokumentieren das Verhalten in verständlichen Beispielen.

## jqwik: Einfache Property - Steuer nie negativ

Ziel-Eigenschaft: Für alle gültigen Einkommen gilt: Steuerbetrag $\ge 0$

Nutzung von jqwik:

-   Einbindung in Gradle:

    ``` groovy
    dependencies {
        testImplementation 'net.jqwik:jqwik:1.10.1'
    }
    ```

-   Testfall: Annotation `@Property` statt `@Test`

-   Generieren von Werten: Annotation`@ForAll` an Parametern generiert
    viele ganzzahlige Einkommen

``` java
class TaxCalculatorProperties {
    @Property
    void tax_is_never_negative(@ForAll @IntRange(min = 0, max = 1_000_000) int income) {
        int tax = TaxCalculator.calculateTax(income);
        assertTrue(tax >= 0);
    }
}
```

Hier formulieren wir eine sehr allgemeine Eigenschaft unserer
Steuerberechnung: Bei keinem gültigen Einkommen darf eine negative
Steuer herauskommen. Die Java-Bibliothek jqwik generiert viele Einkommen
im Bereich 0 bis 1000000 und wendet die Funktion darauf an. Mit der
einfachen JUnit-Assertion `assertTrue(tax >= 0)` prüfen wir die
Eigenschaft wie gewohnt.

Der Test beschreibt nicht konkrete Zahlen, sondern ein generelles
Gesetz.

## jqwik: Monotonie-Eigenschaft für die Steuer

-   Intuition: Wenn Einkommen steigt, darf Steuer nicht sinken
-   Formale Property: Für alle `a`, `b` mit `a <= b` gilt:
    `tax(a) <= tax(b)`

``` java
@Property
void tax_is_monotone_non_decreasing(
        @ForAll @IntRange(min = 0, max = 1_000_000) int a,
        @ForAll @IntRange(min = 0, max = 1_000_000) int b) {

    int lower = Math.min(a, b);
    int higher = Math.max(a, b);

    int taxLower = TaxCalculator.calculateTax(lower);
    int taxHigher = TaxCalculator.calculateTax(higher);

    assertTrue(taxLower <= taxHigher);
}
```

Diese Property fasst eine wesentliche Anforderung an ein Steuersystem
zusammen: Wer mehr verdient, soll nicht weniger Steuer zahlen. jqwik
erzeugt viele Zahlenpaare, die wir im Test sortieren (`lower`, `higher`)
und für die wir jeweils die entsprechenden Steuerbeträge vergleichen.

Ein Verstoß gegen diese Monotonie würde auf inkonsistente Steuerregeln
oder Implementierungsfehler hinweisen - und jqwik würde automatisch ein
Gegenbeispiel liefern.

## jqwik: Verbindung zu Äquivalenzklassen (Bracket-Property)

-   Idee: Innerhalb einer Steuerklasse (z.B. 10000 - 20000) gilt ein
    linearer Zusammenhang
-   Property-Beispiel: Innerhalb 10000 - 20000 steigt die Steuer mit
    10 % der Einkommensdifferenz

``` java
@Property
void within_bracket_10k_to_20k_tax_grows_with_roughly_10_percent(
        @ForAll @IntRange(min = 10_000, max = 19_000) int base,
        @ForAll @IntRange(min = 0, max = 1_000) int delta) {
    int income1 = base;  int income2 = base + delta;
    if (income2 > 20_000) income2 = 20_000;

    int tax1 = TaxCalculator.calculateTax(income1);
    int tax2 = TaxCalculator.calculateTax(income2);
    int diffIncome = income2 - income1;
    int diffTax = tax2 - tax1;
    int expected = (int) Math.floor(0.10 * diffIncome);

    // Wegen Rundung erlauben wir +/- 1 Euro Toleranz
    assertTrue(diffTax >= expected - 1 && diffTax <= expected + 1);
}
```

In dieser Property verbinden wir explizit die Äquivalenzklasse
"Einkommen zwischen 10000 und 20000" mit einer Eigenschaft (*Property*):
In diesem Bereich gilt eine konstante Steuerquote von 10 %. Die Eingaben
werden von jqwik auf diesen Bereich beschränkt, und wir prüfen, ob die
Steuerdifferenz 10 % der Einkommensdifferenz entspricht. Weil in der
Implementierung mit `double` gearbeitet und mit `Math.floor` gerundet
wird, kann es zu Abweichungen um 1 Euro kommen, was durch eine kleine
Toleranz berücksichtigt wird.

## Wrap-Up

-   Klassische Unit-Tests:
    -   Dokumentieren Verhalten an Beispielen
    -   Nutzen Äquivalenzklassen & Grenzwerte manuell
-   Approval Testing:
    -   Erleichtert Tests komplexer Outputs ("Goldstandard")
    -   Passt gut zu Refactoring & Code-Review
-   Property-Based Testing:
    -   Formuliert allgemeine Eigenschaften über alle Eingaben
    -   Nutzt Äquivalenzklassen als Denkgrundlage, generiert aber viele
        Fälle automatisch

Für die Praxis bedeutet das: Sie starten bei der gedanklichen
Strukturierung mit Äquivalenzklassenanalyse, schreiben daraus ein paar
klassische JUnit-Tests zur Dokumentation und Verständlichkeit und
ergänzen diese dann durch Properties, die allgemeine Invarianten
absichern. Wenn zusätzlich komplexe Text- oder Datenstrukturen zu testen
sind, kann Approval Testing helfen, Outputs als referenzierte
Goldstandards zu verwalten. Alle drei Techniken ergänzen sich und helfen
Ihnen, robusteren und besser geprüften Code zu schreiben.

Das Thema Property-Based Testing geht sehr tief, wir schaffen hier nur
einen ersten Einblick in die Grundideen. Frameworks wie jqwik suchen
beispielsweise bei der Ausführung nach "kleinen Gegenbeispiele"
(sogenanntes *Shrinking*), d.h. es wir haben hier nicht einfach nur eine
Spielart von "Random Testing".

> [!TIP]
>
> Sie finden den Beispielcode in einem vorkonfigurierten Gradle-Projekt
> im Ordner
> [ptb](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/junit/src/ptb).

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> Approval Testing:
>
> -   Schönes Video: https://youtu.be/YAXGU2J7XjM (ab 17:12 Approval
>     testing ft. Emily Bache)
> -   Bibliothek
>     [ApprovalTests.Java](https://github.com/approvals/ApprovalTests.Java)
> -   [ApprovalTests Getting
>     Started](https://github.com/approvals/ApprovalTests.Java/blob/master/approvaltests/docs/tutorials/GettingStarted.md)
>
> Property based Testing:
>
> -   Schönes Video (letzter Teil): https://youtu.be/MWsk1h8pv2Q (ab
>     37:33 FizzBuzz)
> -   Blog von Johannes Link (Maintainer von jqwik): [Property-based
>     Testing in Java: Jqwik - a JUnit 5 Test
>     Engine](https://blog.johanneslink.net/2018/03/29/jqwik-on-junit5/)
> -   Doku vom [jqwik-Projekt](https://jqwik.net)
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann das Grundprinzip von Approval Testing an einem selbst
>     gewählten Beispiel erklären (Goldstandard/"approved"-Output,
>     Vergleich mit "received"-Output, Rolle von Diff-Ansichten).
> -   k2: Ich kann den Unterschied zwischen klassischen Beispieltests
>     und Property-Based Testing in eigenen Worten erläutern (Beispiele
>     vs. allgemeine Eigenschaften über viele Eingaben).
> -   k2: Ich kann erklären, wie Äquivalenzklassenanalyse die Auswahl
>     von Testfällen strukturiert und warum sie auch für Property-Based
>     Testing wichtig ist.
> -   k2: Ich kann typische Einsatzszenarien für Approval Testing und
>     Property-Based Testing nennen und begründen, warum diese Techniken
>     dort sinnvoll sind.
> -   k3: Ich kann für eine gegebene Funktion sinnvolle
>     Äquivalenzklassen formulieren und daraus konkrete
>     JUnit-Beispieltests ableiten.
> -   k3: Ich kann für eine Funktion mit komplexem String-Output (z.B.
>     Report oder formatierte Liste) einen einfachen Approval-Test
>     schreiben und den Approved-Output im Projekt verwalten.
> -   k3: Ich kann für eine gegebene Funktion mindestens eine geeignete
>     Property formulieren und diese mit jqwik als `@Property`-Test
>     umsetzen.
> -   k3: Ich kann in einem bestehenden Test-Set begründet entscheiden,
>     ob Beispieltests, Approval Tests oder Property-Based Tests (oder
>     eine Kombination) sinnvoll sind, und dies kurz begründen.
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> a8d89ce 2026-06-09 junit4: add new screencast<br></sub></sup></p></blockquote>
