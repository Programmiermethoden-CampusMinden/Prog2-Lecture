In den Vorgaben finden Sie die Implementierung für ein TicTacToe-Spiel.
Ihre Aufgabe ist es, eine grafische Benutzeroberfläche für das Spiel zu entwickeln.

Ihr Fenster soll sich immer in der Mitte des Bildschirms starten und einen Titel besitzen.

Beim Start des Spiels sollen beide Spieler ihre Namen eingeben können, nutzen Sie dafür `JTextField`. Stellen Sie sicher, dass nur gültige Eingaben getätigt werden.
Sind die beiden Namen gültig, erstellen Sie die jeweiligen `Player` und starten Sie ein Spiel `TicTacToe`.

Im Zentrum Ihres Spielfensters soll das Spielfeld angezeigt werden. Nutzen Sie dafür das `GridLayout` und `JButton`.
Die Buttons repräsentieren dabei die Felder des Spiels. Beim Drücken eines Buttons soll die Methode `TicTacToe#makeMove` aufgerufen werden.

Mit `TicTacToe#getGameField` können Sie sich das aktuelle Spielfeld übergeben lassen.
Sorgen Sie dafür, dass Ihre Oberfläche immer den aktuellen Zustand des Spielfeldes anzeigt.

Prüfen Sie nach jedem Spielzug den Status des Spiels mit `TicTacToe#getGameState`.
    - Wenn ein Spieler gewonnen hat, soll ein `JOptionPane` angezeigt werden und dem Gewinner gratulieren.
    - Wenn ein Unentschieden gespielt wurde, soll ein `JOptionPane` angezeigt werden und das Unentschieden angezeigt werden.
    - In beiden Fällen soll danach eine neue Runde gestartet werden.

Im unteren Bereich des Fensters soll der Spieler angezeigt werden, der aktuell am Zug ist.
Im unteren Bereich des Fensters soll auch der aktuelle Punktestand angezeigt werden.

Das Fenster soll eine Menüleiste mit folgenden Punkten haben:
    - Exit: Beendet das Programm.
    - New Game: Startet das Spiel neu und erlaubt die neue Eingabe der Spielernamen.
    - Clear: Setzt das aktuelle Spielfeld zurück.

Denken Sie bei der Umsetzung daran, dass der Benutzer nur die Oberfläche sieht und bedienen kann. Stellen Sie sicher, dass alle Bedienelemente verständlich sind.
Nutzen Sie ggf. `JLabel`, um Texte auf der UI anzuzeigen.
Für diese Aufgabe müssen Sie keine Testfälle schreiben.
