---
type: lecture-cg
title: "Swing 101: Basics"
menuTitle: "Swing: Basics"
author: "Carsten Gips (FH Bielefeld)"
weight: 1
readings:
  - key: "Java-SE-Tutorial"
    comment: "Creating Graphical User Interfaces > Creating a GUI With Swing"
  - key: "Ullenboom2021"
    comment: "Kap. 18: Einführung in grafische Oberflächen"
tldr: |
  TODO
outcomes:
  - k2: "Unterschied und Zusammenhang zwischen Swing und AWT"
youtube:
  - link: ""
    name: "VL Swing 101"
  - link: ""
    name: "Demo Swing 101"
fhmedia:
  - link: ""
    name: "VL Swing 101"
---


## Wiederholung GUI in Java

*   **AWT**: `abstract window toolkit`
    *   Älteres Framework ("Legacy")
    *   "Schwergewichtig": plattformangepasst
    *   Paket `java.awt`

*   **Swing**
    *   Nutzt AWT
    *   "Leichtgewichtig": rein in Java implementiert
    *   Paket `javax.swing`

*   **JavaFX**
    *   Soll als Ersatz für Swing dienen
        *   Community eher verhalten
        *   Weiterentwicklung immer wieder unklar
        *   Nicht mehr im JDK/Java SE Plattform enthalten
    *   Vergleichsweise komplexes Framework, auch ohne Java programmierbar
        (Skriptsprache FXML)

::: notes
_Anmerkung_: In Swing reimplementierte Klassen aus AWT:
Präfix "J": `java.awt.Button` (AWT) => `javax.swing.JButton` (Swing)
:::


## Graphische Komponenten einer GUI

TODO: Screenshot einfaches Fenster, gelabelt

::: notes
*   Top-Level Komponenten
    *   Darstellung direkt auf Benutzeroberfläche des Betriebssystems
    *   Beispiele: Fenster, Dialoge

*   Atomare Komponenten
    *   Enthalten i.d.R. keine weiteren Komponenten
    *   Beispiele: Label, Buttons, Bilder

*   Gruppierende Komponenten
    *   Bündeln und gruppieren andere Komponenten
    *   Beispiele: JPanel
:::

\bigskip
[Achtung:]{.alert}
Unterteilung nicht im API ausgedrückt: Alle Swing-Bausteine leiten von
Klasse `javax.swing.JComponent` ab!

=> Nutzung "falscher" Methoden führt zu Laufzeitfehlern.


## Ein einfaches Fenster

TODO: Code

[Demo: Fenster mit einigen Elementen]{.bsp}


## Wrap-Up

*   TODO







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
