---
type: lecture-cg
title: "Synchronisation: Verteilter Zugriff auf gemeinsame Ressourcen"
menuTitle: "Synchronisation"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
readings:
  - key: "Ullenboom2021"
    comment: "Kap. 16: Einführung in die nebenläufige Programmierung"
  - key: "Java-SE-Tutorial"
    comment: "Trail: Essential Java Classes, Lesson: Concurrency"
  - key: "Boles2008"
tldr: |
    Synchronisierungsbedarf bei verteiltem Zugriff auf gemeinsame Ressourcen:

    *   Vorsicht mit konkurrierendem Ressourcenzugriff: Synchronisieren mit
        `synchronize` => **Mehrseitige Synchronisierung**
    *   Warten auf Ereignisse mit `wait` und `notifyAll` => **Einseitige Synchronisierung**
outcomes:
  - k2: "Notwendigkeit zur Synchronisation"
  - k2: "Unterscheidung einseitige und mehrseitige Synchronisation"
  - k3: "Synchronisation mit `synchronize`, `wait` und `notifyAll`"
quizzes:
  - link: ""
    name: "Quiz Threads Synchronisation (ILIAS)"
assignments:
  - topic: sheet10
youtube:
  - link: ""
    name: "VL Threads Synchronisation"
  - link: ""
    name: "Demo Threads Synchronisation"
  - link: ""
    name: "Demo Threads Synchronisation"
fhmedia:
  - link: ""
    name: "VL Threads Synchronisation"
---


## Verteilter Zugriff auf gemeinsame Ressourcen: Mehrseitige Synchronisierung

\bigskip

[Demo synchronised.MultiThreadKaputt]{.bsp}

\pause

```java
synchronized (<Object reference>) {
    <statements (synchronized)>
}
```

\bigskip

=> [**"Mehrseitige Synchronisierung"**]{.alert}

::: notes
Fallunterscheidung: Thread T1 führt `synchronized`-Anweisung aus:

*   Sperre im Sperr-Objekt nicht gesetzt:
    1.  T1 setzt Sperre beim Eintritt,
    2.  führt den Block aus, und
    3.  löst Sperre beim Verlassen

*   Sperre durch T1 gesetzt:
    1.  T1 führt den Block aus, und
    2.  löst Sperre beim Verlassen **nicht**

*   Sperre durch T2 gesetzt:
    => T1 wird blockiert, bis T2 die Sperre löst
:::

[Demo synchronised.MultiThreadObjSync]{.bsp}


## Synchronisierte Methoden

:::::: columns
:::{.column width="40%"}
```java
void f() {
    synchronized (this) {
        ...
    }
}
```
:::
:::{.column width="5%"}
<!-- XXX zur Formatierung auf den Folien -->
::: slides
\bigskip
\bigskip
=>
:::
[...  ist äquivalent zu ...]{.notes}
:::
:::{.column width="40%"}
```java
synchronized void f() {
    ...
}
```
:::
::::::

::: notes
Kurzschreibweise: Man spart das separate Wächter-Objekt und synchronisiert auf sich selbst ...

[Beispiel: synchronised.MultiThreadMethodSync]{.bsp}
:::


## Probleme bei der (mehrseitigen) Synchronisierung: Deadlocks

TODO! Bild! / Code!

[Quelle: [@Ullenboom2012], Abschnitt 14.5.12 "Deadlocks"]{.origin}

::: notes
Viel hilft hier nicht viel! Durch zu großzügige mehrseitige Synchronisierung
kann es passieren, dass Threads gegenseitig aufeinander warten: Thread A belegt
eine Ressource, die ein anderer Thread B haben möchte und Thread B belegt eine
Ressource, die A gerne bekommen würde. Da es dann nicht weitergeht, nennt man
diese Situation auch "Deadlock" ("Verklemmung").

Im Beispiel ruft der erste Thread für das Objekt `alphonse` die `bow` -Methode
auf und holt sich damit den Lock auf `alphonse`. Um die Methode beenden zu
können, muss noch die `bowBack` -Methode vom Objekt `gaston` durch diesen ersten
Thread aufgerufen werden. Dafür muss der erste Thread den Lock auf `gaston`
bekommen.

Dummerweise hat parallel der zweite Thread auf dem Objekt `gaston` die
`bow`-Methode aufgerufen und sich damit den Lock auf `gaston` geholt. Damit
muss der erste Thread so lange warten, bis der zweite Thread den Lock auf
`gaston` freigibt.

Das wird allerdings nicht passieren, da der zweite Thread zur Beendigung der
`bow`-Methode noch `bowBack` auf `alphonse` ausführen muss und dazu den Lock
auf `alphonse` holen, den aber aktuell der erste Thread hält.

Und schon geht's nicht mehr weiter :-)
:::

TODO Code
[Demo synchronised.Deadlock]{.bsp}


## Warten auf andere Threads: Einseitige Synchronisierung

TODO Bild! / Code!

[Quelle: [@Ullenboom2012], Abschnitt 14.6 "Synchronisation über Warten und Benachrichtigen"]{.origin}

::: notes
### Problem

*   Thread T1 wartet auf Arbeitsergebnis von T2
*   T2 ist noch nicht fertig

### Mögliche Lösungen

*   Aktives Warten (Polling): Permanente Abfrage
    *   Kostet unnötig Rechenzeit
*   Schlafen mit `Thread.sleep()`
    *   Etwas besser; aber wie lange soll man idealerweise schlafen?
*   Warten mit `join()`
    *   Macht nur Sinn, wenn T1 auf das Ende von T2 wartet
*   Einseitige Synchronisierung mit `wait()` und `notifyAll()`
    *   Das ist DIE Lösung für das Problem :)
:::


## Einseitige Synchronisierung mit _wait_ und _notify_

*   [**wait**]{.alert}: Warten auf Erfüllung einer Bedingung (Thread blockiert):

    \bigskip

    ```java
    synchronized (obj) {    // Geschützten Bereich betreten
        while (!condition) {
            try {
                obj.wait(); // Thread wird blockiert
            } catch (InterruptedException e) {}
        }
        ...     // Condition erfüllt: Tue Deine Arbeit
    }
    ```

    \bigskip

    => Bedingung nach Rückkehr von `wait` erneut prüfen!

::: notes
### Eigenschaften von _wait_

*   Thread ruft auf Synchronisations-Objekt die Methode `wait` auf
*   Prozessor wird entzogen, Thread blockiert
*   Thread wird in interne Warteschlange des Synchronisations-Objekts eingetragen
*   Sperre auf Synchronisations-Objekt wird freigegeben

=> Geht nur innerhalb der `synchronized`-Anweisung für das Synchronisations-Objekt!
:::


## Einseitige Synchronisierung mit _wait_ und _notify_ (cnt.)

*   [**notify**]{.alert}: Aufwecken von wartenden (blockierten) Threads:

    \bigskip

    ```java
    synchronized (obj) {
        obj.notify();       // einen Thread "in" obj aufwecken
        obj.notifyAll();    // alle Threads "in" obj wecken
    }
    ```

::: notes
### Eigenschaften von _notify_ bzw. _notifyAll_

*   Thread ruft auf einem Synchronisations-Objekt die Methode `notify`
    oder `notifyAll` auf
*   Falls Thread(s) in Warteschlange des Objekts vorhanden, dann
    *   `notify`: Ein *zufälliger* Thread wird aus Warteschlange entfernt und
        in den Zustand "rechenwillig" versetzt
    *   `notifyAll`: Alle Threads werden aus Warteschlange entfernt und in
        den Zustand "rechenwillig" versetzt

=> Geht nur innerhalb der `synchronized`-Anweisung für das Synchronisations-Objekt!
:::


## Wrap-Up

Synchronisierungsbedarf bei verteiltem Zugriff auf gemeinsame Ressourcen:

*   Vorsicht mit konkurrierendem Ressourcenzugriff: Synchronisieren mit
    `synchronize` => **Mehrseitige Synchronisierung**
*   Warten auf Ereignisse mit `wait` und `notifyAll` => **Einseitige Synchronisierung**







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
