---
author: Carsten Gips (HSBI)
title: Dependency Injection
---

::: tldr
Dependency Injection (DI) ist ein Prinzip, mit dem Klassen ihre Abhängigkeiten nicht
selbst mit `new` erzeugen (oder hart kodiert verwenden), sondern sie von außen
übergeben bekommen.

Statt direkt eine konkrete Klasse wie `Lsf` zu verwenden, programmieren wir gegen
eine Abstraktion, zum Beispiel ein Interface wie `GradeService`. Die dazugehörigen
Objekte werden dann nicht mehr in der Klasse selbst erzeugt, sondern von außen
übergeben, etwa per Konstruktor-Injektion. Auf diese Weise ist klar sichtbar, welche
Abhängigkeiten eine Klasse benötigt, und die konkreten Implementierungen werden an
einer zentralen Stelle (zum Beispiel in `main` oder durch ein Framework)
zusammengesteckt. Dadurch sinkt die Kopplung, weil die Fachlogik nicht mehr an ein
bestimmtes System gebunden ist, sondern nur noch an dessen Schnittstelle.

Für Tests ist das besonders wichtig: Nur wenn Abhängigkeiten injiziert werden,
können wir sie durch Stubs oder Mocks ersetzen und echte Unit Tests ohne
I/O-Abhängigkeiten schreiben. So werden Tests schneller, deterministischer und
besser in CI/CD-Pipelines integrierbar. Gleichzeitig verbessert DI die Wartbarkeit
und Erweiterbarkeit des Codes, weil Implementierungen leicht ausgetauscht oder
ergänzt werden können. Frameworks wie Spring automatisieren DI im Hintergrund,
setzen aber genau dieses einfache Grundprinzip um, das wir hier manuell angewendet
haben.

Die Einordnung ist schwierig: Manche betrachten DI als "Pattern", andere sehen es
als Technik für testbaren Code ...
:::

::: youtube
Vorlesung \[[YT](https://youtu.be/gEeDt-FmrGc)\],
\[[HSBI](https://www.hsbi.de/medienportal/video/pr2-dependency-injection/f4f07da39b11d17bc4cbd6c5756592cf)\]
:::

# Motivation aus Tests: Ich kann nicht mocken

::: notes
Wir wollen das Verhalten von `Student#printGradeFor` testen:

-   ohne das echte `Lsf` anzusprechen
-   stattdessen mit einem Fake/Stub für die Noten (eigenes `Lsf`-Testdouble
    injizieren)

Problem: Der Produktivcode sieht bisher so aus:
:::

``` java
public class Lsf {
  public double getGrade(String matrikelnummer, String modulName) {
    return 1.7; // Dummy-Wert (und Dummy-Typ!)
  }
}
```

``` java
public class Student {
  private final String matrikelnummer;
  private final String name;

  public Student(String matrikelnummer, String name) {
    this.matrikelnummer = matrikelnummer; this.name = name;
  }
  public String printGradeFor(String modulName) {
    Lsf lsf = new Lsf(); // Harte Kopplung!
    double grade = lsf.getGrade(matrikelnummer, modulName);
    return String.format("%s hat im Modul %s die Note %s erreicht", name, modulName, grade);
  }
}
```

::: notes
Wichtige Beobachtung:

-   `Student` ruft **selbst** `new Lsf()` auf
-   Als Tester habe ich keine Chance, ein alternatives Objekt einzuschleusen
-   Alle Test-Doubles, die wir in den vorherigen Sitzungen kennengelernt haben,
    bringen nichts, solange der Code sich seine Abhängigkeiten selbst baut.

> "Wir können so viel über Mocks wissen, wie wir wollen: Wenn der Code überall `new`
> ruft, kommen wir mit sauberen Unit Tests nicht weit."
:::

# Was ist eine "Dependency"?

::: notes
Begriffsklärung:
:::

::: center
Eine **Dependency** (Abhängigkeit) ist ein Objekt, das eine Klasse **benötigt**, um
ihre Aufgabe zu erfüllen.
:::

\bigskip

-   Beispiele:
    -   `Student` braucht etwas, das Noten liefert (das `Lsf`)
    -   Ein `Dozent` braucht vielleicht einen `GradeSubmissionService`
    -   Ein `Controller` braucht ein `Repository`

\smallskip

-   Typischerweise:
    -   Eine Abhängigkeit ist ein Feld in der Klasse
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

::: notes
# Warum ist Kopplung schlecht? (speziell für Tests)

-   Schlechte Testbarkeit
    -   Unit Tests müssen mit dem "echten" `Lsf` arbeiten
    -   Externe Systeme (Datenbank, Netzwerk, ...) machen Tests langsam/fragil
    -   Test Doubles lassen sich nicht (oder nur sehr schwer) aufbauen
-   Verletzung von Verantwortlichkeiten
    -   `Student` kümmert sich um:
        -   die Fachlogik (Noten abrufen), und um
        -   die Erzeugung der Abhängigkeit
-   Abhängigkeit von Änderungen
    -   Änderung am `Lsf` kann Änderung an allen Klassen erzwingen, die `new Lsf()`
        aufrufen

In größeren Projekten führt dieses Muster oft schnell zu:

-   schwer wartbarem Code ("Spaghetti-Code"),
-   Klassen, die "alles wissen und alles können",
-   Problemen beim Refactoring.

Aus Sicht von Unit Tests ist der zentrale Punkt:

> Harte Kopplung verhindert echte Isolation der zu testenden Klasse. Wir testen dann
> immer halb das `Lsf` mit, obwohl wir nur `Student` testen wollen.
:::

# Idee von Dependency Injection

Grundprinzip:

-   Statt: Klasse erstellt ihre Abhängigkeiten selbst mit `new`
-   Besser: Klasse bekommt ihre Abhängigkeiten von außen "injiziert"

Typische Formen:

-   Konstruktor-Injektion
-   Setter-Injektion
-   Interface-basierte Injektion (z.B. über Frameworks)

\bigskip

::: tip
Don't call `new` all over the place - ask for what you need.
:::

::: notes
In unserem Beispiel:

-   `Student` soll nicht mehr selbst `new Lsf()` aufrufen.
-   Stattdessen soll er ein Objekt bekommen, das Noten liefern kann.

"Injection" bedeutet hier nur: Jemand anderes (z.B. `main`, ein Framework, ein
DI-Container) steckt die passende Abhängigkeit in die Klasse hinein, z.B. über den
Konstruktor.

Wir betrachten nachfolgend die einfachste Variante: Konstruktor-Injektion.
:::

# Schritt 1: Abstraktion der Abhängigkeit

Wir führen zunächst ein neues Interface für Notenabfragen ein:

``` java
public interface GradeService {
  double getGrade(String matrikelnummer, String modulName);
}
```

:::: notes
::: tip
Ein `double` zur Repräsentation einer Note zu nehmen ist ... nicht sooo toll. Hier
sollte man sich besser was anderes überlegen, beispielsweise ein Enum oder etwas
anderes. Ein `double` kann zwar technisch auch die typischen Noten-Werte wie "1.3"
halten, aber eben auch noch viele andere Werte, die wir hier nicht haben wollen. Um
also später unnötige Checks und Operationen zu vermeiden, sollte man den Datentyp
`Grade` lieber vernünftig modellieren (Enum o.ä.).

Das `double` habe ich hier im Beispielszenario nur genommen, um nicht unnötig von
den wesentlichen Details abzulenken!
:::
::::

Das alte `Lsf` verpacken wir jetzt in einen `GradeService`:

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

-   `GradeService` ist eine Abstraktion (Interface) für "irgendetwas, das Noten
    liefern kann"
-   `LsfGradeService` ist eine konkrete Implementierung davon
-   Später könnten wir weitere Implementierungen hinzufügen:
    -   `NeuesSystemGradeService`
    -   `OfflineGradeService`
    -   `DummyGradeService` für Demos oder Tests

`Student` soll nur noch `GradeService` kennen, nicht mehr direkt das `Lsf`.
:::

# Schritt 2: Student mit Dependency Injection

Nun erweitern wir `Student` und eleminieren das feste `new Lsf()`. Stattdessen
übergeben wir ein Objekt vom Typ `GradeService` im Konstruktor
("Konstruktor-Injektion"):

``` java
public class Student {
  private final String matrikelnummer;
  private final String name;
  private final GradeService gradeService; // Dependency

  // Dependency Injection
  public Student(String matrikelnummer, String name, GradeService gradeService) {
    this.matrikelnummer = matrikelnummer;
    this.name = name;
    this.gradeService = gradeService;
  }

  public String printGradeFor(String modulName) {
    double grade = gradeService.getGrade(matrikelnummer, modulName);
    return String.format("%s hat im Modul %s die Note %s erreicht", name, modulName, grade);
  }
}
```

:::: notes
Hier passiert **Dependency Injection**:

-   `Student` **erzeugt** kein `Lsf` mehr
-   `Student` verlangt beim Erzeugen: "Gib mir ein `GradeService`-Objekt."
-   Die konkrete Implementierung wird von außen bestimmt

Vorteile:

-   `Student` ist nur noch an die Abstraktion `GradeService` gekoppelt
-   Wir können in verschiedenen Kontexten unterschiedliche Implementierungen
    injizieren:
    -   echte LSF-Anbindung
    -   Dummy für eine Demo
    -   Fake für Tests

::: tip
Die Übergabe eines konkreten `GradeService`-Objekts im Konstruktor funktioniert
technisch und löst unser Kopplungsproblem ausreichend gut. Man darf sich aber schon
die Frage stellen, ob ein `Student` wirklich ein festes Feld für einen
`GradeService` haben muss, oder ob man das nicht einfach jeweils dynamisch beim
Aufruf der Methode `Student#printGradeFor` mitgeben könnte ... Auch das wäre
"Dependency Injection" (nur eben keine "Konstruktor-Injektion").
:::
::::

# Schritt 3: Verdrahtung im "Composition Root"

Wo kommen die Objekte her?

``` java
public class Demo {
  public static void main(String[] args) throws InterruptedException {
    // Echtes LSF
    Lsf lsf = new Lsf();
    GradeService gradeService = new LsfGradeService(lsf);

    Student alex = new Student("123456", "Alex Muster", gradeService);
    alex.printGradeFor("Programmieren 2");
  }
}
```

Alternative Implementierung (z.B. Demo/Test):

``` java
public class DummyGradeService implements GradeService {
  @Override
  public double getGrade(String matrikelnummer, String modulName) {
    return 1.0; // immer sehr gut :)
  }
}
```

``` java
public class Demo {
  public static void main(String[] args) throws InterruptedException {
    // Dummy-LSF
    GradeService dummy = new DummyGradeService();
    Student chris = new Student("654321", "Chris Beispiel", dummy);
    chris.printGradeFor("Programmieren 2");
  }
}
```

::: notes
Der Ort, an dem Sie alle Objekte "verdrahten" (also erstellen und zusammenstecken),
wird oft **Composition Root** genannt.

-   In kleinen Programmen ist das die `main`-Methode
-   In größeren Anwendungen übernehmen das Frameworks/DI-Container (z.B. Spring)

Wichtig:

-   Die Fachklassen (`Student`, Services, ...) kümmern sich nicht mehr um `new`
    ihrer Abhängigkeiten
-   Sie bleiben "dumm" in Bezug auf Erzeugung und Konfiguration

Für uns als Tester ist entscheidend: Im Composition Root können wir entscheiden,
welche Implementierung wir verwenden, ohne den Produktivcode von `Student` ändern zu
müssen.
:::

# DI und Testbarkeit (JUnit)

JUnit-Test mit Fake-Implementierung (hier als Lambda-Ausdruck):

``` java
class StudentTest {
  @Test
  void createGradeMessage_usesInjectedGradeService() {
    // given
    GradeService fake = (_, modulName) -> modulName.equals("Programmieren 2") ? 1.3 : 4.0;
    Student student = new Student("123456", "Alex Muster", fake);

    // when
    String message = student.printGradeFor("Programmieren 2");

    // then
    assertEquals("Alex Muster hat im Modul Programmieren 2 die Note 1.3 erreicht", message);
  }
}
```

::: notes
Durch DI:

-   können wir im Test gezielt kontrollierte Implementierungen verwenden (z.B. als
    Lambda-Ausdruck `fake`),
-   sind wir nicht vom echten `Lsf` abhängig,
-   werden Tests schneller, stabiler und einfacher in CI/CD-Pipelines integrierbar.

[Demo Dependency Injection]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/dependency/using_di/Demo.java"}
:::

::: notes
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

-   Klassen deklarieren, welche Abhängigkeiten sie brauchen
-   Ein anderer Teil des Systems (Container/Framework) liefert die konkreten
    Implementierungen

Wichtig fürs Verständnis:

-   Was Sie hier "per Hand" gebaut haben (Interfaces, Konstruktor-Injektion,
    Composition Root), ist das Kernprinzip von Dependency Injection.
-   Frameworks nehmen Ihnen nur die "Fleißarbeit" ab:
    -   Instanzen erzeugen
    -   Abhängigkeiten auflösen
    -   Lebenszyklen verwalten

Wenn Sie das einfache Beispiel verstanden haben, fällt Ihnen der Einstieg in Spring
& Co. wesentlich leichter.
:::

# Wrap-Up

::: notes
Kerngedanken von Dependency Injection:
:::

-   Eine Klasse soll **nicht selbst** ihre Abhängigkeiten mit `new` erzeugen
-   Stattdessen soll sie **deklarieren**, was sie braucht (z.B. im Konstruktor)
-   Abhängigkeiten werden über **Abstraktionen** (Interfaces) modelliert
-   Konkrete Implementierungen werden von außen "injiziert":
    -   in kleinen Programmen durch Sie selbst (z.B. in `main`)
    -   in größeren durch DI-Container/Frameworks

::: notes
Vorteile (insbesondere aus Testsicht):

-   Geringere Kopplung
-   Bessere Testbarkeit (einfache Verwendung von Test Doubles)
-   Einfacherer Austausch von Implementierungen
-   Bessere Wartbarkeit, gerade in größeren Projekten und CI/CD-Umgebungen
:::

:::: notes
::: tip
Merksätze zum Mitnehmen:

1.  "Don't call new all over the place - ask for what you need."
2.  "Programmiere gegen Interfaces, nicht gegen konkrete Klassen."
3.  "Dependency Injection ist kein Magie-Werkzeug der Frameworks, sondern ein
    simples Prinzip, das Sie auch ohne Framework anwenden können."
4.  "Guter Testcode braucht guten Produktivcode: DI ist ein Schlüssel dazu."

Diese Prinzipien werden Ihnen in vielen weiteren Themen begegnen: Design Patterns,
Architektur, Testing, Microservices etc.
:::
::::

::: readings
Der Blog [Dependency Injection Pattern in Java: Boosting Maintainability with Loose
Coupling](https://java-design-patterns.com/patterns/dependency-injection/) ist ganz
nett und hat noch eine schöne Visualisierung.

Auch interessant:

-   [Java Dependency Injection: Design Pattern Tutorial
    (DigitalOcean)](https://www.digitalocean.com/community/tutorials/java-dependency-injection-design-pattern-example-tutorial)
-   [Dependency Injection Made Simple with Java Examples
    (Geekific)](https://youtu.be/GATSXm7WAxU)
:::

::: outcomes
-   k2: Ich kann den Begriff "Dependency Injection" in eigenen Worten erklären.
-   k2: Ich kann anhand eines einfachen Beispiels erläutern, was eine Dependency
    ist.
-   k2: Ich kann erklären, warum harte Kopplung (z.B. `new Lsf()` im Code) Unit
    Tests erschwert, und warum DI Unit Tests erleichtert.
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

-   Der `CurrencyConverter` soll Beträge von einer Währung in eine andere umrechnen
-   Er braucht dafür einen `ExchangeRateProvider`, der die Wechselkurse liefert
-   In "echt" würde dieser Provider vielleicht eine API im Internet aufrufen
-   Für Tests wollen wir aber keinen echten HTTP-Aufruf und keine Zufallswerte

Ausgangsversion ohne DI: `CurrencyConverter` erzeugt sich den Provider selbst:

``` java
public class OnlineExchangeRateProvider {
  public double getRate(String from, String to) {
    // Hier könnte z.B. ein HTTP-Call stehen
    IO.println("Frage Online-Dienst nach Wechselkurs " + from + " -> " + to);
    return 1.1; // Dummy-Wert
  }
}
```

``` java
public class CurrencyConverter {
  public static double convert(String from, String to, double amount) {
    OnlineExchangeRateProvider provider = new OnlineExchangeRateProvider();
    double rate = provider.getRate(from, to);
    return amount * rate;
  }
}
```

**Fragen**:

-   Wie testen wir `convert`, ohne den "Online-Dienst" zu benutzen?
-   Wie testen wir unterschiedliche Kurse, Fehlerszenarien etc.?

**Aufgabe**:

-   Bauen Sie den Code mit Hilfe von Dependency Injection um, so dass er testbar
    wird.

<!--
``` java
public interface ExchangeRateProvider {
    double getRate(String from, String to);
}

public class OnlineExchangeRateProvider implements ExchangeRateProvider {
    @Override
    public double getRate(String from, String to) {
        IO.println("Frage Online-Dienst nach Wechselkurs " + from + " -> " + to);
        return 1.1; // Dummy-Wert
    }
}

public class CurrencyConverter {
    public static double convert(String from, String to, double amount, ExchangeRateProvider provider) {
        double rate = provider.getRate(from, to);
        return amount * rate;
    }
}

public class Main {
    public static void main(String[] args) {
        ExchangeRateProvider provider = new OnlineExchangeRateProvider();

        double result = CurrencyConverter.convert("EUR", "USD", 100.0, provider);
        IO.println("100 EUR sind " + result + " USD");
    }
}
```

``` java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CurrencyConverterTest {
    @Test
    void convert_usesInjectedExchangeRateProvider() {
        // given
        ExchangeRateProvider fake = new FakeExchangeRateProvider();

        // when
        double result = CurrencyConverter.convert("EUR", "USD", 100.0, fake);

        // then
        assertEquals(120.0, result, 0.0001);
    }

    static class FakeExchangeRateProvider implements ExchangeRateProvider {
        @Override
        public double getRate(String from, String to) {
            if (from.equals("EUR") && to.equals("USD"))  return 1.2;
            if (from.equals("USD") && to.equals("EUR"))  return 0.8;
            return 1.0;
        }
    }
}
```
-->
:::
