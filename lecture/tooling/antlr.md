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
    -   Von `MiniLangBaseVisitor<R>` erben.
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

Von regulären Ausdrücken zu "richtigen" Bäumen

-   Kurzer Rückblick auf das Übungsblatt mit Syntax-Highlighting via Regex:
    -   Regex erkennt Muster im Text, aber kennt keine Struktur.

-   Problemstellung:
    -   Wie komme ich von einem Text zu einer Baumstruktur, die ich in Java verarbeiten kann?

-   ANTLR4 als Lösung:
    -   Fertiges Tool / Library, die aus Text einen Parse-Baum erzeugt.
    -   Sie müssen zunächst nur wissen: "Ich gebe Text rein, ich bekomme einen Baum raus."


-   Einordnung ins Curriculum:
    -   Jetzt: rein praktische Nutzung von ANTLR im 2. Semester.
        -   Fertige Bibliothek, die für uns diesen Baum erzeugt.
        -   Wir nutzen sie wie jede andere Library (JUnit, etc.).
    -   Später im 3. Semester: Theoretische Grundlagen (Grammatik, Lexer/Parser, AST, ...).

# ANTLR als Blackbox-Pipeline

-   ANTLR als:
    -   Java‑Bibliothek + Codegenerator, den wir über Gradle einbinden.
    -   Eingabe: eine vorgegebene Grammatikdatei + Ihr Quelltext.
    -   Ausgabe: automatisch erzeugte Java-Klassen, die einen Baum repräsentieren.

-   Vereinfachtes Bild: `String -> Lexer -> TokenStream -> Parser -> Baum aus Java-Objekten`
    -   **Lexer**: macht aus Zeichen eine Folge von Tokens.
    -   **Parser**: macht aus Tokens einen Baum.
    -   Steuerung: Regeln in einer **Grammatik**
    -   ANTLR generiert aus Grammatik einen Lexer und Parser und Hilfsklassen

-   Begriffe, die Sie kennen, aber nicht vertiefen müssen:
    -   Grammar, Lexer, Parser, Parse Tree - reine Arbeitsbegriffe.

-   Wichtig im 2. Semester:
    -   Welche Klassen entstehen?
    -   Wie sieht der Baum aus?
    -   Wie kann ich ihn traversieren / verarbeiten?


# Technische Einbindung (Gradle, Projektstruktur)

ANTLR im Java/Gradle‑Projekt nutzen

-   Kurzer Überblick über die Einbindung (ohne ins Detail zu gehen):
    -   Gradle‑Plugin (oder Dependency) für ANTLR.
    -   Grammatikdatei liegt z.B. unter src/main/antlr4.

-   Build‑Prozess (vereinfacht):
    -   Gradle führt ANTLR aus.
    -   ANTLR generiert Java‑Klassen (Lexer, Parser, *Context‑Klassen).
    -   Diese Klassen werden ganz normal mitkompiliert.

-   Für die Studierenden:
    -   Sie ändern im 2. Semester die Grammatik nicht.
    -   Sie arbeiten mit:
        -   der Parser‑Klasse (z.B. MiniLangParser)
        -   den Context-Klassen (z.B. MiniLangParser.StatementContext)
        -   ggf. einem generierten MiniLangBaseVisitor.


# Minimaler Java-Code: Text -> Baum

```java
var input = CharStreams.fromString(sourceCode);
var lexer = new MiniLangLexer(input);
var tokens = new CommonTokenStream(lexer);
var parser = new MiniLangParser(tokens);
var tree = parser.program(); // Wurzelknoten des Baums (Startregel der Grammatik)
```

-   `MiniLangLexer` und `MiniLangParser` sind aus Grammatik `MiniLang.g4` generiert (durch ANTLR).
-   `parser.program()` entspricht der Startregel `program`.
-   `tree` ist ein Objekt vom Typ `MiniLangParser.ProgramContext`.


Diesen Code können Sie als Schablone verwenden. Ab da arbeiten wir nur noch mit `tree`.


# Der Parse-Baum: Klassenhierarchie & Struktur

Wie sieht der erzeugte Baum in Java aus?

-   Grundprinzip:
    -   Jeder Knoten im Baum ist eine Instanz einer **Context-Klasse**:
    -   Es gibt generierte **Kontext-Klassen** für Sprachkonstrukte (Grammatik-Regeln):
        -   z.B. `MiniLangParser.ProgramContext`, `MiniLangParser.StatementContext`, `MiniLangParser.ExpressionContext`, ...

-   Typische Vererbung:
    -   Alle Baumknoten erben von einer gemeinsamen Basisklasse (z.B. `ParserRuleContext`).
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
        -   generierte Klassen und Methoden: `ExpressionContext expr()`, `List<StatementContext> statement()`;  `Program` - `Assignment` - `Identifier("x")` und `PlusExpression` - `NumberLiteral(1)` und `NumberLiteral(2)`


# Traversierung mit Visitor-Pattern

Den Baum "besuchen" - Visitor in ANTLR


-   Aufgabe:
    -   Wir wollen den generierten Baum verarbeiten (z.B. für Syntax-Highlighting, Auswertung, Umwandlung in AST).

-   ANTLR‑Visitor:
    -   ANTLR generiert ein `MiniLangVisitor<T>`-Interface und eine `MiniLangBaseVisitor<T>` Basisklasse mit leeren Standard-Implementierungen.
    -   Jede Regel in der Grammatik erzeugt:
        -   eine Kontext-Klasse `XxxContext``
        -   und eine Methode `R visitXxx(XxxContext ctx)`
    -   Jede Baumart hat eine eigene `visitXxx`‑Methode, z.B.:
        -   `visitProgram(ProgramContext ctx)`
        -   `visitAssignment(AssignmentContext ctx)`

-   Vorgehen:
    -   Eigene Visitor‑Klasse schreiben, die von `MiniLangBaseVisitor<...>` erbt.
        ```java
        public class HighlightVisitor extends MiniLangBaseVisitor<Void> {}
        ```
    -   Nur die Methoden überschreiben, die relevant sind.
        ```java
        @Override
        public Void visitNumberLiteral(MiniLangParser.NumberLiteralContext ctx) {
            // hier: Farbe wählen, Tokenposition auslesen, etc.
            return null;
        }
        ```
    -   Visitor anwenden:
        ```java
        var visitor = new HighlightVisitor();
        visitor.visit(tree);
        ```
-   Vorteile:
    -   Klare Trennung: Struktur (Baum) vs. Verarbeitung (Visitor).
    -   Erleichtert spätere Erweiterungen (weitere Visitor für andere Aufgaben).



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

-   Sie arbeiten in Prog2 nur mit `MiniLangLexer`, `MiniLangParser`, `XxxContext`-Klassen, `MiniLangBaseVisitor`:
    -   den Standard-Code, um `tree = parser.program()` zu bekommen.
    -   das Wissen: Knoten sind `XxxContext`‑Objekte.
    -   einen eigenen Visitor, der von `MiniLangBaseVisitor<...>` erbt.
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
