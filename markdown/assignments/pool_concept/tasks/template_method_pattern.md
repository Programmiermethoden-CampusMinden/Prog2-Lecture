Schreiben Sie eine abstrakte Klasse Drucker. Implementieren Sie die Funktion
`kopieren`, bei der zuerst die Funktion `scannen` und dann die Funktion `drucken`
aufgerufen wird. Der Kopiervorgang ist für alle Druckertypen identisch,
das Scannen und Drucken ist abhängig vom Druckertyp.

Implementieren Sie zusätzlich zwei unterschiedliche Druckertypen.
- `Tintendrucker extends Drucker`
- `Laserdrucker extends Drucker`
- `Tintendrucker#scannen` loggt den Text "Scanne das Dokument mit dem Tintendrucker."
- `Laserdrucker#scannen` loggt den Text "Scanne das Dokument mit dem Laserdrucker."
- `Tintendrucker#drucken` loggt den Text "Drucke das Dokument auf dem Tintendrucker."
- `Laserdrucker#drucken` loggt den Text "Drucke das Dokument auf dem Laserdrucker."

Nutzen Sie das Template-Method-Pattern.
