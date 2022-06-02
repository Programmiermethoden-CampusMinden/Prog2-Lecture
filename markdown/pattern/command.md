---
type: lecture-cg
title: "Command-Pattern"
menuTitle: "Command"
author: "Carsten Gips (FH Bielefeld)"
weight: 6
readings:
  - key: "Gamma2011"
  - key: "Nystrom2014"
    comment: "Kap. 2: Command"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: "Aufbau des Command-Patterns"
  - k3: "Anwendung des Command-Patterns auf konkrete Beispiele, etwa den PM-Dungeon"
quizzes:
  - link: ""
    name: "Quiz Command-Pattern (ILIAS)"
assignments:
  - topic: sheet09
youtube:
  - link: ""
    name: "VL Command-Pattern"
  - link: ""
    name: "Demo Command-Pattern"
fhmedia:
  - link: ""
    name: "VL Command-Pattern"
---


## Motivation

```java
public class InputHandler {
    void handleInput() {
        if (isPressed(BUTTON_X)) hero.jump();
        else if (isPressed(BUTTON_Y)) hero.fireGun();
        else if (isPressed(BUTTON_A)) hero.swapWeapon();
        else if (isPressed(BUTTON_B)) hero.lurchIneffectively();
    }
}
```

Unflexibel: Fest konfiguriert...


## Folie 2

```java
public interface Command {
    void execute();
}

public class Jump implements Command {
    private Entity e;
    public void execute() { e.jump(); }
}

public class InputHandler {
    Command xbutton = new Jump(hero);  // oder über Methoden setzen

    void handleInput() {
        if (isPressed(BUTTON_X)) xbutton.execute();
        else if ...
    }
}
```

Schon besser: Das Verhalten lässt sich konfigurieren. Aber die Aktionen wirken
immer noch nur auf den Helden.


## Command: Objektorientierte Antwort auf Callback-Funktionen

![](images/command.png){width="80%"}

Client: InputHandler (erzeugt neues Command) bzw. `main()`
Receiver: Hero (auf diesem wird eine Aktion ausgeführt)
Command: Jump und die anderen Klassen
Invoker: InputHandler (in der Methode `handleInput`)


## Folie 3

```java
public interface Command {
    void execute();
    Command newCommand(Entity e);
}

public class Jump implements Command {
    private Entity e;

    public void execute() { e.jump(); }
    Command newCommand(Entity e) { return new Jump(e); }
}

public class InputHandler {
    Command xbutton = new Jump();  // oder über Methoden setzen

    void handleInput() {
        Entity e = getSelectedEntity();
        Command c;

        if (isPressed(BUTTON_X)) c = xbutton.newCommand(e);
        else if ...

        c.execute();
    }
}
```

Jetzt kann jedes Command-Objekt eine neue Instanz erzeugen mit der
Entity, die dann dieses Kommando empfangen soll.


## Undo

```java
public interface Command {
    void execute();
    void undo();
    Command newCommand(Entity e);
}

public class MoveX implements Command {
    private Entity e;
    private int oldx;

    public void execute() { oldx = e.getX(); e.move(); }
    public void undo() { e.setX(oldx); e.move(); }
    Command newCommand(Entity e) { return new MoveX(e); }
}

public class InputHandler {
    Command xbutton = new Jump();   // oder über Methoden setzen
    Command wbutton = new MoveX();  // oder über Methoden setzen
    Stack<Command> s = new Stack<>;

    void handleInput() {
        Entity e = getSelectedEntity();

        if (isPressed(BUTTON_X)) s.push(xbutton.newCommand(e));
        else if (isPressed(BUTTON_W)) s.push(wbutton.newCommand(e));
        else if (isPressed(BUTTON_Z)) s.pop().undo();
        else if ...

        s.peek().execute();
    }
}
```

Über den Stack bekommt man ein Undo ...


## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
