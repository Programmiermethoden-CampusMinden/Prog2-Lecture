---
author: Carsten Gips (HSBI)
title: Einführung in ANTLR
---

::: tldr
In dieser Veranstaltung lernen Sie ANTLR4 als "Blackbox-Werkzeug" kennen, ohne sich
bereits tief mit Compilerbau beschäftigen zu müssen. Ausgehend von einem gegebenen
Grammatik-File erzeugt ANTLR automatisch Java-Klassen für Lexer, Parser,
Kontextklassen und Visitors. Über Gradle binden Sie ANTLR als Plugin und als
Bibliothek ein und lassen beim Build-Prozess aus den `.g4`-Dateien den passenden
Code generieren.

Im Zentrum steht nicht das Schreiben eigener Grammatiken, sondern die praktische
Nutzung der generierten Klassen: Diese übersetzen eingegebenen Text zunächst in
Token, anschließend in einen Parse-Baum, und traversieren diesen Baum mit dem
Visitor-Pattern. Dabei arbeiten Sie mit Kontextklassen wie `FooParser.ProgContext`
oder `FooParser.StmtContext` und überschreiben Methoden wie `visitProg` oder
`visitStmt` in einer eigenen Visitor-Klasse, die von `FooBaseVisitor<T>` erbt. Ziel
ist, dass Sie den generierten Baum als Datenstruktur verstehen und verarbeiten
können - etwa zum Auswerten einfacher Ausdrücke oder als Grundlage für Anwendungen
wie Syntax-Highlighting. Die theoretischen Grundlagen zu Grammatiken, Lexer- und
Parser-Konstruktion sowie abstrakten Syntaxbäumen folgen dann systematisch im Modul
Compilerbau im 3. Semester.
:::

::: youtube
TODO
:::

# Motivation & Einordnung

![](images/screenshot_syntaxhighlighting.png){width="60%"}

Von regulären Ausdrücken zu "richtigen" Bäumen: ANTLR

::: notes
Kurzer Rückblick auf das Übungsblatt mit Syntax-Highlighting via Regex: Regex
erkennt Muster im Text, aber kennt keine Struktur.

Problemstellung:

-   Wie komme ich von einzelnen Mustern zu einer Satzstruktur?
-   Wie kann ich gültigen Java-Code von ungültiger Syntax unterscheiden?

ANTLR4 als Lösung: [ANTLR](https://www.antlr.org) ist ein in Java geschriebenes Tool
und eine Bibliothek, welche aus Text eine Struktur (einen Parse-Baum) erzeugt.

Einordnung ins Curriculum: Wir betrachten jetzt im 2. Semester nur die rein
praktische Nutzung als Bibliothek. Später im 3. Semester werden wir tiefer in die
Grundlagen des Compilerbaus einsteigen und uns Grammatiken, Lexer und Parser, AST
usw. näher anschauen.
:::

# ANTLR als Blackbox-Pipeline

![](images/antlr_overview.png){width="80%"}

::: notes
Wir nutzen ANTLR als:

-   Java-Bibliothek + Codegenerator, den wir über Gradle einbinden
-   Eingabe: eine vorgegebene Grammatikdatei + Ihr Quelltext
-   Ausgabe: automatisch erzeugte Java-Klassen, die einen zum eingegebenen Quelltext
    passenden Baum repräsentieren

Wichtige Begriffe:

-   **Lexer**: zerteilt Zeichenstrom (Eingabe) in eine Folge von Wörtern (Token)
-   **Token**: Tupel `(Tokenname, optional: Wert)`
-   **Parser**: unterteilt Tokensequenz in gültige Sätze -\> Parse Tree
-   **Parse Tree**: repräsentiert die Struktur der Sätze, wobei jeder Knoten dem
    Namen einer Regel der Grammatik entspricht. Die Blätter bestehen aus den Token
    samt ihren Werten.
-   **Grammatik**: Regeln für den Aufbau der betrachteten Sprache (formale
    Beschreibung der Wörter und Sätze)
-   **ANTLR** generiert aus der Grammatik einen Lexer und Parser plus diverse
    Hilfsklassen.

Wie ein Lexer oder Parser funktioniert, was genau eine Grammatik ist usw. schauen
wir uns in Compilerbau an. Für Prog2 brauchen Sie nur ein grundlegendes Bild und die
Begriffe.
:::

# Technische Einbindung (Gradle, Projektstruktur)

::: notes
ANTLR im Java/Gradle-Projekt nutzen: Einbindung als Tool (Gradle-Plugin) sowie als
Bibliothek (Dependencies).

Basiskonfiguration:
:::

``` groovy
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
In der Gradle-Konfiguration `build.gradle` wird das ANTLR-Plugin für Gradle
aktiviert und zusätzlich werden die Dependencies für die ANTLR-Bibliothek
konfiguriert. Die Grammatik-Dateien liegen dann im Source-Tree unterhalb von
`src/main/antlr/`.

### Explizite Angabe der Pfade für die generierten Klassen

Das ANTLR-Plugin für Gradle hat eine eigene Vorstellung, wohin die generierten
Klassen geschrieben werden. Die Defaults passen in der Regel sehr gut, aber in der
Praxis ist es oft hilfreich, den Ausgabeordner explizit anzugeben und auch für
IntelliJ als Source-Ordner zu kennzeichnen.

Dies erreicht man beispielsweise durch einen zusätzlichen Block in `build.gradle`,
der ein Verzeichnis wie `build/generated-src/antlr/main` definiert, dieses als
zusätzlichen Java-Source-Ordner einträgt. Zusätzlich kann man den Task
`generateGrammarSource` so konfigurieren, dass automatisch immer die Klassen für das
Visitor-Pattern mit generiert werden:

``` groovy
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

### Build-Prozess

Mit der beschriebenen Konfiguration wird ANTLR in den Gradle-Build-Prozess
eingebunden. Bei jedem `./gradlew build` werden aus den Grammatiken in
`src/main/antlr/` mit ANTLR die entsprechenden Java-Klassen (Lexer, Parser,
\*Context-Klassen, Visitor, ...) generiert und in einem Unterordner des
Build-Ordners gespeichert. Das hat den Vorteil, dass die generierten Klassen von Git
ignoriert werden, aber sie müssen für die IDE explizit als "Sourcen" deklariert
werden (dies passiert durch das ANTLR-Plugin in Gradle normalerweise automatisch;
mit der oben skizzierten zusätzlichen Konfiguration ist man auf der sicheren Seite).
anschließend werden alle Java-Klassen im Projekt ganz normal kompiliert und (bei
`./gradlew run`) ausgeführt.

Das bedeutet aber auch, dass nach einem `./gradlew clean` die generierten Klassen
ebenfalls mit entfernt werden (sie liegen ja im Build-Ordner). Damit fehlen dann in
Ihrem Source-Code zunächst die Importe für Lexer, Parser, Visitor etc. und die IDE
zeigt eine Menge Fehler an. Führen Sie dann einmal `./gradlew build` oder
`./gradlew generateGrammarSource` aus, um die generierten ANTLR-Dateien wieder neu
zu erzeugen.

Sie arbeiten dann nur noch mit den Lexer-/Parser-Klassen wie etwa `FooParser`, den
Kontext-Klassen wie `FooParser.StatementContext` und erweitern den generierten
Basis-Visitor wie `FooBaseVisitor`. (Der Präfix `Foo` kommt von der betrachteten
Grammatik, diese würde hier also `Foo.g4` heissen.)

Wichtig: Diese Gradle-Konfiguration müssen Sie sich nicht im Detail merken. Nutzen
Sie sie in diesem Kurs als Schablone und passen Sie sie bei Bedarf an.
:::

# Beispielgrammatik

``` antlr
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
Die gezeigte Grammatik besteht aus verschiedenen Teilen. Als erste Zeile findet man
immer die Deklaration `grammar <NAME>;`, wobei der Name `<NAME>` auch der Dateiname
ist (`NAME.g4`) und später den Präfix für die generierten
Lexer-/Parser-/Visitor-Klassen bildet.

Darunter finden sich verschiedene Regeln, die die betrachtete Sprache beschreiben.
Es gibt zwei Arten von Regeln:

1.  **Lexer-Regeln**: Diese beginnen mit einem Grossbuchstaben und definieren einen
    regulären Ausdruck, der auf den Eingabetext angewendet wird.

    Jede Lexer-Regel entspricht einem Token. Im Beispiel gibt es die Regel `INT`,
    die den regulären Ausdruck `[0-9]+` anwendet. Damit matcht das Token `INT` auf
    alle Zeichenfolgen, die aus einer oder mehreren Ziffern bestehen. Zusätzlich
    gibt es noch nicht benannte Token, das sind die in `'` eingeschlossenen
    Zeichenketten, beispielsweise `'='` oder `';'`. Die Whitespace-Token (`WS`)
    werden im Beispiel zwar gematcht, aber danach verworfen (`-> skip`) - wir
    brauchen diese nicht für die Prüfung der Strukturen.

2.  **Parser-Regeln**: Diese beginnen mit einem Kleinbuchstaben und können andere
    Parser-Regeln "aufrufen" und auch Lexer-Regeln beinhalten.

    Die Parser-Regeln nutzen auch die aus regulären Ausdrücken bekannten Operatoren
    `+` (einmal oder öfter) und `*` (beliebig oft). Damit kann man die Regel

    ``` antlr
    prog : stmt* EOF;
    ```

    so lesen: Ein Programm `prog` besteht aus beliebig vielen Statements (`stmt`),
    gefolgt von einem `EOF` (die Eingabe ist zu Ende, "End Of File").

    Die Regel

    ``` antlr
    expr : INT ('+' INT)*;
    ```

    bedeutet: eine Zahl `INT` (Token), gefolgt von keinmal, einmal oder mehrfach der
    Folge `+ INT`. Also sind z.B. `1`, `1 + 2` oder `1 + 2 + 3 + 4` gültige
    Ausdrücke.

    Die erste Parser-Regel im File ist die sogenannte "Start-Regel", die wir auf dem
    generierten Parser aufrufen können.
:::

# Minimaler Java-Code: Zerlegen der Eingabe in Token

``` java
var input = CharStreams.fromString(text);
var lexer = new MiniCalcLexer(input);
var tokens = new CommonTokenStream(lexer);

tokens.fill(); // fill stream (fetch all tokens from lexer)

for (var t : tokens.getTokens()) {
    var tokenName = MiniCalcLexer.VOCABULARY.getSymbolicName(t.getType());
    System.out.printf(
        "%-10s line=%d col=%d text='%s'%n",
        tokenName, t.getLine(), t.getCharPositionInLine(), t.getText());
}
```

::: notes
Aus einer Grammatik `MiniCalc.g4` wurde ein Lexer generiert, der über
`MiniCalcLexer` zur Verfügung steht. Der Lexer erwartet als Input einen
`CharStream`, den wir aus dem Input (String) erzeugen und dem Konstruktor von
`MiniCalcLexer` übergeben. Das Lexer-Objekt wird wiederum in den Konstruktor von
`CommonTokenStream` übergeben und stellt den Token-Stream dar, den der aus der
Grammatik `MiniCalc` generierte Lexer für den Eingabe-String erzeugt.

Normalerweise arbeiten wir nicht direkt mit dem Token-Stream, sondern übergeben
diesen dem Parser. Im Beispiel wird demonstriert, wie man beispielsweise alle
gefundenen Token der Reihe nach ausgeben kann. Dazu muss einmalig `tokens.fill()`
aufgerufen werden (dies übernimmt sonst der Parser).

Die Eingabe `a = 1 + 2;` liefert bei der gezeigten Grammatik und dem Beispiel-Code
die folgende Ausgabe:

    ID         line=1 col=0 text='a'
    null       line=1 col=2 text='='
    INT        line=1 col=4 text='1'
    null       line=1 col=6 text='+'
    INT        line=1 col=8 text='2'
    null       line=1 col=9 text=';'
    EOF        line=1 col=10 text='<EOF>'

Man erkennt, wie die Eingabe in einzelne Wörter (Token) zerlegt wurde. Leerzeichen
wurden entfernt. Für benannte Token, d.h. Lexer-Regeln wie `ID` und `INT`, wird der
Tokenname mit ausgegeben (`ID`, `INT`). Für die impliziten Token, die in der
Grammatik nur über Literale wie `'='` angelegt sind, gibt es keinen symbolischen
Namen - `VOCABULARY.getSymbolicName()` liefert dafür `null`. Weiterhin sieht man für
jedes Token, in welcher Zeile es gefunden wurde und an welcher Position es startet.
`EOF` ist ein vordefiniertes Token, welches das Ende der Eingabe kennzeichnet.

Wichtig: Der gesamte Eingabetext muss so in gültige Token überführt werden können,
dass jede Zeichenposition zu einem Token gehört. Wenn der Lexer auf Zeichen stösst,
die zu keiner der definierten Token-Regeln passen, meldet er einen Fehler (über
seine Error-Listener) und je nach Konfiguration kann dies auch zu einer Exception
führen.
:::

# Minimaler Java-Code: Text -\> Baum

``` java
var input = CharStreams.fromString(text);
var lexer = new MiniCalcLexer(input);
var tokens = new CommonTokenStream(lexer);

var parser = new MiniCalcParser(tokens);
var tree = parser.prog(); // Wurzelknoten des Baums (Startregel der Grammatik)

IO.println(tree.toStringTree(parser));
```

::: notes
Hier wird das übliche Vorgehen gezeigt, wenn man mit dem Parse-Tree arbeiten möchte.
Aus dem Eingabetext wird ein `CharStream` erzeugt und damit ein `MiniCalcLexer`. Mit
diesem wird der `CommonTokenStream` angelegt und in einen neuen `MiniCalcParser`
gesteckt. Damit haben wir einen Parser, der von ANTLR beim Kompilieren über Gradle
aus der Grammatik generiert wurde und der für den übergebenen Eingabetext die vom
Lexer gebildeten Token in einen Baum übersetzt. Da unsere Grammatik mit der Regel
`prog` anfängt ("Start-Regel"), können wir uns den Baum mit Hilfe von
`parser.prog()` zurückgeben lassen und damit weiter arbeiten. Die Baumwurzel `tree`
ist ein Objekt vom Typ `MiniCalcParser.ProgContext`.

Wenn die Token nicht entsprechend den Regeln in der Grammatik auftauchen, meldet der
Parser Syntaxfehler. Standardmässig versucht ANTLR4, sich von Fehlern zu erholen und
weiterzuparsen; je nach Konfiguration (z.B. mit einer "Bail-Strategie") kann der
Parser aber auch mit einer Exception abbrechen.

Die Eingabe `a = 1 + 2;` liefert bei der gezeigten Grammatik und dem Beispiel-Code
die folgende Ausgabe:

    (prog (stmt a = (expr 1 + 2) ;) <EOF>)

Dabei wird jeder Knoten in Klammern ausgegeben: Zuerst der Knotenname, danach die
Kinder (die selbst wieder Knoten sind). Die Token bilden die Blätter des Baumes;
hier wird nur der Wert ausgegeben (nicht der Tokenname).

Diesen Code können Sie als Schablone verwenden. Ab hier arbeiten wir normalerweise
nur noch mit `tree` ...
:::

# Der Parse-Tree: Struktur

::::: columns
::: column
``` antlr
grammar MiniCalc;

prog  : stmt* EOF ;
stmt  : ID '=' expr ';'
      | expr ';'
      ;
expr  : INT ('+' INT)* ;

ID    : [a-z][a-zA-Z0-9_]* ;
INT   : [0-9]+ ;
WS    : [ \t\r\n]+ -> skip ;
```
:::

::: column
Eingabe `a = 1 + 2;` liefert:

    (prog (stmt a = (expr 1 + 2) ;) <EOF>)

![](images/screenshot_parsetree.png){width="80%" web_width="40%"}
:::
:::::

# Der Parse-Tree: Klassenhierarchie

::::: columns
::: column
``` antlr
grammar MiniCalc;

prog  : stmt* EOF ;
stmt  : ID '=' expr ';'
      | expr ';'
      ;
expr  : INT ('+' INT)* ;

ID    : [a-z][a-zA-Z0-9_]* ;
INT   : [0-9]+ ;
WS    : [ \t\r\n]+ -> skip ;
```
:::

::: column
![](images/MiniCalcParserUML.png){width="80%" web_width="40%"}
:::
:::::

::: notes
Wie sieht der erzeugte Baum in Java aus?

-   Grundprinzip:
    -   Jeder Knoten im Baum ist eine Instanz einer generierten **Kontext-Klasse**
    -   Jede **Kontext-Klasse** entspricht einer Grammatik-Regel (nur
        Parser-Regeln), z.B.:
        -   `MiniCalcParser.ProgContext` (Regel `prog`),
        -   `MiniCalcParser.StmtContext` (Regel `stmt`),
        -   `MiniCalcParser.ExprContext` (Regel `expr`), ...
    -   Alle Baumknoten erben von einer gemeinsamen Basisklasse
        (`ParserRuleContext`)
-   Baumstruktur:
    -   Jeder Knoten hat Kinderknoten (andere Kontexte oder Tokens)
    -   Zugriff auf Elemente: Beispiel Regel `stmt : ID '=' expr ';' | expr ';' ;`:
        -   Kontext-Klasse `MiniCalcParser.StmtContext`
        -   Zugriff auf Token `ID`: `TerminalNode ID()`
        -   Zugriff auf Kontext `expr`: `ExprContext expr()`
    -   Zusätzlich gibt es aus der Basisklasse `ParserRuleContext` für jede
        Kontext-Klasse noch z.B.:
        -   `int getChildCount()`: Wie viele Kinder hat dieser Knoten?
        -   `ParseTree getChild(int i)`: liefere den Kindknoten mit Index `i` zurück
            (Indexbereich `0` bis `getChildCount() - 1`)
        -   `String getText()`: liefere den gematchten Text aus dem Eingabetext
            zurück
:::

# Traversierung mit Visitor-Pattern

::: notes
Den Baum "besuchen" - Visitor-Pattern in ANTLR angewendet.

ANTLR generiert auf Anfordung die nötigen Klassen und Strukturen, um das
Visitor-Pattern einfach implementieren zu können. Wir schauen uns hier nur die
Anwendung des Patterns an; zur Funktionsweise des Patterns siehe Lektion
[Visitor-Pattern](../pattern/visitor.md).
:::

![](images/MiniCalcVisitorUML.png){width="80%"}

::: notes
-   ANTLR-Visitor:
    -   ANTLR generiert ein `MiniCalcVisitor<T>`-Interface und eine
        `MiniCalcBaseVisitor<T>`-Basisklasse mit leeren Standard-Implementierungen
    -   Jede Regel `xxx` in der Grammatik erzeugt:
        -   eine Kontext-Klasse `XxxContext`, und
        -   eine Methode `T visitXxx(XxxContext ctx)`
    -   Jeder Knotentyp hat eine eigene `visitXxx`-Methode, z.B.:
        -   `T visitProg(MiniCalcParser.ProgContext ctx)`
        -   `T visitStmt(MiniCalcParser.StmtContext ctx)`
        -   `T visitExpr(MiniCalcParser.ExprContext ctx)`
-   Vorgehen:
    -   Eigene Visitor-Klasse schreiben, die von `MiniCalcBaseVisitor<T>` ableitet,
        z.B.

        ``` java
        public class EvalVisitor extends MiniCalcBaseVisitor<Integer> {}
        ```

    -   Nur die Methoden überschreiben, die relevant sind, z.B. `visitProg`,
        `visitStmt`, `visitExpr`, ...

        Beispielidee für `visitStmt` (informell):

        ``` java
        /** stmt : ID '=' expr ';' | expr ';' */
        @Override
        public Integer visitStmt(MiniCalcParser.StmtContext ctx) {
            if (ctx.ID() != null) { // ID '=' expr ';'
                String name = ctx.ID().getText();
                Integer value = visit(ctx.expr());
                memory.put(name, value);
                return value;
            } else
                return visit(ctx.expr()); // expr ';'
        }
        ```

        -   Grammatik: `stmt : ID '=' expr ';' | expr ';' ;`
        -   Wenn `ctx.ID() != null`, handelt es sich um eine Zuweisung
            (`ID '=' expr ';'`):
            -   Namen mit `ctx.ID().getText()` auslesen,
            -   Wert mit `visit(ctx.expr())` berechnen,
            -   in einer Map `memory.put(name, value)` speichern (für spätere
                Verarbeitung).
        -   Sonst handelt es sich um ein einfaches `expr ';'`:
            -   nur den Wert `visit(ctx.expr())` zurückgeben.

    -   Visitor anwenden:

        ``` java
        var tree = parser.prog();
        var eval = new EvalVisitor();
        var result = eval.visit(tree);

        IO.println("Umgebung: " + eval.getMemory());
        ```

        -   Mit `var tree = parser.prog();` den Wurzelknoten holen,
        -   Visitor-Objekt erzeugen, z.B. `var eval = new EvalVisitor();`,
        -   `var result = eval.visit(tree);` aufrufen,
        -   z.B. die Umgebung mit `eval.getMemory()` ausgeben.
-   Vorteile:
    -   Klare Trennung: Struktur (Baum) vs. Verarbeitung (Visitor)
    -   Erleichtert spätere Erweiterungen (weitere Visitors für andere Aufgaben,
        z.B. Auswertung, Pretty-Printer, Linter)

**Beobachtungen**:

-   `visitStmt` zeigt explizit, dass `ID` hier nur ein Token ist und dass hier
    direkt über `ctx.ID().getText()` zugegriffen wird. Für Token gibt es keine
    Kontext-Objekte, d.h. es gibt kein `IDContext`.
-   `visitStmt` zeigt den Umgang mit einer Alternative: Entweder gilt
    `ID '=' expr ';'` *oder* `expr ';'`. D.h. man fragt in diesem Fall ab, ob es
    eine `ID` gibt und reagiert entsprechend: `if (ctx.ID() != null)` -\> wenn es
    keine `ID` gibt, liefert `ctx.ID()` den Wert `null`.
-   Wenn man die Kindknoten nicht direkt per Methode aufrufen will (oder kann, wenn
    es mehrere Kindknoten mit nicht vorher bekannter Anzahl wie in der Regel
    `expr : INT ('+' INT)* ;` gibt), kann man die tatsächliche Anzahl der Kindknoten
    per Aufruf `ctx.getChildCount()` abfragen und dann mit `ctx.getChild(i)` gezielt
    auf ein Kind zugreifen (Indexbereich `0` bis `getChildCount() - 1`).
:::

::: notes
# Pattern Matching auf Bäumen (neuere Java-Versionen)

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

::: notes
# Syntaxhighlighting: Vergleich Regex-Ansatz vs. ANTLR-Ansatz

-   Regex-Ansatz:
    -   Arbeitet rein textbasiert (Zeile für Zeile, Zeichenketten)
    -   Schwer, verschachtelte Strukturen korrekt zu behandeln
    -   Kaum Information über Kontext (z.B. ob etwas eine Variable, ein Keyword oder
        Teil eines Strings ist)
-   ANTLR-Ansatz:
    -   Erstellt einen strukturierten Baum:
        -   Kennt Blöcke, Ausdrücke, Anweisungen, ...
    -   Kontextabhängige Verarbeitung wird möglich:
        -   Unterschiedliche Behandlung je nach Position im Baum
-   Für das Syntax-Highlighting-Beispiel:
    -   Nutzung des Token-Streams vom Lexer für das reine Syntax-Highlighting (z.B.
        farbige Darstellung je nach Tokentyp, ohne den Parse-Baum zu betrachten)
    -   Alternativ Traversierung des Parse-Tree mit einem Visitor:
        -   Highlighting abhängig von Knotentyp statt von vagen Textmustern
        -   Achtung: Token mit `-> skip` tauchen nicht mehr im Baum auf, d.h.
            üblicherweise sind das Whitespaces und Kommentare; für exakte
            Quelltext-Rekonstruktion müssen diese ggf. separat behandelt werden
:::

::: notes
# Ausblick auf das 3. Semester (Compilerbau)

Wie es weitergeht: Vom Parse-Baum zum Compiler

-   Sie arbeiten in Prog2 nur mit `FooLexer`, `FooParser`, `XxxContext`-Klassen,
    `FooBaseVisitor`:
    -   den Standard-Code, um `tree = parser.program()` zu bekommen
    -   das Wissen: Knoten sind `XxxContext`-Objekte
    -   einen eigenen Visitor, der von `FooBaseVisitor<...>` erbt
    -   überschreiben der passenden `visitXxx`-Methoden
-   Was Sie heute "unter der Haube" ignorieren durften:
    -   Wie die Grammatik aufgebaut ist und warum
    -   Wie Lexer und Parser intern funktionieren
    -   Unterschied Parse-Baum vs. abstrakter Syntaxbaum (AST)
-   Im 3. Semester (Compilerbau) vertiefen wir:
    -   Definition eigener Grammatiken
    -   Schreiben und Erweitern eigener Sprachen
    -   Konstruktion von Lexer und Parser (inkl. ANTLR-Details)
    -   Systematische AST-Konstruktion, semantische Analyse, Interpreter, Compiler,
        Linter, Code-Formatter

Verbindung zu heute: Alles, was Sie jetzt zu Baumstrukturen, Visitor und Pattern
Matching gelernt haben, wird im nächsten Semester direkt wiederverwendet!
:::

# Wrap-Up

-   ANTLR als Werkzeug: aus einer gegebenen Grammatik werden Lexer, Parser,
    Kontextklassen und Visitor-Schnittstellen generiert
-   Einbettung in ein Java/Gradle-Projekt:
    -   `antlr`-Plugin in `build.gradle`
    -   `.g4`-Dateien unter `src/main/antlr/`
    -   generierte Sourcen im Build-Ordner
-   Üblicher Workflow: Eingabetext -\> CharStream -\> Lexer -\> TokenStream -\>
    Parser -\> Parse-Tree
-   Struktur des Parse-Baums:
    -   jedes Knotenobjekt ist eine `XxxContext`-Klasse
    -   Blätter sind Token
    -   Whitespaces/Kommentare werden i.d.R. übersprungen/entfernt
-   Visitor-Pattern in ANTLR:
    -   eigene Klasse von generiertem `FooBaseVisitor<T>` ableiten
    -   `visitXxx`-Methoden bei Bedarf überschreiben
    -   Baum mit `visitor.visit(tree)` traversieren.

::: readings
Sie finden auf der [ANTLR-Homepage](https://www.antlr.org) Links zur Dokumentation
und auch zum [ANTLR-Projekt](https://github.com/antlr/antlr4) auf GitHub. Eine
ältere, aber dennoch interessante Quelle vom "Kopf" hinter ANTLR ist @Parr2014, die
auch online verfügbar ist.
:::

::: outcomes
-   k2: Sie können erläutern, welche Rolle Grammatik, Lexer, Parser, Kontextklassen
    und Visitors in einem ANTLR-Projekt spielen, und wie diese in den Build-Prozess
    mit Gradle eingebunden werden.
-   k3: Sie können eine gegebene ANTLR-Grammatik in ein Gradle-Projekt integrieren,
    den erzeugten Parse-Baum mit einem eigenen Visitor traversieren und daraus eine
    einfache Verarbeitung (z.B. Auswertung von Ausdrücken oder einfaches
    Syntax-Highlighting) implementieren.
:::

::: challenges
Betrachten Sie die folgende ANTLR-Grammatik:

``` antlr
grammar OneTwo;

s  : a EOF ;

a  : '1' a '1'
   | '2'
   ;
```

1.  Welche Token können Sie hier vom Lexer erwarten?
2.  Welche Eingaben würde der Parser akzeptieren?
3.  Wie sieht der Parse-Tree aus, welche Knoten und Blätter gibt es und wie sehen
    die zugehörigen (generierten) Klassen und Methoden aus?

<!--
Es gibt nur die beiden impliziten Token `1` und `2` sowie das vordefinierte `EOF`.

Die akzeptierte Sprache: ein oder mehrere "1", eine "2", danach nochmal genauso
viele "1" wie am Anfang.

Klassen: Es gibt `SContext` und `AContext` für die beiden Regeln.

-   `SContext` hat die Methoden `AContext a()` und `TerminalNode EOF()`.
-   `AContext` hat die Methoden `AContext a()`.
-   Zusätzlich die geerbten Methoden aus der Basisklasse `ParserRuleContext`:
    `int getChildCount()`, `ParseTree getChild(int i)`, `String getText()`
-->
:::
