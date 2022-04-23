In den Vorgaben finden Sie ein Modell für eine Lieferkette zwischen Großhandel und Einzelhandel.

Wenn beim Einzelhändler eine Bestellung von einem Kunden eingeht (`Einzelhandel#bestellen`), speichert
dieser den `Auftrag` zunächst in einer Liste ab. In regelmäßigen Abständen (`Einzelhandel#loop`) sendet
der Einzelhändler die offenen Bestellungen an seinen Großhändler (`Grosshandel#bestellen`). Hat der
Großhändler die benötigte Ware vorrätig, sendet er diese an den Einzelhändler (`Einzelhandel#empfangen`).
Dieser kann dann den Auftrag gegenüber seinem Kunden erfüllen (keine Methode vorgesehen).

Anders als der Einzelhandel speichert der Großhandel keine Aufträge ab. Ist die benötigte Ware bei einer
Bestellung also nicht oder nicht in ausreichender Zahl auf Lager, wird diese nicht geliefert und der
Einzelhandel muss (später) eine neue Bestellung aufgeben.

Der Großhandel bekommt regelmäßig (`Grosshandel#loop`) neue Ware für die am wenigsten vorrätigen Positionen.


Im aktuellen Modell wird der Einzelhandel nicht über den neuen Lagerbestand des Großhändlers informiert
und kann daher nur "zufällig" neue Bestellanfragen an den Großhändler senden.

Verbessern Sie das Modell, indem Sie das Observer-Pattern integrieren. Wer ist Observer? Wer ist Observable?
Welche Informationen werden bei einem `update` mitgeliefert?

Bauen Sie in alle Aktionen vom Einzelhändler und vom Großhändler passendes Logging ein.

_Anmerkung_: Sie dürfen nur die Vorgaben-Klassen `Einzelhandel` und `Grosshandel` verändern, die anderen
Vorgaben-Klassen dürfen Sie nicht bearbeiten. Sie können zusätzlich benötigte eigene Klassen/Interfaces
implementieren.
