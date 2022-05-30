In den Vorgaben finden Sie in der Klasse `Lexer` eine einfache Implementierung
eines [Lexers](https://de.wikipedia.org/wiki/Tokenizer), worin ein einfaches
Syntax-Highlighting für Java-Code realisiert ist.

Dazu arbeitet der Lexer mit sogenannten "Token" (Instanzen der Klasse `Token`).
Diese haben einen regulären Ausdruck, um bestimmte Teile im Code zu erkennen,
beispielsweise Keywords oder Kommentare und anderes. Der Lexer wendet alle Token
auf den aktuellen Eingabezeichenstrom an (Methode `Token#test()`), und die Token
prüfen mit "ihrem" regulären Ausdruck, ob die jeweils passende Eingabesequenz
vorliegt. Die regulären Ausdrücke übergeben Sie dem `Token`-Konstruktor als
entsprechendes `Pattern`-Objekt.

Neben dem jeweiligen Pattern kennt jedes Token noch eine `matchingGroup`: Dies
ist ein Integer, der die relevante Matching-Group im regulären Ausdruck bezeichnet.
Wenn Sie keine eigenen Gruppen in einem regulären Ausdruck eingebaut haben, nutzen
Sie hier einfach den Wert 0.

Zusätzlich kennt jedes Token noch die Farbe für das Syntax-Highlighting in der
von uns als Vorgabe realisierten Swing-GUI (Instanz von `Color`).


Erstellen Sie passende `Token`-Instanzen mit entsprechenden Pattern für die
folgenden Token:

-   Einzeiliger Kommentar: beginnend mit `//` bis zum Zeilenende
-   Mehrzeiliger Kommentar: alles zwischen `/*` und dem nächsten `*/`
-   Javadoc-Kommentar: alles zwischen `/**` und dem nächsten `*/`
-   Strings: alles zwischen `"` und dem nächsten `"`
-   Character: genau ein Zeichen zwischen `'` und `'`
-   Keywords: `package`, `import`, `class`, `public`, `private`, `final`,
    `return`, `null`, `new` (jeweils freistehend, also nicht "newx" o.ä.)
-   Annotation: beginnt mit `@`, enthält Buchstaben oder Minuszeichen


Die Token-Objekte fügen Sie im Konstruktor der Klasse `Lexer` durch den
Aufruf der Methode `tokenizer.add(mytoken)` hinzu. Sie können Sich an den
Kommentaren im `Lexer`-Konstruktor orientieren.


Sollten Token ineinander geschachtelt sein, erkennt der Lexer dies automatisch.
Sie brauchen sich keine Gedanken dazu machen, in welcher Reihenfolge die Token
eingefügt und abgearbeitet werden. Beispiel: Im regulären Ausdruck für den
einzeiligen Kommentar brauchen Sie keine Keywords, Annotationen, Strings usw.
erkennen.
