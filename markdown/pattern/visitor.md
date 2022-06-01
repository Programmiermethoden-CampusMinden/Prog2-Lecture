---
type: lecture-cg
title: "Visitor-Pattern"
menuTitle: "Visitor"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
readings:
  - key: "Eilebrecht2013"
  - key: "Gamma2011"
  - key: "Kleuker2018"
tldr: |
    Visitor-Pattern: Auslagern der Traversierung in eigene Klassenstruktur

    \bigskip

    *   Klassen der Datenstruktur
        *   bekommen eine `accept()`-Methode für einen Visitor
        *   rufen den Visitor mit sich selbst als Argument auf
    *   Visitor
        *   hat für jede Klasse eine Überladung der `visit()`-Methode
        *   Rückgabewerte schwierig: Intern halten oder per `return`
            [(dann aber unterschiedliche `visit()`-Methoden für die verschiedenen Rückgabetypen!)]{.notes}
    *   (Double-) Dispatch: Zur Laufzeit wird in `accept()` der Typ des Visitors
        aufgelöst und in `visit()` der Typ der zu besuchenden Klasse?
outcomes:
  - k2: "Aufbau des Visitor-Patterns (Besucher-Entwurfsmusters)"
  - k3: "Anwendung des Visitor-Patterns auf konkrete Beispiele, etwa den PM-Dungeon"
quizzes:
  - link: ""
    name: "Quiz Visitor-Pattern (ILIAS)"
assignments:
  - topic: sheet09
youtube:
  - link: ""
    name: "VL Visitor-Pattern"
  - link: ""
    name: "Demo Visitor-Pattern"
fhmedia:
  - link: ""
    name: "VL Visitor-Pattern"
---


## Motivation: Parsen von "5*4+3"

::::::::: {.columns}
:::::: {.column width="50%"}

::: notes
Zum Parsen von Ausdrücken (_Expressions_) könnte man diese einfache Grammatik
einsetzen. Ein Ausdruck ist dabei entweder ein einfacher Integer oder eine
Addition oder Multiplikation zweier Ausdrücke.
:::

```yacc
expr : e1=expr '*' e2=expr      # MUL
     | e1=expr '+' e2=expr      # ADD
     | INT                      # NUM
     ;
```

::::::
:::::: {.column width="40%"}

::: notes
Beim Parsen von "5*4+3" würde dabei der folgende Parsetree entstehen:
:::

![](images/parsetree.png){width="60%"}

::::::
:::::::::


## Strukturen für den Parsetree

![](images/parsetree_classes_uml.png){width="70%"}

::: notes
Der Parsetree für diese einfache Grammatik ist ein Binärbaum. Die Regeln
werden auf Knoten im Baum zurückgeführt. Es gibt Knoten mit zwei Kindknoten,
und es gibt Knoten ohne Kindknoten ("Blätter").

Entsprechend kann man sich einfache Klassen definieren, die die verschiedenen
Knoten in diesem Parsetree repräsentieren. Als Obertyp könnte es ein (noch
leeres) Interface `Expr` geben.
:::


## Ergänzung I: Ausrechnen des Ausdrucks

::: notes
Es wäre nun schön, wenn man mit dem Parsetree etwas anfangen könnte. Vielleicht
möchte man den Ausdruck ausrechnen?
:::

![](images/parsetree_eval_uml.png){width="70%"}

::: notes
Zum Ausrechnen des Ausdrucks könnte man dem Interface eine `eval()`-Methode
spendieren. Jeder Knoten kann für sich entscheiden, wie die entsprechende
Operation ausgewertet werden soll: Bei einer `NumExpr` ist dies einfach der
gespeicherte Wert, bei Addition oder Multiplikation entsprechend die Addition
oder Multiplikation der Auswertungsergebnisse der beiden Kindknoten.
:::


## Ergänzung II: Pretty-Print des Ausdrucks

::: notes
Nachdem das Ausrechnen so gut geklappt hat, will der Chef nun noch flink eine Funktion,
mit der man den Ausdruck hübsch ausgeben kann:
:::

![](images/parsetree_eval_print_uml.png){width="70%"}

::: notes
Das fängt an, sich zu wiederholen. Wir implementieren immer wieder ähnliche Strukturen,
mit denen wir diesen Parsetree traversieren ... Und wir müssen für _jede_ Erweiterung
immer _alle_ Expression-Klassen anpassen!

[Beispiel: [direct.DemoExpr](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/pattern/src/visitor/direct/DemoExpr.java)]{.bsp}
:::

\vfill

**Das geht besser.**


## Visitor-Pattern (Besucher-Entwurfsmuster)

![](images/visitor.png){web_width="60%"}

[[Hinweis: Implementierungsdetail Traversierung]{.bsp}]{.slides}

::: notes
Das Entwurfsmuster "Besucher" (_Visitor Pattern_) lagert die Aktion beim Besuchen eines
Knotens in eine separate Klasse aus.

Dazu bekommt jeder Knoten im Baum eine neue Methode, die einen Besucher akzeptiert.
Dieser Besucher kümmert sich dann um die entsprechende Verarbeitung des Knotens, also
um das Auswerten oder Ausgeben im obigen Beispiel.

Die Besucher haben eine Methode, die für jeden zu bearbeitenden Knoten überladen wird.
In dieser Methode findet dann die eigentliche Verarbeitung statt: Auswerten des Knotens
oder Ausgeben des Knotens ...

### Implementierungsdetail

In den beiden Klasse `AddExpr` und `MulExpr` müssen auch die beiden Kindknoten besucht
werden, d.h. hier muss der Baum weiter traversiert werden.

Man kann sich überlegen, diese Traversierung in den Klassen `AddExpr` und `MulExpr`
selbst anzustoßen.

Alternativ könnte auch der Visitor die Traversierung vornehmen. Gerade bei der Traversierung
von Datenstrukturen ist diese Variante oft von Vorteil, da man hier unterschiedliche
Traversierungsarten haben möchte (Breitensuche vs. Tiefensuche, Pre-Order vs. Inorder vs.
Post-Order, ...) und diese elegant in den Visitor verlagern kann.

[Beispiel Traversierung intern (in den Knotenklassen): [intrav.DemoExpr](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/pattern/src/visitor/intrav/DemoExpr.java)]{.bsp}

[Beispiel Traversierung extern (im Visitor): [extrav.DemoExpr](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/pattern/src/visitor/extrav/DemoExpr.java)]{.bsp}

### (Double-) Dispatch

Zur Laufzeit wird in `accept()` der Typ des Visitors aufgelöst und dann in `visit()` der
Typ der zu besuchenden Klasse. Dies nennt man auch "Double-Dispatch".

### Hinweis

Man könnte versucht sein, die `accept()`-Methode aus den Knotenklassen in die gemeinsame
Basisklasse zu verlagern: Statt

```java
    public void accept(ExprVisitor v) {
        v.visit(this);
    }
```

in _jeder_ Knotenklasse zu definieren, könnte man das doch _einmalig_ in der Basisklasse
definieren:

```java
public abstract class Expr {
    /** Akzeptiere einen Visitor für die Verarbeitung */
    public void accept(ExprVisitor v) {
        v.visit(this);
    }
}
```

Dies wäre tatsächlich schön, weil man so Code-Duplizierung vermeiden könnte. Aber es
funktioniert in Java leider nicht. (Warum?)
:::


## Ausrechnen des Ausdrucks mit einem Visitor

![](images/parsetree_visitor_uml.png){web_width="60%"}

[Demo: [extrav.DemoExpr](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/pattern/src/visitor/extrav/DemoExpr.java)]{.bsp}


## Wrap-Up

**Visitor-Pattern**: Auslagern der Traversierung in eigene Klassenstruktur

\bigskip
\smallskip

*   Klassen der Datenstruktur
    *   bekommen eine `accept()`-Methode für einen Visitor
    *   rufen den Visitor mit sich selbst als Argument auf

\smallskip

*   Visitor
    *   hat für jede Klasse eine Überladung der `visit()`-Methode
    *   Rückgabewerte schwierig: Intern halten oder per `return`
        [(dann aber unterschiedliche `visit()`-Methoden für die verschiedenen Rückgabetypen!)]{.notes}

\smallskip

*   (Double-) Dispatch: Zur Laufzeit wird in `accept()` der Typ des Visitors
    und in `visit()` der Typ der zu besuchenden Klasse aufgelöst







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
