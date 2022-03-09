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
  TODO
outcomes:
  - k3: "Entwurfsmuster Factory-Methode anwenden"
quizzes:
  - link: "XYZ"
assignments:
  - topic: sheet01
youtube:
  - link: "https://youtu.be/XYZ"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/XYZ"
---


## Einschub Factory-Method-Pattern

![](images/factorymethod.png)


## Hands-On: Ticketautomat (10 Minuten)

Implementieren Sie einen Ticketautomaten, der verschiedene Tickets mit
Hilfe des Factory-Method Entwurfsmusters generiert.

\bigskip

*   Nutzer geben Fahrtziel an (und nicht die Ticketart!)
*   Ticketautomat erstellt passendes Ticket
    *   User muss nicht die konkreten Ticketarten kennen
    *   Ticketarten lassen sich leicht austauschen

    => Objekte sollen nicht direkt durch den Nutzer erzeugt werden

[Konsole: factory.FactoryBeispiel]{.bsp}


## Wrap-Up

TODO







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
