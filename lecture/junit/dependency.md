---
author: Carsten Gips (HSBI)
title: Dependency Injection
---

::: tldr
Dependency Injection (DI) ist ein Prinzip, mit dem Klassen ihre Abhängigkeiten nicht
selbst mit `new` erzeugen, sondern sie von außen übergeben bekommen.

Statt direkt eine konkrete Klasse wie `Lsf` zu verwenden, programmieren wir gegen
eine Abstraktion, zum Beispiel ein Interface wie `GradeService`. Die dazugehörigen
Objekte werden dann nicht mehr in der Klasse selbst erzeugt, sondern von außen
übergeben, etwa per Konstruktor-Injektion. Auf diese Weise ist klar sichtbar, welche
Abhängigkeiten eine Klasse benötigt, und die konkreten Implementierungen werden an
einer zentralen Stelle (zum Beispiel in `main` oder durch ein Framework)
zusammengesteckt. Dadurch sinkt die Kopplung, weil die Fachlogik nicht mehr an ein
bestimmtes System gebunden ist, sondern nur noch an dessen Schnittstelle.

Für Tests ist das besonders wichtig: Nur wenn Abhängigkeiten injiziert werden,
können wir sie durch Fakes, Stubs oder Mocks ersetzen und echte Unit Tests ohne
I/O-Abhängigkeiten schreiben. So werden Tests schneller, deterministischer und
besser in CI/CD-Pipelines integrierbar. Gleichzeitig verbessert DI die Wartbarkeit
und Erweiterbarkeit des Codes, weil Implementierungen leicht ausgetauscht oder
ergänzt werden können. Frameworks wie Spring automatisieren DI im Hintergrund,
setzen aber genau dieses einfache Grundprinzip um, das wir hier manuell angewendet
haben.
:::

::: youtube
TODO
:::

# Motivation aus Tests: Warum stoßen wir auf DI?

-   Ausgangspunkt: bekannte Welt
    -   Personen: Studenten, Tutoren, Dozenten
    -   Prüfungsverwaltungssystem: `Lsf` (Notenabfrage)
-   Bisher:
    -   JUnit-Basics (Arrange -- Act -- Assert)
    -   Was ist ein Unit Test? (Isolation, Determinismus, keine echten
        I/O-Abhängigkeiten)
    -   Test Doubles: Stubs, Fakes, Mocks

Frage: Warum ist es manchmal so schwer, gute Unit Tests zu schreiben, obwohl wir
JUnit und Mocks kennen?

::: notes
Ziel der Mini-Lektion:

-   an ein reales Test-Problem anknüpfen,
-   die Ursache als Strukturproblem im Code identifizieren (harte Kopplung),
-   Dependency Injection als Lösung für testbaren Code kennenlernen.

Wichtiger Punkt für die Dramaturgie: Wir starten bewusst aus der Test-Perspektive.
DI ist hier nicht ein abstraktes Architekturthema, sondern eine sehr konkrete
Antwort auf ein Testproblem.
:::

# Problem: Ich kann nicht mocken

Wir wollen testen:

-   Klasse `Student`
-   ohne das echte `Lsf` anzusprechen
-   mit einem Fake/Stub für die Noten

Wunsch im Test:

-   `Student` benutzen
-   eigenes `GradeService`-Testdouble injizieren
-   Note kontrollieren

Problem: Der Produktivcode sieht bisher so aus:

``` java
public class Lsf {

    public double getGrade(String matrikelnummer, String modulName) {
        System.out.println("Frage LSF nach Note für " + matrikelnummer
                            + " im Modul " + modulName);
        return 1.7; // Dummy-Wert
    }
}
```

``` java
public class Student {

    private final String matrikelnummer;
    private final String name;

    public Student(String matrikelnummer, String name) {
        this.matrikelnummer = matrikelnummer;
        this.name = name;
    }

    public void printGradeFor(String modulName) {
        // Harte Kopplung
        Lsf lsf = new Lsf();
        double grade = lsf.getGrade(matrikelnummer, modulName);
        System.out.println(name + " hat im Modul " + modulName
                            + " die Note " + grade);
    }
}
```

::: notes
Wichtige Beobachtung:

-   `Student` ruft selbst `new Lsf()` auf.
-   Als Tester habe ich keine Chance, ein alternatives Objekt einzuschleusen.
-   Alle Test-Doubles, die wir in den vorherigen Sitzungen kennengelernt haben,
    bringen nichts, solange der Code sich seine Abhängigkeiten selbst baut.

Formulieren Sie das ruhig explizit im Plenum:

> "Wir können so viel über Mocks wissen, wie wir wollen: Wenn der Code überall `new`
> ruft, kommen wir mit sauberen Unit Tests nicht weit."

An diesem Punkt ist die Bühne bereitet, um DI als Lösung einzuführen.
:::

# Was ist eine 'Dependency'?

Begriffsklärung:

-   Eine **Dependency** (Abhängigkeit) ist ein Objekt, das eine Klasse **benötigt**,
    um ihre Aufgabe zu erfüllen.
-   Beispiele:
    -   `Student` braucht etwas, das Noten liefert.
    -   Ein `Dozent` braucht vielleicht einen `GradeSubmissionService`.
    -   Ein `Controller` braucht ein `Repository`.
-   Typischerweise:
    -   Abhängigkeit ist ein Feld in der Klasse
    -   häufig mit `private final` =\> "Ohne dieses Objekt kann ich meine Arbeit
        nicht machen."

::: notes
Es geht nicht nur um externe Systeme. Jede Klasse, von der Ihre Klasse konkret
abhängt, ist eine Dependency.

Je weniger Ihre Klasse über die konkrete Implementierung weiß, desto besser:

-   reduziert Kopplung
-   erhöht Wiederverwendbarkeit
-   macht Tests einfacher

Unser aktuelles Problem mit `Student` und `Lsf` ist ein Beispiel für eine ungünstig
gehandhabte Dependency.
:::

# Warum ist Kopplung schlecht? (speziell für Tests)

Nachteile harter Kopplung:

-   Hohe Kopplung
    -   Änderung am LSF =\> Änderung an allen Klassen, die `new Lsf()` aufrufen.
-   Schlechte Testbarkeit
    -   Unit Tests müssen mit dem 'echten' `Lsf` arbeiten.
    -   Externe Systeme (Datenbank, Netzwerk, ...) machen Tests langsam/fragil.
    -   Test Doubles lassen sich nicht einschleusen.
-   Verletzung von Verantwortlichkeiten
    -   `Student` kümmert sich um:
        -   Fachlogik (Nachricht bauen)
        -   und um die Erzeugung der Abhängigkeit

::: notes
In größeren Projekten führt dieses Muster schnell zu:

-   schwer wartbarem Code ('Spaghetti-Code'),
-   Klassen, die 'alles wissen und alles können',
-   Problemen beim Refactoring.

Aus Sicht von Unit Tests ist der zentrale Punkt:

> Harte Kopplung verhindert echte Isolation der Unit. Wir testen dann immer halb Lsf
> mit, obwohl wir nur Student testen wollen.
:::

# Idee von Dependency Injection

Grundprinzip:

-   Statt: Klasse erstellt ihre Abhängigkeiten selbst mit `new`.
-   Besser: Klasse bekommt ihre Abhängigkeiten von außen 'injiziert'.

Typische Formen:

-   Konstruktor-Injektion
-   Setter-Injektion
-   Interface-basierte Injektion (z. B. über Frameworks)

::: tip
Don't call `new` all over the place - ask for what you need.
:::

::: notes
In unserem Beispiel:

-   `Student` soll nicht mehr selbst `new Lsf()` aufrufen.
-   Stattdessen soll er ein Objekt bekommen, das Noten liefern kann.

'Injection' bedeutet hier nur:

-   Jemand anderes (z. B. `main`, ein Framework, ein DI-Container) steckt die
    passende Abhängigkeit in die Klasse hinein, z. B. über den Konstruktor.

Wir starten mit der einfachsten und testfreundlichsten Variante:
Konstruktor-Injektion.
:::

# Schritt 1: Abstraktion der Abhängigkeit

Ein Interface für Notenabfragen:

``` java
public interface GradeService {
    double getGrade(String matrikelnummer, String modulName);
}
```

Konkrete Implementierung für das LSF:

``` java
public class LsfGradeService implements GradeService {

    private final Lsf lsf;

    public LsfGradeService(Lsf lsf) {
        this.lsf = lsf;
    }

    @Override
    public double getGrade(String matrikelnummer, String modulName) {
        return lsf.getGrade(matrikelnummer, modulName);
    }
}
```

::: notes
Wichtig:

-   `GradeService` ist eine Abstraktion (Interface) für 'irgendetwas, das Noten
    liefern kann'.
-   `LsfGradeService` ist eine konkrete Implementierung davon.
-   Später könnten wir weitere Implementierungen hinzufügen:
    -   `NeuesSystemGradeService`
    -   `OfflineGradeService`
    -   `DummyGradeService` für Demos oder Tests

`Student` soll nur noch `GradeService` kennen, nicht mehr direkt das `Lsf`.
:::

# Schritt 2: Student mit Dependency Injection

Konstruktor-Injektion:

``` java
public class Student {

    private final String matrikelnummer;
    private final String name;
    private final GradeService gradeService; // Dependency

    // Dependency Injection
    public Student(String matrikelnummer, String name,
                    GradeService gradeService) {
        this.matrikelnummer = matrikelnummer;
        this.name = name;
        this.gradeService = gradeService;
    }

    public void printGradeFor(String modulName) {
        double grade = gradeService.getGrade(matrikelnummer, modulName);
        System.out.println(name + " hat im Modul " + modulName
                            + " die Note " + grade);
    }
}
```

::: notes
Hier passiert Dependency Injection:

-   `Student` erzeugt kein `Lsf` mehr.
-   `Student` verlangt beim Erzeugen: 'Gib mir ein `GradeService`-Objekt.'
-   Die konkrete Implementierung wird von außen bestimmt.

Vorteile:

-   `Student` ist nur noch an die Abstraktion `GradeService` gekoppelt.
-   Wir können in verschiedenen Kontexten unterschiedliche Implementierungen
    injizieren:
    -   echte LSF-Anbindung
    -   Dummy für eine Demo
    -   Fake für Tests
:::

# Schritt 3: Verdrahtung im 'Composition Root'

Wo kommen die Objekte her?

``` java
public class Main {
    public static void main(String[] args) {
        // Echtes LSF
        Lsf lsf = new Lsf();
        GradeService gradeService = new LsfGradeService(lsf);

        Student alex = new Student("123456", "Alex Muster", gradeService);
        alex.printGradeFor("Programmieren 2");
    }
}
```

Alternative Implementierung (z. B. Demo/Test):

``` java
public class DummyGradeService implements GradeService {

    @Override
    public double getGrade(String matrikelnummer, String modulName) {
        return 1.0; // immer sehr gut :)
    }
}
```

``` java
public class Main {
    public static void main(String[] args) {
        GradeService dummy = new DummyGradeService();
        Student chris = new Student("654321", "Chris Beispiel", dummy);
        chris.printGradeFor("Programmieren 2");
    }
}
```

::: notes
Der Ort, an dem Sie alle Objekte 'verdrahten' (also erstellen und zusammenstecken),
wird oft **Composition Root** genannt.

-   In kleinen Programmen ist das die `main`-Methode.
-   In größeren Anwendungen übernehmen das Frameworks/DI-Container (z. B. Spring).

Wichtig:

-   Die Fachklassen (`Student`, Services, ...) kümmern sich nicht mehr um `new`
    ihrer Abhängigkeiten.
-   Sie bleiben 'stumpf' in Bezug auf Erzeugung und Konfiguration.

Für uns als Tester ist entscheidend: Im Composition Root können wir entscheiden,
welche Implementierung wir verwenden, ohne den Produktivcode von `Student` ändern zu
müssen.
:::

# DI und Testbarkeit (JUnit)

Fake-Implementierung für Tests:

``` java
public class FakeGradeService implements GradeService {
    @Override
    public double getGrade(String matrikelnummer, String modulName) {
        if (modulName.equals("Programmieren 2")) {
            return 1.3;
        }
        return 4.0;
    }
}
```

Leicht angepasster `Student` für Tests:

``` java
public class Student {
    // ... wie zuvor

    public String createGradeMessage(String modulName) {
        double grade = gradeService.getGrade(matrikelnummer, modulName);
        return name + " hat im Modul " + modulName + " die Note " + grade;
    }
}
```

JUnit-Test:

``` java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void createGradeMessage_usesInjectedGradeService() {
        GradeService fake = new FakeGradeService();
        Student student = new Student("123456", "Alex Muster", fake);

        String message = student.createGradeMessage("Programmieren 2");

        assertEquals("Alex Muster hat im Modul Programmieren 2 die Note 1.3",
                        message);
    }
}
```

::: notes
Durch DI:

-   können wir im Test gezielt kontrollierte Implementierungen verwenden
    (`FakeGradeService`),
-   sind wir nicht vom echten `Lsf` abhängig,
-   werden Tests schneller, stabiler und einfacher in CI/CD-Pipelines integrierbar.

Wichtiger didaktischer Punkt:

-   Vor DI: 'Ich würde gern mocken, aber ich kann nicht, weil überall `new` steht.'
-   Nach DI: 'Ich kann problemlos ein Testdouble injizieren.'

DI ist damit ein Enabler für gutes Testdesign:

-   klare Unit-Grenzen
-   Isolation durch Test Doubles
-   saubere Arrange--Act--Assert-Tests
:::

# Ausblick: Verbindung zu Frameworks

Was machen Spring & Co.?

-   In größeren Java-Projekten nutzen viele von Ihnen später:
    -   Spring / Spring Boot
    -   Jakarta CDI, Guice, ...
-   Dort gibt es:
    -   DI-Container, die Objekte verwalten,
    -   Annotations wie `@Service`, `@Repository`, `@Controller`,
    -   Konstruktor-Injektion oder Annotations wie `@Autowired`.

Grundprinzip bleibt aber genau das gleiche wie im Beispiel:

-   Klassen deklarieren, welche Abhängigkeiten sie brauchen.
-   Ein anderer Teil des Systems (Container/Framework) liefert die konkreten
    Implementierungen.

::: notes
Wichtig fürs Verständnis:

-   Was Sie hier 'per Hand' gebaut haben (Interfaces, Konstruktor-Injektion,
    Composition Root), ist das Kernprinzip von Dependency Injection.
-   Frameworks nehmen Ihnen nur die 'Fleißarbeit' ab:
    -   Instanzen erzeugen
    -   Abhängigkeiten auflösen
    -   Lebenszyklen verwalten

Wenn Sie das einfache Beispiel verstanden haben, fällt Ihnen der Einstieg in Spring
& Co. wesentlich leichter.

Betonen Sie ruhig noch einmal die Verbindung zu Tests:

-   In Spring-Tests ist es Standard, Services durch Mocks/Fakes zu ersetzen.
-   Das funktioniert nur, weil der Code konsequent DI verwendet.
:::

# Wrap-Up

Kerngedanken von Dependency Injection:

-   Eine Klasse soll **nicht selbst** ihre Abhängigkeiten mit `new` erzeugen.
-   Stattdessen soll sie **deklarieren**, was sie braucht (z. B. im Konstruktor).
-   Abhängigkeiten werden über **Abstraktionen** (Interfaces) modelliert.
-   Konkrete Implementierungen werden von außen 'injiziert':
    -   in kleinen Programmen durch Sie selbst (z. B. in `main`),
    -   in größeren durch DI-Container/Frameworks.

Vorteile (insbesondere aus Testsicht):

-   Geringere Kopplung
-   Bessere Testbarkeit (einfache Verwendung von Test Doubles)
-   Einfacherer Austausch von Implementierungen
-   Bessere Wartbarkeit, gerade in größeren Projekten und CI/CD-Umgebungen

::: notes
Merksätze zum Mitnehmen:

1.  'Don't call new all over the place - ask for what you need.'
2.  'Programmiere gegen Interfaces, nicht gegen konkrete Klassen.'
3.  'Dependency Injection ist kein Magie-Werkzeug der Frameworks, sondern ein
    simples Prinzip, das Sie auch ohne Framework anwenden können.'
4.  'Guter Testcode braucht guten Produktivcode: DI ist ein Schlüssel dazu.'

Diese Prinzipien werden Ihnen in vielen weiteren Themen begegnen: Design Patterns,
Architektur, Testing, Microservices etc.
:::

::: readings
TODO
:::

::: outcomes
-   k2: Ich kann den Begriff Dependency Injection in eigenen Worten erklären.
-   k2: Ich kann anhand eines einfachen Beispiels erläutern, was eine Dependency
    ist.
-   k2: Ich kann erklären, warum harte Kopplung (z.B. `new Lsf()` im Code) Unit
    Tests erschwert, und warum DI Unit Tests erleichtert..
-   k2: Ich kann den Zusammenhang zwischen Dependency Injection und Testbarkeit
    (Mocks/Fakes) beschreiben.
-   k3: Ich kann eine bestehende Java-Klasse so umgestalten, dass ihre
    Abhängigkeiten per Konstruktor-Injektion übergeben werden.
-   k3: Ich kann für eine konkrete Abhängigkeit ein Interface entwerfen und eine
    passende Implementierung schreiben.
-   k3: Ich kann eine Klasse so umbauen, dass sie statt einer konkreten
    Implementierung nur noch ein Interface verwendet.
-   k3: Ich kann mithilfe von Dependency Injection einen Unit Test schreiben, der
    ein Testdouble (z.B. `FakeGradeService`) verwendet.
:::

::: challenges
**CurrencyConverter + ExchangeRateProvider**

-   `CurrencyConverter` soll Beträge von einer Währung in eine andere umrechnen.
-   Er braucht dafür einen `ExchangeRateProvider`, der die Wechselkurse liefert.
-   In "echt" würde dieser Provider vielleicht eine API im Internet aufrufen.
-   Für Tests wollen wir aber keinen echten HTTP-Aufruf und keine Zufallswerte.

1.  Version ohne DI (Problemfall) `CurrencyConverter` erzeugt sich den Provider
    selbst:

    ``` java
    public class OnlineExchangeRateProvider {

        public double getRate(String from, String to) {
            // Hier könnte z. B. ein HTTP-Call stehen
            System.out.println("Frage Online-Dienst nach Wechselkurs " + from + " -> " + to);
            return 1.1; // Dummy-Wert
        }
    }
    ```

    ``` java
    public class CurrencyConverter {

        public double convert(String from, String to, double amount) {
            OnlineExchangeRateProvider provider = new OnlineExchangeRateProvider();
            double rate = provider.getRate(from, to);
            return amount * rate;
        }
    }
    ```

    Diskussion mit den Studis:

    -   Wie testen wir `convert`, ohne den "Online-Dienst" zu benutzen?
    -   Wie testen wir unterschiedliche Kurse, Fehlerszenarien etc.?

    Damit haben Sie wieder den bekannten Schmerzpunkt: "Ich kann nicht mocken, weil
    der Code seine Abhängigkeiten selbst erzeugt."

2.  Schritt: Abstraktion und DI Interface für den Kursdienst:

    ``` java
    public interface ExchangeRateProvider {
        double getRate(String from, String to);
    }
    ```

    Konkrete Online-Variante:

    ``` java
    public class OnlineExchangeRateProvider implements ExchangeRateProvider {

        @Override
        public double getRate(String from, String to) {
            System.out.println("Frage Online-Dienst nach Wechselkurs " + from + " -> " + to);
            return 1.1; // Dummy-Wert
        }
    }
    ```

    `CurrencyConverter` mit Konstruktor-Injektion:

    ``` java
    public class CurrencyConverter {

        private final ExchangeRateProvider provider;

        public CurrencyConverter(ExchangeRateProvider provider) {
            this.provider = provider;
        }

        public double convert(String from, String to, double amount) {
            double rate = provider.getRate(from, to);
            return amount * rate;
        }
    }
    ```

    "Verdrahtung" im Main:

    ``` java
    public class Main {
        public static void main(String[] args) {
            ExchangeRateProvider provider = new OnlineExchangeRateProvider();
            CurrencyConverter converter = new CurrencyConverter(provider);

            double result = converter.convert("EUR", "USD", 100.0);
            System.out.println("100 EUR sind " + result + " USD");
        }
    }
    ```

3.  Test mit Fake-Provider

    Fake-Implementierung für Tests:

    ``` java
    public class FakeExchangeRateProvider
    implements ExchangeRateProvider {

         @Override
         public double getRate(String from, String to) {
             if (from.equals("EUR") && to.equals("USD")) {
                 return 1.2;
             }
             if (from.equals("USD") && to.equals("EUR")) {
                 return 0.8;
             }
             return 1.0;
         }

    }
    ```

    JUnit-Test:

    ``` java
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import org.junit.jupiter.api.Test;

    class CurrencyConverterTest {

        @Test
        void convert_usesInjectedExchangeRateProvider() {
            ExchangeRateProvider fake = new FakeExchangeRateProvider();
            CurrencyConverter converter = new CurrencyConverter(fake);

            double result = converter.convert("EUR", "USD", 100.0);

            assertEquals(120.0, result, 0.0001);
        }
    }
    ```
:::
