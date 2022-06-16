---
type: lecture-cg
title: "Collections"
menuTitle: "Collections"
author: "Carsten Gips (FH Bielefeld)"
weight: 6
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
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
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


## Motivation
Lorem Ipsum. Starte mit H2-Level.
...

## Collection

![](images/collection.png){web_width="80%"}
::: notes
* `Collection`ist ein Interface des JDK.
* Klassen die `Collection` implementieren speichern eine Menge an Objekten.
* Bieten Methoden zum Verwalten dieser Mengen.
* Unteranderen gibt es die aus ADS bekannten Datentypen wie Listen, Sets, Queues etc.
* `List`Collections sind eine geordnete Liste an Objekten. Objekte können an jede Stell der Liste eingefügt, gelöscht oder geändert werden. Mithilfe des Index greift man auf ein spezifisches Objekt innerhalb der Liste zu.
* `Queue` Collections sind eine geordnete Liste an Objekten. Objekte können nur an das Ende der Liste hinzugefügt werden und nur das Objekt am Anfang der Liste (head) kann verwendet oder gelöscht werden. 
* `Set` Collections sind eine ungeordnete Menge an Objekten. Objekte können in einem Set nur einmal enthalten sein. Über das Set kann nicht direkt auf das Objekt zugegriffen werden. Es kann aber geprüft werden ob ein spezifisches Objekt in einem Set ist.
:::

## Collections

![](images/collections.png){web_width="80%"}
::: notes
Alternativ:
:::

## Map

![](images/map.png){web_width="80%"}
::: notes
Alternativ:
:::

## Iterator
...

## hashCode() und equals()
...

## ADS?

## Anwendungsbeispiele

## Unterschiedliche List Typen

## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
