---
type: lecture-cg
title: "Exceptions"
menuTitle: "Exceptions"
author: "André Matutat (FH Bielefeld)"
weight: 8
readings:
  - key: "Bloch2018"
  - key: "Java-11-documentation"
  - key: "Java-11-tutorial"
  - key: "Java-SE-tutorial"
  - key: "Ullenboom2016"
  - key: "Urma2014"
  - key: "Juneau2017"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: "Unterschied zwischen Error und Exception"
  - k2: "Unterschied zwischen checked und unchecked Exceptions"
  - k3: "Umgang mit Exceptions"
  - k3: "Eigene Exceptions schreiben"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
youtube:
  - link: ""
    name: "VL "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL "
sketch: true
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

## Unchecked vs Checked Exceptions

Checked:
  * Sind (logische) Fehler im Code
    * Fehlerhafte Benutzereingabe
    * Unerreichbare API
  * Treten zur Compilezeit auf
  * Müssen deklariert/behandelt werden, um wieder in einen sicheren Zustand zu gelangen

Unchecked:
  * Sind Programmier Fehler
    * `NullPointerException`
  * Treten zur Laufzeit auf
  * Müssen nicht deklariert oder behandelt werden

## Exception vs Error

Error:
  * Sind unchecked
  * Liegen an Systemfehlern (z.B `StackOverflowError`, `OutOfMemoryError` etc.)
  * Sollten nicht behandelt werden

Exceptions:
 * Können checked oder unchecked sein
 * Von Exceptions kann man sich erholen


## Vererbungsstruktur Throwable

![Ausschnitt aus der Vererbungsstruktur von Throwable.](images/exception.png){width="80%"}

## Throw

```java
double div(int a, int b) throws ArithmeticException{
    return a/b;
}
```

Alternative

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
*   Exceptions sollten immer dort behandelt werden, wo sie verursacht werden.
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
  e.printstacktrace();
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
  e1.printstacktrace();
}
catch(FileNotFoundException e2) {
  e2.printstacktrace();
}
catch(NullPointerException e3) {
  e3.printstacktrace();
}
```
::: notes
* Die Exception wird der Reihe nach mit den `catch` Blöcken gematcht.
* Daher muss die Vererbungshierarchie beachtet werden.
:::

## finally

```java
Scanner myScanner = new Scanner(System.in);
try {
    double s= 5/myScanner.nextInt();
}
catch(ArithmeticException e) {
  // ups
  e.printstacktrace();
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

## Eigene Exceptions

```java
public class MyException extends Exception {
    public MyException(String errorMessage){
        super(errorMessage);
    }
}
```
```java
void myMethod(int x) throws MyException{
    if(x>5 || x<10) throw new MyException("Ich finde x doof.");
    //...
}
```
::: notes
* Eigene Exceptions erben von `Exception` (direkt oder indirekt)
* Können wie integrierte Exceptions verwendet werden
:::

## Wrap-Up

- Was sind exceptions
- man kann exceptions thrown
- man kann exceptions mit try catch "behandeln"
- finally wird immer aufgerufen

<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
