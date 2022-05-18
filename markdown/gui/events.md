---
type: lecture-cg
title: "Swing Events"
menuTitle: "Swing: Events"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
readings:
  - key: "Java-SE-Tutorial"
    comment: "Creating Graphical User Interfaces > Creating a GUI With Swing"
  - key: "Ullenboom2021"
    comment: "Kap. 18: Einführung in grafische Oberflächen"
tldr: |
  TODO

  *   Observer-Pattern in Swing-Komponenten:
    *   Events: Enthalten Source-Objekt und Informationen
    *   Event-Listener: Interfaces mit Methoden zur Reaktion
    *   Adapter: Listener mit leeren Methodenrümpfen

outcomes:
  - k2: "Unterschied zwischen den Listenern und den entsprechenden Adaptern"
  - k3: "Anwendung des Observer-Pattern, beispielsweise als Listener in Swing, aber auch in eigenen Programmen"
  - k3: "Nutzung von ActionListener, MouseListener, KeyListener, FocusListener"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
youtube:
  - link: ""
    name: "VL Swing Events"
  - link: ""
    name: "Demo Swing Events"
  - link: ""
    name: "Demo Swing Events"
fhmedia:
  - link: ""
    name: "VL Swing Events"
---


## Reaktion auf Events: Anwendung Observer-Pattern

::::::::: notes
*   Swing-GUI läuft in Dauerschleife
*   Komponenten registrieren Ereignisse (Events):
    *   Mausklick
    *   Tastatureingaben
    *   Mauszeiger über Komponente
    *   ...
* Reaktion mit passendem Listener: Observer Pattern!

:::::: columns
::: {.column width="45%"}

![](images/ActionListener.png){width="80%"}

:::
::: {.column width="45%"}

![](images/Observer.png){width="80%"}

:::
::::::
:::::::::

![](images/EventListener.png){width="80%"}

=> Observer aus dem Observer-Pattern!

::: notes
In Swing werden die "Observer" als "Listener" bezeichnet.
:::

```java
component.addActionListener(ActionListener);
component.addMouseListener(MouseListener);
```


## Details zu Listenern

*   Ein Listener kann bei mehreren Observables registriert sein:

    ```java
    Handler single = new Handler();
    singleButton.addActionListener(single);
    multiButton.addActionListener(single);
    ```

*   Ein Observable kann mehrere Listener bedienen:

    ```java
    Handler h1 = new Handler();
    Handler h2 = new Handler();
    multiButton.addActionListener(h1);
    multiButton.addActionListener(h2);
    ```

*   Sequentielles Abarbeiten der Events bzw. Benachrichtigung der Observer

![](images/2eventsource.png){width="80%"}
[Quelle: Java-SE-7-Tutorial, Oracle.com, figures/uiswing/events/2eventsource.gif]{.origin}

[Beispiel: java2d.swing.MultiListenerDemo]{.bsp}


## Wie komme ich an die Daten eines Events?

![](images/EventObject.png){width="80%"}

**Event-Objekte**: Quelle des Events plus aufgetretene Daten

[Beispiel: java2d.swing.MouseListenerDemo]{.bsp}


## Listener vs. Adapter

::: notes
*   Vielzahl möglicher Events
*   Jeweils passendes Event-Objekt u. Event-Listener-Interface
*   Oft nur wenige Methoden, u.U. aber [viele Methoden]{.alert}
:::

=> Bei Nutzung eines Event-Listeners müssen immer [**alle**]{.alert}
Methoden implementiert werden (auch nicht benötigte)!

\bigskip
Abhilfe: **Adapter**-Klassen:

*   Für viele Event-Listener-Interfaces existieren Adapter-Klassen
*   Implementieren jeweils ein Interface
*   Alle Methoden mit **leerem** Body vorhanden

\smallskip
=> Nutzung Adapterklassen: Nur benötigte
Listener-Methoden überschreiben.

\bigskip
Details siehe @Deitel2012,
Abschnitt 14.15: "Adapter Classes"

[Beispiel: java2d.swing.MouseAdapterDemo]{.bsp}


## Wrap-Up

*   Observer-Pattern in Swing-Komponenten:
    *   Events: Enthalten Source-Objekt und Informationen
    *   Event-Listener: Interfaces mit Methoden zur Reaktion
    *   Adapter: Listener mit leeren Methodenrümpfen







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
