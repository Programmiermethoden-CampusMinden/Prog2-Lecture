## Git lokal -- Kommandozeile

Üben Sie den Umgang mit Git auf der Kommandozeile:

a)  Legen Sie ein Repository an.
b)  Fügen Sie Dateien dem Verzeichnis hinzu und stellen Sie *einige* davon
    unter Versionskontrolle.
c)  Ändern Sie eine Datei und versionieren Sie die Änderung.
d)  Was ist der Unterschied zwischen "`git add .; git commit`" und
     "`git commit -a`"?
e)  Wie finden Sie heraus, welche Dateien geändert wurden?
f)  Entfernen Sie eine Datei aus der Versionskontrolle, aber nicht aus dem
    Verzeichnis!
g)  Entfernen Sie eine Datei komplett (Versionskontrolle und Verzeichnis).
h)  Ändern Sie eine Datei und betrachten die Unterschiede zum letzten Commit.
i)  Fügen Sie eine geänderte Datei zum Index hinzu. Was erhalten Sie bei
    `git diff <datei>`?
j)  Wie können Sie einen früheren Stand einer Datei wiederherstellen? Wie
    finden Sie überhaupt den Stand?
k)  Legen Sie sich ein Java-Projekt in Ihrer IDE an an. Stellen Sie dieses
    Projekt unter Git-Versionskontrolle. Führen Sie die vorigen Schritte mit
    Ihrer IDE durch.

[Sicherer Umgang mit den grundlegenden Arbeitsabläufen in Git]{.thema}


## Git Branches und Mergen -- Kommandozeile

Üben Sie den Umgang mit Git auf der Kommandozeile:

a) Legen Sie in Ihrem Projekt einen Branch an. Ändern Sie einige Dateien
   und committen Sie die Änderungen. Checken Sie den Master-Branch aus und
   mergen Sie die Änderungen. Was beobachten Sie?

b) Legen Sie einen weiteren Branch an. Ändern Sie einige Dateien und
   committen Sie die Änderungen. Checken Sie den Master-Branch aus und
   ändern Sie dort ebenfalls:

    *   Ändern Sie eine Datei an einer Stelle, die nicht bereits im Branch
        modifiziert wurde.
    *   Ändern Sie eine Datei an einer Stelle, die bereits im Branch
        manipuliert wurde.

    Committen Sie die Änderungen.

    Mergen Sie den Branch jetzt in den Master-Branch. Was beobachten Sie? Wie
    lösen Sie Konflikte auf?

[Sicherer Umgang mit den grundlegenden Arbeitsabläufen in Git]{.thema}


## Git: Branching-Strategien und Workflows

Worin unterscheiden sich die Branching-Strategien "Git-Flow-Modell" und
"GitHub-Flow-Modell"? Wo liegen jeweils die Vor- und Nachteile aus Ihrer Sicht?

Welche Aufgaben hat ein Integrationsmanager in einem (zentralisierten) Workflow
mit Integrationsmanager oder im "Dictator and Lieutenants Workflow"?
Wie gestaltet sich die Mitarbeit in solchen Projekt-Workflows als "normaler"
Beitragender?

[Sicherer Umgang mit den grundlegenden Arbeitsabläufen in Git]{.thema}


## Github-Workflow und Merge-Requests

Üben Sie gemeinsam das Erstellen von Merge-Requests:

*   Erstellen Sie sich ein "Blessed Repo", forken Sie dieses und clonen Sie den
    den Fork lokal.

*   Arbeiten Sie in Ihrem Clone mit Themenbranches und stellen Sie Merge-Requests
    für die Themenbranches in den Master-Branch in **Ihrem Fork**.
    -   Achten Sie auf die Vollständigkeit des MRs: Assignee, Summary, Description!
    -   Kommentieren Sie gegenseitig die Code-Stellen.
    -   Nehmen Sie weitere Commits in Ihren Themenbranches vor und pushen Sie diese,
        damit die Änderungen Teil des Merge-Requests werden.
    -   Beobachten Sie dabei, ob die Kommentare geschlossen werden.
    -   Wie kann der MR akzeptiert bzw. abgelehnt werden? Welche Optionen gibt es dabei,
        was passiert mit den Themenbranches?

*   Arbeiten Sie nun den erteilten Workflow
    ["Forked Public Project"](https://git-scm.com/book/en/v2/Distributed-Git-Contributing-to-a-Project)
    durch:
    -   Fügen Sie das "Blessed Repo" als weiteres Remote Repo in Ihrem Clone hinzu.
    -   Erstellen Sie für Themenbranches in Ihrem Clone einen MR gegen den Master-Branch
        im "Blessed Repo".
    -   Einer im Team übernimmt die Rolle des Maintainers und kommentiert den Code.
        Die anderen Teammitglieder fixen ihren Code und pushen die Änderungen
    -   Der Maintainer akzeptiert den MR, das lokale Repo und der Fork müssen nun
        aktualisiert werden.

[Einüben des Github-Workflows und der Zusammenarbeit im "Forked Public Project"-Modell]{.thema}


## Fehlersuche mit Git Bisect

Erstellen Sie sich ein Git-Repo mit einigen Commits. Nutzen Sie dabei auch
Branches und mergen Sie diese. Bauen Sie irgendwo einen Fehler ein und
demonstrieren Sie, wie Sie mit Git Bisect den fehlerhaften Commit finden
können. Schreiben Sie sich dazu einen passenden Testfall, den Sie in jedem
Schritt zur Prüfung laufen lassen.

[Wenn Ihr Team-Repo zur Bearbeitung der obigen Aufgabe (oder vom letzten Blatt)
 bereits die gestellten Bedingungen erfüllt, können Sie natürlich auch dieses
 zur Demo nutzen.]{.hinweis}

[Selbstständige Literaturrecherche, Praktischer Umgang mit Git Bisect]{.thema}
