In der Vorgabe finden Sie die drei Dateien `Utility.java`, `Evil.java`
und `UtilityTest.java`.

Testen Sie die Methoden `nonEvilAdd`, `evilAdd` und `veryEvilAdd` der
Klasse `Utility.java` mit dem [JUnit-](https://junit.org/) und dem
[Mockito-Framework](https://github.com/mockito/mockito).

Vervollständigen Sie dazu die vorgegebene Klasse `UtilityTest.java` und
nutzen Sie Mocking mit [Mockito](https://github.com/mockito/mockito),
um die Tests zum Laufen zu bringen. Die Tests dürfen Sie entsprechend
verändern, aber die Aufrufe aus der Vorgabe müssen erhalten bleiben. Die
Klassen `Evil.java` und `Utility.java` dürfen Sie nicht ändern.

_Hinweis:_ Die Klasse `Evil.java` und die Methode `evilMethod()` aus
`Utility.java` lösen eine ungewollte bzw. "zufällige" Exception aus,
auf deren Auftreten jedoch _nicht_ getestet werden soll. Stattdessen
sollen diese Klassen bzw. Methoden mit Mockito "weggemockt" werden, so
dass die vorgegebenen Testmethoden (wieder) funktionieren.
