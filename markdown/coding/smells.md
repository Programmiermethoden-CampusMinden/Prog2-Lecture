---
type: lecture-cg
title: "Bad Smells und Coding Conventions"
menuTitle: "Bad Smells"
author: "Carsten Gips (FH Bielefeld)"
weight: 4
readings:
  - key: "Martin2009"
  - key: "Fowler2011"
  - key: "Beck2014"
  - key: "Passig2013"
  - key: "Inden2013"
    comment: "Kapitel 10: Bad Smells, Kapitel 13: Programmierstil und Coding Conventions"
  - key: "googlestyleguide"
tldr: |
  TODO

  Code entsteht nicht zum Selbstzweck => Regeln nötig!

  *   Coding Conventions
    *   Regeln zu Schreibweisen und Layout
    *   Leerzeichen, Einrückung, Klammern
    *   Zeilenlänge, Umbrüche
    *   Kommentare
  *   Prinzipien des objektorientierten Design
    *   Jede Klasse ist für genau **einen** Aspekt des Systems verantwortlich.
        (*Single Responsibility*)
    *   Keine Code-Duplizierung! (*DRY* - Don't repeat yourself)
    *   Klassen und Methoden sollten sich erwartungsgemäß verhalten.
    *   Kapselung: Möglichst wenig öffentlich zugänglich machen.
  *   Metriken: Einhaltung von Regeln in Zahlen ausdrücken
  *   Prüfung manuell durch Code Reviews oder durch Tools, zB. Checkstyle

outcomes:
  - k2: "Erklären verschiedener Coding Conventions"
  - k2: "Erklären wichtiger Grundregeln des objektorientierten Designs"
  - k2: "Erklären der Metriken NCSS, McCabe, BEC, DAC"
  - k3: "Nutzung des Tools Checkstyle (Standalone, Eclipse-Plugin, Konfiguration)"
  - k3: "Beachten von Coding Conventions und Metriken"
  - k3: "Einhalten der wichtigsten Grundregeln des objektorientierten Designs"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet01
youtube:
  - link: ""
    name: "VL "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL "
sketch: true
---


## Bad Smells: Ist das Code oder kann das weg?

```{.java size="footnotesize"}
class checker {
    static public void CheckANDDO(DATA1 inp, int c, FH.Studi
    CustD, int x, int y, int in, int out,int c1, int c2, int c3 = 4)
{
    public int i; // neues i
for(i=0;i<10;i++) // fuer alle i
{
        inp.kurs[0] = 10; inp.kurs[i] = CustD.cred[i]/c;
}
      SetDataToPlan(  CustD  );
    public double myI = in*2.5; // myI=in*2.5
    if (c1)
        out = myI; //OK
    else if(  c3 == 4  )
    {
        myI = c2 * myI;
    if (c3 != 4 || true ) { // unbedingt beachten!
        //System.out.println("x:"+(x++));
        System.out.println("x:"+(x++)); // x++
        System.out.println("out: "+out);
    } }}   }
```

[Quelle: Nach einem Beispiel von Matthias König]{.origin}

::: notes
Der Code im obigen Beispiel lässt sich möglicherweise kompilieren. Und
möglicherweise tut er sogar das, was er tun soll.

Dennoch: [**Der Code "stinkt"**]{.alert} (zeigt *Bad Smells*):

*   Nichtbeachtung üblicher Konventionen (Coding Rules)
*   Schlechte Kommentare
*   Auskommentierter Code
*   Fehlende Datenkapselung
*   Zweifelhafte Namen
*   Duplizierter Code
*   "Langer" Code: Lange Methoden, Klassen, Parameterlisten, tief
    verschachtelte `if/then`-Bedingungen, ...
*   Feature Neid
*   `switch/case` oder `if/else` statt Polymorphie
*   Globale Variablen, lokale Variablen als Attribut
*   Magic Numbers

Diese Liste enthält die wichtigsten Smells und lässt sich noch beliebig fortsetzen.
Schauen Sie mal in die unten angegebene Literatur :-)

[**Stinkender Code führt zu möglichen (späteren) Problemen.**]{.alert}
:::


## Was ist guter ("sauberer") Code?

::: notes
Robert Martin lässt in [@Martin2009] verschiedene Ikonen der SW-Entwicklung zu
Wort kommen (Zusammenfassung):
:::

> *   Gut ("angenehm") lesbar
> *   Schnell verständlich: Geeignete Abstraktionen
> *   Leicht wart- und erweiterbar: Minimale Abhängigkeiten
> *   Konzentriert sich auf **eine** Aufgabe
> *   So einfach und direkt wie möglich
> *   Fehler können sich nicht so einfach verstecken
> *   Verleitet andere Programmierer nicht zum "Optimieren"
> *   Ist gut getestet
>
> [Quelle: nach [@Martin2009]]{.origin}

\bigskip
=> Jemand kümmert sich um den Code; solides Handwerk


## Warum ist guter ("sauberer") Code so wichtig?

> Any fool can write code that a computer can understand.
> Good programmers write code that humans can understand.
>
> [Quelle: [@Fowler2011]]{.origin}

::: notes
### "Broken Windows" Phänomen

Wenn ein Gebäude leer steht, wird es eine gewisse Zeit lang nur relativ langsam
verfallen: Die Fenster werden nicht mehr geputzt, es sammelt sich Graffiti, Gras
wächst in der Dachrinne, Putz blättert ab ...

Irgendwann wird dann eine Scheibe eingeworfen. Wenn dieser Punkt überschritten
ist, beschleunigt sich der Verfall rasant: Über Nacht werden alle erreichbaren
Scheiben eingeworfen, Türen werden zerstört, es werden sogar Brände gelegt ...

Das passiert auch bei Software! Wenn man als Entwickler das Gefühl bekommt,
die Software ist nicht gepflegt, wird man selbst auch nur relativ schlechte
Arbeit abliefern. Sei es, weil man nicht versteht, was der Code macht und sich
nicht an die Überarbeitung der richtigen Stellen traut und stattdessen die
Änderungen als weiteren "Erker" einfach dran pappt. Seit es, weil man keine Lust
hat, Zeit in ordentliche Arbeit zu investieren, weil der Code ja eh schon
schlecht ist ... Das wird mit der Zeit nicht besser ...
:::

[["Broken Windows" Phänomen](https://en.wikipedia.org/wiki/Broken_windows_theory)]{.bsp}

::: notes
### Bad Smells

Verstöße gegen die Prinzipien von *Clean Code* nennt man auch *Bad Smells*: Der
Code "stinkt" gewissermaßen. Dies bedeutet nicht unbedingt, dass der Code nicht
funktioniert (d.h. er kann dennoch compilieren und die Anforderungen erfüllen).
Er ist nur nicht sauber formuliert, schwer verständlich, enthält Doppelungen etc.,
was im Laufe der Zeit die Chance für Probleme deutlich erhöht.

[**Stinkender Code führt zu möglichen (späteren) Problemen.**]{.alert}
:::


## Maßeinheit für Code-Qualität ;-)

![](figs/badsmells/wtfm){width="60%"}
<!-- https://www.osnews.com/images/comics/wtfm.jpg -->
[Quelle: [Thom Holwerda: www.osnews.com/story/19266/WTFs_](https://www.osnews.com/story/19266/wtfsm/)]{.origin}


## Bad Smells: Nichtbeachtung von Coding Conventions

*   Richtlinien für einheitliches Aussehen \newline
    => Andere Programmierer sollen Code schnell lesen können
    *   Namen, Schreibweisen
    *   Kommentare (Ort, Form, Inhalt)
    *   Einrückungen und Spaces vs. Tabs
    *   Zeilenlängen, Leerzeilen
    *   Klammern

\smallskip

*   Beispiele: [Sun Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf), [Google Java Style](https://google.github.io/styleguide/javaguide.html)

\bigskip

*   *Hinweis*: Betrifft vor allem die (äußere) Form!

[Beispiel: Google Java Style; Hinweis auf Formatter]{.bsp}


## Bad Smells: Schlechte Kommentare

*   Ratlose Kommentare

    ```java
    /* k.A. was das bedeutet, aber wenn man es raus nimmt, geht's nicht mehr */
    /* TODO: was passiert hier, und warum? */
    ```

    ::: notes
    Der Programmierer hat selbst nicht verstanden (und macht sich auch nicht
    die Mühe zu verstehen), was er da tut! Fehler sind vorprogrammiert!
    :::

\bigskip

*   Redundante Kommentare[: Erklären Sie, was der Code **inhaltlich** tun sollte (und warum)!]{.notes}

    ```java
    public int i; // neues i
    for(i=0;i<10;i++)
    // fuer alle i
    ```

    ::: notes
    > Als Faustregel kann man sich daran orientieren, dass ein Kommentar alles
    > enthalten sollte, was man auch seinen Kollegen sagen würde, ginge man mit
    > ihnen den Code durch. Idealerweise wiederholt der Kommentar dabei nicht
    > das, was der Code tut, sondern beschreibt, was der Code tun sollte und
    > warum. Es ist kein Fehler, dabei statt des spezifischen Lösungswegs das
    > allgemeine Konzept zu beschreiben.
    >
    > [Quelle: [@Passig2013]]{.origin}
    :::

\bigskip

*   Veraltete Kommentare

    ::: notes
    Hinweis auf unsauberes Arbeiten: Oft wird im Zuge der Überarbeitung von
    Code-Stellen vergessen, auch den Kommentar anzupassen! Sollte beim Lesen
    extrem misstrauisch machen.
    :::

*   Kommentare erscheinen zwingend nötig

    ::: notes
    Häufig ein Hinweis auf ungeeignete Wahl der Namen (Klassen, Methoden,
    Attribute) und/oder auf ein ungeeignetes Abstraktionsniveau (beispielsweise
    Nichtbeachtung des Prinzips der "*Single Responsibility*")!

    Der Code soll im **Normalfall** für sich selbst sprechen: **WAS** wird gemacht.
    Der Kommentar erklärt im Normalfall, **WARUM** der Code das machen soll.
    :::

*   Unangemessene Information, z.B. Änderungshistorien

    ::: notes
    Hinweise wie "wer hat wann was geändert" gehören in das Versionskontroll-
    oder ins Issue-Tracking-System. Die Änderung ist im Code sowieso nicht mehr
    sichtbar/nachvollziehbar!
    :::

*   Auskommentierter Code

    ::: notes
    Da ist jemand seiner Sache unsicher bzw. hat eine Überarbeitung nicht
    abgeschlossen. Die Chance, dass sich der restliche Code im Laufe der Zeit
    so verändert, dass der auskommentierte Code nicht mehr (richtig) läuft, ist
    groß! Auskommentierter Code ist gefährlich und dank Versionskontrolle
    absolut überflüssig!
    :::


## Bad Smells: Schlechte Namen und fehlende Kapselung

```java
public class Studi extends Person {
    public String n;
    public int c;

    public void prtIf() { ... }
}
```

::: notes
Nach drei Wochen fragen Sie sich, was `n` oder `c` oder `Studi#prtIf()` wohl
sein könnte! (Ein anderer Programmierer fragt sich das schon beim **ersten**
Lesen.)

Wenn Dinge öffentlich angeboten werden, muss man damit rechnen, dass andere
darauf zugreifen. D.h. man kann nicht mehr so einfach Dinge wie die interne
Repräsentation oder die Art der Berechnung austauschen! Öffentliche Dinge
gehören zur Schnittstelle und damit Teil des "Vertrags" mit den Nutzern!
:::

\bigskip

*   Design-Prinzip "**Prinzip der minimalen Verwunderung**"
    *   Klassen und Methoden sollten sich erwartungsgemäß verhalten
    *   Gute Namen ersparen das Lesen der Dokumentation

\smallskip

*   Design-Prinzip "**Kapselung/Information Hiding**"
    *   Möglichst schlanke öffentliche Schnittstelle \newline
        => "Vertrag" mit Nutzern der Klasse!


## Bad Smells: Duplizierter Code

```java
public class Studi {
    public String getName() { return name; }
    public String getAddress() {
        return strasse+", "+plz+" "+stadt;
    }

    public String getStudiAsString() {
        return name+" ("+strasse+", "+plz+" "+stadt+")";
    }
}
```

\bigskip

*   Design-Prinzip "**DRY**" => "Don't repeat yourself!"

::: notes
Im Beispiel wird das Formatieren der Adresse mehrfach identisch implementiert,
d.h. duplizierter Code. Auslagern in eigene Methode und aufrufen!
:::

::: notes
Kopierter Code ist problematisch:

*   Spätere Änderungen müssen an mehreren Stellen vorgenommen werden
*   Lesbarkeit/Orientierung im Code wird erschwert (Analogie: Reihenhaussiedlung)
*   Verpasste Gelegenheit für sinnvolle Abstraktion!
:::


## Bad Smells: Langer Code

*   Lange Klassen
    *   Faustregel: 5 Bildschirmseiten sind viel

*   Lange Methoden
    *   Faustregel: 1 Bildschirmseite
    *   [@Martin2009]: deutlich weniger als 20 Zeilen

*   Lange Parameterlisten
    *   Faustregel: max. 3 ... 5 Parameter
    *   [@Martin2009]: 0 Parameter ideal, ab 3 Parameter
        gute Begründung nötig

*   Tief verschachtelte `if/then`-Bedingungen
    *   Faustregel: 2 ... 3 Einrückungsebenen sind viel

\bigskip

*   Design-Prinzip "**Single Responsibility**"


::::::::: notes

### Lesbarkeit und Übersichtlichkeit leiden:

*   Mensch kann sich nur begrenzt viele Dinge im Kurzzeitgedächtnis merken
*   Klassen länger als 5 Bildschirmseiten erfordern viel Hin- und
    Her-Scrollen, dito für lange Methoden
*   Lange Methoden sind schwer verständlich
*   Mehr als 3 Parameter kann sich kaum jemand merken, vor allem beim
    Aufruf von Methoden
*   Testbarkeit wird bei zu komplexen Methoden/Klassen und vielen Parametern
    sehr erschwert
*   Große Dateien verleiten (auch mangels Übersichtlichkeit) dazu, neuen
    Code ebenfalls schluderig zu gliedern


### Langer Code deutet auch auf eine Verletzung des Prinzips der einfachen Verantwortung hin:

*   Klassen fassen nicht zusammengehörende Dinge zusammen
*   Methoden erledigen mehr als nur eine Aufgabe
    *   Erklären Sie die Methode jemandem. Wenn dabei das Wort "und"
        vorkommt, macht die Methode höchstwahrscheinlich zu viel!

        ```java
        // nach [@Martin2009]
        public void pay() {
            for (Employee e : employees) {
                if (e.isPayDay()) {
                Money amount = e.calculatePay();
                e.deliverPay(amount);
            }
        }

        // Methode erledigt 4 Dinge: Iteration, Abfrage, Berechnung, Auslieferung ...
        ```

*   Viele Parameter bedeuten oft fehlende Datenabstraktion

    ```java
    Circle makeCircle(int x, int y, int radius);
    Circle makeCircle(Point center, int radius);  // besser!
    ```

:::::::::


## Design-Prinzip _Single Responsibility_

Jede Klasse ist für genau [einen Aspekt]{.alert} des Gesamtsystems verantwortlich

\bigskip

```java
public class Student {
    private String name;
    private String phoneAreaCode;
    private String phoneNumber;

    public void printStudentInfo() {
        System.out.println("name:    " + name);
        System.out.println("contact: " + phoneAreaCode + "/" + phoneNumber);
    }
}
```

::: notes
Warum sollte sich die Klasse `Student` um die Einzelheiten des Aufbaus einer
Telefonnummer kümmern? Das Prinzip der "*Single Responsibility*" wird hier
verletzt!
:::


## Bad Smells: Feature Neid

```java
// nach [@Martin2009]
public class HourlyPayCalculator {
    public Money calculateWeeklyPay(HourlyEmployee e) {
        int rate = e.getRate();
        int worked = e.getHoursWorked();
        int straightTime = Math.min(40, worked);
        int overTime = Math.max(0, worked-straightTime);
        int straightPay = straightTime*rate;
        int overtimePay = (int)Math.round(overTime*rate*1.5);
        return new Money(straightPay+overtimePay);
    }
}
```

::: notes
*   Zugriff auf Interna der anderen Klasse! => Hohe Kopplung der Klassen!
*   Methode `HourlyPayCalculator#calculateWeeklyPay()` "möchte" eigentlich in
    `HourlyEmployee` sein ...
:::


## Metriken: Messen und Bewerten

::: notes
### Kennzahlen für verschiedene Aspekte zum Code

*   Einhaltung der Coding Rules
*   Beachtung der Regeln des objektorientierten Entwurfs


### Beispiele für wichtige Metriken (jeweils max-Werte)
:::

*   **NCSS** (*Non Commenting Source Statements*)
    *   Zeilen pro Methode: 50; pro Klasse: 500; pro Datei: 600 \newline
        *Annahme*: Eine Anweisung je Zeile ...
*   **Anzahl der Methoden** pro Klasse: 10
*   **Parameter** pro Methode: 3
*   **BEC** (*Boolean Expression Complexity*) \newline
    Anzahl boolescher Ausdrücke in `if` etc.: 3
*   **McCabe** (Cyclomatic Complexity)
    *   Anzahl der möglichen Verzweigungen (Pfade) pro Methode
    *   1-4 gut, 5-7 noch OK
*   **DAC** (*Class Data Abstraction Coupling*)
    *   Anzahl der genutzten (instantiierten) "Fremdklassen"
    *   Werte kleiner 7 werden i.A. als normal betrachtet

::: notes
Die obigen Grenzwerte sind vorgeschlagene Standardwerte, die sich in der Praxis
allgemein bewährt haben (u.a. nach [@Martin2009]). Dennoch sind das keine absoluten
Werte an sich, sondern müssen an das konkrete Projekt angepasst werden. Ein
Übertreten der Grenzen ist ein **Hinweis** darauf, das **höchstwahrscheinlich**
etwas nicht stimmt, muss aber im konkreten Fall hinterfragt und diskutiert werden!
:::

\bigskip

=> Verweis auf LV Softwareengineering

::: notes
### Tool-Support

Metriken werden sinnvollerweise durch diverse Tools erfasst.

*   **Checkstyle** [([Standalone via Ant](https://github.com/checkstyle/checkstyle) und Plugin für
    [Eclipse](https://github.com/checkstyle/eclipse-cs) oder [IntelliJ](https://github.com/jshiell/checkstyle-idea))]{.notes}
*   Alternativen/Ergänzungen: [Metrics](http://metrics.sourceforge.net/),
    [MetricsReloaded](https://github.com/BasLeijdekkers/MetricsReloaded),
    [FindBugs/SpotBugs](https://github.com/spotbugs/spotbugs), ...
:::

[Beispiel: Konfiguration Eclipse-Checkstyle, Hinweis auf Formatter]{.bsp}


## Wrap-Up

Code entsteht nicht zum Selbstzweck => Regeln nötig!

*   Coding Conventions
    *   Regeln zu Schreibweisen und Layout
    *   Leerzeichen, Einrückung, Klammern
    *   Zeilenlänge, Umbrüche
    *   Kommentare
*   Prinzipien des objektorientierten Design
    *   Jede Klasse ist für genau **einen** Aspekt des Systems verantwortlich.
        (*Single Responsibility*)
    *   Keine Code-Duplizierung! (*DRY* - Don't repeat yourself)
    *   Klassen und Methoden sollten sich erwartungsgemäß verhalten.
    *   Kapselung: Möglichst wenig öffentlich zugänglich machen.
*   Metriken: Einhaltung von Regeln in Zahlen ausdrücken
*   Prüfung manuell durch Code Reviews oder durch Tools, zB. Checkstyle







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
