---
title: "Serialisierung von Objekten und Zuständen"
author: "Carsten Gips (HSBI)"
readings:
  - key: "Java-SE-Tutorial"
    comment: "Essential Java Classes > Basic I/O > Object Streams"
tldr: |
  Objekte lassen sich mit der Methode `void writeObject(Object)` in `ObjectOutputStream`
  einfach in einen Datenstrom schreiben. Dies kann beispielsweise eine Datei o.ä. sein.
  Mit Hilfe von `Object readObject()` in `ObjectInputStream` lassen sich Objekte aus dem
  Datenstrom auch wieder herstellen. Dies nennt man Serialisierung und De-Serialisierung.

  Um Objekte einer Klasse serialisieren zu können, muss diese das leere Interface
  `Serializable` implementieren ("Marker-Interface"). Damit wird quasi die Unterstützung
  in `Object*Stream` freigeschaltet.

  Wenn ein Objekt serialisiert wird, werden alle Attribute in den Datenstrom geschrieben,
  d.h. die Typen der Attribute müssen ihrerseits serialisierbar sein. Dies gilt für alle
  primitiven Typen und die meisten eingebauten Typen. Die Serialisierung erfolgt ggf.
  rekursiv, Zirkelreferenzen werden erkannt und aufgebrochen.

  `static` und `transient` Attribute werden nicht serialisiert.

  Beim De-Serialisieren wird das neue Objekt von der Laufzeitumgebung aus dem Datenstrom
  rekonstruiert. Dies geschieht direkt, es wird kein Konstruktor involviert.

  Beim Serialisieren wird für die Klasse des zu schreibenden Objekts eine `serialVersionUID`
  berechnet und mit gespeichert. Beim Einlesen wird dann geprüft, ob die serialisierten
  Daten zur aktuellen Version der Klasse passen. Da dies relativ empfindlich gegenüber
  Änderungen an einer Klasse ist, wird empfohlen, selbst eine `serialVersionUID` pro
  Klasse zu definieren.
outcomes:
  - k2: "Was ist ein Marker-Interface und warum ist dies eine der großen Design-Sünden in Java?"
  - k2: "Erklären Sie den Prozess der Serialisierung und De-Serialisierung. Worauf müssen Sie achten?"
  - k3: "Serialisierung von Objekten und Programmzuständen"
  - k3: "Serialisierung eigener Klassen und Typen"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106519&client_id=FH-Bielefeld"
    name: "Quiz Serialisierung (ILIAS)"
youtube:
  - link: "https://youtu.be/wnwCMtKpXAQ"
    name: "VL Serialisierung"
  - link: "https://youtu.be/zpWLPIRPTeQ"
    name: "Demo Serialisierung"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/ab8df96555932244456b9ac3dc332fbe39c09029605959af2eea790b5bd5966c5212c9c0184700d6e3785b7af8bdc03e3e6b948bad9392fa01e79309677df68a"
    name: "VL Serialisierung"
challenges: |
    Implementieren Sie die beiden Klassen entsprechend dem UML-Diagram:

    ![](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/images/uml_serialisierung.png?raw=true)

    Objekte vom Typ `Person` sowie `Address` sollen serialisierbar sein (vgl. Vorlesung).
    Dabei soll das Passwort nicht serialisiert bzw. gespeichert werden, alle anderen
    Eigenschaften von `Person` sollen serialisierbar sein.

    _Hinweis_: Verwenden Sie zur Umsetzung [java.io.Serializable](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Serializable.html).

    Erstellen Sie in Ihrem `main()` einige Instanzen von Person und speichern Sie diese in
    serialisierter Form und laden (deserialisieren) Sie diese anschließend in neue Variablen.

    Betrachten Sie die ursprünglichen und die wieder deserialisierten Objekte mit Hilfe des
    Debuggers. Alternativ können Sie die Objekte auch in übersichtlicher Form über den Logger
    ausgeben.

    <!--
    ```java
    import java.io.Serial;
    import java.io.Serializable;

    class Address implements Serializable {
        @Serial
        private static final long serialVersionUID = 2L;
        private String street;
        private Integer number;
        private String city;
        private Integer plz;

        public Address(String street, Integer number, String city, Integer plz) {
            this.street = street;
            this.number = number;
            this.city = city;
            this.plz = plz;
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append(street);
            output.append(" ");
            output.append(number);
            output.append("\n");
            output.append(plz);
            output.append(" ");
            output.append(city);
            output.append("\n");
            return output.toString();
        }
    }


    class Person implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
        private String name;
        private Integer age;
        private String username;
        private transient String password;
        private List<Address> addressList;
        private Person friend;

        public Person(String name, Integer age, String username, String password, List<Address> addressList) {
            this.name = name;
            this.age = age;
            this.username = username;
            this.password = password;
            this.addressList = addressList;
        }

        public void setFriend(Person person) {
            this.friend = person;
        }

        public Person getFriend() {
            return this.friend;
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append("Name: ");
            output.append(name);
            output.append("\nAlter: ");
            output.append(age);
            output.append("\nNutzername: ");
            output.append(username);
            output.append("\nPasswort: ");
            output.append(password);
            output.append("\nAdress Liste: \n");
            output.append(addressList);
            return output.toString();
        }
    }


    class FileHandler<T> {

        private final String filename;

        public FileHandler(String filename) {
            this.filename = filename;
        }

        public void writeObjectToFile(T object) throws IOException {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(object);
                out.flush();
            }
        }

        public T readObjectFromFile() throws IOException, ClassNotFoundException {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
                return (T) in.readObject();
            }
        }
    }


    public class Main {
        private static final String FILENAME = "test.txt";
        private static final Logger LOGGER = Logger.getLogger("Serialisierung");


        public static void main(String... args) {
            FileHandler<Person> fileHandler = new FileHandler<>(FILENAME);
            List<Address> addressList = new ArrayList<>();
            addressList.add(new Address("Ringstraße", 52, "Minden", 32425));
            addressList.add(new Address("Stiftsallee", 36, "Minden", 32425));
            Person originPerson = new Person("Bob", 23, "PM-Bob", "123456", addressList);
            Person otherPerson = new Person("Max", 36, "PM-Max", "test123", addressList);
            originPerson.setFriend(otherPerson);
            otherPerson.setFriend(originPerson);
            Person deserializedPerson = null;

            try {
                fileHandler.writeObjectToFile(originPerson);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                deserializedPerson = fileHandler.readObjectFromFile();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            LOGGER.info("Origin:\n" + originPerson.toString());
            LOGGER.info("Origin_Friend:\n" + originPerson.getFriend().toString());
            LOGGER.info("Origin_Friend_Friend:\n" + originPerson.getFriend().getFriend().toString());
            LOGGER.info("Deserialized:\n" + deserializedPerson.toString());
            LOGGER.info("Deserialized_Friend:\n" + deserializedPerson.getFriend().toString());
            LOGGER.info("Deserialized_Friend_Friend:\n" + deserializedPerson.getFriend().getFriend().toString());
        }
    }
    ```
    -->
---


## Motivation: Persistierung von Objekten und Spielzuständen

```java
public class Studi {
    private final int credits = 42;
    private String name = "Hilde";

    ...
}
```

\bigskip

::: center
Wie kann ich Objekte speichern und wieder laden?
:::

::: notes
Ich möchte ein Spiel (einen Lauf) im Dungeon abspeichern, um es später fortsetzen
zu können. Wie kann ich den aktuellen Zustand (also Level, Monster, Held, Inventar,
XP/Health/...) so speichern, dass ich später das Spiel nach einem Neustart einfach
fortsetzen kann?
:::


## Serialisierung von Objekten

*   Klassen müssen Marker-Interface `Serializable` implementieren

    ::: notes
    "Marker-Interface": Interface ohne Methoden. Ändert das Verhalten
    des Compilers, wenn eine Klasse dieses Interface implementiert:
    Weitere Funktionen werden "freigeschaltet", beispielsweise die
    Fähigkeit, Klone zu erstellen (`Cloneable`) oder bei `Serializable`
    Objekte serialisierbar zu machen.

    Das ist in meinen Augen eine "Design-Sünde" in Java (neben der
    Einführung von `null`): Normalerweise definieren Interfaces eine
    Schnittstelle, die eine das Interface implementierende Klasse
    dann erfüllen muss. Damit agiert das Interface wie ein Typ. Hier
    ist das Interface aber leer, es wird also keine Schnittstelle
    definiert. Aber es werden damit stattdessen Tooling-Optionen
    aktiviert, was Interfaces vom Konzept her eigentlich nicht machen
    sollten/dürften - dazu gibt es Annotationen!
    :::

*   Schreiben von Objekten (samt Zustand) in Streams

    ```java
    ObjectOutputStream: void writeObject(Object)
    ```

    ::: notes
    Die Serialisierung erfolgt dabei für alle Attribute
    (außer `static` und `transient`, s.u.) rekursiv.

    Dabei werden auch Zirkelreferenzen automatisch
    aufgelöst/unterbrochen.
    :::

*   Lesen und "Wiedererwecken" der Objekte aus Streams

    ```java
    ObjectInputStream: Object readObject()
    ```

    ::: notes
    Dabei erfolgt KEIN Konstruktor-Aufruf!
    :::


## Einfaches Beispiel

```{.java size="footnotesize"}
public class Studi implements Serializable {
    private final int credits = 42;
    private String name = "Hilde";

    public static void writeObject(Studi studi, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(studi);    oos.close();
        } catch (IOException ex) {}
    }

    public static Studi readObject(String filename) {
        Studi studi = null;
        try (FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            studi = (Studi) ois.readObject();    ois.close();
        } catch (IOException | ClassNotFoundException ex) {}
        return studi;
    }
}
```


## Bedingungen für Objekt-Serialisierung

*   Klassen implementieren Marker-Interface `Serializable`
*   Alle Attribute müssen ebenfalls serialisierbar sein (oder Deklaration "`transient`")
*   Alle primitiven Typen sind per Default serialisierbar
*   Es wird automatisch rekursiv serialisiert, aber jedes Objekt
    nur einmal (bei Mehrfachreferenzierung)
*   Serialisierbarkeit vererbt sich


## Ausnahmen

*   Als `static` deklarierte Attribute werden nicht serialisiert
*   Als `transient` deklarierte Attribute werden nicht serialisiert
*   Nicht serialisierbare Attribut-Typen führen zu `NotSerializableException`


## Version-UID

```java
static final long serialVersionUID = 42L;
```

\bigskip

*   Dient zum Vergleich der serialisierten Version und der aktuellen Klasse
*   Über IDE generieren oder manuell vergeben
*   Wenn das Attribut fehlt, wird eine Art Checksumme von der Runtime-Umgebung
    berechnet (basierend auf diversen Eigenschaften der Klasse)

::: notes
Dieser Wert wird beim Einlesen verglichen: Das Objekt wird nur dann wieder de-serialisiert,
wenn die `serialVersionUID` mit der einzulesenden Klasse übereinstimmt!

Bei automatischer Berechnung der `serialVersionUID` durch die JVM kann jede kleine Änderung an
der Klasse (beispielsweise Refactoring: Änderung der Methodennamen) eine neue `serialVersionUID`
zur Folge haben. Das würde bedeuten, dass bereits serialisierte Objekte nicht mehr eingelesen
werden können, auch wenn sich nur Methoden o.ä. verändert haben und die Attribute noch so vorhanden
sind. Deshalb bietet es sich an, hier selbst eine `serialVersionUID` zu definieren - dann muss
man aber auch selbst darauf achten, diese zu verändern, wenn sich wesentliche strukturelle
Änderungen an der Klasse ergeben!
:::


::: notes
## Bemerkungen

Es existieren diverse weitere Fallstricke und Probleme, siehe [@Bloch2018] Kapitel 11 "Serialization".

Man kann in den `ObjectOutputStream` nicht nur ein Objekt schreiben, sondern mehrere Objekte und
Variablen schreiben lassen. In dieser Reihenfolge muss man diese dann aber auch wieder aus dem
Stream herauslesen (vgl. [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html)).

Man kann die zu serialisierenden Attribute mit der Annotation `@Serial` markieren. Dies ist in
der Wirkung ähnlich zu `@Override`: Der Compiler prüft dann, ob die markierten Attribute wirklich
serialisierbar sind und würde sonst zur Compile-Zeit einen Fehler werfen.

Weitere Links:

*   Tutorials:
    *   https://docs.oracle.com/en/java/javase/17/docs/specs/serialization/input.html
    *   https://www.baeldung.com/java-serialization
*   API:
    *   https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutputStream.html
    *   https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInputStream.html
    *   https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html
:::

[Demo: serial.SerializableStudi]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/serial/SerializableStudi.java"}


## Wrap-Up

*   Markerinterface `Serializable` schaltet Serialisierbarkeit frei

\smallskip

*   Objekte schreiben: `ObjectOutputStream`:  `void writeObject(Object)`
*   Objekte lesen: `ObjectInputStream`: `Object readObject()`

\smallskip

*   Wichtigste Eigenschaften:
    *   Attribute müssen serialisierbar sein
    *   `transient` und `static` Attribute werden nicht serialisiert
    *   De-Serialisierung: KEIN Konstruktor-Aufruf!
    *   Serialisierbarkeit vererbt sich
    *   Objekt-Referenz-Graph wird automatisch beachtet







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
