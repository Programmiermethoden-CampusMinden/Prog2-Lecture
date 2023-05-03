---
archetype: lecture-cg
title: "Git Worktree"
menuTitle: "Worktree"
author: "Carsten Gips (HSBI)"
weight: 8
tldr: |
  XXX
outcomes:
  - k2: "XXX"
youtube:
  - link: "https://youtu.be/"
    name: "VL Git Worktree"
---


## Git Worktree - Mehrere Branches parallel auschecken

### Szenario

*   Sie arbeiten an einem Projekt
*   Großes Repo mit vielen Versionen und Branches
*   Ungesicherte Änderungen im Featurebranch
*   Wichtige Bugfixes an alter Version nötig

\bigskip

### Lösungsansätze

*   `git stash` nutzen und Branch wechseln
*   Repo erneut in anderem Ordner auschecken

\bigskip

::: notes
### Probleme

1.  `git stash` und `git switch`

    Funktioniert für die meisten Fälle relativ gut und ist daher die "Lösung to go".

    Aber Sie müssen später aufpassen, dass Sie auch wirklich wieder im richtigen
    Branch sind, wenn Sie die Änderungen im Stash anwenden (`git stash pop`)! Und
    wenn Sie mehrere Einträge in der Stash-Liste haben, kann es recht schnell recht
    unübersichtlich werden - zu welchem Branch gehören welche Einträge in der
    Stash-Liste?

    Außerdem kann es gerade in größeren Projekten passieren, dass sich die Konfiguration
    zwischenzeitlich ändert. Wenn Sie jetzt in der IDE einfach auf einen alten Stand
    mit einer anderen Konfiguration wechseln, kann es schnell passieren, dass sich die
    IDE "verschluckt" und Sie dadurch viel Arbeit haben.

2.  Nochmal woanders auschecken

    Im Prinzip ist das eine Möglichkeit. Sie können dann den anderen Ordner in Ihrer
    IDE als neues Projekt öffnen und sofort starten.

    Aber: Sie benötigen noch einmal den Platz auf der Festplatte/SSD/... wie für die
    ursprüngliche Workingcopy! Das kann bei alten/großen Projekten schnell recht
    groß werden und Probleme verursachen.

    Außerdem ist die Synchronisierung zwischen den beiden Workingcopies (der ursprünglichen
    und der neuen) nicht vorhanden bzw. das müssen Sie manuell per `git push` und `git pull`
    (in jeder Kopie des Repos!) erledigen!
:::

\bigskip

### Git Worktree kann helfen!

[**=> mehrere Branches gleichzeitig auschecken (als neue Ordner im Dateisystem)**]{.alert}


## How to use Git Worktree

Man-Page: git worktree add, list, remove
https://git-scm.com/docs/git-worktree

Bild: Repo, Ordner pro ausgechecktem Branch (Worktree)

Warnung: nicht in selben oder in Unterordner auschecken, also _außerhalb_ der Workingcopy!


## Worktree anlegen

Beispiel: Branch auschecken, worktree list
Arbeiten in beiden Branches: Änderungen, Commit, Push

Hinweis: in Konsole sind wir zwar im anderen Ordner, die IDE aber nicht - ggf. neu öffnen


## Worktree wechseln

xxx


## Worktree löschen

Git Worktree Remove (aus dem Hauptordner/Workingcopy-Ordner)


## Wrap-Up

*   XXX







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   XXX
:::
