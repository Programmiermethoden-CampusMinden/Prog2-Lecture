## Debugger

Üben Sie den Umgang mit dem Debugger Ihrer IDE. Insbesondere:

*   Breakpoints: setzen, löschen, deaktivieren ("disable")
*   Schrittweise Ausführung: step into, step over, resume
*   Betrachten und Ändern von Variablen

[Sicherer Umgang mit dem Debugger]{.thema}


## UML2Code und Javadoc

Stellen Sie die im folgenden UML-Klassendiagramm dargestellten Klassen und
Beziehungen korrekt in Java dar.

![Abrechnung](figs/abrechnung.pdf)\

\bigskip

[Lesen und Verstehen von UML-Klassendiagrammen; Nutzung von Annotationen]{.thema}


## Charts mit Java

<!-- TODO: Prüfen, ob man den Code einfach so einbinden kann oder ob es Abhängigkeiten gibt, ggf. als JAR bereitstellen! -->
<!-- TODO: URLs entsprechend anpassen -->

Laden Sie sich von [github.com/jfree/jfreechart](https://github.com/jfree/jfreechart)
die JFreeChart-Bibliothek für Java herunter und binden Sie diese in Ihr Projekt
ein.^[Sie finden unter [repo1.maven.org/maven2/org/jfree/jfreechart/1.5.0/jfreechart-1.5.0.jar](https://repo1.maven.org/maven2/org/jfree/jfreechart/1.5.0/jfreechart-1.5.0.jar) die kompilierte Bibliothek, nutzen Sie diese!]
Erzeugen Sie mit Hilfe dieser Bibliothek mindestens drei verschiedene sinnvolle
Charts (d.h. drei unterschiedliche Diagrammtypen) zum Überblick über die Spiele
und/oder Spieler.


**Achtung**: Die Dokumentation zu JFreeChart ist kostenpflichtig! Sie benötigen
diese aber nicht --- nutzen Sie stattdessen die kostenfrei verfügbare
[Javadoc-Dokumentation der API](http://www.jfree.org/jfreechart/api/javadoc/index.html) sowie
die [FAQ](http://www.jfree.org/jfreechart/faq.html).

<!-- XXX
[Erzeugen Sie sich mit den statischen Methoden von `ChartFactory` ein neues
 `JFreeChart`-Objekt und stecken dieses in ein `ChartPanel`, um das Diagramm
 anzuzeigen.]{.hinweis}
Alternativ geht können Sie auch `makeCharts()` nutzen.
TODO ist jetzt `ChartFactory.create*Chart()`?!
-->

[Einarbeitung in fremde APIs, Erstellen von Diagrammen in Java]{.thema}


## Template Method Pattern

Führen Sie eine Recherche durch und erklären Sie die Funktionsweise des
*Template Method Pattern*.

[Selbstständige Literaturrecherche, Entwurfsmuster "Template Method"]{.thema}


## Build-Skripte: Ant oder Gradle

Erstellen Sie ein oder mehrere Build-Skripte (etwa für Ant oder für Gradle), mit denen Sie
Ihr Projekt unabhängig von der IDE übersetzen und starten können.

[Sicherer Umgang mit der Java-Logging-API `java.util.logger`]{.thema}


## Konfiguration

Bauen Sie unter Nutzung von [Apache Commons CLI](https://commons.apache.org/proper/commons-cli/)
eine Auswertung von Kommandozeilen-Parametern in Ihren Lexer ein.

Es soll mindestens folgende Optionen geben:

1.  Ausgabe einer Hilfe für den Start des Programms: Welche Optionen gibt
    es, wie werden diese geschrieben, welche Parameter werden erwartet, ...
2.  Aktivierung (bzw. Deaktivierung) des Loggers.
3.  Eingabe eines Ordners, aus dem die Token per Reflection geladen werden sollen.

Nutzen Sie benannte Parameter. Sehen Sie jeweils sowohl die Kurz- als auch die
Langform vor. Beachten Sie, dass einige Parameter selbst Argumente haben.

[Umgang mit der Apache CLI-Bibliothek]{.thema}


# Refactoring

Betrachten Sie das Projekt `refactoring` in den Vorgaben. Hier wird mit Hilfe der drei
Klassen  `Album`, `Streaming` und `Customer` eine Art Audio-Streamingdienst realisiert
(eigentlich nur der Abrechnungs-Teil). Mit der Methode `Customer#accountDetails` kann
man sich eine Übersicht der aufgelaufenen Kosten für das Streamen von Alben und der
dabei gesammelten Bonus-Punkte erzeugen.

Dieses Projekt entspricht leider nicht den Prinzipien des objektorientierten Softwareentwurfs.
Beheben Sie die Probleme durch Anwendung von Refactoring-Methoden.

1.  Erstellen Sie einen neuen Themen-Branch, in dem Sie das Refactoring durchführen.

2.  Erstellen Sie eine passende JUnit-Testsuite zum Vorgabecode und committen Sie diese.

3.  Führen Sie nun ein **schrittweises** Refactoring ihres Projekts durch. Achten Sie darauf,
    dass Sie nach jedem Schritt Ihre Testsuite laufen lassen. Ggf. müssen Sie die Tests anpassen
    bzw. neue erstellen! Committen Sie die Änderungen am Code (und ggf. den Tests) nach **jedem**
    Refactoring-Schritt!

    Wenden Sie mindestens folgende Refactoring-Methoden sinnvoll(!) an:

    *   Encapsulate Field
    *   Rename Field, Rename Method
    *   Extract Method, Extract Class
    *   Move Method
    *   Push Up, Pull Down

4.  Führen Sie das Refactoring so lange durch, bis Sie der Meinung sind, dass der Code jetzt
    den Regeln des objektorientierten Designs entspricht.


# ANT (Refactoring Project)

Schreiben Sie für das Refactoring-Projekt ein passendes Ant-File mit dem Namen
`build.xml`. Folgende Teilziele (mit passenden Abhängigkeiten) sollen mindestens enthalten
sein:

*   `clean`: Löschen aller generierten (Hilfs-) Dateien
*   `compile`: Kompilieren der Java-Sourcen in `refactoring/src/`
*   `test`: Ausführen der eigenen JUnit-Tests und Generieren einer Auswertung (XML)
    aller JUnit-Testergebnisse
*   `jar`: Erzeugen eines `.jar` aus den `*.class`
*   `doc`: Erzeugen der Dokumentation mit Javadoc
*   `dist`: Kopieren des `.jar` und der Dokumentation in den Ordner `dist/`
