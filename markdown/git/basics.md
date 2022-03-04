---
type: lecture-cg
title: "Basics der Versionsverwaltung mit Git (lokale Repos)"
menuTitle: "Basics"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
readings:
  - key: "Chacon2014"
    comment: "Kapitel 2 und 3"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
assignments:
  - topic: sheet01
youtube:
  - link: "https://youtu.be/XYZ"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/XYZ"
---


## Versionsverwaltung mit Git: Typische Arbeitsschritte

a.  Repository anlegen (oder clonen)

\bigskip

b.  Dateien neu erstellen (und löschen, umbenennen, verschieben)
c.  Änderungen einpflegen ("committen")
d.  Änderungen und Logs betrachten
e.  Änderungen rückgängig machen
f.  Projektstand markieren ("taggen")

\bigskip

g.  Entwicklungszweige anlegen ("branchen")
h.  Entwicklungszweige zusammenführen ("mergen")

\bigskip

i.  Änderungen verteilen (verteiltes Arbeiten, Workflows)


## Dateien unter Versionskontrolle stellen

1.  `git add .` (oder `git add <file>`)

    \blueArrow Stellt [alle]{.alert} Dateien (bzw. die Datei `<file>`)
    [im aktuellen Verzeichnis]{.notes} unter Versionskontrolle

\smallskip

2.  `git commit`

    \blueArrow Fügt die Dateien dem Repository hinzu

\bigskip

Abfrage mit `git status`

[Konsole]{.bsp}


## Folie 3
...

## Folie 4
...

## Folie 5
...

## Folie 6
...

## Wrap-Up

*   Änderungen einpflegen zweistufig (`add`, `commit`)
*   Status der Workingcopy mit `status` ansehen
*   Logmeldungen mit `log` ansehen
*   Änderungen auf einem File mit `diff` bzw. `blame` ansehen
*   Projektstand markieren mit `tag`
*   Ignorieren von Dateien/Ordnern: Datei `.gitignore`







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
