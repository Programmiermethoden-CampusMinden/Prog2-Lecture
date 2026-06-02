---
author: Carsten Gips (HSBI)
title: Sealed‑Typen & Pattern Matching
---

::: tldr
Pattern Matching in modernem Java nimmt Ihnen viel typischen Boilerplate ab: Statt
erst mit `instanceof` den Typ zu prüfen und dann manuell zu casten, können Sie
**Type Patterns** verwenden (`if (obj instanceof String s) {...}` oder
`case IntLiteral lit -> ...` im `switch`). Mit **`switch`-Expressions**
(`switch (...) { case ... -> ... }`) wird `switch` selbst zu einem Ausdruck, der
einen Wert liefert, ohne `break` und Fall‑Through, was den Code kürzer, sicherer und
leichter lesbar macht.

Besonders nützlich wird das in Kombination mit **sealed Interfaces/Klassen und
Records**: Sealed‑Typen legen eine abgeschlossene Menge erlaubter Untertypen fest,
sodass der Compiler prüfen kann, ob ein `switch` wirklich alle Fälle abdeckt
(exhaustive). Records modellieren reine Daten, und mit **Record-Patterns** können
Sie diese Daten direkt im `switch` dekonstruieren
(`case Point(int x, int y) -> ...`), ohne explizite Getter-Aufrufe.

Zusammen ermöglichen Ihnen `record` + `sealed` + Pattern Matching in Java einen
deklarativen, gut typgesicherten Stil - ähnlich wie algebraische Datentypen in
funktionalen Sprachen - mit deutlich weniger Fehlerquellen und Redundanz im Code.
:::

::: youtube
TODO
:::

# Was nervt Sie an diesem Code?

``` java
interface Expr {}
record IntLiteral(int value) implements Expr {}
record Add(Expr left, Expr right) implements Expr {}
record Negate(Expr inner) implements Expr {}

int evalOld(Expr e) {
    if (e instanceof IntLiteral) {
        IntLiteral lit = (IntLiteral) e;
        return lit.value();
    } else if (e instanceof Add) {
        Add add = (Add) e;
        return evalOld(add.left()) + evalOld(add.right());
    } else if (e instanceof Negate) {
        Negate neg = (Negate) e;
        return -evalOld(neg.inner());
    } else {
        throw new IllegalArgumentException("Unknown expression: " + e);
    }
}
```

::: notes
Cast-Boilerplate, fehlende Compiler-Unterstützung (alle Fälle abgedeckt???), fragile
`else`-Kette mit vielen `instanceof`, Redundanzen (Typprüfung plus Cast)

... die modernere Variante würde so gehen:

``` java
int evalWithInstanceofPattern(Expr e) {
    if (e instanceof IntLiteral lit) {
        return lit.value();
    } else if (e instanceof Add add) {
        return evalWithInstanceofPattern(add.left()) + evalWithInstanceofPattern(add.right());
    } else if (e instanceof Negate neg) {
        return -evalWithInstanceofPattern(neg.inner());
    } else {
        throw new IllegalArgumentException("Unknown expression: " + e);
    }
}
```

(Erklärung folgt in den nächsten Folien) ... und es geht noch besser!
:::

# Pattern Matching für `instanceof`

``` java
// vor Java 16:
if (obj instanceof String) {
    String s = (String) obj;
    if (s.length() > 5) {
        IO.println(s.toUpperCase());
    }
}
```

\bigskip

``` java
// modern:
if (obj instanceof String s && s.length() > 5) {
    IO.println(s.toUpperCase());
}
```

::: notes
-   Type Pattern: `String s` ist direkt Teil der `instanceof`-Abfrage
-   Pattern Variable `s` ist nur im `true`-Zweig sichtbar -\> weniger Fehler, kein
    expliziter Cast
:::

# Switch Expressions

::: notes
Rückblick: Das sollte Ihnen bekannt vorkommen:
:::

``` java
switch (day) {
    case MONDAY:
    case FRIDAY:
        IO.println("Almost weekend");
        break;
    default:
        IO.println("Another day");
}
```

\bigskip

::: notes
Moderne Variante als **switch-Expression**:
:::

``` java
String message = switch (day) {
    case MONDAY, FRIDAY -> "Almost weekend";
    case SATURDAY, SUNDAY -> "Weekend!";
    default -> "Another day";
};
```

::: notes
**Beobachtungen**:

-   Klassische Fall-Through-Variante: `case xyz: ... break;`

    ``` java
    switch (x) {
        case 1:
            IO.println("eins");
            // Gefahr: Fall-Through, wenn break fehlt
        case 2:
            IO.println("zwei");
            break;
        default:
            IO.println("andere Zahl");
    }
    ```

-   Moderne Expression-Variante: `case xyz -> ...`

    ``` java
    String result = switch (x) {
        case 1 -> "eins";
        case 2 -> "zwei";
        default -> "andere Zahl";
    };
    ```

    -   Kann **Expression** sein: `switch (...) { ... }` liefert einen **Wert**

    -   Kein Fall-Through: jeder `case` steht für sich; mehrere Werte können
        zusammengefasst werden:

        ``` java
        String result = switch (x) {
            case 1, 2 -> "kleine Zahl";  // mehrere Labels in einem Fall
            case 3 -> "drei";
            default -> "andere Zahl";
        };
        ```

-   Form:

    -   Single-Expression-Case: `case ... -> expression;`

    -   Block-Case: `case ... -> { ...; returnWert; }` via `yield`:

        ``` java
        String result = switch (x) {
            case 1 -> {
                IO.println("Seiteneffekt");
                yield "eins";  // 'yield' ist das 'return' für Switch-Expressions
            }
            default -> "andere Zahl";
        };
        ```

**Vorteile**:

-   Kein `break` mehr, kein Fall-Through
-   Switch liefert einen **Wert** (im Beispiel: `String message`)
-   Scoping ist klarer: der Body hinter `->` ist ein eigener Block (besonders gut
    sichtbar bei `{ ... }`), lokale Variablen sind sauber begrenzt
-   Arrow-Syntax `->` fördert Expression-Style (passt gut zu Lambdas/Streams)
:::

# Type Patterns im `switch`

::: notes
Unsere Klassenhierarchie wie oben, aber diesmal mit **sealed Interface**:
:::

``` java
sealed interface Expr permits IntLiteral, Add, Negate {}

record IntLiteral(int value) implements Expr {}
record Add(Expr left, Expr right) implements Expr {}
record Negate(Expr inner) implements Expr {}
```

::: notes
Bei einem **sealed Interface** kann ich angeben, **wer dieses Interface
implementiert**. Andere Klassen als die in der `permits`-Klausel angegeben Klassen
dürfen das Interface nicht implementieren (und die angegebenen **müssen**).

Mit **sealed Interfaces** kann ich nun einen Switch über den **Typ** von `Expr`
machen:
:::

``` java
int eval(Expr e) {
    return switch (e) {
        case IntLiteral lit -> lit.value();
        case Add add -> eval(add.left()) + eval(add.right());
        case Negate neg -> -eval(neg.inner());
    };
}
```

::::: notes
## Wichtige Punkte:

-   `case IntLiteral lit` ist ein **Type Pattern**: Typprüfung + Cast + Bindung in
    einem Schritt
    -   Type Patterns funktionieren für alle Referenztypen (nicht nur für Records)
    -   Auch `case null` funktioniert wie erwartet
-   Kein `default` nötig wegen `sealed`-Hierarchy: Hier kann der Compiler prüfen, ob
    alle erlaubten Subtypen (`IntLiteral`, `Add`, `Negate`) abgedeckt sind -\>
    **exhaustive switch**
-   Begrenzte Vererbung: Nur die angegebenen Typen (`IntLiteral`, `Add`, `Negate`)
    dürfen `Expr` implementieren/erweitern

::: tip
**Type Pattern** (z.B. `case IntLiteral lit -> ...`) kann für **alle Referenztypen**
verwendet werden, auch ohne `sealed`.

**Exhaustive switch** bekommt man nur, wenn die Hierarchie "geschlossen" ist
(`sealed`/`enum`/`record`).
:::

Wenn Sie eine neue `record Multiply(Expr left, Expr right) implements Expr {}`
hinzufügen, wird der Compiler meckern:

-   wenn sie die `permits`-Klausel des sealed Interface nicht ergänzen (**begrenzte
    Vererbung**)
-   wenn Sie das Pattern im `switch` nicht ergänzen (**exhaustive switch**)

Damit bekommen wir eine deutlich bessere Compiler-Unterstützung bei Änderungen: Wenn
neue Varianten hinzugefügt werden, werden alle relevanten `switch`-Stellen gefunden
und geprüft. Das resultiert in einem besseren Typsicherheits-Check im Vergleich mit
einem `default`-Case, der stillschweigen die neuen Varianten subsummieren würde.
(Dies ist ähnlich wie bei Algebraischen Datentypen in funktionalen Sprachen.)

## Weiterer Nutzen von `sealed` (jenseits von `switch`)

-   Modellierung: Sie drücken im Typensystem aus: "Diese Menge von Subtypen ist
    abgeschlossen." Das ist fachlich sinnvoll (z.B.
    `Shape = Circle | Rectangle | Square`), nicht nur ein Compiler-Trick.
-   Sicherheit/Kapselung: Bibliotheksautoren können verhindern, dass fremder Code
    beliebige zusätzliche Implementierungen einschmuggelt.
-   Lesbarkeit / Wartbarkeit: Andere Entwickler sehen sofort, welche Untertypen es
    geben darf, ohne das ganze Projekt durchsuchen zu müssen.

::: tip
Sealed-Typen sind die Java-Variante von "abgeschlossenen Summentypen" / ADTs
([*algebraic data types*](https://en.wikipedia.org/wiki/Algebraic_data_type)). Sie
helfen dem Compiler beim Pattern Matching und helfen Ihnen beim Modellieren einer
endlichen Menge von Varianten.
:::

## Hinweis:

Wenn Sie die lange `permits`-Aufzählung stört, können Sie die Klassen auch direkt im
sealed-Interface definieren:

``` java
sealed interface Expr {
    record IntLiteral(int value) implements Expr {}
    record Add(Expr left, Expr right) implements Expr {}
    record Negate(Expr inner) implements Expr {}
}
```

Nachteil: Statt `case Add add ->` muss es dann `case Expr.Add add ->` heissen ...
:::::

# Guarded Patterns im `switch`

``` java
int sign(Expr e) {
    return switch (e) {
        case Expr.IntLiteral lit when lit.value() > 0 -> 1;
        case Expr.IntLiteral lit when lit.value() < 0 -> -1;
        case Expr.IntLiteral lit -> 0;
        default -> throw new IllegalArgumentException("Not a literal: " + e);
    };
}
```

:::: notes
-   `case Expr.IntLiteral lit when lit.value() > 0` ist ein Pattern mit zusätzlicher
    Bedingung (*Guard*)
-   Lesbarkeit oft besser als verschachtelte `if`-Blöcke.

::: caution
Achtung: Im `switch`-Pattern-Matching wird die Zusatzbedingung mit `when`
geschrieben, nicht mit `&&` wie bei `if`.
:::
::::

# Record-Patterns / Dekonstruktion

::: notes
In einem Spiel könnte ein Punkt so modelliert werden:
:::

``` java
record Point(int x, int y) {}
```

::: notes
Wenn ich in älteren Java-Versionen die Manhattan-Distanz eines Objekts zum Ursprung
bestimmen wollte, dann musste ich nach dem Typ des Objekts fragen und entweder
(falscher Typ) eine Exception werfen oder (korrekter Typ, also `Point`) einen Cast
machen und dann den Abstand ausrechnen und dabei die Attribute des `Point` per
Getter abfragen:
:::

``` java
static int manhattan(Object o) {
    if (o instanceof Point) {
        Point p = (Point) o;
        return Math.abs(p.x()) + Math.abs(p.y());
    }
    throw new IllegalArgumentException("Not a point: " + o);
}
```

\pause
\bigskip

::: notes
Mit Pattern Matching und Record-Pattern kann ich das alles elegant in einem `switch`
machen:
:::

``` java
static int manhattan(Object o) {
    return switch (o) {
        case Point(int x, int y) -> Math.abs(x) + Math.abs(y);
        default -> throw new IllegalArgumentException("Not a point: " + o);
    };
}
```

::::: notes
-   Im `switch` wird nach dem konkreten Typ von `o` geschaut:
    -   kein separates `instanceof` notwendig
    -   kein separater Cast notwendig
-   `case Point(int x, int y)` de-strukturiert das Record:
    -   Verwendet implizit den Konstruktor von `Point`
    -   Felder werden direkt in lokale Variablen gemappt
    -   Kein expliziter Getter-Aufruf mehr im Body nötig
-   Das De-Konstruieren klappt für Record-Typen auch im `instanceof`:
    `o instanceof Point(int x, int y)`
-   Derzeit klappt das leider nur mit den **kanonischen Konstruktoren** der
    Record-Klassen!

::: tip
Das geht auch verschachtelt:

``` java
sealed interface Command permits Move, DrawLine, SetColor {}

record Move(Point to) implements Command {}
record DrawLine(Point from, Point to) implements Command {}
record SetColor(int r, int g, int b) implements Command {}
```

Nun ein Switch mit verschachtelten Record-Patterns:

``` java
void handle(Command cmd) {
    switch (cmd) {
        case Move(Point(int x, int y)) -> IO.println("Move cursor to " + x + "," + y);
        case DrawLine(Point(int x1, int y1), Point(int x2, int y2)) -> IO.println("Draw line from " + x1 + "," + y1 + " to " + x2 + "," + y2);
        case SetColor(int r, int g, int b) -> IO.println("Set color to RGB(" + r + "," + g + "," + b + ")");
    }
}
```

Hier sieht man:

-   Nested Patterns: `Move(Point(int x, int y))` -\> sofort Zugriff auf `x`, `y`
-   Kombiniert mit `sealed` bekommen Sie wieder einen **exhaustive** Switch ohne
    `default`
:::

::: important
Record-Patterns dekonstruieren tatsächlich nur Records (also Klassen, die mit
`record` deklariert wurden)

Die Pattern-Match-Fähigkeiten werden kontinuierlich ausgebaut: Für "normale" Klassen
(klassisches `class`) gibt es noch keine allgemeine Dekonstruktion per Pattern.
(Stand Java 25)
:::
:::::

::: notes
# Verbindung zu "funktionalem Stil"

-   Pattern Matching + Switch-Expressions ermöglichen **ausdrucksbasierten** Stil,
    ähnlich wie in funktionalen Sprachen (Haskell, Scala, ...)
-   Dadurch lassen sich Datenstrukturen (Records, Sealed Hierarchies) klar und knapp
    "entpacken"
-   Die Kombination aus:
    -   `record` (für Daten),
    -   `sealed` (für abgeschlossene Hierarchien),
    -   Pattern Matching (`instanceof`, `switch`, Record-Patterns) erlaubt einen
        deklarativen Stil, ideal z.B. in Kombination mit Streams/Optionals

Beispiel: Liste von `Expr` filtern und auswerten (nur Literale):

``` java
List<Expr> exprs = List.of(
    new IntLiteral(1),
    new Add(new IntLiteral(2), new IntLiteral(3)),
    new Negate(new IntLiteral(4))
);

int sumOfLiterals = exprs.stream()
    .mapToInt(e -> switch (e) {
        case IntLiteral lit -> lit.value();
        default -> 0; // neutrales Element bzgl. der Summe
    })
    .sum();
```
:::

# Wrap-Up

Für Datenhierarchien (z.B. `Expr`, `Shape`, `Command`) nutzen Sie heute:

-   `record` für Daten,
-   `sealed` für eine abgeschlossene Variantenmenge, und
-   Pattern Matching im modernen `switch` (mit Arrow-Syntax) für knappen,
    typsicheren und gut wartbaren Code im (teilweise) funktionalen Stil.

:::: readings
Lesen Sie zu diesem Thema auch in den Oracle-Tutorials ["Using Pattern Matching"
(Oracle)](https://dev.java/learn/pattern-matching/) nach.

::: important
Das Thema Pattern Matching ist aktuell in aktiver Entwicklung. Einige Features haben
es bereits in die verschiedenen Releases geschafft, andere stecken aktuell noch in
der Pipeline. Halten Sie die Augen offen - es kann auch passieren, dass bereits
verabschiedete Syntax nachträglich noch einmal zurückgenommen und geändert wird. Das
[Project Amber](https://openjdk.org/projects/amber/) ist die zentrale Stelle für
alle Entwicklungen rund um Pattern Matching in Java.
:::
::::

::: outcomes
-   k2: Ich kann erklären, was `sealed` Typen, Records und Pattern Matching in Java
    leisten.
-   k3: Ich kann einfache `sealed` Hierarchien mit Records modellieren und per
    `switch`-Expression auswerten.
:::

::: challenges
Definieren Sie eine kleine Shape-Hierarchie mit `sealed` und berechnen Sie
Fläche/Umfang per `switch` + Record-Patterns

``` java
sealed interface Shape permits Circle, Rectangle, Square {}

record Circle(double radius) implements Shape {}
record Rectangle(double width, double height) implements Shape {}
record Square(double side) implements Shape {}
```

<!--
```java
double area(Shape s) {
    return switch (s) {
        case Circle(double r) -> Math.PI * r * r;
        case Rectangle(double w, double h) -> w * h;
        case Square(double a) -> a * a;
    };
}
```
-->
:::
