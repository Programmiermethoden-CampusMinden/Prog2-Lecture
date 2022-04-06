---
type: lecture-cg
title: "Testfallermittlung: Wie viel und was muss man testen?"
menuTitle: "Testfallermittlung"
author: "Carsten Gips (FH Bielefeld)"
weight: 3
readings:
  - key: "vogellaJUnit"
  - key: "junit4"
  - key: "Kleuker2019"
  - key: "Osherove2014"
  - key: "Spillner2012"
  - key: "fernunihagenJunit"
tldr: |
  Mit Hilfe der Äquivalenzklassenbildung kann man Testfälle bestimmen. Dabei wird der Eingabebereich
  für jeden Parameter einer Methode in Bereiche mit gleichem Verhalten der Methode eingeteilt (die
  sogenannten "Äquivalenzklassen"). Jede dieser Äquivalenzklassen (ÄK) muss in mindestens einem
  Testfall vorkommen, d.h. man bestimmt einen oder mehrere zufällige Werte in den ÄK. Dabei können
  über mehrere Parameter hinweg verschiedene gültige ÄK in einem Testfall kombiniert werden. Bei den
  ungültigen ÄK kann dagegen immer nur ein Parameter eine ungültige ÄK haben, für die restlichen Parameter
  müssen gültige ÄK genutzt werden, und diese werden dabei als durch diesen Testfall "nicht getestet"
  betrachtet.

  Zusätzlich entstehen häufig Fehler bei den Grenzen der Bereiche, etwa in Schleifen. Deshalb führt
  man zusätzlich noch eine Grenzwertanalyse durch und bestimmt für jede ÄK den unteren und den oberen
  Grenzwert und erzeugt aus diesen Werten zusätzliche Testfälle.

  Wenn in der getesteten Methode der Zustand des Objekts eine Rolle spielt, wird dieser wie ein weiterer
  Eingabeparameter für die Methode betrachtet und entsprechend in die ÄK-Bildung bzw. GW-Analyse einbezogen.
outcomes:
  - k2: "Merkmale schlecht testbaren Codes erklären"
  - k2: "Merkmale guter Unit-Tests erklären"
  - k3: "Erstellen von Testfällen mittels Äquivalenzklassenbildung und Grenzwertanalyse"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet04
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
---


## Hands-On (10 Minuten): Wieviel und was muss man testen?

```java
public class Studi {
    private int credits = 0;

    public void addToCredits(int credits) {
        if (credits < 0) {
            throw new IllegalArgumentException("Negative Credits!");
        }
        if (this.credits + credits > 210) {
            throw new IllegalArgumentException("Mehr als 210 Credits!");
        }
        this.credits += credits;
    }
}
```

::::::::: notes
### _JEDE_ Methode mindestens testen mit/auf:

*   Positive Tests: Gutfall (Normalfall)
*   Negativ-Tests (Fehlbedienung, ungültige Werte)
*   Rand- bzw. Extremwerte
*   Exceptions

=> Anforderungen abgedeckt (Black-Box)?

=> Wichtige Pfade im Code abgedeckt (White-Box)?


### Praxis

*   Je kritischer eine Klasse/Methode/Artefakt ist, um so intensiver testen!
*   Suche nach Kompromissen: Testkosten vs. Kosten von Folgefehlern;
    beispielsweise kein Test generierter Methoden

=> "Erzeugen" der Testfälle über die Äquivalenzklassenbildung und
Grenzwertanalyse (siehe nächste Folien). Mehr dann später im Wahlfach "Softwarequalität" ...
:::::::::


## Äquivalenzklassenbildung

::: notes
Beispiel: Zu testende Methode mit Eingabewert _x_, der zw. 10 und 100 liegen soll
:::

![](images/aequivalenzklassen.png){width="60%" web_width="40%"}

\bigskip

*   Zerlegung der Definitionsbereiche in Äquivalenzklassen (ÄK):
    *   Disjunkte Teilmengen, wobei
    *   Werte *einer* ÄK führen zu *gleichartigem* Verhalten

*   Annahme: Eingabeparameter sind untereinander unabhängig

*   Unterscheidung gültige und ungültige ÄK

[[Beispiel: Eingabeparameter _x_ zw. 10 und 100]{.bsp}]{.slides}


::::::::: notes
### Bemerkungen

Hintergrund: Da die Werte einer ÄK zu gleichartigem Verhalten führen, ist es
egal, *welchen* Wert man aus einer ÄK für den Test nimmt.

Formal hat man *eine* ungültige ÄK (d.h. die Menge aller ungültigen Werte). In
der Programmierpraxis macht es aber einen Unterschied, ob es sich um Werte
unterhalb oder oberhalb des erlaubten Wertebereichs handelt
(Fallunterscheidung). Beispiel: Eine Funktion soll Werte zwischen 10 und 100
verarbeiten. Dann sind alle Werte kleiner 10 oder größer 100 mathematisch
gesehen in der selben ÄK "ungültig". Praktisch macht es aber Sinn, eine
ungültige ÄK für "kleiner 10" und eine weitere ungültige ÄK für "größer 100"
zu betrachten ...

Traditionell betrachtet man nur die Eingabeparameter. Es kann aber Sinn machen,
auch die Ausgabeseite zu berücksichtigen (ist aber u.U. nur schwierig zu
realisieren).


### Faustregeln bei der Bildung von ÄK

*   Falls eine Beschränkung einen Wertebereich spezifiziert:
    Aufteilung in eine gültige und zwei ungültige ÄK

    Beispiel: Eingabewert _x_ soll zw. 10 und 100 liegen

    *   Gültige ÄK: $[10, 100]$
    *   Ungültige ÄKs: $x < 10$ und $100 < x$

*   Falls eine Beschränkung eine minimale und maximale Anzahl von Werten
    spezifiziert:
    Aufteilung in eine gültige und zwei ungültige ÄK

    Beispiel: Jeder Studi muss pro Semester an mindestens einer LV teilnehmen,
    maximal sind 5 LVs erlaubt.

    *   Gültige ÄK: $1 \le x \le 5$
    *   Ungültige ÄKs: $x = 0$ (keine Teilnahme) und $5 < x$ (mehr als 5 Kurse)

*   Falls eine Beschränkung eine Menge von Werten spezifiziert, die
    möglicherweise unterschiedlich behandelt werden:
    Für jeden Wert dieser Menge eine eigene gültige ÄK erstellen und zusätzlich
    insgesamt eine ungültige ÄK

    Beispiel: Das Hotel am Urlaubsort ermöglicht verschiedene Freizeitaktivitäten:
    Segway-fahren, Tauchen, Tennis, Golf

    *   Gültige ÄKs:
        *   Segway-fahren
        *   Tauchen
        *   Tennis
        *   Golf
    *   Ungültige ÄK: "alles andere"

*   Falls eine Beschränkung eine Situation spezifiziert, die zwingend erfüllt sein muss:
    Aufteilung in eine gültige und eine ungültige ÄK


*Hinweis*: Werden Werte einer ÄK vermutlich nicht gleichwertig behandelt, dann
erfolgt die Aufspaltung der ÄK in kleinere ÄKs. Das ist im Grunde die analoge
Überlegung zu mehreren ungültigen ÄKs.

ÄKs sollten für die weitere Arbeit einheitlich und eindeutig benannt werden.
Typisches Namensschema: "gÄKn" und "uÄKn" für gültige bzw. ungültige ÄKs mit
der laufenden Nummer $n$.
:::::::::


## ÄK: Erstellung der Testfälle

::: notes
*   Aus jeder ÄK wird ein Repräsentant gewählt
*   Prinzipiell: Paarweise vollständige Kombination, d.h. jeder Repräsentant
    einer ÄK kommt mit jedem Repräsentanten jeder anderen ÄK in einem Testfall
    (TF) zur Ausführung

*   Erinnerung: Annahme: Eingabeparameter sind untereinander unabhängig

    => Es reicht, wenn jeder Repräsentant einer ÄK *einmal* in einem
    TF zur Ausführung kommt => Kombination verschiedener
    Repräsentanten in *einem* TF

    **Achtung**: Dies gilt nur für die **gültigen** ÄK! Bei den ungültigen
    ÄKs sollten Repräsentanten nicht miteinander in einem TF kombiniert werden!
    Bei gleichzeitiger Behandlung verschiedener ungültiger ÄK bleiben u.U.
    Fehler unentdeckt, da sich die Wirkungen der ungültigen ÄK überlagern!
:::

*   Alle ÄKs durch _mindestens_ **einen TF** abdecken

\smallskip

*   Dabei pro Testfall
    *   *mehrere gültige ÄKs* kombinieren, oder
    *   genau *eine ungültige ÄK* untersuchen
        (restl. Werte aus gültigen ÄK auffüllen; diese gelten dann aber
        nicht als getestet!)


## ÄK: Beispiel: Eingabewert _x_ soll zw. 10 und 100 liegen

### Äquivalenzklassen

| Eingabe | gültige ÄK        | ungültige ÄK    |
|:--------|:------------------|:----------------|
| _x_     | gÄK1: $[10, 100]$ | uÄK2: $x < 10$  |
|         |                   | uÄK3: $100 < x$ |

\bigskip
\pause

### Tests

| Testnummer          | 1    | 2         | 3         |
|:--------------------|:-----|:----------|:----------|
| geprüfte ÄK         | gÄK1 | uÄK2      | uÄK3      |
| _x_                 | 42   | 7         | 120       |
| Erwartetes Ergebnis | OK   | Exception | Exception |


## Grenzwertanalyse

![](images/grenzwerte.png){width="60%" web_width="40%"}

\bigskip

Beobachtung: Grenzen in Verzweigungen/Schleifen kritisch

*   Grenzen der ÄK (kleinste und größte Werte) **zusätzlich** testen
    *   "gültige Grenzwerte" (*gGW*): Grenzwerte von gültigen ÄK
    *   "ungültige Grenzwerte" (*uGW*): Grenzwerte von ungültigen ÄK

::: notes
Zusätzlich sinnvoll:
*   Werte "rechts" und "links" der Grenze
*   Weitere grenzwertnahe Werte

Bildung der Testfälle:
:::

*   Jeder GW muss in mind. einem TF vorkommen

[[Beispiel: Eingabeparameter _x_ zw. 10 und 100]{.bsp}]{.slides}


## GW: Beispiel: Eingabewert _x_ soll zw. 10 und 100 liegen

### Äquivalenzklassen

| Eingabe | gültige ÄK        | ungültige ÄK    |
|:--------|:------------------|:----------------|
| _x_     | gÄK1: $[10, 100]$ | uÄK2: $x < 10$  |
|         |                   | uÄK3: $100 < x$ |


### Grenzwertanalyse

[Zusätzliche Testdaten:]{.notes} 9 (uÄK2o) und 10 (gÄK1u) sowie 100 (gÄK1o) und 101 (uÄK3u)

\pause

### Tests

| Testnummer          | 1     | 2     | 3         | 4         |
|:--------------------|:------|:------|:----------|:----------|
| geprüfte ÄK         | gÄK1u | gÄK1o | uÄK2o     | uÄK3u     |
| _x_                 | 10    | 100   | 9         | 101       |
| Erwartetes Ergebnis | OK    | OK    | Exception | Exception |


::: notes
**Hinweis**: Es gibt auch Ansätze, wonach die Ergebnisse der GW-Analyse **zusätzlich**
zu den Werten aus der ÄK-Analyse eingesetzt werden. In diesem Fall würde man für das
obige Beispiel folgende Tests aus der kombinierten ÄK- und GW-Analyse erhalten:

| Testnummer          | 1    | 2         | 3         | 4     | 5     | 6         | 7         |
|:--------------------|:-----|:----------|:----------|:------|:------|:----------|:----------|
| geprüfte ÄK         | gÄK1 | uÄK2      | uÄK3      | gÄK1u | gÄK1o | uÄK2o     | uÄK3u     |
| _x_                 | 42   | 7         | 120       | 10    | 100   | 9         | 101       |
| Erwartetes Ergebnis | OK   | Exception | Exception | OK    | OK    | Exception | Exception |
:::


::: notes
## Anmerkung: Analyse abhängiger Parameter

Wenn das Ergebnis von der Kombination der Eingabewerte abhängt, dann
sollte man dies bei der Äquivalenzklassenbildung berücksichtigen: Die
ÄK sind in diesem Fall in Bezug auf die Kombinationen zu bilden!

Schauen Sie sich dazu das Beispiel im @Kleuker2019, Abschnitt
"4.3 Analyse abhängiger Parameter" an.

Die einfache ÄK-Bildung würde in diesem Fall versagen, da die Eingabewerte
nicht unabhängig sind. Leider ist die Betrachtung der möglichen Kombinationen
u.U. eine sehr komplexe Aufgabe ...


Analoge Überlegungen gelten auch für die ÄK-Bildung im Zusammenhang mit
objektorientierter Programmierung. Die Eingabewerte und der Objektzustand
müssen dann _gemeinsam_ bei der ÄK-Bildung betrachtet werden!

Vergleiche @Kleuker2019, Abschnitt "4.4 Äquivalenzklassen und Objektorientierung".
:::


## Wrap-Up

  *   Gründliches Testen ist ebenso viel Aufwand wie Coden
  *   Äquivalenzklassenbildung und Grenzwertanalyse







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
