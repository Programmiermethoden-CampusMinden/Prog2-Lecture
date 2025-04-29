---
title: "Type Erasure"
author: "Carsten Gips (HSBI)"
readings:
  - key: "Ullenboom2021"
    comment: "Kapitel 11.2 und 11.6"
  - key: "LernJava"
    comment: "Kapitel Generics"
  - key: "Java-SE-Tutorial"
    comment: "Specialized Trails: Generics"
  - key: "Bloch2018"
tldr: |
  Generics existieren eigentlich nur auf Quellcode-Ebene. Nach der Typ-Prüfung etc.
  entfernt der Compiler alle generischen Typ-Parameter und alle `<...>` (=>
  "Type-Erasure"), d.h. im Byte-Code stehen nur noch Raw-Typen bzw. die oberen
  Typ-Schranken der Typ-Parameter, in der Regel `Object`. Zusätzlich baut der Compiler
  die nötigen Casts ein. Als Anwender merkt man davon nichts, muss das "Type-Erasure"
  wegen der Auswirkungen aber auf dem Radar haben!
outcomes:
  - k2: "Typ-Löschung und Auswirkungen"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106237&client_id=FH-Bielefeld"
    name: "Quiz Generics: Type Erasure (ILIAS)"
youtube:
  - link: "https://youtu.be/vo0WKkPBMAM"
    name: "VL Generics: Type Erasure"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/5fad3671a098d262206f0b0eb995b2d692a6e9914a336b1c28fc99753b0c874a637d310dcdc639afdd200d831b4e3ee5924ea8073b4a32751aebe4fa91c32bef"
    name: "VL Generics: Type Erasure"
---


## Typ-Löschung (_Type-Erasure_)

::: notes
Der Compiler ersetzt nach Prüfung der Typen und ihrer Verwendung alle Typ-Parameter
durch

1.  deren obere (Typ-)Schranke und
2.  passende explizite Cast-Operationen (im Byte-Code).

Die obere Typ-Schranke ist in der Regel der Typ der ersten Bounds-Klausel
oder `Object`, wenn keine Einschränkungen formuliert sind.

Bei parametrisierten Typen wie `List<T>` wird der Typ-Parameter entfernt,
es entsteht ein sogenannter *Raw*-Typ (`List`, quasi implizit mit `Object`
parametrisiert).

=> Ergebnis: Nur **eine** (untypisierte) Klasse! Zur Laufzeit gibt es
keine Generics mehr!

**Hinweis**: In C++ ist man den anderen möglichen Weg gegangen und erzeugt
für jede Instantiierung die passende Klasse. Siehe Modul "Systemprogrammierung" :)


**Beispiel**: Aus dem folgenden harmlosen Code-Fragment:
:::

```java
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

```java
class Studi {
    Object myst(Object m, Object n) { return n; }

    public static void main(String[] args) {
        Studi a = new Studi();
        int i = (Integer) a.myst(1, 3);
    }
}
```

::: notes
Die obere Schranke meist `Object` => `new T()` verboten/sinnfrei (s.u.)!
:::


## Type-Erasure bei Nutzung von Bounds

:::::: columns
::: column

[vor der Typ-Löschung durch Compiler:]{.notes}

```{.java size="footnotesize"}
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

```{.java size="footnotesize"}
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
::::::


## Raw-Types: Ich mag meine Generics "well done" :-)

Raw-Types: Instanziierung ohne Typ-Parameter => `Object`

```java
Stack s = new Stack(); // Stack von Object-Objekten
```

\bigskip

*   Wegen Abwärtskompatibilität zu früheren Java-Versionen noch erlaubt.
*   Nutzung wird nicht empfohlen! (Warum?)

::: notes
### Anmerkung

Raw-Types darf man zwar selbst im Quellcode verwenden (so wie im Beispiel
hier), **sollte** die Verwendung aber vermeiden wegen der Typ-Unsicherheit:
Der Compiler sieht im Beispiel nur noch einen Stack für `Object`, d.h. dort
dürfen Objekte aller Typen abgelegt werden - es kann keine Typprüfung
durch den Compiler stattfinden. Auf einem `Stack<String>` kann der Compiler
prüfen, ob dort wirklich nur `String`-Objekte abgelegt werden und ggf.
entsprechend Fehler melden.

Etwas anderes ist es, dass der Compiler im Zuge von Type-Erasure selbst
Raw-Types in den Byte-Code schreibt. Da hat er vorher bereits die
Typsicherheit geprüft und er baut auch die passenden Casts ein.

Das Thema ist eigentlich nur noch aus Kompatibilität zu Java5 oder früher
da, weil es dort noch keine Generics gab (wurden erst mit Java6 eingeführt).
:::


## Folgen der Typ-Löschung: _new_

::: cbox
`new` mit parametrisierten Klassen ist nicht erlaubt!
:::

\bigskip
\bigskip

```java
class Fach<T> {
    public T foo() {
        return new T();  // nicht erlaubt!!!
    }
}
```

\bigskip
Grund: Zur Laufzeit keine Klasseninformationen über `T` mehr

::: notes
Im Code steht `return (CAST) new Object();`. Das neue Object
kann man anlegen, aber ein Cast nach irgendeinem anderen Typ
ist sinnfrei: Jede Klasse ist ein Untertyp von `Object`, aber
eben nicht andersherum. Außerdem fehlt dem Objekt vom Typ
`Object` auch sämtliche Information und Verhalten, die der
Cast-Typ eigentlich mitbringt ...
:::


## Folgen der Typ-Löschung: _static_

::: cbox
`static` mit generischen Typen ist nicht erlaubt!
:::

\bigskip
\bigskip

```java
class Fach<T> {
    static T t;                    // nicht erlaubt!!!
    static Fach<T> c;              // nicht erlaubt!!!
    static void foo(T t) { ... };  // nicht erlaubt!!!
}

Fach<String>  a;
Fach<Integer> b;
```

\bigskip
Grund: Compiler generiert nur eine Klasse! Beide Objekte würden
sich die statischen Attribute teilen \newline (Typ zur Laufzeit unklar!).

\smallskip

*Hinweis*: Generische (statische) Methoden sind erlaubt.


## Folgen der Typ-Löschung: _instanceof_

::: cbox
`instanceof` mit parametrisierten Klassen ist nicht erlaubt!
:::

\bigskip
\bigskip

:::::: columns
::: {.column width="60%"}

```java
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

```java
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
::::::


## Folgen der Typ-Löschung: _.class_

::: cbox
`.class` mit parametrisierten Klassen ist nicht erlaubt!
:::

\bigskip
\bigskip

```java
boolean x;
List<String>  a = new ArrayList<String>();
List<Integer> b = new ArrayList<Integer>();

x = (List<String>.class == List<Integer>.class);  // Compiler-Fehler
x = (a.getClass() == b.getClass());               // true
```

\bigskip
Grund: Es gibt nur `List.class` (und kein `List<String>.class` bzw. `List<Integer>.class`)!


## Wrap-Up

-   Generics existieren eigentlich nur auf Quellcode-Ebene
-   "Type-Erasure":
    -   Compiler entfernt [nach Typ-Prüfungen etc.]{.notes}
        generische Typ-Parameter [etc.]{.notes} => im Byte-Code nur noch Raw-Typen
        [bzw. die oberen Typ-Schranken der Typ-Parameter, in der Regel `Object`]{.notes}
    -   Compiler baut passende Casts in Byte-Code ein
    -   Transparent für User; Auswirkungen beachten!
