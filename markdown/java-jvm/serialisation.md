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

## Bedingungen für Objekt-Serialisierung

*   Klassen implementieren Marker-Interface `Serializable`
*   Alle Attribute müssen ebenfalls serialisierbar sein (oder Deklaration "`transient`")
*   Alle primitiven Typen sind per Default serialisierbar
*   Es wird automatisch rekusiv serialisiert, aber jedes Objekt
    nur einmal (bei Mehrfachreferenzierung)
*   Serialisierbarkeit vererbt sich

## Ausnahmen

*   Statische Attribute werden nicht serialisiert
*   Als `transient` deklarierte Attribute werden nicht serialisiert
*   Nicht serialisierbare Attribute führen zu `NotSerializableException`


## Version-UID

`static final long serialVersionUID = 42L;`

*   Dient zum Vergleich der serialisierten Version und der aktuellen Klasse
*   Wenn das Attribut fehlt, wird eine Art Checksumme von der Runtime-Umgebung
    berechnet (basierend auf diversen Eigenschaften der Klasse)

::: notes
Es existieren diverse Fallstricke und Probleme, siehe [@Bloch2018] Kapitel 11 "Serialization".

Weitere Links:

-   Tutorials:
    -   https://docs.oracle.com/en/java/javase/17/docs/specs/serialization/input.html
    -   https://www.baeldung.com/java-serialization
-   API:
    -   https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutputStream.html
    -   https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInputStream.html
    -   https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html
:::

[Beispiel: [serial.SerializableStudi](https://github.com/PM-Dungeon/PM-Lecture/blob/master/java-jvm/src/serial/SerializableStudi.java)]{.bsp}


## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
