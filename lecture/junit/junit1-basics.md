# Testen mit JUnit (JUnit-Basics)

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Fehler schleichen sich durch Zeitdruck und hohe Komplexität schnell in
> ein Softwareprodukt ein. Die Folgen können von "ärgerlich" über
> "teuer" bis hin zu (potentiell) "tödlich" reichen. Richtiges Testen
> ist also ein wichtiger Aspekt bei der Softwareentwicklung!
>
> JUnit ist ein Java-Framework, mit dem Unit-Tests (aber auch andere
> Teststufen) implementiert werden können. In JUnit zeichnet man eine
> Testmethode mit Hilfe der Annotation `@Test` an der entsprechenden
> Methode aus. Dadurch kann man Produktiv- und Test-Code prinzipiell
> mischen; Best Practice ist aber das Anlegen eines weiteren Ordners
> `test/` und das Spiegeln der Package-Strukturen und sowie pro Klasse
> eine korrespondierende Test-Klasse zu nutzen. In den Testmethoden baut
> man den Test auf, führt schließlich den Testschritt durch
> (beispielsweise konkreter Aufruf der zu testenden Methode) und prüft
> anschließend mit einem `assert*()`, ob das erzielte Ergebnis dem
> erwarteten Ergebnis entspricht. Ist alles OK, ist der Test "grün",
> sonst "rot". Da ein fehlschlagendes `assert*()` den Test abbricht,
> werden eventuell danach folgende Prüfungen **nicht** mehr durchgeführt
> und damit ggf. weitere Fehler maskiert. Deshalb ist es gute Praxis, in
> einer Testmethode nur einen Testfall zu implementieren und i.d.R. auch
> nur wenige Aufrufe von `assert*()` pro Testmethode zu haben.
>
> Über die verschiedenen `assume*()`-Methoden kann geprüft werden, ob
> eventuelle Vorbedingungen für das Ausführen eines Testfalls erfüllt
> sind - anderenfalls wird der Testfall dann übersprungen.
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> Vorlesung:
>
> -   Teil 1 \[[YT](https://youtu.be/q0LquRchCuY)\],
>     \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-junit1-testen-mit-junit-junit-basics-teil-1/f0c405db106e41a1ccb9d0aa2d85cfce)\]
> -   Teil 2 \[[YT](https://youtu.be/6VEDu3eJ-Cc)\],
>     \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-junit1-testen-mit-junit-junit-basics-teil-2/d72049754cb5cf30c1b635b0ee676bf1)\]
>
> Demos:
>
> -   Anlegen von Testfällen \[[YT](https://youtu.be/CNMT39T8RvI)\],
>     \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-junit1-demo-anlegen-von-testfllen-mit-junit/93ca4f3d7f28063b30a952c040517733)\]
> -   `assume()` vs. `assert()` \[[YT](https://youtu.be/e2XoPr3LfOA)\],
>     \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-junit1-demo-assume-vs-assert/1ad1a68c9464994488e184cde6534d47)\]
> -   Parametrisierte Tests \[[YT](https://youtu.be/IeGXaNHcX3w)\],
>     \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-junit1-demo-parametrisierte-tests/bef1445ac86072839750932073021337)\]
>
> </details>

## Software-Fehler und ihre Folgen

<p align="center"><picture><source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/junit/images/swfehler_inv.png" /><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/junit/images/swfehler.png" width="70%" /></picture></p>

### (Einige) Ursachen für Fehler

-   Zeit- und Kostendruck
-   Mangelhafte Anforderungsanalyse
-   Hohe Komplexität
-   Mangelhafte Kommunikation
-   Keine/schlechte Teststrategie
-   Mangelhafte Beherrschung der Technologie
-   ...

### Irgendjemand muss mit Deinen Bugs leben!

Leider gibt es im Allgemeinen keinen Weg zu zeigen, dass eine Software
korrekt ist. Man kann (neben formalen Beweisansätzen) eine Software oft
nur unter möglichst vielen Bedingungen ausprobieren, um ihr Verhalten zu
beobachten und um die versteckten Bugs zu triggern.

Mal abgesehen von der verbesserten *User-Experience* führt weniger
fehlerbehaftete Software auch dazu, dass man seltener mitten in der
Nacht geweckt wird, weil irgendwo wieder ein Server gecrasht ist ...
Weniger fehlerbehaftete Software ist auch leichter zu ändern und zu
pflegen! In realen Projekten macht Maintenance den größten Teil an der
Softwareentwicklung aus ... Während Ihre Praktikumsprojekte vermutlich
nach der Abgabe nie wieder angeschaut werden, können echte Projekte
viele Jahre bis Jahrzehnte leben! D.h. irgendwer muss sich dann mit
Ihren Bugs herumärgern - vermutlich sogar Sie selbst ;)

> Always code as if the guy who ends up maintaining your code will be a
> violent psychopath who knows where you live. Code for readability.
>
> -- [John F.
> Woods](https://groups.google.com/g/comp.lang.c++/c/rYCO5yn4lXw/m/oITtSkZOtoUJ)

Dieses Zitat taucht immer mal wieder auf, beispielsweise auf der [OSCON
2014](https://twitter.com/andypiper/status/490952891058757632) ... Es
scheint aber tatsächlich, dass [John F.
Woods](https://groups.google.com/g/comp.lang.c++/c/rYCO5yn4lXw/m/oITtSkZOtoUJ)
die ursprüngliche Quelle war (vgl. [Stackoverflow:
876089](https://stackoverflow.com/questions/876089/who-wrote-this-programing-saying-always-code-as-if-the-guy-who-ends-up-maintai#878436)).

Da wir nur wenig Zeit haben und zudem vergesslich sind und obendrein die
Komplexität eines Projekts mit der Anzahl der Code-Zeilen i.d.R.
nicht-linear ansteigt, müssen wir das Testen automatisieren. Und hier
kommt JUnit ins Spiel.

## Zentrale Begriffe: Was wann testen?

-   **Modultest** / **Unit-Test**
    -   Testen einer Klasse und ihrer Methoden
    -   Test auf gewünschtes inneres Verhalten (Parameter, Schleifen,
        ...)

<!-- -->

-   **Integrationstest**
    -   Test des korrekten Zusammenspiels mehrerer Komponenten
    -   Fokus auf Schnittstellen, Datenaustausch, Zusammenspiel

<!-- -->

-   **Systemtest** / **End-to-End-Test (E2E)**
    -   Test des kompletten Systems unter produktiven Bedingungen
    -   Fokus: Gesamter Geschäftsprozess, UI, Use Cases
    -   Funktionale und nichtfunktionale Anforderungen testen

<!-- -->

-   **Regressionstest**
    -   Änderungen dürfen bestehende Funktionalität nicht brechen
    -   Fokus: Wiederholung von bestehenden Tests nach Code-Änderungen

=\> Verweis auf Wahlfach "Softwarequalität"

Dies sind einige ausgewählte Testarten - man kann ohne große Probleme
noch viel genauer hinschauen und viele weitere Arten und Stufen
unterscheiden.

## JUnit: Test-Framework für Java

**JUnit** - Open Source Java Test-Framework zur Erstellung und
Durchführung wiederholbarer Tests

-   JUnit 3
    -   Tests müssen in eigenen Testklassen stehen
    -   Testklassen müssen von Klasse `TestCase` erben
    -   Testmethoden müssen mit dem Präfix "`test`" beginnen

<!-- -->

-   JUnit 4
    -   Annotation `@Test` für Testmethoden
    -   Kein Zwang zu spezialisierten Testklassen (insbesondere kein
        Zwang mehr zur Ableitung von `TestCase`)
    -   Freie Namenswahl für Testmethoden (benötigen nicht mehr Präfix
        "`test`")

    Damit können prinzipiell auch direkt im Source-Code Methoden als
    JUnit-Testmethoden ausgezeichnet werden ... (das empfiehlt sich in
    der Regel aber nicht)

<!-- -->

-   **JUnit 5 und 6 = JUnit Platform + JUnit Jupiter + JUnit Vintage**

    -   Erweiterung um mächtigere Annotationen
    -   Aufteilung in spezialisierte Teilprojekte

    Das Teilprojekt "JUnit Platform" ist die Grundlage für das
    JUnit-Framework. Es bietet u.a. einen Console-Launcher, um
    Testsuiten manuell in der Konsole zu starten oder über Builder wie
    Maven oder Gradle.

    Das Teilprojekt "JUnit Jupiter" ist das neue Programmiermodell zum
    Schreiben von Tests seit JUnit 5. Es beinhaltet eine TestEngine zum
    Ausführen der in Jupiter geschriebenen Tests.

    Das Teilprojekt "JUnit Vintage" beinhaltet eine TestEngine zum
    Ausführen von Tests, die in JUnit 3 oder JUnit 4 geschrieben sind.

*Anmerkung*: Wie der Name schon sagt, ist das Framework für Modultests
("Unit-Tests") gedacht. Man kann damit aber auch prima auf anderen
Teststufen arbeiten und beispielsweise Systemtests definieren.

*Anmerkung*: Im Folgenden besprechen wir JUnit am Beispiel **JUnit 6**.
Mit JUnit 3 sollte definitiv nicht mehr aktiv gearbeitet werden, d.h.
insbesondere keine neuen Tests mehr erstellt werden, da diese Version
nicht mehr weiterentwickelt wird. Es kann sein, dass Ihnen in
Produktivumgebungen noch häufig Testsuiten in JUnit 4 begegnen - achten
Sie dort auf die verwendeten Annotationen, die sich teilweise leicht von
der modernen Variante unterscheiden.

## Einbinden von JUnit (Gradle)

Am einfachsten bindet man JUnit über das Build-Tool in das Projekt ein.
Dabei werden dann automatisch alle Abhängigkeiten aufgelöst und die
relevanten Jar-Files heruntergeladen und in den Classpath eingebunden.

Für Gradle muss man zwei Einträge vornehmen: (a) JUnit als Dependency
deklarieren und (b) für die Test-Targets die JUnit-Plattform aktivieren.
Am einfachsten geht es wie in den
[JUnit-Beispielprojekten](https://github.com/junit-team/junit-examples/tree/r6.0.3/junit-jupiter-starter-gradle)
gezeigt mit einer BOM-Deklaration ([*Bill of
Materials*](https://medium.com/@marcelogdomingues/understanding-bom-and-pom-in-maven-a-comprehensive-guide-4017eaf5d98d)),
die auch die Version trägt. Dann noch ein Eintrag für Jupiter
(beinhaltet die Testengine und die API) sowie zum tatsächlichen
Ausführen der Tests den Launcher. Im Beispiel werden diese Dependencies
so deklariert, dass sie wirklich nur für das Übersetzen der Tests
("testImplementation") bzw. zur Laufzeit beim Ausführen der Tests
("testRuntimeOnly") eingebunden werden.

``` groovy
plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform('org.junit:junit-bom:6.0.3'))
    testImplementation('org.junit.jupiter:junit-jupiter')
    testRuntimeOnly('org.junit.platform:junit-platform-launcher')
}

test {
    useJUnitPlatform()
}
```

Wie üblich findet man die Einträge für die Dependencies auf [Maven
Central](https://mvnrepository.com/).

Ein Blick in die [JUnit-Dokumentation](https://docs.junit.org/) ist
immer lohnenswert.

## Anlegen und Organisation der Tests mit JUnit

-   Anlegen neuer Tests: Klasse auswählen, Kontextmenü `Generate > Test`

<!-- -->

-   **Best Practice**: Spiegeln der Paket-Hierarchie
    -   Toplevel-Ordner `src/test/java/` (statt `src/main/java/`)
    -   Package-Strukturen spiegeln
    -   Testklassen mit Suffix "`Test`"

<p align="center"><picture><source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/junit/images/newJUnit_inv.png" /><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/junit/images/newJUnit.png" width="40%" /></picture></p>

Für die Klasse `foo.bar.Wuppie` im `src/main/java/`-Ordner erzeugen Sie
also die Testklasse `foo.bar.WuppieTest` im `src/test/java/`-Ordner. Aus
Java-Sicht werden beide Ordner als "Source-Ordner" deklariert (über
Gradle).

### Vorteile dieses Vorgehens

-   Die Testklassen sind aus Java-Sicht im selben Package wie die
    Source-Klassen, d.h. Zugriff auf Package-sichtbare Methoden etc. ist
    gewährleistet
-   Durch die Spiegelung der Packages in einem separaten Testordner
    erhält man eine gute getrennte Übersicht über jeweils die Tests und
    die Sourcen
-   Die Wiederverwendung des Klassennamens mit dem Anhang "Test" erlaubt
    die schnelle Erkennung, welche Tests hier vorliegen

In der Paketansicht liegen dann die Source- und die Testklassen immer
direkt hintereinander (da sie im selben Paket sind und mit dem selben
Namen anfangen) =\> besserer Überblick!

### Anmerkung: Die (richtige) JUnit-Bibliothek muss im Classpath liegen!

Die IDE's fragen typischerweise beim Anlegen des ersten Tests nach, ob
sie die passenden Jar-Files für JUnit herunterladen und in den (lokalen)
Classpath einfügen sollen.

**Achtung**: Das passt dann für das lokale Bauen/Testen auf Ihrem
Rechner, klappt aber nicht mehr, wenn das Projekt mit verschiedenen
Personen bearbeitet wird. Dann müsste jede für sich sicherstellen, dass
die richtigen Bibliotheken vorhanden sind. Deshalb: Bitte nutzen Sie ein
Buildtool wie Gradle und konfigurieren Sie dort JUnit als externe
Dependency. Das Buildtool kümmert sich dann um das Auflösen und
Herunterladen der Jar-Files, und da die Konfiguration im Projekt
eingecheckt ist, klappt das auch für alle anderen am Projekt beteiligten
Personen.

## Definition von Testmethoden

Annotation `@Test` vor Testmethode schreiben

``` java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DemoResults {
    @Test
    void passes_when_assertion_is_true() {
        assertEquals(0, 1 - 1);
    }
}
```

**Hinweis Sichtbarkeit**: Während in JUnit 4 die Testmethoden mit der
Sichtbarkeit `public` versehen sein müssen und keine Parameter haben
(dürfen), spielt die Sichtbarkeit ab JUnit 5 keine Rolle mehr (und die
Testmethoden dürfen Parameter aufweisen). *Best Practice* ist aktuell,
auf *package-private* zu gehen. Die Testklassen/-methoden gehören nicht
in die öffentliche API, und man möchte normalerweise von Testklassen
auch nicht erben.

**Hinweis Namen**: In Java werden Methoden üblicherweise in *camelCase*
geschrieben. Bei den Tests wird häufig davon bewusst abgewichen und es
werden Unterstriche eingesetzt, um den Methodennamen zu einem "Satz" zu
machen - und dieser "Satz" erklärt, was der Test macht. Wie bei den
normalen Methodennamen muss man hier aber auch aufpassen, dass die Namen
nicht zu lang und damit unübersichtlich werden (auch wenn sie etwas
länger ausfallen dürfen als bei normalen Methoden).

## Ergebnis prüfen

Klasse **`org.junit.jupiter.api.Assertions`** enthält diverse
**statische** Methoden zum Prüfen:

``` java
// Argument muss true bzw. false sein
static void assertTrue(boolean condition);
static void assertFalse(boolean condition);

// Gleichheit im Sinne von equals()
static void assertEquals(Object expected, Object actual);
static void assertEquals(long expected, long actual);

// Test sofort fehlschlagen lassen
static <V> V fail(String message);

...
```

## Mögliche Testausgänge bei JUnit: rot/grün/ignoriert

<p align="center"><picture><source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/junit/images/junitErgebnis_inv.png" /><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/junit/images/junitErgebnis.png" width="60%" /></picture></p>

1.  **grün**: Testausgang positiv ("passed")
    -   Alle Assertions sind erfolgreich
    -   Es gibt keine unbehandelte Exception
2.  **rot**: Testausgang negativ ("failed")
    -   Ein Assert ist fehlgeschlagen
    -   `Assert.fail()` wurde aufgerufen
    -   Unbehandelte Exception aufgetreten
3.  **ignoriert**: Testausgang "ignored"
    -   Vorbedingung via `assume()` nicht erfüllt
    -   Test mit `@Disabled` annotiert

## Anmerkungen zu den Testmethoden

### Pro Testmethode nur eine Testidee =\> wenige Asserts

Pro Testmethode sollte nur eine konkrete Testidee umgesetzt werden, so
dass die Prüfung des Ergebnisses mit möglichst **wenigen** Asserts
stattfinden kann!

Hintergrund: Schlägt ein Assert fehl, wird der Test abgebrochen und der
Rest nicht mehr überprüft ... Dadurch können weitere Fehler maskiert
werden.

### Tests sollen sich selbst erklären

Wenn ich nur die Testmethode lese, sollte ich ungefähr verstehen, was
passiert.

### Tests sollten unabhängig von einander sein

Jeder Test steht für sich und bekommt seine eigene "Welt" (Fixture). Es
sollte keine statische "globalen" Zustände geben, die über mehrere Tests
hinweg verändern werden (außer mit einem extrem gutem Grund, und dann
sehr gut dokumentiert).

Wenn Testmethode A vor Testmethode B laufen muss, weil A einen Zustand
des Testobjekts herstellt, den B braucht, führt das in meiner Erfahrung
**immer** zu Problemen, selbst wenn die Abhängigkeit gut dokumentiert
sind.

Außerdem kann man nicht davon ausgehen, dass die Ausführungsreihenfolge
der Testmethoden deterministisch ist!

### Tests sollten deterministisch sein (keine "flaky tests")

Tests dürfen nicht zufällig mal grün, mal rot sein. Die Berechnung und
Prüfung in Testmethoden sollten sich immer deterministisch verhalten.

-   Kein `Thread.sleep(...)` ohne Not.
-   Kein Abhängigsein von:
    -   aktueller Uhrzeit,
    -   Netzwerk,
    -   externen Services,
    -   Reihenfolge anderer Tests!

### Saubere Assertions: "Act, then assert"

Keine Logik in Assertions (keine Aufrufe, keine komplizierten
Berechnungen). Das macht dem Test schwer lesbar (viele Asserts,
versteckte Bedingungen) und wartbar.

### To "assert" or to "assume"?

-   Mit `Assertions.assert*` werden Testergebnisse geprüft
    -   Test wird ausgeführt
    -   Ergebnis: grün/rot

<!-- -->

-   Mit `Assumptions.assume*` werden Annahmen über den Zustand geprüft
    -   Test wird abgebrochen, wenn Annahme nicht erfüllt (Ergebnis:
        "Ignored")
    -   Prüfen von Vorbedingungen: Ist der Test hier
        ausführbar/anwendbar?

Im JUnit-Kontext nutzen wir `Assumptions.assume*` für das **Überprüfen
von *Annahmen*** (im Sinne von **Vorbedingungen**): Wenn ein
`Assumptions.assume*` fehlschlägt, wird der Testfall abgebrochen bzw.
als "ignoriert" gewertet.

Dagegen setzen wir `Assertions.assert*` für das **Überprüfen der
*Testergebnisse*** ein, d.h. ein fehlschlagendes `Assertions.assert*`
lässt den Testfall "rot" werden.

### Java: "assert"-Keyword

Neben den wohlbekannten `Assertions.assert*`-Methoden aus JUnit gibt es
auch direkt von Java ein etwas verstecktes `assert`-Keyword, mit dem man
Annahmen über Zustände und Werte explizit ausdrücken kann:

``` java
public void foo() {
    String bar = wuppie();
    assert bar != null : "result of wuppie() must not be null";
}
```

Das `assert` besteht aus einer zu prüfenden Bedingung und einem String.
Wenn die Bedingung erfüllt ist, läuft der Code einfach normal weiter.
Anderenfalls wird ein `AssertionError` geworfen mit dem angegebenen
String als Message.

Allerdings sind diese JVM-Assertions per Default **deaktiviert**. Man
muss sie beim Aufruf manuell über die Option `-enableassertions` bzw.
`-ea` (Kurzschreibweise) aktivieren (`java -ea main`)! Dies gilt auch
beim Start über die IDE oder Gradle ...

> [!WARNING]
>
> Wichtig: Die Assertions sind per Default deaktiviert und müssen erst
> manuell aktiviert werden. Außerdem wird bei Verletzung der Bedingung
> eine *unchecked exception* (ein Error) geworfen, der auf einen nicht
> korrigierbaren Programmzustand hindeutet.
>
> 1.  Nutzen Sie das Java-`assert` deshalb nicht als Ersatz für das
>     normale Prüfen von Parametern von `public` Methoden (also Methoden
>     der Schnittstelle, die Ihre Kunden aufrufen).
>
> 2.  Während der Entwicklungszeit kann das Java-`assert` aber ganz
>     nützlich sein, weil Sie so interne Annahmen sichtbar und prüfbar
>     machen (vorausgesetzt, Sie haben `-ea` aktiviert).
>
>     Analog könnte ein Java-`assert` an Stellen eingebaut werden, die
>     eigentlich nicht erreichbar sein sollten (etwa nach einer
>     Dauerschleife oder in einem nicht erreichbaren `default`-Zweig in
>     einem `switch`).
>
> 3.  Bitte das Java-`assert` **nie** in einer JUnit-Testmethode statt
>     der "richtigen" JUnit-`assert*` verwenden!
>
> 4.  Das Java-`assert` ist in einer JUnit-Testmethode **kein** Ersatz
>     für die JUnit-`assume*`-Methoden!

## BDD: "Given - When - Then"-Mantra

Aus dem [Behavior-driven
development](https://en.wikipedia.org/wiki/Behavior-driven_development)
stammt die Strukturierung nach den Punkten "given - when - then" (oft
auch als *"given - when - then"-Mantra* bezeichnet).

Betrachten Sie noch einmal die Schnittstelle der Studi-Klasse:

``` java
public class Studi {
    public String getName();
    public void setName(String name);
    public int getCredits();
    public void addToCredits(int credits);
}
```

Dafür wurde ein Test geschrieben:

``` java
// Before BDD
class StudiTest {
    @Test
    void testAddToCredits() {
        Studi s = new Studi();
        int cps = 2;
        s.addToCredits(cps);
        assertEquals(cps, s.getCredits());
    }
}
```

Dieser Code ist in seiner Absicht nicht sofort verständlich. Es fällt
auf, dass

1.  am Anfang eine Art Setup des Tests vorgenommen wird und das
    Testobjekt initialisiert wird ("**given**").
2.  Dann wird die zu untersuchende Aktion ausgeführt ("**when**"),
    gefolgt von
3.  einem Vergleich des tatsächlichen mit dem erwarteten Ergebnis
    ("**then**").

Diese gedachte Struktur kann (und sollte!) man mit entsprechenden
Kommentaren auch sichtbar machen:

``` java
// With BDD: given-when-then
class StudiTest {
    @Test
    void accumulates_credits_within_upper_limit() {
        // given
        var studi = new Studi();
        var startCredits = 2;

        // when
        studi.addToCredits(startCredits);
        var endCredits = studi.getCredits();

        // then
        assertEquals(startCredits, endCredits);
    }
}
```

In Testframeworks wie [Spock](https://spockframework.org/) oder
[Cucumber](https://cucumber.io/) ist dies sogar bereits in die Sprache
(eine DSL zum Testen) eingebaut! Einen schönen Blog zum Thema finden Sie
hier: [Spock testing framework versus
JUnit](https://blog.codepipes.com/testing/spock-vs-junit.html).

Weiterhin könnte (und sollte) man die implizit getroffenen Annahmen über
das SUT für alle sichtbar machen:

``` java
class StudiTest {
    @Test
    void accumulates_credits_within_upper_limit() {
        // given
        var studi = new Studi();
        var startCredits = 2;
        assumeTrue(s.getCredits() == 0, "initial credits should be 0");

        // when
        studi.addToCredits(startCredits);
        var endCredits = studi.getCredits();

        // then
        assertEquals(startCredits, endCredits);
    }
}
```

Der Test würde ohnehin fehlschlagen, wenn ein neues `Studi`-Objekt mit
einem anderen Wert für die Credits initialisiert würde. Aber so zeigt
das `assume` direkt unsere (bisher) implizite Annahme sichtbar an, und
bei einer Verletzung dieser Annahme würde der Testfall mit einer
entsprechenden Mitteilung nicht ausgeführt.

... Und nun könnte man sich fragen, warum man das Erhöhen von Credits
nur für ein *neues* `Studi`-Objekt testet und nicht auch für andere
Zustände des `Studi`-Objekts? ... =\> Parametrisierte Tests!

## Test-Fixtures: Testübergreifende Konfiguration

``` java
private Studi x;

@BeforeEach
void setUp() { x = new Studi(); }

@Test
void toString_formats_name_and_credits() {
    // Studi x = new Studi();
    assertEquals("Heinz (15cps)", x.toString());
}
```

-   Vor/nach *jedem* einzelnen Test:
    -   **`@BeforeEach`** : wird **vor jeder** Testmethode aufgerufen
    -   **`@AfterEach`** : wird **nach jeder** Testmethode aufgerufen
-   Einmalig (Klassenmethoden):
    -   **`@BeforeAll`** : wird **einmalig** vor allen Tests aufgerufen
        (`static`!)
    -   **`@AfterAll`** : wird **einmalig** nach allen Tests aufgerufen
        (`static`!)

Beispiel für den Einsatz von `@BeforeEach`

Annahme: **alle/viele** Testmethoden brauchen **neues** Objekt `x` vom
Typ `Studi`

``` java
private Studi x;

@BeforeEach
void setUp() {
    x = new Studi("Heinz", 15);
}

@Test
void toString_formats_name_and_credits() {
    // Studi x = new Studi("Heinz", 15);
    assertEquals("Name: Heinz, credits: 15", x.toString());
}

@Test
public void getName_returns_student_name() {
    // Studi x = new Studi("Heinz", 15);
    assertEquals("Heinz", x.getName());
}
```

**Achtung: Übertreiben Sie es nicht mit den Test-Fixtures!**

Häufig findet man die Test-Fixtures (beispielsweise die
`@BeforeEach`-Methode) ganz oben im Code, und wenn man dann weiter unten
an einer Testmethode arbeitet, hat man die Setup-Methode nicht mehr im
Blick ("verstecktes Setup").

Das ist problematisch, weil:

-   Sie beim Lesen einer Testmethode nicht mehr direkt sehen, in welchem
    Zustand die Objekte am Anfang des Tests sind.
-   eine Änderung im Setup **alle** Testmethoden betreffen kann, ohne
    dass Sie das beim Ändern im Kopf haben (starke Kopplung).

Typischerweise entsteht dann schnell ein "One size fits nobody"-Setup:
Es gibt nur *eine* gemeinsame Setup-Methode, die automatisch vor *allen*
Tests aufgerufen wird, und man versucht, dort eine gemeinsame Basis für
sehr unterschiedliche Tests zu schaffen. Diese Methode wird immer größer
und unübersichtlicher.

Deshalb gibt es Strömungen, die vom Gebrauch von Test-Fixtures komplett
abraten: Lieber ein **explizites Setup in der Testmethode**, das Sie
direkt sehen, als ein "magisches" gemeinsames Fixture.

Ich empfehle einen pragmatischen Mittelweg:

-   Nutzen Sie Test-Fixtures (z.B. `@BeforeEach`) **sparsam**.
-   Lagern Sie dort nur die **grundsätzliche, einfache Initialisierung**
    aus, die für alle Tests offensichtlich gleich ist (z.B. das Erzeugen
    eines Service-Objekts).
-   Alles, was über einfache und offensichtliche Dinge hinausgeht,
    gehört in die **einzelnen Testmethoden**. Dort definieren Sie das
    "fachliche Setup" für den jeweiligen Testfall.

Das verletzt an dieser Stelle bewusst das DRY-Prinzip (es kann etwas
Code-Duplikation geben), führt aber zu **besser verständlichen und
wartbaren Tests** und ist beim Testen deshalb akzeptiert.

Wenn die Testmethoden dadurch zu lang werden, können Sie Teile in
**Hilfsmethoden** auslagern, die Sie gezielt in einzelnen Tests
verwenden. Diese Hilfsmethoden werden dann *nicht automatisch* vor jedem
Test aufgerufen (anders als `@BeforeEach`), sondern nur dort, wo Sie sie
explizit einsetzen.

Der Grundsatz aus dem "normalen" Code *"keine globale magische Welt"*
gilt auch für Testcode -- und dort eigentlich sogar noch stärker.

## Test von Exceptions

Traditionelles Testen von Exceptions mit `try` und `catch`:

``` java
@Test
void divisionByZero_throwsArithmeticException() {
    try {
        int i = 0 / 0;
        fail("keine ArithmeticException ausgeloest");
    } catch (ArithmeticException aex) {
        assertNotNull(aex.getMessage());
    } catch (Exception e) {
        fail("falsche Exception geworfen");
    }
}
```

Ab JUnit 5 kann man hier `org.junit.jupiter.api.Assertions.assertThrows`
nutzen. Dabei benötigt man allerdings *Lambda-Ausdrücke* (Verweis auf
spätere VL):

``` java
@Test
void divisionByZero_throwsArithmeticException() {
    assertThrows(java.lang.ArithmeticException.class, () -> { int i = 0 / 0; });
}
```

## Parametrisierte Tests

Manchmal möchte man den selben Testfall mehrfach mit anderen Werten
(Parametern) durchführen.

``` java
class Sum {
    public static int sum(int i, int j) {
        return i + j;
    }
}

class SumTest {
    @Test
    void sum_of_one_and_one_is_two() {
        assertEquals(2, Sum.sum(1, 1));
    }
    // und mit (2,2, 4), (2,2, 5), ...????
}
```

Prinzipiell könnte man dafür entweder in einem Testfall eine Schleife
schreiben, die über die verschiedenen Parameter iteriert. In der
Schleife würde dann jeweils der Aufruf der zu testenden Methode und das
gewünschte Assert passieren. Alternativ könnte man den Testfall
entsprechend oft duplizieren mit jeweils den gewünschten Werten.

Beide Vorgehensweisen haben Probleme: Im ersten Fall würde die Schleife
bei einem Fehler oder unerwarteten Ergebnis abbrechen, ohne dass die
restlichen Tests (Werte) noch durchgeführt würden. Im zweiten Fall
bekommt man eine unnötig große Anzahl an Testmethoden, die bis auf die
jeweiligen Werte identisch sind (Code-Duplizierung).

In JUnit werden [parametrisierte
Tests](https://docs.junit.org/6.0.3/writing-tests/parameterized-classes-and-tests.html)
mit der Annotation `@ParameterizedTest` gekennzeichnet (statt mit
`@Test`).

Mit Hilfe von ["Source
Annotations"](https://docs.junit.org/6.0.3/writing-tests/parameterized-classes-and-tests.html#sources)
wie `@ValueSource` oder `@CsvSource` und anderen können die zu
verwendenden Werte spezifiziert werden. Dabei gibt es eine große
Vielzahl an Möglichkeiten, im Folgenden wird die Spezifikation mit
`@ValueSource` und `@CsvSource` direkt an einer Testmethode gezeigt.

In der Annotation `@ValueSource` kann man ein einfaches Array von Werten
(Strings oder primitive Datentypen) angeben, mit denen der Test
ausgeführt wird. Dazu bekommt die Testmethode einen entsprechenden
passenden Parameter:

``` java
@ParameterizedTest
@ValueSource(strings = {"wuppie", "fluppie", "foo"})
void testWuppie(String candidate) {
    assertTrue(candidate.equals("wuppie"));
}
```

Für das Testen der Summenfunktion könnte man mit `@CsvSource` die
Testfälle so ausdrücken:

``` java
@ParameterizedTest
@CsvSource({
        // s1,  s2,  result
        "0,     0,      0",
        "10,    0,      10",
        "0,     11,     11",
        "-2,    10,     8"
        })
void sum_adds_two_integers(int s1, int s2, int erg) {
    assertEquals(erg, Sum.sum(s1, s2));
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/junit/src/junit6/">Beispiel</a></p>

## Best Practices

1.  Eine Testmethode behandelt exakt eine Idee/ein Szenario (einen
    Testfall). Das bedeutet auch, dass man in der Regel nur ein bis
    wenige `assert*` pro Testmethode benutzt.

    Wenn man verschiedene Ideen in eine Testmethode kombiniert, wird der
    Testfall unübersichtlicher und auch auch schwerer zu warten.
    Außerdem können so leichter versteckte Fehler auftreten: Das erste
    oder zweite oder dritte `assert*` schlägt fehl - und alle dahinter
    kommenden `assert*` werden nicht mehr ausgewertet!

2.  Wenn die selbe Testidee mehrfach wiederholt wird (mit anderen
    Werten), sollte man diese Tests zu einem parametrisierten Test
    zusammenfassen.

    Das erhöht die Lesbarkeit drastisch - und man läuft auch nicht in
    das Problem der Benennung der Testmethoden.

3.  Es wird nur das Verhalten der öffentlichen Schnittstelle getestet,
    nicht die inneren Strukturen einer Klasse oder Methode.

    Es ist verlockend, auch private Methoden zu testen und in den Tests
    auch die Datenstrukturen o.ä. im Blick zu behalten und zu testen.
    Das führt aber zu sehr "zerbrechlichen" (*brittle*) Tests: Sobald
    sich etwas an der inneren Struktur ändert, ohne dass sich das von
    außen beobachtbare Verhalten ändert und also die Klasse/Methode
    immer noch ordnungsgemäß funktioniert, gehen all diese "internen"
    Tests kaputt. Nicht ohne Grund wird in der objektorientierten
    Programmierung mit Kapselung (Klassen, Methoden, ...) gearbeitet.

4.  Von Setup- und Teardown-Methoden sollte eher sparsam Gebrauch
    gemacht werden.

    Normalerweise folgen wir in der objektorientierten Programmierung
    dem DRY-Prinzip ([Don't repeat
    yourself](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself)).
    Entsprechend liegt es nahe, häufig benötigte Elemente in einer
    Setup-Methode zentral zu initialisieren und ggf. in einer
    Teardown-Methode wieder freizugeben.

    Das führt aber speziell bei Unit-Tests dazu, dass die einzelnen
    Testmethoden schwerer lesbar werden: Sie hängen von einer
    gemeinsamen, zentralen Konfiguration ab, die man üblicherweise nicht
    gleichzeitig mit dem Code der Testmethode sehen kann (begrenzter
    Platz auf der Bildschirmseite).

    Wenn nun in einem oder vielleicht mehreren Testfällen der Wunsch
    nach einer leicht anderen Konfiguration auftaucht, muss man die
    gemeinsame Konfiguration entsprechend anpassen bzw. erweitern. Dabei
    muss man dann aber *alle* anderen Testmethoden mit bedenken, die ja
    ebenfalls von dieser Konfiguration abhängen! Das führt in der Praxis
    dann häufig dazu, dass die gemeinsame Konfiguration sehr schnell
    sehr groß und verschachtelt und entsprechend unübersichtlich wird.

    Jede Änderung an dieser Konfiguration kann leicht einen oder mehrere
    Testfälle kaputt machen (man hat ja i.d.R. nie alle Testfälle
    gleichzeitig im Blick), weshalb man hier unbedingt mit passenden
    `assume*` arbeiten muss - aber dann kann man eigentlich auch
    stattdessen die Konfiguration direkt passend für den jeweiligen
    Testfall in der jeweiligen Testmethode erledigen!

5.  Wie immer sollten auch die Namen der Testmethoden klar über ihren
    Zweck Auskunft geben.

    Da Tests oft auch als "ausführbare Dokumentation" betrachtet werden,
    ist eine sinnvolle Benamung besonders wichtig. Oft werden hier
    deshalb Ausnahmen von den üblichen Java-Konventionen erlaubt. Man
    findet häufig das aus dem [Behavior-driven
    development](https://en.wikipedia.org/wiki/Behavior-driven_development)
    bekannte "given - when - then"-Mantra. Siehe auch [The subtle Art of
    Java Test Method
    Naming](https://jonasg.io/posts/subtle-art-of-java-test-method-naming/)
    und auch [Spock testing framework versus
    JUnit](https://blog.codepipes.com/testing/spock-vs-junit.html).

    Der Präfix "test" für Testmethoden wird seit JUnit 4.x nicht mehr
    benötigt, aber dennoch ist es in vielen Projekten Praxis, diesen
    Präfix beizubehalten - damit kann man in der Package-Ansicht in der
    IDE leichter zwischen den "normalen" und den Testmethoden
    unterscheiden. Das ist analog zum Suffix "Test" für die Klassennamen
    der Testklassen ...

Diese Erfahrungen werden ausführlich in ([Winters u. a.
2020](#ref-SWEGoogle), pp. 231-256) diskutiert.

Eine lesenswerte Diskussion von "Anti-Pattern" beim Testen finden Sie im
Blog [Software Testing
Anti-patterns](https://blog.codepipes.com/testing/software-testing-antipatterns.html).

## Wrap-Up

JUnit als Framework für (Unit-) Tests

-   Testmethoden mit Annotation `@Test`
-   `assert` (Testergebnis) vs. `assume` (Testvorbedingung)
-   Aufbau der Testumgebung `@Before`
-   Abbau der Testumgebung `@After`

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> Zum Nachlesen ist die Dokumentation im
> [JUnit-Projekt](https://junit.org/) sehr empfehlenswert. Ebenfalls
> möchte ich Ihnen das Buch meines Kollegen Stephan Kleuker ans Herz
> legen: Kleuker ([2026](#ref-Kleuker2026)).
>
> Das Video von Kevlin Henney [Structure and Interpretation of Test
> Cases (Kevlin Henney, GOTO 2022)](https://youtu.be/MWsk1h8pv2Q) ist
> sehr interessant.
>
> Hier noch weitere lesenswerte Blog-Beiträge zum Thema Testen:
>
> -   [Spock testing framework versus
>     JUnit](https://blog.codepipes.com/testing/spock-vs-junit.html)
> -   [Software Testing
>     Anti-patterns](https://blog.codepipes.com/testing/software-testing-antipatterns.html)
> -   [The subtle Art of Java Test Method
>     Naming](https://jonasg.io/posts/subtle-art-of-java-test-method-naming/)
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann Tests mit JUnit unter Nutzung der Annotation `@Test`
>     erstellen
> -   k3: Ich kann Testergebnisse prüfen
> -   k2: Ich kenne den Unterschied zwischen `assert` und `assume`
> -   k3: Ich kann vor/nach jedem Test bestimmten Code ausführen
> -   k2: Ich habe verstanden, warum `@Before` und `@After` sparsam
>     einzusetzen sind
> -   k3: Ich kann die Ausführung von Tests steuern, beispielsweise
>     Tests ignorieren oder mit zeitlicher Begrenzung ausführen
> -   k3: Ich kann das Auftreten von Exceptions prüfen
> -   k3: Ich kann Tests zu Testsuiten zusammenfassen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Einfache JUnit-Tests I**
>
> Betrachten Sie die folgende einfache (und nicht besonders sinnvolle)
> Klasse `MyList<T>`:
>
> ``` java
> public class MyList<T> {
>     protected final List<T> list = new ArrayList<>();
>
>     public boolean add(T element) { return list.add(element); }
>     public int size() { return list.size(); }
> }
> ```
>
> Schreiben Sie mit Hilfe von JUnit (4.x oder 5.x) einige Unit-Tests für
> die beiden Methoden `MyList<T>#add` und `MyList<T>#size`.
>
> **Einfache JUnit-Tests II**
>
> Betrachten Sie die Methode `String concat(String str)` der Klasse
> `String` aus dem JDK.
>
> Implementieren Sie drei verschiedenartige Unit-Testfälle (inklusive
> der Eingabe- und Rückgabewerte) für diese Methode mit Hilfe von JUnit
> (Version 4.x oder 5.x).
>
> **Setup und Teardown**
>
> Sie haben in den Challenges in "Intro SW-Test" erste JUnit-Tests für
> die Klasse `MyList<T>` implementiert.
>
> Wie müssten Sie Ihre JUnit-Tests anpassen, wenn Sie im obigen Szenario
> Setup- und Teardown-Methoden einsetzen würden?
>
> **Testmethoden**
>
> Betrachten Sie den folgenden Code. Was fällt Ihnen auf?
>
> ``` java
> public class Studi {
>     public int getCredits();
>     public void addToCredits(int credits);
>
>     @Test
>     void testStudi() {
>         Studi s = new Studi();
>         s.addToCredits(2);
>         assertEquals(2, s.getCredits());
>     }
> }
> ```
>
> **Parametrisierte Tests**
>
> Betrachten Sie die folgende einfache Klasse `MyMath`:
>
> ``` java
> public class MyMath {
>     public static String add(String s, int c) {
>         return s.repeat(c);
>     }
> }
> ```
>
> Beim Testen der Methode `MyMath#add` fällt auf, dass man hier immer
> wieder den selben Testfall mit lediglich anderen Werten ausführt - ein
> Fall für parametrisierte Tests.
>
> Schreiben Sie mit Hilfe von JUnit (4.x oder 5.x) einige
> parametrisierte Unit-Tests für die Methode `MyMath#add`.
>
> **Komplexerer Test**
>
> Betrachten Sie die Klasse `ShoppingCart`:
>
> ``` java
> package junit6;
>
> import java.util.HashMap;
> import java.util.Map;
> import java.util.Objects;
>
> public class ShoppingCart {
>
>     public static class Item {
>         private final String id;
>         private final String name;
>         private final int unitPriceInCents;
>
>         public Item(String id, String name, int unitPriceInCents) {
>             this.id = Objects.requireNonNull(id);
>             this.name = Objects.requireNonNull(name);
>             if (unitPriceInCents < 0) {
>                 throw new IllegalArgumentException("Price must not be negative");
>             }
>             this.unitPriceInCents = unitPriceInCents;
>         }
>
>         public String getId() {
>             return id;
>         }
>
>         public int getUnitPriceInCents() {
>             return unitPriceInCents;
>         }
>     }
>
>     private final Map<String, Integer> quantitiesByItemId = new HashMap<>();
>     private final Map<String, Item> itemsById = new HashMap<>();
>     private int percentageDiscount = 0;
>
>     public void addItem(Item item, int quantity) {
>         if (quantity <= 0) {
>             throw new IllegalArgumentException("Quantity must be positive");
>         }
>         itemsById.putIfAbsent(item.getId(), item);
>         quantitiesByItemId.merge(item.getId(), quantity, Integer::sum);
>     }
>
>     public void removeItem(String itemId, int quantity) {
>         Integer current = quantitiesByItemId.get(itemId);
>         if (current == null || quantity <= 0) {
>             return;
>         }
>         int newQuantity = current - quantity;
>         if (newQuantity <= 0) {
>             quantitiesByItemId.remove(itemId);
>         } else {
>             quantitiesByItemId.put(itemId, newQuantity);
>         }
>     }
>
>     public void applyPercentageDiscount(int discount) {
>         if (discount < 0 || discount > 100) {
>             throw new IllegalArgumentException("Discount must be between 0 and 100");
>         }
>         this.percentageDiscount = discount;
>     }
>
>     public int getTotalPriceInCents() {
>         int sum = 0;
>         for (Map.Entry<String, Integer> entry : quantitiesByItemId.entrySet()) {
>             Item item = itemsById.get(entry.getKey());
>             int quantity = entry.getValue();
>             sum += item.getUnitPriceInCents() * quantity;
>         }
>         int discountAmount = sum * percentageDiscount / 100;
>         return sum - discountAmount;
>     }
>
>     public boolean isEmpty() {
>         return quantitiesByItemId.isEmpty();
>     }
>
>     public void clear() {
>         quantitiesByItemId.clear();
>         percentageDiscount = 0;
>     }
> }
> ```
>
> Definieren Sie für diese Klasse verschiedene Testfälle. Achten Sie auf
> die Testidee, die Namen für die Methoden, den inneren Aufbau ("given -
> when - then") und setzen Sie auch gezielt parametrisierte Tests ein.
>
> </details>

------------------------------------------------------------------------

> [!NOTE]
>
> <details >
> <summary><strong>👀 Quellen</strong></summary>
>
> <div id="refs" class="references csl-bib-body hanging-indent">
>
> <div id="ref-Kleuker2026" class="csl-entry">
>
> Kleuker, S. 2026. *Qualitätssicherung durch Softwaretests*. Springer
> Vieweg Wiesbaden. <https://doi.org/10.1007/978-3-658-50232-4>.
>
> </div>
>
> <div id="ref-SWEGoogle" class="csl-entry">
>
> Winters, T., T. Manshreck, und H. Wright. 2020. *Software Engineering
> at Google: Lessons Learned from Programming Over Time*. O'Reilly.
>
> </div>
>
> </div>
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> 243da2a 2026-04-27 junit1: rework all screencasts<br></sub></sup></p></blockquote>
