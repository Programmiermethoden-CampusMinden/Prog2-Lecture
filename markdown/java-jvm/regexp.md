---
type: lecture-cg
title: "Reguläre Ausdrücke"
menuTitle: "RegExp"
author: "Carsten Gips (FH Bielefeld)"
weight: 1
readings:
  - key: "Java-SE-Tutorial"
    comment: "Essential Java Classes > Regular Expressions"
tldr: |
    Mit Hilfe von regulären Ausdrücken kann man den Aufbau von Zeichenketten formal
    beschreiben. Dabei lassen sich direkt die gewünschten Zeichen einsetzen, oder
    man nutzt Zeichenklassen oder vordefinierte Ausdrücke. Teilausdrücke lassen sich
    gruppieren und über _Quantifier_ kann definiert werden, wie oft ein Teilausdruck
    vorkommen soll. Die Quantifier sind per Default **greedy** und versuchen so viel
    wie möglich zu matchen.

    Auf der Java-Seite stellt man reguläre Ausdrücke zunächst als `String` dar. Dabei
    muss darauf geachtet werden, dass ein Backslash im regulären Ausdruck im Java-String
    geschützt (_escaped_) werden muss, indem ein weiterer Backslash voran gestellt
    wird. Mit Hilfe der Klasse `java.util.regex.Pattern` lässt sich daraus ein Objekt
    mit dem kompilierten regulären Ausdruck erzeugen, was insbesondere bei mehrfacher
    Verwendung günstiger in der Laufzeit ist. Dem Pattern-Objekt kann man dann den
    Suchstring übergeben und bekommt ein Objekt der Klasse `java.util.regex.Matcher`
    (dort sind regulärer Ausdruck/Pattern und der Suchstring kombiniert). Mit den
    Methoden `Matcher#find` und `Matcher#matches` kann dann geprüft werden, ob das Pattern
    auf den Suchstring passt: `find` sucht dabei nach dem ersten Vorkommen des Patterns
    im Suchstring, `match` prüft, ob der gesamte String zum Pattern passt.
outcomes:
  - k1: "Wichtigste Methoden von `java.util.regex.Pattern` und `java.util.regex.Matcher`"
  - k2: "Unterschied zwischen `Matcher#find` und `Matcher#matches`"
  - k2: "Unterscheidung zwischen greedy und non-greedy Verhalten"
  - k3: "Bildung einfacher regulärer Ausdrücke"
  - k3: "Nutzung von Zeichenklassen und deren Negation"
  - k3: "Nutzung der vordefinierten regulären Ausdrücke"
  - k3: "Nutzung von Quantifizierern"
  - k3: "Zusammenbauen von komplexen Ausdrücken (u.a. mit Gruppen)"
quizzes:
  - link: "XYZ"
    name: "Quiz RegExp (ILIAS)"
assignments:
  - topic: sheet08
youtube:
  - link: "https://youtu.be/K9R1Bwa73uI"
    name: "VL RegExp"
  - link: ""
    name: "Demo StringSplit"
  - link: ""
    name: "Demo MatchFind"
  - link: ""
    name: "Demo Quantifier"
  - link: ""
    name: "Demo Groups"
  - link: ""
    name: "Demo Backref"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/35288af40bdf53fe210d0f8c4d25fd38d4c5f4cde5c04ffd49500f815723448b0bc16b305c7b05b0d57d670019d52dd5ff9da5f4a43afc0c85ed870b44f93e00"
    name: "VL RegExp"
---


## Suchen in Strings

Gesucht ist ein Programm zum Extrahieren von Telefonnummern aus E-Mails.

\bigskip
=> [**Wie geht das?**]{.alert}
\bigskip
\bigskip

\pause

::: notes
Leider gibt es unzählig viele Varianten, wie man eine Telefonnummer (samt
Vorwahl und ggf. Ländervorwahl) aufschreiben kann:
:::

    030 - 123 456 789, 030-123456789, 030/123456789,
    +49(30)123456-789, +49 (30) 123 456 - 789, ...


## Definition Regulärer Ausdruck

> Ein **regulärer Ausdruck** ist eine Zeichenkette, die zur Beschreibung von
> Zeichenketten dient.

::: notes
### Anwendungen

*   Finden von Bestandteilen in Zeichenketten
*   Aufteilen von Strings in Tokens
*   Validierung von textuellen Eingaben
    => "Eine Postleitzahl besteht aus 5 Ziffern"
*   Compilerbau: Erkennen von Schlüsselwörtern und Strukturen und Syntaxfehlern
:::


## Einfachste reguläre Ausdrücke

| **Zeichenkette** | **Beschreibt**         |
|:-----------------|:-----------------------|
| `x`              | "x"                    |
| `.`              | ein beliebiges Zeichen |
| `\t`             | Tabulator              |
| `\n`             | Newline                |
| `\r`             | Carriage-return        |
| `\\`             | Backslash              |

::: notes
### Beispiel
:::

*   `abc` => "abc"
*   `A.B` => "AAB" oder "A2B" oder ...
*   `a\\bc` => "a\\bc"

::: notes
### Anmerkung

In Java-Strings leitet der Backslash eine zu interpretierende Befehlssequenz ein.
Deshalb muss der Backslash i.d.R. geschützt ("escaped") werden.
=> Statt "`\n`" müssen Sie im Java-Code "`\\n`" schreiben!
:::


## Zeichenklassen

| **Zeichenkette** | **Beschreibt**                                           |
|:-----------------|:---------------------------------------------------------|
| `[abc]`          | "a" oder "b" oder "c"                                    |
| `[^abc]`         | alles außer "a", "b" oder "c" (Negation)                 |
| `[a-zA-Z]`       | alle Zeichen von "a" bis "z" und "A" bis "Z" (Range)     |
| `[a-z&&[def]]`   | "d","e" oder "f" (Schnitt)                               |
| `[a-z&&[^bc]]`   | "a" bis "z", außer "b" und "c": `[ad-z]` (Subtraktion)   |
| `[a-z&&[^m-p]]`  | "a" bis "z", außer "m" bis "p": `[a-lq-z]` (Subtraktion) |

::: notes
### Beispiel
:::

*   `[abc]` => "a" oder "b" oder "c"
*   `[a-c]` => "a" oder "b" oder "c"
*   `[a-c][a-c]` => "aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb" oder "cc"
*   `A[a-c]` => "Aa", "Ab" oder "Ac"


## Vordefinierte Ausdrücke

| **Zeichenkette** | **Beschreibt**                               |
|:-----------------|:---------------------------------------------|
| `^`              | Zeilenanfang                                 |
| `$`              | Zeilenende                                   |
| `\d`             | eine Ziffer: `[0-9]`                         |
| `\w`             | beliebiges Wortzeichen: `[a-zA-Z_0-9]`       |
| `\s`             | Whitespace (Leerzeichen, Tabulator, Newline) |
| `\D`             | jedes Zeichen außer Ziffern: `[^0-9]`        |
| `\W`             | jedes Zeichen außer Wortzeichen: `[^\w]`     |
| `\S`             | jedes Zeichen außer Whitespaces: `[^\s]`     |

::: notes
### Beispiel
:::

*   `\d\d\d\d\d` => "12345"
*   `\w\wA` => "aaA", "a0A", "a_A", ...


## Nutzung in Java

\bigskip

*   `java.lang.String`:

    ```{.java size="footnotesize"}
    public String[] split(String regex)
    public boolean matches(String regex)
    ```

[Demo: [regexp.StringSplit](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/java-jvm/src/regexp/StringSplit.java)]{.bsp}

\pause

*   `java.util.regex.Pattern`:

    ```{.java size="footnotesize"}
    public static Pattern compile(String regex)
    public Matcher matcher(CharSequence input)
    ```

    ::: notes
    *   Schritt 1: Ein Pattern compilieren (erzeugen) mit `Pattern#compile`
        => liefert ein Pattern-Objekt für den regulären Ausdruck zurück
    *   Schritt 2: Dem Pattern-Objekt den zu untersuchenden Zeichenstrom
        übergeben mit `Pattern#matcher` => liefert ein Matcher-Objekt
        zurück, darin gebunden: Pattern (regulärer Ausdruck) und die zu
        untersuchende Zeichenkette
    :::

\smallskip

*   `java.util.regex.Matcher`:

    ```{.java size="footnotesize"}
    public boolean find()
    public boolean matches()
    public int groupCount()
    public String group(int group)
    ```

    ::: notes
    *   Schritt 3: Mit dem Matcher-Objekt kann man die Ergebnisse der
        Anwendung des regulären Ausdrucks auf eine Zeichenkette auswerten

        Bedeutung der unterschiedlichen Methoden siehe folgende Folien

        `Matcher#group`: Liefert die Sub-Sequenz des Suchstrings zurück, die
        erfolgreich gematcht wurde (siehe unten "Fangende Gruppierungen")
    :::

[Demo: [regexp.MatchFind](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/java-jvm/src/regexp/MatchFind.java)]{.bsp}


## Unterschied zw. Finden und Matchen

*   `Matcher#find`:

    Regulärer Ausdruck muss im Suchstring **enthalten** sein. \newline
    => Suche nach **erstem Vorkommen**

\smallskip

*   `Matcher#matches`:

    Regulärer Ausdruck muss auf **kompletten** Suchstring passen.

\bigskip

::: notes
### Beispiel
:::

*   Regulärer Ausdruck: `abc`, Suchstring: "blah blah abc blub"
    *   `Matcher#find`: erfolgreich
    *   `Matcher#matches`: kein Match -- Suchstring entspricht nicht dem Muster


## Quantifizierung

| **Zeichenkette** | **Beschreibt**                                   |
|:-----------------|:-------------------------------------------------|
| `X?`             | ein oder kein "X"                                |
| `X*`             | beliebig viele "X" (inkl. kein "X")              |
| `X+`             | mindestens ein "X", ansonsten beliebig viele "X" |
| `X{n}`           | exakt $n$ Vorkommen von "X"                      |
| `X{n,}`          | mindestens $n$ Vorkommen von "X"                 |
| `X{n,m}`         | zwischen $n$ und $m$ Vorkommen von "X"           |

::: notes
### Beispiel
:::

*   `\d{5}` => "12345"
*   `-?\d+\.\d*` => ???


## Interessante Effekte

```java
Pattern p = Pattern.compile("A.*A");
Matcher m = p.matcher("A 12 A 45 A");

String result = m.group(); // ???
```

[Demo: [regexp.Quantifier](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/java-jvm/src/regexp/Quantifier.java)]{.bsp}

::: notes
`Matcher#group` liefert die Inputsequenz, auf die der Matcher angesprochen hat.
Mit `Matcher#start` und `Matcher#end` kann man sich die Indizes des ersten und
letzten Zeichens des Matches im Eingabezeichenstrom geben lassen. D.h. für einen
Matcher `m` und eine Eingabezeichenkette `s` ist `m.group()` und
`s.substring(m.start(), m.end())` äquivalent.

Da bei `Matcher#matches` das Pattern immer auf den gesamten Suchstring passen
muss, verwundert das Ergebnis für `Matcher#group` nicht. Bei `Matcher#find`
wird im Beispiel allerdings ebenfalls der gesamte Suchstring "gefunden" ...
Dies liegt am "*greedy*" Verhalten der Quantifizierer.
:::


## Nicht gierige Quantifizierung mit "?"

\bigskip

| **Zeichenkette** | **Beschreibt**               |
|:-----------------|:-----------------------------|
| `X*?`            | non-greedy Variante von `X*` |
| `X+?`            | non-greedy Variante von `X+` |

::: notes
### Beispiel
:::

*   Suchstring "A 12 A 45 A":
    *   `A.*A` findet/passt auf "A 12 A 45 A"

        ::: notes
        normale **greedy** Variante
        :::

    *   `A.*?A`
        *   findet "A 12 A"
        *   passt auf "A 12 A 45 A" (!)

        ::: notes
        **non-greedy** Variante der Quantifizierung;
        `Matcher#matches` muss trotzdem auf den gesamten Suchstring passen!
        :::


## (Fangende) Gruppierungen

`Studi{2}` passt [nicht]{.alert} auf "StudiStudi" (!)

::: notes
Quantifizierung bezieht sich auf das direkt davor stehende Zeichen. Ggf.
Gruppierungen durch Klammern verwenden!
:::

\pause
\bigskip

| **Zeichenkette** | **Beschreibt** |
|:-----------------|:---------------|
| `X|Y`            | X oder Y       |
| `(C)`            | Gruppierung    |

::: notes
### Beispiel
:::

*   `(A)(B(C))`
    -   Gruppe 0: `ABC`
    -   Gruppe 1: `A`
    -   Gruppe 2: `BC`
    -   Gruppe 3: `C`

::: notes
Die Gruppen heißen auch "fangende" Gruppen (engl.: *"capturing groups"*).

Damit erreicht man eine Segmentierung des gesamten regulären Ausdrucks, der
in seiner Wirkung aber nicht durch die Gruppierungen geändert wird. Durch die
Gruppierungen von Teilen des regulären Ausdrucks erhält man die Möglichkeit,
auf die entsprechenden Teil-Matches (der Unterausdrücke der einzelnen Gruppen)
zuzugreifen:

*   `Matcher#groupCount`: Anzahl der "fangenden" Gruppen im regulären Ausdruck
*   `Matcher#group(i)`: Liefert die Subsequenz der Eingabezeichenkette zurück,
    auf die die jeweilige Gruppe gepasst hat. Dabei wird von links nach rechts
    durchgezählt, beginnend bei 1(!).

    Konvention: Gruppe 0 ist das gesamte Pattern, d.h. `m.group(0) == m.group();` ...
:::

\pause
\bigskip

`(Studi){2}` => "StudiStudi"

[Demo: [regexp.Groups](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/java-jvm/src/regexp/Groups.java)]{.bsp}


## Gruppen und Backreferences

Matche zwei Ziffern, gefolgt von den selben zwei Ziffern

\pause

::: cbox
`(\d\d)\1`
:::

\bigskip
\smallskip

*   Verweis auf bereits gematchte Gruppen: `\num`

    `num` Nummer der Gruppe (1 ... 9)

    => Verweist nicht auf regulären Ausdruck, sondern auf jeweiligen Match!

    ::: notes
    *Anmerkung*: Laut Literatur/Doku nur 1 ... 9, in Praxis geht auch mehr per Backreference ...
    :::

\smallskip

*   Benennung der Gruppe: `(?<name>X)`

    `X` ist regulärer Ausdruck für Gruppe, spitze Klammern wichtig

    => Backreference: `\k<name>`

[Demo: [regexp.Backref](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/java-jvm/src/regexp/Backref.java)]{.bsp}


## Beispiel Gruppen und Backreferences

Regulärer Ausdruck: Namen einer Person matchen, wenn Vor- und Nachname identisch sind.

\pause
\bigskip

Lösung: `([A-Z][a-zA-Z]*)\s\1`


::: notes
## Umlaute und reguläre Ausdrücke

*   Keine vordefinierte Abkürzung für Umlaute (wie etwa `\d`)

*   Umlaute nicht in `[a-z]` enthalten, aber in `[a-ü]`

    ```java
    "helloüA".matches(".*?[ü]A");
    "azäöüß".matches("[a-ä]");
    "azäöüß".matches("[a-ö]");
    "azäöüß".matches("[a-ü]");
    "azäöüß".matches("[a-ß]");
    ```

*   Strings sind Unicode-Zeichenketten

    => Nutzung der passenden Unicode Escape Sequence `\uFFFF`

    ```java
    System.out.println("\u0041 :: A");
    System.out.println("helloüA".matches(".*?A"));
    System.out.println("helloüA".matches(".*?\u0041"));
    System.out.println("helloü\u0041".matches(".*?A"));
    ```

*   RegExp vordefinieren und mit Variablen zusammenbauen ala Perl
    nicht möglich => Umweg String-Repräsentation
:::


## Wrap-Up

*   RegExp: Zeichenketten, die andere Zeichenketten beschreiben
*   `java.util.regex.Pattern` und `java.util.regex.Matcher`
*   Unterschied zwischen `Matcher#find` und `Matcher#matches`!
*   Quantifizierung ist möglich, aber **greedy** (Default)







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
