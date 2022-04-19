---
type: lecture-cg
title: "Refactoring"
menuTitle: "Refactoring"
author: "Carsten Gips (FH Bielefeld)"
weight: 6
readings:
  - key: "Fowler2011"
  - key: "Inden2013"
    comment: "Kapitel 11: Refactorings"
tldr: |
  TODO

  Behebung von **Bad Smells** durch **Refactoring**

  => Änderung der inneren Struktur ohne Beeinflussung äußeren Verhaltens

  *   Verbessert Lesbarkeit, Verständlichkeit, Wartbarkeit
  *   Immer nur kleine Schritte machen
  *   Nach jedem Schritt Testsuite laufen lassen
  *   Katalog von Maßnahmen, beispielsweise _Rename_, _Extract_, _Move_, _Push Up/Pull Down_, u.a.
  *   Unterstützung durch IDEs wie Eclipse, Idea, u.a.

outcomes:
  - k2: "Begriff, Notwendigkeit und Vorgehen des/beim Refactoring"
  - k2: "Bedeutung kleiner Schritte beim Refactoring"
  - k2: "Bedeutung einer sinnvollen Testsuite beim Refactoring"
  - k2: "Refactoring: Nur innere Struktur ändern, nicht äußeres Verhalten!"
  - k3: "Anwendung der wichtigsten Refactoring-Methoden: _Rename_, _Extract_, _Move_, _Push Up/Pull Down_"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet01
youtube:
  - link: ""
    name: "VL "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL "
sketch: true
---


## Definition Refactoring

> Refactoring ist, wenn einem auffällt, daß der Funktionsname `foobar`
> ziemlich bescheuert ist, und man die Funktion in `sinus` umbenennt.
>
> [Quelle: Andreas Bogk, in: Lutz Donnerhacke: "Fachbegriffe der Informatik"  [[(altlasten.lutz.donnerhacke.de)](http://altlasten.lutz.donnerhacke.de/mitarb/lutz/usenet/Fachbegriffe.der.Informatik.html)]{.notes}]{.origin}

\pause
\bigskip
\bigskip
\smallskip

> Refactoring is a change made to the internal structure of software to make it
> easier to understand and cheaper to modify without changing its observable
> behaviour.
>
> [Quelle: [@Fowler2011]]{.origin}

::: notes
**Refactoring:** Änderungen an der [**inneren Struktur**]{.alert} einer Software

*   Beobachtbares (äußeres) Verhalten ändert sich dabei **nicht**
*   Ziel: Verbesserung von Verständlichkeit und Änderbarkeit
:::


## Anzeichen, dass Refactoring jetzt eine gute Idee wäre

*   Code "stinkt" (zeigt/enthält *Bad Smells*)

\smallskip


*   [Nach]{.notes} [@Passig2013]:
    *   Schwer erklärbarer Code

        ::: notes
        Könnten Sie Ihren Code ohne Vorbereitung in der Abgabe erklären?
        In einer Minute? In fünf Minuten? In zehn? Gar nicht? In den letzten beiden
        Fällen sollten Sie definitiv über eine Vereinfachung nachdenken.
        :::

    *   Verständnisprobleme, Erweiterungen

        ::: notes
        Sie grübeln in der Abgabe, was Ihr Code machen sollte? Sie überlegen,
        was Ihr Code bedeutet, um herauszufinden, wo Sie die neue Funktionalität
        anbauen können? Nutzen Sie die (neuen) Erkenntnisse, um den Code leichter
        verständlich zu gestalten.
        :::

    *   Schlechte Nachbarschaft

        ::: notes
        Schlechter Code wird meist von schlechtem Code aufgerufen, da vom selben
        Autor zur selben Zeit geschrieben. Gilt übrigens auch für Fehler: Wo man
        einen Fehler findet, findet man oft noch mehr.
        :::

    *   Falsche Orte

        ::: notes
        Sie suchen nach Codeteilen, finden diese aber nicht, da die sich in
        anderen (falschen?) Stellen/Klassen befinden. Aufräumen: Oft sind die
        intuitiven Erwartungen nicht schlecht.
        :::

\smallskip

*   [@Fowler2011]: "Rule of Three"

    > "Three strikes and you refactor."

    ::: notes
    Wenn Sie sich zum dritten Mal über eine suboptimale Lösung ärgern, dann
    werden Sie sich vermutlich noch öfter darüber ärgern. Jetzt ist der
    Zeitpunkt für eine Verbesserung.
    :::


## Und los ... Standardvorgehen

\bigskip

1.  **Unit Tests** schreiben
    *   Normale und ungültige Eingaben
    *   Rand- und Spezialfälle

2.  **Coding Conventions** einhalten
    *   Sourcecode formatieren
    *   Umbenennungen (Namenskonventionen, Verständlichkeit)

3.  **Clean up**
    *   Unbenutzte Variablen/Methoden/... raus
    *   Alte/falsche Kommentare raus
    *   Duplizierten Code entfernen
    *   Bedingungen (zb. in `if`) vereinfachen
    *   Bei Bedarf erklärende Kommentare

4.  **Refactoring-Katalog** anwenden [(Das ist das eigentliche Refactoring!)]{.notes}

\bigskip

Letzte Frage: Haben Sie die [fragliche Codestelle auch wirklich verstanden]{.alert}?!

::: notes
### Hinweise zum Vorgehen beim Refactoring:

*   Kleine Schritte: immer nur **eine** Änderung zu einer Zeit
*   Nach jedem Refactoring-Schritt Testsuite laufen lassen
    *   Nächster Refactoring-Schritt erst, wenn alle Tests wieder "grün"
*   Versionskontrolle nutzen: **Jeden** Schritt **einzeln** committen
:::

[Beispiel: refactoring.*]{.bsp}


::: notes
## Formatieren Sie Ihren Code mit der IDE

*   Eclipse: "`Project > Properties > Java Code Style > Formatter`":
    Coding-Style einstellen/einrichten
*   Code markieren, "`Source > Format`"
*   Komplettes Aufräumen: "`Source > Clean Up`" (Formatierung, Importe, Annotationen, ...)
    Kann auch so eingestellt werden, dass ein Clean Up immer beim Speichern
    ausgeführt wird!

IntelliJ verfügt über ähnliche Fähigkeiten.


Wer direkt den [Google Java Style](https://google.github.io/styleguide/javaguide.html) nutzt, kann auch den dazu
passenden Formatter von Google einsetzen: [google-java-format](https://github.com/google/google-java-format).
Diesen kann man entweder als Plugin für IntelliJ/Eclipse einsetzen oder als Stand-alone-Tool
(Kommandozeile oder Build-Skripte) aufrufen. Wenn man sich noch einen entsprechenden
Git-Hook definiert, wird vor jedem Commit der Code entsprechend den Richtlinien formatiert :)

**Achtung**: Zumindest in Eclipse gibt es mehrere Stellen, wo ein Code-Style eingestellt
werden kann (Clean Up, Formatter/Profile, Formatter/Implementation). Diese sollten dann jeweils
auf den selben Style eingestellt werden, sonst gibt es u.U. lustige Effekte, da beim Speichern
ein anderer Style angewendet wird als beim Clean Up oder beim Format Source ... Analog sollte
man auch die entsprechenden CheckStyle-Regeln passend einstellen, sonst bekommt man Warnungen
angezeigt, die man durch ein automatisches Formatieren nicht beheben kann.

[Beispiel: Konfiguration Formatter (`Source > Format`, `Source > Clean Up`)]{.bsp}
:::


::: notes
## Refactoring-Methode: Rename Method/Class/Field

### Motivation

Name einer Methode/Klasse/Attributs erklärt nicht ihren Zweck.

### Durchführung

Name selektieren, "`Refactor > Rename`"

### Anschließend ggf. prüfen

Aufrufer? Superklassen?

### Beispiel

```java
public String getTeN() {}
```

wird zu

```java
public String getTelefonNummer() {}
```
:::


::: notes
## Refactoring-Methode: Encapsulate Field

### Motivation

Sichtbarkeit von Attributen reduzieren.

### Durchführung

Attribut selektieren, "`Refactor > Encapsulate Field`"

### Anschließend ggf. prüfen

Superklassen? Referenzen? (Neue) JUnit-Tests?

### Beispiel

```java
int cps;

public void printDetails() {
    System.out.println("Credits: "+cps);
}
```

wird zu

```java
private int cps;

int getCps() { return cps; }
void setCps(int cps) {  this.cps = cps;  }

public void printDetails() {
    System.out.println("credits: "+getCps());
}
```
:::


::: notes
## Refactoring-Methode: Extract Method/Class

### Motivation

*   Codefragment stellt eigenständige Methode dar
*   "Überschriften-Code"
*   Code-Duplizierung
*   Code ist zu "groß"
*   Klasse oder Methode erfüllt unterschiedliche Aufgaben

### Durchführung

Codefragment selektieren, "`Refactor > Extract Method`" bzw. "`Refactor > Extract Class`"

### Anschließend ggf. prüfen

*   Aufruf der neuen Methode? Nutzung der neuen Klasse?
*   Neue JUnit-Tests nötig? Veränderung bestehender Tests nötig?
*   Speziell bei Methoden:
    *   Nutzung lokaler Variablen: Übergabe als Parameter!
    *   Veränderung lokaler Variablen: Rückgabewert in neuer Methode
        und Zuweisung bei Aufruf; evtl. neue Typen nötig!

### Beispiel

```java
public void printInfos() {
    printHeader();
    // Details ausgeben
    System.out.println("name:    "+name);
    System.out.println("credits: "+cps);
}
```

wird zu

```java
public void printInfos() {
    printHeader();
    printDetails();
}
private void printDetails() {
    System.out.println("name:    "+name);
    System.out.println("credits: "+cps);
}
```
:::


::: notes
## Refactoring-Methode: Move Method

### Motivation

Methode nutzt (oder wird genutzt von) mehr Eigenschaften einer
fremden Klasse als der eigenen Klasse.

### Durchführung

Methode selektieren, "`Refactor > Move`"
(ggf. "Keep original method as delegate to moved method" aktivieren)

### Anschließend ggf. prüfen

*   Aufruf der neuen Methode (Delegation)?
*   Neue JUnit-Tests nötig? Veränderung bestehender Tests nötig?
*   Nutzung lokaler Variablen: Übergabe als Parameter!
*   Veränderung lokaler Variablen: Rückgabewert in neuer Methode
    und Zuweisung bei Aufruf; evtl. neue Typen nötig!

### Beispiel

```java
public class Kurs {
    int cps;
    String descr;
}

public class Studi extends Person {
    String name;
    int cps;
    Kurs kurs;

    public void printKursInfos() {
        System.out.println("Kurs:    "+kurs.descr);
        System.out.println("Credits: "+kurs.cps);
    }
}
```

wird zu

```java
public class Kurs {
    int cps;
    String descr;

    public void printKursInfos() {
        System.out.println("Kurs:    "+descr);
        System.out.println("Credits: "+cps);
    }
}

public class Studi extends Person {
    String name;
    int cps;
    Kurs kurs;

    public void printKursInfos() {
        kurs.printKursInfos();
    }
}
```
:::


::: notes
## Refactoring-Methode: Pull Up, Push Down (Field, Method)

### Motivation

*   Attribut/Methode nur für die Oberklasse relevant: **Pull Up**
*   Subklassen haben identische Attribute/Methoden: **Pull Up**
*   Attribut/Methode nur für eine Subklasse relevant: **Push Down**

### Durchführung

Name selektieren, "`Refactor > Pull Up`" oder "`Refactor > Push Down`"

### Anschließend ggf. prüfen

Referenzen/Aufrufer? JUnit-Tests?

### Beispiel

```java
public class Person { }

public class Studi extends Person {
    String name;
    public void printDetails() {
        System.out.println("name:    "+name);
    }
}
```

wird zu

```java
public class Person { protected String name; }

public class Studi extends Person {
    public void printDetails() {
        System.out.println("name:    "+name);
    }
}
```
:::


## Wrap-Up

Behebung von **Bad Smells** durch **Refactoring**

=> Änderung der inneren Struktur ohne Beeinflussung äußeren Verhaltens

*   Verbessert Lesbarkeit, Verständlichkeit, Wartbarkeit
*   Immer nur kleine Schritte machen
*   Nach jedem Schritt Testsuite laufen lassen
*   Katalog von Maßnahmen, beispielsweise _Rename_, _Extract_, _Move_, _Push Up/Pull Down_, ...
*   Unterstützung durch IDEs wie Eclipse, Idea, ...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
