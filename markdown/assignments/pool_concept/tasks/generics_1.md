In dieser Aufgabe modellieren Sie in Java verschiedene Spielertypen sowie generische Mannschaften
und Ligen, die jeweils bestimmte Spieler bzw. Mannschaften aufnehmen können.

a) Implementieren Sie die Klasse `bundesliga.generic.Spieler`, die das Interface
`bundesliga.generic.ISpieler` aus den Vorgaben erfüllt.

b) Implementieren Sie die beiden Klassen `bundesliga.generic.{FussballSpieler,BasketballSpieler}`
und sorgen Sie dafür, dass beide Klassen vom Compiler als Spieler betrachtet werden
(Vererbungshierarchie).

c) Betrachten Sie das nicht-generische Interface `bundesliga.polymorph.IMannschaft` in den
Vorgaben. Erstellen Sie daraus das generische Interface `bundesliga.generic.IMannschaft`
mit einer Typvariablen. Stellen Sie durch geeignete Beschränkung der Typvariablen sicher,
dass nur Mannschaften mit von `bundesliga.generic.ISpieler` abgeleiteten Spielern gebildet
werden können.