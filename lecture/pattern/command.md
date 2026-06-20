---
author: Carsten Gips (HSBI)
title: Command-Pattern
---

::: tldr
Das **Command-Pattern** ist die objektorientierte Antwort auf Callback-Funktionen:
Man kapselt Befehle in einem Objekt.

Ziel: Eingaben/Aktionen entkoppeln und konfigurierbar machen (und optional "Undo").

1.  Die `Command`-Objekte haben eine Methode `execute()` und führen dabei eine
    Aktion auf einem bzw. "ihrem" Receiver aus.

2.  `Receiver` sind Objekte, auf denen Aktionen ausgeführt werden, im Dungeon
    könnten dies etwa Hero, Monster, ... sein. Receiver müssen keine der anderen
    Akteure in diesem Pattern kennen.

3.  Damit die `Command`-Objekte aufgerufen werden, gibt es einen `Invoker`, der
    `Command`-Objekte hat und zu gegebener Zeit auf diesen die Methode `execute()`
    aufruft. Der Invoker muss dabei die konkreten Kommandos und die Receiver nicht
    kennen (nur die `Command`-Schnittstelle).

4.  Zusätzlich gibt es einen `Client`, der die anderen Akteure kennt und alles
    zusammenbaut.
:::

::: youtube
Vorlesung \[[YT](https://youtu.be/bvsmpVHKtNU)\],
\[[HSBI](https://www.hsbi.de/medienportal/video/pr2-command-pattern/e3f939297cc131a7db2716c47d98491d)\]
:::

# Motivation

::: notes
Irgendwo im Dungeon wird es ein Objekt einer Klasse ähnlich wie `InputHandler` geben
mit einer Methode ähnlich zu `handleInput()`:
:::

``` java
public class InputHandler {
    public void handleInput() {
        switch (keyPressed()) {
            case BUTTON_W -> hero.jump();
            case BUTTON_A -> hero.moveX();
            case ...
            default -> { ... }
        }
    }
}
```

::: notes
Diese Methode wird je Frame einmal aufgerufen, um auf eventuelle Benutzereingaben
reagieren zu können. Je nach gedrücktem Button wird auf dem Hero eine bestimmte
Aktion ausgeführt ...

Das funktioniert, ist aber recht unflexibel. Die Aktionen sind den Buttons fest
zugeordnet und erlauben keinerlei Konfiguration.
:::

[[Problem: Starre Zuordnung]{.ex}]{.slides}

# Auflösen der starren Zuordnung über Zwischenobjekte

``` java
public interface Command { void execute(); }

public class Jump implements Command {
    private Entity e;
    public void execute() { e.jump(); }
}

public class InputHandler {
    private final Command wbutton = new Jump(hero);  // Über Ctor/Methoden setzen!
    private final Command abutton = new Move(hero);  // Über Ctor/Methoden setzen!

    public void handleInput() {
        switch (keyPressed()) {
            case BUTTON_W -> wbutton.execute();
            case BUTTON_A -> abutton.execute();
            case ...
            default -> { ... }
        }
    }
}
```

::: notes
Die starre Zuordnung "Button : Aktion" wird durch das Command-Pattern aufgelöst und
über Zwischenobjekte konfigurierbar gemacht.

Für die Zwischenobjekte wird ein Typ `Command` eingeführt, der nur eine
`execute()`-Methode hat. Für jede gewünschte Aktion wird eine Klasse davon
abgeleitet, diese Klassen können auch einen Zustand pflegen.

Den Buttons wird nun an geeigneter Stelle (Konstruktor, Methoden, ...) je ein Objekt
der jeweiligen Command-Unterklassen zugeordnet. Wenn ein Button betätigt wird, wird
auf dem Objekt die Methode `execute()` aufgerufen.

Damit die Kommandos nicht nur auf den Helden wirken können, kann man den
Kommando-Objekten beispielsweise noch eine Entität mitgeben, auf der das Kommando
ausgeführt werden soll. Im Beispiel oben wurde dafür der `hero` genutzt.
:::

# Command: Objektorientierte Antwort auf Callback-Funktionen

![](images/command.png){web_width="80%"}

:::: notes
Im Command-Pattern gibt es vier beteiligte Parteien: Client, Receiver, Command und
Invoker.

Ein Command ist die objektorientierte Abstraktion eines Befehls. Es hat
möglicherweise einen Zustand, und kennt "seinen" Receiver und kann beim Aufruf der
`execute()`-Methode eine vorher verabredete Methode auf diesem Receiver-Objekt
ausführen.

Ein Receiver ist eine Klasse, die Aktionen durchführen kann. Sie kennt die anderen
Akteure nicht.

Der Invoker (manchmal auch "Caller" genannt) ist eine Klasse, die Commands
aggregiert und die die Kommandos "ausführt", indem hier die `execute()`-Methode
aufgerufen wird. Diese Klasse kennt nur das `Command`-Interface und keine
spezifischen Kommandos (also keine der Sub-Klassen). Es kann zusätzlich eine gewisse
Buchführung übernehmen, etwa um eine Undo-Funktionalität zu realisieren.

Der Client ist ein Programmteil, der die Command-Objekte aufbaut und dabei einen
passenden Receiver übergibt und der die Command-Objekte dann zum Aufruf an den
Invoker weiterreicht.

In unserem Beispiel lassen sich die einzelnen Teile so sortieren:

-   Client: Klasse `InputHandler` (erzeugt neue `Command`-Objekte im obigen Code)
    bzw. `main()`, wenn man die `Command`-Objekte dort erstellt und an den
    Konstruktor von `InputHandler` weiterreicht
-   Receiver: Objekt `hero` der Klasse `Hero` (auf diesem wird eine Aktion
    ausgeführt)
-   Command: `Jump` und `Move`
-   Invoker: `InputHandler` (in der Methode `handleInput()`)

::: tip
**Client** = die Stelle, wo verkabelt wird (z.B. `main`), **Invoker** = Ausführen
der Commands.

Die Rollen dürfen in der Praxis zusammenfallen: Eine Klasse kann mehrere Rollen
übernehmen; hier in unserem Beispiel ist der `InputHandler` zugleich `Client` und
`Invoker`.
:::
::::

# Undo

::: notes
Wir könnten das `Command`-Interface um ein paar Methoden erweitern:

``` java
public interface Command {
    void execute();
    void undo();
    Command newCmd(Entity e);
}
```

Jetzt kann jedes Command-Objekt eine neue Instanz erzeugen mit der Entity, die dann
dieses Kommando empfangen soll:
:::

``` java
public class Move implements Command {
    private Entity e;
    private int x, y, oldX, oldY;

    public void execute() { oldX = e.getX();  oldY = e.getY();  x = oldX + 42;  y = oldY;  e.moveTo(x, y); }
    public void undo() { e.moveTo(oldX, oldY); }
    public Command newCmd(Entity e) { return new Move(e); }
}

public class InputHandler {
    private final Command wbutton;
    private final Command abutton;
    private final Deque<Command> s = new ArrayDeque<>();

    public void handleInput() {
        Entity e = getSelectedEntity();
        switch (keyPressed()) {
            case BUTTON_W -> { s.push(wbutton.newCmd(e)); s.peek().execute(); }
            case BUTTON_A -> { s.push(abutton.newCmd(e)); s.peek().execute(); }
            case BUTTON_U -> s.pop().undo();
            case ...
            default -> { ... }
        }
    }
}
```

::: notes
Über den Konstruktor von `InputHandler` (im Beispiel nicht gezeigt) würde man wie
vorher die `Command`-Objekte für die Buttons setzen. Es würde aber in jedem Aufruf
von `handleInput()` abgefragt, was gerade die selektierte Entität ist und für diese
eine neue Instanz des zur Tastatureingabe passenden `Command`-Objekts erzeugt.
Dieses wird nun in einem Stack gespeichert und danach ausgeführt.

Wenn der Button "U" gedrückt wird, wird das letzte `Command`-Objekt aus dem Stack
genommen (Achtung: Im echten Leben müsste man erst einmal schauen, ob hier noch was
drin ist!) und auf diesem die Methode `undo()` aufgerufen. Für das Kommando `Move`
ist hier skizziert, wie ein Undo aussehen könnte: Man muss einfach bei jedem
`execute()` die alte Position der Entität speichern, dann kann man sie bei einem
`undo()` wieder auf diese Position verschieben. Da für jeden Move ein neues Objekt
angelegt wird und dieses nur einmal benutzt wird, braucht man keine weitere
Buchhaltung ...
:::

::: notes
# Abgrenzung zum Strategy-Pattern

Beide Entwurfsmuster (Strategy-Pattern und Command-Pattern) kann man schnell
verwechseln. Beide nutzen "irgendwie" Interfaces mit "irgendwelchen" Methoden ...

**Strategy-Pattern**: Wir tauschen den Algorithmus aus, mit dem der Empfänger seine
Aktion durchführt.

**Command-Pattern**: Wir kapseln eine Aktion als Objekt. Dieses kann dann
herumgereicht, gespeichert oder in eine Queue gesteckt werden. Es kann auch über
eine undo-Fähigkeit verfügen, d.h. man kann die Aktion über das Objekt rückgängig
machen.

Das Command-Pattern ist besonders nützlich, wenn Sie Befehle speichern, loggen,
replayen, undoen oder asynchron ausführen wollen. Im Zusammenhang mit JUnit lassen
sich Commands einzeln testen, indem man beispielsweise den Receiver mockt.
:::

# Wrap-Up

**Command-Pattern**: Kapselt Befehle als Objekte, um

-   Aktionen entkoppelt und konfigurierbar zu machen,
-   Undo/Redo-Funktionalität zu ermöglichen,
-   Befehle zu speichern, zu loggen oder asynchron auszuführen.

\bigskip

::: notes
Aufbau:
:::

-   `Command`-Objekte haben [eine]{.notes} Methode `execute()`, führen darin
    [die]{.notes} Aktion auf [dem]{.notes} Receiver aus
-   `Receiver` sind Objekte, auf denen Aktionen ausgeführt werden (Hero, Monster,
    ...)
-   `Invoker` hat `Command`-Objekte und ruft darauf `execute()` auf
-   `Client` kennt alle Klassen und baut alles zusammen

\bigskip
\bigskip

**Objektorientierte Antwort auf Callback-Funktionen**

::: readings
Auch wenn es für C++ geschrieben ist, lässt sich zum Thema Command-Pattern das
Kapitel 2 "Command" im @Nystrom2014 sehr gut lesen. Der Verweis auf @Gamma2011 der
["Gang of Four"](https://en.wikipedia.org/wiki/Design_Patterns) darf natürlich nicht
fehlen. Der [refactoring.guru](https://refactoring.guru/design-patterns/command) hat
ebenfalls ein schönes Tutorial zum Command-Pattern.
:::

::: outcomes
-   k2: Ich kann den Aufbau des Command-Patterns erklären
-   k3: Ich kann das Command-Pattern auf konkrete Beispiele anwenden
:::

::: challenges
**Command-Pattern im Restaurant**

**Problem**: In einem Restaurant gibt es folgende Rollen:

-   Gast (bestellt Essen/Getränke)
-   Kellner (nimmt Bestellungen entgegen und leitet sie weiter)
-   Koch (bereitet Essen zu)
-   Barkeeper (mischt Getränke)

**Ziel**: Implementieren Sie das Command-Pattern für dieses Szenario. Der Gast soll
Bestellungen beim Kellner aufgeben, die dieser an den Koch bzw. den Barkeeper
weitergibt. Bestellungen sollen auch storniert werden können.

**Aufgabe**: Diskutieren Sie in 10 Minuten:

-   Wie modellieren Sie die Rollen (Gast, Kellner, Koch, Barkeeper)?
-   Wie sieht das Command-Interface aus? Soll es `execute()` oder
    `execute(Receiver)` heißen?
-   Wie übergibt der Kellner den `Receiver` an das Command?
-   Wie implementieren Sie Undo/Redo?
-   Wie ist die Klassenstruktur (Wer kennt wen?)?
:::
