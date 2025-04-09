---
title: "Aufzählungen (Enumerations)"
author: "Carsten Gips (HSBI)"
readings:
  - "@Java-SE-Tutorial"
  - "@Ullenboom2021 [Kap. 6.4.3 und 10.7]"
tldr: |
    Mit Hilfe von `enum` lassen sich Aufzählungstypen definieren (der Compiler erzeugt intern
    passende Klassen). Dabei wird den Konstanten eine fortlaufende Nummer zugeordnet, auf die
    mit `ordinal()` zugegriffen werden kann. Mit der Methode `values()` kann über die Konstanten
    iteriert werden, und mit `name()` kann eine Stringrepräsentation einer Konstanten erzeugt
    werden. Es sind keine Instanzen von Enum-Klassen erzeugbar, und die Enum-Konstanten sind
    implizit `final` und `static`.

    Es lassen sich auch komplexe Enumerations analog zu Klassendefinition definieren, die eigene
    Konstruktoren, Felder und Methoden enthalten.
outcomes:
  - k2: "Vorgänge beim Initialisieren von Enum-Klassen (Hinweis: `static`)"
  - k3: "Erstellung komplexer Enumerationen mit Feldern und Konstruktoren"
  - k3: "Nutzung von `name()`, `ordinal()` und `values()` in Enum-Klassen"
#quizzes:
#  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106515&client_id=FH-Bielefeld"
#    name: "Quiz Enumerations (ILIAS)"
youtube:
  - link: "https://youtu.be/qoeT9jVuQZc"
    name: "VL Enumerations"
  - link: "https://youtu.be/ZCE9AmTluyk"
    name: "Demo Enumerations"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/5c9330cb4425a5b33f89b491d007990642765bf0ca7ea9fd6b8b7536f46691b86bba9bde65cdbce308fb467f2d0183391dd0d1247c142e4e28d9b9eaf8c0ff67"
    name: "VL Enumerations"
challenges: |
    Im [Dungeon](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/configuration/KeyboardConfig.java)
    sollen Key-Codes aus libGDX (Integer-Werte) als Konstanten zugreifbar sein. Zusätzlich soll es es noch einen String geben, der
    beschreibt, wo und wie diese Taste im Spiel eingesetzt wird. Aus historischen Gründen ist dies im Dungeon recht komplex gelöst.

    Definieren Sie eine neue Enum-Klasse, die Konstanten für Tasten aufzählt (beispielsweise `ESCAPE`, `W`, `A` oder `LEFT`). Jede
    dieser Konstanten soll den der Taste zugeordneten Integerwert speichern können und einen String haben, der als Hilfestring
    verstanden werden könnte (nutzen Sie hier einfach Phantasiewerte). Zeigen Sie in einer kleinen Demo, wie Sie mit diesem Enum
    arbeiten würden: Zugriff auf die Konstanten, Zugriff auf den Zahlenwert und/oder den String, Übergabe als Funktionsparameter.
---


## Motivation

```java
public class Studi {
    public static final int IFM = 0;
    public static final int ELM = 1;
    public static final int ARC = 2;

    public Studi(String name, int credits, int studiengang) {
        // Wert für studiengang muss zwischen 0 und 2 liegen
        // Erwünscht: Konstanten nutzen
    }

    public static void main(String[] args) {
        Studi rainer = new Studi("Rainer", 10, Studi.IFM);
        Studi holger = new Studi("Holger", 3, 4);   // Laufzeit-Problem!
    }
}
```

::: notes
**Probleme**:

*   Keine Typsicherheit
*   Konstanten gehören zur Klasse `Studi`, obwohl sie in anderem Kontext
    vermutlich auch interessant sind
:::

[[Probleme: Typsicherheit, Kontext]{.ex}]{.slides}
[[Beispiel enums.v1.Studi]{.ex href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/enums/v1/Studi.java"}]{.notes}


## Verbesserung: Einfache Aufzählung

```java
public enum Fach {
    IFM, ELM, ARC
}


public class Studi {
    public Studi(String name, int credits, Fach studiengang) {
        // Typsicherheit für studiengang :-)
    }

    public static void main(String[] args) {
        Studi rainer = new Studi("Rainer", 10, Fach.IFM);
        Studi holger = new Studi("Holger", 3, 4);   // Syntax-Fehler!
    }
}
```


## Einfache Aufzählungen: Eigenschaften

```java
public enum Fach {
    IFM, ELM, ARC
}
```

\bigskip

1.  Enum-Konstanten (`IFM`, ...) sind implizit `static` und `final`
2.  Enumerations (`Fach`) nicht instantiierbar
3.  Enumerations stellen einen neuen Typ dar: hier der Typ `Fach`
4.  Methoden: `name()`, `ordinal()`, `values()`, `toString()`

[[Erinnerung: Bedeutung von static und final]{.ex}]{.slides}


::::::::: notes
### Wiederholung _static_

**Attribute**:

*   `static` Attribute sind Eigenschaften/Zustände der **Klasse**
*   Gelten in jedem von der Klasse erzeugten Objekt
*   Unterschiedliche Lebensdauer:
    *   Objektattribute (Instanzvariablen): ab `new` bis zum Garbage Collector
    *   Statische Variablen: Laufzeitumgebung (JVM) lädt und initialisiert die Klasse
        (`static` Attribute existieren, bis die JVM die Klasse entfernt)

**Methoden**:

*   `static` deklarierte Methoden sind **Klassenmethoden**
*   Können direkt auf der Klasse aufgerufen werden
*   Beispiele: `Math.max()`, `Math.sin()`, `Integer.parseInt()`
*   **Achtung**: In Klassenmethoden nur Klassenattribute nutzbar (keine Instanzattribute!),
    d.h. keine `this`-Referenz nutzbar

### Wiederholung _final_: Attribute/Methoden/Klassen nicht änderbar

*   Attribute: `final` Attribute können nur einmal gesetzt werden

    ```java
    void foo() {
        int i = 2;
        final int j = 3;
        final int k;
        i = 3;
        j = 4;  // Compilerfehler
        k = 5;
        k = 6;  // Compilerfehler
    }
    ```

    [Beispiel enums.FinalDemo]{.ex href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/enums/FinalDemo.java"}

*   Methoden: `final` deklarierte Methoden können bei Vererbung nicht überschrieben werden
*   Klassen: von `final` deklarierten Klassen können keine Unterklassen gebildet werden
:::::::::


## Einfache Aufzählungen: Eigenschaften (cnt.)

```java
// Referenzen auf Enum-Objekte können null sein
Fach f = null;
f = Fach.IFM;

// Vergleich mit == möglich
// equals() unnötig, da Vergleich mit Referenz auf statische Variable
if (f == Fach.IFM) {
    System.out.println("Richtiges Fach :-)");
}

// switch/case
switch (f) {
    case IFM:   // Achtung: *NICHT* Fach.IFM
        System.out.println("Richtiges Fach :-)");
        break;
    default:
        throw new IllegalArgumentException("FALSCHES FACH: " + f);
}
```

::: notes
Außerdem können wir folgende Eigenschaften nutzen (u.a., s.u.):

*   Enumerations haben Methode `String toString()` für die Konstanten
*   Enumerations haben Methode `final T[] values()` für die Iteration über die Konstanten
:::

[Demo: enums.v2.Studi]{.ex href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/enums/v2/Studi.java"}


## Enum: Genauer betrachtet

```java
public enum Fach {  IFM, ELM, ARC  }
```

\bigskip

**Compiler sieht (*in etwa*):**

```java
public class Fach extends Enum {
    public static final Fach IFM = new Fach("IFM", 0);
    public static final Fach ELM = new Fach("ELM", 1);
    public static final Fach ARC = new Fach("ARC", 2);

    private Fach( String s, int i ) { super( s, i ); }
}
```

=> **Singleton-Pattern** für Konstanten


## Enum-Klassen: Eigenschaften

``` java
public enum Fach {
    IFM,
    ELM("Elektrotechnik Praxisintegriert", 1, 30),
    ARC("Architektur", 4, 40),
    PHY("Physik", 3, 10);

    private final String description;
    private final int number;
    private final int capacity;

    Fach() { this("Informatik Bachelor", 0, 60); }
    Fach(String descr, int number, int capacity) {
        this.description = descr;  this.number = number;  this.capacity = capacity;
    }
    public String getDescription() {
        return "Konstante: " + name() + " (Beschreibung: " + description
                + ", Kapazitaet: " + capacity + ", Nummer: " + number
                + ", Ordinal: " + ordinal() + ")";
    }
}
```

::: notes
### Konstruktoren und Methoden für Enum-Klassen definierbar

*   Kein eigener Aufruf von `super` (!)
*   Konstruktoren implizit `private`

### Compiler fügt automatisch folgende Methoden hinzu (Auswahl):

*   Strings:
    *   `public final String name()` => Name der Konstanten (`final`!)
    *   `public String toString()` => Ruft `name()` auf, überschreibbar
*   Konstanten:
    *   `public final T[] values()` => Alle Konstanten der Aufzählung
    *   `public final int ordinal()` => Interne Nummer der Konstanten
        (Reihenfolge des Anlegens der Konstanten!)
    *   `public static T valueOf(String)` => Zum String passende Konstante
        (via `name()`)

**Hinweis**: Diese Methoden gibt es auch bei den "einfachen" Enumerationen (s.o.).
:::

[Demo: enums.v3]{.ex href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/enums/v3/"}


## Wrap-Up

*   Aufzählungen mit Hilfe von `enum` [(Compiler erzeugt intern Klassen)]{.notes}

\smallskip

*   Komplexe Enumerations analog zu Klassendefinition: Konstruktoren, Felder und Methoden \newline
    (keine Instanzen von Enum-Klassen erzeugbar)

\bigskip

*   Enum-Konstanten sind implizit `final` und `static`
*   Compiler stellt Methoden `name()`, `ordinal()` und `values()` zur Verfügung

    ::: notes
    *   Name der Konstanten
    *   Interne Nummer der Konstanten (Reihenfolge des Anlegens)
    *   Array mit allen Konstanten der Enum-Klasse
    :::
