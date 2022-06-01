---
type: lecture-cg
title: "Visitor-Pattern"
menuTitle: "Visitor"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
readings:
  - key: "Eilebrecht2013"
  - key: "Gamma2011"
  - key: "Kleuker2018"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: "Aufbau des Visitor-Patterns (Besucher-Entwurfsmusters)"
  - k3: "Anwendung des Visitor-Patterns auf konkrete Beispiele, etwa den PM-Dungeon"
quizzes:
  - link: ""
    name: "Quiz Visitor-Pattern (ILIAS)"
assignments:
  - topic: sheet09
youtube:
  - link: ""
    name: "VL Visitor-Pattern"
  - link: ""
    name: "Demo Visitor-Pattern"
fhmedia:
  - link: ""
    name: "VL Visitor-Pattern"
---


## Motivation: Parsen von "5*4+3"

```yacc
expr : e1=expr '*' e2=expr      # MULT
     | e1=expr '+' e2=expr      # ADD
     | DIGIT                    # ZAHL
     ;
```

![](images/parsetree.png)


## Strukturen für den Parsetree

```java

```


## Ausrechnen des Ausdrucks

```java

```


## Pretty-Print des Ausdrucks

```java
```


## Visitor-Pattern (Besucher-Entwurfsmuster)

![](images/visitor.png)


## Ausrechnen des Ausdrucks mit einem Visitor

```java
```


## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
