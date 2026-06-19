---
author: Carsten Gips (HSBI)
title: "Generics2: Bounds & Wildcards"
---

::: tldr
Typ-Parameter können durch **Bounds** eingeschränkt werden: `<T extends ...>`
bedeutet, dass der Typ-Parameter `T` nach oben eingeschränkt wird ("upper bound").
Durch `extends`-Bounds kann in einer Klasse bzw. Methode der Typ-Parameter so
eingeschränkt werden, dass alle Methoden des Obertyps verwendet werden können.

Ein **Wildcard** (`?`) steht für einen unbestimmten Typ. Ein Wildcard-Typ hat keinen
Namen / ist nicht benennbar und ist innerhalb der Klasse/Methode nicht direkt
zugreifbar. Wildcards können mit `? extends ...` nach oben ("upper bound") oder
`? super ...` nach unten ("lower bound") eingeschränkt werden.

Bei `? extends Bound` muss der konkrete Typ die Schranke selbst oder ein Subtyp
davon sein. Bei `? super Bound` muss der konkrete Typ ein Supertyp (Obertyp) der
angegebenen Schranke sein.
:::

::: youtube
-   [VL Generics: Bounds & Wildcards](https://youtu.be/OV2vEn2EkWo)
-   [Demo Wildcards](https://youtu.be/D2hIicsho7I)
:::

# Bounds: Einschränken der generischen Typen

``` java
public class Cps<E extends Number> {
    // Obere Schranke: E muss Number oder Subklasse sein
    // => Zugriff auf Methoden aus Number moeglich
}
Cps<Double> a;
Cps<Number> b;
Cps<String> c;  // Fehler!!!
```

\bigskip
\smallskip

-   Schlüsselwort `extends` gilt hier auch für Interfaces

-   Mehrere Interfaces: nach `extends` **eine** Klasse oder **ein** Interface,
    danach mit "`&`" getrennt die restlichen Interfaces:

    ``` java
    class Cps<E extends KlasseOderInterface & I1 & I2 & I3> {}
    ```

:::: notes
Falls eine Klasse einem gemeinsamen Obertyp folgen soll, können mehrere Bound-Typen
durch `&` verbunden werden. Der erste Bound kann eine Klasse (z.B. `Number`) sein;
alle weiteren Bound-Typen müssen Interfaces sein. Wenn kein Klassen-Bound existiert,
können alle Bound-Typen Interfaces sein.

::: tip
*Anmerkung*: Der Typ-Parameter ist analog auch mit `super` (nach unten)
einschränkbar. Das schauen wir uns im Zusammenhang mit Vererbungsbeziehungen und
Polymorphie im dritten Teil ["Generics3: Generics und
Polymorphie"](generics3-polymorphism.md) noch genauer an.
:::

[Beispiel bounds.Cps]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/bounds/Cps.java"}
::::

# Wildcards: Dieser Typ ist mir nicht so wichtig

\bigskip

::: center
Wildcard mit "`?`" =\> steht für unbestimmten Typ
:::

\bigskip

``` java
public class Wuppie {
    public void m1(List<?> a) { ... }
    public void m2(List<? extends Number> b) { ... }
}
```

-   `m1`: `List` beliebig parametrisierbar `\newline`{=tex} =\> In `m1` für Objekte
    in Liste `a` nur Methoden von `Object` nutzbar!

-   `m2`: `List` muss mit `Number` oder Subklasse parametrisiert werden.
    `\newline`{=tex} =\> Dadurch für Objekte in Liste `b` alle Methoden von `Number`
    nutzbar ...

::: notes
Die Wildcard `?` steht für einen unbekannten Typ. `List<?>` erlaubt `List`-Objekte
jedes Typs, aber innerhalb der Methode kann man nicht sicher auf spezifische
Eigenschaften des konkreten Typs zugreifen. `List<?>` ist also **nicht** eine "Liste
von `Object`", sondern "Liste von unbekanntem Typ".

-   Typvariable: "ich benenne den Typ und kann ihn mehrfach verwenden"
-   Wildcard: "ich akzeptiere etwas Unbekanntes, kann es aber nicht benennen"

Mit `List<? extends A>` erlaubt man Listen von Elementen, die `A` oder eine
Unterklasse von `A` sind (*kovariant*, siehe auch Diskussion in ["Generics3:
Generics und Polymorphie"](generics3-polymorphism.md)); man kann Elemente als `A`
lesen/nutzen, aber nicht sicher als `A` hinzufügen (weil der echte Typ wg. des
Wildcards unbekannt ist - es könnte ein beliebiger Untertyp von `A` sein).

Weitere Eigenschaften:

-   Durch Wildcard kein Zugriff auf den Typ
-   Wildcard kann durch upper bound eingeschränkt werden
-   Geht nicht bei Klassen-/Interface-Definitionen, hier wird eine Typ-Variable
    benötigt

Weitere Beispiele:

-   `List<?>` - Typ der Listenelemente unbekannt, nur Methoden von `Object` nutzbar
-   `List<? extends T>` - Typ der Listenelemente ist `T` oder eine Unterklasse von
    `T`; Zugriff lesend mit den Methoden von `T` (außer `null`), Schreiben nur
    eingeschränkt möglich (konkreter Typ unklar wg. `?` - es könnte eine Unterklasse
    von `T` sein, und Schreiben von Elementen vom Typ `T` würde (wenn es erlaubt
    wäre) dann zur Laufzeit schief gehen - Java fängt das aber zur Compilezeit ab)
-   `List<? super T>` - Typ der Listenelemente ist `T` oder eine Oberklasse von `T`;
    Zugriff schreibend möglich mit Werten vom Typ `T` und Untertypen, Lesen nur mit
    `Object` (der konkrete Typ samt Schnittstelle ist unklar: es könnte eine
    beliebige Oberklasse von `T` sein, die eine völlig unterschiedliche
    Schnittstelle als `T` hat)

=\> Das soll uns als erste Einführung von Bounds und Wildcards reichen. Wir werden
überwiegend die `extends`-Bounds verwenden. Für eine genauere Diskussion von "Type
Erasure" (TE) und "Producer extends, Consumer super" (PECS-Regel) sowie die
Varianz-Diskussion siehe Lektion ["Generics3: Generics und
Polymorphie"](generics3-polymorphism.md).
:::

\bigskip
\bigskip

@Bloch2018: Wildcards **meist** für Parameter; Rückgabewerte **möglichst** konkret
typisieren.

::: notes
Generische Typen in Rückgabewerten sollten möglichst konkrete Typen oder Bounds
verwenden, um Typ-Sicherheit zu wahren.
:::

# Hands-On: Ausgabe für generische Listen

Ausgabe für Listen gesucht, die sowohl Elemente der Klasse `A` als auch Elemente der
Klasse `B` enthalten [können]{.notes}

\bigskip

``` java
class A { void printInfo() { System.out.println("A"); } }
class B extends A { void printInfo() { System.out.println("B"); } }

public class X {
    public static void main(String[] args) {
        List<A> x = new ArrayList<A>();
        x.add(new A());  x.add(new B());
        printInfo(x);    // Klassenmethode in X, gesucht
        List<B> y = new ArrayList<B>();
        y.add(new B());  y.add(new B());
        printInfo(y);    // Klassenmethode in X, gesucht
    }
}
```

::: notes
**Hinweis**: Dieses Beispiel berührt auch Polymorphie bei/mit generischen
Datentypen, vgl. dritter Teil ["Generics und
Polymorphie"](generics3-polymorphism.md) anschauen.
:::

::: notes
## Erster Versuch (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

=\> **So geht's nicht!** Eine `List<B>` ist **keine** `List<A>` (auch wenn ein `B`
ein `A` ist, vgl. spätere Sitzung zu Generics und Vererbung ...)!

[Beispiel wildcards.v1.X]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/wildcards/v1/X.java"}

## Zweiter Versuch mit Wildcards (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<?> list) {
        for (Object a : list) { a.printInfo(); }
    }
}
```

=\> **So gehts auch nicht!** Im Prinzip passt das jetzt für `List<A>` und `List<B>`.
Dummerweise hat man durch das Wildcard keinen Zugriff mehr auf den Typ-Parameter und
muss für den Typ der Laufvariablen in der `for`-Schleife dann `Object` nehmen. Aber
`Object` kennt unser `printInfo` nicht ... Außerdem könnte man die Methode
`X#printInfo` dank des Wildcards auch mit allen anderen Typen aufrufen ...

[Beispiel wildcards.v2.X]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/wildcards/v2/X.java"}

## Dritter Versuch (Lösung) mit Wildcards und Bounds (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<? extends A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

Das ist die Lösung. Man erlaubt als Argument nur `List`-Objekte und fordert, dass
sie mit `A` oder einer Unterklasse von `A` parametrisiert sind. D.h. in der Schleife
kann man sich auf den gemeinsamen Obertyp `A` abstützen und hat dann auch wieder die
`printInfo`-Methode (von `A`) zur Verfügung ...
:::

[Konsole wildcards.v3.X]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/wildcards/v3"}

# Wrap-Up

-   Ein Wildcard (`?`) als Typ-Parameter steht für einen beliebigen Typ
    -   Ist in Klasse oder Methode dann aber nicht mehr zugreifbar

\smallskip

-   Mit Bounds kann man Typ-Parameter/Wildcards nach oben oder nach unten
    einschränken (im Sinne einer Vererbungshierarchie)
    -   `extends`: Der Typ-Parameter bzw. die Wildcard muss eine Unterklasse eines
        bestimmten Typen sein
    -   `super`: Die Wildcard muss eine Oberklasse eines bestimmten Typen sein

::: readings
Lesen Sie zu diesem Thema auch in den Oracle-Tutorials
["Wildcards"](https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html)
und ["More Fun with
Wildcards"](https://docs.oracle.com/javase/tutorial/extra/generics/morefun.html)
sowie im dev.java-Tutorial ["Wildcards"](https://dev.java/learn/generics/wildcards/)
nach.
:::

::: outcomes
-   k3: Ich kann Wildcards und Bounds bei generischen Klassen/Methoden einsetzen
:::

::: challenges
**Spieler, Mannschaften und Ligen** Modellieren Sie in Java verschiedene
Spielertypen sowie generische Mannschaften und Ligen, die jeweils bestimmte Spieler
(-typen) bzw. Mannschaften aufnehmen können.

1.  Implementieren Sie die Klasse `Spieler`, die das Interface `ISpieler` erfüllt.

    ``` java
    public interface ISpieler {
        String getName();
    }
    ```

2.  Implementieren Sie die beiden Klassen `FussballSpieler` und `BasketballSpieler`
    und sorgen Sie dafür, dass beide Klassen vom Compiler als Spieler betrachtet
    werden (geeignete Vererbungshierarchie).

3.  Betrachten Sie das nicht-generische Interface `IMannschaft`. Erstellen Sie
    daraus ein generisches Interface `IMannschaft` mit einer Typ-Variablen. Stellen
    Sie durch geeignete Beschränkung der Typ-Variablen sicher, dass nur Mannschaften
    mit von `ISpieler` abgeleiteten Spielern gebildet werden können.

    ``` java
    public interface IMannschaft {
        boolean aufnehmen(ISpieler spieler);
        boolean rauswerfen(ISpieler spieler);
    }
    ```

4.  Betrachten Sie das nicht-generische Interface `ILiga`. Erstellen Sie daraus ein
    generisches Interface `ILiga` mit einer Typvariablen. Stellen Sie durch
    geeignete Beschränkung der Typvariablen sicher, dass nur Ligen mit von
    `IMannschaft` abgeleiteten Mannschaften angelegt werden können.

    ``` java
    public interface ILiga {
        boolean aufnehmen(IMannschaft mannschaft);
        boolean rauswerfen(IMannschaft mannschaft);
    }
    ```

5.  Leiten Sie von `ILiga` das **generische** Interface `IBundesLiga` ab. Stellen
    Sie durch geeignete Formulierung der Typvariablen sicher, dass nur Ligen mit
    Mannschaften angelegt werden können, deren Spieler vom Typ `FussballSpieler`
    (oder abgeleitet) sind.

    Realisieren Sie nun noch die Funktionalität von `IBundesLiga` als
    **nicht-generisches** Interface `IBundesLiga2`.
:::
