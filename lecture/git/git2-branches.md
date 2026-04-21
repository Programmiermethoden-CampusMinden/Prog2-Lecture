---
author: Carsten Gips (HSBI)
title: "Git Branches: Features unabhängig entwickeln und mit Git verwalten"
---

::: tldr
Die Commits in Git bauen aufeinander auf und bilden dabei eine verkettete "Liste".
Diese "Liste" nennt man auch *Branch* (Entwicklungszweig). Beim Initialisieren eines
Repositories wird automatisch ein Default-Branch angelegt, auf dem die Commits dann
eingefügt werden.

Weitere Branches kann man mit `git branch` anlegen, und die Workingcopy kann mit
`git switch` oder `git checkout` auf einen anderen Branch umgeschaltet werden. Auf
diese Weise kann man an mehreren Features parallel arbeiten, ohne dass die Arbeiten
sich gegenseitig stören.

Zum Mergen (Vereinigen) von Branches gibt es `git merge`. Dabei werden die
Änderungen im angegebenen Branch in den aktuell in der Workingcopy ausgecheckten
Branch integriert und hier ggf. ein neuer Merge-Commit erzeugt. Falls es in beiden
Branches inkompatible Änderungen an der selben Stelle gab, entsteht beim Mergen ein
Merge-Konflikt. Dabei zeigt Git in den betroffenen Dateien jeweils an, welche
Änderung aus welchem Branch stammt und man muss diesen Konflikt durch Editieren der
Stellen manuell beheben.

Mit `git rebase` kann die Wurzel eines Branches an eine andere Stelle verschoben
werden. Dies wird später bei Workflows eine Rolle spielen.

Beim Klonen eines Repositories mit `git clone <url>` wird das fremde Repo mit dem
Namen `origin` im lokalen Repo festgehalten. Dieser Name wird auch als Präfix für
die Branches in diesem Repo genutzt, d.h. die Branches im Remote-Repo tauchen als
`origin/<branch>` im lokalen Repo auf. Diese Remote-Branches kann man nicht direkt
bearbeiten, sondern man muss diese Remote-Branches in einem lokalen Branch
auschecken und dann darin weiterarbeiten. Es können beliebig viele weitere Remotes
dem eigenen Repository hinzugefügt werden.

Änderungen aus einem Remote-Repo können mit `git fetch <remote>` in das lokale Repo
geholt werden. Dies aktualisiert **nur** die Remote-Branches `<remote>/<branch>`!
Die Änderungen können anschließend mit `git merge <remote>/<branch>` in den aktuell
in der Workingcopy ausgecheckten Branch gemergt werden. (*Anmerkung*: Wenn mehrere
Personen an einem Branch arbeiten, will man die eigenen Arbeiten in dem Branch
vermutlich eher auf den aktuellen Stand des Remote **rebasen** statt mergen!) Eigene
Änderungen können mit `git push <remote> <branch>` in das Remote-Repo geschoben
werden.

Um den Umgang mit den Remote-Branches und den davon abgeleiteten lokalen Branches zu
vereinfachen, gibt es das Konzept der "Tracking Branches". Dabei "folgt" ein lokaler
Branch einem Remote-Branch. Ein einfaches `git pull` oder `git push` holt dann
Änderungen aus dem Remote-Branch in den ausgecheckten lokalen Branch bzw. schiebt
Änderungen im lokalen Branch in den Remote-Branch.
:::

::: youtube
-   [VL Git Branches](https://youtu.be/WXPJOsgeR10)
-   [Demo Anlegen und Mergen von Branches](https://youtu.be/B8sesK1GyiE)
-   [Demo Auflösen von Merge-Konflikten](https://youtu.be/iEr9i8auF7c)
-   [Demo HEAD](https://youtu.be/U4gd0FBBqZQ)

-   [VL Git Remotes](https://youtu.be/_uhEseblDYU)
-   [Demo Fetch, Pull und Push](https://youtu.be/moqywsxtEy8)
-   [Demo Tracking-Branches](https://youtu.be/0RoqM5Wmxfc)
-   [Demo Verknüpfen weiterer Remotes](https://youtu.be/jL4AvSsjjKg)

[Introduction to Git with Scott Chacon of GitHub (zweiter Teil, ab ca. Minute
45)](https://youtu.be/ZDR433b0HJY)
:::

# Neues Feature entwickeln/ausprobieren

    A---B---C  master

::: notes
-   Bisher nur lineare Entwicklung: Commits bauen aufeinander auf (lineare Folge von
    Commits)
-   `master` ist der (Default-) Hauptentwicklungszweig
    -   Pointer auf letzten Commit
    -   Default-Name: "`master`" (muss aber nicht so sein bzw. kann geändert werden)

*Anmerkung*: Git und auch Github haben den Namen für den Default-Branch von `master`
auf `main`geändert. Der Name an sich ist aber für Git bedeutungslos und kann mittels
`git config --global init.defaultBranch <name>` geändert werden. In Github hat der
Default-Branch eine gewisse Bedeutung, beispielsweise ist der Default-Branch das
automatische Ziel beim Anlegen von Pull-Requests. In Github kann man den
Default-Namen global in den User-Einstellungen (Abschnitt "Repositories") und für
jedes einzelne Repository in den Repo-Einstellungen (Abschnitt "Branches") ändern.
:::

\bigskip
\pause

::: notes
Entwicklung des neuen Features soll stabilen `master`-Branch nicht beeinflussen =\>
Eigenen Entwicklungszweig für die Entwicklung des Features anlegen:
:::

1.  [Neuen Branch erstellen:]{.notes} `git branch wuppie`
2.  [Neuen Branch auschecken:]{.notes} `git checkout wuppie` oder
    `git switch wuppie`

::: notes
Alternativ: `git checkout -b wuppie` oder `git switch -c wuppie` [(neuer Branch und
auschecken in einem Schritt)]{.notes}
:::

    A---B---C  master, wuppie

::: notes
Startpunkt: prinzipiell beliebig (jeder Commit in der Historie möglich).

Die gezeigten Beispiel zweigen den neuen Branch direkt vom aktuell ausgecheckten
Commit/Branch ab. Also aufpassen, was gerade in der Workingcopy los ist!

Alternativ nutzen Sie die Langform: `git branch wuppie master` (mit `master` als
Startpunkt; hier kann jeder beliebige Branch, Tag oder Commit genutzt werden).

Nach Anlegen des neuen Branches zeigen beide Pointer auf den selben Commit.

`git switch <branchname>` bzw. `git checkout <branchname>`holt den aktuellen Stand des jeweiligen Branches in die
Workingcopy. Man kann also jederzeit in der Workingcopy die Branches wechseln und
entsprechend weiterarbeiten.

*Anmerkung*: In neueren Git-Versionen wurde der Befehl "`switch`" eingeführt, mit
dem Sie in der Workingcopy auf einen anderen Branch wechseln können. Der bisherige
Befehl "`checkout`" funktioniert aber weiterhin.
Während der neue `git switch`-Befehl allerdings nur Branches umschalten kann,
funktioniert `git checkout` sowohl mit Branchnamen und Dateinamen - damit kann man
also auch eine andere Version einer Datei in der Workingcopy "auschecken". Falls
gleiche Branch- und Dateinamen existieren, muss man für das Auschecken einer Datei
noch "`--`" nutzen: `git checkout -- <dateiname>`.
:::

\bigskip

...

::: notes
Commit(s) auf `wuppie` ...
:::


              D  wuppie
             /
    A---B---C  master

::: notes
-   Entwicklung des neuen Features erfolgt im eigenen Branch: beeinflusst den
    stabilen `master`-Branch nicht
-   Wenn in der Workingcopy der Feature-Branch ausgecheckt ist, gehen die Commits in
    den Feature-Branch; der `master` bleibt auf dem alten Stand
-   Wenn der `master` ausgecheckt wäre, würden die Änderungen in den `master` gehen,
    d.h. der `master` würde sich ab Commit `C` parallel zu `wuppie` entwickeln
:::

[[Konsole]{.ex}]{.slides}

# Problem: Fehler im ausgelieferten Produkt

::: notes
Fix für `master` nötig:
:::

1.  `git checkout master`
2.  `git checkout -b fix`
3.  Änderungen in `fix` vornehmen ...

\bigskip
\smallskip

::: notes
Das führt zu dieser Situation:
:::


              D  wuppie                                D  wuppie
             /                                        /
    A---B---C  master              =>        A---B---C  master
                                                      \
                                                       E  fix

::: notes
`git checkout <branchname>` holt den aktuellen Stand des jeweiligen Branches in die
Workingcopy. (Das geht in neueren Git-Versionen auch mit `git switch <branchname>`.)

Man kann weitere Branches anlegen, d.h. hier im Beispiel ein neuer Feature-Branch
`fix`, der auf dem `master` basiert. Analog könnte man auch Branches auf der Basis
von `wuppie` anlegen ...
:::

# Fix ist stabil: Integration in *master*

1.  `git checkout master`
2.  `git merge fix` =\> **fast forward** von `master`
3.  `git branch -d fix`

::: notes
Der letzte Schritt entfernt den Branch `fix`.
:::

\bigskip
\smallskip

              D  wuppie                                D  wuppie
             /                                        /
    A---B---C  master              =>        A---B---C---E  master
             \
              E  fix

::: notes
-   Allgemein: `git merge <branchname>` führt die Änderungen im angegebenen Branch
    `<branchname>` in den aktuell in der Workingcopy ausgecheckten Branch ein.
    Daraus resultiert für den aktuell ausgecheckten Branch ein neuer Commit, der
    Branch `<branchname>` bleibt dagegen auf seinem bisherigen Stand.

    Beispiel:

    -   Die Workingcopy ist auf `A`
    -   `git merge B` führt `A` und `B` zusammen: `B` wird **in** `A` gemergt
    -   Wichtig: Der Merge-Commit (sofern nötig) findet hierbei in `A` statt!

    In der Abbildung ist `A` der `master` und `B` der `fix`.

-   Nach dem Merge existieren beide Branches weiter (sofern sie nicht explizit
    gelöscht werden)

-   Hier im Beispiel findet ein sogenannter "Fast forward" statt.

    "Fast forward" ist ein günstiger Spezialfall beim Merge: Beide Branches liegen
    in einer direkten Kette, d.h. der Zielbranch kann einfach "weitergeschaltet"
    werden. Ein Merge-Commit ist in diesem Fall nicht notwendig und wird auch nicht
    angelegt.
:::

# Feature weiter entwickeln und Integration in *master*

1.  `git checkout master`
2.  `git merge wuppie` `\newline`{=tex}=\> Kein *fast forward* möglich: Git sucht
    nach gemeinsamen Vorgänger + neuer Commit

\bigskip
\smallskip

              D---F  wuppie                            D---F  wuppie
             /                     =>                 /     \
    A---B---C---E  master                    A---B---C---E---G  master

::: notes
Hier im Beispiel ist der Standardfall beim Mergen dargestellt: Die beiden Branches
liegen nicht in einer direkten Kette von Commits, d.h. hier wurde parallel
weitergearbeitet.

Git sucht in diesem Fall nach dem gemeinsamen Vorgänger beider Branches und führt
die jeweiligen Änderungen (Differenzen) seit diesem Vorgänger in einem Merge-Commit
zusammen.

Im `master` entsteht ein neuer Commit, da kein *fast forward* beim Zusammenführen
der Branches möglich!

*Anmerkung*: `git checkout wuppie; git merge master` würde den `master` in den
`wuppie` mergen, d.h. der Merge-Commit wäre dann in `wuppie`.

Beachten Sie dabei die "Merge-Richtung":

-   Die Workingcopy ist auf `A`
-   `git merge B` führt `A` und `B` zusammen: `B` wird **in** `A` gemergt
-   Wichtig: Der Merge-Commit (sofern nötig) findet hierbei in `A` statt!

In der Abbildung ist `A` der `master` und `B` der `wuppie`.

**Achtung**: Richtung beachten! `git checkout A; git merge B` führt beide Branches
zusammen, genauer: führt die Änderungen von `B` in `A` ein, d.h. der entsprechende
Merge-Commit ist in `A`!
:::

# Konflikte beim Mergen

::: notes
Merksatz: (Parallele) Änderungen an selber Stelle =\> Merge-Konflikte
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
-   Der Teil mit `HEAD` ist aus dem aktuellen Branch in der Workingcopy
-   Der Teil aus dem zu mergenden Branch ist unter `wuppie` notiert
-   Das `=======` trennt beide Bereiche
:::

::: notes
# Merge-Konflikte auflösen

Manuelles Editieren nötig (Auflösung des Konflikts):

1)  Entfernen der Marker
2)  Hinzufügen der Datei zum Index
3)  Analog für restliche Dateien mit Konflikt
4)  Commit zum Abschließen des Merge-Vorgangs

\smallskip

Alternativ: Nutzung graphischer Oberflächen mittels `git mergetool`
:::

[Konsole: Branchen und Mergen]{.ex href="https://youtu.be/B8sesK1GyiE"}

# Rebasen: Verschieben von Branches

              D---F  wuppie                            D---F  wuppie
             /                     =>                 /     \
    A---B---C---E  master                    A---B---C---E---G  master

::: notes
Bisher haben wir Branches durch Mergen zusammengeführt. Dabei entsteht in der Regel
ein extra Merge-Commit (im Beispiel `G`), außer es handelt sich um ein *fast
forward*. Außerdem erkennt man in der Historie sehr gut, dass hier in einem
separaten Branch gearbeitet wurde, der irgendwann in den `master` gemergt wurde.

Leider wird dieses Vorgehen in großen Projekten recht schnell sehr unübersichtlich.
Außerdem werden Merges in der Regeln nur von besonders berechtigten Personen
(Manager) durchgeführt, die im Falle von Merge-Konflikten diese dann selbst auflösen
müssten (ohne aber die fachliche Befähigung zu haben). Hier greift man dann häufig
zur Alternative *Rebase*. Dabei wird der Ursprung eines Branches auf einen
bestimmten Commit verschoben. Im Anschluss ist dann ein Merge mit *fast forward*,
also ohne die typischen rautenförmigen Ketten in der Historie und ohne extra
Merge-Commit möglich. Dies kann aber auch als Nachteil gesehen werden, da man in der
Historie den früheren Branch nicht mehr erkennt! Ein weiterer schwerwiegender
Nachteil ist, dass alle Commits im verschobenen Branch umgeschrieben werden und
damit neue Commit-IDs bekommen. Das verursacht bei der Zusammenarbeit in Projekten
massive Probleme! Als Vorteil gilt, dass man mögliche Merge-Konflikte bereits beim
Rebasen auflösen muss, d.h. hier muss derjenige, der den Merge "beantragt", durch
einen vorherigen Rebase den konfliktfreien Merge sicherstellen. Mehr dazu in
["Branching-Strategien & Git-Workflows"](git3-workflows.md).
:::

\pause
\bigskip
\bigskip
\bigskip

:::::: columns
:::: {.column width="40%"}
\vspace{4mm}

    git rebase master wuppie

::: notes
führt zu
:::
::::

::: {.column width="40%"}
                  D'---F'  wuppie
                 /
    A---B---C---E  master
:::
::::::

::: notes
Nach dem Rebase von `wuppie` auf `master` sieht es so aus, als ob der Branch
`wuppie` eben erst vom `master` abgezweigt wurde. Damit ist dann ein *fast forward*
Merge von `wuppie` in den `master` möglich, d.h. es gibt keine Raute und auch keinen
extra Merge-Commit (hier nicht gezeigt).

Man beachte aber die Änderung der Commit-IDs von `wuppie`: Aus `D` wird `D'`!
(Datum, Ersteller und Message bleiben aber erhalten.)
:::

::: notes
# Don't lose your HEAD

-   Branches sind wie Zeiger auf letzten Stand (Commit) eines Zweiges

-   `HEAD`: Spezieller Pointer

    -   Zeigt auf den aktuellen Branch der Workingcopy

\bigskip

-   Früheren Commit auschecken (ohne Branch): "headless state"
    -   Workingcopy ist auf früherem Commit

    -   Kein Branch =\> Änderungen gehen verloren!

        ::: notes
        Eventuelle Änderungen würden ganz normal als Commits auf dem `HEAD`-Branch
        aufgezeichnet. Sobald man aber einen anderen Branch auscheckt, wird der
        `HEAD` auf diesen anderen Branch gesetzt, so dass die eben gemachten Commits
        "in der Luft hängen". Sofern man die SHA's kennt, kommt man noch auf die
        Commits zurück. Allerdings laufen von Zeit zu Zeit interne Aufräum-Aktionen,
        so dass die Chance gut steht, dass die "kopflosen" Commits irgendwann
        tatsächlich verschwinden.
        :::

[[Konsole: Commit auschecken]{.ex}]{.slides}
:::




# Erinnerung: Clonen kann sich lohnen => Remote-Branches

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E  master

\bigskip

=\> `git clone https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture`

\bigskip

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E  master
               ^origin/master

::: notes
Erinnerung: Git-Repository mit der URL `<URL-Repo>` in lokalen Ordner `<directory>` auschecken: `git clone <URL-Repo> [<directory>]`.

Für die URL sind verschiedene Protokolle möglich, beispielsweise:

-   "`file://`" für über das Dateisystem erreichbare Repositories (ohne Server)
-   "`https://`" für Repo auf einem Server: Authentifikation mit Username und
    Passwort (!)
-   "`git@`" für Repo auf einem Server: Authentifikation mit **SSH-Key** (diese
    Variante wird im Praktikum im Zusammenspiel mit dem Gitlab-Server im SW-Labor
    verwendet)

Neue Beobachtung: Die Workingcopy ist automatisch über den Namen `origin` mit dem Remote-Repo (gern auch "Remote" oder "Upstream" genannt) auf dem Server verbunden. Der lokale Branch `master` ist automatisch mit dem Remote-Branch `origin/master` verbunden, der den Stand des `master`-Branches auf dem Server spiegelt.

Mit `git remote add <name> <url>` kann man beliebig viele weitere Remotes hinzufügen. Das Arbeiten mit den weiteren Remotes unterscheidet sich nicht von dem hier gezeigten Vorgehen mit dem Default-Remote `origin`.
:::

# Eigener und entfernter *master* entwickeln sich weiter ...

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E---F---G  master

\bigskip

[]{.notes}

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E---H  master
               ^origin/master

::: notes
Nach dem Auschecken liegen (in diesem Beispiel) drei `master`-Branches vor:

1.  Der `master` auf dem Server,
2.  der lokale `master`, und
3.  die lokale Referenz auf den `master`-Branch auf dem Server: `origin/master`.

Der lokale `master` ist ein normaler Branch und kann durch Commits verändert werden.

Der `master` auf dem Server kann sich ebenfalls ändern, beispielsweise weil jemand
anderes seine lokalen Änderungen mit dem Server abgeglichen hat (`git push`, s.u.).

Der Branch `origin/master` lässt sich nicht direkt verändern! Das ist lediglich eine
lokale Referenz auf den `master`-Branch auf dem Server und zeigt an, welchen Stand
man bei der letzten Synchronisierung hatte. D.h. erst mit dem nächsten Abgleich wird
sich dieser Branch ändern (sofern sich der entsprechende Branch auf dem Server
verändert hat).

*Anmerkung*: Dies gilt analog für alle anderen Branches. Allerdings wird nur der
`origin/master` beim Clonen automatisch als lokaler Branch ausgecheckt.

Zur Abbildung: Während man lokal arbeitet (Commit `H` auf dem lokalen `master`),
kann es passieren, dass sich auch das remote Repo ändert. Im Beispiel wurden dort
die beiden Commits `F` und `G` angelegt (durch `git push`, s.u.).

Wichtig: Da in der Zwischenzeit das lokale Repo nicht mit dem Server abgeglichen
wurde, zeigt der remote Branch `origin/master` immer noch auf den Commit `E`!
:::

# Änderungen vom Remote holen und Branches lokal zusammenführen

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E---F---G  master

\bigskip

=\> `git fetch origin`

\bigskip

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E---H  master
                \
                 F---G  origin/master

::: notes
## Änderungen auf dem Server mit dem eigenen Repo abgleichen

Mit `git fetch origin` alle Änderungen holen

-   Alle remote Branches werden aktualisiert und entsprechen den jeweiligen Branches
    auf dem Server: Im Beispiel zeigt jetzt `origin/master` ebenso wie der `master`
    auf dem Server auf den Commit `G`.
-   Neue Branches auf dem Server werden ebenfalls "geholt", d.h. sie liegen nach dem
    Fetch als entsprechende remote Branches vor
-   Auf dem Server gelöschte Branches werden nicht automatisch lokal gelöscht; dies
    kann man mit `git fetch --prune origin` automatisch erreichen

*Wichtig*: Es werden nur die remote Branches aktualisiert, nicht die lokalen
Branches!

## *master*-Branch nach "git fetch origin" zusammenführen

1.  Mit `git checkout master` Workingcopy auf eigenen `master` umstellen
2.  Mit `git merge origin/master` Änderungen am `origin/master` in eigenen `master`
    mergen

[]{.notes}

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E---F---G  master

[]{.notes}

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E---H---I  master
                \     /
                 F---G  origin/master

*Anmerkung*: Schritt (2) kann man auch direkt per `git pull origin master` erledigen ...
Ein `pull` fasst `fetch` und `merge` zusammen.

*Anmerkung* Statt dem `merge` in Schritt (2) kann man auch den lokalen `master` auf
den aktualisierten `origin/master` rebasen und vermeidet damit die "Raute". Der
`pull` kann mit der Option "`--rebase`" auf "rebase" umgestellt werden (per Default
wird bei `pull` ein "merge" ausgeführt).

## *master*-Branch ins Remote pushen

1.  Mit `git push origin master` eigene Änderungen ins Remote-Repo pushen

[]{.notes}

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E---H---I  master
                \     /
                 F---G

[]{.notes}

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E---H---I  master
                \     /^origin/master
                 F---G

## Achtung: Auf dem Server ist nur ein *fast forward merge* möglich

Sie können Ihre Änderungen in Ihrem lokalen `master` auch direkt in das remote Repo
pushen, solange auf dem Server ein **fast forward merge** möglich ist.

Wenn aber (wie in der Abbildung) der lokale und der remote `master` divergieren,
müssen Sie den Merge wie beschrieben lokal durchführen (`fetch`/`merge` oder `pull`)
und das Ergebnis wieder in das remote Repo pushen (dann ist ja wieder ein *fast
forward merge* möglich, es sei denn, jemand hat den remote `master` in der
Zwischenzeit weiter geschoben - dann muss die Aktualisierung erneut durchgeführt
werden).
:::

[Beispiel für Zusammenführen (merge und push), Anmerkung zu fast forward merge]{.ex}

::: notes
# Branches und Remotes

Das Arbeiten mit Remote-Branches ist nicht nur bereits beim Klonen vorhandene Branches beschränkt.

1.  Neue lokale Branches pushen mit `git push <remote> <branch>`.
2.  Neue remote Branches fetchen:
    -   `git fetch <remote>` holt (auch) alle neuen (Remote-) Branches
    -   Lokale Änderungen an Remote-Branches nicht möglich! `\newline`{=tex} =\>
        **Remote-Branch in lokalen Branch auschecken**

## Anmerkung: *push* geht nur, wenn

1.  Ziel ein "bare"-Repository ist, **und**
2.  keine Konflikte entstehen

=\> im remote Repo **nur** "fast forward"-Merge möglich

=\> bei Konflikten erst `fetch` und `merge`, danach `push`

**Anmerkung**: Ein "bare"-Repository enthält keine Workingcopy, sondern nur das Repo
an sich. Die ist bei Repos, die Sie auf einem Server wie Gitlab oder Github anlegen,
automatisch der Fall. Sie können aber auch lokal ein solches "bare"-Repo anlegen,
indem Sie beim Initialisieren den Schalter `--bare` mitgeben: `git init --bare` ...

## Beispiel

    git fetch origin           # alle Änderungen vom Server holen
    git checkout master        # auf lokalen Master umschalten
    git merge origin/master    # lokalen Master aktualisieren

    ... # Herumspielen am lokalen Master

    git push origin master     # lokalen Master auf Server schicken
:::






# Wrap-Up

-   Anlegen von Branches mit `git branch`
-   Umschalten der Workingcopy auf anderen Branch: `git checkout` oder `git switch`
-   Mergen von Branches und Auflösen von Konflikten: `git merge`
-   Verschieben von Branches mit `git rebase`
-   Änderungen vom Server holen: `git fetch <remote>`
-   Lokalen Branch auffrischen: `git merge <remote>/<branch>`
-   Eigene Änderungen hochladen: `git push <remote> <branch>`

::: readings
Sie finden den Inhalt dieser Sitzung im @Chacon2014 [Kap. 3].

Zusätzlich gibt es viele hilfreiche Tutorials wie beispielsweise die [Atlassian Git
Tutorials](https://www.atlassian.com/git/tutorials).
:::

::: outcomes
-   k3: Ich kann neue Branches anlegen
-   k3: Ich kann Branches mergen und mögliche Konflikte auflösen
-   k3: Ich kann Branches rebasen
-   k3: Ich kann Änderungen vom fremden Repo holen
-   k2: Ich kann den Unterschied zwischen lokalen Branches und entfernten Branches
-   k3: Ich kann meine lokale Branches aktualisieren
-   k3: Ich kann lokale Änderungen ins fremde Repo pushen
    erklären
:::

::: challenges
**Branches und Merges**

1.  Legen Sie in Ihrem Projekt einen Branch an. Ändern Sie einige Dateien und
    committen Sie die Änderungen. Checken Sie den Master-Branch aus und mergen Sie
    die Änderungen. Was beobachten Sie?

2.  Legen Sie einen weiteren Branch an. Ändern Sie einige Dateien und committen Sie
    die Änderungen. Checken Sie den Master-Branch aus und ändern Sie dort ebenfalls:

    -   Ändern Sie eine Datei an einer Stelle, die nicht bereits im Branch
        modifiziert wurde.
    -   Ändern Sie eine Datei an einer Stelle, die bereits im Branch manipuliert
        wurde.

    Committen Sie die Änderungen.

    Mergen Sie den Branch jetzt in den Master-Branch. Was beobachten Sie? Wie lösen
    Sie Konflikte auf?

**Mergen am Beispiel**

Sie verwalten Ihr Projekt mit Git. Es existieren zwei Branches: `master` (zeigt auf
Commit $C$) und `feature` (zeigt auf Version $F$). In Ihrer Workingcopy haben Sie
den Branch `feature` ausgecheckt:

![](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/git/images/before.png?raw=true){width="35%"}

(1) Mit welcher Befehlsfolge können Sie den Branch `feature` in den Branch `master`
    mergen, so dass nach dem Merge die im folgenden Bild dargestellte Situation
    entsteht?

![](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/git/images/after.png?raw=true){width="35%"}

(Der Merge läuft ohne Konflikte ab. Es ist irrelevant, welcher Branch am Ende in der
Workingcopy ausgecheckt ist.)

<!--
`git checkout master  &&  git merge feature`
-->

(2) Wie können Sie erreichen, dass es keinen Merge-Commit gibt, sondern dass die
    Änderungen in $D$ und $F$ im `master` als eine lineare Folge von Commits
    erscheinen?

<!--
`git rebase master feature  &&  git switch master  &&  git merge feature`
-->

**Synchronisierung mit Remote-Repos**

Sie haben ein Repo von github.com geklont. Beide Repos, das Original auf dem Server
als auch Ihre lokale Kopie, haben sich danach unabhängig voneinander weiter
entwickelt (siehe Skizze).

![](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/git/images/remote-branches-2.png?raw=true){width="60%"}

Wie können Sie Ihre Änderung im lokalen Repo auf den Server pushen? Analysieren Sie
die Situation und erklären Sie zwei verschiedene Lösungsansätze und geben Sie
jeweils die entsprechenden Git-Befehle an.

<!--
Ein einfaches `git push (origin master)` wird nicht gehen, da beide Master-Branches sich
auseinander entwickelt haben und kein Fast-Forward möglich ist.

Variante A: Änderungen vom Server in die Working-Copy holen, den eigenen Master-Branch
mergen und das Ergebnis wieder pushen.
`(git checkout master) && git pull && git push` oder
`(git checkout master) && git fetch && git merge origin/master && git push (origin master)`

Variante B: Änderungen vom Server in die Working-Copy holen, den eigenen Master-Branch
rebasen und das Ergebnis wieder pushen.
`(git checkout master) && git pull --rebase && git push` oder
`git fetch && git rebase origin/master master && git push (origin master)`
-->

**Interaktive Git-Tutorials**: Schaffen Sie die Rätsel?

-   [Learn Git Branching](https://learngitbranching.js.org/)
-   [Oh My Git!](https://ohmygit.org/)
-   [Git Time](https://git.bradwoods.io/)
-   [Tutorial: A Visual Git
    Reference](https://marklodato.github.io/visual-git-guide/index-en.html)
:::
