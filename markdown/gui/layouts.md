---
type: lecture-cg
title: "Swing: Layout-Manager"
menuTitle: "Swing: Layout-Manager"
author: "Carsten Gips (FH Bielefeld)"
weight: 4
readings:
  - key: "Java-SE-Tutorial"
    comment: "Creating Graphical User Interfaces > Creating a GUI With Swing"
  - key: "Ullenboom2021"
    comment: "Kap. 18: Einführung in grafische Oberflächen"
tldr: |
  TODO

    *   Fortgeschrittenes Layout mit `GridBagLayout`

outcomes:
  - k3: "Komplexe Layouts mit GridBagLayout"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1085303&client_id=FH-Bielefeld"
    name: "Quiz Swing (ILIAS)"
youtube:
  - link: ""
    name: "VL Swing: Layout-Manager"
  - link: ""
    name: "Demo Swing: Layout-Manager"
  - link: ""
    name: "Demo Swing: Layout-Manager"
fhmedia:
  - link: ""
    name: "VL Swing: Layout-Manager"
---


## Überblick

Anordnung der Komponenten [in einem Container ist]{.notes} abhängig vom **Layout**

\bigskip

Verschiedene LayoutManager:

*   `BorderLayout`
*   `FlowLayout`
*   `GridLayout`
*   `GridBagLayout`
*   ...


## Border

![](images/screenshot-borderlayout.png){width="40%"}

```java
JPanel contentPane = new JPanel();

contentPane.setLayout(new BorderLayout());

contentPane.add(new JButton("North"), BorderLayout.NORTH);  // also: PAGE_START
contentPane.add(new JButton("West"), BorderLayout.WEST);    // also: LINE_START
contentPane.add(new JButton("Center"), BorderLayout.CENTER);
contentPane.add(new JButton("East"), BorderLayout.EAST);    // also: LINE_END
contentPane.add(new JButton("South"), BorderLayout.SOUTH);  // also: PAGE_END
```

::: notes
Es gibt fünf verschiedene Bereiche, in denen die Komponenten bei einem Border-Layout angeordnet
werden können. Für die "historischen" Konstanten `NORTH`, `SOUTH`, `WEST` und `EAST` gibt es
mittlerweile neue Namen, die eher am Aufbau einer Seite orientiert werden können.

Man kann auch nur einige Teile nutzen, bei der Tabellen-Demo beispielsweise wurde nur der
`NORTH`-Bereich für den Tabellenkopf und der `CENTER`-Bereich für die eigentliche Tabelle
genutzt.

Wenn das Fenster vergrößert wird, bekommt zunächst der Mittelteil den neuen zur Verfügung stehenden
Platz. Die anderen Bereiche werden dabei auf vergrößert, aber nur so weit, dass der neue verfügbare
Platz ggf. ausgefüllt wird.

Mit den Methoden `setHgap()` und `setVgap()` kann der Abstand zwischen den Komponenten eingestellt
werden (horizontal und vertikal, Abstände in Pixel).
:::

[Demo: [layout.Border](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/gui/src/layout/Border.java)]{.bsp}


## Flow

todo


## Grid

todo


## Komplexer Layoutmanager: _GridBagLayout_

*   Layoutmanager mit gitterartiger Grundstruktur
*   Erzeugung/Verwendung ähnlich zu `GridLayout`
*   Zusätzlich **Constraints**, beschreiben Verhalten des
    Layouts bei Größenveränderungen: `GridBagConstraints`

| Constraint   | Bedeutung                                                                                                    |
|:-------------|:-------------------------------------------------------------------------------------------------------------|
| `gridx`      | **Spalte** für Komponente (linke obere Ecke)                                                                 |
| `gridy`      | **Zeile** für Komponente (linke obere Ecke)                                                                  |
| `gridwidth`  | **Anzahl der Spalten** für Komponente                                                                        |
| `gridheight` | **Anzahl der Zeilen** für Komponente                                                                         |
| `fill`       | Vergrößert **Komponente** (wenn Platz ist) in angegebene  Richtung: `NONE`, `HORIZONTAL`, `VERTICAL`, `BOTH` |
| `weightx`    | Freier Platz in x-Richtung wird unter den **Grid-Slots** entsprechend ihrem "Gewicht" aufgeteilt             |
| `weighty`    | Freier Platz in y-Richtung wird unter den **Grid-Slots** entsprechend ihrem "Gewicht" aufgeteilt             |

::: notes
Selbststudium: Machen Sie sich mit Hilfe der Literatur mit dem `GridBagLayout`
vertraut. Nutzen Sie den Beispielcode und variieren Sie die verschiedenen
Parameter/Constraints, um sich mit dem Verhalten und den Auswirkungen vertraut
zu machen!

[Beispiel: java2d.swing.MultiListenerGridBagDemo]{.bsp}
:::


## Wrap-Up

*   Fortgeschrittene Swing-Komponenten
    *   Fortgeschrittenes Layout mit `GridBagLayout`







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
