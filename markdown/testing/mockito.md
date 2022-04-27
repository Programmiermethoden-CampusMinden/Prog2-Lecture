---
type: lecture-cg title: "Mocking mit Mockito"
menuTitle: "Mocking"
author: "Carsten Gips (FH Bielefeld)"
weight: 4
readings:
  - key: "XXX"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
    name: "Quiz Mocking (ILIAS)"
assignments:
  - topic: sheet05
youtube:
  - link: ""
    name: "VL Mocking"
  - link: ""
    name: "Demo Mocking"
fhmedia:
  - link: ""
    name: "VL Mocking"
---

---

## Motivation

![MockitoGrafik]((images/mockito.png)) // evtl. Lizenzprobleme -> klären ob das
hier rein kann.

Mockito ist ein Mocking-Framework. Es simuliert das Verhalten eines realen
Objektes oder einer realen Methode.

Wofür brauchen wir denn jetzt so ein Mocking-Framework überhaupt?

Wir wollen die Funktionalität einer Klasse isoliert vom Rest testen können.
Dabei stören uns aber bisher so ein paar Dinge:

* Arbeiten mit den echten Objekten ist langsam. (zum Beispiel aufgrund von
  Datenbankenzugriffen)
* Objekte beinhalten oft komplexe Abhängigkeiten die in Tests schwer abzudecken
  sind.
* Manchmal existiert der zu testende Teil einer Applikation auch noch gar nicht,
  sondern es gibt nur die Interfaces.
* Oder es gibt unschöne Seiteneffekte beim Arbeiten mit den realen Objekten. Zum
  Beispiel könnte es sein das immer eine email versendet wird wenn wir mit einem
  Objekt interagieren.

In solchen Situationen wollen wir eine Möglichkeit haben das Verhalten eines
realen Objektes bzw. der Methoden zu simulieren möglichst ohne dabei die
originalen Methoden aufrufen zu müssen. (Manchmal möchte man das dennoch aber
dazu später mehr...)

Und genau hier kommt Mockito ins Spiel. Mockito hilft uns dabei uns von den
externen Abhängigkeiten zu lösen in dem es sogenannte Mocks, Stubs oder Spies
anbietet mit denen sich das Verhalten der realen Objekte simulieren/überwachen
und testen lässt.
Quelle: [Understanding mockito](https://medium.com/@ashrawan70/understanding-the-mockito-74cd7e5a77e4)

## Einführung

Mocking und das sogenannte stubbing sind die beiden Eckpfeiler zum Erstellen von
schnellen und einfachen JUnit tests.

Mocks sind in JUnittests immer dann nützlich, wenn man externe Abhängigkeiten
hat, auf die der eigene Code zugreift. Das können zum Beispiel externe APIs sein
oder Datenbanken etc. Mocks helfen einem beim Testen nun dabei sich von diesen
externen Abhängigkeiten zu lösen und seine Softwarefunktionalität dennoch
schnell und effizient testen zu können ohne evtl. auftretende Verbindungsfehler
oder andere mögliche Seiteneffekte der externen Abhängigkeiten auszulösen.

Dabei simulieren Mocks die funktionalität der externen APIs oder
Datenbankzugriffe. Auf diese Weise ist es möglich Softwaretests zu schreiben die
scheinbar die gleichen Methoden aufrufen die sie auch im regulären
softwarebetrieb nutzen würden, diese werden wie oben erwähnt allerdings für die
tests nur simuliert.

Mocks stellen so, im Vergleich zu den umfangreichen integrationstests, eine
schnelle und effiziente testbarkeit dar.

**_Anmerkung_**: Ein Test der Daten in eine Datenbank schreibt oder von dieser
Daten einliest oder ein Test der eine JSON-Datei von einem Webservice oder
ähnlichem bezieht ist _kein_ Unittest. Siehe: [Teststufen VL:
testing-intro](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/testing/testing-intro.md#was-wann-testen-wichtigste-teststufen)

Er wird erst dann zu einem Unittest, wenn man diese externen Zugriffe weg mockt.

Mockito ist dabei ein sehr beliebtes, häufig in der praxis anzutreffendes,
Mockingframework das einem bei der Erstellung von diesen Tests behilflich ist.

Quelle:

- [Stubbing-and-mocking-with-mockito](https://semaphoreci.com/community/tutorials/stubbing-and-mocking-with-mockito-2-and-junit)
- [Methods-of-mockito](https://www.javatpoint.com/methods-of-mockito)

## Aber was genau ist denn jetzt eigentlich Mocking?

Mocking ist ein Prozess zum Erzeugen von Objekten die ein Mock/Klon der realen
Objekte sind. Dabei bezeichnet Mocking eine Technik, die in Softwaretests
verwendet wird, in denen die gemockten Objekte anstatt der realen Objekte zu
testzwecken genutzt werden. Die gemockten Objekte liefern dabei bei einem vom
Programmierer bestimmten (dummy) input, einen dazu passenden gelieferten (dummy)
output der durch seine vorhersagbare funktionalität gut testbar ist.

Um das ganze Konzept des Mockens etwas besser verstehen zu können ist es
hilfreich vielleicht ein Paar weitere Begrifflichkeiten vorab zu klären auf die
wir in der Vorlesung stoßen werden.

Dabei ist es von Vorteil die drei grundbegriffe Mock, Stub oder Spy, auf die wir
in der Vorlesung noch häufiger treffen werden, voneinander abgrenzen und
unterscheiden zu können.

## Dabei bezeichnet ein:

- **Mock**: Eine Art Dummy oder Klon eines Objekts, das man mit Mockito anlegen
  kann und das dann in den Softwaretests anstelle, des realen Objekts in der
  Applikation genutzt wird. Diese Mocks werden von den Mocking-Frameworks
  erzeugt und, in den darauf aufbauenden Softwaretests, typischerweise für die
  sogenannte Verhaltensverifikation, auch "Behavior testing" genannt, genutzt.
- **Stub**: Sind Objekte die vordefinierte Werte enthalten, die in den
  Softwaretests abgefragt werden können. Des Weiteren enthalten Stubs nur ein
  absolutes minimum an Methoden, die für den jeweiligen Test benötigten werden.
  Zudem können sie auch Methoden enthalten, die einem den Zugriff auf den
  internen Zustand eines Stubs gewähren, wenn dies nötigt ist. Man könnte
  eigentlich auch sagen das Stubs in den Tests generell zum verifizieren eines
  Zustandes genutzt werden.
- **Spy**: Ein Spy ist in Mockito eine Art Wrapper der um ein Objekt gelegt
  wird. Dabei werden dann sämtliche Methodenaufrufe die eigentlich sonst von den
  realen Methoden eines Objekts ausgeführt worden wären an den Spion delegiert,
  der diese dann protokollieren, den State verändern und/oder eventuelle, von
  den Methoden getätigten Ausgaben kontrolliert verändern kann.

// TODO Evtl. noch fuzzy Dummy und Fake erklären.

// TODO hübsche Grafik

## Mockito Setup

Gradle: `build.gradle`

- ```java
  dependencies {
        testImplementation 'org.mockito:mockito-inline{mockitoversion}'
        testImplementation 'org.mockito:mockito-junit-jupiter:{mockitoversion}'
    }
   ```

Maven: `pom.xml`

- ```xml
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-inline</artifactId>
        <version>{mockitoversion}</version>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>{mockitoversion}</version>
        <scope>test</scope>
    </dependency>
    ```

## Folie 2

| Parameter         | Mock                                                                                                                                                    | Stub                                                                                         | Spy                                                                                                                               |
|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| Datenquelle       | Daten der Mocks werden in den Tests definiert                                                                                                           | Daten in Stubs sind hart codiert. Sie sind normalerweise eng mit der Testsuite verbunden.    | Spies sind partielle/halb gemockte Objekte. Spies werden ebenso wie Mocks in großen Testsuiten verwendet.                         |
| Erstellt von      | Werden normalerweise bei der Verwendung eines Mocking-Frameworks erstellt.                                                                              | Werden normalerweise von Hand kreiert                                                        | Werden normalerweise bei der Verwendung eines Mocking-Frameworks erstellt.                                                        |
| Verwendung        | Mocks werden meistens in großen Testsuiten verwendet. Mocks werden zum erstellen eines kompletten Mocks oder eines Dummy Objekts verwendet.             | Stubs werden meistens in kleinen/überschaubaren Testsuiten verwendet.                        | Spies werden verwendet um partielle oder halb gemockte Objekte zu erzeugen. Spies werden meistens in großen Testsuiten verwendet. |
| Default Verhalten | Wenn gemockte Objekte verwendet werden ist deren default Verhalten von Methoden (wenn diese nicht stubed sind) das sie gar nichts tun. (doNothing(...)) | Beinhalten meistens nur das absolute Minimum an Methoden die für einen Test benötigt werden. | Wenn Spies verwendet werden ist deren default Verhalten von Methoden (die nicht stubbed sind) das sie die reale Methode aufrufen. |
Quelle: [mock-vs-stub-vs-spy](https://www.javatpoint.com/mock-vs-stub-vs-spy)
## Folie 3

...

## Folie 4

...

## Folie 5

...

## Folie 6

...

## Wrap-Up

* Gründliches Testen ist ebenso viel Aufwand wie Coden (siehe vorherige
  Vorlesungen über JUnit tests).
* How to Setup.
* Unterschiede Mock > Stub > Spy.
* Einfaches Beispiel für einen Mock.
* Einfaches Beispiel für einen Stub.
* Einfaches Beispiel für einen Spy.
* Testen von Verhalten.
* Verifikation mit `when(...).then(...)` / `times(...)`
* Was macht der Mockito Arguemnt Captor.
* Dynamische manipulation von Argumenten.
* Dynamische Rückgabewerte basierend auf den verarbeiteten Argumenten.
* // TODO

...

## NOTIZEN

## Examples

@see https://www.javatpoint.com/examples-of-mockito-and-junit-in-eclipse-ide

## Fakes vs. Dummys vs. Mock vs. Stub vs. Spy

@see https://www.javatpoint.com/mockito
@see https://www.javatpoint.com/mock-vs-stub-vs-spy
Tabelle Mocks vs. Stubs vs. Spies von dort ^

Fake vs... @see https://www.martinfowler.com/articles/mocksArentStubs.html

## Was versteht man unter sogenannten Fakes?

- "Fakes" haben normalerweise eine gewisse Funktionalität, aber nutzen dabei
  "shortcuts" und sind dadurch für Softwaretests normalerweise eher
  ungeeignet. (Zum Beispiel: In-Memory-Datenbanken) ✅

## Was ist ein Dummy?

- Dummy-Objekte werden meistens nur hin und her geschoben, werden dabei zum
  Testen aber nicht wirklich genutzt. Sie werden eigentlich nur gebraucht um
  Parameterlisten auszuschmücken. ✅

## Stub -> when then syntax

## Answer<T> interface of Mockito

@see https://www.javadoc.io/doc/org.mockito/mockito-core/2.7.9/org/mockito/stubbing/Answer.html
@see https://www.baeldung.com/mockito-behavior

- doAnswer()
- when() then answer()

## Mockito Argument Matchers

@see https://www.javadoc.io/doc/org.mockito/mockito-core/2.7.17/org/mockito/Matchers.html

# verify for testing side effects

@see https://www.baeldung.com/mockito-verify

## Mocking private methods with another dependency "PowerMock"?

@see https://www.baeldung.com/powermock-private-method

## Mockito Spies

@see https://www.baeldung.com/mockito-spy

## Mockito’s Mock Methods

@see https://www.baeldung.com/mockito-mock-methods

## Behavior-driven development (BDD)

@see https://www.javatpoint.com/mockito-behavior-driven-development

## Mockito Annotations overview with examples

@see https://www.javatpoint.com/mockito-annotations

## Mockito JUnit Rules

@see https://www.javatpoint.com/mockito-junit-rules

## Weiterführendes

### PowerMock provides more functionality

- mocking of static methods
- final classes
- final methods
- private methods
- constructor
- removal of static initializers

@see https://www.javatpoint.com/mockito-powermock

# Codesnippets

@see https://blog.indrek.io/articles/getting-started-with-mockito/

## Frage/Code snippet zu when(...).thenReturn(...)?

- // TODO

## Frage/Code snippet zu when(...).thenThrow(...)?

- // TODO

## Frage/Code snippet zu doReturn(...).when(...)?

- // TODO

## Frage/Code snippet zu doThrow(...).when(...)?

- // TODO
-

## Frage/Code snippet zu doAnswer(...).when(...)?

- // TODO

## Wie können "Answer" Methoden von Mockito verwendet werden?

- // TODO

## Wie verwendet man Spies und Reflections um private Attribute zu ändern?

- // TODO

## Mockito example

@see https://entwickler.de/software-architektur/cocktail-gefallig

## providing a Different Default Answer

@see https://www.baeldung.com/mockito-mocksettings#providing-a-different-default-answer

## AdditionalAnswers

@see https://www.baeldung.com/mockito-additionalanswers#overview

## Return Custom Value using Mockito

@see http://www.javabyexamples.com/mockito-recipe-custom-return-with-answer

### Calling the Real Method using Answer

@see http://www.javabyexamples.com/mockito-recipe-custom-return-with-answer#call-real

## Spying or Mocking Abstract Classes

@see https://www.javatpoint.com/mockito-spying-or-mocking-abstract-classes

## How to mock a void method using Mockito?

@see https://www.baeldung.com/mockito-void-methods

## Wie werden externe Abhängigkeiten gemockt?

- siehe coding Beispiel.

## Mockitos internal Whitebox is depreacted but Powermock has one with extended capabilities.

<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides

## LICENSE

![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)


```
https://github.com/PM-Dungeon/PM-Lecture/pull/426
https://www.baeldung.com/tag/mockito/
https://www.baeldung.com/intro-to-powermock
https://www.baeldung.com/powermock-private-method

> > kriegen wir die praktikumsaufgabe auch direkt mit moskito hin,
>
> ja, bekommen wir auch hin...

dann lass uns das noch anpassen. ich habe ja nur 20 minuten (max 30 minuten), und da schafft man eigentlich grad mal so die wichtigsten dinge von mockito plus einen hinweis auf powermock. aber da noch auf powermock einzugehen, so dass die studis das im praktikum nutzen können, halte ich für nicht zielführend.

>
> https://www.baeldung.com/intro-to-powermock#:~:text=PowerMockito%20is%20a%20PowerMock's%20extension,final%2C%20static%20or%20private%20methods.
>
> > It provides capabilities to work with the Java Reflection API in a simple way to overcome the problems of Mockito, such as the lack of ability to mock final, static or private methods.
>
> Konstruktoren, final Methoden, static Methoden, partielles Mocking und Whitebox/Variablen.

das sollte ich zumindest als "ausblick" aufnehmen. danke!
```

:::
