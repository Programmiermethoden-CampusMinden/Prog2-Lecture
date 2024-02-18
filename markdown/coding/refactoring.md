---
archetype: lecture-cg
title: "Refactoring"
linkTitle: "Refactoring"
author: "Carsten Gips (HSBI)"
weight: 6
readings:
  - key: "Fowler2011"
  - key: "Inden2013"
    comment: "Kapitel 11: Refactorings"
tldr: |
  Refactoring bedeutet Änderung der inneren Struktur des Codes ohne Beeinflussung äußeren Verhaltens.

  Mit Hilfe von Refactoring kann man Code Smells beheben, und Lesbarkeit, Verständlichkeit und Wartbarkeit
  von Software verbessern.

  Es ist wichtig, immer nur einzelne Schritte zu machen und anschließend die Testsuite laufen zu lassen,
  damit nicht versehentlich Fehler oder Verhaltensänderungen beim Refactoring eingebaut werden.

  Prinzipiell kann man Refactoring manuell mit Search&Replace durchführen, aber es bietet sich an, hier
  die IDE-Unterstützung zu nutzen. Es stehen verschiedene Methoden zur Verfügung, die nicht unbedingt
  einheitlich benannt sein müssen oder in jeder IDE vorkommen. Zu den häufig genutzten Methoden zählen
  _Rename_, _Extract_, _Move_ und _Push Up/Pull Down_.
outcomes:
  - k2: "Begriff, Notwendigkeit und Vorgehen des/beim Refactoring"
  - k2: "Bedeutung kleiner Schritte beim Refactoring"
  - k2: "Bedeutung einer sinnvollen Testsuite beim Refactoring"
  - k2: "Refactoring: Nur innere Struktur ändern, nicht äußeres Verhalten!"
  - k3: "Anwendung der wichtigsten Refactoring-Methoden: _Rename_, _Extract_, _Move_, _Push Up/Pull Down_"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106231&client_id=FH-Bielefeld"
    name: "Quiz Refactoring (ILIAS)"
youtube:
  - link: "https://youtu.be/n0RaQ_Qve0Y"
    name: "VL Refactoring"
  - link: "https://youtu.be/zZ2RGKRBVz4"
    name: "Demo Refactoring: Rename"
  - link: "https://youtu.be/PR4mEjBl_No"
    name: "Demo Refactoring: Encapsulate"
  - link: "https://youtu.be/4VbxgqZ68ng"
    name: "Demo Refactoring: Extract Method"
  - link: "https://youtu.be/Wr92Oboh05E"
    name: "Demo Refactoring: Move Method"
  - link: "https://youtu.be/t24c88RshL8"
    name: "Demo Refactoring: Pull up"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/36389f8fe4befc6370c28cda4475690224942c00c854e6dfc953b60c26acdf62093345ae1ee0698f71dc0a7f02739253d4ba29b7c05b69036cbb09fb1e361549"
    name: "VL Refactoring"
challenges: |
    In der [Vorgabe](https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/tree/master/markdown/coding/src/challenges/refactor)
    finden Sie einige Klassen mit unübersichtlichem und schlecht strukturierten Code.

    Welche _Bad Smells_ können Sie hier identifizieren?

    Beheben Sie die Smells durch die _schrittweise Anwendung_ von den aus der Vorlesung
    bekannten Refactoring-Methoden. Wenden Sie dabei _mindestens_ die unten genannten
    Methoden an. Wenn Sie keinen passenden Smell identifizieren können, suchen Sie sich
    eine geeignete Stelle, um die jeweilige Methode anzuwenden. Denken Sie auch daran,
    dass Refactoring immer durch eine entsprechende Testsuite abgesichert sein muss.

    Ergänzend zu der Übersicht aus der Vorlesung finden sie unter
    [Refactoring Guru](https://refactoring.guru/refactoring/techniques) eine erweiterte
    Auflistung der gängigen Refactoring-Techniken.

    1.  Extract Method/Class
    2.  Move Method/Field
    3.  Encapsulate Method/Field
    4.  Pull Up oder Push Down
---


## Was ist Refactoring?

> Refactoring ist, wenn einem auffällt, daß der Funktionsname `foobar`
> ziemlich bescheuert ist, und man die Funktion in `sinus` umbenennt.
>
> \hfill\ [Quelle: ["356: Refactoring"](http://altlasten.lutz.donnerhacke.de/mitarb/lutz/usenet/Fachbegriffe.der.Informatik.html#356) by [Andreas Bogk](mailto:andreas@andreas.org) on Lutz Donnerhacke: "Fachbegriffe der Informatik"]{.origin}

\pause
\bigskip
\vfill

> Refactoring (noun): a change made to the internal structure of software to make
> it easier to understand and cheaper to modify without changing its observable
> behaviour.
>
> \hfill\ [Quelle: [@Fowler2011, p. 53]]{.origin}

::: notes
**Refactoring:** Änderungen an der [**inneren Struktur**]{.alert} einer Software

*   Beobachtbares (äußeres) Verhalten ändert sich dabei **nicht**
    *   Keine neuen Features einführen
    *   Keine Bugs fixen
    *   Keine öffentliche Schnittstelle ändern (_Anmerkung_: Bis auf Umbenennungen
        oder Verschiebungen von Elementen innerhalb der Software)
*   Ziel: Verbesserung von Verständlichkeit und Änderbarkeit
:::


## Anzeichen, dass Refactoring jetzt eine gute Idee wäre

*   Code "stinkt" (zeigt/enthält _Code Smells_)

    ::: notes
    Code Smells sind strukturelle Probleme, die im Laufe der Zeit zu
    Problemen führen können. Refactoring ändert die innere Struktur
    des Codes und kann entsprechend genutzt werden, um die Smells zu
    beheben.
    :::

\bigskip

*   Schwer erklärbarer Code

    ::: notes
    Könnten Sie Ihren Code ohne Vorbereitung in der Abgabe erklären?
    In einer Minute? In fünf Minuten? In zehn? Gar nicht?

    In den letzten beiden Fällen sollten Sie definitiv über eine
    Vereinfachung der Strukturen nachdenken.
    :::

*   Verständnisprobleme, Erweiterungen

    ::: notes
    Sie grübeln in der Abgabe, was Ihr Code machen sollte?

    Sie überlegen, was Ihr Code bedeutet, um herauszufinden, wo Sie
    die neue Funktionalität anbauen können?

    Sie suchen nach Codeteilen, finden diese aber nicht, da die sich
    in anderen (falschen?) Stellen/Klassen befinden?

    Nutzen Sie die (neuen) Erkenntnisse, um den Code leichter
    verständlich zu gestalten.
    :::

\bigskip
\vfill

::: cbox
> "Three strikes and you refactor."
>
> \hfill\ [Quelle: [@Fowler2011, p. 58]: "The Rule of Three"]{.origin}
:::

::: notes
Wenn Sie sich zum dritten Mal über eine suboptimale Lösung ärgern, dann
werden Sie sich vermutlich noch öfter darüber ärgern. Jetzt ist der
Zeitpunkt für eine Verbesserung.

Schauen Sie sich die entsprechenden Kapitel in [@Passig2013] und [@Fowler2011]
an, dort finden Sie noch viele weitere Anhaltspunkte, ob und wann Refactoring
sinnvoll ist.
:::


## Bevor Sie loslegen ...

1.  **Unit Tests** schreiben
    *   Normale und ungültige Eingaben
    *   Rand- und Spezialfälle

\smallskip

2.  **Coding Conventions** einhalten
    *   Sourcecode formatieren (lassen)

\bigskip
\smallskip

3.  Haben Sie die [fragliche Codestelle auch wirklich verstanden]{.alert}?!


## Vorgehen beim Refactoring

::: notes
### Überblick über die Methoden des Refactorings

Die Refactoring-Methoden sind nicht einheitlich definiert, es existiert ein großer
und uneinheitlicher "Katalog" an möglichen Schritten. Teilweise benennt jede IDE
die Schritte etwas anders, teilweise werden unterschiedliche Möglichkeiten angeboten.

Zu den am häufigsten genutzten Methoden zählen

*   Rename Method/Class/Field
*   Encapsulate Field
*   Extract Method/Class
*   Move Method
*   Pull Up, Push Down (Field, Method)

### Best Practice

Eine Best Practice (oder nennen Sie es einfach eine wichtige Erfahrung) ist,
beim Refactoring langsam und gründlich vorzugehen. Sie ändern die Struktur
der Software und können dabei leicht Fehler oder echte Probleme einbauen.
Gehen Sie also langsam und sorgsam vor, machen Sie einen Schritt nach dem
anderen und sichern Sie sich durch eine gute Testsuite ab, die Sie nach jedem
Schritt erneut ausführen: Das Verhalten der Software soll sich ja nicht
ändern, d.h. die Tests müssen nach jedem einzelnen Refactoring-Schritt immer
grün sein (oder Sie haben einen Fehler gemacht).
:::

*   Kleine Schritte: immer nur **eine** Änderung zu einer Zeit

*   Nach **jedem** Refactoring-Schritt **Testsuite** laufen lassen

    => Nächster Refactoring-Schritt erst, wenn alle Tests wieder "grün"

*   Versionskontrolle nutzen: **Jeden** Schritt **einzeln** committen


## Refactoring-Methode: Rename Method/Class/Field

::: notes
### Motivation

Name einer Methode/Klasse/Attributs erklärt nicht ihren Zweck.

### Durchführung

Name selektieren, "`Refactor > Rename`"

### Anschließend ggf. prüfen

Aufrufer? Superklassen?

### Beispiel
:::

**Vorher**

```java
public String getTeN() {}
```

**Nachher**

```java
public String getTelefonNummer() {}
```



## Refactoring-Methode: Encapsulate Field

::: notes
### Motivation

Sichtbarkeit von Attributen reduzieren.

### Durchführung

Attribut selektieren, "`Refactor > Encapsulate Field`"

### Anschließend ggf. prüfen

Superklassen? Referenzen? (Neue) JUnit-Tests?

### Beispiel
:::

**Vorher**

```java
int cps;

public void printDetails() {
    System.out.println("Credits: " + cps);
}
```

**Nachher**

```java
private int cps;

int getCps() { return cps; }
void setCps(int cps) {  this.cps = cps;  }

public void printDetails() {
    System.out.println("credits: " + getCps());
}
```


## Refactoring-Methode: Extract Method/Class

::: notes
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
:::

**Vorher**

```java
public void printInfos() {
    printHeader();
    // Details ausgeben
    System.out.println("name:    " + name);
    System.out.println("credits: " + cps);
}
```

**Nachher**

```java
public void printInfos() {
    printHeader();
    printDetails();
}
private void printDetails() {
    System.out.println("name:    " + name);
    System.out.println("credits: " + cps);
}
```


## Refactoring-Methode: Move Method

::: notes
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
:::

**Vorher**

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
        System.out.println("Kurs:    " + kurs.descr);
        System.out.println("Credits: " + kurs.cps);
    }
}
```

::: slides
## Refactoring-Methode: Move Method (cnt.)
:::

**Nachher**

```java
public class Kurs {
    int cps;
    String descr;

    public void printKursInfos() {
        System.out.println("Kurs:    " + descr);
        System.out.println("Credits: " + cps);
    }
}

public class Studi extends Person {
    String name;
    int cps;
    Kurs kurs;

    public void printKursInfos() { kurs.printKursInfos(); }
}
```


## Refactoring-Methode: Pull Up, Push Down (Field, Method)

::: notes
### Motivation

*   Attribut/Methode nur für die Oberklasse relevant: **Pull Up**
*   Subklassen haben identische Attribute/Methoden: **Pull Up**
*   Attribut/Methode nur für eine Subklasse relevant: **Push Down**

### Durchführung

Name selektieren, "`Refactor > Pull Up`" oder "`Refactor > Push Down`"

### Anschließend ggf. prüfen

Referenzen/Aufrufer? JUnit-Tests?

### Beispiel
:::

**Vorher**

```java
public class Person { }

public class Studi extends Person {
    String name;
    public void printDetails() { System.out.println("name:    " + name); }
}
```

**Nachher**

```java
public class Person { protected String name; }

public class Studi extends Person {
    public void printDetails() { System.out.println("name:    " + name); }
}
```


## Wrap-Up

Behebung von **Bad Smells** durch **Refactoring**

\smallskip

=> Änderung der inneren Struktur ohne Beeinflussung des äußeren Verhaltens

\bigskip

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
*   Citation "_Refactoring ist, wenn ..._": ["356: Refactoring"](http://altlasten.lutz.donnerhacke.de/mitarb/lutz/usenet/Fachbegriffe.der.Informatik.html#356) by [Andreas Bogk](mailto:andreas@andreas.org) on Lutz Donnerhacke: "Fachbegriffe der Informatik"
*   Citation "_Refactoring (noun): a change ..._": [@Fowler2011, p. 53]
*   Citation "_The Rule of Three_": [@Fowler2011, p. 58]
:::
