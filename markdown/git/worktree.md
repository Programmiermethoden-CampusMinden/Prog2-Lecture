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

Beispiel: Projekt mit ungesicherten Änderungen im Feature-Branch; temporär Arbeiten in anderem Branch notwendig - einfach git switch geht nicht
Optionen: (a) Committen (hmmm?!), (b) Stash (Vorsicht, wenn man wieder zurückkommt, damit man den richtigen Punkt hat)

Lösung: Git Worktree - mehrere Branches gleichzeitig auschecken (als neue Ordner im Dateisystem)
XXX


## How to use Git Worktree

Man-Page: git worktree add, list, remove
https://git-scm.com/docs/git-worktree

Bild: Repo, Ordner pro ausgechecktem Branch (Worktree)

Warnung: nicht in selben oder in Unterordner auschecken, also _außerhalb_ der Workingcopy!


## Git Worktree Add

Beispiel: Branch auschecken, worktree list
Arbeiten in beiden Branches: Änderungen, Commit, Push

Hinweis: in Konsole sind wir zwar im anderen Ordner, die IDE aber nicht - ggf. neu öffnen


## Git Worktree Remove

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
