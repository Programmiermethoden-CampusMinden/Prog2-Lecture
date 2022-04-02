Betrachten Sie den Ringpuffer in der Vorgabe (inkl. JUnit-Tests und einem Main-Programm).

Fügen Sie in diese drei Artefakte Logging auf der Basis von `java.util.logging` ein, so
dass es keine Ausgaben mit `System.out.println` oder `System.err.println` mehr gibt und
dass an allen interessanten Stellen passende Informationen ausgegeben werden und sich so
der Ablauf des Programms und der Zustand des Ringpuffers über die Logs nachvollziehen
lässt.


1.  Schreiben Sie einen Formatter, welcher die Meldungen in folgendem Format auf der
    _Konsole_ ausgibt. Bauen Sie diesen Formatter in alle Logger ein.

    ```
    ------------
    Logger: record.getLoggerName()
    Level: record.getLevel()
    Class: record.getSourceMethodName()
    Method: record.getSourceClassName()
    Message: record.getMessage()
    ------------
    ```

2.  Schreiben Sie einen weiteren Formatter, welcher die Daten als Komma-separierte Werte
    (CSV-Format) mit der folgenden Reihenfolge in eine _Datei_ ausgibt (durch Anfügen
    einer neuen Zeile an bereits bestehenden Inhalt). Bauen Sie diesen Formatter in den
    Logger für den Ringpuffer ein.

    ```
    record.getLoggerName(),record.getLevel(),record.getSourceMethodName(),record.getSourceClassName(),record.getMessage()
    ```

3.  Ersetzen Sie mindestens sämtliche Konsolenausgaben (`System.out.println` und
    `System.err.println`) in der Vorgabe durch geeignete Logger-Aufrufe mit passendem
    Log-Level.

    Alle Warnungen und Fehler sollen zusätzlich in eine `.csv`-Datei geschrieben werden.
    Auf der Konsole sollen alle Log-Meldungen ausgegeben werden.
