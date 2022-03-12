---
type: lecture-cg
title: "Reflection"
menuTitle: "Reflection"
author: "Carsten Gips (FH Bielefeld)"
weight: 5
readings:
  - key: "Java-SE-Tutorial"
    comment: "Specialized Trails and Lessons > The Reflection API"
  - key: "Inden2013"
    comment: "Reflection: Kapitel 8"
tldr: |
  TODO

  *   Inspektion von Programmen zur Laufzeit: **Reflection**
    *   `java.lang.Class`: Metadaten über Klassen
    *   Je Klasse ein `Class`-Objekt
    *   Informationen über Konstruktoren, Methoden, Felder
    *   Anwendung: Laden und Ausführen von zur Compile-Zeit unbekanntem Code
    *   Vorsicht: Verlust von Refactoring und Compiler-Zusicherungen!

outcomes:
  - k2: "Probleme beim Einsatz von Reflection"
  - k2: "Bedeutung der verschiedenen Exceptions beim Aufruf von Methoden per Reflection"
  - k3: "Inspection von Klassen zur Laufzeit mit Reflection"
  - k3: "Einbindung von zur Compilezeit unbekannten Klassen, Aufruf von Konstruktoren und Methoden (mit und ohne Parameter/Rückgabewerte)"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet01
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


## Ausgaben und Einblicke zur Laufzeit

```java
public class FactoryBeispielTest {
    @Test
    public void testGetTicket() {
        fail("not implemented");
    }
}
```

\bigskip

```java
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Wuppie {
}
```

::: notes
Wenn Sie nicht (mehr) wissen, wie man eigene Annotationen definiert,
schauen Sie doch bitte einfach kurz im Handout zu Annotationen nach :-)
:::


## Wer bin ich? ... Informationen über ein Programm

> Reflection is commonly used by programs which require the ability to examine
> or modify the runtime behaviour of applications running in the Java virtual
> machine.
>
> \hfill -- [docs.oracle.com/javase/tutorial/reflect/](https://docs.oracle.com/javase/tutorial/reflect/)

\bigskip
\bigskip

> For every type of object, the Java virtual machine instantiates an immutable
> instance of `java.lang.Class` which provides methods to examine the runtime
> properties of the object including its members and type information. `Class`
> also provides the ability to create new classes and objects. Most importantly,
> it is the entry point for all of the Reflection APIs.
>
> \hfill -- [docs.oracle.com/javase/tutorial/reflect/class/](https://docs.oracle.com/javase/tutorial/reflect/class/)

\bigskip

[`java.lang.Class`: Metadaten über Klassen]{.cbox}

::: notes
Dies umfasst u.a.:

*   Klassenname
*   Implementierte Interfaces
*   Methoden
*   Attribute
*   Annotationen
*   ...
:::


## Vorgehen

1.  Gewünschte Klasse über ein `Class`-Objekt laden

\smallskip

2.  Informationen abrufen (etwa welche Methoden vorhanden sind, welche Annotationen annotiert wurden, ...)

\smallskip

3.  Eine Instanz dieser Klasse erzeugen, und
4.  Methoden aufrufen

::: notes
Das Vorgehen umfasst vier Schritte: Zunächst die gewünschte Klasse über ein `Class`-Objekt laden
und anschließend Informationen abrufen (etwa welche Methoden vorhanden sind, welche Annotationen
annotiert wurden, ...) und bei Bedarf eine Instanz dieser Klasse erzeugen sowie Methoden aufrufen.

Ein zweiter wichtiger Anwendungsfall (neben dem Abfragen von Informationen und Aufrufen von Methoden)
ist das Laden von Klassen, die zur Compile-Zeit nicht mit dem eigentlichen Programm verbunden sind.
Auf diesem Weg kann beispielsweise ein Bildbearbeitungsprogramm zur Laufzeit dynamisch Filter aus einem
externen Ordner laden und nutzen, oder der Lexer kann die Tokendefinitionen zur Laufzeit einlesen (d.h.
er könnte mit unterschiedlichen Tokensätzen arbeiten, die zur Compile-Zeit noch gar nicht definiert sind).
Damit werden die Programme dynamischer.
:::


## Schritt 1: _Class_-Objekt erzeugen und Klasse laden

```java
// Variante 1 (package.MyClass dynamisch zur Laufzeit laden)
Class<?> c = Class.forName("package.MyClass");


// Variante 2 (Objekt)
MyClass obj = new MyClass();
Class<?> c = obj.getClass();

// Variante 3 (Klasse)
Class<?> c = MyClass.class;
```

::: notes
=> Einstiegspunkt der Reflection API

Eigentlich wird nur in **Variante 1 die über den String angegebene Klasse
dynamisch von der Laufzeitumgebung (nach-) geladen** (muss also im gestarteten
Programm nicht vorhanden sein). Die angegebene Klasse muss aber in Form von
Byte-Code an der angegebenen Stelle (Ordner `package`, Dateiname `MyClass.class`)
vorhanden sein.

Die anderen beiden Varianten setzen voraus, dass die jeweilige Klasse **bereits
geladen** ist (also ganz normal mit den restlichen Sourcen zu Byte-Code
(`.class`-Dateien) kompiliert wurde und mit dem Programm geladen wurde).

Alle drei Varianten ermöglichen die Introspektion der jeweiligen Klassen zur
Laufzeit.
:::


## Schritt 2: In die Klasse reinschauen

```java
// Studi-Klasse dynamisch (nach-) laden
Class<?> c = Class.forName("reflection.Studi");


// Parametersatz für Methode zusammenbasteln
Class<?>[] paramT = new Class<?>[] { String.class };

// public Methode aus dem **Class**-Objekt holen
Method pubMethod = c.getMethod("setName", paramT);
// beliebige Methode aus dem **Class**-Objekt holen
Method privMethod = c.getDeclaredMethod("setName", paramT);


Method[] publicMethods = c.getMethods();  // all public methods (incl. inherited)
Method[] allMethods = c.getDeclaredMethods();  // all methods (excl. inherited)
```

::: notes
*   Public Methode laden (auch von Superklasse/Interface geerbt): `Class<?>.getMethod(String, Class<?>[])`
*   Beliebige (auch private) Methoden (in der Klasse selbst deklariert): `Class<?>.getDeclaredMethod(...)`


[Beispiel: reflection.ReflectionDemoInfo]{.bsp}


*Anmerkung*: Mit `Class<?>.getDeclaredMethods()` erhalten Sie alle Methoden,
die direkt in der Klasse deklariert werden (ohne geerbte Methoden!), unabhängig
von deren Sichtbarkeit. Mit `Class<?>.getMethods()` erhalten Sie dagegen alle
`public` Methoden, die in der Klasse selbst oder ihren Superklassen bzw. den
implementierten Interfaces deklariert sind.

Vgl. Javadoc [`getMethods`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Class.html#getMethods())
und [`getDeclaredMethods`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Class.html#getDeclaredMethods()).

Die Methoden-Arrays können Sie nach bestimmten Eigenschaften durchsuchen, bzw. auf
das Vorhandensein einer bestimmten Annotation prüfen (etwa mit `isAnnotationPresent()`)
etc.

Analog können Sie weitere Eigenschaften einer Klasse abfragen, beispielsweise Attribute
(`Class<?>.getDeclaredFields()`) oder Konstruktoren (`Class<?>.getDeclaredConstructors()`).
:::

[Beispiel: reflection.ReflectionDemoAnnotation]{.bsp}


## Schritt 3: Instanz der geladenen Klasse erzeugen

```java
// Class-Objekt erzeugen
Class<?> c = Class.forName("reflection.Studi");


// Variante 1
Studi s = (Studi) c.newInstance();

// Variante 2
Constructor<?> ctor = c.getConstructor();
Studi s = (Studi) ctor.newInstance();

// Variante 3
Class<?>[] paramT = new Class<?>[] {String.class, int.class};
Constructor<?> ctor = c.getDeclaredConstructor(paramT);
Studi s = (Studi) ctor.newInstance("Beate", 42);
```

::: notes
[Beispiel: reflection.ReflectionDemoCreate]{.bsp}

*   Parameterlose, öffentliche Konstruktoren:
    *   `Class<?>.newInstance()` (seit Java9 *deprecated*)
    *   `Class<?>.getConstructor()` => `Constructor<?>.newInstance()`

*   Sonst: Passenden Konstruktor explizit holen
    `Class<?>.getDeclaredConstructor(Class<?>[])`,
    Parametersatz zusammenbasteln (hier nicht dargestellt)
    und aufrufen `Constructor<?>.newInstance(...)`


**Unterschied `new` und `Constructor.newInstance()`**:

> Tip: An important difference between `new` and `Constructor.newInstance()` is
> that `new` performs method argument type checking, boxing, and method
> resolution. None of these occur in reflection, where explicit choices must
> be made.
>
> \hfill -- [docs.oracle.com/javase/tutorial/reflect/member/ctorTrouble.html](https://docs.oracle.com/javase/tutorial/reflect/member/ctorTrouble.html)
:::


## Schritt 4: Methoden aufrufen ...

```java
// Studi-Klasse dynamisch (nach-) laden
Class<?> c = Class.forName("reflection.Studi");
// Studi-Objekt anlegen (Defaultkonstruktor)
Studi s = (Studi) c.newInstance();
// Parametersatz für Methode zusammenbasteln
Class<?>[] paramT = new Class<?>[] { String.class };
// Methode aus dem **Class**-Objekt holen
Method method = c.getMethod("setName", paramT);


// Methode auf dem **Studi**-Objekt aufrufen
method.invoke(s, "Holgi");
```

[[Beispiel: reflection.ReflectionDemoCall]{.bsp}]{.notes}


## Hinweis: Klassen außerhalb des Classpath laden

```java
File folder = new File("irgendwo");
URL[] ua = new URL[]{folder.toURI().toURL()};

URLClassLoader ucl = URLClassLoader.newInstance(ua);
Class<?> c1 = Class.forName("org.wuppie.Fluppie", true, ucl);
Class<?> c2 = ucl.loadClass("org.wuppie.Fluppie");
```

[Bemerkung zu Ordnerstruktur und Classpath; Beispiel: reflection.ReflectionDemoCP]{.bsp}

::: notes
Mit `Class.forName("reflection.Studi")` können Sie die Klasse `Studi` im
Package `reflection` laden. Dabei muss sich aber die entsprechende
`.class`-Datei (samt der der Package-Struktur entsprechendenen Ordnerstruktur
darüber) **im Java-Classpath** befinden!

Mit einem weiteren `ClassLoader` können Sie auch aus Ordnern, die sich
nicht im Classpath befinden, `.class`-Dateien laden. Dies geht dann entweder
wie vorher über `Class.forName()`, wobei hier der neue Classloader als
Parameter mitgegeben wird, oder direkt über den neuen Classloader mit
dessen Methode `loadClass()`.
:::


## Licht und Schatten

**Nützlich**:

*   Erweiterbarkeit: Laden von "externen" [(zur Kompilierzeit unbekannter)]{.notes}
    Klassen in eine Anwendung
*   Klassen-Browser, Debugger und Test-Tools

\bigskip

[**Nachteile**]{.alert}:

*   Verlust von Kapselung, Compilerunterstützung und Refactoring
*   Performance: Dynamisches Laden von Klassen etc.
*   Sicherheitsprobleme/-restriktionen

\bigskip

[**Gibt es eine Lösung ohne Reflection, wähle diese!**]{.cbox}


## Wrap-Up

*   Inspektion von Programmen zur Laufzeit: **Reflection**
    *   `java.lang.Class`: Metadaten über Klassen
    *   Je Klasse ein `Class`-Objekt
    *   Informationen über Konstruktoren, Methoden, Felder
    *   Anwendung: Laden und Ausführen von zur Compile-Zeit unbekanntem Code
    *   Vorsicht: Verlust von Refactoring und Compiler-Zusicherungen!







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
