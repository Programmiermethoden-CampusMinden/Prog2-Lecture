# Reguläre Ausdrücke

> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit Hilfe von regulären Ausdrücken kann man den Aufbau von
> Zeichenketten formal beschreiben. Dabei lassen sich direkt die
> gewünschten Zeichen einsetzen, oder man nutzt Zeichenklassen oder
> vordefinierte Ausdrücke. Teilausdrücke lassen sich gruppieren und über
> *Quantifier* kann definiert werden, wie oft ein Teilausdruck vorkommen
> soll. Die Quantifier sind per Default **greedy** und versuchen so viel
> wie möglich zu matchen.
>
> Auf der Java-Seite stellt man reguläre Ausdrücke zunächst als `String`
> dar. Dabei muss darauf geachtet werden, dass ein Backslash im
> regulären Ausdruck im Java-String geschützt (*escaped*) werden muss,
> indem jeweils ein weiterer Backslash voran gestellt wird. Mit Hilfe
> der Klasse `java.util.regex.Pattern` lässt sich daraus ein Objekt mit
> dem kompilierten regulären Ausdruck erzeugen, was insbesondere bei
> mehrfacher Verwendung günstiger in der Laufzeit ist. Dem
> Pattern-Objekt kann man dann den Suchstring übergeben und bekommt ein
> Objekt der Klasse `java.util.regex.Matcher` (dort sind regulärer
> Ausdruck/Pattern und der Suchstring kombiniert). Mit den Methoden
> `Matcher#find` und `Matcher#matches` kann dann geprüft werden, ob das
> Pattern auf den Suchstring passt: `find` sucht dabei nach dem ersten
> Vorkommen des Patterns im Suchstring, `match` prüft, ob der gesamte
> String zum Pattern passt.
>
> </details>
> <details>
> <summary><strong>🎦 Videos</strong></summary>
>
> - [VL RegExp](https://youtu.be/K9R1Bwa73uI)
> - [Demo StringSplit](https://youtu.be/j_pTZBI6Z3M)
> - [Demo MatchFind](https://youtu.be/LYlPL1C_au8)
> - [Demo Quantifier](https://youtu.be/xkD9PhCjXyY)
> - [Demo Groups](https://youtu.be/ANLB2MdC_uY)
> - [Demo Backref](https://youtu.be/SRZyT3EAB94)
>
> </details>
> <details>
> <summary><strong>🖇 Unterlagen</strong></summary>
>
> - [PDF-Version](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/_pdf/lecture/java-classic/regexp.pdf)
>
> </details>

## Suchen in Strings

Gesucht ist ein Programm zum Extrahieren von Telefonnummern aus E-Mails.

=\> **Wie geht das?**

Leider gibt es unzählig viele Varianten, wie man eine Telefonnummer
(samt Vorwahl und ggf. Ländervorwahl) aufschreiben kann:

    030 - 123 456 789, 030-123456789, 030/123456789,
    +49(30)123456-789, +49 (30) 123 456 - 789, ...

## Definition Regulärer Ausdruck

> Ein **regulärer Ausdruck** ist eine Zeichenkette, die zur Beschreibung
> von Zeichenketten dient.

### Anwendungen

- Finden von Bestandteilen in Zeichenketten
- Aufteilen von Strings in Tokens
- Validierung von textuellen Eingaben =\> "Eine Postleitzahl besteht aus
  5 Ziffern"
- Compilerbau: Erkennen von Schlüsselwörtern und Strukturen und
  Syntaxfehlern

## Einfachste reguläre Ausdrücke

| **Zeichenkette** | **Beschreibt**         |
|:-----------------|:-----------------------|
| `x`              | "x"                    |
| `.`              | ein beliebiges Zeichen |
| `\t`             | Tabulator              |
| `\n`             | Newline                |
| `\r`             | Carriage-return        |
| `\\`             | Backslash              |

### Beispiel

- `abc` =\> "abc"
- `A.B` =\> "AAB" oder "A2B" oder ...
- `a\\bc` =\> "a\\bc"

### Anmerkung

In Java-Strings leitet der Backslash eine zu interpretierende
Befehlssequenz ein. Deshalb muss der Backslash i.d.R. geschützt
("escaped") werden. =\> Statt "`\n`" müssen Sie im Java-Code "`\\n`"
schreiben!

## Zeichenklassen

| **Zeichenkette** | **Beschreibt**                                           |
|:-----------------|:-----------------------------------------------------|
| `[abc]`          | "a" oder "b" oder "c"                                    |
| `[^abc]`         | alles außer "a", "b" oder "c" (Negation)                 |
| `[a-zA-Z]`       | alle Zeichen von "a" bis "z" und "A" bis "Z" (Range)     |
| `[a-z&&[def]]`   | "d","e" oder "f" (Schnitt)                               |
| `[a-z&&[^bc]]`   | "a" bis "z", außer "b" und "c": `[ad-z]` (Subtraktion)   |
| `[a-z&&[^m-p]]`  | "a" bis "z", außer "m" bis "p": `[a-lq-z]` (Subtraktion) |

### Beispiel

- `[abc]` =\> "a" oder "b" oder "c"
- `[a-c]` =\> "a" oder "b" oder "c"
- `[a-c][a-c]` =\> "aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb" oder
  "cc"
- `A[a-c]` =\> "Aa", "Ab" oder "Ac"

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

### Beispiel

- `\d\d\d\d\d` =\> "12345"
- `\w\wA` =\> "aaA", "a0A", "a_A", ...

## Nutzung in Java

- `java.lang.String`:

  ``` java
  public String[] split(String regex)
  public boolean matches(String regex)
  ```

<p align="right">Demo:
regexp.StringSplit (https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/StringSplit.java)</p>

- `java.util.regex.Pattern`:

  ``` java
  public static Pattern compile(String regex)
  public Matcher matcher(CharSequence input)
  ```

  - Schritt 1: Ein Pattern compilieren (erzeugen) mit `Pattern#compile`
    =\> liefert ein Pattern-Objekt für den regulären Ausdruck zurück
  - Schritt 2: Dem Pattern-Objekt den zu untersuchenden Zeichenstrom
    übergeben mit `Pattern#matcher` =\> liefert ein Matcher-Objekt
    zurück, darin gebunden: Pattern (regulärer Ausdruck) und die zu
    untersuchende Zeichenkette

<!-- -->

- `java.util.regex.Matcher`:

  ``` java
  public boolean find()
  public boolean matches()
  public int groupCount()
  public String group(int group)
  ```

  - Schritt 3: Mit dem Matcher-Objekt kann man die Ergebnisse der
    Anwendung des regulären Ausdrucks auf eine Zeichenkette auswerten

    Bedeutung der unterschiedlichen Methoden siehe folgende Folien

    `Matcher#group`: Liefert die Sub-Sequenz des Suchstrings zurück, die
    erfolgreich gematcht wurde (siehe unten "Fangende Gruppierungen")

**Hinweis**:

In Java-Strings leitet der Backslash eine zu interpretierende
Befehlssequenz ein. Deshalb muss der Backslash i.d.R. extra geschützt
("escaped") werden.

=\> Statt "`\n`" (regulärer Ausdruck) müssen Sie im Java-String "`\\n`"
schreiben!

=\> Statt "`a\\bc`" (regulärer Ausdruck, passt auf die Zeichenkette
"a\\bc") müssen Sie im Java-String "`a\\\\bc`" schreiben!

<p align="right">Demo:
regexp.MatchFind (https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/MatchFind.java)</p>

## Unterschied zw. Finden und Matchen

- `Matcher#find`:

  Regulärer Ausdruck muss im Suchstring **enthalten** sein. =\> Suche
  nach **erstem Vorkommen**

<!-- -->

- `Matcher#matches`:

  Regulärer Ausdruck muss auf **kompletten** Suchstring passen.

### Beispiel

- Regulärer Ausdruck: `abc`, Suchstring: "blah blah abc blub"
  - `Matcher#find`: erfolgreich
  - `Matcher#matches`: kein Match - Suchstring entspricht nicht dem
    Muster

## Quantifizierung

| **Zeichenkette** | **Beschreibt**                                   |
|:-----------------|:-------------------------------------------------|
| `X?`             | ein oder kein "X"                                |
| `X*`             | beliebig viele "X" (inkl. kein "X")              |
| `X+`             | mindestens ein "X", ansonsten beliebig viele "X" |
| `X{n}`           | exakt $n$ Vorkommen von "X"                      |
| `X{n,}`          | mindestens $n$ Vorkommen von "X"                 |
| `X{n,m}`         | zwischen $n$ und $m$ Vorkommen von "X"           |

### Beispiel

- `\d{5}` =\> "12345"
- `-?\d+\.\d*` =\> ???

## Interessante Effekte

``` java
Pattern p = Pattern.compile("A.*A");
Matcher m = p.matcher("A 12 A 45 A");

if (m.matches())
    String result = m.group(); // ???
```

<p align="right">Demo:
regexp.Quantifier (https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/Quantifier.java)</p>

`Matcher#group` liefert die Inputsequenz, auf die der Matcher
angesprochen hat. Mit `Matcher#start` und `Matcher#end` kann man sich
die Indizes des ersten und letzten Zeichens des Matches im
Eingabezeichenstrom geben lassen. D.h. für einen Matcher `m` und eine
Eingabezeichenkette `s` ist `m.group()` und
`s.substring(m.start(), m.end())` äquivalent.

Da bei `Matcher#matches` das Pattern immer auf den gesamten Suchstring
passen muss, verwundert das Ergebnis für `Matcher#group` nicht. Bei
`Matcher#find` wird im Beispiel allerdings ebenfalls der gesamte
Suchstring "gefunden" ... Dies liegt am "*greedy*" Verhalten der
Quantifizierer.

## Nicht gierige Quantifizierung mit "?"

| **Zeichenkette** | **Beschreibt**               |
|:-----------------|:-----------------------------|
| `X*?`            | non-greedy Variante von `X*` |
| `X+?`            | non-greedy Variante von `X+` |

### Beispiel

- Suchstring "A 12 A 45 A":
  - `A.*A` findet/passt auf "A 12 A 45 A"

    normale **greedy** Variante

  - `A.*?A`

    - findet "A 12 A"
    - passt auf "A 12 A 45 A" (!)

    **non-greedy** Variante der Quantifizierung; `Matcher#matches` muss
    trotzdem auf den gesamten Suchstring passen!

## (Fangende) Gruppierungen

`Studi{2}` passt nicht auf "StudiStudi" (!)

Quantifizierung bezieht sich auf das direkt davor stehende Zeichen. Ggf.
Gruppierungen durch Klammern verwenden!

| **Zeichenkette** | **Beschreibt** |
|:-----------------|:---------------|
| `X\|Y`           | X oder Y       |
| `(C)`            | Gruppierung    |

### Beispiel

- `(A)(B(C))`
  - Gruppe 0: `ABC`
  - Gruppe 1: `A`
  - Gruppe 2: `BC`
  - Gruppe 3: `C`

Die Gruppen heißen auch "fangende" Gruppen (engl.: *"capturing
groups"*).

Damit erreicht man eine Segmentierung des gesamten regulären Ausdrucks,
der in seiner Wirkung aber nicht durch die Gruppierungen geändert wird.
Durch die Gruppierungen von Teilen des regulären Ausdrucks erhält man
die Möglichkeit, auf die entsprechenden Teil-Matches (der Unterausdrücke
der einzelnen Gruppen) zuzugreifen:

- `Matcher#groupCount`: Anzahl der "fangenden" Gruppen im regulären
  Ausdruck

- `Matcher#group(i)`: Liefert die Subsequenz der Eingabezeichenkette
  zurück, auf die die jeweilige Gruppe gepasst hat. Dabei wird von links
  nach rechts durchgezählt, beginnend bei 1(!).

  Konvention: Gruppe 0 ist das gesamte Pattern, d.h.
  `m.group(0) == m.group();` ...

*Hinweis*: Damit der Zugriff auf die Gruppen klappt, muss auch erst ein
Match gemacht werden, d.h. das Erzeugen des Matcher-Objekts reicht noch
nicht, sondern es muss auch noch ein `matcher.find()` oder
`matcher.matches()` ausgeführt werden. Danach kann man bei Vorliegen
eines Matches auf die Gruppen zugreifen.

`(Studi){2}` =\> "StudiStudi"

<p align="right">Demo:
regexp.Groups (https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/Groups.java)</p>

## Gruppen und Backreferences

Matche zwei Ziffern, gefolgt von den selben zwei Ziffern

<div align="center">

`(\d\d)\1`

</div>

- Verweis auf bereits gematchte Gruppen: `\num`

  `num` Nummer der Gruppe (1 ... 9)

  =\> Verweist nicht auf regulären Ausdruck, sondern auf jeweiligen
  Match!

  *Anmerkung*: Laut Literatur/Doku nur 1 ... 9, in Praxis geht auch mehr
  per Backreference ...

<!-- -->

- Benennung der Gruppe: `(?<name>X)`

  `X` ist regulärer Ausdruck für Gruppe, spitze Klammern wichtig

  =\> Backreference: `\k<name>`

<p align="right">Demo:
regexp.Backref (https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/Backref.java)</p>

## Beispiel Gruppen und Backreferences

Regulärer Ausdruck: Namen einer Person matchen, wenn Vor- und Nachname
identisch sind.

Lösung: `([A-Z][a-zA-Z]*)\s\1`

## Umlaute und reguläre Ausdrücke

- Keine vordefinierte Abkürzung für Umlaute (wie etwa `\d`)

- Umlaute nicht in `[a-z]` enthalten, aber in `[a-ü]`

  ``` java
  "helloüA".matches(".*?[ü]A");
  "azäöüß".matches("[a-ä]");
  "azäöüß".matches("[a-ö]");
  "azäöüß".matches("[a-ü]");
  "azäöüß".matches("[a-ß]");
  ```

- Strings sind Unicode-Zeichenketten

  =\> Nutzung der passenden Unicode Escape Sequence `\uFFFF`

  ``` java
  System.out.println("\u0041 :: A");
  System.out.println("helloüA".matches(".*?A"));
  System.out.println("helloüA".matches(".*?\u0041"));
  System.out.println("helloü\u0041".matches(".*?A"));
  ```

- RegExp vordefinieren und mit Variablen zusammenbauen ala Perl nicht
  möglich =\> Umweg String-Repräsentation

## Wrap-Up

- RegExp: Zeichenketten, die andere Zeichenketten beschreiben
- `java.util.regex.Pattern` und `java.util.regex.Matcher`
- Unterschied zwischen `Matcher#find` und `Matcher#matches`!
- Quantifizierung ist möglich, aber **greedy** (Default)

## 📖 Zum Nachlesen

- Oracle Corporation ([2024](#ref-Java-SE-Tutorial))

------------------------------------------------------------------------

> [!TIP]
> <details>
> <summary><strong>✅ Lernziele</strong></summary>
>
> - k1: Wichtigste Methoden von java.util.regex.Pattern und java.util.regex.Matcher
> - k2: Unterschied zwischen Matcher#find und Matcher#matches
> - k2: Unterscheidung zwischen greedy und non-greedy Verhalten
> - k3: Bildung einfacher regulärer Ausdrücke
> - k3: Nutzung von Zeichenklassen und deren Negation
> - k3: Nutzung der vordefinierten regulären Ausdrücke
> - k3: Nutzung von Quantifizierern
> - k3: Zusammenbauen von komplexen Ausdrücken (u.a. mit Gruppen)
>
> </details>
> <details>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Schreiben Sie eine Methode, die mit Hilfe von regulären Ausdrücken
> überprüft, ob der eingegebene String eine nach dem folgenden Schema
> gebildete EMail-Adresse ist:
>
> > `name@firma.domain`
>
> Dabei sollen folgende Regeln gelten:
>
> - Die Bestandteile `name` und `firma` können aus Buchstaben, Ziffern,
>   Unter- und Bindestrichen bestehen.
> - Der Bestandteil `name` muss mindestens ein Zeichen lang sein.
> - Der Bestandteil `firma` kann entfallen, dann entfällt auch der
>   nachfolgende Punkt (`.`) und der Teil `domain` folgt direkt auf das
>   `@`-Zeichen.
> - Der Bestandteil `domain` besteht aus 2 oder 3 Kleinbuchstaben.
>
> Hinweis: Sie dürfen keinen Oder-Operator verwenden.
>
> </details>

------------------------------------------------------------------------

> [!NOTE]
> <details>
> <summary><strong>👀 Quellen</strong></summary>
>
> <div id="refs" class="references csl-bib-body hanging-indent"
> entry-spacing="0">
>
> <div id="ref-Java-SE-Tutorial" class="csl-entry">
>
> Oracle Corporation. 2024. „The Java Tutorials". 2024.
> <https://docs.oracle.com/javase/tutorial/>.
>
> </div>
>
> </div>
>
> </details>

------------------------------------------------------------------------

<div style="width:10%;">

![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

</div>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> 2ce9f3f (Tooling: use original folder structure for generated pdf's, 2025-04-17)<br></sub></sup></p></blockquote>
