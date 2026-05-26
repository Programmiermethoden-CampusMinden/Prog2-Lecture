---
author: Carsten Gips (HSBI)
title: Dependency Injection
---

::: tldr
TODO
:::

::: youtube
TODO
:::

# Entkopplung durch Dependency Injection

-   Ausgangspunkt: bekannte Welt
    -   Personen: Studis, Tutor:innen, Lecturer
    -   Prüfungsverwaltungssystem: `Lsf` (Notenabfrage)

::: notes
Ziel der Mini-Lektion: Sie verstehen grundlegend

-   was eine *Dependency* (Abhängigkeit) ist,
-   was *Dependency Injection* bedeutet,
-   warum DI Code testbarer und flexibler macht.

Wir bleiben bewusst bei einem sehr einfachen, konkreten Szenario, das Sie schon
kennen: Studierende fragen ihre Noten im LSF ab.
:::

# Was ist eine "Dependency"?

Begriffsklärung

-   Eine **Dependency** (Abhängigkeit) ist ein Objekt, das eine Klasse **benötigt**,
    um ihre Aufgabe zu erfüllen.
-   Beispiele:
    -   `Student` braucht etwas, das Noten liefert.
    -   Ein:e `Lecturer` braucht vielleicht ein `GradeSubmissionService`.
    -   Ein `Controller` braucht einen `Repository` etc.
-   Typischerweise:
    -   Abhängigkeit ist ein Feld in der Klasse
    -   häufig mit `private final` =\> "Ohne dieses Objekt kann ich meine Arbeit
        nicht machen."

::: notes
Es geht nicht nur um externe Systeme. *Jede Klasse*, von der Ihre Klasse **konkret**
abhängt, ist eine Dependency.

Je weniger Ihre Klasse über die konkrete Implementierung weiß, desto besser: Das
reduziert Kopplung, erhöht Wiederverwendbarkeit und macht Tests einfacher.
:::

Folie 3 - Die "harte" Kopplung ohne DI

Student fragt Note im LSF ab (ohne DI)

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

:::: notes
Problematisch hier:

-   `Student` erzeugt seine Abhängigkeit (`Lsf`) selbst.
-   `Student` ist an konkrete Klasse `Lsf` gebunden.
-   Wenn das Prüfungsverwaltungssystem wechselt (z.B. `Cat`), muss die
    `Student`-Klasse geändert werden.
-   Für Tests können wir `Lsf` nicht einfach ersetzen.

::: tip
Ohne DI: Klasse ruft überall `new` auf und entscheidet selbst, welche konkrete
Implementierung sie benutzt.
:::
::::

# Warum ist Kopplung schlecht?

Nachteile harter Kopplung

-   Hohe Kopplung
    -   Änderung am LSF =\> Änderung an allen Klassen, die `new Lsf()` aufrufen.
-   Schlechte Testbarkeit
    -   Unit Tests müssen mit dem "echten" `Lsf` arbeiten.
    -   Externe Systeme (Datenbank, Netzwerk, ...) machen Tests langsam/fragil.
-   Verletzung von Verantwortlichkeiten
    -   `Student` kümmert sich um:
        -   Fachlogik (Nachricht bauen)
        -   und um die Erzeugung der Abhängigkeit

::: notes
In größeren Projekten führt dieses Muster schnell zu schwer wartbarem Code
("Spaghetti-Code"), Klassen, die "alles wissen und alles können", und zu Problemen
beim Refactoring.

Besonders in CI/CD-Setups wollen wir viele schnelle, zuverlässige Tests. Das
funktioniert nur gut, wenn wir Abhängigkeiten leicht austauschen können.
:::

# Idee von Dependency Injection

Grundprinzip

-   Statt: Klasse erstellt ihre Abhängigkeiten selbst mit `new`.
-   Besser: Klasse bekommt ihre Abhängigkeiten von außen "injiziert".
-   Typische Formen:
    -   Konstruktor-Injektion
    -   Setter-Injektion
    -   Interface-basierte Injektion (z.B. über Frameworks)

::: tip
Don't call `new` all over the place - ask for what you need.
:::

::: notes
In unserem Beispiel:

-   `Student` "fragt" nicht mehr nach `new Lsf()`,
-   sondern erwartet ein Objekt, das Noten liefern kann.

"Injection" bedeutet hier nur:

Jemand anderes (z.B. main, ein Framework, ein DI-Container) steckt die passende
Abhängigkeit in die Klasse hinein, z.B. über den Konstruktor.

Wir starten mit der einfachsten Variante: Konstruktor-Injektion.
:::

# Schritt 1: Abstraktion der Abhängigkeit

Ein Interface für Notenabfragen

``` java
public interface GradeService {
    double getGrade(String matrikelnummer, String modulName);
}
```

Konkrete Implementierung für das LSF:

``` java
public class LsfGradeService implements GradeService {

    private final Lsf Lsf;

    public LsfGradeService(Lsf Lsf) {
        this.Lsf = Lsf;
    }

    @Override
    public double getGrade(String matrikelnummer, String modulName) {
        return Lsf.getGrade(matrikelnummer, modulName);
    }
}
```

::: notes
Wichtig:

-   `GradeService` ist eine Abstraktion (Interface) für "irgendetwas, das Noten
    liefern kann".
-   `LsfGradeService` ist eine konkrete Implementierung davon.
-   Später könnten wir weitere Implementierungen hinzufügen:
    -   `NeuesSystemGradeService`
    -   `OfflineGradeService`
    -   `DummyGradeService` für Demos oder Tests

`Student` muss nur noch `GradeService` kennen - nicht mehr das `Lsf` direkt.
:::

# Schritt 2: Student mit Dependency Injection

Konstruktor-Injektion

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
Hier passiert DI:

-   `Student` erzeugt kein `Lsf` mehr.
-   `Student` verlangt beim Erzeugen: "Gib mir ein `GradeService`-Objekt."
-   Die konkrete Implementierung wird von außen bestimmt.

Vorteil:

-   `Student` ist jetzt nur an die Abstraktion `GradeService` gekoppelt.
-   Wir können in verschiedenen Kontexten unterschiedliche Implementierungen
    injizieren.
:::

# Schritt 3: Verdrahtung im "Composition Root"

Wo kommen die Objekte her?

``` java
public class Main {
    public static void main(String[] args) {
        // Echtes LSF
        Lsf Lsf = new Lsf();
        GradeService gradeService = new LsfGradeService(Lsf);

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
public class Main {
    public static void main(String[] args) {
        GradeService dummy = new DummyGradeService();
        Student chris = new Student("654321", "Chris Beispiel", dummy);
        chris.printGradeFor("Programmieren 2");
    }
}
```

::: notes
Der Ort, an dem Sie alle Objekte "verdrahten" (also erstellen und zusammenstecken),
wird oft **Composition Root** genannt. In kleinen Programmen ist das die
`main`-Methode. In größeren Anwendungen übernehmen das Frameworks/DI-Container (z.B.
Spring).

Wichtig: Die Fachklassen (`Student`, Services, ...) kümmern sich nicht mehr um `new`
ihrer Abhängigkeiten. Sie bleiben "stumpf" in Bezug auf Erzeugung und Konfiguration.
:::

# DI und Testbarkeit (JUnit)

Fake-Implementierung für Tests

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

Ohne DI müssten wir `Student` umbauen/mocken, um das echte `LSF` zu umgehen. Mit DI
ist das Austauschen der Abhängigkeit Standardfall.
:::

# Ausblick: Verbindung zu Frameworks

Was machen Spring & Co.?

-   In größeren Java-Projekten nutzen viele von Ihnen später:
    -   Spring / Spring Boot
    -   Jakarta CDI, Guice, ...
-   Dort gibt es:
    -   DI-Container, die Objekte verwalten,
    -   Annotations wie `@Service`, `@Repository`, `@Controller`,
    -   Konstruktor-Injektion oder Annotationen wie `@Autowired`.

Grundprinzip bleibt aber genau das gleiche wie im Beispiel:

-   Klassen deklarieren, welche Abhängigkeiten sie brauchen.
-   Ein anderer Teil des Systems (Container/Framework) liefert die konkreten
    Implementierungen.

::: notes
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

Kerngedanken von Dependency Injection

-   Eine Klasse soll **nicht selbst** ihre Abhängigkeiten mit new erzeugen.
-   Stattdessen soll sie **deklarieren**, was sie braucht (z.B. im Konstruktor).
-   Abhängigkeiten werden über **Abstraktionen** (Interfaces) modelliert.
-   Konkrete Implementierungen werden von außen "injiziert":
    -   in kleinen Programmen durch Sie selbst (z.B. in `main`),
    -   in größeren durch DI-Container/Frameworks.

Vorteile:

-   Geringere Kopplung
-   Bessere Testbarkeit
-   Einfacherer Austausch von Implementierungen
-   Bessere Wartbarkeit, gerade in größeren Projekten und CI/CD-Umgebungen.

::: notes
Merksätze zum Mitnehmen:

1.  "Don't call new all over the place - ask for what you need."
2.  "Programmiere gegen Interfaces, nicht gegen konkrete Klassen."
3.  "Dependency Injection ist kein Magie-Werkzeug der Frameworks, sondern ein
    simples Prinzip, das Sie auch ohne Framework anwenden können."

Diese Prinzipien werden Ihnen in vielen weiteren Themen begegnen: Design Patterns,
Architecture, Testing, Microservices etc.
:::

::: readings
TODO
:::

::: outcomes
-   k2: Ich kann den Einsatz von Packages in Java erklären
:::

::: challenges
TODO
:::
