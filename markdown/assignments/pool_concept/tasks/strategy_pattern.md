Implementieren Sie das Spiel "Schere,Stein,Papier" (Spielregeln vergleiche
[wikipedia.org/wiki/Schere,Stein,Papier](https://de.wikipedia.org/wiki/Schere,_Stein,_Papier)) in Java. Nutzen
Sie dazu die Interfaces und das `Cheater.jar` aus der Vorgabe.

Es soll eine eigene Klasse für die Spieler geben, die das vorgegebene Interface `rps.game.IPlayer`
implementiert. Ihr Spiel muss das vorgegebene Interface `rps.game.IGame` implementieren. Nutzen Sie
für die Repräsentation der Spielzüge das Enum `rps.game.Move` aus der Vorgabe. Die Enum-Konstanten können sie
beim Zuweisen direkt verwenden. Um ein Enum auf der Konsole auszugeben, können Sie die Methode `name()` des Enums verwenden.

Implementieren Sie das Strategy-Pattern, um den Spielerinstanzen zur Laufzeit eine konkrete Spielstrategie mitzugeben, nach denen die Spieler ihre Züge _berechnen_.
Implementieren Sie mindestens drei unterschiedliche konkrete Strategien.

_Hinweis_: Eine mögliche Strategie könnte sein, den Nutzer via Tastatureingabe nach dem nächsten Zug zu fragen.

In der Vorgabe finden Sie im Unterverzeichnis `lib/` die Datei `Cheater.jar`. In dieser Datei befindet sich die Klasse `Cheater`, die das Interface `rps.strategy.IGameStrategy` implementiert und immer gewinnt, wenn sie als zweiter Spieler verwendet wird.
Verwenden Sie diese Strategie-Klasse in ihrem Projekt.

_Hinweis_: Binden Sie das vorgegebene `.jar`-File mit der Strategie so ein, dass es zum Compilieren und zum Starten Ihres
Programms genutzt wird. Sie sollen die Datei nicht entpacken!

_Hinweis_: Ein Spieler soll in `IPlayer#nextMove` seinen nächsten Zug nur **berechnen** und darf nicht direkt den
Spielstand modifizieren! Die Berechnung im Spieler wird an die zur Laufzeit übergebene
Strategie delegiert. Das eigentliche Durchführen des berechneten Zuges geschieht dann in der Methode `IGame#doMoves`
mit der Rückgabe des Move-Objects.

**Gehen Sie bei der Lösung der Aufgabe methodisch vor**:

1.  Stellen Sie sich eine Liste mit relevanten Anforderungen zusammen.

2.  Erstellen Sie (von Hand) ein Modell (UML-Klassendiagramm):
    *   Welche Klassen und Interfaces werden benötigt?
    *   Welche Aufgaben sollen die Klassen haben?
    *   Welche Attribute und Methoden sind nötig?
    *   Wie sollen die Klassen interagieren, wer hängt von wem ab?

3.  Implementieren Sie Ihr Modell in Java. Schreiben Sie ein Hauptprogramm, welches das Spiel startet,
    die Spieler ziehen lässt und dann das Ergebnis ausgibt.

4.  Überlegen Sie, wie Sie Ihr Programm sinnvoll manuell (noch ohne JUnit) testen können und tun Sie das.
