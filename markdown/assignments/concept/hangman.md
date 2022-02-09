## UML2Code

Implementieren Sie ein Programm, das den Part des ersten Spielers bei einer textbasierten
Version des Galgenmännchens übernimmt (d.h. Sie müssen kein Galgenmännchen zeichnen, sondern
nur die Anzahl der Fehlversuche im Auge behalten). Die gebräuchlichsten Spielregeln finden
Sie im Web: [de.wikipedia.org/wiki/Galgenmännchen](https://de.wikipedia.org/wiki/Galgenm%C3%A4nnchen).

Implementieren Sie zur Lösung der Aufgabe das folgende UML-Klassendiagramm und speichern Sie
alle Klassen im Package `hangman`. Die Klassen, Attribute und Methoden haben einen "sprechenden"
Namen und sollen entsprechend das tun, was ihr Name sagt.

Über die Methode `playGame` der Klasse `WordQuiz` können Sie ein Spiel starten und dabei (je
nach Methode) über die Parameter festlegen, welche Länge das zu erratende Wort haben soll
(`int`-Parameter), aus welcher Kategorie es stammen soll (`Subject`) und wie schwer das Spiel
sein soll (`Difficulty`), d.h. wie viele Fehlversuche man  maximal hat. Bei den Varianten mit
fehlenden Parametern soll jeweils ein Defaultwert für die fehlenden Parameter genutzt werden.
Beispiel: `playGame(int, Subject)` nutzt für die `Difficulty` einen Defaultwert. Der Rückgabewert
von `addWordList` ist `true`, falls die übergebene Wortliste intern gespeichert werden konnte und
`false`, falls alle Wortlisten bereits angelegt sind.

Objekte vom Typ `WordList` stellen Listen mit möglichen zu erratenden Wörtern dar; dabei
wird das Thema der Liste beim Erzeugen des Objekts angegeben (`Subject`) und die Textdatei
mit den Rate-Wörtern dieser Kategorie mit der Hilfsmethode `readListFromFile` eingelesen (der
`String`-Parameter ist der Dateiname).

Mit einem `ConsoleReader` lesen Sie das nächste geratene Zeichen von der Tastatur ein.

Über die Writer kann die Methode `playGame` den jeweiligen Zug ausgeben. Dabei schreibt
ein `ConsoleWriter` auf die Konsole, ein `ExcelWriter` mit Hilfe von Apache POI (siehe
nächste Teilaufgabe) in eine Exceldatei, deren Name das Thema der Wortliste, aus der
das Ratewort stammt, ist (mit der Endung `.xls`). Dazu ruft `playGame` nach jedem Zug die
Methode `write` auf und übergibt die bisher geratenen Buchstaben (`char[]`), den aktuell
eingegebenen Buchstaben (`char`) sowie die Anzahl der aktuell verbleibenen Fehlversuche
(`int`).[^6]

![UML](figs/galgenmaennchen.pdf)\


Nutzen Sie für das Erzeugen einer `WordQuiz`-Instanz eine extra Hilfsklasse (nicht im UML-Klassendiagramm
aufgeführt) mit einer `main`-Methode. Diese Methode baut dann auch die `WordList`-Objekte und übergibt
sie an das `WordQuiz` (dito für `Writer`/`ConsoleReader`/...) und startet letztlich das Spiel durch den
Aufruf einer `playGame`-Methode.


[Zum Umgang mit dem `BufferedReader` und dem `InputStreamReader` für das Einlesen
 von Zeichen von der Standard-Eingabe lesen Sie ggf. in der Semesterliteratur
 nach.]{.hinweis}

[**Das UML-Klassendiagramm umfasst sämtliche erlaubten Klassen/Attribute/Methoden/Parameter.**]{.hinweis}

[^6]: Hier sehen Sie übrigens das Strategie-Entwurfsmuster am Werk. Näheres dazu in der
Vorlesung "Strategy-Pattern" und auf B02.

[Umgang mit UML-Klassendiagrammen und Implementierung]{.thema}


## Apache POI

Bauen Sie in die obige Implementierung eine Ausgabe des Spielverlaufs in eine Excel-Datei ein
(`ExcelWriter`). Dabei soll jeder "Zug" samt Zeitstempel mit Hilfe der `write`-Methode in eine
neue Zeile geschrieben werden.

Nutzen Sie hierfür die Java-API [POI-HSSF bzw. POI-XSSF](https://poi.apache.org/components/spreadsheet/index.html)[^4]
aus dem [Apache POI](https://poi.apache.org/)-Projekt.


**Beachten Sie folgende Punkte:**

1.  Beim Speichern in eine neue Excel-Datei soll diese vom Programm angelegt
    werden. Als Namen wählen Sie das `Subject` plus die Endung `.xls`.

2.  Die Daten der Logmeldungen werden in vier Spalten organisiert: der Zeitstempel,
    die bisher geratenen Buchstaben (`char[]`), der aktuell eingegebene Buchstabe (`char`)
    sowie die Anzahl der aktuell verbleibenen Fehlversuche (`int`).

3.  Die erste Zeile soll ein Header sein, wobei in den Zellen der Name der Spalte steht.

4.  Sorgen Sie für eine ansprechende und übersichtliche Formatierung:
    *   Die Zellen des Headers sollen gelb eingefärbt werden und der
        Text in den Zellen soll in Fettdruck erscheinen.
    *   Die Datenzeilen sollen abwechselnd mit einem leicht grauen Hintergrund
        eingefärbt werden, so dass sich ein leicht lesbares Streifenmuster
        ergibt.


[Nutzen Sie am besten die
 [**User-API** von POI-HSSF](https://poi.apache.org/components/spreadsheet/how-to.html#user_api)[^5]
 und erzeugen Sie damit Exceldateien im Excel '97(-2007) Format mit  der Endung `.xls`. Diese können
 Sie problemlos mit Open- oder LibreOffice öffnen. Eine Excel-Installation wird *nicht* benötigt!]{.hinweis}

[^4]: [poi.apache.org/spreadsheet/](https://poi.apache.org/components/spreadsheet/index.html)
[^5]: [poi.apache.org/spreadsheet/how-to.html](https://poi.apache.org/components/spreadsheet/how-to.html#user_api)

[Einarbeitung in komplexe APIs, Umgang mit POI und Tabellen]{.thema}

## Coding Conventions und UML

Halten Sie die Code-Richtlinien gemäß ["Google Java Style Guide"](https://google.github.io/styleguide/javaguide.html)[^1]
ein, insbesondere in Bezug auf die Formatierung Ihres Codes, die Namensgebung sowie die Dokumentation mit
Javadoc. Wählen Sie darüber hinaus stets **"sprechende" Namen für die Bezeichner**[^2], damit der Sinn der
Bezeichner dem Leser Ihres Codes sofort klar wird.

Das Thema Klassendiagramme mit UML sollte ausführlich im Modul OOP besprochen worden sein. Bei Unsicherheiten
schauen Sie bitte in der Literatur nach, beispielsweise im "*Grundkurs Software-Engineering mit UML*" von
Stephan Kleuker[^3] (insbesondere Anhang "A UML-Überblick" und Kapitel "5.2 Ableitung von grundlegenden Klassen")
oder auf [de.wikipedia.org/wiki/Klassendiagramm](https://de.wikipedia.org/wiki/Klassendiagramm).


[^1]: [google.github.io/styleguide/javaguide.html](https://google.github.io/styleguide/javaguide.html)
[^2]: [de.wikipedia.org/wiki/Namenskonvention_(Datenverarbeitung)](https://de.wikipedia.org/wiki/Namenskonvention_(Datenverarbeitung)), insbesondere die Abschnitte "Namenskonventionen für Java" und "Weitere Namensregeln"
[^3]: Kleuker, S. 2018. *Grundkurs Software-Engineering mit UML*. Springer Vieweg. DOI: [10.1007/978-3-658-19969-2](https://doi.org/10.1007/978-3-658-19969-2).






\clearpage
