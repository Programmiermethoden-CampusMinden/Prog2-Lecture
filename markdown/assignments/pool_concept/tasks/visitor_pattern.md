In den Vorgaben finden Sie die Klasse `Node` zur Realisierung von binären Suchbäumen, die verschiedene Quartettkarten speichern (`Card`).

Implementieren Sie das Visitor-Pattern für den Baum (Klasse `Node`).
Implementieren Sie einen konkreten Visitor, welcher den Baum _inorder_ traversiert, und einen konkreten  Visitor, der den Baum _postorder_ traversiert.
Beim Besuchen eines Knoten soll der Name der gespeicherten Karte sowie deren Preis ausgegeben werden.

Rufen Sie Ihre Visitoren auf dem Binärbaum `root` in der `main()` auf (Zeile 38).

__Note__ `root.toDotGraph()` gibt Ihnen den Binärbaum in Dot-Notation wieder. Diese können Sie nutzen, um den Baum graphisch darzustellen (zum Beispiel mit Graphviz).

