## Strategie-Entwurfsmuster

<!-- TODO: Vorgabe des minmax.jar -->
<!-- TODO: Vorgabe einer TTT-Testsuite (NEU) -->

Implementieren Sie das Spiel "Tic Tac Toe" (Spielregeln vergleiche
[wikipedia.org/wiki/Tic_Tac_Toe](https://de.wikipedia.org/wiki/Tic_Tac_Toe)) in Java. Nutzen
Sie dazu die Vorgaben (Interfaces und Packages): Forken/Clonen Sie das Vorgabe-Repo  unter
[git01-ifm-min.ad.fh-bielefeld.de/Lehre/pm-s20/pm-vorgaben-s20](http://git01-ifm-min.ad.fh-bielefeld.de/Lehre/pm-s20/pm-vorgaben-s20)
und arbeiten Sie Ihrem Clone weiter.

Es soll eine eigene Klasse für die Spieler geben, die das vorgegebene Interface `ttt.game.IPlayer`
implementiert. Ihr Spiel muss das vorgegebene Interface `ttt.game.IGame` implementieren. Nutzen Sie
für die Repräsentation der Spielzüge das Interface `ttt.game.IMove` aus der Vorgabe.

Implementieren Sie das Strategy-Pattern, um den Spielerinstanzen zur Laufzeit eine konkrete
Spielstrategie mit dem Interface `ttt.strategy.IGameStrategy` mitzugeben, nach denen die Spieler
ihre Züge *berechnen*. Implementieren Sie mindestens drei unterschiedliche konkrete Strategien.^[Eine
mögliche Strategie könnte sein, den Nutzer via Tastatureingabe nach dem nächsten Zug zu fragen.]

Nutzen Sie als weitere Strategie den stets perfekt spielenden MinMax-Algorithmus^[Auf die
Funktionsweise des MinMax-Algorithmus  wird im Wahlmodul "Künstliche Intelligenz" genauer eingegangen
:-)]. Der Algorithmus steht über die Klasse `ttt.strategy.MinMaxStrategy` im `.jar`-File in den
Vorgaben zur Verfügung (die Klasse implementiert das Interface `ttt.strategy.IGameStrategy`).

[Ein Spieler soll in `IPlayer#nextMove` seinen nächsten Zug nur **berechnen** und darf nicht direkt den
 Spielstand (Spielbrett) modifizieren! Das eigentliche Durchführen des berechneten Zuges geschieht über
 die Methode `IGame.doMove()` aus dem Spiel. Die Berechnung im Spieler wird an die zur Laufzeit übergebene
 Strategie delegiert.]{.hinweis}

[Binden Sie das `.jar`-File mit dem MinMax-Algorithmus so ein, dass es zum Compilieren  und zum Starten Ihres
 Programms genutzt wird. Sie sollen die Datei nicht entpacken!]{.hinweis}

\bigskip

**Gehen Sie bei der Lösung der Aufgabe methodisch vor**:

a)  Stellen Sie sich eine Liste mit relevanten Anforderungen zusammen.

b)  Erstellen Sie (von Hand) ein Modell (UML-Klassendiagramm):
    *   Welche Klassen und Interfaces werden benötigt?
    *   Welche Aufgaben sollen die Klassen haben?
        Welche Attribute und Methoden sind nötig?
    *   Wie sollen die Klassen interagieren, wer hängt von wem ab?

c)  Implementieren Sie Ihr Modell in Java. Schreiben Sie ein Hauptprogramm,
    welches das Spiel startet und die Spieler abwechselnd ziehen lässt.

d)  Überlegen Sie, wie Sie Ihr Programm sinnvoll manuell (noch ohne JUnit)
    testen können und tun Sie das.

e)  Beachten Sie die Style- und Namensrichtlinien und dokumentieren Sie Ihr Programm
    mit Javadoc (vgl. B01).

[Objektorientierter Entwurf und Implementierung, manuelles Testen, Nutzung des Strategie-Entwurfsmusters]{.thema}
