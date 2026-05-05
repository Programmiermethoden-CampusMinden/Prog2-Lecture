# Git4: Worktree

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Git Worktree erlaubt es, Branches in separaten Ordnern auszuchecken.
> Diese Ordner sind mit der Workingcopy verknüpft, d.h. alle Änderungen
> über Git-Befehle werden automatisch mit der Workingcopy
> "synchronisiert". Im Unterschied zum erneuten Clonen hat man in den
> verknüpften Ordnern aber nicht die gesamte Historie noch einmal neu
> als `.git`-Ordner, sondern nur den Link auf die Workingcopy, wodurch
> viel Platz gespart wird. Damit bilden Git Worktrees eine elegante
> Möglichkeit, parallel an verschiedenen Branches zu arbeiten.
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> Vorlesung Git Worktree \[[YT](https://youtu.be/5jI9MTKIKTs)\],
> \[[HSBI](https://www.hsbi.de/medienportal/album/video/pr2-git4-worktree/80984d064888d7ed2cff5b3bd4f5e62e/250)\]
>
> Demo Git Worktree \[[YT](https://youtu.be/aCyvKii19yQ)\],
> \[[HSBI](https://www.hsbi.de/medienportal/album/video/pr2-git4-demo-git-worktree/d72f222248f9a91aa34db97007456750/250)\]
>
> </details>

## Git Worktree - Mehrere Branches parallel auschecken

### Szenario

-   Sie arbeiten an einem Projekt
-   Großes Repo mit vielen Versionen und Branches
-   Ungesicherte Änderungen im Featurebranch
-   Wichtige Bugfixes an alter Version nötig

### Lösungsansätze

-   `git stash` nutzen und Branch wechseln
-   Repo erneut in anderem Ordner auschecken

### Probleme

1.  `git stash` und `git switch`

    Funktioniert für die meisten Fälle relativ gut und ist daher die
    "Lösung to go".

    Aber Sie müssen später aufpassen, dass Sie auch wirklich wieder im
    richtigen Branch sind, wenn Sie die Änderungen im Stash anwenden
    (`git stash pop`)! Und wenn Sie mehrere Einträge in der Stash-Liste
    haben, kann es recht schnell recht unübersichtlich werden - zu
    welchem Branch gehören welche Einträge in der Stash-Liste?

    Außerdem kann es gerade in größeren Projekten passieren, dass sich
    die Konfiguration zwischenzeitlich ändert. Wenn Sie jetzt in der IDE
    einfach auf einen alten Stand mit einer anderen Konfiguration
    wechseln, kann es schnell passieren, dass sich die IDE "verschluckt"
    und Sie dadurch viel Arbeit haben.

2.  Nochmal woanders auschecken

    Im Prinzip ist das eine Möglichkeit. Sie können dann den anderen
    Ordner in Ihrer IDE als neues Projekt öffnen und sofort starten.

    Aber: Sie benötigen noch einmal den Platz auf der Festplatte/SSD/...
    wie für die ursprüngliche Workingcopy! Das kann bei alten/großen
    Projekten schnell recht groß werden und Probleme verursachen.

    Außerdem ist die Synchronisierung zwischen den beiden Workingcopies
    (der ursprünglichen und der neuen) nicht vorhanden bzw. das müssen
    Sie manuell per `git push` und `git pull` (in jeder Kopie des
    Repos!) erledigen!

### Git Worktree kann helfen!

**=\> Mehrere Branches gleichzeitig auschecken (als neue Ordner im
Dateisystem)**

## How to use Git Worktree

<p align="center"><picture><source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/linkedworktrees_inv.png" /><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/linkedworktrees.png" width="60%" /></picture></p>

## Worktree anlegen

<div align="center">

`git worktree add <path> <branch>`

</div>

Legt neuen Ordner `<path>` an und checkt darin `<branch>` als "linked
worktree" aus.

Mit `git worktree add ../wuppie foo` würden Sie also parallel zum
aktuellen Ordner (wo Ihre Workingcopy enthalten ist) einen neuen Ordner
`wuppie/` anlegen und darin den Branch `foo` auschecken.

Wenn Sie in den Ordner `wuppie` wechseln, finden Sie auch eine *Datei*
`.git`. Darin ist lediglich der Pfad zur Workingcopy vermerkt, damit Git
Änderungen auch in die eigentliche Workingcopy spiegeln kann. Dies ist
der sogenannte "linked worktree".

Im Vergleich dazu finden Sie in der eigentlichen Workingcopy einen
*Ordner* `.git`, der üblicherweise die gesamte Historie etc. enthält und
entsprechend groß werden kann.

Den Befehl `git worktree add` gibt es in verschiedenen Versionen. In der
Kurzform `git worktree add <path>` würde ein neuer Branch angelegt und
ausgecheckt, der der letzten Komponente von `<path>` entspricht ...

**Warnung: Nicht in selben Ordner oder in Unterordner auschecken!**

Die neuen Worktrees sollten immer **außerhalb** der Workingcopy liegen!
Sie können Git sehr schnell sehr gründlich durcheinanderbringen, wenn
Sie einen Worktree im selben Ordner oder in einem Unterordner anlegen.

`git worktree` sollte nach Möglichkeit nicht zusammen mit Git Submodules
eingesetzt werden (unstabiles Verhalten)!

## Worktree wechseln

-   Worktrees anzeigen: `git worktree list`
-   Worktree wechseln: Ordner wechseln (IDE: neues Projekt)

Die Worktrees sind aus Sicht des Dateisystems einfach Ordner. Die
`.git`-Datei verlinkt für Git den Ordner mit der ursprünglichen
Workingcopy.

Um also mit einem Worktree arbeiten zu können, wechseln Sie einfach das
Verzeichnis. In einer IDE würden Sie entsprechend ein neues Projekt
anlegen. So können Sie gleichzeitig in verschiedenen Branches arbeiten.

Änderungen in einem Worktree werden automatisch in die ursprüngliche
Workingcopy gespiegelt. Analog können Sie in einem Worktree auf die
aktuelle Historie aus der ursprünglichen Workingcopy zugreifen.

*Hinweis*: Sie können in den Ordnern zwar Branches wechseln, aber nicht
auf einen Branch, der bereits in einem anderen Ordner (Worktree)
ausgecheckt ist. Es ist gute Praxis, dass die Ordnernamen dem
ausgecheckten Branch (linked Worktree) entsprechen, um Verwirrungen zu
vermeiden.

## Worktree löschen

<div align="center">

`git worktree remove <worktree>`

</div>

Sofern der Worktree "clean" ist, es also keine nicht comitteten
Änderungen gibt, können Sie mit `git worktree remove <worktree>` einen
Worktree `<worktree>` wieder löschen.

Dabei bleibt der Ordner erhalten - Sie können ihn selbst löschen oder
später wiederverwenden.

## Wrap-Up

Git Worktree: Auschecken von Branches in separate Ordner

-   Anlegen: `git worktree add <path> <branch>`
-   Anschauen: `git worktree list`
-   Löschen: `git worktree remove <worktree>`

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> Eine gute Quelle zum Nachlesen bietet die
> [Git-Dokumentation](https://git-scm.com/docs/git-worktree).
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Vorteile von Git Worktree
> -   k2: Prinzipielle Arbeitsweise von Git Worktree
> -   k3: Anlegen von Worktrees
> -   k3: Anzeigen von Worktrees
> -   k3: Löschen von Worktrees
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> f6a6e4a 2026-04-22 git4: put link to documentation in readings section<br></sub></sup></p></blockquote>
