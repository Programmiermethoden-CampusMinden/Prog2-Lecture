---
type: lecture-cg
title: "Ressourcen"
author: "Carsten Gips (FH Bielefeld)"
weight: 4
hidden: true
---


@Bloch2018
@Chacon2014
@Dietz2018
@Nissen1997
...


## Was brauche ich? Literatur ...

### Basics ("Must Have"!)

1.  "**Compiler: Prinzipien, Techniken und Werkzeuge**": @Aho2008
2.  "**Crafting Interpreters**": @Nystrom2021

### Weitere empfohlene Literatur

Ergänzend zum @Aho2008 empfiehlt sich ein Blick in @Mogensen2017 und @Watson2017, wo ebenfalls beinahe
alle Themen (auf etwas einfacherem Niveau) besprochen werden.

Zur Vertiefung sei @Grune2012 als eine moderne Variante zum Drachenbuch empfohlen. Ebenfalls sehr interessant
ist @Torczon2012, wobei hier der Fokus allerdings sehr stark auf dem Backend liegt. Ein weiteres gutes Buch
zum Thema Compilerbau ist @Wirth2011.

Zum Thema "Formale Sprachen" wird auf @Wagenknecht2014 und @Schoening2009 verwiesen.

Zu ANTLR sei auf die Online-Dokumentation [github.com/antlr](https://github.com/antlr/antlr4) verwiesen
sowie auf @Parr2014. Dort gibt der Autor eine Einführung in ANTLR und geht u.a. auch auf LL-Parsing und
Symboltabellen ein. @Parr2010 ist ebenfalls interessant in Bezug auf die Erläuterungen zum Lexing und
(LL-) Parsing, allerdings bezieht sich das Buch in den Beispielen auf eine veraltete ANTLR-Version.

Speziell zu Flex und Bison sei auf @Levine2009 verwiesen.

In @Ball2018a und @Ball2018b wird für eine kleine künstliche Sprache *Monkey* jeweils ein Interpreter und ein
Compiler in Go entwickelt. (Achtung: Das ist ein relativ praktisches Vorgehen, hier findet sich kaum Theorie!)
Wer sich für Haskell interessiert, findet den passenden Beispielcode (für den Interpreter-Teil) in
[github.com/utatti/monkey-hs](https://github.com/utatti/monkey-hs).
Analog wird in @Clausing2011 für verschiedene Sprachen (imperativ, objektorientiert, funktional: Mini-C,
Mini-Java, Mini-Lisp) ein Interpreter in Java geschrieben. Um den Interpreter einfach zu halten, wird für die
betrachteten Sprachen allerdings jeweils eine Scheme-ähnliche Syntax (und nicht die übliche) eingesetzt.
@Nystrom2021 entwickelt ebenfalls einen Interpreter für eine fiktive Sprache.

Bei Interesse an Sprachkonzepten und der entsprechenden Umsetzung im Compilerbau erscheinen @Clausing2011,
@Lee2017, @Sestoft2017 und @Scott2016 interessant.

Unter @Alhour2018 findet sich eine kuratierte Liste mit interessanten Hinweisen, Projekten und Literatur zum
Thema Compilerbau. Lohnenswert!

**Hinweis**: Am Ende einer Vorlesung wird noch einmal spezifisch zum Thema passende Literatur empfohlen.


`{{< bib />}}`{=markdown}
