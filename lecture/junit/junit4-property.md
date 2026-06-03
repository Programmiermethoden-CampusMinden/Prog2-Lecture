---
author: Carsten Gips (HSBI)
title: Property based Testing & Approval Testing
---

::: tldr
Approval Testing hilft Ihnen, komplexe Ausgaben wie Reports, HTML oder JSON
praktikabel zu testen. Statt im Test einen riesigen `expected`-String zu pflegen,
frieren Sie einmal einen geprüften Output als "approved" ein und lassen künftige
Testläufe automatisch dagegen vergleichen. Änderungen sehen Sie als Diff im
Repository und können bewusst entscheiden, ob das Verhalten gewollt angepasst wurde
oder ein Fehler vorliegt - ideal auch als Sicherheitsnetz vor und nach Refactorings.

Property-Based Testing ergänzt klassische Beispieltests, indem es allgemeine
Eigenschaften ("Für alle Eingaben aus diesem Bereich muss X gelten") über viele
automatisch generierte Eingaben prüft. Die Äquivalenzklassenanalyse bleibt dabei das
zentrale Denkwerkzeug: Sie strukturieren damit den Eingaberaum, wählen Beispiele für
klassische JUnit-Tests und formulieren daraus Properties für jqwik. Beispieltests
dokumentieren Verhalten an konkreten Fällen, Properties suchen systematisch nach
Gegenbeispielen - zusammen ergeben sie ein deutlich robusteres Test-Set.
:::

::: youtube
TODO
:::

# Motivation: Mehr als nur Beispieltests

-   Bisher: klassische Unit-Tests mit JUnit (`@Test`, `assertEquals`, ...)
-   Problem 1: Komplexe/umfangreiche Outputs sind schwer "per Hand" zu vergleichen
-   Problem 2: Einzelne Beispieltests decken nur wenige Eingaben ab
-   Idee: Zwei Ergänzungen
    -   Approval Testing
    -   Property-Based Testing (PBT)

In klassischen Tests formulieren wir für ein paar ausgewählte Beispiele "Eingabe X
-\> erwartete Ausgabe Y". Das ist gut für Dokumentation und einfache Funktionen,
stößt aber an Grenzen, wenn Outputs lang/komplex sind oder wenn wir viele
verschiedene Eingaben testen wollen. Approval Testing hilft beim Umgang mit
komplexen Ausgaben, Property-Based Testing beim automatisierten Durchprobieren
vieler Eingaben anhand allgemeiner Eigenschaften.

# Approval Testing: Idee und Einsatzgebiete

-   Grundidee:
    -   Einmal gültigen Output als "Goldstandard" abspeichern (`approved`)
    -   Zukünftig generierten Output automatisch dagegen vergleichen
-   Gut geeignet für:
    -   Reports, Tabellen, formatierten Text
    -   HTML, JSON, Logs, Konsolen-Output
-   Typischer Einsatz:
    -   Refactoring ohne Verhaltensänderung absichern

Beim Approval Testing wird nicht im Test ein erwarteter String manuell
zusammengebaut. Stattdessen prüft man einmalig einen generierten Output, "segnet ihn
ab" und speichert ihn als "approved"-Datei. Künftige Testläufe erzeugen einen
"received"-Output und vergleichen ihn mit der "approved"-Version. Unterschiede
fallen als Diffs auf. Besonders beim Refactoring ist das hilfreich: Wenn sich der
Output nicht ändert, war das Refactoring verhaltensgleich.

# Beispiel: Order-Report mit ApprovalTests

-   Produktionscode: Textreport aus Bestellungen erzeugen
-   Approval-Test: vergleicht gesamten Report-String mit `*.approved`-Datei
-   Kein manuelles Zusammensetzen eines langen "expected"-Strings nötig

``` java
public class Order {
    private final String id;
    private final String customer;
    private final List<String> items;

    public Order(String id, String customer, List<String> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    public String getId() { return id; }
    public String getCustomer() { return customer; }
    public List<String> getItems() { return items; }
}

public class OrderReportGenerator {

    public String generateReport(List<Order> orders) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ORDER REPORT ===\n");
        for (Order o : orders) {
            sb.append("Order: ").append(o.getId()).append("\n");
            sb.append("Customer: ").append(o.getCustomer()).append("\n");
            sb.append("Items:\n");
            for (String item : o.getItems()) {
                sb.append(" - ").append(item).append("\n");
            }
            sb.append("\n");
        }
        sb.append("Total orders: ").append(orders.size()).append("\n");
        return sb.toString();
    }
}

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;
import java.util.List;

class OrderReportGeneratorApprovalTest {

    @Test
    void reportLooksAsExpected() {
        OrderReportGenerator gen = new OrderReportGenerator();
        List<Order> orders = List.of(
            new Order("A-001", "Alice", List.of("Keyboard", "Mouse")),
            new Order("B-002", "Bob", List.of("Laptop")),
            new Order("C-003", "Charlie", List.of("Monitor", "HDMI Cable", "USB Hub"))
        );

        String report = gen.generateReport(orders);

        Approvals.verify(report);
    }
}
```

Der Approval-Test ruft die normale Produktionsmethode auf, erzeugt einen kompletten
Report und übergibt diesen an `Approvals.verify(report)`. Beim ersten Lauf wird ein
"received"-File erzeugt, das Sie prüfen und als "approved"-File übernehmen. Spätere
Testläufe vergleichen den aktuellen Output mit der "approved"-Version; bei
Änderungen zeigt ein Diff genau, was sich im Verhalten geändert hat. So müssen Sie
keinen langen `expected`-String im Test pflegen.

# Approval Testing & Git

-   Approved-Dateien werden im Repository versioniert
-   Diffs der Approved-Files zeigen Verhaltensänderungen im Code-Review
-   Workflow bei legitimer Änderung:
    -   Test schlägt fehl -\> Diff prüfen -\> neue Version als "approved" übernehmen

Da die "approved"-Ausgabedateien im Versionskontrollsystem liegen, können Sie bei
jedem Pull-Request sehen, wie genau sich der Output geändert hat. Das ist besonders
wertvoll, wenn formatiertes Text- oder HTML-Output betroffen ist. Wenn sich eine
Änderung als gewollt herausstellt, aktualisieren Sie einfach die Approved-Datei und
dokumentieren damit die neue, korrekte Ausgabe.

# Property-Based Testing: Grundidee

-   Klassischer Test:
    -   "Für Eingabe X erwarte ich Ergebnis Y"
-   Property-Based Test:
    -   "Für alle Eingaben mit Eigenschaft E muss Eigenschaft P gelten"
-   Das Framework (z.B. jqwik) generiert viele Eingaben automatisch
-   Fokus: Allgemeine Eigenschaften / Invarianten statt einzelner Beispiele

Beim Property-Based Testing überlegen Sie nicht mehr nur konkrete Beispielwerte,
sondern formulieren allgemeine Gesetze. Zum Beispiel: "Sortieren liefert immer eine
aufsteigend geordnete Liste mit denselben Elementen" oder "Die Steuer steigt nie,
wenn das Einkommen sinkt". jqwik erzeugt dann viele unterschiedliche Testdaten,
inklusive Grenzfällen, und versucht aktiv, Gegenbeispiele zu finden. So werden mehr
Teile des Eingaberaums automatisch abgedeckt.

# Anknüpfung: Äquivalenzklassenanalyse

-   Äquivalenzklassenanalyse:
    -   Eingaberaum in Bereiche mit ähnlichem Verhalten aufteilen
    -   Je Klasse einige repräsentative Testfälle + Grenzwerte wählen
-   Property-Based Testing:
    -   Nutzt dieselben Bereiche/Eigenschaften
    -   Aber: Framework erzeugt viele Werte innerhalb der Bereiche
-   Kein "doppelt genäht", sondern:
    -   Äquivalenzklassen = Denkwerkzeug
    -   PBT = automatisierte Stichproben über diese Klassen

Sie kennen bereits die Idee, den Eingaberaum in Äquivalenzklassen aufzuteilen und
pro Klasse typische sowie Grenzfälle zu testen. Property-Based Testing baut genau
darauf auf: Sie formulieren Eigenschaften, die für ganze Klassen (z.B. "Einkommen
zwischen 10k und 20k") gelten müssen, und überlassen dem Framework die Auswahl
vieler konkreter Werte in diesen Bereichen. Das Denken in Bereichen und Grenzwerten
bleibt, wird aber automatisiert "ausgerollt".

# Durchgängiges Beispiel: Steuerfunktion - Spezifikation

-   Funktion: `calculateTax(int income)`
    -   Einkommen in ganzen Euro (`income >= 0`)
    -   Rückgabe: Steuerbetrag (ganze Euro, abgerundet)
-   Steuerregeln (vereinfacht):
    -   \< 10 000: 0 %

    -   10 000 - 20 000: 10 % auf den Teil über 10 000

    -   20 000 - 50 000: zusätzlich 20 % auf den Teil über 20 000

    -   > 50 000: zusätzlich 30 % auf den Teil über 50 000
-   Negative Einkünfte: `IllegalArgumentException`

``` java
public class TaxCalculator {

    public static int calculateTax(int income) {
        if (income < 0) {
            throw new IllegalArgumentException("Income must be >= 0");
        }

        double tax = 0.0;

        if (income <= 10_000) {
            tax = 0.0;
        } else if (income <= 20_000) {
            tax = 0.10 * (income - 10_000);
        } else if (income <= 50_000) {
            tax = 0.10 * 10_000
                    + 0.20 * (income - 20_000);
        } else {
            tax = 0.10 * 10_000
                    + 0.20 * 30_000
                    + 0.30 * (income - 50_000);
        }

        return (int) Math.floor(tax);
    }
}
```

Diese vereinfachte Steuerfunktion eignet sich gut als Übungsbeispiel: Die Regeln
sind klar strukturiert (verschiedene "Steuerklassen"), es gibt Grenzwerte und das
Ergebnis ist deterministisch und leicht nachzurechnen. Negative Eingaben behandeln
wir explizit als Fehler. Damit haben wir ein Setting, in dem sich
Äquivalenzklassenanalyse und Property-Based Testing sehr gut demonstrieren lassen.

# Steuerfunktion: Äquivalenzklassen & Grenzwerte

-   Äquivalenzklassen:
    -   E1: `income < 0` (ungültig)
    -   E2: `0 <= income < 10_000`
    -   E3: `10_000 <= income <= 20_000`
    -   E4: `20_000 < income <= 50_000`
    -   E5: `income > 50_000`
-   Wichtige Grenzwerte:
    -   Rund um 0: `-1`, `0`, `1`
    -   Rund um 10 000: `9_999`, `10_000`, `10_001`
    -   Rund um 20 000: `19_999`, `20_000`, `20_001`
    -   Rund um 50 000: `49_999`, `50_000`, `50_001`

Hier zerlegen Sie gemeinsam mit den Student:innen den Eingabebereich in sinnvolle
Klassen. Jede Klasse beschreibt Bereiche, in denen die Steuerfunktion dasselbe
Rechenmuster nutzt. Um diese Klassen herum identifizieren Sie Grenzwerte, an denen
das Verhalten wechselt (z.B. 9 999 vs. 10 000). Das ist die klassische Vorbereitung
für systematische Tests - und gleichzeitig eine hervorragende Basis für Properties.

# Klassische JUnit-Tests: Beispiele aus den Klassen

-   Für jede Äquivalenzklasse einige repräsentative Werte testen
-   Zusätzlich Grenzfälle explizit prüfen
-   Negative Eingaben: Exception erwarten

``` java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void negativeIncomeThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> TaxCalculator.calculateTax(-1));
    }

    @Test
    void incomeBelow10kIsTaxFree() {
        assertEquals(0, TaxCalculator.calculateTax(0));
        assertEquals(0, TaxCalculator.calculateTax(5_000));
        assertEquals(0, TaxCalculator.calculateTax(9_999));
    }

    @Test
    void incomeBetween10kAnd20kTaxedAt10PercentAbove10k() {
        assertEquals(0, TaxCalculator.calculateTax(10_000));
        assertEquals(500, TaxCalculator.calculateTax(15_000));
        assertEquals(1_000, TaxCalculator.calculateTax(20_000));
    }

    @Test
    void incomeBetween20kAnd50kHasTwoBrackets() {
        assertEquals(1_000, TaxCalculator.calculateTax(20_001));
        assertEquals(3_000, TaxCalculator.calculateTax(30_000));
        assertEquals(7_000, TaxCalculator.calculateTax(50_000));
    }

    @Test
    void incomeAbove50kHasThirdBracket() {
        assertEquals(7_000, TaxCalculator.calculateTax(50_001));
        assertEquals(16_000, TaxCalculator.calculateTax(80_000));
    }
}
```

Diese klassischen Tests setzen direkt die Äquivalenzklassenanalyse um: Für jede
Klasse und jeden Grenzbereich wählen Sie einige typische Einkünfte und erwarten
einen exakt berechneten Steuerbetrag. Diese Tests dokumentieren das Verhalten in
verständlichen Beispielen und sind eine gute Grundlage, bevor Sie mit Property-Based
Testing in die Breite gehen.

# jqwik: Einfache Property - Steuer nie negativ

-   Ziel-Eigenschaft:
    -   Für alle gültigen Einkommen gilt: Steuerbetrag $\ge 0$
-   Nutzung von jqwik:
    -   `@Property` statt `@Test`
    -   `@ForAll` generiert viele ganzzahlige Einkommen

``` java
import net.jqwik.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaxCalculatorProperties {

    @Property
    void taxIsNeverNegative(
            @ForAll @IntRange(min = 0, max = 1_000_000) int income) {

        int tax = TaxCalculator.calculateTax(income);

        assertTrue(tax >= 0);
    }
}
```

Hier formulieren Sie eine sehr allgemeine Eigenschaft: Bei keinem gültigen Einkommen
darf eine negative Steuer herauskommen. jqwik generiert viele Einkommen im Bereich 0
bis 1 000 000 und wendet die Funktion darauf an. Mit der einfachen JUnit-Assertion
`assertTrue(tax >= 0)` prüfen Sie die Eigenschaft ohne zusätzliche Bibliotheken. Die
Studierenden sehen: Der Test beschreibt nicht konkrete Zahlen, sondern ein
generelles Gesetz.

# jqwik: Monotonie-Eigenschaft für die Steuer

-   Intuition:
    -   Wenn Einkommen steigt, darf Steuer nicht sinken
-   Formale Property:
    -   Für alle `a`, `b` mit `a <= b` gilt:
        -   `tax(a) <= tax(b)`

``` java
class TaxCalculatorMonotonicityProperties {

    @Property
    void taxIsMonotoneNonDecreasing(
            @ForAll @IntRange(min = 0, max = 1_000_000) int a,
            @ForAll @IntRange(min = 0, max = 1_000_000) int b) {

        int lower = Math.min(a, b);
        int higher = Math.max(a, b);

        int taxLower = TaxCalculator.calculateTax(lower);
        int taxHigher = TaxCalculator.calculateTax(higher);

        assertTrue(taxLower <= taxHigher);
    }
}
```

Diese Property fasst eine wesentliche Anforderung an ein Steuersystem zusammen: Wer
mehr verdient, soll nicht weniger Steuer zahlen. jqwik erzeugt viele Zahlenpaare,
sortiert sie (`lower`, `higher`) und vergleicht die entsprechenden Steuerbeträge.
Ein Verstoß gegen diese Monotonie würde auf inkonsistente Steuerregeln oder
Implementierungsfehler hinweisen - und jqwik würde automatisch ein Gegenbeispiel
liefern.

# jqwik: Verbindung zu Äquivalenzklassen (Bracket-Property)

-   Idee:
    -   Innerhalb einer Steuerklasse (z.B. 10 000 - 20 000) gilt ein "fast" linearer
        Zusammenhang
-   Property-Beispiel:
    -   Innerhalb 10 000 - 20 000 steigt die Steuer ungefähr mit 10 % der
        Einkommensdifferenz
-   Praktisch:
    -   `@IntRange` beschränkt generierte Werte auf diesen Bereich

``` java
class TaxCalculatorBracketProperties {

    @Property
    void withinBracket10kTo20kTaxGrowsWithRoughly10Percent(
            @ForAll @IntRange(min = 10_000, max = 19_000) int base,
            @ForAll @IntRange(min = 0, max = 1_000) int delta) {

        int income1 = base;
        int income2 = base + delta;
        if (income2 > 20_000) {
            income2 = 20_000;
        }

        int tax1 = TaxCalculator.calculateTax(income1);
        int tax2 = TaxCalculator.calculateTax(income2);

        int diffIncome = income2 - income1;
        int diffTax = tax2 - tax1;

        int expected = (int) Math.floor(0.10 * diffIncome);

        // Wegen Rundung erlauben wir +/- 1 Euro Toleranz
        assertTrue(diffTax >= expected - 1 && diffTax <= expected + 1);
    }
}
```

In dieser Property verbinden Sie explizit die Äquivalenzklasse "Einkommen zwischen
10 000 und 20 000" mit einer Eigenschaft: In diesem Bereich gilt eine konstante
Steuerquote von 10 %. Die Eingaben werden von jqwik auf diesen Bereich beschränkt,
und Sie prüfen, ob die Steuerdifferenz ungefähr 10 % der Einkommensdifferenz
entspricht. Runden kann zu Abweichungen um 1 Euro führen, was Sie durch eine kleine
Toleranz berücksichtigen.

# Fazit: Zusammenspiel der Techniken

-   Klassische Unit-Tests:
    -   Dokumentieren Verhalten an Beispielen
    -   Nutzen Äquivalenzklassen & Grenzwerte manuell
-   Approval Testing:
    -   Erleichtert Tests komplexer Outputs ("Goldstandard")
    -   Passt gut zu Refactoring & Code-Review
-   Property-Based Testing:
    -   Formuliert allgemeine Eigenschaften über alle Eingaben
    -   Nutzt Äquivalenzklassen als Denkgrundlage, generiert aber viele Fälle
        automatisch

Für die Praxis bedeutet das: Sie starten bei der gedanklichen Strukturierung mit
Äquivalenzklassenanalyse, schreiben daraus ein paar klassische JUnit-Tests zur
Dokumentation und Verständlichkeit und ergänzen diese dann durch Properties, die
allgemeine Invarianten absichern. Wenn zusätzlich komplexe Text- oder
Datenstrukturen zu testen sind, kann Approval Testing helfen, Outputs als
referenzierte Goldstandards zu verwalten. Alle drei Techniken ergänzen sich und
helfen Ihnen, robusteren und besser geprüften Code zu schreiben.

# Wrap-Up

-   Approval Testing eignet sich für komplexe Outputs (Reports, HTML, JSON): Einmal
    als "approved" akzeptieren, danach automatisch dagegen vergleichen und
    Änderungen per Diff sehen.
-   Property-Based Testing prüft nicht einzelne Beispiele, sondern allgemeine
    Eigenschaften ("Gesetze") über viele automatisch generierte Eingaben.
-   Äquivalenzklassenanalyse bleibt das zentrale Denkwerkzeug: Sie strukturiert den
    Eingaberaum und liefert die Grundlage sowohl für Beispieltests als auch für
    Properties.
-   Beispieltests erklären Verhalten an konkreten Fällen, Properties suchen
    systematisch nach Gegenbeispielen - beides ergänzt sich und führt zusammen zu
    deutlich robusteren Tests.

::: readings
Approval Testing: schönes Video: https://youtu.be/YAXGU2J7XjM (ab 17:12)

Property based Testing:
- schönes Video (letzter Teil): https://youtu.be/MWsk1h8pv2Q
- talk: https://github.com/stfnw/talk-introduction-to-property-based-testing
- Blog von Johannes Link (Maintainer von jqwik): [Property-based Testing in Java: Jqwik - a JUnit 5 Test Engine](https://blog.johanneslink.net/2018/03/29/jqwik-on-junit5/)
- Doku vom [jqwik-Projekt](https://jqwik.net)
:::

::: outcomes
k2: Ich kann das Grundprinzip von Approval Testing an einem selbst gewählten
Beispiel erklären (Goldstandard/"approved"-Output, Vergleich mit "received"-Output,
Rolle von Diff-Ansichten). k2: Ich kann den Unterschied zwischen klassischen
Beispieltests und Property-Based Testing in eigenen Worten erläutern (Beispiele
vs. allgemeine Eigenschaften über viele Eingaben). k2: Ich kann erklären, wie
Äquivalenzklassenanalyse die Auswahl von Testfällen strukturiert und warum sie auch
für Property-Based Testing wichtig ist. k2: Ich kann typische Einsatzszenarien für
Approval Testing und Property-Based Testing nennen und begründen, warum diese
Techniken dort sinnvoll sind. k3: Ich kann für eine gegebene Funktion sinnvolle
Äquivalenzklassen formulieren und daraus konkrete JUnit-Beispieltests ableiten. k3:
Ich kann für eine gegebene Funktion mindestens eine geeignete Property formulieren
und diese mit jqwik als `@Property`-Test umsetzen. k3: Ich kann für eine Funktion
mit komplexem String-Output (z.B. Report oder formatierte Liste) einen einfachen
Approval-Test schreiben und den Approved-Output im Projekt verwalten. k3: Ich kann
in einem bestehenden Test-Set begründet entscheiden, ob Beispieltests, Approval
Tests oder Property-Based Tests (oder eine Kombination) sinnvoll sind, und dies kurz
begründen.
:::

::: challenges
TODO
:::
