---
author: Carsten Gips (HSBI)
title: Visitor-Pattern
---

::: tldr
Häufig bietet es sich bei Datenstrukturen an, die Traversierung nicht direkt in den
Klassen der Datenstrukturen zu implementieren, sondern in Hilfsklassen zu verlagern.
Dies gilt vor allem dann, wenn die Datenstruktur aus mehreren Klassen besteht (etwa
ein Baum mit verschiedenen Knotentypen) und/oder wenn man nicht nur eine
Traversierungsart ermöglichen will oder/und wenn man immer wieder neue Arten der
Traversierung ergänzen will. Das würde nämlich bedeuten, dass man für jede weitere
Form der Traversierung in *allen* Klassen eine entsprechende neue Methode
implementieren müsste.

Das Visitor-Pattern lagert die Traversierung in eigene Klassenstruktur aus.

Die Klassen der Datenstruktur bekommen nur noch eine `accept()`-Methode, in der ein
Visitor übergeben wird und rufen auf diesem Visitor einfach dessen `visit()`-Methode
auf (mit einer Referenz auf sich selbst als Argument).

Der Visitor hat für jede Klasse der Datenstruktur eine Überladung der
`visit()`-Methode. In diesen kann er je nach Klasse die gewünschte Verarbeitung
vornehmen. Üblicherweise gibt es ein Interface oder eine abstrakte Klasse für die
Visitoren, von denen dann konkrete Visitoren ableiten.

Bei Elementen mit "Kindern" muss man sich entscheiden, wie die Traversierung
implementiert werden soll. Man könnte in der `accept()`-Methode den Visitor an die
Kinder weiter reichen (also auf den Kindern `accept()` mit dem Visitor aufrufen),
bevor man die `visit()`-Methode des Visitors mit sich selbst als Referenz aufruft.
Damit ist die Form der Traversierung in den Klassen der Datenstruktur fest verankert
und über den Visitor findet "nur" noch eine unterschiedliche Form der Verarbeitung
statt. Alternativ überlässt man es dem Visitor, die Traversierung durchzuführen:
Hier muss in den `visit()`-Methoden für die einzelnen Elemente entsprechend auf
mögliche Kinder reagiert werden.

In diesem Pattern spricht man von "Double-Dispatch":

-   Zur Compile‑Zeit ist bei einem Aufruf wie `e.accept(v)` nur der Obertyp `Expr`
    bekannt. Zur **Laufzeit** entscheidet der tatsächliche Typ von `e` (z.B.
    `AddExpr`), welche konkrete `accept`‑Methode ausgeführt wird. -\> *erster
    Dispatch*: dynamischer Dispatch auf das **Element**.
-   In der jeweiligen `accept`‑Methode steht dann z.B. `v.visit(this)`. Der
    **statische** Typ von `this` ist dort z.B. `AddExpr`, dadurch ist zur
    Compile‑Zeit klar, welche `visit`‑Überladung gemeint ist (`visit(AddExpr)`). Zur
    **Laufzeit** entscheidet der tatsächliche Typ von `v` (z.B. `EvalVisitor`
    vs. `PrintVisitor`), welche Implementierung dieser `visit(AddExpr)`‑Methode
    aufgerufen wird. -\> *zweiter Dispatch*: dynamischer Dispatch auf den
    **Visitor**.

Zusammen: Die endgültige Methode ergibt sich aus dem Zusammenspiel des Laufzeittyps
des Elements (welche `accept`‑Methode) und des Laufzeittyps des Visitors (welche
`visit`‑Implementierung für den konkreten Elementtyp).

Das Pattern wird traditionell gern für die Traversierung von Datenstrukturen
eingesetzt. Es hilft aber auch, wenn man einer gewissen Anzahl von Klassen je eine
neue Hilfsmethode hinzufügen möchte - normalerweise müsste man jetzt jede Klasse
einzeln ergänzen. Mit dem Visitor-Pattern muss lediglich ein neuer Visitor mit den
Hilfsmethoden implementiert werden.
:::

::: youtube
-   [VL Visitor-Pattern](https://youtu.be/zW_2oQmjp8M)
-   [Demo Visitor-Pattern (Part I: Traversierung ohne
    Visitor)](https://youtu.be/9dvcufpyQdw)
-   [Demo Visitor-Pattern (Part II: Traversierung mit
    Visitor)](https://youtu.be/4rBRkXKhuN4)
:::

# Motivation: Parsen von "5\*4+3"

::::::::: columns
:::: {.column width="50%"}
::: notes
Zum Parsen von Ausdrücken (*Expressions*) könnte man diese einfache Grammatik
einsetzen. Ein Ausdruck ist dabei entweder ein einfacher Integer oder eine Addition
oder Multiplikation zweier Ausdrücke.
:::

``` yacc
add : mul ('+' mul)* ;
mul : num ('*' num)* ;
num : INT ;
```
::::

:::::: {.column width="40%"}
::: notes
Beim Parsen von "5\*4+3" würde dabei der folgende Parse-Tree entstehen:
:::

![](images/parsetree.png){width="50%" web_width="20%"}

:::: notes
::: tip
Anmerkung: Wer genau hinschaut und sich schon die
[ANTLR-Session](../tooling/antlr.md) angeschaut hat, wird merken, dass dieser Baum
tatsächlich *kein* Parse-Tree von ANTRL basierend auf der Grammatik ist. Hier habe
ich schon etwas vorgearbeitet und den Parse-Tree vereinfacht - das nennt man dann
auch oft "Abstract Syntax Tree" (*AST*). Wir werden so eine Transformation von einem
vollständigen Parse-Tree hin zu einem AST auch noch als Übungsaufgabe programmieren
und werden das Visitor-Pattern nutzen, um den Parse-Tree zu traversieren.
:::
::::
::::::
:::::::::

# Erinnerung: Baumstrukturen

::: notes
## Begriffe

-   Ein Baum ist eine **hierarchische Datenstruktur**
    -   besteht aus **Knoten** (Nodes) und **Kanten** (Edges)
    -   es gibt genau **eine Wurzel** (Root)
    -   jeder Knoten (außer der Wurzel) hat **genau einen Elternknoten**
-   Knoten mit Kindern: **innere Knoten**, ohne Kinder: **Blätter**
-   Wichtige Begriffe:
    -   **Tiefe** eines Knotens = Länge des Pfads von der Wurzel bis zu diesem
        Knoten
    -   **Höhe** des Baums = maximale Tiefe eines Knotens
    -   **Pfad**: Folge von Knoten von der Wurzel zu einem Knoten

## Beispiel
:::

                            (Root)
                            /    \
                          (A)    (B)
                          / \      \
                        (C) (D)    (E)

\bigskip
\smallskip

-   Root: `Root`
-   Innere Knoten: `Root`, `A`, `B`
-   Blätter: `C`, `D`, `E`

::: notes
## Typische Einsatzgebiete

-   Dateisystem
-   GUI‑Komponentenbäume
-   **Parsebäume** für Programme/Sprachen

## Brücke zu ANTLR

[ANTLR](../tooling/antlr.md) sind genau solche Bäume:

-   Wurzel = kompletter Input
-   innere Knoten = Grammatikregeln / Sprachkonstrukte
-   Blätter = Tokens
:::

# Erinnerung: Varianten der Datenhaltung

Variante A: **Daten nur in den Blättern**

                            (+)
                           /   \
                         (*)    3
                         / \
                        2   4

\bigskip

Variante B: **Daten in allen Knoten**

# Erinnerung: Implementierungsvarianten

::::::: columns
:::: column
::: notes
**Binäre Bäume (explizite Felder)**

-   zwei Kinder: `left`, `right`
-   typisch für: Binärbäume, Binärsuchbäume, Heaps, ...
:::

``` java
public class BinaryTreeNode {
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public Object value; // Payload
}
```
::::

:::: column
::: notes
**Allgemeine (n‑äre) Bäume (Kinderliste)**

-   beliebig viele Kinder: Speicherung in einer Liste
-   typisch für: **Parsebäume / ASTs**, XML/HTML‑DOM, GUI‑Hierarchien, ...
:::

``` java
public class TreeNode {
    public List<TreeNode> children;

    public Object value; // Payload
}
```
::::
:::::::

\bigskip
\pause

::: notes
Oder auch mit **getrennten Typen für Knoten und Blätter** (hier im Beispiel: Daten
nur in den Blättern):
:::

``` java
public interface Tree {}
public class Node implements Tree {
    Tree leftChild;
    Tree rightChild;
}
public class Leaf implements Tree {
    Object data;
}
```

:::: notes
::: tip
Brücke zu ANTLR:

-   ANTLR‑Parsebäume sind im Wesentlichen **allgemeine (n‑äre) Bäume mit
    Kinderliste**
-   Knoten enthalten typischerweise:
    -   Kontext für eine Grammatikregel (für innere Knoten), oder
    -   ein Token (für Blätter)
:::
::::

::: notes
# Erinnerung: Algorithmische Varianten bei Bäumen

-   **Suchbäume**
    -   Binäre Suchbäume (BST):
        -   Invariante: links $<$ Wert $<$ rechts
    -   Selbstbalancierende Bäume:
        -   **AVL‑Bäume**
        -   **Rot‑Schwarz‑Bäume**
-   **Mehrweg‑Suchbäume**
    -   **B‑Bäume, B+-Bäume**
        -   mehrere Schlüssel und mehrere Kinder pro Knoten
-   **Heaps**
    -   Min‑Heap, Max‑Heap
    -   Grundlage für Prioritätswarteschlangen
-   Einordnung:
    -   Diese Varianten optimieren v.a. **Laufzeiten** (Suchen, Einfügen, Löschen)
    -   Für das **Visitor‑Pattern** heute wichtig:
        -   Wir brauchen "nur" eine Baumstruktur, über die wir systematisch laufen
        -   Ob der Baum balanciert ist oder nicht, ist für das Traversieren
            zweitrangig
:::

# Strukturen für den Parse-Tree

![](images/parsetree_classes_uml.png){width="70%"}

::: notes
Der Parse-Tree für diese einfache Grammatik ist ein Binärbaum. Die Regeln werden auf
Knoten im Baum zurückgeführt. Es gibt Knoten mit zwei Kindknoten, und es gibt Knoten
ohne Kindknoten ("Blätter").

Entsprechend kann man sich einfache Klassen definieren, die die verschiedenen Knoten
in diesem Parse-Tree repräsentieren. Als Obertyp könnte es ein (noch leeres)
Interface `Expr` geben.

``` java
public interface Expr {}

public class NumExpr implements Expr {
    private final int d;

    public NumExpr(int d) { this.d = d; }
}

public class MulExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public MulExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
}

public class AddExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public AddExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
}


public class DemoExpr {
    public static void main(final String... args) {
        // 5*4+3
        Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));
    }
}
```
:::

# Ergänzung I: Ausrechnen des Ausdrucks

::: notes
Es wäre nun schön, wenn man mit dem Parse-Tree etwas anfangen könnte. Vielleicht
möchte man den Ausdruck ausrechnen?
:::

![](images/parsetree_eval_uml.png){width="70%"}

::: notes
Zum Ausrechnen des Ausdrucks könnte man dem Interface eine `eval()`-Methode
spendieren. Jeder Knoten kann für sich entscheiden, wie die entsprechende Operation
ausgewertet werden soll: Bei einer `NumExpr` ist dies einfach der gespeicherte Wert,
bei Addition oder Multiplikation entsprechend die Addition oder Multiplikation der
Auswertungsergebnisse der beiden Kindknoten.

``` java
public interface Expr {
    int eval();
}

public class NumExpr implements Expr {
    private final int d;

    public NumExpr(int d) { this.d = d; }
    public int eval() { return d; }
}

public class MulExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public MulExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public int eval() { return e1.eval() * e2.eval(); }
}

public class AddExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public AddExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public int eval() { return e1.eval() + e2.eval(); }
}


public class DemoExpr {
    public static void main(final String... args) {
        // 5*4+3
        Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));

        int erg = e.eval();
    }
}
```
:::

# Ergänzung II: Pretty-Print des Ausdrucks

::: notes
Nachdem das Ausrechnen so gut geklappt hat, will der Chef nun noch flink eine
Funktion, mit der man den Ausdruck hübsch ausgeben kann:
:::

![](images/parsetree_eval_print_uml.png){width="70%"}

::: notes
[Beispiel: direct.DemoExpr]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/direct/DemoExpr.java"}

Das fängt an, sich zu wiederholen. Wir implementieren immer wieder ähnliche
Strukturen, mit denen wir diesen Parse-Tree traversieren ... Und wir müssen für
*jede* Erweiterung immer *alle* Expression-Klassen anpassen!
:::

::: slides

------------------------------------------------------------------------------------
:::

::: center
**Das geht besser!**
:::

# Visitor-Pattern (Besucher-Entwurfsmuster)

![](images/visitor.png){web_width="80%"}

[[Hinweis: Implementierungsdetails (Traversierung, visit-Methoden)]{.ex}]{.slides}

::::: notes
Das Entwurfsmuster "Besucher" (*Visitor Pattern*) lagert die Aktion beim Besuchen
eines Knotens in eine separate Klasse aus.

Dazu bekommt jeder Knoten im Baum eine neue Methode, die einen Besucher akzeptiert.
Dieser Besucher kümmert sich dann um die entsprechende Verarbeitung des Knotens,
also um das Auswerten oder Ausgeben im obigen Beispiel.

Die Besucher haben eine Methode, die für jeden zu bearbeitenden Knoten überladen
wird. In dieser Methode findet dann die eigentliche Verarbeitung statt: Auswerten
des Knotens oder Ausgeben des Knotens ...

``` java
public interface Expr {
    void accept(ExprVisitor v);
}

public class NumExpr implements Expr {
    private final int d;

    public NumExpr(int d) { this.d = d; }
    public int getValue() { return d; }

    public void accept(ExprVisitor v) { v.visit(this); }
}

public class MulExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public MulExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public Expr getE1() { return e1; }
    public Expr getE2() { return e2; }

    public void accept(ExprVisitor v) { v.visit(this); }
}

public class AddExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public AddExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public Expr getE1() { return e1; }
    public Expr getE2() { return e2; }

    public void accept(ExprVisitor v) { v.visit(this); }
}


public interface ExprVisitor {
    void visit(NumExpr e);
    void visit(MulExpr e);
    void visit(AddExpr e);
}

public class EvalVisitor implements ExprVisitor {
    private final Stack<Integer> erg = new Stack<>();

    public void visit(NumExpr e) { erg.push(e.getValue()); }
    public void visit(MulExpr e) {
        // rechte Seite zuerst in den Stack, damit beim pop() als zweites Argument in die Operation
        // (hier nicht relevant, aber bei nicht-kommutativen Operationen wichtig)
        e.getE2().accept(this); e.getE1().accept(this);
        erg.push(erg.pop() * erg.pop());
    }
    public void visit(AddExpr e) {
        e.getE2().accept(this); e.getE1().accept(this);
        erg.push(erg.pop() + erg.pop());
    }
    public int getResult() { return erg.peek(); }
}

public class PrintVisitor implements ExprVisitor {
    private final Stack<String> erg = new Stack<>();

    public void visit(NumExpr e) { erg.push("NumExpr(" + e.getValue() + ")"); }
    public void visit(MulExpr e) {
        e.getE2().accept(this); e.getE1().accept(this);
        erg.push("MulExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }
    public void visit(AddExpr e) {
        e.getE2().accept(this); e.getE1().accept(this);
        erg.push("AddExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }
    public String getResult() { return erg.peek(); }
}


public class DemoExpr {
    public static void main(final String... args) {
        // 5*4+3
        Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));

        EvalVisitor v1 = new EvalVisitor();
        e.accept(v1);
        int erg = v1.getResult();

        PrintVisitor v2 = new PrintVisitor();
        e.accept(v2);
        String s = v2.getResult();
    }
}
```

## Implementierungsdetail 1: externe vs. interne Traversierung

In den beiden Klasse `AddExpr` und `MulExpr` müssen auch die beiden Kindknoten
besucht werden, d.h. hier muss der Baum weiter traversiert werden.

Man kann sich überlegen, diese Traversierung in den Klassen `AddExpr` und `MulExpr`
selbst anzustoßen.

Alternativ könnte auch der Visitor die Traversierung vornehmen. Gerade bei der
Traversierung von Datenstrukturen ist diese Variante oft von Vorteil, da man hier
unterschiedliche Traversierungsarten haben möchte (Breitensuche vs. Tiefensuche,
Pre-Order vs. Inorder vs. Post-Order, ...) und diese elegant in den Visitor
verlagern kann.

[Beispiel Traversierung intern (in den Knotenklassen):
visitor.visit.intrav.DemoExpr]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/visit/intrav/DemoExpr.java"}

[Beispiel Traversierung extern (im Visitor): visitor.visit.extrav.DemoExpr]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/visit/extrav/DemoExpr.java"}

## Implementierungsdetail 2: Überladene vs. unterschiedlich benannte `visit`‑Methoden

Bisher haben wir das Visitor‑Interface so definiert:

``` java
public interface ExprVisitor {
    void visit(NumExpr e);
    void visit(MulExpr e);
    void visit(AddExpr e);
}
```

Hier wird **eine Methode** `visit(...)` mehrfach mit unterschiedlichen
Parameter‑Typen überladen. Der Methodenname transportiert die *Aktion* ("besuche
dieses Element"), der Parametertyp transportiert die *Variante* (welche konkrete
Unterklasse von `Expr`).

In vielen Bibliotheken und Frameworks (und auch bei ANTLR) findet man aber häufig
eine andere Schreibweise:

``` java
public interface ExprVisitor {
    void visitNumExpr(NumExpr e);
    void visitMulExpr(MulExpr e);
    void visitAddExpr(AddExpr e);
}
```

Hier haben die `visit`-Methoden **unterschiedliche Namen**. Technisch ist das aber
immer noch das gleiche Visitor‑Pattern:

-   Auf den besuchten Objekten gibt es weiterhin eine `accept(...)`‑Methode.
-   Der Visitor hat pro konkretem Typ eine eigene `visit`-Methode (nur nicht mehr
    überladen).
-   Über `e.accept(v)` wird zuerst die passende `accept`‑Implementierung und darin
    dann die passende Visitormethode aufgerufen (Double‑Dispatch‑Prinzip bleibt
    gleich).

### Vor‑ und Nachteile der beiden Varianten

#### Variante A: Überladene `visit(...)`‑Methoden

``` java
void visit(NumExpr e);
void visit(MulExpr e);
void visit(AddExpr e);
```

-   Vorteile:
    -   kompakte, einheitliche Benennung (`visit` überall)
    -   der Typ des Arguments sagt, was besucht wird
-   Nachteile:
    -   lange Liste von Überladungen kann unübersichtlich werden
    -   im Code muss man genauer auf den Parametertyp achten, um zu sehen, welche
        Variante gemeint ist

#### Variante B: Unterschiedlich benannte Methoden

``` java
void visitNumExpr(NumExpr e);
void visitMulExpr(MulExpr e);
void visitAddExpr(AddExpr e);
```

-   Vorteile:
    -   schon am Methodennamen erkennbar, welcher Typ behandelt wird (`visitMulExpr`
        vs. `visitAddExpr`)
    -   gut geeignet, wenn man viele verschiedene Knotentypen hat (z.B. in großen
        Grammatiken)
-   Nachteile:
    -   etwas mehr Schreibarbeit
    -   die Verbindung zum abstrakten Pattern ("eine `visit`‑Operation,
        spezialisiert für jede Unterklasse") ist weniger direkt sichtbar

### Bezug zu ANTLR

ANTLR generiert typischerweise Visitor‑Interfaces mit **eigenen Namen pro
Grammatikregel**, z.B.:

``` java
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
    T visitAdd(ExprParser.AddContext ctx);
    T visitMul(ExprParser.MulContext ctx);
    T visitNum(ExprParser.NumContext ctx);
}
```

Das entspricht genau der zweiten Variante oben. Wichtig ist für Sie:

-   Beides sind gültige Implementierungen des **gleichen** Visitor‑Patterns.
-   Das **Double‑Dispatch‑Prinzip** und die Trennung von Datenstruktur (`Expr`) und
    Operationen (`Visitor`) bleiben unverändert.
-   Die Wahl der Namenskonvention ist eine Design‑Entscheidung bzw. durch das
    verwendete Tool (wie ANTLR) vorgegeben.

## Double-Dispatch

::: tip
Im Visitor-Pattern spricht man oft von "**Double‑Dispatch**". Gemeint ist damit,
dass bei einem Aufruf wie

``` java
e.accept(v);
```

zwei verschiedene Typinformationen benutzt werden, um zur passenden Methode zu
gelangen:

1.  der tatsächliche Typ des besuchten Objekts (also von `e`), und
2.  der tatsächliche Typ des Visitors (also von `v`).
:::

Schauen wir uns das Schritt für Schritt an.

### 1. Erster Dispatch: Auswahl der richtigen `accept`‑Methode

Im Code steht z.B.:

``` java
Expr e = new AddExpr(...);
ExprVisitor v = new EvalVisitor();

e.accept(v);
```

-   Der **statische Typ** von `e` ist `Expr`.
-   Der **dynamische Typ** von `e` ist hier `AddExpr`.

Zur **Compile‑Zeit** weiß der Compiler nur: "`e` ist irgendetwas vom Typ `Expr`".
Zur **Laufzeit** sieht die JVM aber, dass `e` tatsächlich ein `AddExpr` ist und ruft
deshalb die `accept`‑Methode von `AddExpr` auf:

``` java
public class AddExpr implements Expr {
    public void accept(ExprVisitor v) {
        v.visit(this);
    }
}
```

Das ist der **erste Dispatch**: Die konkrete `accept`‑Implementierung wird anhand
des **Laufzeittyps des Elements** (hier `AddExpr`) bestimmt.

### 2. Zweiter Dispatch: Auswahl der passenden `visit`‑Methode

Innerhalb von `AddExpr.accept` steht:

``` java
public void accept(ExprVisitor v) {
    v.visit(this);
}
```

-   Der **statische Typ** von `v` ist `ExprVisitor` (Interface).
-   Der **dynamische Typ** von `v` ist hier `EvalVisitor` (konkrete
    Implementierung).
-   Der **statische Typ** von `this` in dieser Methode ist `AddExpr`.

Damit passiert Folgendes:

1.  Über den **dynamischen Typ des Visitors** (`EvalVisitor`) wird entschieden,
    welche Implementierung von `visit(AddExpr)` in der Visitor‑Hierarchie aufgerufen
    wird (falls `EvalVisitor` diese Methode überschreibt, dann diese, sonst evtl.
    eine Implementierung in einer Oberklasse).
2.  Welche **Überladung** von `visit(...)` gemeint ist (`visit(NumExpr)`,
    `visit(AddExpr)`, `visit(MulExpr)`, ...) hängt am **statischen Typ** des
    Arguments `this`. In der Methode `AddExpr.accept` ist das statisch der Typ
    `AddExpr`, deshalb wird dort immer die Überladung `visit(AddExpr)` ausgewählt.

::: important
Wichtig: In Java wird die Auswahl der passenden *Überladung* (`visit(AddExpr)`
vs. `visit(MulExpr)` ...) **zur Compile‑Zeit** anhand des statischen Typs des
Arguments getroffen - hier also anhand des Typs `AddExpr` in der jeweiligen
`accept`‑Methode. Zur Laufzeit wird dann über den Typ des Visitors entschieden,
welche konkrete Implementierung dieser Methode ausgeführt wird.
:::

### 3. Warum braucht das Pattern diesen Mechanismus?

In den `accept()`‑Methoden der besuchten Klassen ist nur der gemeinsame Obertyp der
Visitors bekannt (`ExprVisitor`). Das ist wichtig, weil Sie so später beliebig viele
verschiedene konkrete Visitor-Klassen (z.B. `EvalVisitor`, `PrintVisitor`,
`TypeCheckVisitor`, ...) ergänzen/nutzen können, ohne die Klassen der Datenstruktur
noch einmal anpassen zu müssen.

Das Visitor‑Pattern nutzt also zwei Stufen:

1.  **Dynamischer Dispatch** auf das besuchte Objekt -\> "`e` ist zur Laufzeit ein
    `AddExpr`, also nutze `AddExpr.accept`."
2.  **Auswahl der passenden `visit`-Methode** anhand
    -   des **statischen Typs** des Elements in `accept` (`visit(AddExpr e)`), und
    -   des **dynamischen Typs** des Visitors (`EvalVisitor`, `PrintVisitor`, ...).

Diese Kombination bezeichnet man im Kontext des Visitor‑Patterns als
**Double‑Dispatch**: Die endgültige Methode entsteht aus dem Zusammenwirken beider
Typen - des Typs des Elements und des Typs des Visitors.

## Hinweis I

Man könnte nun versucht sein, eine dieser zwei Stufen zu überspringen - man könnte
ja die `visit`-Methode des `EvalVisitors` direkt aufrufen und dabei die Wurzel des
Baums (das Objekt `e`) übergeben.

``` java
// Beispiel von oben (Ausschnitt)
Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));
EvalVisitor v = new EvalVisitor();
e.accept(v);

// Direkter Aufruf - Autsch?!
v.visit(e);
```

Fragen Sie sich selbst: Kann das funktionieren? Was ist die Begründung?

## Hinweis II

Man könnte versucht sein, die `accept()`-Methode aus den Knotenklassen in die
gemeinsame Basisklasse zu verlagern: Statt

``` java
public void accept(ExprVisitor v) {
    v.visit(this);
}
```

in *jeder* Knotenklasse einzeln zu definieren, könnte man das doch *einmalig* in der
Basisklasse definieren:

``` java
public abstract class Expr {
    /** Akzeptiere einen Visitor für die Verarbeitung */
    public void accept(ExprVisitor v) {
        v.visit(this);
    }
}
```

Dies wäre tatsächlich schön, weil man so Code-Duplizierung vermeiden könnte. Aber es
funktioniert in Java leider nicht. (Warum?)

## Hinweis III

Während die `accept()`-Methode nicht in die Basisklasse der besuchten Typen (im
UML-Diagramm zum Visitor-Pattern oben das Interface `Elem` bzw. im Beispiel oben das
Interface `Expr`) verlagert werden kann, kann man die `visit()`-Methoden im
Interface `Visitor` durchaus als Default-Methoden im Interface implementieren.
:::::

# Ausrechnen des Ausdrucks mit einem Visitor

![](images/parsetree_visitor_uml.png)

[Demo: visitor.visit.extrav.DemoExpr]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/visit/extrav/DemoExpr.java"}

::: notes
# Diskussion

In der typischen OO-Denkweise geht man davon aus, dass man eher neue Klassen über
Vererbung hinzufügt als dass man in einer bestehenden Vererbungshierarchie in jeder
der beteiligten Klassen neue Methoden einbaut. Man leitet einfach von der
gewünschten Klasse ab und definiert mittels Überschreiben von Methoden o.ä. das
geänderte Verhalten und erbt den Rest - es wird also nur eine neue Klasse
hinzugefügt samt den überschriebenen Teilen.

Wenn man allerdings in einer solchen Hierarchie in allen Klassen eine neue Methode
einbauen muss, die dann auch noch in den einzelnen Klassen individuell implementiert
werden muss, dann kommt das Visitor-Pattern zur Hilfe und erspart Arbeit. Es muss
nämlich in der Klassenhierarchie nur einmal die Schnittstelle für den Visitor
einbaut werden (pro Klasse eine `accept`-Methode). Danach kann man von außen sehr
einfach neue Methoden (also neue Visitoren) erstellen und nutzen, ohne die
Klassenhierarchie noch einmal ändern zu müssen.

Siehe auch [When should I use the Visitor Design
Pattern?](https://stackoverflow.com/a/478672).

Ein anderer Blick ist auf die Rolle der jeweiligen Klassen: Es gibt Objekte für/in
Datenstrukturen, und es gibt Algorithmen, die auf diesen Objekten bzw.
Datenstrukturen arbeiten. Im Sinne des sauberen OO-Designs würde man diese
Strukturen trennen: "Trenne Algorithmen von den Objekten, auf denen die Algorithmen
arbeiten."

Vergleiche auch die Darstellung des Visitor-Patterns in [Visitor (Refactoring
Guru)](https://refactoring.guru/design-patterns/visitor).
:::

::: notes
# Ausblick: Pattern Matching auf Bäumen (neuere Java-Versionen)

Ausblick auf eine spätere Lesson [Sealed Classes & Pattern
Matching](../java-modern/patternmatching.md):

``` java
Object node = ...;
switch (node) {
    case NumberNode n -> ...
    case BinaryOpNode b -> ...
    // ...
}
```

Statt mit dem Visitor-Pattern durch den Baum zu iterieren, kann man das in neueren
Java-Versionen auch mit Pattern Matching auf Typen machen. Dies schauen wir uns in
der Sitzung [Sealed Classes & Pattern Matching](../java-modern/patternmatching.md)
genauer an, hier nur der Ausblick.
:::

# Wrap-Up

**Visitor-Pattern**: Auslagern der Traversierung in eigene Klassenstruktur

:::: notes
::: tip
Wir haben das Visitor-Pattern am Beispiel von Bäumen kennengelernt. Das Pattern
beschränkt sich aber nicht auf Bäume, sondern kann allgemein für Traversierung von
Datenstrukturen eingesetzt werden.
:::
::::

\bigskip
\smallskip

-   Klassen der traversierten Datenstruktur
    -   bekommen eine `accept()`-Methode für einen Visitor
    -   rufen darin den Visitor mit sich selbst als Argument auf

\smallskip

-   Visitor
    -   hat für jede Klasse der Datenstruktur eine `visit()`-Methode
    -   Rückgabewerte schwierig: Intern halten oder per `return` [(dann aber
        unterschiedliche `visit()`-Methoden für die verschiedenen
        Rückgabetypen!)]{.notes}

\smallskip

-   (Double-) Dispatch: Kombination aus
    -   dynamischem Dispatch auf das **Element** (`accept`) und
    -   dynamischem Dispatch auf den **Visitor** (`visit` für den konkreten
        Elementtyp)

::: readings
Der [Refactoring.Guru](https://refactoring.guru/design-patterns/visitor) hat eine
schöne Zusammenfassung des Visitor-Patterns. Der Verweis auf @Gamma2011 der ["Gang
of Four"](https://en.wikipedia.org/wiki/Design_Patterns) darf natürlich nicht
fehlen.
:::

::: outcomes
-   k2: Ich verstehe den Aufbau des Visitor-Patterns und kann den Double-Dispatch
    erklären
-   k3: Ich kann das Visitor-Pattern auf konkrete Beispiele anwenden
:::

::: challenges
**Visitor-Pattern praktisch (und einfach)**

Betrachten Sie den folgenden Code und erklären Sie das Ergebnis:

``` java
interface Fruit { }
class Apple implements Fruit { }
class Orange implements Fruit { }
class Banana implements Fruit { }
class Foo extends Apple { }

public class FruitBasketDirect {
    public static void main(String... args) {
        List<Fruit> basket = List.of(new Apple(), new Apple(), new Banana(), new Foo());

        int oranges = 0;  int apples = 0;  int bananas = 0;  int foo = 0;

        for (Fruit f : basket) {
            if (f instanceof Apple) apples++;
            if (f instanceof Orange) oranges++;
            if (f instanceof Banana) bananas++;
            if (f instanceof Foo) foo++;
        }
    }
}
```

<!--
3x Apple, 1x Banana, 0x Orange, 1x Foo
-->

Das Verwenden von `instanceof` ist unschön und fehleranfällig. Schreiben Sie den
Code unter Einsatz des Visitor-Patterns um.

<!--
```java
interface FruitCounter {
    void count(Apple a);
    void count(Orange o);
    void count(Banana b);
    void count(Foo f);
}


interface Fruit { void accept(FruitCounter fc); }
class Apple implements Fruit { public void accept(FruitCounter fc) { fc.count(this); } }
class Orange implements Fruit { public void accept(FruitCounter fc) { fc.count(this); } }
class Banana implements Fruit { public void accept(FruitCounter fc) { fc.count(this); } }
class Foo extends Apple { public void accept(FruitCounter fc) { fc.count(this); } }


public class FruitBasketVisitor {
    public static void main(String... args) {
        List<Fruit> basket = List.of(new Apple(), new Apple(), new Banana(), new Foo());

        FruitCounter cnt = new FruitCounter() {
            int oranges = 0;  int apples = 0;  int bananas = 0;  int foo = 0;

            public void count(Apple a) { apples++; }
            public void count(Orange o) { oranges++; }
            public void count(Banana b) { bananas++;  }
            public void count(Foo f) { foo++;  }
        };

        for (Fruit f : basket) {
            f.accept(cnt);
        }
    }
}
```
-->
<!--
2x Apple, 1x Banana, 0x Orange, 1x Foo
-->

Diskutieren Sie Vor- und Nachteile des Visitor-Patterns.
:::
