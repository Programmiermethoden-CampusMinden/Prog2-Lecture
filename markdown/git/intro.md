---
type: lecture-cg
title: "Intro: Versionskontrolle in der Softwareentwicklung"
menuTitle: "Intro"
author: "Carsten Gips (FH Bielefeld)"
weight: 1
readings:
  - key: "Chacon2014"
    comment: "Kapitel 1 und 2"
  - key: "AtlassianGit"
  - key: "GitCheatSheet"
tldr: |
  In der Softwareentwicklung wird häufig ein Versionsmanagementsystem (VCS) eingesetzt, welches die Verwaltung
  von Versionsständen und Änderungen ermöglicht. Ein Repository sammelt dabei die verschiedenen Änderungen.
  Die Software *Git* ist verbreiteter Vertreter und arbeitet mit dezentralen Repositories. Ein neues lokales
  Repository kann man mit `git init` anlegen. Der Befehl legt den Unterordner `.git/` im aktuellen Ordner an,
  darin befindet sich das lokale Repository und weitere von Git benötigte Dateien (FINGER WEG!). Die Dateien
  und anderen Unterordner im aktuellen Ordner können nun der Versionskontrolle hinzugefügt werden. Den lokal
  vorliegenden (Versions-) Stand der Dateien im aktuellen Ordner nennt man auch "Working Copy". Ein bereits
  existierendes Repo kann mit `git clone <url>` geklont werden.
outcomes:
  - k1: "Varianten der Versionierung"
  - k1: "Begriffe Workingcopy und Repository"
  - k2: "Erstellung von lokalen Git-Repositories"
  - k3: "Umgang mit entsprechenden Git-Befehlen auf der Konsole"
quizzes:
  - link: "XYZ"
assignments:
  - topic: sheet01
youtube:
  - link: "https://youtu.be/XYZ"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/XYZ"
---


## Typische Probleme bei SW-Entwicklung

*   Was hat wer wann (und wo) geändert? Und warum?
*   Ich brauche den Stand von gestern/letzter Woche/...
*   Ich will schnell mal eine neue Idee ausprobieren ...
*   Ich arbeite an mehreren Rechnern (Synchronisation)
*   Wir müssen gemeinsam an der gleichen Codebasis arbeiten.
*   Wir arbeiten am Release v42, aber Kunde braucht schnell einen Fix für v40


## Folgen SW-Entwicklung ohne Versionsverwaltung

![](intro.images/screenshot_zusammenarbeit_ohne_vcs.png)

::: notes
*   Filesystem müllt voll mit manuell versionierten
    Dateien/Sicherungen ala `file_20120507_version2_cagi.txt`
*   Ordner/Projekte müssen dupliziert werden für neue Ideen
*   Code müllt voll mit auskommentierten Zeilen ("Könnte ja noch gebraucht werden")
*   Unklar, wann welche Änderung von wem warum eingeführt wurde
*   Unbeabsichtigtes Überschreiben mit älteren Versionen beim Upload
    in gemeinsamen Filesharing-Bereich
:::


## Prinzip Versionsverwaltung

:::::: columns
::: {.column width="48%"}

![](figs/git/local)
[Quelle: [Scott Chacon and Ben Straub (CC BY-NC-SA 3.0)](https://github.com/progit/progit2/blob/master/images/local.png)]{.origin}

:::
::: {.column width="50%"}

\vspace{10mm}

*   [**Repository:**]{.alert}
    **Datenbank** mit verschiedenen Versionsständen, Kommentaren, Tags etc.

\bigskip

*   [**Workingcopy:**]{.alert}
    **Arbeitskopie** eines bestimmten Versionsstandes

:::
::::::


## Varianten: Zentrale Versionsverwaltung (Beispiel SVN)

::: center
![](figs/git/centralized){width=64mm}
[Quelle: [Scott Chacon and Ben Straub (CC BY-NC-SA 3.0)](https://github.com/progit/progit2/blob/master/images/centralized.png)]{.origin}
:::


## Varianten: Verteilte Versionsverwaltung (Beispiel Git)

::: center
![](figs/git/distributed){width="58%"}
[Quelle: [Scott Chacon and Ben Straub (CC BY-NC-SA 3.0)](https://github.com/progit/progit2/blob/master/images/distributed.png)]{.origin}
:::


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


## (Globale) Konfiguration

**Minimum**:

*   `git config --global user.name <name>`
*   `git config --global user.email <email>`

::: notes
Diese Konfiguration muss man nur einmal machen.

Wenn man den Schalter `--global` weglässt, gelten die Einstellungen nur
für das aktuelle Projekt/Repo.

Zumindest Namen und EMail-Adresse **muss** man setzen, da Git diese
Information beim Anlegen der Commits speichert (== benötigt!).
:::

\bigskip
\bigskip

**Aliase**:

*   `git config --global alias.ci commit`
*   `git config --global alias.co checkout`
*   `git config --global alias.br branch`
*   `git config --global alias.st status`
*   `git config --global alias.ll 'log --all --graph --decorate --oneline'`

::: notes
Zusätzlich kann man weitere Einstellungen vornehmen, etwa auf bunte
Ausgabe umschalten: `git config --global color.ui auto` oder Abkürzungen
(Aliase) für Befehle definieren: `git config --global alias.ll 'log --all --oneline --graph --decorate'` ...

Anschauen kann man sich die Einstellungen in der Textdatei `~/.gitconfig`
oder per Befehl `git config --global -l`.
:::

[Konsole]{.bsp}


## Neues Repo anlegen

*   `git init`

    \blueArrow Erzeugt neues Repository im akt. Verzeichnis

\bigskip

*   `git clone <url>`

    \blueArrow Erzeugt (verlinkte) Kopie [des Repos unter `<url>`]{.notes}

[Konsole]{.bsp}


## Wrap-Up

*   Git: Versionsmanagement mit dezentralen Repositories
*   Anlegen eines lokalen Repos mit `git init`
*   Clonen eines existierenden Repos mit `git clone <url>`







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
