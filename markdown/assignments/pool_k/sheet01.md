---
type: assignment
title: "Blatt 01: Git (Basics, Branches, Remotes)"
author: " André Matutat (FH Bielefeld)"
points: 10
weight: 1
hidden: true
---


**Abgabe**: Die Lösung für dieses Blatt ist als **Zip**-Archiv (`.zip`) im Objekt "Praktikum"
im ILIAS hochzuladen. Beachten Sie die Deadline (vgl. `[Fahrplan]({{< ref "/org/schedule" >}})`{=markdown})!


## Git Basics (4 Punkte)

{{% include "assignments/pool_k/tasks/git_basics.md" %}}

Abgabe: Schreiben Sie Ihre Schritte, die Antworten auf die Fragen und Ihre Beobachtungen zu den einzelnen
Schritten in eine Textdatei und geben Sie diese als Teil der Lösung im Zip-Archiv ab. Das erstellte Repo
samt Workingcopy fügen Sie ebenfalls dem Zip-Archiv hinzu. Im Praktikum demonstrieren Sie den Umgang mit
den Schritten noch einmal live.


## Git Branches (4 Punkte)

{{% include "assignments/pool_k/tasks/git_branches.md" %}}

Abgabe: Schreiben Sie Ihre Schritte, die Antworten auf die Fragen und Ihre Beobachtungen zu den einzelnen
Schritten in eine Textdatei und geben Sie diese als Teil der Lösung im Zip-Archiv ab. Das erstellte Repo
samt Workingcopy fügen Sie ebenfalls dem Zip-Archiv hinzu. Im Praktikum demonstrieren Sie den Umgang mit
den Schritten noch einmal live.


## Git Remotes: Vorbereitung Repo für die Abgabe (2 Punkte)

Sie sollen alle zukünftigen Aufgaben aus dem Dungeon- und Konzept-Pool in einem
privaten Git-Repository bearbeiten.

1.  Erstellen Sie sich einen kostenlosen und ggf. anonymen Account auf [GitHub](https://github.com/)
    oder loggen Sie sich einmal mit Ihren FH-Zugangsdaten auf dem Gitlab-Server im Software-Labor
    ein (URLs siehe `[Ressourcen > Vorgaben]({{< ref "/org/resources" >}})`{=markdown}).
2.  Erstellen Sie sich auf GitHub oder dem Gitlab-Server im SW-Labor ein neues (leeres!) privates Repo,
    auf dem Ihr Team das Semester über arbeiten wird.
3.  Tragen Sie Jonas Posselt (`jposselt`), André Matutat (`amatutat`) und Carsten Gips (`cagix`)
    mit Schreibrechten in Ihr Repo ein (GitHub: Settings > Collaborateurs and Teams > Manage Access > Role "write";
    Gitlab: Project Information > Members > Invite > Role "Developer").
    Dies ist zwingend notwendig, damit wir Ihre Pull-/Merge-Requests bearbeiten/akzeptieren
    können.
4.  Schreiben Sie die verwendeten Usernamen Ihrer Teammitglieder und die URL Ihres Repos in eine
    Textdatei, die Sie mit in das `.zip`-Archiv aufnehmen und mit im ILIAS abgeben. Keine Passwörter
    angeben!
5.  Klonen Sie Ihr Team-Repo auf Ihren lokalen Rechner und tragen Sie das Vorgabe-Repo (siehe
    `[Ressourcen > Vorgaben]({{< ref "/org/resources" >}})`{=markdown}) als weiteres Remote ein. Pullen Sie
    vom Vorgabe-Repo und pushen Sie die Dateien in Ihr eigenes Repo.

Abgabe: Geben Sie die Textdatei aus Schritt (4) als Teil der Lösung im Zip-Archiv ab. Im Praktikum zeigen Sie
den Umgang mit Ihrem Repo und Ihrer Workingcopy noch einmal live.
