---
archetype: lecture-cg
title: "Einführung in die nebenläufige Programmierung mit Threads"
linkTitle: "Intro"
author: "Carsten Gips (HSBI)"
readings:
  - key: "Ullenboom2021"
    comment: "Kap. 16: Einführung in die nebenläufige Programmierung"
  - key: "Java-SE-Tutorial"
    comment: "Trail: Essential Java Classes, Lesson: Concurrency"
  - key: "Boles2008"
tldr: |
    Threads sind weitere Kontrollflussfäden, die von der Java-VM (oder (selten) vom OS)
    verwaltet werden. Damit ist sind sie leichtgewichtiger als der Start neuer Prozesse
    direkt auf Betriebssystem-Ebene.

    Beim Start eines Java-Programms wird die `main()`-Methode automatisch in einem
    (Haupt-) Thread ausgeführt. Alle Anweisungen in einem Thread werden sequentiell
    ausgeführt.

    Um einen neuen Thread zu erzeugen, leitet man von `Thread` ab oder implementiert
    das Interface `Runnable`. Von diesen eigenen Klassen kann man wie üblich ein neues
    Objekt anlegen. Die Methode `run()` enthält dabei den im Thread auszuführenden
    Code. Um einen Thread als neuen parallelen Kontrollfluss zu starten, muss man die
    geerbte Methode `start()` auf dem Objekt aufrufen. Im Fall der Implementierung von
    `Runnable` muss man das Objekt zuvor noch in den Konstruktor von `Thread` stecken
    und so ein neues `Thread`-Objekt erzeugen, auf dem man dann `start()` aufrufen kann.

    Threads haben einen Lebenszyklus: Nach dem Erzeugen der Objekte mit `new` wird
    der Thread noch nicht ausgeführt. Durch den Aufruf der Methode `start()` gelangt
    der Thread in einen Zustand "ausführungsbereit". Sobald er vom Scheduler eine
    Zeitscheibe zugeteilt bekommt, wechselt er in den Zustand "rechnend". Von hier kann
    er nach Ablauf der Zeitscheibe durch den Scheduler wieder nach "ausführungsbereit"
    zurück überführt werden. Dieses Wechselspiel passiert automatisch und i.d.R. schnell,
    so dass selbst auf Maschinen mit nur einem Prozessor/Kern der Eindruck einer parallelen
    Verarbeitung entsteht. Nach Abarbeitung der `run()`-Methode wird der Thread beendet
    und kann nicht wieder neu gestartet werden. Bei Zugriff auf gesperrte Ressourcen
    oder durch `sleep()` oder `join()` kann ein Thread blockiert werden. Aus diesem
    Zustand gelangt er durch Interrupts oder nach Ablauf der Schlafzeit oder durch `notify`
    wieder zurück nach "ausführungsbereit".

    Die Thread-Objekte sind normale Java-Objekte. Man kann hier Attribute und Methoden
    haben und diese entsprechend zugreifen/aufrufen. Das klappt auch, wenn der Thread
    noch nicht gestartet wurde oder bereits abgearbeitet wurde.
outcomes:
  - k2: "Grundsätzlicher Unterschied zw. Threads und Prozessen"
  - k2: "Lebenszyklus von Threads"
  - k3: "Erzeugen und Starten von Threads"
  - k3: "Kommunikation mit Objekten"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106529&client_id=FH-Bielefeld"
    name: "Quiz Threads Intro (ILIAS)"
youtube:
  - link: "https://youtu.be/ClfXbNPRl_8"
    name: "VL Threads Intro"
  - link: "https://youtu.be/zcVqFAx5D0E"
    name: "Demo Threads Intro: Erzeugen von Threads"
  - link: "https://youtu.be/lQ_JSHBGhdU"
    name: "Demo Threads Intro: Arbeiten mit Threads (`join()`)"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/41a885ac4baf0e087d393b0fa9d3d6f38cc86debad5b7e563c46dac15c0ba4f214476650ad6fa288708eb8b1ccf12d19f6ab46a8c5cf7a58b61a4cff39ec727b"
    name: "VL Threads Intro"
---


## 42

![](images/screenshot_swingworker.png){width="80%"}

<!-- XXX
Wert 42 ausprobieren (ist zeitlich ganz gut)
-->

[Demo: misc.SwingWorkerDemo (GUI ausprobieren)]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/threads/src/misc/SwingWorkerDemo.java"}


::: notes
## Einführung in nebenläufige Programmierung
:::

::: notes
### Traditionelle Programmierung
::::

::: slides
## Traditionelle Programmierung
:::

::: notes
*   Aufruf einer Methode verlagert Kontrollfluss in diese Methode
*   Code hinter Methodenaufruf wird erst **nach Beendigung** der Methode ausgeführt
:::

```java
public class Traditional {
    public static void main(String... args) {
        Traditional x = new Traditional();

        System.out.println("main(): vor run()");
        x.run();
        System.out.println("main(): nach run()");
    }

    public void run() {
        IntStream.range(0, 10).mapToObj(i -> "in run()").forEach(System.out::println);
    }
}
```

[Demo: intro.Traditional]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/threads/src/intro/Traditional.java"}


::: notes
### Nebenläufige Programmierung
::::

::: slides
## Nebenläufige Programmierung
:::

::: notes
*   Erzeugung eines neuen Kontrollflussfadens (Thread)
    *   **Läuft (quasi-) parallel zu bisherigem Kontrollfluss**
*   Threads können unabhängig von einander arbeiten
*   Zustandsverwaltung durch Java-VM [(oder Unterstützung durch Betriebssystem)]{.notes}
    *   Aufruf einer bestimmten Methode erzeugt neuen Kontrollflussfaden
    *   Der neue Thread arbeitet "parallel" zum bisherigen Thread
    *   Kontrolle kehrt sofort wieder zurück: Code hinter dem Methodenaufruf
        wird ausgeführt ohne auf die Beendigung der aufgerufenen Methode zu
        warten
    *   Verteilung der Threads auf die vorhandenen Prozessorkerne abhängig
        von der Java-VM
:::

```java
public class Threaded extends Thread {
    public static void main(String... args) {
        Threaded x = new Threaded();

        System.out.println("main(): vor run()");
        x.start();
        System.out.println("main(): nach run()");
    }

    @Override
    public void run() {
        IntStream.range(0, 10).mapToObj(i -> "in run()").forEach(System.out::println);
    }
}
```

[Demo: intro.Threaded]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/threads/src/intro/Threaded.java"}


## Erzeugen von Threads

*   Ableiten von `Thread` oder Implementierung von `Runnable`

    ![](images/ThreadRunnable.png){width="80%"}

*   Methode `run()` implementieren, aber nicht aufrufen
*   Methode `start()` aufrufen, aber (i.d.R.) nicht implementieren

[Demo: creation.*]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/threads/src/creation/"}

::: notes
### Ableiten von _Thread_

*    `start()` startet den Thread und sorgt für Ausführung von `run()`
*    `start()` nur einmal aufrufen

### Implementierung von _Runnable_

*   Ebenfalls `run()` implementieren
*   Neues `Thread`-Objekt erzeugen, Konstruktor das eigene Runnable übergeben
*   Für Thread-Objekt die Methode `start()` aufrufen
    *   Startet den Thread (das Runnable) und sorgt für Ausführung von `run()`

Vorteil von `Runnable`: Ist ein Interface, d.h. man kann noch von einer anderen Klasse erben
:::


## Zustandsmodell von Threads (vereinfacht)

::: notes
Threads haben einen Lebenszyklus: Nach dem Erzeugen der Objekte mit `new` wird
der Thread noch nicht ausgeführt. Er ist sozusagen in einem Zustand "erzeugt".
Man kann bereits mit dem Objekt interagieren, also auf Attribute zugreifen und
Methoden aufrufen.

Durch den Aufruf der Methode `start()` gelangt der Thread in einen Zustand
"ausführungsbereit", er läuft also aus Nutzersicht. Allerdings hat er noch keine
Ressourcen zugeteilt (CPU, ...), so dass er tatsächlich noch nicht rechnet. Sobald
er vom Scheduler eine Zeitscheibe zugeteilt bekommt, wechselt er in den Zustand
"rechnend" und führt den Inhalt der `run()`-Methode aus. Von hier kann er nach
Ablauf der Zeitscheibe durch den Scheduler wieder nach "ausführungsbereit" zurück
überführt werden. Dieses Wechselspiel passiert automatisch und i.d.R. schnell,
so dass selbst auf Maschinen mit nur einem Prozessor/Kern der Eindruck einer parallelen
Verarbeitung entsteht.

Nach der Abarbeitung der `run()`-Methode oder bei einer nicht gefangenen Exception
wird der Thread beendet und kann nicht wieder neu gestartet werden. Auch wenn der
Thread abgelaufen ist, kann man mit dem Objekt wie üblich interagieren (nur eben
nicht mehr parallel).

Bei Zugriff auf gesperrte Ressourcen oder durch Aufrufe von Methoden wie `sleep()`
oder `join()` kann ein Thread blockiert werden. Hier führt der Thread nichts aus,
bekommt durch den Scheduler aber auch keine neue Zeitscheibe zugewiesen. Aus diesem
Zustand gelangt der Thread wieder heraus, etwa durch Interrupts (Aufruf der Methode
`interrupt()` auf dem Thread-Objekt) oder nach Ablauf der Schlafzeit (in `sleep()`)
oder durch ein `notify`, und wird wieder zurück nach "ausführungsbereit" versetzt
und wartet auf die Zuteilung einer Zeitscheibe durch den Scheduler.

Sie finden in [@Boles2008, Kapitel 5.2 "Thread-Zustände"] eine schöne
ausführliche Darstellung.
:::

\bigskip

### Threads können wie normale Objekte kommunizieren

*   Zugriff auf (`public`) Attribute [(oder eben über Methoden)]{.notes}
*   Aufruf von Methoden

\bigskip

### Threads können noch mehr

*   Eine Zeitlang schlafen: `Thread.sleep(<duration_ms>)`

    ::: notes
    *   Statische Methode der Klasse `Thread` (Klassenmethode)
    *   Aufrufender Thread wird bis zum Ablauf der Zeit oder bis zum Aufruf
        der `interrupt()`-Methode des Threads blockiert
    *   "Moderne" Alternative: `TimeUnit`, beispielsweise `TimeUnit.SECONDS.sleep( 2 );`
    :::

*   Prozessor abgeben und hinten in Warteschlange einreihen: `yield()`

*   Andere Threads stören: `otherThreadObj.interrupt()`

    ::: notes
    *   Die Methoden `sleep()`, `wait()` und `join()` im empfangenden Thread
        `otherThreadObj` lösen eine `InterruptedException` aus, wenn sie
        durch die Methode `interrupt()` unterbrochen werden. Das heißt,
        `interrupt()` beendet diese Methoden mit der Ausnahme.
    *   Empfangender Thread verlässt ggf. den Zustand "blockiert" und wechselt
        in den Zustand "ausführungsbereit"
    :::

*   Warten auf das Ende anderer Threads: `otherThreadObj.join()`

    ::: notes
    *   Ausführender Thread wird blockiert (also nicht `otherThreadObj`!)
    *   Blockade des Aufrufers wird beendet, wenn der andere Thread
        (`otherThreadObj`) beendet wird.
    :::

\bigskip

::: notes
_Hinweis:_ Ein Thread wird beendet, wenn

*   die `run()`-Methode normal endet, oder
*   die `run()`-Methode durch eine nicht gefangene Exception beendet wird, oder
*   von außen die Methode `stop()` aufgerufen wird (Achtung: Deprecated!
    Einen richtigen Ersatz gibt es aber auch nicht.).

_Hinweis:_ Die Methoden `wait()`, `notify()`/`notifyAll()` und die "`synchronized`-Sperre"
werden in der Sitzung `["Threads: Synchronisation"]({{< ref "/threads/intro" >}})`{=markdown}
besprochen.
:::

\vspace{24mm}

[Demo: intro.Join]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/threads/src/intro/Join.java"}


## Wrap-Up

Threads sind weitere Kontrollflussfäden, von Java-VM (oder (selten) von OS) verwaltet

\bigskip

*   Ableiten von `Thread` oder implementieren von `Runnable`
*   Methode `run` enthält den auszuführenden Code
*   Starten des Threads mit `start` (nie mit `run`!)







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
