---
type: lecture-cg
title: "Generische Klassen & Methoden"
menuTitle: "Klassen & Methoden"
author: "Carsten Gips (FH Bielefeld)"
weight: 1
readings:
  - key: "Ullenboom2021"
    comment: "Kapitel 11.1: Einführung in Java Generics"
  - key: "LernJava"
    comment: "Kapitel Generics"
  - key: "Java-SE-Tutorial"
    comment: "Specialized Trails: Generics"
  - key: "Bloch2018"
tldr: |
  Generische Klassen und Methoden sind ein wichtiger Baustein in der Programmierung mit Java.
  Dabei werden Typ-Variablen eingeführt, die dann bei der Instantiierung der generischen
  Klassen oder beim Aufruf von generischen Methoden mit existierenden Typen konkretisiert
  werden ("Typ-Parameter").

  Syntaktisch definiert man die Typ-Variablen in spitzen Klammern hinter dem Klassennamen bzw.
  vor dem Rückgabetyp einer Methode: `public class Stack<E> { }` und `public <T> T foo(T m) { }`.
outcomes:
  - k1: "Begriffe generischer Typ, parametrisierter Typ, formaler Typ-Parameter, Typ-Parameter"
  - k3: "Erstellen und Nutzen von generischen Klassen und Interfaces"
  - k3: "Erstellen und Nutzen von generischen Methoden"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1106235&client_id=FH-Bielefeld"
    name: "Quiz Generics: Classes & Methods (ILIAS)"
assignments:
  - topic: sheet03
youtube:
  - link: "https://youtu.be/k6MFPW-shh8"
    name: "VL Generische Klassen & Methoden"
  - link: "https://youtu.be/ekXBXge6VvE"
    name: "Demo Generische Methoden"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/5497f0d31a9d0ac4d46e781040b1fd9f20ca7e0103cccc1abe0089c7c36a9251de0126f11fe376341a7b077dcdd43e8683f2c165b895da1a70da6c17d5c4576f"
    name: "VL Generische Klassen & Methoden"
---


## Generische Strukturen

```java
Vector speicher = new Vector();
speicher.add(1); speicher.add(2); speicher.add(3);
speicher.add("huhu");

int summe = 0;
for (Object i : speicher) { summe += (Integer)i; }
```

::: notes
Problem: Nutzung des "*raw*" Typs `Vector` ist nicht typsicher!

*   Mögliche Fehler fallen erst zur Laufzeit und u.U. erst sehr spät auf: Offenbar werden im obigen
    Beispiel `int`-Werte erwartet, d.h. das Hinzufügen von `"huhu"` ist vermutlich ein Versehen (wird
    vom Compiler aber nicht bemerkt)
*   Die Iteration über `speicher` kann nur allgemein als `Object` erfolgen, d.h. in der Schleife muss
    auf den vermuteten/gewünschten Typ gecastet werden: Hier würde dann der String `"huhu"` Probleme
    zur Laufzeit machen
:::

\pause

\bigskip
\smallskip
\hrule
\bigskip

```java
Vector<Integer> speicher = new Vector<Integer>();
speicher.add(1); speicher.add(2); speicher.add(3);
speicher.add("huhu");

int summe = 0;
for (Integer i : speicher) { summe += i; }
```

::: notes
Vorteile beim Einsatz von Generics:

*   Datenstrukturen/Algorithmen nur einmal implementieren, aber für unterschiedliche Typen nutzen
*   Keine Vererbungshierarchie nötig
*   Nutzung ist typsicher, Casting unnötig
*   Geht nur für Referenztypen
*   Beispiel: Collections-API
:::


## Generische Klassen/Interfaces definieren

*   **Definition**: "`<Typ>`" hinter Klassennamen

    ```java
    public class Stack<E> {
        public E push(E item) {
            addElement(item);
            return item;
        }
    }
    ```

    *   `Stack<E>` => Generische (parametrisierte) Klasse (auch: "*generischer Typ*")
    *   `E` => Formaler Typ-Parameter (auch: "*Typ-Variable*")

\pause
\bigskip
\smallskip

*   **Einsatz**:

    ```java
    Stack<Integer> stack = new Stack<Integer>();
    ```

    *   `Integer` => Typ-Parameter
    *   `Stack<Integer>` => Parametrisierter Typ


::::::::: notes
## Generische Klassen instantiieren

*   Typ-Parameter in spitzen Klammern hinter Klasse bzw. Interface

    ```java
    ArrayList<Integer> il = new ArrayList<Integer>();
    ArrayList<Double>  dl = new ArrayList<Double>();
    ```
:::::::::


## Beispiel I: Einfache generische Klassen

\bigskip

```java
class Tutor<T> {
    // T kann in Tutor *fast* wie Klassenname verwendet werden
    private T x;
    public T foo(T t) { ... }
}
```

\smallskip

```java
Tutor<String>  a = new Tutor<String>();
Tutor<Integer> b = new Tutor<>();  // ab Java7: "Diamond Operator"

a.foo("wuppie");
b.foo(1);
b.foo("huhu");  // Fehlermeldung vom Compiler
```

::::::::: notes
[Beispiel: [classes.GenericClasses](https://github.com/Programmiermethoden/PM-Lecture/blob/master/markdown/generics/src/classes/GenericClasses.java)]{.bsp}

### Typ-Inferenz

Typ-Parameter kann bei `new()` auf der rechten Seite oft weggelassen werden
=> **Typ-Inferenz**

```java
Tutor<String> x = new Tutor<>();  // <>: "Diamantoperator"
```

(gilt seit Java 1.7)
:::::::::


## Beispiel II: Vererbung mit Typparametern

```java
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

::: notes
Auch Interfaces und abstrakte Klassen können parametrisierbar sein.

Bei der Vererbung sind alle Varianten bzgl. der Typ-Variablen denkbar.
Zu beachten ist dabei vor allem, dass die Typ-Variablen der Oberklasse (gilt
analog für Interfaces) entweder durch Typ-Variablen der Unterklasse oder durch
konkrete Typen spezifiziert sind. Die Typ-Variablen der Oberklasse dürfen
nicht "in der Luft hängen" (siehe auch nächste Folie)!
:::


## Beispiel III: Überschreiben/Überladen von Methoden

```java
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

```java
class Foo<T> extends T { ... }

class Fluppie<T> extends Wuppie<S> { ... }
```

::: notes
*   Generische Klasse `Foo<T>` kann nicht selbst vom Typ-Parameter `T` ableiten (warum?)
*   Bei Ableiten von generischer Klasse `Wuppie<S>` muss deren Typ-Parameter `S` bestimmt sein:
    etwa durch den Typ-Parameter der ableitenden Klasse, beispielsweise `Fluppie<S>` (statt `Fluppie<T>`)
:::


## Generische Methoden definieren

*   "`<Typ>`" vor Rückgabetyp

    ```java
    public class Mensch {
        public <T> T myst(T m, T n) {
            return Math.random() > 0.5 ? m : n;
        }
    }
    ```

\pause
\bigskip

*   "Mischen possible":

    ```java
    public class Mensch<E> {
        public <T> T myst(T m, T n) { ... }
        public String myst(String m, String n) { ... }
    }
    ```


## Aufruf generischer Methoden

::::::::: notes
### Aufruf

*   Aufruf mit Typ-Parameter vor Methodennamen, oder
*   Inferenz durch Compiler

### Finden der richtigen Methode durch den Compiler

1.  Zuerst Suche nach exakt passender Methode,
2.  danach passend mit Konvertierungen
    => Compiler sucht gemeinsame Oberklasse in Typhierarchie

### Beispiel
:::::::::

```java
class Mensch {
    <T> T myst(T m, T n) { ... }
}
Mensch m = new Mensch();


m.<String>myst("Essen", "lecker");  // Angabe Typ-Parameter


m.myst("Essen", 1);          // String, Integer => T: Object
m.myst("Essen", "lecker");   // String, String  => T: String
m.myst(1.0, 1);              // Double, Integer => T: Number
```

[Beispiel [methods.GenericMethods](https://github.com/Programmiermethoden/PM-Lecture/blob/master/markdown/generics/src/methods/GenericMethods.java)]{.bsp}

::::::::: notes
Reihenfolge der Suche nach passender Methode gilt auch für nicht-generisch überladene Methoden

```java
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
:::::::::


## Wrap-Up

*   Begriffe:
    *   Generischer Typ: `Stack<T>`
    *   Formaler Typ-Parameter: `T`
    *   Parametrisierter Typ:`Stack<Long>`
    *   Typ-Parameter: `Long`
    *   Raw Type: `Stack`

\smallskip

*   Generische Klassen: `public class Stack<E> { }`
    *   "`<Typ>`" hinter Klassennamen

\smallskip

*   Generische Methoden: `public <T> T foo(T m) { }`
    *   "`<Typ>`" vor Rückgabewert







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
