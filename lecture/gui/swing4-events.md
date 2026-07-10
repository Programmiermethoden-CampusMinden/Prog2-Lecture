# Swing 4: Events

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> In Swing-Komponenten werden Events ausgelöst, wenn der User mit den
> Komponenten interagiert.
>
> Zur Bearbeitung der Events kann man Listener bei den Komponenten
> registrieren, die bei Auftreten eines Events benachrichtigt werden
> (Observer-Pattern: Die Observer werden in Swing "Listener" genannt).
>
> Es gibt für alle möglichen Formen von Interaktion mit Komponenten
> vordefinierte Interfaces für die Event-Listener. Da man hier wie
> üblich immer alle Methoden implementieren muss, selbst wenn man nur
> auf wenige Events reagieren möchte, gibt es zusätzlich sogenannte
> "Adapter": Dies sind Klassen, die das jeweilige
> Event-Listener-Interface mit leeren Methodenrümpfen implementieren.
> Bei Nutzung der Adapter-Klassen müssen dann nur noch die benötigten
> Methoden überschrieben werden.
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> Vorlesung \[[YT](https://youtu.be/TuL8NUQfKWo)\],
> \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-swing-4-events/b2f0f0ca1af3969dc3ff2ff4a20c2b8c)\]
>
> Demos:
>
> -   Swing Events und Listener \[[YT](https://youtu.be/gR6uHmMG4rk)\],
>     \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-demo-swing-events-und-listener/fcbd66f8c1cdf3e0e4f0f76bc4d1ffb9)\]
> -   MouseListener vs. MouseAdapter
>     \[[YT](https://youtu.be/8GGUpSOFWjE)\],
>     \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-demo-swing-mouselistener-vs-mouseadapter/c7633620d72a1eee218d99995d5fd14d)\]
>
> </details>

## Reaktion auf Events: Anwendung Observer-Pattern

-   Swing-GUI läuft in Dauerschleife
-   Komponenten registrieren Ereignisse (Events):
    -   Mausklick
    -   Tastatureingaben
    -   Mauszeiger über Komponente
    -   ...
-   Reaktion mit passendem Listener: Observer Pattern!

<p align="center"><picture><source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/gui/images/ActionListener_inv.png" /><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/gui/images/ActionListener.png" width="80%" /></picture></p>

=\> Observer aus dem Observer-Pattern!

In Swing werden die "Observer" als "Listener" bezeichnet.

``` java
component.addActionListener(ActionListener);
component.addMouseListener(MouseListener);
```

## Arten von Events

<p align="center"><picture><source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/gui/images/EventListener_inv.png" /><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/gui/images/EventListener.png" width="80%" /></picture></p>

Es gibt für alle möglichen Input-Arten eine Ableitung von
`java.util.EventListener`, beispielsweise für Maus- oder
Tastaturereignisse oder wenn ein Element den Fokus bekommt und viele
weitere.

## Details zu Listenern

-   Ein Listener kann bei mehreren Observables registriert sein:

    ``` java
    Handler single = new Handler();
    singleButton.addActionListener(single);
    multiButton.addActionListener(single);
    ```

-   Ein Observable kann mehrere Listener bedienen:

    ``` java
    multiButton.addActionListener(new Handler());
    multiButton.addActionListener(new Handler());
    ```

-   Sequentielles Abarbeiten der Events bzw. Benachrichtigung der
    Observer

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/events/ListenerDemo.java">Demo: events.ListenerDemo</a></p>

## Wie komme ich an die Daten eines Events?

<p align="center"><picture><source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/gui/images/EventObject_inv.png" /><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/gui/images/EventObject.png" width="80%" /></picture></p>

**Event-Objekte**: Quelle des Events plus aufgetretene Daten

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/events/MouseListenerDemo.java">Demo: events.MouseListenerDemo</a></p>

## Listener vs. Adapter

-   Vielzahl möglicher Events
-   Jeweils passendes Event-Objekt u. Event-Listener-Interface
-   Oft nur wenige Methoden, u.U. aber viele Methoden

=\> Bei Nutzung eines Event-Listeners müssen immer **alle** Methoden
implementiert werden (auch nicht benötigte)!

Abhilfe: **Adapter**-Klassen:

-   Für viele Event-Listener-Interfaces existieren Adapter-Klassen
-   Implementieren jeweils ein Interface
-   Alle Methoden mit **leerem** Body vorhanden

=\> Nur benötigte Listener-Methoden überschreiben.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/gui/src/events/MouseAdapterDemo.java">Demo: events.MouseAdapterDemo</a></p>

## Exkurs: Nützliches zu Swing

Über Swing wurde prinzipiell bereits im ersten Semester gesprochen,
deshalb wird hier in Prog2 nur der Zusammenhang mit dem
[Observer-Pattern](../pattern/observer.md) hergestellt.

Wenn Sie Ihr Wissen zu Swing auffrischen wollen, hier vier nützliche
Sessions zu Swing:

-   [Swing Basics](./swing1-basics.md)
-   [Nützliche Widgets](./swing2-widgets.md)
-   [Layouts und -Manager](./swing3-layouts.md)
-   [Java2D](./swing6-java2d.md)

## Wrap-Up

Observer-Pattern in Swing-Komponenten:

-   Events: Enthalten Source-Objekt und Informationen
-   Event-Listener: Interfaces mit Methoden zur Reaktion
-   Adapter: Listener mit leeren Methodenrümpfen

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> Zum Thema Swing Events können Sie im Tutorial ["Lesson: Writing Event
> Listeners"
> (Oracle)](https://docs.oracle.com/javase/tutorial/uiswing/events/index.html)
> nachlesen.
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Unterschied zwischen den Listenern und den entsprechenden
>     Adaptern
> -   k3: Anwendung des Observer-Pattern, beispielsweise als Listener in
>     Swing, aber auch in eigenen Programmen
> -   k3: Nutzung von ActionListener, MouseListener, KeyListener,
>     FocusListener
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> d78e242 2026-04-27 swing4: rework readings<br></sub></sup></p></blockquote>
