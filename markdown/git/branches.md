---
type: lecture-cg
title: "Git Branches: Features unabhängig entwickeln und mit Git verwalten"
menuTitle: "Branches"
author: "Carsten Gips (FH Bielefeld)"
weight: 3
readings:
  - key: "Chacon2014"
    comment: "Kapitel 3"
  - key: "AtlassianGit"
  - key: "GitCheatSheet"
tldr: |
  TODO
outcomes:
  - k3: "Erzeugen von Branches"
  - k3: "Mergen von Branches, Auflösen möglicher Konflikte"
  - k3: "Rebasen von Branches"
quizzes:
  - link: "XYZ"
assignments:
  - topic: sheet01
youtube:
  - link: "https://youtu.be/XYZ"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/XYZ"
---


## Aktueller Stand der Entwicklung

    A---B---C  master

[[Konsole]{.bsp}]{.slides}

::: notes
*   Bisher nur lineare Entwicklung: Commits bauen aufeinander auf (lineare Folge von Commits)
*   `master` ist der (Default-) Hauptentwicklungszweig
    *   Pointer auf letzten Commit
    *   Default-Name: "`master`" (muss aber nicht so sein bzw. kann geändert werden)

*Anmerkung*: Git und auch Github haben den Namen für den Default-Branch von `master`
auf `main`geändert. Der Name an sich ist aber für Git bedeutungslos und kann mittels
`git config --global init.defaultBranch <name>` geändert werden. In Github hat der
Default-Branch eine gewisse Bedeutung, beispielsweise ist der Default-Branch das
automatische Ziel beim Anlegen von Pull-Requests. In Github kann man den Default-Namen
global in den User-Einstellungen (Abschnitt "Repositories") und für jedes einzelne
Repository in den Repo-Einstellungen (Abschnitt "Branches") ändern.
:::


## Neues Feature entwickeln/ausprobieren

:::::: columns
::: {.column width="55%"}

    A---B---C  master, wuppie

:::
::: {.column width="45%"}

\bigskip

::: notes
Entwicklung des neuen Features soll stabilen `master`-Branch nicht beeinflussen
=> Eigenen Entwicklungszweig für die Entwicklung des Features anlegen:
:::

*   `git branch wuppie`

    `git checkout wuppie` oder `git switch wuppie`

\bigskip

*   [Alternativ:]{.notes} `git checkout -b wuppie` oder `git switch -c wuppie`

:::
::::::

::: notes
Startpunkt: prinzipiell beliebig (jeder Commit in der Historie möglich).

Die gezeigten Beispiel zweigen den neuen Branch direkt vom aktuell ausgecheckten
Commit/Branch ab. Also aufpassen, was gerade in der Workingcopy los ist!

Alternativ nutzen Sie die Langform: `git branch wuppie master` (mit `master` als
Startpunkt; hier kann jeder beliebige Branch, Tag oder Commit genutzt werden).

Nach Anlegen des neuen Branches zeigen beide Pointer auf den selben Commit.

*Anmerkung*: In neueren Git-Versionen wurde der Befehl "`switch`" eingeführt,
mit dem Sie in der Workingcopy auf einen anderen Branch wechseln können. Der
bisherige Befehl "`checkout`" funktioniert aber weiterhin.
:::


## Arbeiten im Entwicklungszweig ...

              D  wuppie
             /
    A---B---C  master

::: notes
*   Entwicklung des neuen Features erfolgt im eigenen Branch: beeinflusst den
    stabilen `master`-Branch nicht
*   Wenn in der Workingcopy der Feature-Branch ausgecheckt ist, gehen die
    Commits in den Feature-Branch; der `master` bleibt auf dem alten Stand
*   Wenn der `master` ausgecheckt wäre, würden die Änderungen in den `master`
    gehen, d.h. der `master` würde sich ab Commit `C` parallel zu `wuppie`
    entwickeln
:::


## Problem: Fehler im ausgelieferten Produkt

              D  wuppie
             /
    A---B---C  master
             \
              E  fix

\bigskip

::: notes
Fix für `master` nötig:
:::

1.  `git checkout master`
2.  `git checkout -b fix`
3.  Änderungen vornehmen ...

::: notes
`git checkout <branchname>` holt den aktuellen Stand des jeweiligen
Branches in die Workingcopy.

Man kann weitere Branches anlegen, d.h. hier im Beispiel ein neuer
Feature-Branch `fix`, der auf dem `master` basiert. Analog könnte man
auch Branches auf der Basis von `wuppie` anlegen ...
:::


## Fix ist stabil: Integration in *master*

              D  wuppie
             /
    A---B---C---E  master

\bigskip

1.  `git checkout master`
2.  `git merge fix` => [**fast forward**]{.alert} von `master`
3.  `git branch -d fix`

::: notes
Der letzte Schritt entfernt den Namen `fix`.
:::

::: notes
*   Allgemein: `git merge <branchname>` führt die Änderungen im angegebenen Branch
    `<branchname>` in den aktuell in der Workingcopy ausgecheckten Branch ein. Daraus
    resultiert für den aktuell ausgecheckten Branch ein neuer Commit, der Branch
    `<branchname>` bleibt dagegen auf seinem bisherigen Stand.

    Beispiel:
    *   Die Workingcopy ist auf `A`
    *   `git merge B` führt `A` und `B` zusammen: `B` wird **in** `A` gemergt
    *   Wichtig: Der Merge-Commit (sofern nötig) findet hierbei in `A` statt!

    In der Abbildung ist `A` der `master` und `B` der `fix`.

*   Nach dem Merge existieren beide Branches weiter (sofern sie nicht explizit
    gelöscht werden)

*   Hier im Beispiel findet ein sogenannter "Fast forward" statt.

    "Fast forward" ist ein günstiger Spezialfall beim Merge: Beide Branches
    liegen in einer direkten Kette, d.h. der Zielbranch kann einfach
    "weitergeschaltet" werden. Ein Merge-Commit ist in diesem Fall nicht
    notwendig und wird auch nicht angelegt.
:::


## Feature weiter entwickeln ...

              D---F  wuppie
             /
    A---B---C---E  master

\bigskip

1.  `git switch wuppie`
2.  Weitere Änderungen im Branch `wuppie` ...

::: notes
`git switch <branchname>` holt den aktuellen Stand des jeweiligen Branches in
die Workingcopy. Man kann also jederzeit in der Workingcopy die Branches wechseln
und entsprechend weiterarbeiten.

*Hinweis*: Während der neue `git switch`-Befehl nur Branches umschalten kann,
funktioniert `git checkout` sowohl mit Branchnamen und Dateinamen -- damit kann
man also auch eine andere Version einer Datei in der Workingcopy "auschecken".
Falls gleiche Branch- und Dateinamen existieren, muss man für das Auschecken
einer Datei noch "`--`" nutzen: `git checkout -- <dateiname>`.
:::


## Feature ist stabil: Integration in *master*

              D---F  wuppie                                D---F  wuppie
             /                     =>                     /     \
    A---B---C---E  master                    A---B---C---E-------G  master

\bigskip

1.  `git checkout master`
2.  `git merge wuppie` \newline => Kein *fast forward* möglich: Git sucht nach gemeinsamen Vorgänger

::: notes
Hier im Beispiel ist der Standardfall beim Mergen dargestellt: Die beiden
Branches liegen nicht in einer direkten Kette von Commits, d.h. hier wurde
parallel weitergearbeitet.

Git sucht in diesem Fall nach dem gemeinsamen Vorgänger beider Branches und
führt die jeweiligen Änderungen (Differenzen) seit diesem Vorgänger in einem
Merge-Commit zusammen.

Im `master` entsteht ein neuer Commit, da kein *fast forward* beim
Zusammenführen der Branches möglich!

*Anmerkung*: `git checkout wuppie; git merge master` würde den `master` in den
`wuppie` mergen, d.h. der Merge-Commit wäre dann in `wuppie`.


Beachten Sie dabei die "Merge-Richtung":
*   Die Workingcopy ist auf `A`
*   `git merge B` führt `A` und `B` zusammen: `B` wird **in** `A` gemergt
*   Wichtig: Der Merge-Commit (sofern nötig) findet hierbei in `A` statt!

In der Abbildung ist `A` der `master` und `B` der `wuppie`.

**Achtung**: Richtung beachten! `git checkout A; git merge B` führt beide Branches zusammen,
genauer: führt die Änderungen von `B` in `A` ein, d.h. der entsprechende Merge-Commit ist in `A`!
:::


## Konflikte beim Mergen

::: notes
(Parallele) Änderungen an selber Stelle => Merge-Konflikte
:::

    $ git merge wuppie
    Auto-merging hero.java
    CONFLICT (content): Merge conflict in hero.java
    Automatic merge failed; fix conflicts and then commit the result.

\bigskip
\smallskip
\pause

::: notes
Git fügt Konflikt-Marker in die Datei ein:
:::

    <<<<<<< HEAD:hero.java
    public void getActiveAnimation() {
        return null;
    =======
    public Animation getActiveAnimation() {
        return this.idleAnimation;
    >>>>>>> wuppie:hero.java

::: notes
*   Der Teil mit `HEAD` ist aus dem aktuellen Branch in der Workingcopy
*   Der Teil aus dem zu mergenden Branch ist unter `wuppie` notiert
*   Das `=======` trennt beide Bereiche
:::


::: notes
## Merge-Konflikte auflösen

Manuelles Editieren nötig (Auflösung des Konflikts):

1)  Entfernen der Marker
2)  Hinzufügen der Datei zum Index
3)  Analog für restliche Dateien mit Konflikt
4)  Commit zum Abschließen des Merge-Vorgangs

\smallskip

Alternativ: Nutzung graphischer Oberflächen mittels `git mergetool`
:::

[Konsole: Branchen und Mergen]{.bsp}


## Rebasen: Verschieben von Branches

              D---F  wuppie                                D---F  wuppie
             /                     =>                     /     \
    A---B---C---E  master                    A---B---C---E-------G  master

::: notes
Bisher haben wir Branches durch Mergen zusammengeführt. Dabei entsteht in der Regel ein extra
Merge-Commit (im Beispiel `G`), außer es handelt sich um ein *fast forward*. Außerdem erkennt
man in der Historie sehr gut, dass hier in einem separaten Branch gearbeitet wurde, der irgendwann
in den `master` gemergt wurde.

Leider wird dieses Vorgehen in großen Projekten recht schnell sehr unübersichtlich. Außerdem
werden Merges in der Regeln nur von besonders berechtigten Personen (Manager) durchgeführt, die im
Falle von Merge-Konflikten diese dann selbst auflösen müssten (ohne aber die fachliche Befähigung
zu haben). Hier greift man dann häufig zur Alternative *Rebase*. Dabei wird der Ursprung eines
Branches auf einen bestimmten Commit verschoben. Im Anschluss ist dann ein Merge mit *fast forward*,
also ohne die typischen rautenförmigen Ketten in der Historie und ohne extra Merge-Commit möglich.
Dies kann aber auch als Nachteil gesehen werden, da man in der Historie den früheren Branch nicht
mehr erkennt! Ein weiterer schwerwiegender Nachteil ist, dass alle Commits im verschobenen Branch
umgeschrieben werden und damit neue Commit-IDs bekommen. Das verursacht bei der Zusammenarbeit in
Projekten massive Probleme! Als Vorteil gilt, dass man mögliche Merge-Konflikte bereits beim Rebasen
auflösen muss, d.h. hier muss derjenige, der den Merge "beantragt", durch einen vorherigen Rebase den
konfliktfreien Merge sicherstellen. Mehr dazu in `["Branching-Strategien"]({{<ref "/git/branching-strategies" >}})`{=markdown}
und `["Workflows"]({{<ref "/git/workflows" >}})`{=markdown}.
:::

\pause
\bigskip
\bigskip
\bigskip

:::::: columns
:::  {.column width="40%"}
\vspace{14mm}
`git rebase master wuppie`
:::
:::  {.column width="50%"}

                  D'---F'  wuppie
                 /
    A---B---C---E  master

:::
::::::

::: notes
Nach dem Rebase von `wuppie` auf `master` sieht es so aus, als ob der Branch `wuppie`
eben erst vom `master` abgezweigt wurde. Damit ist dann ein *fast forward* Merge von `wuppie`
in den `master` möglich, d.h. es gibt keine Raute und auch keinen extra Merge-Commit (hier nicht
gezeigt).

Man beachte aber die Änderung der Commit-IDs von `wuppie`: Aus `D` wird `D'`! (Datum, Ersteller
und Message bleiben aber erhalten.)
:::


## Don't lose your HEAD

*   Branches sind wie Zeiger auf letzten Stand (Commit) eines Zweiges

*   `HEAD`: Spezieller Pointer
    *   Zeigt auf den aktuellen Branch der Workingcopy

\bigskip

*   Früheren Commit auschecken (ohne Branch): "headless state"
    *   Workingcopy ist auf früherem Commit
    *   Kein Branch => Änderungen gehen verloren!

        ::: notes
        Eventuelle Änderungen würden ganz normal als Commits auf
        dem `HEAD`-Branch aufgezeichnet. Sobald man aber einen
        anderen Branch auscheckt, wird der `HEAD` auf diesen anderen
        Branch gesetzt, so dass die eben gemachten Commits "in der
        Luft hängen". Sofern man die SHA's kennt, kommt man noch auf
        die Commits zurück. Allerdings laufen von Zeit zu Zeit interne
        Aufräum-Aktionen, so dass die Chance gut steht, dass die
        "kopflosen" Commits irgendwann tatsächlich verschwinden.
        :::

[Konsole: Commit auschecken]{.bsp}


## Wrap-Up

*   Anlegen von Branches mit `git branch`
*   Umschalten der Workingcopy auf anderen Branch: `git checkout` oder `git switch`
*   Mergen von Branches und Auflösen von Konflikten: `git merge`
*   Verschieben von Branches mit `git rebase`








<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
