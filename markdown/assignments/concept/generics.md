## Generische Klassen und Interfaces

In dieser Aufgabe modellieren Sie in Java verschiedene Spielertypen sowie generische Mannschaften
und Ligen, die jeweils bestimmte Spieler bzw. Mannschaften aufnehmen können.

a)  Implementieren Sie die Klasse `bundesliga.generic2.Spieler`, die das Interface
    `bundesliga.generic2.ISpieler` aus den Vorgaben erfüllt.

b)  Implementieren Sie die beiden Klassen `bundesliga.generic2.{FussballSpieler,BasketballSpieler}`
    und sorgen Sie dafür, dass beide Klassen vom Compiler als `Spieler` betrachtet werden
    (Vererbungshierarchie).

    Der `FussballSpieler` kann mit der Methode `public void schiessTor()` ein Tor schießen und
    erzielt damit einen Punkt.

    Der `BasketballSpieler` kann mit der Methode `public void wirfKorb()` einen Korb werfen und
    erzielt damit zwei Punkte.

c)  Betrachten Sie das nicht-generische Interface `bundesliga.polymorph.IMannschaft` in den
    Vorgaben. Erstellen Sie daraus das generische Interface `bundesliga.generic2.IMannschaft`
    mit einer Typvariablen. Stellen Sie durch geeignete Beschränkung der Typvariablen sicher,
    dass nur Mannschaften mit von `bundesliga.generic2.ISpieler` abgeleiteten Spielern gebildet
    werden können.

d)  Betrachten Sie das nicht-generische Interface `bundesliga.polymorph.ILiga` in den Vorgaben.
    Erstellen Sie daraus das generische Interface `bundesliga.generic2.ILiga` mit einer
    Typvariablen. Stellen Sie durch geeignete Beschränkung der Typvariablen sicher, dass nur
    Ligen mit von `bundesliga.generic2.IMannschaft` abgeleiteten Mannschaften angelegt werden
    können.

e)  Leiten Sie von `bundesliga.generic2.ILiga` das generische Interface `bundesliga.generic2.IBundesLiga`
    ab. Stellen Sie durch geeignete Formulierung der Typvariablen sicher, dass nur Ligen mit Mannschaften
    angelegt werden können, deren Spieler vom Typ `bundesliga.generic2.FussballSpieler` (oder abgeleitet)
    sind.

    Realisieren Sie die Funktionalität von `bundesliga.generic2.IBundesLiga` als
    **nicht-generisches** Interface `bundesliga.generic2.IBundesLiga2`.

[Betrachten Sie die JUnit4-Tests in den Vorgaben wieder als (zusätzliche) ausführbare Spezifikation.]{.hinweis}

[Sicherer Umgang mit generischen Klassen und Methoden]{.thema}

## Generische verkettete Listen

<!-- TODO: in verkürzter Form auch E2 -->

a.  Sie finden in den Vorgaben ein Interface für eine (stark vereinfachte) Listen-API
    (`linkedlist.ISimpleList`).

    Implementieren Sie eine generische Klasse `linkedlist.SimpleLinkedList`, die
    dieses Interface als **einfach verkettete Liste** implementiert.

    [Sie sollen den Listen-Datentyp und ggf. damit zusammenhängende Hilfsklassen etc.
     selbst realisieren! Verwenden Sie also **nicht** intern einfach Datenstrukturen
     aus dem JDK o.ä.!]{.hinweis}

    <!-- XXX
    https://docs.oracle.com/javase/8/docs/api/java/util/List.html
    -->


b.  Implementieren Sie das Interface `java.lang.Iterable` für Ihre Klasse
    `linkedlist.SimpleLinkedList`, um mit einer `foreach`-Schleife elementweise
    über alle Elemente einer `SimpleLinkedList` iterieren zu können:

    ```java
    SimpleLinkedList<Integer> speicher = ...;
    for (Integer i : speicher) {
        summe += i;
    }
    ```


c.  Machen Sie Ihre Liste sortierbar: Implementieren Sie das Interface `linkedlist.ISortable`
    für Ihre Klasse `linkedlist.SimpleLinkedList`.^[Normalerweise würde man das Interface
    `java.util.List` implementieren und könnte dann die selbst implementierten verketteten
    Listen auch durch `java.util.Collections#sort()` sortieren lassen. Dann müssten Sie aber
    noch etliche weitere Listenmethoden implementieren. Diese Mehrarbeit wollten wir Ihnen
    ersparen :-)]

    Um die Liste sortieren zu können, muss der Typparameter vergleichbar sein, d.h. das
    Interface `java.lang.Comparable` implementieren. Bilden Sie den Vergleich zwischen
    zwei Listenelementen auf den Vergleich zwischen den gespeicherten Daten ab!

    Definieren Sie zwei verschiedene Comperatoren, so dass Sie eine Liste auf- bzw.
    absteigend sortieren können.

    [Vergessen Sie nicht, neben `compareTo` auch `equals` und `hashCode` passend zu implementieren!]{.hinweis}


d.  Ein Stack kann intern durch eine Liste realisiert werden. Implementieren Sie dazu das
    Interface `linkedlist.IStack` für Ihre Klasse `linkedlist.SimpleLinkedList`.


[Betrachten Sie die JUnit4-Tests in den Vorgaben wieder als (zusätzliche)
 ausführbare Spezifikation.]{.hinweis}

[Sie können die Vorgabe-Tests auch einzeln ausführen, um die Implementierung schrittweise
 zu erweitern. Beachten Sie bitte dabei, dass jeweils die Funktionalitäten der verketteten
 Liste (`linkedlist.ISimpleList`) benötigt werden. D.h. um beispielsweise die Tests zur
 Sortierbarkeit (`linkedlist.SortTest`) ausführen zu können, muss die Klasse `linkedlist.SimpleLinkedList`
 bereits das Interface `linkedlist.ISimpleList` implementieren ...]{.hinweis}

[Komplexere generische Datenstrukturen selbst implementieren]{.thema}


## Generics Linked list

<!-- TODO: auch B03 -->

a.  Sie finden in den Vorgaben ein Interface für eine (stark vereinfachte) Listen-API
    (`linkedlist.ISimpleList`).

    Implementieren Sie eine generische Klasse `linkedlist.SimpleLinkedList`, die
    dieses Interface als **einfach verkettete Liste** implementiert.

    [Sie sollen den Listen-Datentyp und ggf. damit zusammenhängende Hilfsklassen etc.
     selbst realisieren! Verwenden Sie also **nicht** intern einfach Datenstrukturen
     aus dem JDK o.ä.!]{.hinweis}

    <!-- XXX
    https://docs.oracle.com/javase/8/docs/api/java/util/List.html
    -->


b.  Implementieren Sie das Interface `java.lang.Iterable` für Ihre Klasse
    `linkedlist.SimpleLinkedList`, um mit einer `foreach`-Schleife elementweise
    über alle Elemente einer `SimpleLinkedList` iterieren zu können:

    ```java
    SimpleLinkedList<Integer> speicher = ...;
    for (Integer i : speicher) {
        summe += i;
    }
    ```


c.  Machen Sie Ihre Liste sortierbar: Implementieren Sie das Interface `linkedlist.ISortable`
    für Ihre Klasse `linkedlist.SimpleLinkedList`.^[Normalerweise würde man das Interface
    `java.util.List` implementieren und könnte dann die selbst implementierten verketteten
    Listen auch durch `java.util.Collections#sort()` sortieren lassen. Dann müssten Sie aber
    noch etliche weitere Listenmethoden implementieren. Diese Mehrarbeit wollten wir Ihnen
    ersparen :-)]

    Um die Liste sortieren zu können, muss der Typparameter vergleichbar sein, d.h. das
    Interface `java.lang.Comparable` implementieren. Bilden Sie den Vergleich zwischen
    zwei Listenelementen auf den Vergleich zwischen den gespeicherten Daten ab!

    Definieren Sie zwei verschiedene Comperatoren, so dass Sie eine Liste auf- bzw.
    absteigend sortieren können.

    [Vergessen Sie nicht, neben `compareTo` auch `equals` und `hashCode` passend zu implementieren!]{.hinweis}


d.  Ein Stack kann intern durch eine Liste realisiert werden. Implementieren Sie dazu das
    Interface `linkedlist.IStack` für Ihre Klasse `linkedlist.SimpleLinkedList`.


[Betrachten Sie die JUnit-Tests in den Vorgaben wieder als (zusätzliche)
 ausführbare Spezifikation.]{.hinweis}

[Sie können die Vorgabe-Tests auch einzeln ausführen, um die Implementierung schrittweise
 zu erweitern. Beachten Sie bitte dabei, dass jeweils die Funktionalitäten der verketteten
 Liste (`linkedlist.ISimpleList`) benötigt werden. D.h. um beispielsweise die Tests zur
 Sortierbarkeit (`linkedlist.SortTest`) ausführen zu können, muss die Klasse `linkedlist.SimpleLinkedList`
 bereits das Interface `linkedlist.ISimpleList` implementieren ...]{.hinweis}

[Komplexere generische Datenstrukturen selbst implementieren]{.thema}
