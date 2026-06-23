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

Generics existieren eigentlich nur auf Quellcode-Ebene. Nach der Typ-Prüfung etc.
entfernt der Compiler alle generischen Typ-Parameter und alle `<...>` (=\>
"Type-Erasure"), d.h. im Byte-Code stehen nur noch Raw-Typen bzw. die oberen
Typ-Schranken der Typ-Parameter, in der Regel `Object`. Zusätzlich baut der Compiler
die nötigen Casts ein. Als Anwender merkt man davon nichts, muss das "Type-Erasure"
wegen der Auswirkungen aber auf dem Radar haben!
:::

::: youtube
-   [VL Generics und Polymorphie](https://youtu.be/RiTA43wTixQ)
:::




<!-- TODO
hey, ich unterrichte das modul "programmieren 2" für studis im zweiten semester informatik an einer hochschule. es geht um vertiefende und fortgeschrittene kenntnisse in der programmiersprache java (moderne version: java 25) sowie um kenntnisse in git, testen (junit), loggen, debuggen, ...

ich habe zu generics drei einheiten gebaut: (a) eine einführung,  (b) wildcards und bounds, (c) type erasure und polymorphie (varianz-diskussion).

kannst du bitte einmal über mein skript zu wildcards und bounds (teil b) schauen und mir feedback geben? sind irgendwo fehler (inhaltlich, tippfehler, grammatik, ...)? ist das material für ein zweites semester verständlich genug? fehlt eventuell noch etwas?

```markdown

```
-->






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


# Motivation: Wie verhalten sich generische Typen zueinander

::: notes
Wir haben uns schon angeschaut:

- generische Klassen/Methoden: `class Box<T> { ... }`, `static <T> void m(T x) {...}`
- Bounds: `T extends Number`
- Wildcards: `List<? extends Number>`

Die Frage für heute: **Wie verhalten sich generische Typen zueinander**?
:::

```java
interface Animal {
    default void eat() {};
}
record Dog() extends Animal {}
record Cat() extends Animal {}
```

\bigskip

Da `Cat` eine Unterklasse von `Animal` ist: Ist `List<Cat>` dann auch eine Unterklasse von `List<Animal>`?

```java
List<Animal> animals = new ArrayList<Cat>();  // ???
```

# Invarianz generischer Klassen in Java

::: notes
Angenommen, `List<Animal> animals = new ArrayList<Cat>();` wäre erlaubt. Dann würde das Folgende auch erlaubt sein:
:::


```java
List<Cat> cats = new ArrayList<>();
List<Animal> animals = cats;  // hypothetisch erlaubt

animals.add(new Dog());       // erlaubt, weil animals: List<Animal>
Cat c = cats.getFirst();      // aber jetzt steckt ein Dog in cats!
```

\pause

**Widerspruch zur Typ­sicherheit**

\bigskip

::: important
Java: generische Klassen sind **invariant**

Wenn `A` $\subseteq$ `B` (A Untertyp von B), dann folgt **nicht** `List<A>` $\subseteq$ `List<B>`.
:::

::: notes
=\> Polymorphie bei Generics bezieht sich auf **Typ** (nicht Typ-Parameter)

**Invarianz**: Generics sind *invariant*, d.h. ein `HashSet<String>` ist ein
Untertyp von `Set<String>`. Bei der Vererbung muss der Typ-Parameter identisch sein.

Beispiele:

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
:::


# Kovarianz mit `? extends` (Producer)


::: notes
Motivation:

Wir wollen lesen können: Eine Methode soll alle "Listen von Tieren" akzeptieren, egal ob `List<Dog>`, `List<Cat>` oder `List<Animal>`.
:::

```java
static void feedAll(List<? extends Animal> animals) {
    for (Animal a : animals) { a.eat(); }

    // animals.add(new Cat()); // Compiler-Fehler
}
```

::: notes
Erklärung:

-   `animals` ist eine Liste von **irgendetwas**, das **mindestens** ein `Animal` ist
-   Wir wissen deshalb: Jeder Eintrag hat die Schnittstelle von `Animal` $\to$ `a.eat()` ist also sicher

=> Diese Liste ist ein *"Producer"* von `Animal`‑Objekten (wir holen nur raus, wir lesen nur).

Darf man auch Elemente der Liste `animals` hinzufügen? => NEIN!

- Zur Laufzeit könnte es z.B. eine `List<Dog>` sein
- Dann wäre `animals.add(new Cat())` nicht typ­sicher

=> Konsequenz: Bei `List<? extends Animal>` ist **lesen sicher**, **schreiben (`add`) verboten**.
:::

\pause

::: important
**Kovarianz** durch `? extends T`:

- "Ich akzeptiere Listen von Untertypen von `T`."
- Nur sicher als **Producer** von `T` (lesen erlaubt).

\smallskip

- `List<Cat>` ist **kein** Untertyp von `List<Animal>`
- Aber: `List<Cat>` ist ein Untertyp von `List<? extends Animal>`
:::


# Kontravarianz mit `? super` (Consumer)

::: notes
Jetzt die andere Richtung:

Wir wollen eine Methode, die hinzufügen kann: z.B. alle `Cat` in irgendeine Liste stecken, die "`Cat` oder allgemeiner“ ist.
:::

```java
static void addCats(List<? super Cat> cats) {
    cats.add(new Cat());         // erlaubt
    // Cat c = cats.getFirst();  // geht nicht: Rückgabetyp ist Object
}
```

::: notes
Erklärung:

- `cats` ist eine Liste von `Cat` oder einem Supertyp (`Cat`, `Animal`, `Object`)
- Es ist immer sicher, eine `Cat` hinzuzufügen, denn:
    - Eine Liste von `Cat` darf Cats enthalten
    - Eine Liste von `Animal` darf Cats (als Untertyp) enthalten
    - Eine Liste von `Object` sowieso

Aber:

-   Beim Lesen weiß der Compiler nicht, ob wirklich eine `List<Cat>` übergeben wurde - er kennt nur `? super Cat`
-   Sicherer gemeinsamer Nenner: `Object`
:::


\pause

::: important
**Kontravarianz** durch `? super T`:

- "Ich akzeptiere Listen von Supertypen von `T`."
- Nur sicher als **Consumer** von `T` (schreiben/hinzufügen erlaubt).

\smallskip

`List<? extends Animal>` ist ein Supertyp von `List<Cat>`
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




# Typ-Löschung (*Type-Erasure*)

::: notes
Der Compiler ersetzt nach Prüfung der Typen und ihrer Verwendung alle Typ-Parameter
durch

1.  deren obere (Typ-)Schranke und
2.  passende explizite Cast-Operationen (im Byte-Code).

Die obere Typ-Schranke ist in der Regel der Typ der ersten Bounds-Klausel oder
`Object`, wenn keine Einschränkungen formuliert sind.

Bei parametrisierten Typen wie `List<T>` wird der Typ-Parameter entfernt, es
entsteht ein sogenannter *Raw*-Typ (`List`, quasi implizit mit `Object`
parametrisiert).

=\> Ergebnis: Nur **eine** (untypisierte) Klasse! Zur Laufzeit gibt es keine
Generics mehr!

**Hinweis**: In C++ ist man den anderen möglichen Weg gegangen und erzeugt für jede
Instantiierung die passende Klasse. Siehe Modul "Systemprogrammierung" :)

**Beispiel**: Aus dem folgenden harmlosen Code-Fragment:
:::

``` java
class Studi<T> {
    T myst(T m, T n) { return n; }

    public static void main(String[] args) {
        Studi<Integer> a = new Studi<>();
        int i = a.myst(1, 3);
    }
}
```

\pause
\bigskip
\hrule
\smallskip

::: notes
wird nach der Typ-Löschung durch Compiler (das steht dann quasi im Byte-Code):
:::

``` java
class Studi {
    Object myst(Object m, Object n) { return n; }

    public static void main(String[] args) {
        Studi a = new Studi();
        int i = (Integer) a.myst(1, 3);
    }
}
```

::: notes
Die obere Schranke meist `Object` =\> `new T()` verboten/sinnfrei (s.u.)!
:::

# Type-Erasure bei Nutzung von Bounds

::::: columns
::: column
[vor der Typ-Löschung durch Compiler:]{.notes}

``` java
class Cps<T extends Number> {
    T myst(T m, T n) {
        return n;
    }

    public static void main(String[] args) {
        Cps<Integer> a = new Cps<>();
        int i = a.myst(1, 3);
    }
}
```
:::

::: column
[nach der Typ-Löschung durch Compiler:]{.notes}

``` java
class Cps {
    Number myst(Number m, Number n) {
        return n;
    }

    public static void main(String[] args) {
        Cps a = new Cps();
        int i = (Integer) a.myst(1, 3);
    }
}
```
:::
:::::

# Raw-Types: Ich mag meine Generics "well done" :-)

Raw-Types: Instanziierung ohne Typ-Parameter =\> `Object`

``` java
Stack s = new Stack(); // Stack von Object-Objekten
```

\bigskip

-   Wegen Abwärtskompatibilität zu früheren Java-Versionen noch erlaubt.
-   Nutzung wird nicht empfohlen! (Warum?)

::: notes
## Anmerkung

Raw-Types darf man zwar selbst im Quellcode verwenden (so wie im Beispiel hier),
**sollte** die Verwendung aber vermeiden wegen der Typ-Unsicherheit: Der Compiler
sieht im Beispiel nur noch einen Stack für `Object`, d.h. dort dürfen Objekte aller
Typen abgelegt werden - es kann keine Typprüfung durch den Compiler stattfinden. Auf
einem `Stack<String>` kann der Compiler prüfen, ob dort wirklich nur
`String`-Objekte abgelegt werden und ggf. entsprechend Fehler melden.

Etwas anderes ist es, dass der Compiler im Zuge von Type-Erasure selbst Raw-Types in
den Byte-Code schreibt. Da hat er vorher bereits die Typsicherheit geprüft und er
baut auch die passenden Casts ein.

Das Thema ist eigentlich nur noch aus Kompatibilität zu Java5 oder früher da, weil
es dort noch keine Generics gab (wurden erst mit Java6 eingeführt).
:::

# Folgen der Typ-Löschung: *new*

::: center
`new` mit parametrisierten Klassen ist nicht erlaubt!
:::

\bigskip
\bigskip

``` java
class Fach<T> {
    public T foo() {
        return new T();  // nicht erlaubt!!!
    }
}
```

\bigskip

Grund: Zur Laufzeit keine Klasseninformationen über `T` mehr

::: notes
Im Code steht `return (CAST) new Object();`. Das neue Object kann man anlegen, aber
ein Cast nach irgendeinem anderen Typ ist sinnfrei: Jede Klasse ist ein Untertyp von
`Object`, aber eben nicht andersherum. Außerdem fehlt dem Objekt vom Typ `Object`
auch sämtliche Information und Verhalten, die der Cast-Typ eigentlich mitbringt ...
:::

# Folgen der Typ-Löschung: *static*

::: center
`static` mit generischen Typen ist nicht erlaubt!
:::

\bigskip
\bigskip

``` java
class Fach<T> {
    static T t;                    // nicht erlaubt!!!
    static Fach<T> c;              // nicht erlaubt!!!
    static void foo(T t) { ... };  // nicht erlaubt!!!
}

Fach<String>  a;
Fach<Integer> b;
```

\bigskip

Grund: Compiler generiert nur eine Klasse! Beide Objekte würden sich die statischen
Attribute teilen `\newline`{=tex} (Typ zur Laufzeit unklar!).

\smallskip

*Hinweis*: Generische (statische) Methoden sind erlaubt.

# Folgen der Typ-Löschung: *instanceof*

::: center
`instanceof` mit parametrisierten Klassen ist nicht erlaubt!
:::

\bigskip
\bigskip

::::: columns
::: {.column width="60%"}
``` java
class Fach<T> {
    void printType(Fach<?> p) {
        if (p instanceof Fach<Number>)
            ...
        else if (p instanceof Fach<String>)
            ...
    }
}
```
:::

::: {.column width="40%"}
[Grund: Unsinniger Code nach Typ-Löschung:]{.notes}

``` java
class Fach {
void printType(Fach p) {
    if (p instanceof Fach)
        ...
    else if (p instanceof Fach)
        ...
    }
}
```
:::
:::::

# Folgen der Typ-Löschung: *.class*

::: center
`.class` mit parametrisierten Klassen ist nicht erlaubt!
:::

\bigskip
\bigskip

``` java
boolean x;
List<String>  a = new ArrayList<String>();
List<Integer> b = new ArrayList<Integer>();

x = (List<String>.class == List<Integer>.class);  // Compiler-Fehler
x = (a.getClass() == b.getClass());               // true
```

\bigskip

Grund: Es gibt nur `List.class` (und kein `List<String>.class` bzw.
`List<Integer>.class`)!




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
-   Generics existieren eigentlich nur auf Quellcode-Ebene

\smallskip

-   Achtung: Bei Arrays gilt aber: Wenn "`U extends O`" dann gilt auch
    "`U[] extends O[]`" ...

\smallskip

-   "Type-Erasure":
    -   Compiler entfernt [nach Typ-Prüfungen etc.]{.notes} generische Typ-Parameter
        [etc.]{.notes} =\> im Byte-Code nur noch Raw-Typen [bzw. die oberen
        Typ-Schranken der Typ-Parameter, in der Regel `Object`]{.notes}
    -   Compiler baut passende Casts in Byte-Code ein
    -   Transparent für User; Auswirkungen beachten!


::: readings
-   @Ullenboom2021 [Kap. 11.5 und Kap. 12.2 und 12.6]
-   @LernJava
-   @Java-SE-Tutorial
-   @Bloch2018
:::

::: outcomes
- k2: Ich verstehe, warum `List<Dog>` kein Untertyp von `List<Animal>` ist (Invarianz)
-   k2: Ich verstehe, was Type Erasure bedeutet und kann erklären, welche praktischen Folgen das hat
-   k3: Ich kann Vererbungsbeziehungen mit generischen Klassen bilden
- k3: Ich kann erklären, wann `? extends` und wann `? super passt` (PECS)
-   k3: Ich kann mit Arrays und generischen Typen umgehen
:::
