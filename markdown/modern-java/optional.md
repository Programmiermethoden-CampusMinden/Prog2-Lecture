---
type: lecture-cg
title: "Optional"
menuTitle: "Optional"
author: "Carsten Gips (FH Bielefeld)"
weight: 6
readings:
  - key: "LernJava"
    comment: "Tutorials > The Stream API > Using Optionals"
  - key: "Ullenboom2021"
    comment: "Kap. 12.6: Optional ist keine Nullnummer"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: ""
  - k3: ""
quizzes:
  - link: ""
    name: "Quiz Optional (ILIAS)"
assignments:
  - topic: sheet09
youtube:
  - link: ""
    name: "VL Optional"
  - link: ""
    name: "Demo Optional"
fhmedia:
  - link: ""
    name: "VL Optional"
---


## Motivation

```java
public record Studi(String name, int credits) {}

public class LSF {
    private final Set<Studi> sl = new HashSet<>();

    public Studi getBestStudi() {
        if (sl == null) return null;  // Fehler: Es gibt noch keine Liste

        Studi best = null;
        for (Studi s : sl) {
            if (best == null) best = s;
            if (best.credits() < s.credits()) best = s;
        }
        return best;
    }
}

public static void main(String... args) {
    LSF lsf = new LSF();

    Studi best = lsf.getBestStudi();
    if (best != null) {
        // mach was mit dem Studi ...
        String name = best.name();
        if (name != null) {
            // mach was mit dem Namen ...
        }
    }
}
```

::: notes
*   **Problem**: `null` wird an (zu) vielen Stellen genutzt:
    *   Es gibt keinen Wert ("not found")
    *   Felder wurden (noch) nicht initialisiert
    *   Es ist ein Problem oder etwas Unerwartetes aufgetreten

    => Parameter und Rückgabewerte müssen auf stets `null` geprüft werden
    (oder Annotationen wie `@NotNull` eingesetzt werden ...)

\smallskip

*   **Lösung**:
    *   `Optional<T>` für Rückgabewerte, die "kein Wert vorhanden" mit einschließen
        (statt `null` bei Abwesenheit von Werten)
    *   `@NotNull`/`@Nullable` für Parameter einsetzen (oder separate Prüfung)
    *   Exceptions werfen in Fällen, wo ein Problem aufgetreten ist

\smallskip

*   **Anmerkungen**:
    *   Verwendung von `null` auf Attribut-Ebene (Klassen-interne Verwendung) ist okay!
    *   `Optional<T>` ist **kein** für `null`-Checks!
    *   `null` ist **kein** Ersatz für vernünftiges Error-Handling!
        "Irgendwas Unerwartetes ist passiert, hier ist `null`" ist ein _Anti-Pattern_!
:::


## Erzeugen von _Optional_-Objekten

Konstruktor ist `private` ...

*   "Kein Wert": `Optional.empty()`
*   Verpacken eines non-`null` Elements: `Optional.of()` (`NullPointerException` wenn Argument `null`!)

\bigskip

*   Verpacken eines "unsicheren"/beliebigen Elements: `Optional.ofNullable()`
    *   Liefert verpacktes Element, oder
    *   `Optional.empty()`, falls Element `null` war

::: notes
Es sollte in der Praxis eigentlich nur wenige Fälle geben, wo ein Aufruf von
`Optional.of()` sinnvoll ist. Ebenso ist `Optional.empty()` nur selten sinnvoll.

Stattdessen sollte stets `Optional.ofNullable()` verwendet werden.
:::

\vfill

**`null` kann nicht nicht in `Optional<T>` verpackt werden!**
[(Das wäre dann eben `Optional.empty()`.)]{.notes}


## LSF liefert jetzt _Optional_ zurück

```java
public class LSF {
    public Optional<Studi> getBestStudi() throws NullPointerException {
        // Fehler: Es gibt noch keine Liste
        if (sl == null) throw new NullPointerException("There ain't any list");

        Studi best = null;
        for (Studi s : sl) {
            if (best == null) best = s;
            if (best.credits() < s.credits()) best = s;
        }

        // Entweder Optional.empty() (wenn best==null) oder Optional.of(best) sonst
        return Optional.ofNullable(best);
    }
}
```

::: notes
Das Beispiel soll verdeutlichen, dass man im Fehlerfall nicht einfach `null` oder
`Optional.empty()` zurückliefern soll, sondern eine passende Exception werfen soll.

Wenn die Liste aber leer ist, stellt dies keinen Fehler dar! In diesem Fall wird
statt `null` ein `Optional.empty()` zurückgeliefert, also ein Objekt, auf dem der
Aufrufer die üblichen Methoden aufrufen kann.
:::


## Zugriff auf _Optional_-Objekte

::: notes
In der funktionalen Programmierung gibt es schon lange das Konzept von `Optional`,
in Haskell ist dies beispielsweise die Monade `Maybe`. Allerdings ist die Einbettung
in die Sprache von vornherein mit berücksichtigt worden, insbesondere kann man hier
sehr gut mit _Pattern Matching_ in der Funktionsdefinition auf den verpackten Inhalt
reagieren.

In Java gibt es die Methode `Optional#isEmpty()`, die einen Boolean zurückliefert und
prüft, ob es sich um ein leeres `Optional` handelt oder ob hier ein Wert "verpackt" ist.

Für den direkten Zugriff auf die Werte gibt es die Methoden `Optional#orElseThrow()`
und `Optional#orElse()`. Damit kann man auf den verpackten Wert zugreifen, oder es
wird eine Exception geworfen bzw. ein Ersatzwert geliefert.

Zusätzlich gibt es `Optional#isPresent()`, die als Parameter ein ` java.util.function.Consumer`
erwartet, also ein funktionales Interface mit einer Methode `void accept(T)`, die das
Objekt verarbeitet.
:::


```java
Studi best;

// Testen und dann verwenden
if (!lsf.getBestStudi().isEmpty()) {
    best = lsf.getBestStudi().get();
    // mach was mit dem Studi ...
}

// Arbeite mit Consumer
lsf.getBestStudi().ifPresent(studi -> {
    // mach was mit dem Studi ...
});

// Studi oder Alternative (wenn Optional.empty())
best = lsf.getBestStudi().orElse(anne);

// Studi oder NoSuchElementException (wenn Optional.empty())
best = lsf.getBestStudi().orElseThrow();
```

::: notes
Es gibt noch eine Methode `get()`, die so verhält wie `orElseThrow()`. Da man diese
Methode vom Namen her schnell mit einem Getter verwechselt, ist sie mittlerweile
_deprecated_.

[Beispiel: [optional.traditional.Demo](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/optional/traditional/Demo.java)]{.bsp}
:::


## Einsatz in Streams

```java
public class LSF {
    ...

    public Optional<Studi> getBestStudi() throws NullPointerException {
        if (sl == null) throw new NullPointerException("There ain't any list");
        return sl.stream().sorted((s1, s2) -> s2.credits() - s1.credits()).findFirst();
    }
}

public static void main(String... args) {
    ...

    // Hole Studi und löse den Namen auf oder NoSuchElementException
    // anna.name == null => NoSuchElementException
    // anna.name != null => "Anna"
    String name = lsf.getBestStudi()
                     .map(Studi::name)
                     .orElseThrow();
}
```

::: notes
[Beispiel: [optional.streams.Demo](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/optional/streams/Demo.java)]{.bsp}



the map() method comes from the Optional class, and it integrates nicely with the stream processing. You do not need to check if the optional object returned by the findFirst() method is empty or not; calling map() does in fact this for you.


Wrapper-Klasse: Verpacke eine Referenz `Optional<T>` oder Wert `OptionalInt` => kann leer sein!
:::


## Regeln für _Optional_

Rule #1 Never use null for an optional variable or returned value.

Rule #2 Never call orElseThrow() or get() unless you are sure the optional is not empty.

Rule #3 Prefer alternatives to ifPresent(), orElseThrow(), or get().

Rule #4 Do not create an optional to avoid testing for the nullity of a reference.

Rule #5 Do not use optional in fields, method parameters, collections, and maps.

Rule #6 Do not use identity-sensitive operations on an optional object, such as reference equality, identity hash code, and synchronization.

Rule #7 Do not forget that optional objects are not serializable.


::: notes
## Interessante Links

*   ["Using Optionals"](https://dev.java/learn/using-optionals/)
*   ["What You Might Not Know About Optional"](https://medium.com/javarevisited/what-you-might-not-know-about-optional-7238e3c05f63)
*   ["Experienced Developers Use These 7 Java Optional Tips to Remove Code Clutter"](https://medium.com/javarevisited/experienced-developers-use-these-7-java-optional-tips-to-remove-code-clutter-6e8b1a639861)
*   ["Code Smells: Null"](https://blog.jetbrains.com/idea/2017/08/code-smells-null/)
*   [`Class Optional<T>`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html)
:::


## Wrap-Up
...


::: notes
Schöne Doku: ["Using Optionals"](https://dev.java/learn/using-optionals/).
:::







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
