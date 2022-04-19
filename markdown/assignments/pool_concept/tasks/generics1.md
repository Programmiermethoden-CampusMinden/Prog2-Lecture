In dieser Aufgabe modellieren Sie in Java verschiedene Spielertypen sowie generische
Mannschaften und Ligen, die jeweils bestimmte Spieler (-typen) bzw. Mannschaften
aufnehmen können.

1.  Implementieren Sie die Klasse `bundesliga.generic.Spieler`, die das Interface
    `bundesliga.generic.ISpieler` aus den Vorgaben erfüllt.

2.  Implementieren Sie die beiden Klassen `bundesliga.generic.FussballSpieler` und
    `bundesliga.generic.BasketballSpieler` und sorgen Sie dafür, dass beide Klassen
    vom Compiler als Spieler betrachtet werden (geeignete Vererbungshierarchie).

3.  Betrachten Sie das nicht-generische Interface `bundesliga.polymorph.IMannschaft`
    in den Vorgaben. Erstellen Sie daraus das generische Interface `bundesliga.generic.IMannschaft`
    mit einer Typ-Variablen. Stellen Sie durch geeignete Beschränkung der Typ-Variablen
    sicher, dass nur Mannschaften mit von `bundesliga.generic.ISpieler` abgeleiteten
    Spielern gebildet werden können.
