---
type: lecture-cg
title: "Factory-Method-Pattern"
menuTitle: "Factory-Method"
author: "Carsten Gips (FH Bielefeld)"
weight: 1
readings:
  - key: "Eilebrecht2013"
  - key: "Gamma2011"
  - key: "Kleuker2018"
tldr: |
  Oft ist es wünschenswert, dass Nutzer nicht direkt Objekte von bestimmten Klassen anlegen (können).
  Hier kann eine "Fabrik-Methode" (**Factory-Method**) helfen, der man die gewünschten Parameter
  übergibt und die daraus dann das passende Objekt (der richtigen Klasse) erzeugt und zurückliefert.

  Dadurch erreicht man eine höhere Entkoppelung, die Nutzer müssen nur noch das Interface oder die
  abstrakte Klasse, also den Obertyp des Ergebnisses kennen. Außerdem lassen sich so leicht die
  konkreten Klassen austauschen.

  Dieses Entwurfsmuster kommt häufig zusammen mit dem _Singleton-Pattern_ vor, wo es nur eine einzige
  Instanz einer Klasse geben soll. Über eine Fabrik-Methode kann man diese Instanz ggf. erzeugen und
  dann die Referenz darauf zurückliefern.
outcomes:
  - k3: "Entwurfsmuster Factory-Methode anwenden"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1045002&client_id=FH-Bielefeld"
    name: "Quiz Factory-Method-Pattern (ILIAS)"
assignments:
  - topic: sheet02
youtube:
  - link: "https://youtu.be/mJWe-2BS2W0"
    name: "VL Factory-Method-Pattern"
  - link: "https://youtu.be/14rt1YIoiME"
    name: "Demo Factory-Method-Pattern"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/54f1c0ac6b5a7670788efdd88e63dd9eb5de4179d342bce82f5c04268c469beba149891305c81181f1d23c2cf89194f06cdac809396d2e7bff7607078a1a621e"
    name: "VL Factory-Method-Pattern"
---


## Motivation: Ticket-App

*   Nutzer geben Fahrtziel an (und nicht die Ticketart!)

\bigskip

*   Ticket-App bucht passendes Ticket
    *   User muss nicht die konkreten Ticketarten kennen
    *   Ticketarten lassen sich leicht austauschen

\bigskip
\bigskip

=> **Factory-Method-Pattern**: Objekte sollen nicht direkt durch den Nutzer erzeugt werden


## Factory-Method-Pattern

![](images/factorymethod.png){width="80%"}


## Hands-On: Ticket-App

Implementieren Sie eine Ticket-App, die verschiedene Tickets mit
Hilfe des Factory-Method Entwurfsmusters generiert.

[UML; Konsole: factory.FactoryBeispiel]{.bsp}


## Wrap-Up

*   Konkrete Objekte sollen nicht direkt über Konstruktor erzeugt werden
*   (Statische) Hilfsmethode, die aus Parameter das "richtige" Objekte erzeugt

\smallskip

*   Vorteil:
    *   Nutzer kennt nur das Interface
    *   Konkrete Klassen lassen sich leicht austauschen







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
