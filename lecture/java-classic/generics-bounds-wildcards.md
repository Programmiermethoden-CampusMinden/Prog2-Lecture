# Generics: Bounds & Wildcards

> [!IMPORTANT]
>
> <details open>
>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Typ-Variablen können weiter eingeschränkt werden, in dem man einen
> verpflichtenden Ober- oder Untertyp angibt mit `extends` bzw. `super`.
> Damit muss der später bei der Instantiierung verwendete Typ-Parameter
> entweder die Oberklasse selbst sein oder davon ableiten (bei
> `extends`) bzw. der Typ-Parameter muss eine Oberklasse der angegebenen
> Schranke sein (`super`).
>
> Durch die Einschränkung mit `extends` können in der Klasse/Methode auf
> der Typ-Variablen alle Methoden des angegebenen Obertyps verwendet
> werden.
>
> Ein Wildcard (`?`) als Typ-Parameter steht für einen beliebigen Typ,
> wobei die Typ-Variable keinen Namen bekommt und damit innerhalb der
> Klasse/Methode nicht zugreifbar ist.
> </details>

> [!TIP]
>
> <details open>
>
> <summary><strong>🎦 Videos</strong></summary>
>
> - [VL Generics: Bounds & Wildcards](https://youtu.be/OV2vEn2EkWo)
> - [Demo Wildcards](https://youtu.be/D2hIicsho7I)
>
> </details>

## Bounds: Einschränken der generischen Typen

``` java
public class Cps<E extends Number> {
    // Obere Schranke: E muss Number oder Subklasse sein
    // => Zugriff auf Methoden aus Number moeglich
}
Cps<Double> a;
Cps<Number> b;
Cps<String> c;  // Fehler!!!
```

- Schlüsselwort `extends` gilt hier auch für Interfaces

- Mehrere Interfaces: nach `extends` Klasse oder Interface, danach mit
  “`&`” getrennt die restlichen Interfaces:

  ``` java
  class Cps<E extends KlasseOderInterface & I1 & I2 & I3> {}
  ```

*Anmerkung*: Der Typ-Parameter ist analog auch mit `super` (nach unten)
einschränkbar

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/bounds/Cps.java">Beispiel bounds.Cps</a></p>

## Wildcards: Dieser Typ ist mir nicht so wichtig

<div align="center">

Wildcard mit “`?`” =\> steht für unbestimmten Typ

</div>

``` java
public class Wuppie {
    public void m1(List<?> a) { ... }
    public void m2(List<? extends Number> b) { ... }
}
```

- `m1`: `List` beliebig parametrisierbar =\> In `m1` für Objekte in
  Liste `a` nur Methoden von `Object` nutzbar!

- `m2`: `List` muss mit `Number` oder Subklasse parametrisiert werden.
  =\> Dadurch für Objekte in Liste `b` alle Methoden von `Number`
  nutzbar …

Weitere Eigenschaften:

- Durch Wildcard kein Zugriff auf den Typ
- Wildcard kann durch upper bound eingeschränkt werden
- Geht nicht bei Klassen-/Interface-Definitionen

Bloch ([2018](#ref-Bloch2018)): Nur für Parameter und nicht für
Rückgabewerte nutzen!

## Hands-On: Ausgabe für generische Listen

Ausgabe für Listen gesucht, die sowohl Elemente der Klasse `A` als auch
Elemente der Klasse `B` enthalten können

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

**Hinweis**: Dieses Beispiel beinhaltet auch Polymorphie bei/mit
generischen Datentypen, bitte vorher auch das Video zum vierten Teil
“Generics und Polymorphie” anschauen

### Erster Versuch (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

=\> **So gehts nicht!** Eine `List<B>` ist **keine** `List<A>` (auch
wenn ein `B` ein `A` ist, vgl. spätere Sitzung zu Generics und Vererbung
…)!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/wildcards/v1/X.java">Beispiel wildcards.v1.X</a></p>

### Zweiter Versuch mit Wildcards (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<?> list) {
        for (Object a : list) { a.printInfo(); }
    }
}
```

=\> **So gehts auch nicht!** Im Prinzip passt das jetzt für `List<A>`
und `List<B>`. Dummerweise hat man durch das Wildcard keinen Zugriff
mehr auf den Typ-Parameter und muss für den Typ der Laufvariablen in der
`for`-Schleife dann `Object` nehmen. Aber `Object` kennt unser
`printInfo` nicht … Außerdem könnte man die Methode `X#printInfo` dank
des Wildcards auch mit allen anderen Typen aufrufen …

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/wildcards/v2/X.java">Beispiel wildcards.v2.X</a></p>

### Dritter Versuch (Lösung) mit Wildcards und Bounds (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<? extends A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

Das ist die Lösung. Man erlaubt als Argument nur `List`-Objekte und
fordert, dass sie mit `A` oder einer Unterklasse von `A` parametrisiert
sind. D.h. in der Schleife kann man sich auf den gemeinsamen Obertyp `A`
abstützen und hat dann auch wieder die `printInfo`-Methode zur Verfügung
…

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/wildcards/v3">Konsole wildcards.v3.X</a></p>

## Wrap-Up

- Ein Wildcard (`?`) als Typ-Parameter steht für einen beliebigen Typ
  - Ist in Klasse oder Methode dann aber nicht mehr zugreifbar

<!-- -->

- Mit Bounds kann man Typ-Parameter nach oben oder nach unten
  einschränken (im Sinne einer Vererbungshierarchie)
  - `extends`: Der Typ-Parameter muss eine Unterklasse eines bestimmten
    Typen sein
  - `super`: Der Typ-Parameter muss eine Oberklasse eines bestimmten
    Typen sein

## 📖 Zum Nachlesen

- Ullenboom ([2021, 11.3](#ref-Ullenboom2021))
- Oracle Corporation ([2025](#ref-LernJava))
- Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
- Bloch ([2018](#ref-Bloch2018))

> [!NOTE]
>
> <details>
>
> <summary><strong>✅ Lernziele</strong></summary>
>
> - k3: Ich kann Wildcards und Bounds bei generischen Klassen/Methoden
>   einsetzen
>
> </details>

> [!TIP]
>
> <details>
>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Spieler, Mannschaften und Ligen** Modellieren Sie in Java
> verschiedene Spielertypen sowie generische Mannschaften und Ligen, die
> jeweils bestimmte Spieler (-typen) bzw. Mannschaften aufnehmen können.
>
> 1.  Implementieren Sie die Klasse `Spieler`, die das Interface
>     `ISpieler` erfüllt.
>
>     ``` java
>     public interface ISpieler {
>         String getName();
>     }
>     ```
>
> 2.  Implementieren Sie die beiden Klassen `FussballSpieler` und
>     `BasketballSpieler` und sorgen Sie dafür, dass beide Klassen vom
>     Compiler als Spieler betrachtet werden (geeignete
>     Vererbungshierarchie).
>
> 3.  Betrachten Sie das nicht-generische Interface `IMannschaft`.
>     Erstellen Sie daraus ein generisches Interface `IMannschaft` mit
>     einer Typ-Variablen. Stellen Sie durch geeignete Beschränkung der
>     Typ-Variablen sicher, dass nur Mannschaften mit von `ISpieler`
>     abgeleiteten Spielern gebildet werden können.
>
>     ``` java
>     public interface IMannschaft {
>         boolean aufnehmen(ISpieler spieler);
>         boolean rauswerfen(ISpieler spieler);
>     }
>     ```
>
> 4.  Betrachten Sie das nicht-generische Interface `ILiga`. Erstellen
>     Sie daraus ein generisches Interface `ILiga` mit einer
>     Typvariablen. Stellen Sie durch geeignete Beschränkung der
>     Typvariablen sicher, dass nur Ligen mit von `IMannschaft`
>     abgeleiteten Mannschaften angelegt werden können.
>
>     ``` java
>     public interface ILiga {
>         boolean aufnehmen(IMannschaft mannschaft);
>         boolean rauswerfen(IMannschaft mannschaft);
>     }
>     ```
>
> 5.  Leiten Sie von `ILiga` das **generische** Interface `IBundesLiga`
>     ab. Stellen Sie durch geeignete Formulierung der Typvariablen
>     sicher, dass nur Ligen mit Mannschaften angelegt werden können,
>     deren Spieler vom Typ `FussballSpieler` (oder abgeleitet) sind.
>
>     Realisieren Sie nun noch die Funktionalität von `IBundesLiga` als
>     **nicht-generisches** Interface `IBundesLiga2`.
>
> </details>

------------------------------------------------------------------------

> [!NOTE]
>
> <details>
>
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
> Oracle Corporation. 2024. „The Java Tutorials“.
> <https://docs.oracle.com/javase/tutorial/>.
>
> </div>
>
> <div id="ref-LernJava" class="csl-entry">
>
> Oracle Corporation. 2025. „Learn Java“. <https://dev.java/learn/>.
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

<img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png" width="10%">

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> 95a02cf (markdown: switch to leaner yaml header (#1037), 2025-08-09)<br></sub></sup></p></blockquote>
