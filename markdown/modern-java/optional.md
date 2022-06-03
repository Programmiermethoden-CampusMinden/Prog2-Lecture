---
type: lecture-cg
title: "Optional"
menuTitle: "Optional"
author: "Carsten Gips (FH Bielefeld)"
weight: 6
readings:
  - key: "LernJava"
    comment: "Tutorials > The Stream API > Using Optionals "
  - key: "Ullenboom2021"
    comment: ""
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: ""
  - k3: ""
quizzes:
  - link: ""
    name: "Quiz Optional (ILIAS)"
assignments:
  - topic: sheet09
youtube:
  - link: ""
    name: "VL Optional"
  - link: ""
    name: "Demo Optional"
fhmedia:
  - link: ""
    name: "VL Optional"
---


## Motivation

Problem: `null` wird an (zu) vielen Stellen genutzt: "absence of a value", aber die
Gründe sind nicht bekannt:

*   Es gibt keinen Wert ("not found")
*   Felder wurden (noch) nicht initialisiert
*   Es ist ein Problem oder etwas Unerwartetes aufgetreten
*   Parameter und Rückgabewerte müssen auf `null` geprüft werden

Lösung:

*   `Optional` für Rückgabewerte, die "not found" oder "not existing" bedeuten ("Kein Wert vorhanden")
*   `@NotNull`/`@Nullable` für Parameter
*   Exceptions für Fälle, wo ein Problem aufgetreten ist
*   `null` auf Attribut-Ebene (Klassen-interne Verwendung)


Supporting Methods That Cannot Produce a Result

Being able to use the Optional class, for the cases where you cannot produce a value, offers many opportunities
for better patterns, especially for better handling of errors. This is the main reason why you should be using
option objects: **they signal that a method may not produce a result in certain circumstances**.
**Storing an instance of Optional instance in a field, in a list, in a map, or passing it as a method argument is not what options have been created.**

Wrapper-Klasse: Verpacke eine Referenz `Optional<T>` oder Wert `OptionalInt` => kann leer sein!



Keep it simple and use Optional for absent values.

*   Abwesenheit von Werten
*   KEIN Ersatz für `null`-Checks!
*   Vernünftige Error-Handling: "Something wrong happened and here’s a null." (Anti-Pattern!)


`null` für absent values, `Optional` löst das Problem mit den absent values: Don’t return null, use Optional

```java
if(absentVariable == null) { /* absent value handler */}


if(isValueAbsent) {return null;} // => Nullpointerexception beim Aufrufer!
...
if(isValueAbsent) {return Optional.empty();}


return Optional.ofNullable(variableInQuestion);  // wenn variableInQuestion==null => Optional.empty()
```


## Erzeugen von _Optional_-Objekten

Konstruktor ist `private`...

*   "Kein Wert": `Optional.empty()`
*   Verpacken eines non-`null` Elements: `Optional.of()` (`NullPointerException` wenn Argument `null`!)

\bigskip

*   Verpacken eines "unsicheren"/beliebigen Elements: `Optional.ofNullable()`
    *   Liefert verpacktes Element, oder
    *   `Optional.empty()`, falls Element `null` war

::: notes
Es sollte in der Praxis eigentlich nur wenige Fälle geben, wo ein Aufruf von
`Optional.of()` sinnvoll ist. Ebenso ist `Optional.empty()` nur selten sinnvoll.

Stattdessen sollte `Optional.ofNullable()` verwendet werden.
:::

\vfill

**`null` kann nicht nicht in `Optional<T>` verpackt werden!**
[(Das wäre dann eben `Optional.empty()`.)]{.notes}


## Zugriff auf _Optional_-Objekte

::: notes
In der funktionalen Programmierung gibt es schon lange das Konzept von `Optional`,
in Haskell ist dies beispielsweise die Monade `Maybe`. Allerdings ist die Einbettung
in die Sprache von vornherein mit berücksichtigt worden, insbesondere kann man hier
sehr gut mit _Pattern Matching_ die Funktionsdefinition auf den verpackten Inhalt
anpassen: Eine Funktion, die auf ein `Nothing` (in Java ein `Optional.empty()`)
reagiert, und eine gleichnamige Funktion, die aus `Just x` das `x` direkt im Funktionskopf
auspackt und mit `x` dann in der Funktion weiter arbeitet (in Java wäre das ein `get()`).


:::


## Folie 2

```java
Vorher:

private int readExpirationAsInt(Milk milk)
{
  String expiration = milk.getExpiration();
  try {
    return Integer.parseInt(expiration);
  }
  catch(NumberFormatException ignored) {}

  return 0;
}


Nachher:

private OptionalInt readExpirationAsInt(Milk milk)
{
  String expiration = milk.getExpiration();

  try {
    return Optional.of(Integer.parseInt(expiration));
  }
  catch(NumberFormatException e) {
    return OptionalInt.empty();
  }
}
```


## Folie 3

```java
if (foo != null) {
    // Do something
}

Optional.ofNullable(foo).ifPresent(value -> {
//do something
})
```


```java
Before:

User user = userRepo.findUserById("someId");

if (user == null) {
    // return some value
    // or
    // throw a business exception/controller 4xx error/etc.

// do something with user


After:

// note the exception is now thrown when unwrapping

User user = userRepo.findUserById("someId")
                    .orElseThrow(// business exception/controller error/etc.);

// do something with user
```

```java
Before:

User user = userRepo.findUserById("someId");

List<String> favouriteFood = null;
if (user == null) {
    // return some value
    // or
    // throw a business exception/controller 4xx error/etc.

favouriteFood = user.getFavouriteFood();

// do something with favouriteFood


After:

List<String> favouriteFood = userRepo.findUserById("someId")
                                     .map(User::getFavouriteFood)
                                     .orElseThrow(// business exception/controller error/etc.);

// do something with favouriteFood


Not:

userRepo.findUserById("someId")
        .map(User::getFavouriteFood)
        .map(this::doBusinessLogic)
        .orElseThrow(// business exception/controller error/etc.);
```

## Folie 4

```java
var user = userService.getCurrentUser();
if(user == null) {
    return "(unknown)";
}
var username = user.getUsername();
if (username == null) {
    return "(unknown)";
}
return username;

vs

var user = userService.getCurrentUser();
if(user.isEmpty()) {
    return "(unknown)";
}
var username = user.orElseThrow().getUsername();
if (username == null) {
    return "(unknown)";
}
return username;

vs

return userService.getCurrentUser()
                  .map(User::getUsername)
                  .orElse("(unknown)");
```

## Folie 5
...

## Folie 6

*   ["Using Optionals"](https://dev.java/learn/using-optionals/)
*   ["What You Might Not Know About Optional"](https://medium.com/javarevisited/what-you-might-not-know-about-optional-7238e3c05f63)
*   ["Experienced Developers Use These 7 Java Optional Tips to Remove Code Clutter"](https://medium.com/javarevisited/experienced-developers-use-these-7-java-optional-tips-to-remove-code-clutter-6e8b1a639861)
*   ["Code Smells: Null"](https://blog.jetbrains.com/idea/2017/08/code-smells-null/)
*   [`Class Optional<T>`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html)


## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
