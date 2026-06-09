# Java: Strukturieren mit Packages

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Packages strukturieren Java-Projekte, indem sie Klassen in logisch
> zusammengehörige Bereiche aufteilen, ähnlich wie Ordner im
> Dateisystem. Sie schaffen eigene Namensräume, sodass Klassen mit
> gleichem Namen (z.B. `java.util.List` und `java.awt.List`)
> nebeneinander existieren können, und sie sind die Basis für
> Sichtbarkeit auf Package-Ebene, also für interne vs. externe APIs.
>
> Übliche Konventionen orientieren sich am umgedrehten Domain-Namen
> (`de.hsbi`), ergänzt um Projekt (`prog2`) und fachliche/technische
> Unterteilung (`library.app`, `library.model`). Das Default-Package
> (keine `package`-Deklaration in der Datei) ist eine Einbahnstraße:
> Code in benannten Packages kann nicht auf Klassen im Default-Package
> zugreifen und viele Tools erwarten benannte Packages - deshalb sollten
> Sie es nicht in Projekten verwenden.
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> Vorlesung \[[YT](https://youtu.be/db3SGcxJxT8)\],
> \[[HSBI](https://www.hsbi.de/medienportal/video/pr2-packages/17abeff70beaf81a631314cb0207613f)\]
>
> </details>

## Typisches Java-Projekt

Hier ist ein typisches Java-Projekt zu sehen:

    src/
    |____main/
      |____java/
        |____Book.java
        |____LibraryService.java
        |____ConsoleUI.java
        |____Member.java
        |____AppMain.java

Es gibt die Maven-Ordnerstruktur `src/main/java/`, darunter dann
verschiedene Klassen.

Beobachtung: Alles liegt "wild" im selben Namespace. Man kann am
Klassennamen erkennen, welche Aufgaben die Klassen jeweils vermutlich
haben. Gleichzeitig wird es bereits bei den gezeigten fünf Klassen etwas
unübersichtlich - in typischen Projekten ist die Anzahl der Klassen
ungleich höher! Wenn das Projekt wächst, fehlt die Orientierung.

## Listen aus dem JDK

    java.util.List          vs.          java.awt.List

Beobachtung: Beide Listen finden sich in der Java-API - aber es sind
unterschiedliche Listenimplementierungen. Der einfache Klassenname
`List` ist nicht mehr eindeutig, man braucht noch einen Präfix (Spoiler:
ein Package), um die beiden Listen auseinander halten zu können.

## Was ist ein Package in Java

Packages sind eine Ordnerstruktur unterhalb des Source-Ordners im
Projekt.

-   Dateisystem-Sicht: `src/main/java/de/hsbi/prog2/wuppie/`

<!-- -->

-   Java-Sicht: `de.hsbi.prog2.wuppie`

Der Teil `src/main/java/` ist der Pfade zum Source-Ordner. IDEs suchen
darunter nach den Klassen etc. Der hintere Teil `de/hsbi/prog2/wuppie/`
der Ordnerhierarchie bildet das Package `de.hsbi.prog2.wuppie`.

D.h. man kann für Ordner unterhalb des Source-Ordners einfach die
Dateisystem-Trenner durch Punkte ersetzen und kommt auf das Package.

## Aufgaben von Packages in Java

In Java dienen Packages mehreren Zielen:

1.  Strukturierung des Codes

    Verwandte Klassen/Interfaces werden zusammengefasst. Erleichtert
    Orientierung in größeren Projekten. Analogie: Verzeichnisse/Ordner
    im Dateisystem.

<!-- -->

2.  Namensräume (Namespace)

    Verhindert Namenskonflikte: Zwei Klassen `List` können in
    verschiedenen Packages existieren. Über den vollqualifizierten Namen
    kann man gezielt auf die gewünschte Klasse zugreifen:
    `java.util.List` vs. `java.awt.List`.

<!-- -->

3.  Sichtbarkeit / Kapselung Package-Ebene als "Freundeskreis" von
    Klassen

    Es gibt verschiedene Sichtbarkeitsmodifikatoren:

    -   `public`: Von überall sichtbar: aus allen Klassen, in allen
        Packages, auch aus anderen Modulen/Projekten (sofern auf dem
        Classpath)
    -   `protected`: Sichtbar innerhalb desselben Packages und
        zusätzlich in Unterklassen (abgeleitete Klassen), auch wenn
        diese in anderen Packages liegen
    -   `private`: Sichtbar nur innerhalb derselben Klasse; keine andere
        Klasse (auch nicht im selben Package oder als Unterklasse) kann
        direkt darauf zugreifen
    -   ohne Modifikator: "package-private": Sichtbar nur innerhalb
        desselben Packages; Klassen, Methoden und Felder ohne
        Modifikator bilden eine "Package-interne" API

    Damit kann man gezielt Klassenstrukturen aufbauen, die
    beispielsweise für bestimmte User-Gruppen gedacht sind: Developer,
    User, ... Man bekommt klare Grenzen und kann zwischen der internen
    API (auf Projekte-Ebene, aber eben auch auf Package-Ebene) und der
    externen API differenzieren.

## Konventionen

<div align="center">

    de.hsbi.prog2.wuppie

</div>

-   Umgedrehter Domain-Name: `de.hsbi` (von "hsbi.de")
-   Zusätzlich Projekt: `prog2`
-   Fachliche/technische Strukturen: `wuppie`

Prinzipiell kann man Package-Namen fast beliebig wählen.

Zur Vermeidung von Namenskollisionen nutzen viele Projekte den
umgedrehten Domain-Namen. Danach kommt normalerweise der Projektname.

Dies entspricht auch den Maven-Koordinaten: Die `groupId` wäre
`de.hsbi`, die `artifactId` wäre in diesem Beispiel `prog2`.

Üblicherweise werden für Packages nur Kleinbuchstaben verwendet.
Vermeiden Sie unbedingt Umlaute und sonstige Sonderzeichen!
Normalerweise werden auch keine Versionsnummern o.ä. (`prog2_v3`,
`newmodel`, `testneu`) in Packages verwendet.

## Packages strukturieren

Es liegt komplett bei Ihnen, wie Sie Ihre Packages aufteilen...

Üblichweise nutzt man eine von zwei Strategien für die Strukturierung
unterhalb des Wurzel-Packages:

1.  Fachliche Strukturierung: Trennung nach Domänenthemen

    -   `customer`: "Alles zu Kunden"
    -   `order`: "Alles zu Bestellungen"
    -   `product`: "Alles zu Produkten"

<!-- -->

2.  Technische Strukturierung: Trennung nach "Art der Aufgabe"

    -   `model`: Domänenobjekte
    -   `service`: Geschäftslogik
    -   `persistence`: Datenbankzugriff
    -   `ui`: Benutzeroberfläche
    -   `util`: Hilfsklassen

Innerhalb der Packages kann man natürlich weiter unterteilen.

Wichtig: Packages sollten klar benannt und voneinander abgegrenzt sein.
Packages sollten nicht in ihrer Verantwortung überlappen. Machen Sie
Packages nicht zu voll, aber vermeiden Sie auch eine Flut von fast
leeren Packages ...

**Hinweis**: `util` ist ein beliebtes "Mülleimer"-Package. Hier sollten
an sich nur echte generische Helfer landen, die in mehreren
Packages/Klassen gebraucht werden. Wenn `util` voll läuft, ist das oft
ein Zeichen für eine schlechte Aufteilung der anderen Packages.

**Hinweis**: Organisieren Sie Ihre Projekte frühzeitig in Packages.
Fangen Sie mit wenigen Top-Level Packages an. Wenn Sie merken, dass die
Struktur nicht passt, können Sie verfeinern und/oder umbauen. Lassen Sie
internen Code bewusst "private" oder "package-private".

------------------------------------------------------------------------

Für das obige Beispiel könnte beispielsweise die Aufteilung nach
technischen Kriterien so aussehen:

    library/
    |____src/
      |____main/
        |____java/
          |____de/
            |____hsbi/
              |____prog2/
                |____library/
                  |____app/
                  | |____LibraryService.java
                  | |____ConsoleUI.java
                  | |____AppMain.java
                  |____model/
                    |____Book.java
                    |____Member.java

Der Source-Ordner ist hier der übliche `src/main/java/`. Die `groupId`
ist hier `de.hsbi.prog2`, die `artifactId` wäre in diesem Beispiel
`library` (als Projektordner und gleichzeitig als Package benutzt).
Darunter gibt es die beiden Top-Level Packages `app` und `model`, wobei
in `model` alle Typen zur Modellierung der Daten (hier Bücher und
Mitglieder) landen und `app` beheimatet die Bibliothekslogik und das
Userinterface sowie den Starter mit der `main()`-Methode.

Es wäre auch eine fachliche Aufteilung denkbar, etwa `loan`, `user`,
`catalog` o.ä. ...

## Praktischer Einsatz von Packages

1.  Deklaration am Beginn der Java-Dateien:
    `package de.hsbi.prog2.library.app;`

    Jede Java-Datei beginnt mit einer solchen Package-Deklaration. Davor
    darf höchstens ein (Javadoc-) Kommentar kommen.

    Es gibt genau eine Package-Deklaration pro Datei. Sie darf nur dann
    fehlen, wenn die Datei im Default-Package ist (also direkt im
    Source-Ordner liegt).

    Achten Sie auf die Schreibweise!

<!-- -->

2.  Importe von Typen und Packages

    Die Importe folgen auf die Package-Deklaration. Wenn es keine gibt,
    dann sind die Importe der Beginn der Java-Datei.

    -   `import de.hsbi.prog2.library.model.Book;`

        Hier wird die Klasse `Book` aus dem Package
        `de.hsbi.prog2.library.model` importiert. Danach können Sie die
        Klasse direkt mit ihrem **einfachen Namen** ansprechen, d.h.
        ganz normal mit `Book` arbeiten, beispielsweise `new Book()`
        aufrufen o.ä.

        Sie können natürlich auch den **vollqualifizierten Namen**
        nutzen, also statt `Book` immer
        `de.hsbi.prog2.library.model.Book` schreiben. Dies wird i.d.R.
        aber als Anti-Pattern gesehen. Vermeiden Sie nach Möglichkeit
        vollqualifizierte Namen im Code.

    -   `import de.hsbi.prog2.library.model.*;`

        Mit dem Wildcard importieren Sie alle Klassen, die in
        `de.hsbi.prog2.library.model` definiert sind.

        Für Übungsprojekte ist das gegebenfalls noch akzeptabel. In
        echten Projekten kann es dadurch aber schnell Namenskollisionen
        geben, weshalb die meisten Projekte gezielte Imports für bessere
        Lesbarkeit/Wartbarkeit einsetzen.

    -   `import static java.lang.Math.max;`

        Das ist ein sogenannter **statischer Import**. Damit werden
        statische Member einer Klasse importiert und können direkt ohne
        die definierende Klasse genutzt werden.

        Im Beispiel: Statt `int bigger = Math.max(3, 5);` kann man jetzt
        einfach `int bigger = max(3, 5);` schreiben.

        Auch hier sparsam einsetzen - Gefahr von Namenskollisionen!

## Einbahnstraße Default-Package

    src/
    |____main/
      |____java/
        |____ConsoleUI.java
        |____de/
          |____hsbi/
            |____prog2/
              |____library/
                |____app/
                | |____LibraryService.java
                | |____AppMain.java
                |____model/
                  |____Book.java
                  |____Member.java

Die Klasse `ConsoleUI` liegt direkt im Soure-Ordner, also direkt unter
`src/main/java/`. Sie ist keinem speziellen Package zugeordnet, d.h. sie
liegt im **Default-Package**.

Die anderen Klassen sind nach Funktionalität in benannte Packages
aufgeteilt: `de.hsbi.prog2.library.model` beherbergt `Book` und
`Member`, und in `de.hsbi.prog2.library.app` gibt es die Bedienlogik der
Bibliothek (`LibraryService`) und den Starter (`AppMain`).

**PROBLEM**: Die Klassen im Default-Package können auf die Klassen in
den benannten Packages zugreifen (via `import`, sofern Sichtbarkeit
passt). Andersherum ist dies **nicht** möglich, d.h. `LibraryService`
oder `AppMain` können nicht auf `ConsoleUI` zugreifen! **Code in
benannten Packages kann keine Klassen aus dem Default-Package
verwenden.**

**PROBLEM**: Tools, Build-Systeme, Frameworks, Libraries, Class-Loader
erwarten meist keinen Code im Default-Package. JUnit beispielsweise
erwartet benannte Packages. **Code im Default-Package lässt sich
schlecht als Bibliothek verwenden oder in andere Projekte integrieren.**

**Das Default-Package ist eine Einbahnstraße! Nutzen Sie es nicht.**

## Wrap-Up

-   Packages sind logische Container für Klassen/Interfaces und
    entsprechen Ordnern unterhalb des Source-Ordners
    -   Strukturierung des Codes
    -   Vermeidung von Namenskollisionen (Namespaces)
    -   Grenze für Sichtbarkeit (package-private)
-   Zwei gängige Strukturierungsstrategien:
    -   fachlich/domainorientiert (z.B. `customer`, `order`, `product`),
    -   technisch (z.B. `model`, `service`, `persistence`, `ui`,
        `util`).
-   Verwendung von Klassennamen ohne vollqualifizierten Namen per
    `import`
-   Default-Package vermeiden

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> Lesen Sie zu Packages im [Packages Tutorial
> (Oracle)](https://dev.java/learn/packages/) nach.
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann den Einsatz von Packages in Java erklären
> -   k2: Ich kann zwischen dem einfachen Klassennamen und dem
>     vollqualifizierten Klassennamen unterscheiden
> -   k2: Ich kann die Probleme des Default-Packages erklären
> -   k3: Ich kann Packages erstellen und Klassen zuordnen
> -   k3: Ich kann Klassen und Packages importieren
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Nehmen Sie Ihr letztes Prog1-Projekt und überlegen Sie: Wie würden Sie
> es in 3..4 Packages aufteilen?
>
> Bearbeiten Sie die [Package
> Challenge](https://github.com/Programmiermethoden-CampusMinden/prog2_challenge_packages).
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> cc7ea96 2026-04-27 packages: add new library challenge<br></sub></sup></p></blockquote>
