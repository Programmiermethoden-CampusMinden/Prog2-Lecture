# Generics: Generische Klassen & Methoden

> [!IMPORTANT]
>
> <details open>
>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Generische Klassen und Methoden sind ein wichtiger Baustein in der
> Programmierung mit Java. Dabei werden Typ-Variablen eingeführt, die
> dann bei der Instantiierung der generischen Klassen oder beim Aufruf
> von generischen Methoden mit existierenden Typen konkretisiert werden
> (“Typ-Parameter”).
>
> Syntaktisch definiert man die Typ-Variablen in spitzen Klammern hinter
> dem Klassennamen bzw. vor dem Rückgabetyp einer Methode:
> `public class Stack<E> { }` und `public <T> T foo(T m) { }`.
> </details>

> [!TIP]
>
> <details open>
>
> <summary><strong>🎦 Videos</strong></summary>
>
> - [VL Generische Klassen & Methoden](https://youtu.be/k6MFPW-shh8)
> - [Demo Generische Methoden](https://youtu.be/ekXBXge6VvE)
>
> </details>

## Generische Strukturen

``` java
Vector speicher = new Vector();
speicher.add(1); speicher.add(2); speicher.add(3);
speicher.add("huhu");

int summe = 0;
for (Object i : speicher) { summe += (Integer)i; }
```

Problem: Nutzung des “*raw*” Typs `Vector` ist nicht typsicher!

- Mögliche Fehler fallen erst zur Laufzeit und u.U. erst sehr spät auf:
  Offenbar werden im obigen Beispiel `int`-Werte erwartet, d.h. das
  Hinzufügen von `"huhu"` ist vermutlich ein Versehen (wird vom Compiler
  aber nicht bemerkt)
- Die Iteration über `speicher` kann nur allgemein als `Object`
  erfolgen, d.h. in der Schleife muss auf den vermuteten/gewünschten Typ
  gecastet werden: Hier würde dann der String `"huhu"` Probleme zur
  Laufzeit machen

``` java
Vector<Integer> speicher = new Vector<Integer>();
speicher.add(1); speicher.add(2); speicher.add(3);
speicher.add("huhu");

int summe = 0;
for (Integer i : speicher) { summe += i; }
```

Vorteile beim Einsatz von Generics:

- Datenstrukturen/Algorithmen nur einmal implementieren, aber für
  unterschiedliche Typen nutzen
- Keine Vererbungshierarchie nötig
- Nutzung ist typsicher, Casting unnötig
- Geht nur für Referenztypen
- Beispiel: Collections-API

## Generische Klassen/Interfaces definieren

- **Definition**: “`<Typ>`” hinter Klassennamen

  ``` java
  public class Stack<E> {
      public E push(E item) {
          addElement(item);
          return item;
      }
  }
  ```

  - `Stack<E>` =\> Generische (parametrisierte) Klasse (auch:
    “*generischer Typ*”)
  - `E` =\> Formaler Typ-Parameter (auch: “*Typ-Variable*”)

<!-- -->

- **Einsatz**:

  ``` java
  Stack<Integer> stack = new Stack<Integer>();
  ```

  - `Integer` =\> Typ-Parameter
  - `Stack<Integer>` =\> Parametrisierter Typ

## Generische Klassen instantiieren

- Typ-Parameter in spitzen Klammern hinter Klasse bzw. Interface

  ``` java
  ArrayList<Integer> il = new ArrayList<Integer>();
  ArrayList<Double>  dl = new ArrayList<Double>();
  ```

## Beispiel I: Einfache generische Klassen

``` java
class Tutor<T> {
    // T kann in Tutor *fast* wie Klassenname verwendet werden
    private T x;
    public T foo(T t) { ... }
}
```

``` java
Tutor<String>  a = new Tutor<String>();
Tutor<Integer> b = new Tutor<>();  // ab Java7: "Diamond Operator"

a.foo("wuppie");
b.foo(1);
b.foo("huhu");  // Fehlermeldung vom Compiler
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/classes/GenericClasses.java">Beispiel: classes.GenericClasses</a></p>

### Typ-Inferenz

Typ-Parameter kann bei `new()` auf der rechten Seite oft weggelassen
werden =\> **Typ-Inferenz**

``` java
Tutor<String> x = new Tutor<>();  // <>: "Diamantoperator"
```

(gilt seit Java 1.7)

## Beispiel II: Vererbung mit Typparametern

``` java
interface Fach<T1, T2> {
    public void machWas(T1 a, T2 b);
}

class SHK<T> extends Tutor<T> { ... }

class PM<X, Y, Z> implements Fach<X, Z> {
    public void machWas(X a, Z b) { ... }
    public Y getBla() { ... }
}

class Studi<A,B> extends Person { ... }
class Properties extends Hashtable<Object,Object> { ... }
```

Auch Interfaces und abstrakte Klassen können parametrisierbar sein.

Bei der Vererbung sind alle Varianten bzgl. der Typ-Variablen denkbar.
Zu beachten ist dabei vor allem, dass die Typ-Variablen der Oberklasse
(gilt analog für Interfaces) entweder durch Typ-Variablen der
Unterklasse oder durch konkrete Typen spezifiziert sind. Die
Typ-Variablen der Oberklasse dürfen nicht “in der Luft hängen” (siehe
auch nächste Folie)!

## Beispiel III: Überschreiben/Überladen von Methoden

``` java
class Mensch { ... }

class Studi<T extends Mensch> {
    public void f(T t) { ... }
}

class Prof<T> extends Mensch { ... }

class Tutor extends Studi<Mensch> {
    public void f(Mensch t) { ... }      // Ueberschreiben
    public void f(Tutor t) { ... }       // Ueberladen
}
```

## Vorsicht: So geht es nicht!

``` java
class Foo<T> extends T { ... }

class Fluppie<T> extends Wuppie<S> { ... }
```

- Generische Klasse `Foo<T>` kann nicht selbst vom Typ-Parameter `T`
  ableiten (warum?)
- Bei Ableiten von generischer Klasse `Wuppie<S>` muss deren
  Typ-Parameter `S` bestimmt sein: etwa durch den Typ-Parameter der
  ableitenden Klasse, beispielsweise `Fluppie<S>` (statt `Fluppie<T>`)

## Generische Methoden definieren

- “`<Typ>`” vor Rückgabetyp

  ``` java
  public class Mensch {
      public <T> T myst(T m, T n) {
          return Math.random() > 0.5 ? m : n;
      }
  }
  ```

<!-- -->

- “Mischen possible”:

  ``` java
  public class Mensch<E> {
      public <T> T myst(T m, T n) { ... }
      public String myst(String m, String n) { ... }
  }
  ```

## Aufruf generischer Methoden

### Aufruf

- Aufruf mit Typ-Parameter vor Methodennamen, oder
- Inferenz durch Compiler

### Finden der richtigen Methode durch den Compiler

1.  Zuerst Suche nach exakt passender Methode,
2.  danach passend mit Konvertierungen =\> Compiler sucht gemeinsame
    Oberklasse in Typhierarchie

### Beispiel

``` java
class Mensch {
    <T> T myst(T m, T n) { ... }
}
Mensch m = new Mensch();


m.<String>myst("Essen", "lecker");  // Angabe Typ-Parameter


m.myst("Essen", 1);          // String, Integer => T: Object
m.myst("Essen", "lecker");   // String, String  => T: String
m.myst(1.0, 1);              // Double, Integer => T: Number
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/methods/GenericMethods.java">Beispiel methods.GenericMethods</a></p>

Reihenfolge der Suche nach passender Methode gilt auch für
nicht-generisch überladene Methoden

``` java
class Mensch {
    public <T> T myst(T m, T n) {
        System.out.println("X#myst: T");
        return m;
    }

    // NICHT gleichzeitig erlaubt wg. Typ-Löschung (s.u.):
/*
    public <T1, T2> T1 myst(T1 m, T2 n) {
        System.out.println("X#myst: T");
        return m;
    }
*/

    public String myst(String m, String n) {
        System.out.println("X#myst: String");
        return m;
    }

    public int myst(int m, int n) {
        System.out.println("X#myst: int");
        return m;
    }
}


public class GenericMethods {
    public static void main(String[] args) {
        Mensch m = new Mensch();

        m.myst("Hello World", "m");
        m.myst("Hello World", 1);
        m.myst(3, 4);
        m.myst(m, m);
        m.<Mensch>myst(m, m);
        m.myst(m, 1);
        m.myst(3.0, 4);
        m.<Double>myst(3, 4);
    }
}
```

## Wrap-Up

- Begriffe:
  - Generischer Typ: `Stack<T>`
  - Formaler Typ-Parameter: `T`
  - Parametrisierter Typ:`Stack<Long>`
  - Typ-Parameter: `Long`
  - Raw Type: `Stack`

<!-- -->

- Generische Klassen: `public class Stack<E> { }`
  - “`<Typ>`” hinter Klassennamen

<!-- -->

- Generische Methoden: `public <T> T foo(T m) { }`
  - “`<Typ>`” vor Rückgabewert

## 📖 Zum Nachlesen

- Ullenboom ([2021, 11.1](#ref-Ullenboom2021))
- Oracle Corporation ([2025](#ref-LernJava))
- Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
- Bloch ([2018](#ref-Bloch2018))

> [!NOTE]
>
> <details>
>
> <summary><strong>✅ Lernziele</strong></summary>
>
> - k1: Ich kenne die Begriffe ‘generischer Typ’, ‘parametrisierter
>   Typ’, ‘formaler Typ-Parameter’, ‘Typ-Parameter’
> - k3: Ich kann generische Klassen und Interfaces definieren und
>   praktisch einsetzen
> - k3: Ich kann generische Methoden definieren und praktisch einsetzen
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
