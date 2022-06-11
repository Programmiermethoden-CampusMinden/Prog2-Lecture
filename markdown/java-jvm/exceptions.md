---
type: lecture-cg
title: "Exception-Handling"
menuTitle: "Exceptions"
author: "André Matutat (FH Bielefeld)"
weight: 8
readings:
  - key: "LernJava"
    comment: "Tutorials > Exceptions"
  - key: "Ullenboom2021"
    comment: "Kap. 8: Ausnahmen müssen sein"
  - key: "Java-SE-Tutorial"
    comment: "Trail: Essential Java Classes, Lesson: Exceptions"
tldr: |
    Man unterscheidet zwischen **Exception** und *Error**. Ein Error ist ein Fehler im System, von dem man sich nicht wieder erholen kann. Eine Exception ist ein Fehlerfall innerhalb des Programmes.

    Mit Hilfe von Exceptions lassen sich Fehlerfälle im Programmablauf deklarieren und behandeln. Methoden können mit dem Keyword `throw` gefolgt vom Namen der Exception angeben, dass sie im Fehlerfall diese spezifische Exception werfen. Der Aufrufer kann dann mithilfe der Keywords `try`, `catch` und `finally` den Fehler abfangen und behandeln.
    Dabei wird im `try`-Block der Code geschrieben, der einen potenziellen Fehler wirf, im `catch`-Block wird das Verhalten implementiert, dass im Fehlerfall ausgeführt werden soll und im `finally`-Block kann Optional Code geschrieben werden, der sowohl im Erfolgs- als auch Fehlerfall ausgeführt wird.

    Es wird zwischen **checked** Exceptions und **unchecked** Exceptions unterschieden. Checked Exceptions sind für erwartbare Fehlerfälle gedacht, die nicht vom Programm ausgeschlossen werden können, wie das Fehlen einer Datei, die eingelesen werden soll. Checked Exceptions müssen deklariert und behandelt werden. Dies wird vom Compiler überprüft.

    Unchecked Exceptions werden für Fehler in der Programmlogik verwendet, wie das Teilen durch 0. Sie deuten auf fehlerhafte Programmierung oder mangelhafter Eingabeprüfung hin. Checked Exceptions müssen nicht deklariert oder behandelt werden.
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
double div(int a, int b){
    return a/b;
}

div(3.5,0);
```
::: notes
**Probleme**:
*   Programm wird abstürzen, da durch '0' geteilt wird
:::

## Lösung?

```java
Double div(int a, int b){
    if(b==0) return null;
    return a/b;
}

Double sol = div(3.5,0);
if(sol==null){
    //do something
}
else {
    //do something else
}
```
::: notes
**Probleme**:

*   Da `double` nicht `null` sein kann, muss ein `Double` Objekt erzeugt und zurückgegeben werden
*   Der Aufrufer muss auf `null` prüfen
*   Es wird nicht kommuniziert warum `null` zurückgegeben wird. Was ist das Problem?
*   Was ist, wenn `null` ein gültiger Rückgabewert sein soll?
:::

## Vererbungsstruktur Throwable

![Ausschnitt aus der Vererbungsstruktur von Throwable.](images/exception.png){width="80%"}

## Unchecked vs Checked Exceptions

Checked:
  * Für erwartbare Fehler fälle, die nicht am Programm selbst liegen
    * `FileNotFoundException`
    * `IOException`
  * Alle nicht von `RuntimeException` ableitende Exceptions
  * Werden vom Compiler überprüft
  * Müssen deklariert und behandelt werden

Unchecked:
  * Logische Programmierfehler ("Versagen" des Programmcodes)
    * `IndexOutOfBoundException`
    * `NullPointerException`
    * `ArithmeticException`
    * `IllegalArgumentException`
  * Alle ableitende Exceptions von `RuntimeException`
  * Werden nicht vom Compiler überprüft
  * Müssen nicht deklariert oder behandelt werden

::: notes
Beispiel Checked Exception: Es soll eine Abfrage an eine externe API geschickt werden. Diese ist aber aktuell nicht zu erreichen. Lösung: Anfrage noch einmal schicken.
Beispiel unchecked Exception: Ein `for`-Loop über ein Array ist falsch programmiert und will auf einen Index im Array zugreifen, der nicht existiert.
:::

## Exception vs Error

Exceptions:
 * Können checked oder unchecked sein
 * Von Exceptions kann man sich erholen

Error:
  * Liegen an Systemfehlern
    * `StackOverflowError`
    * `OutOfMemoryError`
  * Von einem Error kann man sich  nicht erholen
  * Sollten nicht behandelt werden

## Throw

```java
double div(int a, int b) throws ArithmeticException{
    return a/b;
}
```

Alternative:

```java
double div(int a, int b) throws IllegalArgumentException{
    if(b==0) throw new IllegalArgumentException("Can't divide by zero");
    return a/b;
}
```
::: notes
*   Exception können an die aufrufende Stelle weitergeleiten werden
*   Dafür wird das Keyword `throws` gefolgt vom Namen der Exception in die Methodensignatur hinzugefügt
*   Es können auch mehrere Exceptions geworfen werden `throws Exception1, Exception2, Exception3`
*   Wenn innerhalb der Methode die genannte Exception aufkommt (oder mit `throw` geworfen wird), wird diese an die aufrufende Stelle weitergeleitet
*   Wenn eine Methode `throws` **muss** die aufrufende Stelle diese Exception behandeln.
:::

## Try-Catch

```java
int a = getUserInput();
int b = getUserInput();
try {
  div(a,b);
}
catch(IllegalArgumentException e) {
  //  Codeblock der im Fehlerfall aufgerufen wird
  e.printStackTrace();
}
// hier geht es normal weiter
```
::: notes
* Im `try` Block wird der Code ausgeführt, der einen Fehler werfen könnte
* Gute Stil ist es, so wenig Code wie möglich in einem `try` Block zu schreiben, sonst könnte es unklar sein, wo genau der Fehler herkommt.
* Mit `catch` kann eine Exception gefangen und im `catch` Block behandelt werden.
:::

## Try with multiple Catch

```java
try {
    someMethod(a,b,c);
}
catch(IllegalArgumentException e1) {
  e1.printStackTrace();
}
catch(FileNotFoundException | NullPointerException e2) {
  e2.printStackTrace();
}
```
::: notes
* Die Exception wird der Reihe nach mit den `catch` Blöcken gematcht (vergleichbar mit `switch case` ).
* Daher muss die Vererbungshierarchie beachtet werden.
:::

## finally

```java
Scanner myScanner = new Scanner(System.in);
try {
    double s= 5/myScanner.nextInt();
}
catch(IllegalArgumentException e) {
  e.printStackTrace();
}
finally {
    //wird immer aufgerufen
    myScanner.close();
}
```

::: notes
* Der `finally` Block wird sowohl im Fehlerfall als auch im Normalfall aufgerufen
* Wird für Aufräumarbeiten genutzt, wie zum Beispiel das Schließen von Verbindungen oder Inputstreams.
:::

## Try-with-Resources

```java
String getFirstLine(String pathToFile) throws IOException {
	    try (FileReader fileReader = new FileReader(pathToFile);
	         BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	        return bufferedReader.readLine();
	    }
	}
```
::: notes
* In einem `try`-Statement können Ressourcen deklariert werden, die am Ende sicher geschlossen werden
* Eine Ressource ist ein Objekt, dass am Ende geschlossen werden muss
* Ressourcen Objekte müssen `java.io.Closeable` implementieren
:::

## Wann throw wann catch?
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
## Eigene Checked-Exceptions

```java
public class MyCheckedException extends Exception {
    public MyException(String errorMessage){
        super(errorMessage);
    }
}
```
```java
void myMethod(int x) throws MyCheckedException{
    if(x>5 || x<10) throw new MyCheckedException("Ich finde x doof.");
    //...
}
```
```java
try {
    myMethod(12);
} catch (MyCheckedException e) {
    throw new RuntimeException(e);
}
```
::: notes
* Eigene Checked-Exceptions erben von `Exception` (direkt oder indirekt)
* Können wie integrierte Exceptions verwendet werden
:::

## Eigene Unchecked-Exceptions

```java
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String errorMessage){
        super(errorMessage);
    }
}
```
```java
void myMethod(int x) throws MyUncheckedException{
    if(x>5 || x<10) throw new MyCheckedException("Ich finde x doof.");
    //...
}
```
```java
myMethod(12);
```
::: notes
* Eigene Unchecked-Exceptions erben von `RuntimeException` (direkt oder indirekt)
* Können wie integrierte Exceptions verwendet werden
:::

## Wann eine Exception checked machen, wann unchecked

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

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
