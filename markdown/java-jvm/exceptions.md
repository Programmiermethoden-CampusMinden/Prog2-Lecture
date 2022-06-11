---
type: lecture-cg
title: "Exception-Handling"
menuTitle: "Exceptions"
author: "André Matutat / Carsten Gips (FH Bielefeld)"
weight: 8
readings:
  - key: "LernJava"
    comment: "Tutorials > Exceptions"
  - key: "Ullenboom2021"
    comment: "Kap. 8: Ausnahmen müssen sein"
  - key: "Java-SE-Tutorial"
    comment: "Trail: Essential Java Classes, Lesson: Exceptions"
tldr: |
    Man unterscheidet in Java zwischen **Exceptions** und *Errors**. Ein Error ist ein
    Fehler im System (OS, JVM), von dem man sich nicht wieder erholen kann. Eine Exception
    ist ein Fehlerfall innerhalb des Programmes, auf den man innerhalb des Programms
    reagieren kann.

    Mit Hilfe von Exceptions lassen sich Fehlerfälle im Programmablauf deklarieren und
    behandeln. Methoden können mit dem Keyword `throws` gefolgt vom Namen der Exception
    deklarieren, dass sie im Fehlerfall diese spezifische Exception werfen (und nicht
    selbst behandeln).

    Zum Exception-Handling werden die Keywords `try`, `catch` und `finally` verwendet.
    Dabei wird im `try`-Block der Code geschrieben, der einen potenziellen Fehler wirft.
    Im `catch`-Block wird das Verhalten implementiert, dass im Fehlerfall ausgeführt
    werden soll, und im `finally`-Block kann optional Code geschrieben werden, der sowohl
    im Erfolgs- als auch Fehlerfall ausgeführt wird.

    Es wird zwischen **checked** Exceptions und **unchecked** Exceptions unterschieden.
    Checked Exceptions sind für erwartbare Fehlerfälle gedacht, die nicht vom Programm
    ausgeschlossen werden können, wie das Fehlen einer Datei, die eingelesen werden soll.
    Checked Exceptions müssen deklariert und behandelt werden. Dies wird vom Compiler
    überprüft.

    Unchecked Exceptions werden für Fehler in der Programmlogik verwendet, etwa das Teilen
    durch 0 oder Index-Fehler. Sie deuten auf fehlerhafte Programmierung, fehlerhafte Logik
    oder beispielsweise mangelhafte Eingabeprüfung in. Unchecked Exceptions müssen nicht
    deklariert oder behandelt werden. Unchecked Exceptions leiten von `RuntimeException`
    ab.

    Als Faustregel gilt: Wenn der Aufrufer sich von einer Exception-Situation erholen kann,
    sollte man eine checked Exception nutzen. Wenn der Aufrufer vermutlich nichts tun kann,
    um sich von dem Problem zu erholen, dann sollte man eine unchecked Exception einsetzen.
outcomes:
  - k2: "Unterschied zwischen Error und Exception"
  - k2: "Unterschied zwischen checked und unchecked Exceptions"
  - k3: "Umgang mit Exceptions"
  - k3: "Eigene Exceptions schreiben"
quizzes:
  - link: ""
    name: "Quiz Exceptions (ILIAS)"
youtube:
  - link: ""
    name: "VL Exceptions"
  - link: ""
    name: "Demo Exceptions"
fhmedia:
  - link: ""
    name: "VL Exceptions"
---


## Fehlerfälle in Java

```java
int div(int a, int b) {
    return a / b;
}

div(3, 0);
```

::: notes
**Problem**: Programm wird abstürzen, da durch '0' geteilt wird
:::


## Lösung?

```java

Optional<Integer> div(int a, int b) {
    if (b == 0) return Optional.empty();
    return Optional.of(a / b);
}

Optional<Integer> x = div(3, 0);
if (x.isPresent()) {
    // do something
} else {
    // do something else
}
```

::: notes
**Probleme**:

*   Da `double` nicht `null` sein kann, muss ein `Double` Objekt erzeugt und zurückgegeben werden: Overhead wg. Auto-Boxing und -Unboxing!
*   Der Aufrufer muss auf `null` prüfen.
*   Es wird nicht kommuniziert, warum `null` zurückgegeben wird. Was ist das Problem?
*   Was ist, wenn `null` ein gültiger Rückgabewert sein soll?
:::


## Vererbungsstruktur _Throwable_

![](images/exception.png){width="80%"}

::::::::: notes
### _Exception_ vs. _Error_

*   `Error`:
    *   Liegen an Systemfehlern (Betriebssystem, JVM, ...)
        *   `StackOverflowError`
        *   `OutOfMemoryError`
    *   Von einem Error kann man sich  nicht erholen
    *   Sollten nicht behandelt werden

*   `Exception`:
    *   Ausnahmesituationen bei der Abarbeitung eines Programms
    *   Können "checked" oder "unchecked" sein
    *   Von Exceptions kann man sich erholen

### Unchecked vs. Checked Exceptions

*   "Checked" Exceptions:
    *   Für erwartbare Fehlerfälle, deren Ursprung nicht im Programm selbst liegt
        *   `FileNotFoundException`
        *   `IOException`
    *   Alle nicht von `RuntimeException` ableitende Exceptions
    *   Müssen behandelt (`try`/`catch`) oder deklariert (`throws`) werden: Dies
        wird vom Compiler überprüft!

*   "Unchecked" Exceptions:
    *   Logische Programmierfehler ("Versagen" des Programmcodes)
        *   `IndexOutOfBoundException`
        *   `NullPointerException`
        *   `ArithmeticException`
        *   `IllegalArgumentException`
    *   Leiten von `RuntimeException` oder Unterklassen ab
    *   Müssen nicht deklariert oder behandelt werden

Beispiele checked Exception:
*   Es soll eine Abfrage an eine externe API geschickt werden. Diese ist aber aktuell
    nicht zu erreichen. Lösung: Anfrage noch einmal schicken.
*   Es soll eine Datei geöffnet werden. Diese ist aber nicht unter dem angegebenen
    Pfad zu finden. Lösung: Aufrufer der Methode versucht es noch einmal mit einem
    anderen Namen.

Beispiele unchecked Exception:
*   Eine `for`-Loop über ein Array ist falsch programmiert und will auf einen Index
    im Array zugreifen, der nicht existiert. Hier kann der Aufrufer nicht Sinnvolles
    tun, um sich von dieser Situation zu erholen.
*   Argumente oder Rückgabewerte einer Methode können `null` sein. Wenn man das nicht
    prüft, sondern einfach Methoden auf dem vermeintlichen Objekt aufruft, wird eine
    `NullPointerException` ausgelöst, die eine Unterklasse von `RuntimeException` ist
    und damit eine unchecked Exception. Auch hier handelt es sich um einen Fehler in
    der Programmlogik, von dem sich der Aufrufer nicht sinnvoll erholen kann.
:::::::::


## _Throws_

```java
int div(int a, int b) throws ArithmeticException {
    return a / b;
}
```

::: notes
Alternativ:
:::

```java
int div(int a, int b) throws IllegalArgumentException {
    if (b == 0) throw new IllegalArgumentException("Can't divide by zero");
    return a / b;
}
```

::: notes
Exception können an an den Aufrufer weitergeleitet werden oder selbst geworfen werden.

Wenn wie im ersten Beispiel bei einer Operation eine Exception entsteht und nicht
gefangen wird, dann wird sie automatisch an den Aufrufer weitergeleitet. Dies wird
über die `throws`-Klausel deutlich gemacht (Keyword `throws` plus den/die Namen der
Exception(s), angefügt an die Methodensignatur). Bei unchecked Exceptions _kann_ man
das tun, bei checked Exceptions _muss_ man dies tun.

Wenn man wie im zweiten Beispiel selbst eine neue Exception werfen will, erzeugt man
mit `new` ein neues Objekt der gewünschten Exception und "wirft" diese mit `throw`.
Auch diese Exception kann man dann entweder selbst fangen und bearbeiten (siehe nächste
Folie) oder an den Aufrufer weiterleiten und dies dann entsprechend über die
`throws`-Klausel deklarieren: nicht gefangene checked Exceptions _müssen_ deklariert
werden, nicht gefangene unchecked Exceptions _können_ deklariert werden.

Wenn mehrere Exceptions an den Aufrufer weitergeleitet werden, werden sie in der
`throws`-Klausel mit Komma getrennt: `throws Exception1, Exception2, Exception3`.

**Anmerkung**: In beiden obigen Beispielen wurde zur Verdeutlichung, dass die Methode
`div()` eine Exception wirft, diese per `throws`-Klausel deklariert. Da es sich bei
den beiden Beispielen aber jeweils um **unchecked Exceptions** handelt, ist dies im
obigen Beispiel _nicht notwendig_. Der Aufrufer _muss_ auch nicht ein passendes
Exception-Handling einsetzen!

Wenn wir stattdessen eine **checked Exception** werfen würden oder in `div()` eine
Methode aufrufen würden, die eine checked Exception deklariert hat, _muss_ diese
checked Exception entweder in `div()` gefangen und bearbeitet werden oder aber per
`throws`-Klausel deklariert werden. Im letzteren Fall _muss_ dann der Aufrufer analog
damit umgehen (fangen oder selbst auch deklarieren). **Dies wird vom Compiler geprüft!**
:::


## _Try_-_Catch_

```java
int a = getUserInput();
int b = getUserInput();

try {
    div(a, b);
} catch (IllegalArgumentException e) {
    e.printStackTrace(); // Wird im Fehlerfall aufgerufen
}

// hier geht es normal weiter
```
::: notes
*   Im `try` Block wird der Code ausgeführt, der einen Fehler werfen könnte.
*   Mit `catch` kann eine Exception gefangen und im `catch` Block behandelt werden.
:::


## _Try_ with multiple _Catch_

```java
try {
    someMethod(a, b, c);
} catch (IllegalArgumentException iae) {
    iae.printStackTrace();
} catch (FileNotFoundException | NullPointerException e) {
    e.printStackTrace();
}
```

::: notes
Eine im `try`-Block auftretende Exception wird der Reihe nach mit den `catch`-Blöcken
gematcht (vergleichbar mit `switch case`).

**Wichtig**: Dabei muss die Vererbungshierarchie beachtet werden. Die spezialisierteste
Klasse muss ganz oben stehen, die allgemeinste Klasse als letztes. Sonst wird eine
Exception u.U. in einem nicht dafür gedachten `catch`-Zweig aufgefangen.

**Wichtig**: Wenn eine Exception nicht durch die `catch`-Zweige aufgefangen wird, dann
wird sie an den Aufrufer weiter geleitet. Im Beispiel würde eine `IOException` nicht durch
die `catch`-Zweige gefangen (`IllegalArgumentException` und `NullPointerException` sind
im falschen Vererbungszweig, und `FileNotFoundException` ist spezieller als `IOException`)
und entsprechend an den Aufrufer weiter gereicht. Da es sich obendrein um eine checked
Exception handelt, müsste man diese per `throws IOException` an der Methode deklarieren.
:::


## _Finally_

```java
Scanner myScanner = new Scanner(System.in);
try {
    return 5 / myScanner.nextInt();
} catch (InputMismatchException ime) {
    ime.printStackTrace();
} finally {
    // wird immer aufgerufen
    myScanner.close();
}
```

::: notes
Der `finally` Block wird sowohl im Fehlerfall als auch im Normalfall aufgerufen. Dies
wird beispielsweise für Aufräumarbeiten genutzt, etwa zum Schließen von Verbindungen
oder Input-Streams.
:::


## _Try_-with-Resources

```java
try (Scanner myScanner = new Scanner(System.in)) {
    return 5 / myScanner.nextInt();
} catch (InputMismatchException ime) {
    ime.printStackTrace();
}
```
::: notes
Im `try`-Statement können Ressourcen deklariert werden, die am Ende sicher geschlossen
werden. Diese Ressourcen müssen `java.io.Closeable` implementieren.
:::


## Eigene Exceptions

```java
// Checked Exception
public class MyCheckedException extends Exception {
    public MyCheckedException(String errorMessage) {
        super(errorMessage);
    }
}

// Unchecked Exception
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String errorMessage) {
        super(errorMessage);
    }
}
```

::: notes
Eigene Exceptions können durch Spezialisierung anderer Exception-Klassen realisiert
werden. Dabei kann man direkt von `Exception` oder `RuntimeException` ableiten oder
bei Bedarf von spezialisierteren Exception-Klassen.

Wenn die eigene Exception in der Vererbungshierachie unter `RuntimeException` steht,
handelt es sich um eine _unchecked Exception_, sonst um eine _checked Exception_.

In der Benutzung (werfen, fangen, deklarieren) verhalten sich eigene Exception-Klassen
wie die Exceptions aus dem JDK.
:::


## Stilfragen

### Wie viel im try?
* Gute Stil ist es, so wenig Code wie möglich in einem `try` Block zu schreiben, sonst könnte es unklar sein, wo genau der Fehler herkommt.


### Wann throw wann catch?
```java
public static void methode1(String path, int x) throws IOException {
    methode2(path, x, x * 2);
}

private static void methode2(String path, int x, int y) throws IOException {
    methode3(path, x, y, x + y);
}

private static void methode3(String path, int x, int y, int z) throws IOException {
    try (FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
        bufferedWriter.write("X:" + x + " Y: " + y + " Z:" + z);
        bufferedWriter.flush();
    }
}

public static void main(String[] args) {
    try {
        methode1("wuppi/flupp", 2);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
::: notes
* Exceptions sollten immer beim Ursprung der Fehlerursache behandelt werden
:::

### Wann eine Exception checked machen, wann unchecked

Laut [Oracle](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html)
* Wenn erwartet werden kann, das ein Client sich von der Exception erholen kann, mache sie checked
* Wenn nicht erwartet werden kann, das ein Client sich von den Exception erholen kann, mache sie unchecked.

Laut Bloch
TODO


## Wrap-Up

* Behandeln von Fehlerfällen in Programmen
* Unterschied checked und unchecked Exceptions
* Unterschied Error und Exception
* `throw` : Wirf eine Exception
* `try` : Versuche Code auszuführen
* `catch` : Verhalten im Fehlerfall
* `finally` : Verhalten im Erfolgs- und Fehlerfall
* Mit `extends Exception` können eigene Exceptions implementiert werden







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
