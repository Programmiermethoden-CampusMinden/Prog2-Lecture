---
archetype: lecture-cg
title: "Swing: Layout-Manager"
linkTitle: "Swing: Layout-Manager"
author: "Carsten Gips (HSBI)"
readings:
  - key: "Java-SE-Tutorial"
    comment: "Creating Graphical User Interfaces > Creating a GUI With Swing"
  - key: "Ullenboom2021"
    comment: "Kap. 18: Einführung in grafische Oberflächen"
tldr: |
  Zur Anordnung von Komponenten greift Swing auf sogenannte Layout-Manager zurück.

  Hier gibt es viele verschiedene Ausprägungen und Spielarten. Es gibt beispielsweise:
  *   das `BorderLayout`, eine gitterartige Struktur mit fünf Elementen,
  *   das `FlowLayout`, eine einzeilige Anordnung mit automatischem Umbruch bei Platzmangel,
  *   das `GridLayout`, eine tabellenartige Struktur, in der alle Elemente gleich groß dargestellt werden, und
  *   das `GridBagLayout`, welches sich prinzipiell wie das `GridLayout` verhält und mehr Möglichkeiten bietet.
      Zur Anordnung der Komponenten greift man hier auf `GridBagConstraints` zurück und kann sehr genau und
      sehr flexibel definieren, wo und wie die Komponenten angeordnet sein sollen und sich bei Größenänderungen
      des Containers verhalten sollen.
outcomes:
  - k3: "Anwenden der verschiedenen Layout-Manager: BorderLayout, FlowLayout, GridLayout, GridBagLayout"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106248&client_id=FH-Bielefeld"
    name: "Quiz Swing (ILIAS)"
youtube:
  - link: "https://youtu.be/An7tQMW1A3E"
    name: "VL Swing: Layout-Manager"
  - link: "https://youtu.be/tifXSKXSUYw"
    name: "Demo BorderLayout"
  - link: "https://youtu.be/tYTDhv6lwT8"
    name: "Demo FlowLayout"
  - link: "https://youtu.be/JyN_Wozg3ms"
    name: "Demo GridLayout"
  - link: "https://youtu.be/95PG2alVTSo"
    name: "Demo GridBagLayout"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/16d8509024067614df7909666ebb26ac42eb672180fd8b9f846d61f6d9d5c7d75a7430799469971666cbbe531fab23f7b78884c9bd432e901bfe81975e84da2b"
    name: "VL Swing: Layout-Manager"
challenges: |
    In den [Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/gui/src/challenges)
    eine Implementierung für ein TicTacToe-Spiel. Ihre
    Aufgabe ist es, eine grafische Benutzeroberfläche für das Spiel zu entwickeln.

    Ihr Fenster soll sich immer in der Mitte des Bildschirms starten und einen Titel
    besitzen.

    Beim Start des Spiels sollen beide Spieler ihre Namen eingeben können, nutzen Sie
    dafür `JTextField`. Stellen Sie sicher, dass nur gültige Eingaben getätigt werden.
    Sind die beiden Namen gültig, erstellen Sie die jeweiligen `Player` und starten Sie
    ein Spiel `TicTacToe`.

    Im Zentrum Ihres Spielfensters soll das Spielfeld angezeigt werden. Nutzen Sie dafür
    das `GridLayout` und `JButton`. Die Buttons repräsentieren dabei die Felder des Spiels.
    Beim Drücken eines Buttons soll die Methode `TicTacToe#makeMove` aufgerufen werden.

    Mit `TicTacToe#getGameField` können Sie sich das aktuelle Spielfeld übergeben lassen.
    Sorgen Sie dafür, dass Ihre Oberfläche immer den aktuellen Zustand des Spielfeldes
    anzeigt.

    Prüfen Sie nach jedem Spielzug den Status des Spiels mit `TicTacToe#getCurrentGameState`:

    -   Wenn ein Spieler gewonnen hat, soll ein `JOptionPane` angezeigt werden und dem Gewinner
        gratulieren.
    -   Wenn ein Unentschieden gespielt wurde, soll ein `JOptionPane` angezeigt werden und das
        Unentschieden angezeigt werden.
    -   In beiden Fällen soll danach eine neue Runde gestartet werden.

    Im unteren Bereich des Fensters soll der Spieler angezeigt werden, der aktuell am Zug ist.
    Im unteren Bereich des Fensters soll auch der aktuelle Punktestand angezeigt werden.

    Das Fenster soll eine Menüleiste mit folgenden Punkten haben:

    -   Exit: Beendet das Programm.
    -   New Game: Startet das Spiel neu und erlaubt die neue Eingabe der Spielernamen.
    -   Clear: Setzt das aktuelle Spielfeld zurück.

    Denken Sie bei der Umsetzung daran, dass der Benutzer nur die Oberfläche sieht und bedienen
    kann. Stellen Sie sicher, dass alle Bedienelemente verständlich sind. Nutzen Sie ggf. `JLabel`,
    um Texte auf der UI anzuzeigen.
---


## Überblick

Anordnung der Komponenten [in einem Container ist]{.notes} abhängig vom **Layout**

\bigskip

Verschiedene beliebte Layout-Manager:

*   `BorderLayout`
*   `FlowLayout`
*   `GridLayout`
*   `GridBagLayout`
*   ...


## _BorderLayout_

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

[Demo: layout.Border]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/layout/Border.java"}


## _FlowLayout_

![](images/screenshot-flowlayout.png){width="60%"}

```java
JPanel contentPane = new JPanel();

contentPane.setLayout(new FlowLayout());

contentPane.add(new JButton("Label 1"));
contentPane.add(new JButton("Label 2"));
contentPane.add(new JButton("Label 3"));
```

::: notes
Das `FlowLayout` ist ein sehr einfaches Layout, welches per Default in `JPanel` genutzt wird.

Die Komponenten werden der Reihe nach in einer Zeile angeordnet. Wenn der Platz nicht ausreicht,
bricht diese Zeile um in mehrere Zeilen.

Per Default werden die Komponenten zentriert angeordnet. Über den Konstruktor oder die Methoden
`setAlignment()` und `setHgap()` bzw. `setVgap()` kann aber eine andere Ausrichtung definiert
werden, ebenso wie ein vertikales und horizontales Padding zwischen den Komponenten.
:::

[Demo: layout.Flow]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/layout/Flow.java"}


## _GridLayout_

![](images/screenshot-gridlayout.png){width="40%"}

```java
JPanel contentPane = new JPanel();

contentPane.setLayout(new GridLayout(0, 3));

contentPane.add(new JButton("Label 1"));
contentPane.add(new JButton("Label 2"));
contentPane.add(new JButton("Label 3"));
```

::: notes
Das `GridLayout` ist ein sehr einfaches Layout mit einer tabellenartigen Struktur. Dabei werden
die Komponenten nacheinander auf die "Zellen" verteilt, beginnend mit der ersten Zeile. Alle
Komponenten werden dabei gleich groß dargestellt.

Über den Konstruktor wird die Anzahl der gewünschten Zeilen und Spalten angegeben. Es darf auch
für einen der beiden Parameter der Wert 0 verwendet werden, in diesem Fall werden so viele Zeilen
oder Spalten angelegt, wie für die hinzugefügten Komponenten benötigt.

Auch in diesem Layout kann das Padding über die Methoden `setHgap()` bzw. `setVgap()` eingestellt
werden.
:::

[Demo: layout.Grid]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/layout/Grid.java"}


## Komplexer Layout-Manager: _GridBagLayout_

*   Layout-Manager ähnlich zu `GridLayout`
*   Zusätzlich `GridBagConstraints`: Verhalten bei Größenveränderungen

\bigskip

| Constraint   | Bedeutung                                                                                 |
|:-------------|:------------------------------------------------------------------------------------------|
| `gridx`      | **Spalte** für Komponente (linke obere Ecke)                                              |
| `gridy`      | **Zeile** für Komponente (linke obere Ecke)                                               |
| `gridwidth`  | **Anzahl der Spalten** für Komponente                                                     |
| `gridheight` | **Anzahl der Zeilen** für Komponente                                                      |
| `fill`       | Vergrößert **Komponente** in  Richtung: `NONE`, `HORIZONTAL`, `VERTICAL`, `BOTH`          |
| `weightx`    | Platz in x-Richtung wird unter den **Grid-Slots** entsprechend ihrem "Gewicht" aufgeteilt |
| `weighty`    | Platz in y-Richtung wird unter den **Grid-Slots** entsprechend ihrem "Gewicht" aufgeteilt |

::: notes
Beim Hinzufügen einer Komponente wird eine Instanz der Klasse `GridBagConstraints` mitgegeben.
Diese definiert, wie die Komponente in der gitterartigen Struktur konkret angeordnet werden soll:
Startposition im Gitter (x, y) bzw (Spalte, Zeile), wie viele Spalten oder Zeilen soll die
Komponente überstreichen und wie soll auf Größenänderungen des Containers reagiert werden.

Beispiel:

```java
JPanel contentPane = new JPanel();
contentPane.setLayout(new GridBagLayout());

GridBagConstraints c2 = new GridBagConstraints();
c2.gridx = 1;
c2.gridy = 0;
c2.gridheight = 2;
c2.fill = GridBagConstraints.VERTICAL;
c2.weightx = 0.5;
c2.weighty = 0.5;

contentPane.add(new JButton("Label 2"), c2);
```

Der Button wird dem Panel mit dem GridBagLayout hinzugefügt und soll in Spalte 1 und Zeile 0
angeordnet werden. Er soll sich dabei über 2 Zeilen erstrecken (und 1 Spalte). Der Button soll
sich in vertikaler Richtung vergrößern, sofern Platz zur Verfügung steht.

Dem Grid-Slot wird ein Gewicht in x- und in y-Richtung von je 0.5 mitgegeben. Bei einer Änderung
des Containers in der jeweiligen Richtung wird der neue Platz unter den Slots gemäß ihren Gewichten
aufgeteilt.
:::

[Demo: layout.GridBag]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/layout/GridBag.java"}


## Wrap-Up

*   Anordnung von Komponenten lässt sich mit Layout-Manager steuern

\bigskip

*   Auswahl von beliebten Layout-Managern:
    *   `BorderLayout`: Gitterartige Struktur mit fünf Elementen
    *   `FlowLayout`: Zeilenweise Anordnung (Umbruch bei Platzmangel)
    *   `GridLayout`: Tabellenartige Struktur, Elemente gleich groß
    *   `GridBagLayout`: Wie `GridLayout`, mit mehr Möglichkeiten: `GridBagConstraints`







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
