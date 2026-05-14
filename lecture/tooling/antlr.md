---
author: Carsten Gips (HSBI)
title: ANTLR
---

::: tldr
TODO
:::

::: youtube
TODO
:::


Ziel: ANTLR als "Blackbox-Tool" fürs Programmieren 2, ohne Grammatik‑/Compiler-Theorie zu betonen. Fokus: Baumstrukturen, Traversierung (Visitor), Integration in das bisherige Übungssetting (Regex -> ANTLR).

1.  Mentales Modell "Pipeline": Text -> Lexer -> Parser -> Baum
-   Nicht im Detail, nur: "Da entsteht ein Baum, den wir gleich besuchen."

2.  Wie komme ich in Java an den Wurzelknoten?
    -   4 Zeilen Code, die sie ggf. auch einfach abschreiben:

        sourceCode->lexer->tokens->parser->tree

3.  Was ist dieser Baum in Java?
    -   Generierte Kontext‑Klassen: `XxxContext`
    -   Kindknoten, Methoden wie `ctx.foo()` / `ctx.bar(i)` / `ctx.getText()`.


4.  Wie schreibe ich einen Visitor?
    -   Von `FooBaseVisitor<R>` erben.
    -   Relevante `visitXxx`‑Methoden überschreiben.
    -   In jeder Methode:
        -   den Kontext lesen (Kinder, Text),
        -   etwas tun (z.B. highlighten, AST-Knoten bauen),
        -   ggf. `visitChildren(ctx)` aufrufen.

5.  Ganz wichtig für Anfänger:innen:
    -   Sie müssen die **Grammatik nicht verstehen**.
    -   Sie müssen nur wissen:
        -   "Es gibt eine Regel program, also gibt es ProgramContext und eine Methode visitProgram."
    -   Übersetzung im Kopf: Regelname ↔ Knotentyp ↔ visit-Methode.

Alles andere (Lexer/Parser-Theorie, AST vs. Parse-Tree, Grammatikdesign, Pattern Matching) ist Kür und gehört ins 3. Semester.



# Motivation & Einordnung

![](images/screenshot_syntaxhighlighting.png){width="60%"}

Von regulären Ausdrücken zu "richtigen" Bäumen: ANTLR

::: notes
Kurzer Rückblick auf das Übungsblatt mit Syntax-Highlighting via Regex: Regex erkennt Muster im Text, aber kennt keine Struktur.

Problemstellung:
-   Wie komme ich von einzelnen Mustern zu einer Satzstruktur?
-   Wie kann ich gültigen Java-Code von ungültiger Syntax unterscheiden?

ANTLR4 als Lösung: [ANTLR](https://www.antlr.org) ist ein in Java geschriebenes Tool und Bibliothek, welche aus Text einen Strukturen (einen Parse-Baum) erzeugt.

Einordnung ins Curriculum: Wir betrachten jetzt im 2. Semester nur die rein praktische Nutzung als Bibliothek. Später im 3. Semester werden wir tiefer in die Grundlagen des Compilerbaus einsteigen und uns Grammatiken, Lexer und Parser, AST ... näher anschauen.
:::


# ANTLR als Blackbox-Pipeline

![](images/antlr_overview.png){width="80%"}

::: notes
Wir nutzen ANTLR als:
-   Java‑Bibliothek + Codegenerator, den wir über Gradle einbinden
-   Eingabe: eine vorgegebene Grammatikdatei + Ihr Quelltext
-   Ausgabe: automatisch erzeugte Java-Klassen, die einen zum eingegebenen Quelltext passenden Baum repräsentieren

Begriffe:
-   **Lexer**: zerteilt Zeichenstrom (Eingabe) in eine Folge von Wörtern (Tokens)
-   **Token**: Tupel `(Tokenname, optional: Wert)`
-   **Parser**: unterteilt Tokensequenz in gültige Sätze -> Parse Tree
-   **Parse Tree**: Repräsentiert die Struktur der Sätze, wobei jeder Knoten dem Namen einer
    Regel der Grammatik entspricht. Die Blätter bestehen aus den Token samt ihren Werten.
-   **Grammatik**: Regeln für den Aufbau der betrachteten Sprache (formale Beschreibung der Wörter und Sätze)
-   **ANTLR** generiert aus Grammatik einen Lexer und Parser plus diverse Hilfsklassen

Wie ein Lexer oder Parser funktioniert, was genau eine Grammatik ist ... das schauen wir uns in Compilerbau an. Für Prog2 brauchen Sie nur ein grundlegendes Bild und die Begriffe.
:::

# Technische Einbindung (Gradle, Projektstruktur)

::: notes
ANTLR im Java/Gradle‑Projekt nutzen: Einbindung als Tool (Gradle-Plugin) sowie als Bibliothek (Dependencies):
:::

```groovy
plugins {
    id 'java'
    id 'antlr'
}

repositories {
    mavenCentral()
}

dependencies {
    antlr 'org.antlr:antlr4:4.13.2'
    implementation 'org.antlr:antlr4-runtime:4.13.2'
}
```

::: notes
In der Gradle-Konfiguration `build.gradle` wird das ANTLR-Plugin für Gradle aktiviert und zusätzlich werden die Dependencies für die ANTLR-Bibliothek konfiguriert.
Die Grammatik-Dateien liegen dann im Sourcetree unterhalb von `src/main/antlr/`.


### Explizite Angabe der Pfade für die generierten Klassen

Das ANTLR-Plugin für Gradle hat eine eigene Vorstellung, wohin die generierten Klassen geschrieben werden. Die Defaults passen in der Regel, aber in der Praxis ist es tatsächlich oft hilfreich, zusätzlich den Ausgabeordner explizit anzugeben und auch für IntelliJ als Source-Ordner zu kennzeichnen. Dies erreicht man beispielsweise durch diese zusätzlichen Abschnitte im `build.gradle`:

```groovy
def antlrGenDir = layout.buildDirectory.dir('generated-src/antlr/main')

sourceSets {
    main {
        java.srcDir(antlrGenDir)
    }
}

tasks.named('generateGrammarSource') {
    maxHeapSize = '64m'
    arguments.addAll(['-visitor', '-long-messages'])
    outputDirectory = antlrGenDir.get().asFile
}
```

Mit diesem Snippet werden außerdem die Klassen für das Visitor-Pattern immer mit generiert.

### Build-Prozess

Mit der obigen Konfiguration wird ANTLR in den Gradle-Build-Prozess eingebunden. Bei jedem `./gradlew build` werden aus den Grammatiken in `src/main/antlr/` mit ANTLR die entsprechenden Java‑Klassen (Lexer, Parser, *Context‑Klassen, Visitor, ...) generiert und in einem Unterordner des Build-Ordner gespeichert. Das hat den Vorteil, dass die generierten Klassen von Git ignoriert werden, aber sie müssen explizit als "Sourcen" deklariert werden (dies passiert durch das ANTLR-Plugin in Gradle normalerweise automatisch, aber mit der obigen zusätzlichen Konfiguration ist man auf der sicheren Seite). Anschließend werden alle Java-Klassen im Projekt ganz normal kompiliert und (bei `./gradlew run`) ausgeführt.

Das bedeutet aber auch, dass nach einem `./gradlew clean` die generierten Klassen auch mit entfernt werden (liegen ja im Build-Ordner). Damit fehlen dann in Ihrem Source-Code die Importe für Lexer, Parser, Visitor etc. und die IDE zeigt eine Menge Fehler an. Führen Sie dann einmal einen `./gradlew build` oder `./gradlew generateGrammarSource` aus, um die generierten ANTLR-Dateien wieder neu zu generieren.

Sie arbeiten dann nur noch mit den Lexer-/Parser-Klassen wie etwa `FooParser`, den Context-Klasse wie `FooParser.StatementContext` und erweitern den generierten Basis-Visitor wie `FooBaseVisitor`. (Der Präfix "`Foo`" kommt von der betrachteten Grammatik, diese würde hier also `Foo.g4` heissen.)
:::


# Beispielgrammatik

```antlr
grammar MiniCalc;


// Programm besteht aus beliebig vielen Statements
prog  : stmt* EOF ;

// Statement: entweder Zuweisung oder nackter Ausdruck
stmt  : ID '=' expr ';'
      | expr ';'
      ;

// Ausdruck: eine oder mehrere Zahlen, addiert
expr  : INT ('+' INT)* ;


// LEXER-Regeln (Token)
ID    : [a-z][a-zA-Z0-9_]* ;
INT   : [0-9]+ ;

WS    : [ \t\r\n]+ -> skip ;
```

::: notes
Die gezeigte Grammatik besteht aus verschiedenen Teilen. Als erste Zeile findet man immer die Deklaration `grammar <NAME>;`, wobei der Name `NAME` auch der Dateiname ist (`NAME.g4`).

Darunter finden sich verschiedene Regeln, die die betrachtete Sprache beschreiben. Es gibt zwei Arten von Regeln:

1. Lexer-Regeln: Diese beginnen mit einem Großbuchstaben und definieren einen regulären Ausdruck, der auf den Eingabetext angewendet wird.
2. Parser-Regeln: Diese beginnen mit einem Kleinbuchstaben und können andere Parser-Regeln "aufrufen" und auch Lexer-Regeln beinhalten.

Jede Lexer-Regel entspricht einem Token. Im Beispiel gibt es die Regel `INT`, die den regulären Ausdruck `[0-9]+` anwendet. Damit matcht das Token `INT` alle Zeichenfolgen, die aus einer oder mehreren Ziffern bestehen. Zusätzlich gibt es noch nicht-benannte Token, das sind die in `'` eingeschlossenen Zeichenketten, beispielsweise `'"'` oder "';'". Die Whitespace-Token (`WS`) werden im Beispiel oben zwar gematcht, aber danach verworfen (`-> skip`) - wir brauchen diese nicht für die Prüfung der Strukturen.

Die Parser-Regeln nutzen auch die aus regulären Ausdrücken bekannten Operatoren `+` (einmal oder öfter) und `*` (beliebig oft). Damit kann man die Regel `prog` so lesen: Ein Programm `prog` besteht aus beliebig vielen Statements (`stmt`), gefolgt von einem `EOF` (die Eingabe ist zuende, "End Of File").

Die erste Parser-Regel ist die sogenannte "Start-Regel", die wir auf dem generierten Parser aufrufen können.
:::



# Minimaler Java-Code: Zerlegen der Eingabe in Token

```java
var input = CharStreams.fromString(text);
var lexer = new FooLexer(input);
var tokens = new CommonTokenStream(lexer);

tokens.fill(); // fill stream (fetch all tokens from lexer)

for (var t : tokens.getTokens()) {
    var tokenName = FooLexer.VOCABULARY.getSymbolicName(t.getType());
    System.out.printf(
        "%-10s line=%d col=%d text='%s'%n",
        tokenName, t.getLine(), t.getCharPositionInLine(), t.getText());
}
```

::: notes
Eingabe `a = 1 + 2;` liefert:

```
ID         line=1 col=0 text='a'
null       line=1 col=2 text='='
NUM        line=1 col=4 text='1'
null       line=1 col=6 text='+'
NUM        line=1 col=8 text='2'
null       line=1 col=9 text=';'
EOF        line=1 col=10 text='<EOF>'
```
:::



# Minimaler Java-Code: Text -> Baum

```java
var input = CharStreams.fromString(text);
var lexer = new FooLexer(input);
var tokens = new CommonTokenStream(lexer);

var parser = new FooParser(tokens);
var tree = parser.program(); // Wurzelknoten des Baums (Startregel der Grammatik)

IO.println(tree.toStringTree(parser));
```

::: notes
Eingabe `a = 1 + 2;` liefert:

```
(program (stmt a = (expr (term (atom 1)) + (term (atom 2))) ;))
```
:::

-   `FooLexer` und `FooParser` sind aus Grammatik `Foo.g4` generiert (durch ANTLR).
-   `parser.program()` entspricht der Startregel `program`.
-   `tree` ist ein Objekt vom Typ `FooParser.ProgramContext`.

Diesen Code können Sie als Schablone verwenden. Ab da arbeiten wir nur noch mit `tree`.




# Der Parse-Baum: Klassenhierarchie & Struktur

Wie sieht der erzeugte Baum in Java aus?

-   Grundprinzip:
    -   Jeder Knoten im Baum ist eine Instanz einer **Context-Klasse**:
    -   Es gibt generierte **Kontext-Klassen** für Sprachkonstrukte (Grammatik-Regeln):
        -   z.B. `FooParser.ProgramContext` (Regel "program"), `FooParser.StmtContext` (Regel "stmt"), `FooParser.ExprContext` (Regel "expr"), ...

-   Typische Vererbung:
    -   Alle Baumknoten erben von einer gemeinsamen Basisklasse (`ParserRuleContext`).
    -   Spezifische Kontexte bilden eine Klassenhierarchie.

-   Baumstruktur:
    -   Jeder Knoten hat Kinderknoten (andere Kontexte oder Tokens).
    -   Vergleich zu eigenen Baumklassen aus "Programmieren 1/2":
        -   Ähnlich wie selbst geschriebene `Node`-Klassen, nur automatisch generiert.

-   Beispiel, visuelle Darstellung:
    -   Grammatik: Regel für Expressions
    -   Eingabe z.B. für `x = 1 + 2;`
    -   Generierter Baum:
        -   grafisch, Screenshot
        -   generierte Klassen und Methoden: `ExprContext expr()`, `List<StmtContext> stmt()`, ...

```antlr
grammar Foo;

program : stmt* ;

stmt    : ID '=' expr ';' | expr ';' ;

expr    : term ('+' term)* ;
term    : atom ('*' atom)* ;
atom    : ID | NUM ;

ID      : [a-z][a-zA-Z]* ;
NUM     : [0-9]+ ;
WS      : [ \t\n]+ -> skip ;
```

Eingabe `a = 1 + 2;` liefert:

```
(program (stmt a = (expr (term (atom 1)) + (term (atom 2))) ;))
```

![](images/screenshot_parsetree.png){width="60%" web_width="30%"}

```java
public static class ProgramContext extends ParserRuleContext {
    public List<StmtContext> stmt() {
        return getRuleContexts(StmtContext.class);
    }
    public StmtContext stmt(int i) {
        return getRuleContext(StmtContext.class,i);
    }
...
}

public static class StmtContext extends ParserRuleContext {
    public TerminalNode ID() { return getToken(FooParser.ID, 0); }
    public ExprContext expr() {
        return getRuleContext(ExprContext.class,0);
    }
    ...
}

public static class ExprContext extends ParserRuleContext {
    public List<TermContext> term() {
        return getRuleContexts(TermContext.class);
    }
    public TermContext term(int i) {
        return getRuleContext(TermContext.class,i);
    }
    ...
}

public static class TermContext extends ParserRuleContext {
    public List<AtomContext> atom() {
        return getRuleContexts(AtomContext.class);
    }
    public AtomContext atom(int i) {
        return getRuleContext(AtomContext.class,i);
    }
    ...
}


public static class AtomContext extends ParserRuleContext {
    public TerminalNode ID() { return getToken(FooParser.ID, 0); }
    public TerminalNode NUM() { return getToken(FooParser.NUM, 0); }
    ...
}
```

![](images/FooParserUML.png)


# Traversierung mit Visitor-Pattern

Den Baum "besuchen" - Visitor in ANTLR

![](images/FooVisitorUML.png)

-   Aufgabe:
    -   Wir wollen den generierten Baum verarbeiten (z.B. für Syntax-Highlighting, Auswertung, Umwandlung in AST).

-   ANTLR‑Visitor:
    -   ANTLR generiert ein `FooVisitor<T>`-Interface und eine `FooBaseVisitor<T>` Basisklasse mit leeren Standard-Implementierungen.
    -   Jede Regel `xxx` in der Grammatik erzeugt:
        -   eine Kontext-Klasse `XxxContext`
        -   und eine Methode `T visitXxx(XxxContext ctx)`
    -   Jede Knotentyp hat eine eigene `visitXxx`‑Methode, z.B.:
        -   `visitProgram(ProgramContext ctx)`
        -   `visitExpr(ExprContext ctx)`

-   Vorgehen:
    -   Eigene Visitor‑Klasse schreiben, die von `FooBaseVisitor<...>` erbt.
        ```java
        public class MyVisitor extends FooBaseVisitor<Void> {}
        ```
    -   Nur die Methoden überschreiben, die relevant sind.
        ```java
        @Override
        public Void visitExpr(FooParser.ExprContext ctx) {
            // hier: Farbe wählen, Tokenposition auslesen, etc.
            return null;
        }
        ```
    -   Visitor anwenden:
        ```java
        var visitor = new MyVisitor();
        visitor.visit(tree);
        ```
-   Vorteile:
    -   Klare Trennung: Struktur (Baum) vs. Verarbeitung (Visitor).
    -   Erleichtert spätere Erweiterungen (weitere Visitor für andere Aufgaben).


Didaktisch interessant:

visitExpr zeigt explizit, dass INT hier nur ein Token ist:
Zugriff über ctx.INT(i) statt über einen INTContext.


visitStmt zeigt eine Alternative:
if (ctx.ID() != null) als sehr direkte, anschauliche Abfrage.


visitProg zeigt eine Liste von Kindknoten (stmt*):

prog→stmt1,stmt2,…,stmtn\text{prog} \rightarrow \text{stmt}_1, \text{stmt}_2, \dots, \text{stmt}_nprog→stmt1​,stmt2​,…,stmtn​

Die generierten Klassen zeigen (MiniCalcLexer, MiniCalcParser, ProgContext, StmtContext, ExprContext).
Einmal durchsteppen, was visit(...) macht.
„Randfälle“ besprechen:
Leer-Programm: prog mit 0 stmts ⇒ Rückgabewert null.
Zuweisung vs. nackter Ausdruck.
Zugriff auf Token (INT) vs. Parser-Regel (expr).


ctx.INT(i)
ctx.getText()
ctx.getChildCount() und ctx.getChild(i) exemplarisch an prog oder stmt.


Optional: eine Folie mit der erweiterten +/--Variante, um zu zeigen, dass man mit getChild() Operatoren auswerten kann – ohne dass die Studis das direkt im Übungsblatt brauchen.



# Pattern Matching auf Bäumen (neuere Java-Versionen)

```java
Object node = ...;
switch (node) {
    case NumberNode n -> ...
    case BinaryOpNode b -> ...
    // ...
}
```


# Vergleich: Regex-Ansatz vs. ANTLR-Ansatz

-   Regex-Ansatz:
    -   Arbeitet rein textbasiert (Zeile für Zeile, Zeichenketten).
    -   Schwer, verschachtelte Strukturen korrekt zu behandeln.
    -   Kaum Information über Kontext (z.B. ob etwas eine Variable, ein Keyword oder Teil eines Strings ist).


-   ANTLR-Ansatz:
    -   Erstellt einen strukturierten Baum:
        -   Kennt Blöcke, Ausdrücke, Anweisungen, ...
    -   Kontextabhängige Verarbeitung wird möglich:
        -   Unterschiedliche Behandlung je nach Position im Baum.

-   Für das Syntax-Highlighting-Beispiel:
    -   Visitor über den Parse-Baum:
        -   Highlighting abhängig von Knoten-Typ statt vagen Textmustern.

-   Didaktischer Punkt:
    -   Vorbereitung auf sprachbasierte Werkzeuge:
        -   Interpreter, Compiler, Linter, Code-Formatter.


# Ausblick auf das 3. Semester (Compilerbau)

Wie es weitergeht: Vom Parse-Baum zum Compiler

-   Sie arbeiten in Prog2 nur mit `FooLexer`, `FooParser`, `XxxContext`-Klassen, `FooBaseVisitor`:
    -   den Standard-Code, um `tree = parser.program()` zu bekommen.
    -   das Wissen: Knoten sind `XxxContext`‑Objekte.
    -   einen eigenen Visitor, der von `FooBaseVisitor<...>` erbt.
    -   Überschreiben der passenden `visitXxx`‑Methoden.

-   Was Sie heute "unter der Haube" ignorieren durften:
    -   Wie die Grammatik aufgebaut ist.
    -   Wie Lexer und Parser intern funktionieren.
    -   Unterschied Parse‑Baum vs. abstrakter Syntaxbaum (AST).

-   Im 3. Semester (Compilerbau) vertiefen wir:
    -   Definition eigener Grammatiken.
    -   Schreiben und Erweitern eigener Sprachen.
    -   Konstruktion von Lexer und Parser (inkl. ANTLR‑Details).
    -   Systematische AST‑Konstruktion, semantische Analyse, Interpreter.


-   Verbindung zu heute: Alles, was Sie jetzt zu Baumstrukturen, Visitor und Pattern Matching lernen, ist direkt wiederverwendbar:



# Wrap-Up

TODO

::: readings
TODO
:::

::: outcomes
-   k2: Ich kann den Einsatz von Packages in Java erklären
:::

::: challenges
TODO
:::
