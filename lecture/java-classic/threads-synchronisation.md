---
author: Carsten Gips (HSBI)
title: "Threads: Synchronisation: Verteilter Zugriff auf gemeinsame Ressourcen"
---

::: tldr
Bei verteiltem Zugriff auf gemeinsame Ressourcen besteht Synchronisierungsbedarf,
insbesondere sollten nicht mehrere Threads gleichzeitig geteilte Daten modifizieren.
Dazu kommt das Problem, dass ein Thread in einer komplexen Folge von Aktionen die
Zeitscheibe verlieren kann und dann später mit veralteten Daten weiter macht.

Um den Zugriff auf gemeinsame Ressourcen oder den Eintritt in kritische Bereiche zu
schützen und zu synchronisieren, kann man diese Zugriffe oder Bereiche in einen
`synchronized`-Block legen. Dazu benötigt man noch ein beliebiges (gemeinsam
sichtbares) Objekt, welches als Wächter- oder Sperr-Objekt fungiert. Beim Eintritt
in den geschützten Block muss ein Thread einen Lock auf dem Sperr-Objekt erlangen.
Hat bereits ein anderer Thread den Lock, wird der neue Thread so lange blockiert,
bis der Lock wieder "frei" ist. Beim Eintritt in den Bereich wird dann durch den
Thread auf dem Sperr-Objekt der Lock gesetzt und beim Austritt automatisch wieder
aufgehoben. Dies nennt man auch **mehrseitige Synchronisierung** (mehrere Threads
"stimmen" sich quasi untereinander über den Zugriff auf eine Ressource ab).

Um auf den Eintritt eines Ereignisses oder die Erfüllung einer Bedingung zu warten,
kann man `wait` und `notify` nutzen. In einem `synchronized`-Block prüft man, ob die
Bedingung erfüllt oder ein Ereignis eingetreten ist, und falls ja arbeitet man damit
normal weiter. Falls die Bedingung nicht erfüllt ist oder das Ereignis nicht
eingetreten ist, kann man auf dem im `synchronized`-Block genutzten Sperr-Objekt die
Methode `wait()` aufrufen. Damit wird der Thread in die entsprechende Schlange auf
dem Sperr-Objekt eingereiht und blockiert. Zusätzlich wird der Lock auf dem
Sperr-Objekt freigegeben. Zum "Aufwecken" nutzt man an geeigneter Stelle auf dem
**selben Sperr-Objekt** die Methode `notify()` oder `notifyALl()` (erstere weckt
einen in der Liste des Sperr-Objekts wartenden Thread, die letztere alle). Nach dem
Aufwachen macht der Thread nach seinem `wait()` weiter. Es ist also wichtig, dass
die Bedingung, wegen der ursprünglich das `wait()` aufgerufen wurde, erneut
abgefragt wird und ggf. erneut in das `wait()` gegangen wird. Dies nennt man
**einseitige Synchronisierung**.

Es gibt darüber hinaus viele weitere Mechanismen und Probleme, die aber den Rahmen
dieser Lehrveranstaltung deutlich übersteigen. Diese werden teilweise in den
Veranstaltungen "Betriebssysteme" und/oder "Verteilte Systeme" besprochen.
:::

::: youtube
-   [VL Threads Synchronisation](https://youtu.be/FtVaobn4NqA)
-   [Demo Teaser: Falscher Zugriff auf gemeinsame
    Ressourcen](https://youtu.be/SB1ngVkQdLM)
-   [Demo Mehrseitige Synchronisation (Sperr-Objekt, synchronisierte
    Methode)](https://youtu.be/YTV-oT-vmpE)
-   [Demo Mehrseitige Synchronisation: Deadlock](https://youtu.be/D4B5xHqCZ-0)
-   [Demo Einseitige Synchronisation](https://youtu.be/akCl01ZAaGo)
:::

# Motivation: Verteilter Zugriff auf gemeinsame Ressourcen

``` java
public class Teaser implements Runnable {
    private int val = 0;

    public static void main(String... args) {
        Teaser x = new Teaser();
        new Thread(x).start();
        new Thread(x).start();
    }

    private void incrVal() {
        ++val;
        System.out.println(Thread.currentThread().getId() + ": " + val);
    }

    public void run() {
        IntStream.range(0, 5).forEach(i -> incrVal());
    }
}
```

[Demo: synchronised.Teaser]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/Teaser.java"}

# Zugriff auf gemeinsame Ressourcen: Mehrseitige Synchronisierung

``` java
synchronized (<Object reference>) {
    <statements (synchronized)>
}
```

\bigskip

=\> **"Mehrseitige Synchronisierung"**

::: notes
Fallunterscheidung: Thread T1 führt `synchronized`-Anweisung aus:

-   Sperre im Sperr-Objekt nicht gesetzt:
    1.  T1 setzt Sperre beim Eintritt,
    2.  führt den Block aus, und
    3.  löst Sperre beim Verlassen
-   Sperre durch T1 gesetzt:
    1.  T1 führt den Block aus, und
    2.  löst Sperre beim Verlassen **nicht**
-   Sperre durch T2 gesetzt: =\> T1 wird blockiert, bis T2 die Sperre löst

*Anmerkung*: Das für die Synchronisierung genutzte Objekt nennt man "Wächter-Objekt"
oder auch "Sperr-Objekt" oder auch "Synchronisations-Objekt".
:::

\pause
\bigskip

::: notes
Damit könnte man den relevanten Teil der Methode `incrVal()` beispielsweise in einen
geschützten Bereich einschließen und als Sperr-Objekt das eigene Objekt (`this`)
einsetzen:
:::

``` java
    private void incrVal() {
        synchronized (this) { ++val; }
    }
```

[Demo: synchronised.ObjSync]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/ObjSync.java"}

# Synchronisierte Methoden

::::::: columns
::: {.column width="40%"}
``` java
void f() {
    synchronized (this) {
        ...
    }
}
```
:::

:::: {.column width="5%"}
<!-- XXX zur Formatierung auf den Folien -->

::: slides
\bigskip
\bigskip

=\>
:::

[... ist äquivalent zu ...]{.notes}
::::

::: {.column width="40%"}
``` java
synchronized void f() {
    ...
}
```
:::
:::::::

::: notes
Kurzschreibweise: Man spart das separate Wächter-Objekt und synchronisiert auf sich
selbst ...
:::

\pause
\bigskip

::: notes
Die Methode `incrVal()` könnte entsprechend so umgeschrieben werden:
:::

``` java
    private synchronized void incrVal() {
        ++val;
    }
```

[Demo: synchronised.MethodSync]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/MethodSync.java"}

# Probleme bei der (mehrseitigen) Synchronisierung: Deadlocks

``` java
public class Deadlock {
    private final String name;

    public synchronized String getName() { return name; }
    public synchronized void foo(Deadlock other) {
        System.out.format("%s: %s.foo() \n", Thread.currentThread().getName(), name);
        System.out.format("%s: %s.name()\n", Thread.currentThread().getName(), other.getName());
    }

    public static void main(String... args) {
        final Deadlock a = new Deadlock("a");
        final Deadlock b = new Deadlock("b");

        new Thread(() -> a.foo(b)).start();
        new Thread(() -> b.foo(a)).start();
    }
}
```

::: notes
Viel hilft hier nicht viel! Durch zu großzügige mehrseitige Synchronisierung kann es
passieren, dass Threads gegenseitig aufeinander warten: Thread A belegt eine
Ressource, die ein anderer Thread B haben möchte und Thread B belegt eine Ressource,
die A gerne bekommen würde. Da es dann nicht weitergeht, nennt man diese Situation
auch "Deadlock" ("Verklemmung").

Im Beispiel ruft der erste Thread für das Objekt `a` die `foo()`-Methode auf und
holt sich damit den Lock auf `a`. Um die Methode beenden zu können, muss noch die
`getName()`-Methode vom Objekt `b` durch diesen ersten Thread aufgerufen werden.
Dafür muss der erste Thread den Lock auf `b` bekommen.

Dummerweise hat parallel der zweite Thread auf dem Objekt `b` die `foo()`-Methode
aufgerufen und sich damit den Lock auf `b` geholt. Damit muss der erste Thread so
lange warten, bis der zweite Thread den Lock auf `b` freigibt.

Das wird allerdings nicht passieren, da der zweite Thread zur Beendigung der
`foo()`-Methode noch `getName()` auf `a` ausführen muss und dazu den Lock auf `b`
holen, den aber aktuell der erste Thread hält.

Und schon geht's nicht mehr weiter :-)
:::

[Demo: synchronised.Deadlock]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/Deadlock.java"}

# Warten auf andere Threads: Einseitige Synchronisierung

## Problem

-   Thread T1 wartet auf Arbeitsergebnis von T2
-   T2 ist noch nicht fertig

\bigskip

## Mögliche Lösungen

1.  Aktives Warten (Polling): Permanente Abfrage
    -   Kostet unnötig Rechenzeit
2.  Schlafen mit `Thread.sleep()`
    -   Etwas besser; aber wie lange soll man idealerweise schlafen?
3.  Warten mit `T2.join()`
    -   Macht nur Sinn, wenn T1 auf das *Ende* von T2 wartet
4.  **Einseitige Synchronisierung** mit `wait()` und `notify()`
    -   Das ist DIE Lösung für das Problem :)

# Einseitige Synchronisierung mit *wait* und *notify*

-   **wait**: Warten auf Erfüllung einer Bedingung (Thread blockiert):

    \bigskip

    ``` java
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

    =\> Bedingung nach Rückkehr von `wait` erneut prüfen!

::: notes
## Eigenschaften von *wait*

-   Thread ruft auf Synchronisations-Objekt die Methode `wait` auf
-   Prozessor wird entzogen, Thread blockiert
-   Thread wird in interne Warteschlange des Synchronisations-Objekts eingetragen
-   Sperre auf Synchronisations-Objekt wird freigegeben

=\> Geht nur innerhalb der `synchronized`-Anweisung für das Synchronisations-Objekt!
:::

# Einseitige Synchronisierung mit *wait* und *notify* (cnt.)

-   **notify**: Aufwecken von wartenden (blockierten) Threads:

    \bigskip

    ``` java
    synchronized (obj) {
        obj.notify();       // einen Thread "in" obj aufwecken
        obj.notifyAll();    // alle Threads "in" obj wecken
    }
    ```

::: notes
## Eigenschaften von *notify* bzw. *notifyAll*

-   Thread ruft auf einem Synchronisations-Objekt die Methode `notify` oder
    `notifyAll` auf
-   Falls Thread(s) in Warteschlange des Objekts vorhanden, dann
    -   `notify`: Ein *zufälliger* Thread wird aus Warteschlange entfernt und in den
        Zustand "ausführungsbereit" versetzt
    -   `notifyAll`: Alle Threads werden aus Warteschlange entfernt und in den
        Zustand "ausführungsbereit" versetzt

=\> Geht nur innerhalb der `synchronized`-Anweisung für das Synchronisations-Objekt!
:::

[Demo: synchronised.Staffel]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/Staffel.java"}

# Wrap-Up

Synchronisierungsbedarf bei verteiltem Zugriff auf gemeinsame Ressourcen:

\bigskip
\smallskip

-   Vorsicht mit konkurrierendem Ressourcenzugriff: `\newline`{=tex} Synchronisieren
    mit `synchronized` =\> **Mehrseitige Synchronisierung**

\smallskip

-   Warten auf Ereignisse mit `wait` und `notify`/`notifyAll` =\> **Einseitige
    Synchronisierung**

::: readings
-   @Java-SE-Tutorial
-   @Boles2008
:::

::: outcomes
-   k2: Ich kann die Notwendigkeit zur Synchronisation erklären
-   k2: Ich kann den Unterschied zwischen einseitiger und mehrseitiger
    Synchronisation erklären
-   k3: Ich kann die Synchronisation mit synchronized, wait, notify und notifyAll
    praktisch einsetzen
:::

::: challenges
**Hamster-Welt**

In den
[Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/challenges/threads)
finden Sie eine Modellierung für eine Hamsterwelt.

Es gibt rote und blaue Hamster, die sich unabhängig von einander bewegen können. Es
gibt einen Tunnel, den die Hamster betreten und durchqueren können. In der Vorgabe
ist ein kleines Hauptprogramm enthalten, welches einige Hamster anlegt und
herumlaufen lässt.

**Teil I: Stau im Tunnel**

Die Hamster sind sehr neugierig und wollen gern durch den Tunnel gehen, um die Höhle
auf der anderen Seite zu erkunden. Leider mussten sie feststellen, dass immer nur
ein Hamster zu einem Zeitpunkt im Tunnel sein darf, sonst wird die Luft zu knapp.

Ergänzen Sie die Vorgaben, so dass sich immer nur ein paralleler Hamster (egal
welcher Farbe) im Tunnel aufhalten kann. Wenn ein Hamster in den Tunnel will, aber
nicht hinein kann, dann soll er am Eingang warten, also nicht noch einmal in seiner
Höhle herumlaufen. (Das passiert eigentlich automatisch, wenn Sie alles richtig
machen.)

<!-- XXX
Mehrseitige Synchronisierung auf das gemeinsame Tunnel-Objekt -- von Ein- bis Austritt
Hamster: `synchronized (tunnel()) { moveThroughTunnel(); }`
-->

**Teil II: Schlaue Hamster**

Die Hamster sind schlau und haben bemerkt, dass die Einschränkung aus der letzten
Aufgabe zu stark war. Sie überleben auch, wenn sich beliebig viele blaue Hamster
oder nur genau ein roter Hamster im Tunnel aufhalten.

Erweitern Sie die Implementierung aus der letzten Aufgabe, so dass folgende
Bedingungen eingehalten werden:

-   Es dürfen sich beliebig viele blaue Hamster gleichzeitig im Tunnel befinden.

    Das bedeutet, dass in diesem Fall zwar weitere blaue Hamster den Tunnel betreten
    dürfen, aber kein roter Hamster in den Tunnel hinein darf.

-   Wenn sich ein roter Hamster im Tunnel aufhält, dürfen keine anderen Hamster
    (unabhängig von deren Farbe) den Tunnel betreten.

<!-- XXX
Einseitige Synchronisierung auf Tunnel -- Ein- und Austritt, zusätzlich wait/notifyAll
Tunnel muss zwei Listen führen, auf denen die jeweiligen Hamster `wait` bzw. `notifyAll` aufrufen
-->
<!--
Lösung siehe https://github.com/Programmiermethoden-CampusMinden/prog2_intern_solutions/tree/solution_challenge_multithreading/src/main/java/threads
-->
:::
