# Swing 1: Basics

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Swing baut auf AWT auf und ersetzt dieses. Der designierte Nachfolger
> JavaFX wurde nie wirklich als Ersatz angenommen und ist mittlerweile
> sogar wieder aus dem JDK bzw. der Java SE herausgenommen worden.
>
> Swing-Fenster bestehen zunächst aus Top-Level-Komponenten wie einem
> Frame oder einem Dialog. Darin können "atomare Komponenten" wie
> Buttons, Label, Textfelder, ... eingefügt werden. Zur Gruppierung
> können Komponenten wie Panels genutzt werden.
>
> Fenster werden über die Methode `pack()` berechnet (Größe, Anordnung)
> und müssen explizit sichtbar gemacht werden (`setVisible(true)`). Per
> Default läuft die Anwendung weiter, nachdem das Hauptfenster
> geschlossen wurde (konfigurierbar).
>
> Swing ist nicht Thread-safe, man darf also nicht mit mehreren Threads
> parallel die Komponenten bearbeiten. Events werden in Swing durch
> einen speziellen Thread verarbeitet, dem sogenannten *Event Dispatch
> Thread* (EDT). Dieser wird über den Aufruf von `pack()` automatisch
> gestartet. Da das Hauptprogramm `main()` in einem eigenen Thread läuft
> und ja die ganzen Komponenten quasi schrittweise erzeugt, kann es hier
> zu Konflikten kommen. Deshalb sollte das Erzeugen der Swing-GUI als
> neuer Thread ("Runnable") dem EDT übergeben werden.
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> Vorlesung \[[YT](https://youtu.be/UNTMWHEbnYs)\],
> \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-swing-1-basics/426b0e66bbe4a2d940655a40341002f2)\]
>
> Demo Einfaches Fenster \[[YT](https://youtu.be/IKsptx69iTM)\],
> \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-demo-swing-einfaches-fenster/f221a9c89a1f8c12d494171967fc3b8e)\]
>
> </details>

## Wiederholung GUI in Java

-   **AWT**: `abstract window toolkit`
    -   Älteres Framework ("Legacy")
    -   "Schwergewichtig": plattformangepasst
    -   Paket `java.awt`

<!-- -->

-   **Swing**
    -   Nutzt AWT
    -   "Leichtgewichtig": rein in Java implementiert
    -   Paket `javax.swing`

<!-- -->

-   **JavaFX**
    -   Soll als Ersatz für Swing dienen
        -   Community eher verhalten
        -   Weiterentwicklung immer wieder unklar
        -   Nicht mehr im JDK/Java SE Plattform enthalten
    -   Vergleichsweise komplexes Framework, auch ohne Java
        programmierbar (Skriptsprache FXML)

*Anmerkung*: In Swing reimplementierte Klassen aus AWT: Präfix "J":
`java.awt.Button` (AWT) =\> `javax.swing.JButton` (Swing)

## Graphische Komponenten einer GUI

-   Top-Level Komponenten
    -   Darstellung direkt auf Benutzeroberfläche des Betriebssystems
    -   Beispiele: Fenster, Dialoge
-   Atomare Komponenten
    -   Enthalten i.d.R. keine weiteren Komponenten
    -   Beispiele: Label, Buttons, Bilder
-   Gruppierende Komponenten
    -   Bündeln und gruppieren andere Komponenten
    -   Beispiele: JPanel

**Achtung**: Unterteilung nicht im API ausgedrückt: Alle Swing-Bausteine
leiten von Klasse `javax.swing.JComponent` ab!

=\> Nutzung "falscher" Methoden führt zu Laufzeitfehlern.

## Ein einfaches Fenster

``` java
public class FirstWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World :)");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
```

### Elemente

Es wird ein neuer Frame angelegt als Top-Level-Komponente. Der
Fenstertitel wird auf "Hello World :)" gesetzt.

Zusätzlich wird spezifiziert, dass sich das Programm durch Schließen des
Fensters beenden soll. Anderenfalls würde man zwar das sichtbare Fenster
schließen, aber das Programm würde weiter laufen.

Mit der Swing-Methode `pack()` werden alle Komponenten berechnet und die
Fenstergröße bestimmt, so dass alle Komponenten Platz haben. Bis dahin
ist das Fenster aber unsichtbar und wird erst über den Aufruf von
`setVisible(true)` auch dargestellt.

### Swing und Multithreading: Event Dispatch Thread

Leider ist die Welt nicht ganz so einfach. In Swing werden Events wie
das Drücken eines Buttons durch den *Event Dispatch Thread* (EDT)
abgearbeitet. (Zum Thema Events in Swing siehe Einheit ["Swing
Events"](./swing4-events.md).) Der EDT wird mit dem Erzeugen der
visuellen Komponenten für die Swing-Objekte durch den Aufruf der
Swing-Methoden `show()`, `setVisible()` und `pack()` erstellt. Bereits
beim Realisieren der Komponenten könnten diese Events auslösen, die dann
durch den EDT verarbeitet werden und an mögliche Listener verteilt
werden. Dummerweise wird das `main()` von der JVM aber in einem eigenen
Thread abgearbeitet - es könnten also zwei Threads parallel durch die
hier erzeugte Swing-GUI laufen, und Swing ist **nicht Thread-safe**!
Komponenten dürfen nicht durch verschiedene Threads manipuliert werden.

Die Lösung ist, die Realisierung der Komponenten als Job für den EDT zu
"verpacken":

``` java
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

Mit `new Runnable()` wird ein neues Objekt vom Typ `Runnable` anlegt -
im Prinzip ein neuer, noch nicht gestarteter Thread mit der Hauptmethode
`run()`. Dieses Runnable wird mit `SwingUtilities.invokeLater()` dem EDT
zu Ausführung übergeben.

Zum Thema "Nebenläufige Programmierung" auch [Einführung in die
nebenläufige Programmierung (Rheinwerk
Verlag)](https://openbook.rheinwerk-verlag.de/javainsel/17_001.html#u17)
und [Lesson: Concurrency
(Oracle)](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
sowie speziell in Bezug auf Swing ["Concurrency in
Swing"](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html).

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/basics/FirstWindow.java">Beispiel: basics.FirstWindow</a></p>

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/basics/SecondWindow.java">Demo: basics.SecondWindow</a></p>

## Wrap-Up

-   Swing baut auf AWT auf und nutzt dieses
-   JavaFX ist moderner, aber kein Swing-Ersatz geworden

<!-- -->

-   Basics:
    -   Swing-Fenster haben Top-Level-Komponenten: `JFrame`, ...
    -   Atomare Komponenten wie Buttons, Label, ... können gruppiert
        werden
    -   Fenster müssen explizit sichtbar gemacht werden
    -   Nach Schließen des Fensters läuft die Applikation weiter
        (Default)
    -   Swing-Events werden durch den *Event Dispatch Thread* (EDT)
        verarbeitet =\> Aufpassen mit Multithreading!

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> Zum Thema Swing Basics können Sie im Tutorial ["Using Top-Level
> Containers"
> (Oracle)](https://docs.oracle.com/javase/tutorial/uiswing/components/toplevel.html)
> nachlesen.
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Unterschied und Zusammenhang zwischen Swing und AWT
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> 6a34679 2026-04-27 swing1: rework readings<br></sub></sup></p></blockquote>
