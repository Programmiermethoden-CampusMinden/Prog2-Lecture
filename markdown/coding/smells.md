---
type: lecture-cg
title: "Code Smells"
menuTitle: "Code Smells"
author: "Carsten Gips (FH Bielefeld)"
weight: 4
readings:
  - key: "Martin2009"
  - key: "Passig2013"
  - key: "Inden2013"
    comment: "Kapitel 10: Bad Smells"
tldr: |
  Code entsteht nicht zum Selbstzweck, er muss von anderen Menschen leicht verstanden und
  gewartet werden können: Entwickler verbringen einen wesentlichen Teil ihrer Zeit mit dem
  **Lesen** von (fremdem) Code. Dabei helfen "Coding Conventions", die eine gewisse einheitliche
  äußerliche Erscheinung des Codes vorgeben (Namen, Einrückungen, ...). Die Beachtung von
  grundlegenden Programmierprinzipien hilft ebenso, die Lesbarkeit und Verständlichkeit zu
  verbessern.

  Code, der diese Konventionen und Regeln verletzt, zeigt sogenannte "**Code Smells**" oder
  "Bad Smells". Das sind Probleme im Code, die noch nicht direkt zu einem Fehler führen, die
  aber im Laufe der Zeit die Chance für echte Probleme deutlich erhöht.
outcomes:
  - k3: "Erkennen und Vermeiden von Code Smells"
  - k3: "Unterscheiden von leicht lesbarem und schwer lesbarem Code"
  - k3: "Programmierprinzipien anwenden, um den Code sauberer zu gestalten"
  - k3: "Bessere Kommentare schreiben"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet05
youtube:
  - link: ""
    name: "VL Code Smells"
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL Code Smells"
---


## Code Smells: Ist das Code oder kann das weg?

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

::: notes
Der Code im obigen Beispiel lässt sich möglicherweise kompilieren. Und
möglicherweise tut er sogar das, was er tun soll.

Dennoch: [**Der Code "stinkt"**]{.alert} (zeigt **Code Smells**):

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

Diese Liste enthält die häufigsten "Smells" und ließe sich noch beliebig fortsetzen.
Schauen Sie mal in die unten angegebene Literatur :-)

**Stinkender Code führt zu möglichen (späteren) Problemen.**
:::


## Was ist guter ("sauberer") Code ("Clean Code")?

::: notes
Im Grunde bezeichnet "sauberer Code" ("Clean Code") die Abwesenheit von Smells. D.h. man
könnte Code als "sauberen" Code bezeichnen, wenn die folgenden Eigenschaften erfüllt sind
(keine vollständige Aufzählung!):
:::

*   Gut ("angenehm") lesbar
*   Schnell verständlich: Geeignete Abstraktionen
*   Konzentriert sich auf **eine** Aufgabe
*   So einfach und direkt wie möglich
*   Ist gut getestet

::: notes
In [@Martin2009] lässt der Autor Robert Martin verschiedene Ikonen der SW-Entwicklung
zu diesem Thema zu Wort kommen -- eine sehr lesenswerte Lektüre!
:::

\bigskip
\bigskip
=> Jemand kümmert sich um den Code; solides Handwerk


## Warum ist guter ("sauberer") Code so wichtig?

> Any fool can write code that a computer can understand.
> Good programmers write code that humans can understand.
>
> \hfill\ [Quelle: [@Fowler2011]]{.origin}

::::::::: notes
Auch wenn das zunächst seltsam klingt, aber Code muss auch von Menschen gelesen und
verstanden werden können. Klar, der Code muss inhaltlich korrekt sein und die jeweilige
Aufgabe erfüllen, er muss kompilieren etc. ... aber er muss auch von anderen Personen
weiter entwickelt werden und dazu gelesen und verstanden werden. Guter Code ist nicht
einfach nur inhaltlich korrekt, sondern kann auch einfach verstanden werden.

Code, der nicht einfach lesbar ist oder nur schwer verständlich ist, wird oft in der
Praxis später nicht gut gepflegt: Andere Entwickler haben (die berechtigte) Angst, etwas
kaputt zu machen und arbeiten "um den Code herum". Nur leider wird das Konstrukt dann
nur noch schwerer verständlich ...

### Code Smells

Verstöße gegen die Prinzipien von _Clean Code_ nennt man auch _Code Smells_: Der
Code "stinkt" gewissermaßen. Dies bedeutet nicht unbedingt, dass der Code nicht
funktioniert (d.h. er kann dennoch compilieren und die Anforderungen erfüllen).
Er ist nur nicht sauber formuliert, schwer verständlich, enthält Doppelungen etc.,
was im Laufe der Zeit die Chance für tatsächliche Probleme deutlich erhöht.
:::::::::

\pause
\bigskip
\vfill

[Und weil es so wichtig ist, hier gleich noch einmal:]{.notes}

::: cbox
[**Stinkender Code führt zu möglichen (späteren) Problemen.**]{.alert}
:::

::::::::: notes
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
:::::::::

[["Broken Windows" Phänomen](https://en.wikipedia.org/wiki/Broken_windows_theory)]{.bsp}

::::::::: notes
### Maßeinheit für Code-Qualität ;-)

Es gibt eine "praxisnahe" (und nicht ganz ernst gemeinte) Maßeinheit für Code-Qualität:
Die "WTF/m" (_What the Fuck per minute_):
[Thom Holwerda: www.osnews.com/story/19266/WTFs_](https://www.osnews.com/story/19266/wtfsm/).

Wenn beim Code-Review durch Kollegen viele "WTF" kommen, ist der Code offenbar nicht
in Ordnung ...
:::::::::


## Code Smells: Nichtbeachtung von Coding Conventions

*   Richtlinien für einheitliches Aussehen
    => Andere Programmierer sollen Code schnell lesen können
    *   Namen, Schreibweisen
    *   Kommentare (Ort, Form, Inhalt)
    *   Einrückungen und Spaces vs. Tabs
    *   Zeilenlängen, Leerzeilen
    *   Klammern

\smallskip

*   Beispiele: [Sun Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf),
    [Google Java Style](https://google.github.io/styleguide/javaguide.html)

\bigskip

*   _Hinweis_: Betrifft vor allem die (äußere) Form!

[Hinweis: Genauere Betrachtung in "Coding Rules"]{.bsp}


## Code Smells: Schlechte Kommentare I

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

*   Redundante Kommentare: Erklären Sie, was der Code **inhaltlich** tun sollte (und warum)!

    ```java
    public int i; // neues i
    for(i=0;i<10;i++)
    // fuer alle i
    ```

    ::: notes
    Was würden Sie Ihrem Kollegen erklären (müssen), wenn Sie ihm/ihr den
    Code vorstellen?

    Wiederholen Sie nicht, was der Code tut (das kann ich ja selbst lesen),
    sondern beschreiben Sie, was der Code tun _sollte_ und _warum_.

    Beschreiben Sie dabei auch das Konzept hinter einem Codebaustein.
    :::


## Code Smells: Schlechte Kommentare II

*   Veraltete Kommentare

    ::: notes
    Hinweis auf unsauberes Arbeiten: Oft wird im Zuge der Überarbeitung von
    Code-Stellen vergessen, auch den Kommentar anzupassen! Sollte beim Lesen
    extrem misstrauisch machen.
    :::

*   Auskommentierter Code

    ::: notes
    Da ist jemand seiner Sache unsicher bzw. hat eine Überarbeitung nicht
    abgeschlossen. Die Chance, dass sich der restliche Code im Laufe der Zeit
    so verändert, dass der auskommentierte Code nicht mehr (richtig) läuft, ist
    groß! Auskommentierter Code ist gefährlich und dank Versionskontrolle
    absolut überflüssig!
    :::

*   Kommentare erscheinen zwingend nötig

    ::: notes
    Häufig ein Hinweis auf ungeeignete Wahl der Namen (Klassen, Methoden,
    Attribute) und/oder auf ein ungeeignetes Abstraktionsniveau (beispielsweise
    Nichtbeachtung des Prinzips der "_Single Responsibility_")!

    Der Code soll im **Normalfall** für sich selbst sprechen: **WAS** wird gemacht.
    Der Kommentar erklärt im Normalfall, **WARUM** der Code das machen soll.
    :::

*   Unangemessene Information, z.B. Änderungshistorien

    ::: notes
    Hinweise wie "wer hat wann was geändert" gehören in das Versionskontroll-
    oder ins Issue-Tracking-System. Die Änderung ist im Code sowieso nicht mehr
    sichtbar/nachvollziehbar!
    :::


## Code Smells: Schlechte Namen und fehlende Kapselung

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
Lesen.) Klassen und Methoden sollten sich erwartungsgemäß verhalten.

Wenn Dinge öffentlich angeboten werden, muss man damit rechnen, dass andere
darauf zugreifen. D.h. man kann nicht mehr so einfach Dinge wie die interne
Repräsentation oder die Art der Berechnung austauschen! Öffentliche Dinge
gehören zur Schnittstelle und damit Teil des "Vertrags" mit den Nutzern!
:::

\bigskip

*   Programmierprinzip "**Prinzip der minimalen Verwunderung**"
*   Programmierprinzip "**Kapselung/Information Hiding**"


## Code Smells: Duplizierter Code

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

*   Programmierprinzip "**DRY**" => "Don't repeat yourself!"

::: notes
Im Beispiel wird das Formatieren der Adresse mehrfach identisch implementiert,
d.h. duplizierter Code. Auslagern in eigene Methode und aufrufen!

Kopierter Code ist problematisch:

*   Spätere Änderungen müssen an mehreren Stellen vorgenommen werden
*   Lesbarkeit/Orientierung im Code wird erschwert (Analogie: Reihenhaussiedlung)
*   Verpasste Gelegenheit für sinnvolle Abstraktion!
:::


## Code Smells: Langer Code

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

*   Programmierprinzip "**Single Responsibility**"

    ::: notes
    Jede Klasse ist für genau [einen Aspekt]{.alert} des Gesamtsystems verantwortlich
    :::

\bigskip

::::::::: notes
### Lesbarkeit und Übersichtlichkeit leiden

*   Der Mensch kann sich nur begrenzt viele Dinge im Kurzzeitgedächtnis merken
*   Klassen, die länger als 5 Bildschirmseiten sind, erfordern viel Hin- und
    Her-Scrollen, dito für lange Methoden
*   Lange Methoden sind schwer verständlich (erledigen viele Dinge?)
*   Mehr als 3 Parameter kann sich kaum jemand merken, vor allem beim
    Aufruf von Methoden
*   Die Testbarkeit wird bei zu komplexen Methoden/Klassen und vielen Parametern
    sehr erschwert
*   Große Dateien verleiten (auch mangels Übersichtlichkeit) dazu, neuen
    Code ebenfalls schluderig zu gliedern

### Langer Code deutet auch auf eine Verletzung des Prinzips der Single Responsibility hin

*   Klassen fassen evtl. nicht zusammengehörende Dinge zusammen
*   Methoden erledigen vermutlich mehr als nur eine Aufgabe
    *   Erklären Sie die Methode jemandem. Wenn dabei das Wort "und"
        vorkommt, macht die Methode höchstwahrscheinlich zu viel!

        ```java
        public void credits() {
            for (Student s : students) {
                if (s.hasSemesterFinished()) {
                    ECTS c = calculateEcts(s);
                    s.setEctsSum(c);
                }
            }
        }

        // Methode erledigt 4 Dinge: Iteration, Abfrage, Berechnung, Setzen ...
        ```

*   Viele Parameter bedeuten oft fehlende Datenabstraktion

    ```java
    Circle makeCircle(int x, int y, int radius);
    Circle makeCircle(Point center, int radius);  // besser!
    ```
:::::::::


## Code Smells: Feature Neid

```java
public class CreditsCalculator {
    public ECTS calculateEcts(Student s) {
        int semester = s.getSemester();
        int workload = s.getCurrentWorkload();
        int nrModuls = s.getNumberOfModuls();
        int total = Math.min(30, workload);
        int extra = Math.max(0, total - 30);
        if (semester < 5) {
             extra = extra * nrModuls;
        }
        return new ECTS(total + extra);
    }
}
```

::: notes
*   Zugriff auf (viele) Interna der anderen Klasse! => Hohe Kopplung der Klassen!
*   Methode `CreditsCalculator#calculateEcts()` "möchte" eigentlich in
    `Student` sein ...
:::


::: notes
## Weiterführende Links

*   ["Foundations: Clean Code" (The Odin Project)](https://www.theodinproject.com/lessons/foundations-clean-code)
*   ["Documentation Best Practices" (Google Styleguide)](https://github.com/google/styleguide/blob/gh-pages/docguide/best_practices.md)
:::


## Wrap-Up

*   Code entsteht nicht zum Selbstzweck => Lesbarkeit ist wichtig

\bigskip

*   Code Smells: Code führt zu möglichen (späteren) Problemen

    *   Richtiges Kommentieren und Dokumentieren

        ::: notes
        In dieser Sitzung haben wir vor allem auf Kommentare geschaut. Zum Thema Dokumentieren
        siehe die Einheit zu `["Javadoc"]({{< ref "/coding/javadoc" >}})`{=markdown}.
        :::

    *   Einhalten von Coding Conventions

        ::: notes
        *   Regeln zu Schreibweisen und Layout
        *   Leerzeichen, Einrückung, Klammern
        *   Zeilenlänge, Umbrüche
        *   Kommentare
        :::

    *   Einhalten von Prinzipien des objektorientierten Programmierens

        ::: notes
        *   Jede Klasse ist für genau **einen** Aspekt des Systems verantwortlich.
            (_Single Responsibility_)
        *   Keine Code-Duplizierung! (_DRY_ - Don't repeat yourself)
        *   Klassen und Methoden sollten sich erwartungsgemäß verhalten
        *   Kapselung: Möglichst wenig öffentlich zugänglich machen
        :::







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   Citation "_Any fool can write code ..._": [@Fowler2011]
:::
