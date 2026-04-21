---
author: Carsten Gips (HSBI)
title: Arbeiten mit Git Remotes (dezentrale Repos)
---


# Vereinfachung: Tracking Branches

-   **Tracking Branch**: lokaler Branch, der remote Branch "verfolgt"
    -   Beispiel: lokaler `master`-Branch folgt `origin/master` per Default

\bigskip

-   **Vereinfachung im Workflow**:
    -   `git pull` entspricht
        1.  `git fetch <remote>` **plus**
        2.  `git merge <remote>/<branch>`
    -   `git push` entspricht `git push <remote> <branch>`

\bigskip

Vorsicht: `pull` und `push` beziehen sich nur auf ausgecheckten Tracking Branch

# Einrichten von Tracking Branches

-   `git clone`: lokaler `master` trackt automatisch `origin/master`

\smallskip

-   Remote Branch als Tracking Branch einrichten:
    1.  [Änderungen aus remote Repo holen:]{.notes} `git fetch <remote>`
    2.  [Tracking Branch anlegen:]{.notes} `git checkout -t <remote>/<branch>` [(=\>
        Option `-t` richtet den remote Branch als Tracking Branch ein)]{.notes}

\smallskip

-   Lokalen [neuen]{.notes} Branch [ins remote Repo schicken und]{.notes} als
    Tracking Branch einrichten:
    1.  [Lokalen Branch erzeugen:]{.notes} `git checkout -b <branch>`
    2.  [Lokalen Branch ins Repo schicken:]{.notes} `git push -u <remote> <branch>`
        [(=\> Option `-u` richtet den lokalen Branch als Tracking Branch
        ein)]{.notes}

[[Beispiel]{.ex}]{.slides}



# Wrap-Up


-   Tracking Branches (Konzept, Anwendung)
    -   Remote Branches können lokal nicht verändert werden:
        -   In lokale Branches mergen, oder
        -   Tracking Branches anlegen =\> einfaches `pull` und `push` nutzen
    -   Tracking Branches sind lokale Branches, die remote Branches verfolgen
        ("tracken")

::: readings
-   @Chacon2014 [Kap. 3]
:::

::: outcomes
-   k3: Ich kann Tracking Branches zum Vereinfachen der Arbeit anlegen
:::
