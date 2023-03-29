In der Vorgabe finden Sie die Klassen `Student` und `StudentSort` mit
vorgefertigten Methoden  zu den Teilaufgaben sowie eine Testsuite
`SortTest` mit einzelnen Testfälllen zu den Teilaufgaben, mit der Ihre
Implementierung aufgerufen und getestet wird.

Ziel dieser Aufgabe ist es, eine Liste von Studierenden mithilfe verschiedener
syntaktischer Strukturen (Lambda-Ausdrücke, Methoden-Referenzen) zu sortieren.
Dabei soll bei allen Teilaufgaben die Methode
[java.util.List#sort](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#sort(java.util.Comparator))
für das eigentliche Sortieren verwendet werden.


1.  In dieser Teilaufgabe sollen Sie der Methode `List#sort` das Sortierkriterium
    mithilfe eines **Lambda-Ausdrucks** übergeben. Greifen Sie im Lambda-Ausdruck
    für den Vergleich der Objekte auf die Getter der Objekte zu.

    _Hinweis_: Erstellen Sie hierzu keine neuen Methoden, sondern verwenden Sie
    nur Lambda-Ausdrücke innerhalb des Aufrufs von `List#sort`.

    1.  Sortieren Sie die Studierendenliste aufsteigend nach dem Geburtsdatum.
    2.  Sortieren Sie die Studierendenliste absteigend nach dem Namen.


2.  Erweitern Sie die Klasse `Student` um eine _statische_ Methode, die zwei
    `Student`-Objekte anhand des Alters miteinander vergleicht. Die Methode
    soll die Signatur `static int compareByAge(Student a, Student b)` besitzen
    und die folgenden Werte zurückliefern:

    -   a > b -> -1
    -   a < b -> 1
    -   a == b -> 0

    1.  Verwenden Sie die neue statische Methode `compareByAge` zum Sortieren
        der Liste. Nutzen Sie dabei einen **Lambda-Ausdruck**.
    2.  Verwenden Sie die neue statische Methode `compareByAge` zum Sortieren
        der Liste. Nutzen Sie dabei eine **Methodenreferenz**.


3.  Erweitern Sie die Klasse `Student` um eine Instanz-Methode, die das
    `Student`-Objekt mit einem anderen (als Parameter übergebenen) `Student`-Objekt
    vergleicht. Die Methode soll die Signatur `int compareByName(Student other)`
    besitzen und die folgenden Werte zurückliefern:

    -   self > other -> -1
    -   self < other -> 1
    -   self == other -> 0

    1.  Verwenden Sie die neue Methode `compareByName` zum Sortieren der Liste.
        Nutzen Sie dabei einen **Lambda-Ausdruck**.
    2.  Verwenden Sie die neue Methode `compareByName` zum Sortieren der Liste.
        Nutzen Sie dabei eine **Methodenreferenz**.


4.  Erstellen Sie ein generisches Funktionsinterface, dass die Methode `compare`
    definiert und zum Vergleichen von zwei Objekten mit generischen Typen dient.

    1.  Erzeugen Sie mithilfe eines **Lambda-Ausdrucks** eine **Instanz** Ihres
        Interfaces, um damit zwei Objekte vom Typ `Student` in Bezug auf ihr Alter
        vergleichen zu können. Verwenden Sie die erzeugte Instanz, um die
        Studierendenliste absteigend zu sortieren.
    2.  Erzeugen Sie eine weitere Instanz Ihres Interfaces mit einem passenden
        Lamda-Ausdruck, so dass die Liste der `Student`-Objekte aufsteigend nach
        ihrem Namen sortieren können. Erstellen Sie zudem die statische und
        generische Methode `mySort`. Diese Methode soll die Sortierung einer
        generischen Liste unter der Verwendung Ihres Funktionsinterfaces durchführen.
        Die Methode soll als Parameter die zu sortierende Liste sowie eine Instanz
        Ihres Funktionsinterfaces erwarten. Innerhalb dieser Methode dürfen Sie wie
        bisher die Methode `List#sort` verwenden. Rufen Sie diese Methode wie in
        den anderen Teilaufgaben in `StudentSort` ein, hier also in der Methode
        `StudentSort#sort_4b()`.
