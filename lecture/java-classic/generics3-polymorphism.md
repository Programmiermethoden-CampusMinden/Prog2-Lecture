# Generics: Generics und Polymorphie

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Auch mit generischen Klassen stehen die Mechanismen Vererbung und
> Überladen zur Verfügung. Dabei muss aber beachtet werden, dass
> generische Klassen sich **"invariant"** verhalten: Der Typ selbst
> folgt der Vererbungsbeziehung, eine Vererbung des Typ-Parameters
> begründet *keine* Vererbungsbeziehung! D.h. aus `U extends O` folgt
> **nicht** `A<U> extends A<O>`.
>
> Bei Arrays ist es genau anders herum: Wenn `U extends O` dann gilt
> auch `U[] extends O[]` ... (Dies nennt man "*kovariantes*" Verhalten.)
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Generics und Polymorphie](https://youtu.be/RiTA43wTixQ)
>
> </details>

## Generische Polymorphie

<div align="center">

`B<E> extends A<E>`

</div>

``` java
class A<E> { ... }
class B<E> extends A<E> { ... }

A<Double> ad = new B<Double>();
A<String> as = new B<String>();
```

``` java
class Vector<E> { ... }
class Stack<E> extends Vector<E> { ... }

Vector<Double> vd = new Stack<Double>();
Vector<String> vs = new Stack<String>();
```

=\> Polymorphie bei Generics bezieht sich auf **Typ** (nicht
Typ-Parameter)

**Invarianz**: Generics sind *invariant*, d.h. ein `HashSet<String>` ist
ein Untertyp von `Set<String>`. Bei der Vererbung muss der Typ-Parameter
identisch sein.

## Polymorphie bei Generics bezieht sich nur auf Typ!

<div align="center">

"`B extends A`" **bedeutet nicht** "`C<B> extends C<A>`"

</div>

``` java
Stack<Number> s = new Stack<Integer>(); // DAS GEHT SO NICHT!

// Folgen (wenn obiges gehen wuerde):
s.push(new Integer(3)); // das ginge sowieso ...

// Folgen (wenn obiges gehen wuerde):
// Stack<Number> waere Oberklasse auch von Stack<Double>
s.push(new Double(2.0)); // waere dann auch erlaubt ...

// Das Objekt (Stack<Integer>) kann aber keine Double speichern!
// Zur Laufzeit keine Typ-Informationen mehr!
```

-   Typ-Löschung =\> zur Laufzeit keine Typinformationen vorhanden
-   Compiler muss Typen prüfen (können)!

## Abgrenzung: Polymorphie bei Arrays

<div align="center">

Wenn "`B extends A`" dann "`B[] extends A[]`"

</div>

``` java
Object[] x = new String[] {"Hello", "World", ":-)"};
x[0] = "Hallo";
x[0] = new Double(2.0);  // Laufzeitfehler
String[] y = x;  // String[] ist KEIN Object[]!!!
```

-   Arrays besitzen Typinformationen über gespeicherte Elemente
-   Prüfung auf Typ-Kompatibilität zur **Laufzeit** (nicht
    Kompilierzeit!)

<p align="right"><a href="https://openbook.rheinwerk-verlag.de/javainsel/11_002.html#u11.2.2">Hinweis auf Java-Geschichte (Java-Insel: “Type Erasure”)</a></p>

Arrays gab es sehr früh, Generics erst relativ spät (ab Java6) =\> bei
Arrays fand man das Verhalten natürlich und pragmatisch (trotz der
Laufzeit-Überprüfung).

Bei der Einführung von Generics musste man Kompatibilität sicherstellen
(alter Code soll auch mit neuen Compilern übersetzt werden können -
obwohl im alten Code Raw-Types verwendet werden). Außerdem wollte man
von Laufzeit-Prüfung hin zu Compiler-Prüfung. Da würde das von Arrays
bekannte Verhalten Probleme machen ...

**Kovarianz**: Arrays sind *kovariant*, d.h. ein Array vom Typ
`String[]` ist wegen `String extends Object` ein Untertyp von
`Object[]`.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/arrays/X.java">Beispiel arrays.X</a></p>

## Arrays vs. parametrisierte Klassen

=\> Keine Arrays mit parametrisierten Klassen!

``` java
Foo<String>[] x = new Foo<String>[2];   // Compilerfehler

Foo<String[]> y = new Foo<String[]>();  // OK :)
```

Arrays mit parametrisierten Klassen sind nicht erlaubt! Arrays brauchen
zur Laufzeit Typinformationen, die aber durch die Typ-Löschung entfernt
werden.

## Diskussion Vererbung vs. Generics

**Vererbung:**

-   *IS-A*-Beziehung
-   Anwendung: Vererbungsbeziehung vorliegend, Eigenschaften verfeinern
-   Beispiel: Ein Student *ist eine* Person

**Generics:**

-   Schablone (Template) für viele Datentypen
-   Anwendung: Identischer Code für unterschiedliche Typen
-   Beispiel: Datenstrukturen, Algorithmen generisch realisieren

## Wrap-Up

-   Generics: Vererbung und Überladen möglich, aber: Aus "`U extends O`"
    folgt **nicht** "`A<U> extends A<O>`"

<!-- -->

-   Achtung: Bei Arrays gilt aber: Wenn "`U extends O`" dann gilt auch
    "`U[] extends O[]`" ...

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, 11.5](#ref-Ullenboom2021))
> -   Oracle Corporation ([2026](#ref-LernJava))
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Bloch ([2018](#ref-Bloch2018))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann Vererbungsbeziehungen mit generischen Klassen bilden
> -   k3: Ich kann mit Arrays und generischen Typen umgehen
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
> <div id="ref-Bloch2018" class="csl-entry">
>
> Bloch, J. 2018. *Effective Java*. 3. Aufl. Addison-Wesley.
>
> </div>
>
> <div id="ref-Java-SE-Tutorial" class="csl-entry">
>
> Oracle Corporation. 2024. „The Java Tutorials".
> <https://docs.oracle.com/javase/tutorial/>.
>
> </div>
>
> <div id="ref-LernJava" class="csl-entry">
>
> Oracle Corporation. 2026. „Learn Java". <https://dev.java/learn/>.
>
> </div>
>
> <div id="ref-Ullenboom2021" class="csl-entry">
>
> Ullenboom, C. 2021. *Java ist auch eine Insel*. 16. Aufl.
> Rheinwerk-Verlag.
> <https://openbook.rheinwerk-verlag.de/javainsel/index.html>.
>
> </div>
>
> </div>
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> be8ad59 2026-04-11 generics: rename files<br></sub></sup></p></blockquote>
