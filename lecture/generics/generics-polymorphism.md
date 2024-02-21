---
archetype: lecture-cg
title: "Generics und Polymorphie"
linkTitle: "Polymorphie"
author: "Carsten Gips (HSBI)"
readings:
  - key: "Ullenboom2021"
    comment: "Kapitel 11.5"
  - key: "LernJava"
    comment: "Kapitel Generics"
  - key: "Java-SE-Tutorial"
    comment: "Specialized Trails: Generics"
  - key: "Bloch2018"
tldr: |
  Auch mit generischen Klassen stehen die Mechanismen Vererbung und Überladen zur Verfügung. Dabei muss
  aber beachtet werden, dass generische Klassen sich **"invariant"** verhalten: Der Typ selbst folgt der
  Vererbungsbeziehung, eine Vererbung des Typ-Parameters begründet _keine_ Vererbungsbeziehung! D.h.
  aus `U extends O` folgt **nicht** `A<U> extends A<O>`.

  Bei Arrays ist es genau anders herum: Wenn `U extends O` dann gilt auch `U[] extends O[]` ... (Dies
  nennt man "_kovariantes_" Verhalten.)
outcomes:
  - k3: "Vererbungsbeziehungen mit generischen Klassen"
  - k3: "Umgang mit Arrays und generischen Typen"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106238&client_id=FH-Bielefeld"
    name: "Quiz Generics und Polymorphie (ILIAS)"
youtube:
  - link: "https://youtu.be/RiTA43wTixQ"
    name: "VL Generics und Polymorphie"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/a0d6f4ada3f85cd9f78dfde923f045f5fd43819a4930c5ef989ff6acb150c2f53208a061cf87f3c3f03823f6d645e10b1388009bfd9cfe474cfb4bdc93302fc2"
    name: "VL Generics und Polymorphie"
---


## Generische Polymorphie

::: cbox
`B<E> extends A<E>`
:::

\bigskip
\bigskip

::: notes
```java
class A<E> { ... }
class B<E> extends A<E> { ... }

A<Double> ad = new B<Double>();
A<String> as = new B<String>();
```
:::

```java
class Vector<E> { ... }
class Stack<E> extends Vector<E> { ... }

Vector<Double> vd = new Stack<Double>();
Vector<String> vs = new Stack<String>();
```

\bigskip
=> Polymorphie bei Generics bezieht sich auf **Typ** (nicht Typ-Parameter)

::: notes
**Invarianz**: Generics sind _invariant_, d.h. ein `HashSet<String>` ist ein
Untertyp von `Set<String>`. Bei der Vererbung muss der Typ-Parameter identisch
sein.
:::


## Polymorphie bei Generics bezieht sich nur auf Typ!

\bigskip

::: cbox
"`B extends A`" [**bedeutet nicht**]{.alert} "`C<B> extends C<A>`"
:::

\bigskip
\bigskip

```java
Stack<Number> s = new Stack<Integer>(); // DAS GEHT SO NICHT!

// Folgen (wenn obiges gehen wuerde):
s.push(new Integer(3)); // das ginge sowieso ...

// Folgen (wenn obiges gehen wuerde):
// Stack<Number> waere Oberklasse auch von Stack<Double>
s.push(new Double(2.0)); // waere dann auch erlaubt ...

// Das Objekt (Stack<Integer>) kann aber keine Double speichern!
// Zur Laufzeit keine Typ-Informationen mehr!
```

::: notes
*   Typ-Löschung => zur Laufzeit keine Typinformationen vorhanden
*   Compiler muss Typen prüfen (können)!
:::


## Abgrenzung: Polymorphie bei Arrays

::: cbox
Wenn "`B extends A`" dann "`B[] extends A[]`"
:::

\bigskip
\bigskip

```java
Object[] x = new String[] {"Hello", "World", ":-)"};
x[0] = "Hallo";
x[0] = new Double(2.0);  // Laufzeitfehler
String[] y = x;  // String[] ist KEIN Object[]!!!
```
\bigskip

*   Arrays besitzen Typinformationen über gespeicherte Elemente
*   Prüfung auf Typ-Kompatibilität zur **Laufzeit** (nicht Kompilierzeit!)

[Hinweis auf Java-Geschichte [(Java-Insel: "Type Erasure")]{.notes}]{.bsp href="https://openbook.rheinwerk-verlag.de/javainsel/11_002.html#u11.2.2"}

::: notes
Arrays gab es sehr früh, Generics erst relativ spät (ab Java6) => bei
Arrays fand man das Verhalten natürlich und pragmatisch (trotz der Laufzeit-Überprüfung).

Bei der Einführung von Generics musste man Kompatibilität sicherstellen (alter
Code soll auch mit neuen Compilern übersetzt werden können - obwohl im alten
Code Raw-Types verwendet werden). Außerdem wollte man von Laufzeit-Prüfung hin zu
Compiler-Prüfung. Da würde das von Arrays bekannte Verhalten Probleme machen ...

**Kovarianz**: Arrays sind _kovariant_, d.h. ein Array vom Typ `String[]` ist wegen
`String extends Object` ein Untertyp von `Object[]`.

[Beispiel arrays.X]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/markdown/generics/src/arrays/X.java"}
:::


## Arrays vs. parametrisierte Klassen

=> Keine Arrays mit parametrisierten Klassen!

\bigskip
\bigskip

```java
Foo<String>[] x = new Foo<String>[2];   // Compilerfehler

Foo<String[]> y = new Foo<String[]>();  // OK :)
```

::: notes
Arrays mit parametrisierten Klassen sind nicht erlaubt! Arrays brauchen zur
Laufzeit Typinformationen, die aber durch die Typ-Löschung entfernt werden.
:::


## Diskussion Vererbung vs. Generics

**Vererbung:**

*   *IS-A*-Beziehung
*   Anwendung: Vererbungsbeziehung vorliegend, Eigenschaften verfeinern
*   Beispiel: Ein Student *ist eine* Person

\bigskip

**Generics:**

*   Schablone (Template) für viele Datentypen
*   Anwendung: Identischer Code für unterschiedliche Typen
*   Beispiel: Datenstrukturen, Algorithmen generisch realisieren


## Wrap-Up

*   Generics: Vererbung und Überladen möglich, aber: \newline
    **Aus "`U extends O`" folgt [**nicht**]{.alert} "`A<U> extends A<O>`"**

\smallskip

*   Achtung: Bei Arrays gilt aber: Wenn "`U extends O`" dann gilt auch "`U[] extends O[]`" ...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
