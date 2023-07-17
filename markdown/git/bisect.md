---
archetype: lecture-cg
title: "Fehlersuche mit Git Bisect"
menuTitle: "Bisect"
author: "Carsten Gips (HSBI)"
weight: 7
readings:
  - key: "Chacon2014"
    comment: "Abschnitt 7.10 (Git Tools)"
  - key: "AtlassianGit"
  - key: "GitCheatSheet"
tldr: |
  Mit Git Bisect kann man durch Halbierungssuche den Commit finden, der einen
  bestimmten Fehler eingeführt hat.

  Dazu startet man den Prozess mit `git bisect start` und teilt Git jeweils den
  letzten bekannten "guten" und den ersten bekannten fehlerhaften Commit mit:
  `git bisect good <commit>` und `git bisect bad <commit>`. Anschließend sucht
  Git einen Commit dazwischen und "präsentiert" diesen in der Workingcopy. Wenn
  der Commit noch fehlerfrei ist, antwortet man mit `git bisect good`, sonst mit
  `git bisect bad`. Auf diese Weise grenzt man den Commit ein, der den Fehler
  eingeführt hat.

  Man kann die Workingcopy mit `git bisect reset` anschließend wieder zurücksetzen.

  Der Prozess lässt sich automatisieren mit `git bisect run <my_script> <arguments>`,
  wobei Git automatisch bei jedem untersuchten Commit das Skript ausführt und
  entsprechend reagiert (die Rückgabe 0 bedeutet dabei "OK", ein anderer Rückgabewert
  bedeutet "Fehler").
outcomes:
  - k3: "Fehlersuche mit Git Bisect"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106247&client_id=FH-Bielefeld"
    name: "Quiz Git Bisect (ILIAS)"
youtube:
  - link: "https://youtu.be/9XWwefIokPg"
    name: "VL Git Bisect"
  - link: "https://youtu.be/hiiugrQMNR4"
    name: "Demo Git Bisect"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/c844865038e41cf59adebab0244758e61af9cf2c76233962be711920ff8f2d614d1a8012ec85d47cf421eaa94a9efedf0917bf369f3adb495c018796d3d89b13"
    name: "VL Git Bisect"
---


## Git Bisect: Wer hats wann kaputt gespielt?

::::::::: notes
### Szenario

*   Sie haben eine Software ausgeliefert, die offenbar gut funktioniert.
*   Sie erweitern die Software und testen intern mit JUnit.
*   Nachdem Sie keine Fehler mehr gefunden haben, erstellen Sie ein neues
    Release und liefern die neue Version aus.
*   Die Kunden beschweren sich über Fehler ....
*   Sie erstellen einen neuen Test mit JUnit für das von den Kunden beschriebene
    Verhalten und können das Problem verifizieren. Offenbar haben Sie vorher
    nicht gründlich genug getestet.
*   Sie haben leider keine Idee, woran der Fehler liegt (der Test ist eher
    ein Systemtest) und wann er sich in die Code-Basis eingeschlichen hat.

=> Hier schlägt die Stunde von Git Bisect :-)

### Arbeitsweise
:::::::::


1.  Git Bisect initialisieren

        git bisect start
        git bisect good <commit>
        git bisect bad <commit>

\smallskip

2.  Git präsentiert einen Commit zwischen `<good commit>` und `<bad commit>`
    *   Alles OK: `git bisect good`
    *   Fehler vorhanden: `git bisect bad`

        => Git sucht nächsten Commit dazwischen ...

\smallskip

3.  Workingcopy zurücksetzen: `git bisect reset`

[Live-Demo]{.bsp href="https://youtu.be/hiiugrQMNR4"}


::::::::: notes
### Anmerkungen

*   Geht auch mit `new`/`old` (statt `good`/`bad`)
*   Suche kann auch automatisiert werden: `git bisect run <my_script> <arguments>`
    *   Skript `my_skript` wird bei jedem Stopp ausgeführt
    *   Ergebnis (Rückgabewert) wird zur Interpretation `good`/`bad` herangezogen:
        *   Wert 0 für `good`
        *   Wert 1 für `bad`
*   Wenn Git Bisect einen Commit auswählt, der nicht compiliert o.ä.
    (kann eigentlich nicht vorkommen, da wir so etwas ja NIE einchecken!),
    dann kann man einen in der Nähe liegenden Commit als Ersatz
    auswählen lassen: `git bisect skip`

### Tutorial

Ein schönes Tutorial finden Sie auf
["A beginner's guide to GIT BISECT - The process of elimination"](https://www.metaltoad.com/blog/beginners-guide-git-bisect-process-elimination).
:::::::::


## Wrap-Up

*   Git Bisect: Finde Commit, der einen Fehler einführt (Halbierungs-Suche)







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
