---
type: lecture-cg
title: "Template-Method-Pattern"
menuTitle: "Template-Method"
author: "Carsten Gips (FH Bielefeld)"
weight: 5
readings:
  - key: "Eilebrecht2013"
  - key: "Gamma2011"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet01
youtube:
  - link: ""
    name: "VL "
fhmedia:
  - link: ""
    name: "VL "
---


## Motivation: Syntax-Highlighting im Tokenizer

::: notes
In einem Compiler ist meist der erste Arbeitsschritt, den Eingabestrom in einzelne
Token aufzubrechen. Dies sind oft die verschiedenen Schlüsselwörter, Operationen,
Namen von Variablen, Methoden, Klassen etc. ... Aus der Folge von Zeichen (also dem
eingelesenen Programmcode) wird ein Strom von Token, mit dem die nächste Stufe im
Compiler dann weiter arbeiten kann.
:::

```java
public class Lexer {
    private final List<Token> allToken;  // alle verfügbaren Token-Klassen

    public List<Token> tokenize(String string) {
        List<Token> result = new ArrayList<>();

        while (string.length() > 0) {
            for (Token t : allToken) {
                Token token = t.match(string);
                if (token != null) {
                    result.add(token);
                    string = string.substring(token.getContent().length(), string.length());
                }
            }
        }

        return result;
    }
}
```

::: notes
Dazu prüft man jedes Token, ob es auf den aktuellen Anfang des Eingabestroms passt.
Wenn ein Token passt, erzeugt man eine Instanz dieser Token-Klasse und speichert darin
den gematchten Eingabeteil, den man dann vom Eingabestrom entfernt. Danach geht man
in die Schleife und prüft wieder alle Token ... bis irgendwann der Eingabestrom leer
ist und man den gesamten eingelesenen Programmcode in eine dazu passende Folge von
Token umgewandelt hat.

_Anmerkung_: Abgesehen von fehlenden Javadoc etc. hat das obige Code-Beispiel mehrere
Probleme: Man würde im realen Leben nicht mit `String`, sondern mit einem Zeichenstrom
arbeiten. Außerdem fehlt noch eine Fehlerbehandlung, wenn nämlich keines der Token in
der Liste `allToken` auf den aktuellen Anfang des Eingabestroms passt.
:::


## Token-Klassen mit formatiertem Inhalt

::: notes
Um den eigenen Tokenizer besser testen zu können, wurde beschlossen, dass jedes Token
seinen Inhalt als formatiertes HTML-Schnipsel zurückliefern soll. Damit kann man dann
alle erkannten Token formatiert ausgeben und erhält eine Art Syntax-Highlighting für
den eingelesenen Programmcode.
:::

```java
public abstract class Token {
    protected String content;

    abstract protected String getHtml();
}
public class KeyWord extends Token {
    @Override
    protected String getHtml() {
        return "<font color=\"red\"><b>" +  this.content + "</b></font>";
    }
}
public class StringContent extends Token {
    @Override
    protected String getHtml() {
        return "<font color=\"green\">" +  this.content + "</font>";
    }
}


Token t = new KeyWord();
LOG.info(t.getHtml());
```

::: notes
In der ersten Umsetzung erhält die Basisklasse `Token` eine weitere abstrakte
Methode, die jede Token-Klasse implementieren muss und in der die Token-Klassen
einen String mit dem Token-Inhalt und einer Formatierung für HTML zurückgeben.

Dabei fällt auf, dass der Aufbau immer gleich ist: Es werden ein oder mehrere
Tags zum Start der Format-Sequenz mit dem Token-Inhalt verbunden, gefolgt mit
einem zum verwendeten startenden HTML-Format-Tag passenden End-Tag.

Auch wenn die Inhalte unterschiedlich sind, sieht das stark nach einer Verletzung
von DRY aus ...
:::


## Don't call us, we'll call you

```java
public abstract class Token {
    protected String content;

    public final String getHtml() {
        return htmlStart() + this.content + htmlEnd();
    }

    abstract protected String htmlStart();
    abstract protected String htmlEnd();
}
public class KeyWord extends Token {
    @Override protected String htmlStart() { return "<font color=\"red\"><b>"; }
    @Override protected String htmlEnd() { return "</b></font>"; }
}
public class StringContent extends Token {
    @Override protected String htmlStart() { return "<font color=\"green\">"; }
    @Override protected String htmlEnd() { return "</font>"; }
}


Token t = new KeyWord();
LOG.info(t.getHtml());
```

::: notes
Wir können den Spaß einfach umdrehen (["inversion of control"](https://en.wikipedia.org/wiki/Inversion_of_control))
und die Methode zum Zusammenbasteln des HTML-Strings bereits in der Basisklasse
implementieren. Dazu "rufen" wir dort drei Hilfsmethoden auf, die die jeweiligen
Bestandteile des Strings (Format-Start, Inhalt, Format-Ende) erzeugen und deren
konkrete Implementierung wir in der Basisklasse nicht kennen. Dies ist dann Sache
der ableitenden konkreten Token-Klassen.

Objekte vom Typ `KeyWord` sind dank der Vererbungsbeziehung auch `Token` (Vererbung:
_is-a-Beziehung_). Wenn man nun auf einem `Token t` die Methode `getHtml()` aufruft,
wird zur Laufzeit geprüft, welchen Typ `t` tatsächlich hat (im Beispiel `KeyWord`).
Methodenaufrufe werden dann mit den am tiefsten in der vorliegenden Vererbungshierarchie
implementierten Methoden durchgeführt: Hier wird also die von `Token` geerbte Methode
`getHtml()` in `KeyWord` aufgerufen, die ihrerseits die Methoden `htmlStart()` und
`htmlEnd()` aufruft. Diese sind in `KeyWord` implementiert und liefern nun die passenden
Ergebnisse.

Die Methode `getHtml()` wird auch als "_Template-Methode_" bezeichnet. Die beiden darin
aufgerufenen Methoden `htmlStart()` und `htmlEnd()` in `Token` werden auch als "_Hook-Methoden_"
bezeichnet.

Dies ist ein Beispiel für das **[Template-Method-Pattern](https://en.wikipedia.org/wiki/Template_method_pattern)**.
:::


## Template-Method-Pattern

![](images/template-method.png){width="80%" web_width="50%"}

::: notes
Dieses Pattern hat eine starke Verwandtschaft zum Strategy-Pattern.

Dort haben wir Verhalten komplett an andere Objekte _delegiert_, indem
wir in einer Methode einfach die passende Methode auf dem übergebenen
Strategie-Objekt aufgerufen haben.

Im Template-Method-Pattern nutzen wir Vererbung und dynamische Polymorphie
und definieren abstrakte Template-Methoden, die wir in den Methoden der
Basis-Klasse aufrufen. Die Template-Methoden werden aber ihrerseits erst
in den ableitenden Klassen implementiert. Damit lagert man hier gewissermaßen
nur Teile des Verhaltens an die ableitenden Klassen aus.
:::


## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
