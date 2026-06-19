---
author: Carsten Gips (HSBI)
title: "Generics3: Generics und Polymorphie"
---

::: tldr
Auch mit generischen Klassen stehen die Mechanismen Vererbung und Überladen zur
Verfügung. Dabei muss aber beachtet werden, dass generische Klassen sich
**"invariant"** verhalten: Der Typ selbst folgt der Vererbungsbeziehung, eine
Vererbung des Typ-Parameters begründet *keine* Vererbungsbeziehung! D.h. aus
`U extends O` folgt **nicht** `A<U> extends A<O>`.

Bei Arrays ist es genau anders herum: Wenn `U extends O` dann gilt auch
`U[] extends O[]` ... (Dies nennt man "*kovariantes*" Verhalten.)
:::

::: youtube
-   [VL Generics und Polymorphie](https://youtu.be/RiTA43wTixQ)
:::


<!-- TODO
Slide 1: Typ-Erasure (TE) und PECS – kompakt erklärt + zwei Beispiele


TE/PECS – kompakt erklärt



Typparameter (Generics) werden zur Laufzeit durch Type Erasure gelöscht. Zur Laufzeit existiert nur der Rohtyp (z. B. List), nicht der konkrete Typparameter.

PECS-Regel: Producer extends, Consumer super.

Producer extends T: Du liest aus einer Struktur; die konkrete Unterklasse bleibt unbekannt.

Consumer super T: Du schreibst in eine Struktur hinein; beim Lesen erhältst du nur Object.



Warum das sinnvoll ist: Typ-Sicherheit bei Zugriffen, flexible Schnittstellen, dennoch Laufzeittypinformationen begrenzt.



Beispiel 1: Typerasure (TE)




Code:
public class Box<T> { T value; }


public class TEExample {
public static void main(String[] args) {
Box<Integer> bi = new Box<>();
Box<String> bs = new Box<>();
// Zur Laufzeit existiert nur Box, nicht Box<Integer> vs Box<String>
System.out.println(bi.getClass() == bs.getClass()); // true
}
}




Erläuterung:



Beide Box-Instanzen haben zur Laufzeit denselben parametrisierten Typ-Typ (Box), daher ist der Vergleich true.

Hinweis für Teilnehmende: TYPPARAMETER-Informationen existieren zur Laufzeit nicht mehr; generische Typen wirken wie der Rohtyp.





Beispiel 2: PECS – zwei kompakte Fälle




Producer extends (lesen, aber nicht sicher hinzufügen)




Code:
import java.util.List;
import java.util.ArrayList;


public class PECSProducer extends Object {
public static void main(String[] args) {
List<? extends Number> nums = new ArrayList<Integer>(); // erlaubt
Number n = nums.get(0); // Lesen als Number ist möglich


    // nums.add(1); // Kompilierfehler: Kann nicht sicher typisieren

    // Consumer super (schreiben, aber Lesen nur als Object)
    List<? super Integer> ints = new ArrayList<Number>();
    ints.add(1); // Hinzufügen von Integer klappt
    Object o = ints.get(0); // Lesen liefert Object (kein konkreter Typ bekannt)
}
Kopieren

}




Erläuterung:



Bei List<? extends Number> darf man nichts Spezifisches in die Liste einfügen, außer null; man kann aber Elemente sicher als Number lesen.

Bei List<? super Integer> darf man Integer oder Untertypen hineinlegen; beim Lesen erhält man ein Objekt (Object), da der konkrete Typ unten nicht bekannt ist.




Praktischer Take-away: PECS hilft, Typ-Sicherheit zu wahren, wenn man sowohl lesen als auch schreiben will, je nach Kontext den passenden Bound wählen.




Slide 2: Zusatzfolie – Kurzfassung für Studierende

Kernbegriffe

Wildcard ? steht für einen unbekannten Typ.

Ungebundene Wildcard: List<?> – Zugriff auf Elemente ist eingeschränkt; konkret Typ unbekannt.

Extends-Bound: List<? extends T> – lese- wie „kovariant“, du kannst Elemente als T lesen, aber nichts sicher hinein schreiben (außer null).

Super-Bound: List<? super T> – schreibe- wie „kontravarient“, du kannst Werte vom Typ T hineinlegen, beim Lesen erhältst du Object.

Typherasure (TE): Generische Typen werden zur Laufzeit gelöscht; Laufzeit kennt nur den Rohtyp (z. B. List), nicht List<Integer>.


PECS in Kürze

Producer extends: Du liest aus der Struktur; Bound wählen, der Obertyp liefern kann.

Consumer super: Du schreibst in die Struktur hinein; Bound wählen, der Werte vom Typ T aufnehmen kann.


Schnell-Checkliste

Möchten Sie aus einer Struktur lesen, aber nicht sicher schreiben? Extends-Bound verwenden.

Möchten Sie in eine Struktur schreiben, aber nicht sicher lesen? Super-Bound verwenden.

Benutzen Sie ungebundene Wildcards sparsam, nur wenn der konkrete Typ wirklich egal ist.


Kleine Merkhilfen

List<? extends T> ist read-only in Bezug auf konkrete Typinformation.

List<? super T> ist write-only in Bezug auf konkrete Typinformation; Lesen ergibt Object.


Hinweise für den Unterricht

TE ist konzeptionell wichtig, aber zur Laufzeit nicht sichtbar; PECS hilft bei API-Design, wenn Sie Flexibilität und Typ-Sicherheit zusammenbringen möchten.

Achten Sie darauf, Studierende an konkreten Beispielen durch die drei Varianten von Hands-On zu führen (invariante Listen, List<?>, List<? extends T>, List<? super T>).
-->

# Generische Polymorphie

::: center
`B<E> extends A<E>`
:::

\bigskip
\bigskip

::: notes
``` java
class A<E> { ... }
class B<E> extends A<E> { ... }

A<Double> ad = new B<Double>();
A<String> as = new B<String>();
```
:::

``` java
class Vector<E> { ... }
class Stack<E> extends Vector<E> { ... }

Vector<Double> vd = new Stack<Double>();
Vector<String> vs = new Stack<String>();
```

\bigskip

=\> Polymorphie bei Generics bezieht sich auf **Typ** (nicht Typ-Parameter)

::: notes
**Invarianz**: Generics sind *invariant*, d.h. ein `HashSet<String>` ist ein
Untertyp von `Set<String>`. Bei der Vererbung muss der Typ-Parameter identisch sein.
:::

# Polymorphie bei Generics bezieht sich nur auf Typ!

\bigskip

::: center
"`B extends A`" **bedeutet nicht** "`C<B> extends C<A>`"
:::

\bigskip
\bigskip

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

::: notes
-   Typ-Löschung =\> zur Laufzeit keine Typinformationen vorhanden
-   Compiler muss Typen prüfen (können)!
:::

# Abgrenzung: Polymorphie bei Arrays

::: center
Wenn "`B extends A`" dann "`B[] extends A[]`"
:::

\bigskip
\bigskip

``` java
Object[] x = new String[] {"Hello", "World", ":-)"};
x[0] = "Hallo";
x[0] = new Double(2.0);  // Laufzeitfehler
String[] y = x;  // String[] ist KEIN Object[]!!!
```

\bigskip

-   Arrays besitzen Typinformationen über gespeicherte Elemente
-   Prüfung auf Typ-Kompatibilität zur **Laufzeit** (nicht Kompilierzeit!)

[Hinweis auf Java-Geschichte [(Java-Insel: "Type Erasure")]{.notes}]{.ex
href="https://openbook.rheinwerk-verlag.de/javainsel/11_002.html#u11.2.2"}

::: notes
Arrays gab es sehr früh, Generics erst relativ spät (ab Java6) =\> bei Arrays fand
man das Verhalten natürlich und pragmatisch (trotz der Laufzeit-Überprüfung).

Bei der Einführung von Generics musste man Kompatibilität sicherstellen (alter Code
soll auch mit neuen Compilern übersetzt werden können - obwohl im alten Code
Raw-Types verwendet werden). Außerdem wollte man von Laufzeit-Prüfung hin zu
Compiler-Prüfung. Da würde das von Arrays bekannte Verhalten Probleme machen ...

**Kovarianz**: Arrays sind *kovariant*, d.h. ein Array vom Typ `String[]` ist wegen
`String extends Object` ein Untertyp von `Object[]`.

[Beispiel arrays.X]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/arrays/X.java"}
:::

# Arrays vs. parametrisierte Klassen

=\> Keine Arrays mit parametrisierten Klassen!

\bigskip
\bigskip

``` java
Foo<String>[] x = new Foo<String>[2];   // Compilerfehler

Foo<String[]> y = new Foo<String[]>();  // OK :)
```

::: notes
Arrays mit parametrisierten Klassen sind nicht erlaubt! Arrays brauchen zur Laufzeit
Typinformationen, die aber durch die Typ-Löschung entfernt werden.
:::

# Diskussion Vererbung vs. Generics

**Vererbung:**

-   *IS-A*-Beziehung
-   Anwendung: Vererbungsbeziehung vorliegend, Eigenschaften verfeinern
-   Beispiel: Ein Student *ist eine* Person

\bigskip

**Generics:**

-   Schablone (Template) für viele Datentypen
-   Anwendung: Identischer Code für unterschiedliche Typen
-   Beispiel: Datenstrukturen, Algorithmen generisch realisieren

# Wrap-Up

-   Generics: Vererbung und Überladen möglich, aber: `\newline`{=tex} Aus
    "`U extends O`" folgt **nicht** "`A<U> extends A<O>`"

\smallskip

-   Achtung: Bei Arrays gilt aber: Wenn "`U extends O`" dann gilt auch
    "`U[] extends O[]`" ...

::: readings
-   @Ullenboom2021 [Kap. 11.5]
-   @LernJava
-   @Java-SE-Tutorial
-   @Bloch2018
:::

::: outcomes
-   k3: Ich kann Vererbungsbeziehungen mit generischen Klassen bilden
-   k3: Ich kann mit Arrays und generischen Typen umgehen
:::
