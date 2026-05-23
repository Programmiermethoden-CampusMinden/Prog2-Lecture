---
author: Carsten Gips (HSBI)
title: Observer-Pattern
---

::: tldr
Eine Reihe von Objekten möchte über Änderungen in einem anderen ("zentralen") Objekt
informiert werden. Dazu könnte das "zentrale" Objekt eine Zugriffsmethode anbieten,
die die anderen Objekte regelmäßig aufrufen ("pollen").

Mit dem Observer-Pattern kann man das aktive Polling vermeiden und in ein
Push-Modell umbauen. Die interessierten Objekte "registrieren" sich beim "zentralen"
Objekt. Sobald dieses eine Änderung erfährt oder Informationen bereitstehen o.ä.,
wird das "zentrale" Objekt alle registrierten Objekte durch den Aufruf einer Methode
benachrichtigen. Dafür müssen die registrierten Objekte eine gemeinsame
Schnittstelle implementieren.

Das "zentrale" Objekt, welches abgefragt wird, nennt man "*Observable*" (oder
manchmal auch "*Subject*"). Die Objekte, die die Information abfragen möchten, nennt
man "*Observer*" (oder gelegentlich auch "*Client*").

\bigskip

| Aspekt | Polling (Pull) | Observer (Push) |
|-------------------|--------------------------------|----------------------------------|
| Wer startet den Kontakt? | Client (z.B. `Student`) fragt aktiv nach | Subject (z.B. `LSF`) meldet sich von sich aus |
| Häufigkeit | Regelmäßig, auch wenn sich nichts ändert | Nur, wenn sich der Zustand wirklich ändert |
| Kosten | Viele unnötige Anfragen | Nur relevante Benachrichtigungen |
| Kopplung | Alle kennen die konkrete(n) Abfragemethode(n) | Alle kennen nur das gemeinsame `Observer`-Interface |
:::

::: youtube
Vorlesung \[[YT](https://youtu.be/CJ_1WkBdhRQ)\],
\[[HSBI](https://www.hsbi.de/medienportal/video/pr2-observer-pattern/b333050d82fd710c6d38d0662911c04b)\]
:::

# Gedankenexperiment: Verteilung der Prüfungsergebnisse

![](images/lsf.png){width="80%"}

::: notes
Die Studierenden möchten nach einer Prüfung wissen, ob für einen bestimmten Kurs
die/ihre Prüfungsergebnisse im LSF bereit stehen.

Dazu modelliert man eine Klasse `LSF` und implementiert eine Abfragemethode, die
dann alle interessierten Objekte regelmäßig aufrufen können. Dies sieht dann
praktisch etwa so aus:

``` java
List<Person> persons = List.of(new Lecturer("Frau Holle"),
                               new Student("Heinz"),
                               new Student("Karla"),
                               new Tutor("Kolja"),
                               new Student("Wuppie"));
LSF lsf = new LSF();

for (Person p : persons) {
    lsf.getGradings(p, "My Module");   // polling
}
```

Eigentlich müsste man diese Abfrage natürlich **regelmäßig** machen, z.B. jede
Minute:

``` java
while (true) {
    for (Person p : persons) {
        lsf.getGradings(p, "My Module");
    }

    Thread.sleep(60_000); // jede Minute nachschauen
}
```

**Problem**:

-   Alle fragen ständig aktiv nach, ob sich etwas geändert hat ("Polling").
-   Meistens gibt es **nichts Neues**, trotzdem werden immer wieder Methoden
    aufgerufen.
-   Das kostet Zeit/Ressourcen!
-   Das gezeigte Vorgehen koppelt zudem alle Objekte (hier Personen) direkt an die
    konkrete Abfragemethode von `LSF`.
:::

# Elegantere Lösung: Observer-Entwurfsmuster

![](images/observerexample.png){width="80%"}

::: notes
Sie erstellen im `LSF` eine Methode `register()`, mit der sich interessierte
Personen beim `LSF` registrieren können.

Zur Benachrichtigung der Personen (registrierte Objekte) brauchen diese eine
geeignete Methode, die traditionell `update()` benannt wird.

Der typische Ablauf sieht dann so aus:

1.  Interessierte Objekte (z.B. `Student`, `Lecturer`) implementieren eine Methode
    `update(...)`.
2.  Diese Objekte rufen einmalig `lsf.register(this)` auf, um sich anzumelden.
3.  Wenn sich im `LSF` etwas ändert (z.B. neue Noten verfügbar sind), ruft `LSF`
    **von sich aus** seine interne Methode `notifyObservers()` auf.
4.  `notifyObservers()` ruft dann auf allen registrierten Objekten deren
    `update(...)`-Methode auf.
:::

[Demo: observer]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/pattern/src/observer/"}

# Observer-Pattern verallgemeinert

![](images/observer.png){width="80%"}

::::::: notes
Im vorigen Beispiel wurde die Methode `update()` einfach der gemeinsamen Basisklasse
`Person` hinzugefügt. Normalerweise möchte man die Aspekte `Person` und `Observer`
aber sauber trennen und definiert sich dazu ein *separates* Interface `Observer` mit
der Methode `update()`, die dann alle "interessierten" Klassen (zusätzlich zur
bestehenden Vererbungshierarchie) implementieren.

Ein mögliches, sehr einfaches Java-Skelett für unser LSF-/Student-Beispiel sähe
entsprechend folgendermaßen aus:

``` java
public interface Observer {
    void update();
}

public class LSF {
    private List<Observer> observers = new ArrayList<>();

    public void register(Observer o) {
        observers.add(o);
    }

    public void unregister(Observer o) {
        observers.remove(o);
    }

    void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void neueNotenSindDa() {
        // ... interne Logik ...
        notifyObservers(); // alle angemeldeten Observer benachrichtigen
    }
}

public class Student extends Person implements Observer {
    @Override
    public void update() {
        System.out.println("Student: Ich schaue mir die neuen Noten an.");
    }
}
```

Die Klasse für das zu beobachtende Objekt benötigt dann eine Methode `register()`,
mit der sich Observer registrieren können. Die Objektreferenzen werden dabei einfach
einer geeigneten internen Sammlung hinzugefügt.

Häufig findet sich dann noch eine Methode `unregister()`, mit der sich bereits
registrierte Beobachter wieder abmelden können. Weiterhin findet man häufig eine
Methode `notifyObservers()`, die man von außen auf dem beobachteten Objekt aufrufen
kann und die dann auf allen registrierten Beobachtern deren Methoden `update()`
aufruft. (Dieser Vorgang kann aber auch durch eine sonstige Zustandsänderung im
beobachteten Objekt durchgeführt werden.)

Der typische Lebenszyklus eines Observers sieht also so aus:

1.  Observer-Objekt wird erzeugt (z.B. `new Student()`).
2.  Das Observer-Objekt registriert sich einmalig beim Observable (z.B. beim
    `LSF lsf` per `lsf.register(student)`).
3.  Das Observable ändert irgendwann seinen Zustand (z.B. neue Noten).
4.  Das Observable ruft intern `notifyObservers()` auf.
5.  `notifyObservers()` ruft bei allen registrierten Observern `update(...)` auf.

\bigskip

::: tip
**Hinweis**: Im obigen Beispiel wurde für die Observer eine Liste verwendet:
`List<Observer> observers`. Je nach Anwendungsfall kann das aber auch eine andere
Datenstruktur sein - beispielsweise könnte man mit einer Menge (`Set`) vermeiden,
dass sich Observer mehrfach registrieren können. Der verwendete Datentyp hängt nicht
am Observer-Pattern!
:::

::: important
**Wichtig**: In der Standarddefinition des Observer-Patterns nach [@Gamma2011]
werden beim Aufruf der Methode `update()` **keine Werte** an die Observer
mitgegeben. Jeder Observer muss sich entsprechend eine eigene Referenz auf das
beobachtete Objekt halten, um von dort dann weitere Informationen erhalten zu
können.

Wir nutzen im Rahmen dieses Moduls in der Regel eine **praktischere Variante**, bei
der `update()` einen oder mehrere Parameter mitbekommt, z.B. eine Referenz auf das
`Observable` oder (meist besser) direkt die relevanten Daten. Ein angepasstes
Interface könnte z.B. so aussehen:

``` java
public interface Observer {
    void update(LSF source);
}
```

Oder noch besser:

``` java
public interface Observer {
    void update(Gradings neueNoten);
}
```

Mit der zweiten Variante werden die relevanten Daten direkt an den Observer
mitgegeben und diese sparen sich dadurch die entsprechende Nachfrage beim
Observable.

Dies muss dann natürlich im `Observer`-Interface nachgezogen werden.
:::

::: caution
Die typische Implementierung von `notifyObservers` sieht ungefähr so aus:

``` java
void notifyObservers() {
    for (Observer o : observers) {
        o.update();
    }
}
```

Für jeden Observer wird die Methode `update()` aufgerufen (ob nun mit oder ohne
Argumente). Damit geht der Kontrollfluss an den jeweiligen Observer und dessen
Implementation von `update()` über und kehrt erst hier in die Schleife zurück, wenn
`update()` im aktuellen Observer fertig ist. Das setzt voraus, dass sich alle
Observer vernünftig verhalten!
:::

::: tip
**Hinweis**: Es gibt in der Java-Standardbibliothek (`java.util`) bereits die
Klassen `Observer` und `Observable`, die aber als "deprecated" gekennzeichnet sind.
Sinnvollerweise nutzen Sie nicht diese vorgegebene Variante, sondern implementieren
Ihre eigenen Interfaces/Klassen, wenn Sie das Observer-Pattern einsetzen wollen!
:::
:::::::

# Wrap-Up

Observer-Pattern: Benachrichtige registrierte Objekte über Statusänderungen

\bigskip

-   Interface `Observer` mit Methode `update()`
-   Interessierte Objekte als "Beobachter":
    1.  implementieren das Interface `Observer`
    2.  registrieren sich beim beobachteten Objekt (`Observable` / `Subject`)
-   Beobachtetes Objekt ruft auf allen registrierten Objekten `update()` auf
-   `update()` kann auch Parameter haben (z.B. Quelle oder neue Daten)

::: readings
Auch wenn es für C++ geschrieben ist, lässt sich zum Thema Observer-Pattern das
Kapitel 4 "Observer" im @Nystrom2014 sehr gut lesen. Der Verweis auf @Gamma2011 der
["Gang of Four"](https://en.wikipedia.org/wiki/Design_Patterns) darf natürlich nicht
fehlen.
:::

::: outcomes
-   k2: Ich kenne den Aufbau des Observer-Patterns und kann dies an einem Beispiel
    erklären
-   k3: Ich kann das Observer-Pattern auf konkrete Beispiele (etwa den PM-Dungeon)
    anwenden
:::

::: challenges
**Observer: Restaurant**

Stellen Sie sich ein Restaurant vor, in welchem man nicht eine komplette Mahlzeit
bestellt, sondern aus einzelnen Komponenten auswählen kann. Die Kunden bestellen
also die gewünschten Komponenten, suchen sich einen Tisch und warten auf die
Fertigstellung ihrer Bestellung. Da die Küche leider nur sehr klein ist, werden
immer alle Bestellungen einer bestimmten Komponente zusammen bearbeitet - also
beispielsweise werden alle bestellten Salate angerichtet oder die alle bestellten
Pommes-Portionen zubereitet. Sobald eine solche Komponente fertig ist, werden alle
Kunden aufgerufen, die diese Komponente bestellt haben ...

Modellieren Sie dies in Java. Nutzen Sie dazu das Observer-Pattern, welches Sie ggf.
leicht anpassen müssen.

*Tipp*: Überlegen Sie, ob das Restaurant für **jede Komponente** eine eigene Liste
von Observer (Kunden) führen sollte oder ob eine gemeinsame Liste mit zusätzlicher
Information zur Komponente genügt.

<!--
-   Typ für Komponenten (Enum reicht)
-   Kunden als Observer (`update`-Methode)
-   Restaurant als Observable (`register`-Methode)
-   Kunden registrieren sich, aber jeweils für eine bestimmte Komponente
    (die Registrierung passiert also mehrfach pro Kunde, aber nur einmal pro Komponente):
    -   (a) Je Komponente eine eigene `registerXYZ()`-Methode im Restaurant
    -   (b) Eine gemeinsame `register()`-Methode, die zusätzlich eine Komponente mit aufnimmt
-   Das `update()` im Kunden ist dann analog mit Parameter (Komponente) oder es gibt pro
    Komponente eine eigene `update`-Methode
-->

**Observer: Einzel- und Großhandel**

In den
[Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/pattern/src/challenges/observer)
finden Sie ein Modell für eine Lieferkette zwischen Großhandel und Einzelhandel.

Wenn beim Einzelhändler eine Bestellung von einem Kunden eingeht
(`Einzelhandel#bestellen`), speichert dieser den `Auftrag` zunächst in einer Liste
ab. In regelmäßigen Abständen (`Einzelhandel#loop`) sendet der Einzelhändler die
offenen Bestellungen an seinen Großhändler (`Grosshandel#bestellen`). Hat der
Großhändler die benötigte Ware vorrätig, sendet er diese an den Einzelhändler
(`Einzelhandel#empfangen`). Dieser kann dann den Auftrag gegenüber seinem Kunden
erfüllen (keine Methode vorgesehen).

Anders als der Einzelhandel speichert der Großhandel keine Aufträge ab. Ist die
benötigte Ware bei einer Bestellung also nicht oder nicht in ausreichender Zahl auf
Lager, wird diese nicht geliefert und der Einzelhandel muss (später) eine neue
Bestellung aufgeben.

Der Großhandel bekommt regelmäßig (`Grosshandel#loop`) neue Ware für die am
wenigsten vorrätigen Positionen.

Im aktuellen Modell wird der Einzelhandel nicht über den neuen Lagerbestand des
Großhändlers informiert und kann daher nur "zufällig" neue Bestellanfragen an den
Großhändler senden.

Verbessern Sie das Modell, indem Sie das Observer-Pattern integrieren.

-   Wer ist Observer?
-   Wer ist Observable?
-   Welche Informationen werden bei einem `update` mitgeliefert?

*Tipp*: Überlegen Sie zuerst, **wo** der "interessante" Zustand liegt (z.B.
Lagerbestand) und **wer** an Änderungen dieses Zustands interessiert ist.

Bauen Sie in alle Aktionen vom Einzelhändler und vom Großhändler passendes Logging
ein.

*Anmerkung*: Sie dürfen nur die Vorgaben-Klassen `Einzelhandel` und `Grosshandel`
verändern, die anderen Vorgaben-Klassen dürfen Sie nicht bearbeiten. Sie können
zusätzlich benötigte eigene Klassen/Interfaces implementieren.
:::
