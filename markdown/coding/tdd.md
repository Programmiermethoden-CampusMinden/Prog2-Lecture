---
type: lecture-cg
title: "Testbarkeit und Testdriven Development (TDD)"
menuTitle: "Testbarkeit und TDD"
author: "Carsten Gips (FH Bielefeld)"
weight: 7
readings:
  - key: "Beck2014"
  - key: "Martin2009"
  - key: "Fowler2011"
tldr: |
  Um Code mit JUnit automatisiert testen zu können, muss beim Software-Entwurf die Testbarkeit
  mitgedacht werden. Besonders einfach lassen sich Methoden testen, die das Ergebnis ihrer
  Berechnung als Rückgabewert zurückliefern und die keine Seiteneffekte aufweisen. Wenn Methoden
  den inneren Zustand des eigenen Objekts ändern, kann man dies nur indirekt über den Aufruf
  anderer Methoden testen. Je weniger eine Methode berechnet, um so einfacher lassen sich diese
  Berechnungen durch JUnit-Tests überprüfen.

  Auch für (JUnit-) Tests gelten die üblichen Regeln des Software-Entwurfs. Insbesondere sollte
  sich ein Testfall auf einen Aspekt konzentrieren und möglichst schnell und möglichst unabhängig
  von Datenbank- oder Internetverbindungen o.ä. ausführen lassen. Nur wenn die Testfälle nicht
  viel Zeit bei der Ausführung benötigen, wird man sie als Entwickler häufiger nach Änderungen
  laufen lassen ...

  Mit "Test-Driven Development" (_TDD_) steht eine Methode bereit, wo zuerst ein Test geschrieben
  wird und erst danach der Code. Dabei wird der Code nur so weit implementiert, bis der Test
  "grün" ist. Danach erfolgt ggf. eine Umstrukturierung der inneren Code-Strukturen (aber kein
  Hinzufügen von Funktionalität), und der Zyklus kann erneut beginnen: Test, Code, Refactoring.
  Dies führt dazu, dass man nicht "vergessen" kann, Tests zu schreiben. Außerdem erhält man
  häufig den minimal nötigen Code, da ja immer nur die Tests erfüllt werden sollen.
outcomes:
  - k3: "Einsatz von TDD bei der Softwareentwicklung"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1068951&client_id=FH-Bielefeld"
    name: "Quiz TDD (ILIAS)"
youtube:
  - link: ""
    name: "VL TDD"
  - link: ""
    name: "Demo TDD"
fhmedia:
  - link: ""
    name: "VL TDD"
---


## Design für Testbarkeit

::: notes
### Schlechtes Beispiel
:::

```java
public void ausgabe(...) {
    ... // mache komplexe Berechnungen
    ... // berechne nette Formatierungen
    System.out.println(...);
}
```

\pause
\bigskip
\hrule
\smallskip

::: notes
### Etwas verbessertes Beispiel
:::

```java
private A berechneA(...)  {
    return ...;  // mache komplexe Berechnungen
}
private String formatiereA(A a) {
    return ...;  // berechne nette Formatierungen
}
public void ausgabe(...) {
    System.out.println(formatiereA(berechneA(...)));
}
```

## Anzeichen für schlecht testbares Design

*   Keine Rückgabewerte
*   Direkte Ausgaben
*   Mehr als ein Zweck:
    *   Berechnung plus Ausgabe
    *   Mehrere unterschiedliche Berechnungen
    *   ...
*   Seiteneffekte, z.B. Berechnung und direkte Veränderung von Zuständen **anderer** Objekte


## Private Methoden sind nicht (direkt) testbar

1.  Gar nicht testen????

    ::: notes
    Private Methoden sind nicht ohne Grund "privat": Sie gehören nicht zur
    Schnittstelle einer Klasse. Deshalb können sie jederzeit geändert oder
    sogar entfernt werden ...

    Andererseits steckt hier Funktionalität drin, die man in irgendeiner
    Weise absichern sollte. In "Softwarequalität" werden wir dieses Thema
    weiter diskutieren. Oft ist es aber hilfreich, auch für die privaten
    Methoden ausreichend Unit-Tests zu haben (Stichwort "Refactoring").
    :::

\smallskip

2.  Sichtbarkeit auf `protected` setzen; Tests im selben Package unterbringen

    ::: notes
    *   Testklassen und getestete Klassen im selben Ordner, oder
    *   Wahl unterschiedlicher Oberordner: `src` für Sourcecode und
        `test` für Testklassen und Spiegelung der Package-Struktur
        (Eclipse: Testordner über Project-Properties als Source-Ordner hinzufügen!)
    :::

\smallskip

3.  JUnit 4/5: [Testmethoden via]{.notes} Annotationen
    => Testmethoden mit Produktionscode mischen

\smallskip

4.  Reflection nutzen (vgl. spätere VL)

    ::: notes
    [**Nachteile**]{.alert}:

    *   Umgang mit Strings statt Klassen!
    *   Keine Compiler-/IDE-Unterstützung!
    *   Kein Refactoring!
    :::


## Was ist ein guter Test?

*   Läuft schnell. Läuft schnell. Läuft schnell!!!

    ::: notes
    Langsame Tests werden nicht oft (genug) ausgeführt!
    :::

\smallskip

*   Testet genau einen Aspekt, wenige Assertions

    ::: notes
    Wenn der Test fehlschlägt, ist offensichtlich, wo nach dem Problem gesucht werden muss.
    :::

\smallskip

*   Separiert Abhängigkeiten (Datenbanken, Netzwerk, ...)

    ::: notes
    Ein Test, der von Datenbanken o.ä. abhängt, ist normalerweise nicht schnell
    (vgl. Regel Eins). Außerdem können bei einem Test, der noch von anderen
    Dingen wie Datenbanken o.ä. abhängt, Fehler auftreten, die mit dem eigentlichen
    Tests nichts zu tun haben.

    Dazu werden Stubs und Mocks (vgl. Wahlfach "Softwarequalität") eingesetzt, um
    diese Abhängigkeiten "selbst in der Hand zu haben", d.h. zu ersetzen und zu
    simulieren.
    :::

\smallskip

*   Absicht ist klar zu verstehen

    ::: notes
    Jeder Entwickler kann sich den Test anschauen und dadurch verstehen, was
    vom Produktionscode erwartet wird.
    :::


## TDD oder der "Red-Green-Refactor"-Zyklus

![](images/tdd.png){width="60%" web_width="40%"}

::: notes
### Test-Driven Development (_TDD_)

1.  Schreibe Test => schlägt fehl: "Red"
    *   Überlegen Sie, wie das Stück Software, welches Sie erstellen wollen,
        funktionieren soll und wie Sie das testen würden, wenn es schon
        existieren würde.
    *   Stellen Sie sich vor, wie der (zu testende) Code aufgerufen wird und
        schreiben Sie den Testfall, als ob der Code schon existieren würde.
    *   Eclipse wird "meckern", weil es den aufgerufenen Code noch nicht gibt.
        Nutzen Sie einfach die vorgeschlagene Lösung von Eclipse und lassen
        sich den Methodenrumpf für die zu testende Methode(!) von Eclipse generieren.
    *   Jetzt compiliert der Code und der Test, aber der Test ist immer noch
        "rot".
2.  Schreibe genau soviel Code, dass Test OK wird: "Green"
    *   Implementieren Sie jetzt die Methode, d.h. füllen Sie den generierten
        Methodenrumpf mit "Leben". Aber nur genau so viel Code schreiben, bis
        der Test "grün" ist.
3.  Überarbeite Code-Struktur: "Refactor" (Refactoring ist Thema einer
    `[späteren VL]({{< ref "/coding/refactoring" >}})`{=markdown})
    *   Durch das reine Erfüllen des neuen Test gibt es im Laufe der Zeit sehr
        wahrscheinlich doppelten Code oder zu große Methoden o.ä. ... Dies wird
        durch diesen Schritt konsequent aufgeräumt.
    *   Eventuell müssen auch (frühere) Testfälle angepasst werden, die durch
        die eben implementierte neue Funktionalität ungültig werden.
:::

\vfill

_Anmerkung_: Jeder Zyklus sollte sehr kurz sein!
[=> Pro Stunde schafft man i.d.R. viele Rot/Grün/Refactoring-Zyklen!]{.notes}

[Demo: Validierung von Passwörtern]{.bsp}

::: notes
### Vorteile bei konsequenter Anwendung von TDD

*   Kein ungetesteter Code mehr:
    Es entstehen automatisch viele Unit-Tests und gibt keinen Grund, keine Tests zu schreiben
*   Kein unnötiger Code auf Vorrat: Es wird immer genau ein Test erfüllt
*   Konzentration auf das Wesentliche
*   Vermeidung von Redundanzen durch Refactoring
*   Die Testfälle dienen als Dokumentation, da man von erwartetem Verhalten ausgegangen ist
    Veraltet im Gegensatz zu separater Dokumentation nicht
*   Da der Entwickler zuerst einen Test schreiben muss, ist die Gefahr, dass
    er nicht versteht, was der Produktionscode machen soll, minimiert
:::


## Wrap-Up

*   Testbarkeit muss mitgedacht werden: SW-Design
*   Private Methoden auch testen ("Sicherheitsnetz")
*   Auch Tests brauchen SW-Design (Kapselung, Single Responsibility, ...)
*   _Test first_: Test-Driven Development (_TDD_)







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
