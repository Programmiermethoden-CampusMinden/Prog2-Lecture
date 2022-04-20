Sie finden in den Vorgaben im Package `zoo` einige Interfaces und Klassen, mit denen
man einen Zoo modellieren kann.

1.  Erstellen Sie ein UML-Diagramm, welches die Strukturen in der Vorgabe verdeutlicht.

2.  Betrachten Sie das nicht-generische Interface `IGehege` in den Vorgaben. Arbeiten
    Sie dieses Interface in eine generische Klasse `Gehege` mit einer Typ-Variablen um
    (erstellen Sie eine neue generische Klasse mit den Methoden aus dem Interface).
    Stellen Sie durch geeignete Beschränkung der Typ-Variablen sicher, dass nur Gehege
    mit von `Tier` abgeleiteten Typen gebildet werden können. Jedes einzelne Tier im
    Gehege kann genau einmal vorkommen.

    Legen Sie in Ihrer `main()`-Methode mindestens zwei konkrete Gehege als Instanzen
    der neuen generischen Klasse `Gehege` an. Dabei sollen in diesen konkreten Gehegen
    nur jeweils Tiere einer Art (Löwe, Hamster, ...) vorkommen. Fügen Sie einige
    passende Tiere in die beiden Gehege ein.

3.  Betrachten Sie das nicht-generische Interface `IZoo` in den Vorgaben. Arbeiten
    Sie dieses Interface in eine generische Klasse `Zoo` mit einer Typ-Variablen um
    (erstellen Sie ein neue generische Klasse mit den Methoden aus dem Interface).
    Stellen Sie durch geeignete Beschränkung der Typ-Variablen sicher, dass nur Zoos
    mit von `Gehege` abgeleiteten Typen gebildet werden können. Jedes Gehege gibt es
    pro Zoo nur einmal, und die Reihenfolge des Errichtens definiert eine Ordnung
    auf den Gehegen.

    Legen Sie in Ihrer `main()`-Methode einen konkreten Zoo als Instanz der neuen
    generischen Klasse `Zoo` an. Dieser Zoo soll einige Gehege für verschiedene Tiere
    beinhalten.

4.  Leiten Sie von `Zoo` eine nicht-generische Klasse `Aquarium` ab. Stellen Sie durch
    geeignete Formulierung der Typ-Variablen sicher, dass nur Aquarien mit Gehegen
    angelegt werden können, deren Tiere vom Typ `Fisch` (oder abgeleitet) sind.

    Legen Sie in Ihrer `main()`-Methode ein konkretes Aquarium als Instanz der neuen
    generischen Klasse `Aquarium` an und gruppieren Sie darin verschiedene Fisch-"Gehege".

_Hinweis_: Die Interfaces `IGehege` und `IZoo` sind nicht vollständig (kein gültiger
Java-Code) und sollen Ihnen nur die gewünschten Methoden für Ihre entsprechenden
generischen Klassen verdeutlichen. Diese müssen Sie in Ihren generischen Klassen mit
der korrekten Syntax implementieren.
