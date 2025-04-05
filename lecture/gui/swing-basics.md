---
title: "Swing 101: Basics"
author: "Carsten Gips (HSBI)"
readings:
  - key: "Java-SE-Tutorial"
    comment: "Creating Graphical User Interfaces > Creating a GUI With Swing"
  - key: "Ullenboom2021"
    comment: "Kap. 18: Einführung in grafische Oberflächen"
tldr: |
  Swing baut auf AWT auf und ersetzt dieses. Der designierte Nachfolger JavaFX wurde nie wirklich
  als Ersatz angenommen und ist mittlerweile sogar wieder aus dem JDK bzw. der Java SE herausgenommen
  worden.

  Swing-Fenster bestehen zunächst aus Top-Level-Komponenten wie einem Frame oder einem Dialog.
  Darin können "atomare Komponenten" wie Buttons, Label, Textfelder, ... eingefügt werden. Zur
  Gruppierung können Komponenten wie Panels genutzt werden.

  Fenster werden über die Methode `pack()` berechnet (Größe, Anordnung) und müssen explizit
  sichtbar gemacht werden (`setVisible(true)`). Per Default läuft die Anwendung weiter,
  nachdem das Hauptfenster geschlossen wurde (konfigurierbar).

  Swing ist nicht Thread-safe, man darf also nicht mit mehreren Threads parallel die Komponenten
  bearbeiten. Events werden in Swing durch einen speziellen Thread verarbeitet, dem sogenannten
  _Event Dispatch Thread_ (EDT). Dieser wird über den Aufruf von `pack()` automatisch gestartet.
  Da das Hauptprogramm `main()` in einem eigenen Thread läuft und ja die ganzen Komponenten
  quasi schrittweise erzeugt, kann es hier zu Konflikten kommen. Deshalb sollte das Erzeugen der
  Swing-GUI als neuer Thread ("Runnable") dem EDT übergeben werden.
outcomes:
  - k2: "Unterschied und Zusammenhang zwischen Swing und AWT"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106248&client_id=FH-Bielefeld"
    name: "Quiz Swing (ILIAS)"
youtube:
  - link: "https://youtu.be/ynwu6LuSLgQ"
    name: "VL Swing 101"
  - link: "https://youtu.be/L3Y2mB7-jRQ"
    name: "Demo Einfaches Fenster"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/4b3f17de4155c07ed1b7e568d19eea47a865912d93a68adba04f22601c0c509034d5328f3e66131bbfdb8fe31c2a23bf95d67a3df57e3df4e548612d9f4bfd16"
    name: "VL Swing 101"
---


## Wiederholung GUI in Java

*   **AWT**: `abstract window toolkit`
    *   Älteres Framework ("Legacy")
    *   "Schwergewichtig": plattformangepasst
    *   Paket `java.awt`

\bigskip

*   **Swing**
    *   Nutzt AWT
    *   "Leichtgewichtig": rein in Java implementiert
    *   Paket `javax.swing`

\bigskip

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

*   Top-Level Komponenten
    *   Darstellung direkt auf Benutzeroberfläche des Betriebssystems
    *   Beispiele: Fenster, Dialoge

*   Atomare Komponenten
    *   Enthalten i.d.R. keine weiteren Komponenten
    *   Beispiele: Label, Buttons, Bilder

*   Gruppierende Komponenten
    *   Bündeln und gruppieren andere Komponenten
    *   Beispiele: JPanel

\bigskip

**Achtung**:
Unterteilung nicht im API ausgedrückt: Alle Swing-Bausteine leiten von
Klasse `javax.swing.JComponent` ab!

=> Nutzung "falscher" Methoden führt zu Laufzeitfehlern.


## Ein einfaches Fenster

```java
public class FirstWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World :)");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
```

::: notes
### Elemente

Es wird ein neuer Frame angelegt als Top-Level-Komponente. Der Fenstertitel wird auf "Hello World :)"
gesetzt.

Zusätzlich wird spezifiziert, dass sich das Programm durch Schließen des Fensters beenden soll.
Anderenfalls würde man zwar das sichtbare Fenster schließen, aber das Programm würde weiter laufen.

Mit der Swing-Methode `pack()` werden alle Komponenten berechnet und die Fenstergröße bestimmt, so dass
alle Komponenten Platz haben. Bis dahin ist das Fenster aber unsichtbar und wird erst über den Aufruf
von `setVisible(true)` auch dargestellt.

### Swing und Multithreading: Event Dispatch Thread

Leider ist die Welt nicht ganz so einfach. In Swing werden Events wie das Drücken eines Buttons
durch den _Event Dispatch Thread_ (EDT) abgearbeitet. (Zum Thema Events in Swing siehe Einheit
["Swing Events"](events.md).) Der EDT wird mit dem Erzeugen der
visuellen Komponenten für die Swing-Objekte durch den Aufruf der Swing-Methoden `show()`,
`setVisible()` und `pack()` erstellt. Bereits beim Realisieren der Komponenten könnten diese
Events auslösen, die dann durch den EDT verarbeitet werden und an mögliche Listener verteilt
werden. Dummerweise wird das `main()` von der JVM aber in einem eigenen Thread abgearbeitet - es
könnten also zwei Threads parallel durch die hier erzeugte Swing-GUI laufen, und Swing ist
**nicht Thread-safe**! Komponenten dürfen nicht durch verschiedene Threads manipuliert werden.

Die Lösung ist, die Realisierung der Komponenten als Job für den EDT zu "verpacken":

```java
SwingUtilities.invokeLater(
        new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Hello World :)");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.pack();
                frame.setVisible(true);
            }
        });
```

Mit `new Runnable()` wird ein neues Objekt vom Typ `Runnable` anlegt - im Prinzip ein neuer, noch nicht
gestarteter Thread mit der Hauptmethode `run()`. Dieses Runnable wird mit `SwingUtilities.invokeLater()`
dem EDT zu Ausführung übergeben. Wir werden uns das Thema Erzeugen und Starten von Threads in der Einheit
["Einführung in die nebenläufige Programmierung mit Threads"](../java-classic/threads-intro.md)
genauer ansehen.

Siehe auch ["Concurrency in Swing"](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html).

[Beispiel: basics.FirstWindow]{.ex href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/basics/FirstWindow.java"}
:::

[Demo: basics.SecondWindow]{.ex href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/basics/SecondWindow.java"}


## Wrap-Up

*   Swing baut auf AWT auf und nutzt dieses
*   JavaFX ist moderner, aber kein Swing-Ersatz geworden

\bigskip

*   Basics:
    *   Swing-Fenster haben Top-Level-Komponenten: `JFrame`, ...
    *   Atomare Komponenten wie Buttons, Label, ... können gruppiert werden
    *   Fenster müssen explizit sichtbar gemacht werden
    *   Nach Schließen des Fensters läuft die Applikation weiter (Default)
    *   Swing-Events werden durch den _Event Dispatch Thread_ (EDT) verarbeitet \newline
        => Aufpassen mit Multithreading!
