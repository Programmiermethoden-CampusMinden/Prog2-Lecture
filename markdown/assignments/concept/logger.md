## Logger II

Erweitern Sie das Logging in Ihrem Lexer:

*   Nutzen Sie zunächst einen `ConsoleHandler`. Schreiben Sie sich einen Formatter, den Sie
    im `ConsoleHandler` nutzen und der die Logmeldungen in etwa so formatiert:

        -----------------------------------------------------------
        Logger: <name>
            Level: <level>
            Class: <class>
            Method: <method>
            Message: <message>
        -----------------------------------------------------------

*   Um eine zusätzliche Ausgabe in eine HTML-Datei zu ermöglichen, ergänzen Sie die Logger
    nun noch um einen `FileHandler`. Schreiben Sie sich einen weiteren Formatter, der die
    Logmeldung als HTML-Schnipsel formatiert (analog zur Formatierung für die Ausgabe in
    der GUI) und nutzen Sie diesen im `FileHandler`.

    Je nach Level soll die Farbe und Hervorhebung der Meldung variieren, beispielsweise *rot*
    und *fett* für das Level `SEVERE`. Schauen Sie sich das generierte Logfile mit einem
    Browser an.

*   Unterdrücken Sie zusätzlich erscheinende Konsolenausgaben, die nicht von Ihren Formattern
    stammen.

*   Wie können Sie die Empfindlichkeit des Loggings in der `main()`-Methode steuern? Wie
    kann man dort einzelne Logger komplett abschalten? Nutzen Sie dazu die in der nächsten
    Teilaufgabe implementierte CLI-Option.

Überlegen Sie sich geeignete Testfälle und führen Sie diese durch.^[Passende Aufrufe in `main()`
und manuelle Kontrolle der Konsolenausgabe bzw. der Zieldatei reichen. Sie können aber auch gern
mit JUnit arbeiten.]

## Syntax-Highlighting

Erweitern Sie den Logger um Funktionalität zum SyntaxHighlighting.

1.  Implementieren Sie die Methoden zum Formatieren des Token-Inhalts.

    Die Methode `Token#getHtml` wird in der abstrakten Basisklasse `Token`
    implementiert und kann nicht überschrieben werden (`final`). Sie erzeugt den
    gewünschten HTML-formatierten String durch den Aufruf der abstrakten Methoden
    `Token#htmlStart`, `Token#getContent` und `Token#htmlEnd` und die entsprechende
    Konkatenation der jeweiligen Rückgabewerte. Die drei zuletzt genannten Methoden
    werden erst in den konkreten (abgeleiteten) Token-Klassen implementiert.[^TemplateMethodPattern]

    Nutzen Sie für die Formatierung **HTML-Tags**. Beispielsweise könnten
    Java-Schlüsselwörter fett und dunkelrot formatiert werden, Kommentare kursiv
    und in einem dunklen Grau. Die einzelnen Tokenarten sollen sich in ihrer
    Formatierung deutlich voneinander unterscheiden, die verschiedenen Kommentare
    können die gleiche Formatierung nutzen.

    Beispiel (Schlüsselwort `public` in rot+fett):
    ```html
    <font color="red"><b>public</b></font>
    ```

    Verweis auf Textformatierung mit HTML: [selfhtml.org](https://wiki.selfhtml.org/wiki/HTML).

2.  Finden Sie heraus, welche von `JTextComponent` abgeleiteten Klassen
    HTML-Dokumente darstellen können und die Bearbeitung der dargestellten Inhalte
    ermöglichen.

    Bauen Sie eine Swing-GUI auf, deren zentrales Element eine Instanz dieser
    Klasse ist. Das Element soll auf Textänderungen reagieren, indem nach einer
    Änderung der aktuelle Textinhalt an den Lexer aus dem vorigen Aufgabenteil
    übergeben wird und aus der resultierenden Liste von Token jeweils die
    **formatierten Stringrepräsentationen** abgerufen werden.

    Diese Strings müssen in ein minimales HTML-Gerüst eingebettet werden und können
    dem Element als neuer Text gesetzt werden. Verweis auf Aufbau einer HTML-Datei:
    [selfhtml.org: Grundgerüst](https://wiki.selfhtml.org/wiki/HTML/Dokumentstruktur_und_Aufbau).
    Ihre durch die Token erzeugten HTML-Schnipsel gehören zwischen die Tags
    `<body>` und `</body>`.

    Da das Element HTML-formatierten Text interpretieren und formatiert darstellen
    kann, haben Sie soeben ein einfaches Syntax-Highlighting realisiert.

    [Das Highlighting muss nicht nach jeder Änderung am Eingabetext automatisch
     aktualisiert werden. Es ist ausreichend, eine entsprechende Aktualisierung
     durch Aktivierung eines Buttons o.ä. zu triggern. Weiterhin ist es ausreichend,
     wenn Sie ein Editorfenster (ohne Highlighting) und ein Vorschaufenster
     (Highlighting des Textes im Editor-Fenster) realisieren.]{.hinweis}

[Formatierung von Strings mit HTML-Code; Einarbeitung in Swing]{.thema}
