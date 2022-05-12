---
type: lecture-cg
title: "Serialisierung von Objekten und Zuständen"
menuTitle: "Serialisierung"
author: "Carsten Gips (FH Bielefeld)"
weight: 7
readings:
  - key: "Java-SE-Tutorial"
    comment: "Essential Java Classes > Basic I/O > Object Streams"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
    name: "Quiz Serialisierung (ILIAS)"
assignments:
  - topic: sheet07
youtube:
  - link: ""
    name: "VL Serialisierung"
fhmedia:
  - link: ""
    name: "VL Serialisierung"
---


## Motivation
Lorem Ipsum. Starte mit H2-Level.
...

## Folie 2

*   Klassen müssen Marker-Interface `Serializable` implementieren

    ::: notes
    "Marker-Interface": Interface ohne Methoden. Ändert das Verhalten des
    Compilers, wenn eine Klasse dieses Interface implementiert: Weitere
    Funktionen werden "freigeschaltet", beispielsweise die Fähigkeit, Klone
    zu erstellen oder Objekte serialisierbar zu machen.
    :::

*   Schreiben von Objekten (samt Zustand) in Streams

    ```java
    ObjectOutputStream: void writeObject(Object);
    ```

*   Lesen und "Wiedererwecken" der Objekte aus Streams

    ```java
    ObjectInputStream: Object readObject()
    ```

::: notes
### Bedingungen für Objektserialisierung

*   Klassen implementieren Marker-Interface `Serializable`
*   Alle Attribute müssen ebenfalls serialisierbar sein (oder Deklaration "`transient`")
*   Alle primitiven Typen sind per Default serialisierbar
*   Es wird automatisch rekusiv serialisiert, aber jedes Objekt
    nur einmal (bei Mehrfachreferenzierung)
*   Serialisierbarkeit vererbt sich

### Ausnahmen

*   Statische Attribute werden nicht serialisiert
*   Als `transient` deklarierte Attribute werden nicht serialisiert

### Version-UID

`static final long serialVersionUID = 42L;`

*   Dient zum Vergleich der serialisierten Version und der aktuellen Klasse
*   Wenn das Attribut fehlt, wird eine Art Checksumme von der Runtime-Umgebung
    berechnet (basierend auf diversen Eigenschaften der Klasse)

Es existieren diverse Fallstricke und Probleme, siehe Bloch: "Effective Java",
Addison-Wesley, Kapitel 11 "Serialization"
:::

[Beispiel: [serial.SerializableStudi](https://github.com/PM-Dungeon/PM-Lecture/blob/master/java-jvm/src/serial/SerializableStudi.java)]{.bsp}



## Folie 3
...

## Folie 4

Serialisierung (equals, hashCode Wdhlg)


## Folie 5
...

## Folie 6

https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutputStream.html
https://docs.oracle.com/javase/8/docs/platform/serialization/spec/serialTOC.html
https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html
https://www.baeldung.com/java-serialization

https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html
https://docs.oracle.com/javase/8/docs/api/java/io/ObjectOutputStream.html
https://docs.oracle.com/javase/8/docs/api/java/io/ObjectInputStream.html

...

## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
