---
type: lecture-cg
title: "Mocking mit Mockito"
menuTitle: "Mocking"
author: "Carsten Gips (FH Bielefeld)"
weight: 4
readings:
  - key: "Mockito"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
    name: "Quiz Mocking (ILIAS)"
assignments:
  - topic: sheet05
youtube:
  - link: ""
    name: "VL Mocking"
  - link: ""
    name: "Demo Mocking"
fhmedia:
  - link: ""
    name: "VL Mocking"
---


## Motivation: Entwicklung einer Studi-Prüfungsverwaltung

::: notes
Zwei Teams entwickeln eine neue Studi-Prüfungsverwaltung für die Hochschule. Ein Team modelliert dabei
die Studierenden, ein anderes Team modelliert die Prüfungsverwaltung LSF.
:::

*   Team A:

    ```{.java size="scriptsize"}
    public class Studi {
        String name;  LSF lsf;

        public Studi(String name, LSF lsf) {
            this.name = name;  this.lsf = lsf;
        }

        public boolean anmelden(String modul) { return lsf.anmelden(name, modul); }
        public boolean einsicht(String modul) { return lsf.ergebnis(name, modul) > 50; }
    }
    ```

*   Team B:

    ```{.java size="scriptsize"}
    public class LSF {
        public boolean anmelden(String name, String modul) { throw new UnsupportedOperationException(); }
        public int ergebnis(String name, String modul) { throw new UnsupportedOperationException(); }
    }
    ```

\bigskip

::: notes
Team B kommt nicht so recht vorwärts, Team A ist fertig und will schon testen.
:::

Wie kann Team A seinen Code testen?

::: notes
**Optionen**:

*   Gar nicht testen?!
*   Das LSF selbst implementieren? Wer pflegt das dann? => manuell implementierte Stubs
*   Das LSF durch einen Mock ersetzen => Einsatz der Bibliothek "mockito"
:::


## Manuell Stubs implementieren

::: notes
Team A könnte manuell das LSF rudimentär implementieren (nur für die Tests): **Stubs**

**Definition**: "Stubs": TODO
:::

```{.java size="footnotesize"}
public class StudiStubTest {
    Studi studi;  LSF lsf;

    @Before
    public void setUp() { lsf = new LsfStub();  studi = new Studi("Harald", lsf); }

    @Test
    public void testAnmelden() { assertTrue(studi.anmelden("PM-Dungeon")); }
    @Test
    public void testEinsicht() { assertTrue(studi.einsicht("PM-Dungeon")); }


    // Stub für das noch nicht fertige LSF
    class LsfStub extends LSF {
        public boolean anmelden(String name, String modul) { return true; }
        public int ergebnis(String name, String modul) { return 80; }
    }
}
```

::: notes
**Problem**: Wartung der Tests (wenn das richtige LSF fertig ist) und Wartung der Stubs (wenn sich die Schnittstelle
des LSF ändert, muss auch der Stub nachgezogen werden).

**Problem**: Der Stub hat nur eine Art minimale Default-Logik (sonst könnte man ja das LSF gleich selbst implementieren).
Wenn man im Test andere Antworten braucht, müsste man einen weiteren Stub anlegen ...
:::

[Demo [fhb.StudiStubTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/testing/src/mockito/src/test/java/fhb/StudiStubTest.java)]{.bsp}


## Mockito: Mocking von ganzen Klassen

::: notes
**Lösung**: Mocking der Klasse `LSF` mit Mockito für den Test von `Studi`: `mock()`.

**Definition**: "Mock": TODO
:::

```{.java size="scriptsize"}
public class StudiMockTest {
    Studi studi;  LSF lsf;

    @Before
    public void setUp() {
        lsf = mock(LSF.class);  studi = new Studi("Harald", lsf);
    }

    @Test
    public void testAnmelden() {
        when(lsf.anmelden(anyString(), anyString())).thenReturn(true);
        assertTrue(studi.anmelden("PM-Dungeon"));
    }

    @Test
    public void testEinsichtI() {
        when(lsf.ergebnis("Harald", "PM-Dungeon")).thenReturn(80);
        assertTrue(studi.einsicht("PM-Dungeon"));
    }

    @Test
    public void testEinsichtII() {
        when(lsf.ergebnis("Harald", "PM-Dungeon")).thenReturn(40);
        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
```

::: notes
Erklärung der Elemente: TODO
`when().thenReturn()` => `when(mock.methode()).thenReturn(wert)`
:::

[Demo [fhb.StudiMockTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/testing/src/mockito/src/test/java/fhb/StudiMockTest.java)]{.bsp}


## Mockito: Spy = Wrapper um ein Objekt

::: notes
Team B hat das `LSF` nun implementiert und Team A kann es endlich für die Tests benutzen. Aber
das `LSF` hat eine Zufallskomponente (`ergebnis()`). Wie kann man nun die Reaktion des Studis
testen (`einsicht()`)?

**Lösung**: Mockito-Spy als partieller Mock einer Klasse (Wrapper um ein Objekt): `spy()`.

**Definition**: "Spy": TODO
:::

```{.java size="scriptsize"}
public class StudiSpyTest {
    Studi studi;  LSF lsf;

    @Before
    public void setUp() {
        lsf = spy(LSF.class);  studi = new Studi("Harald", lsf);
    }

    @Test
    public void testAnmelden() { assertTrue(studi.anmelden("PM-Dungeon")); }

    @Test
    public void testEinsichtI() {
        doReturn(80).when(lsf).ergebnis("Harald", "PM-Dungeon");
        assertTrue(studi.einsicht("PM-Dungeon"));
    }

    @Test
    public void testEinsichtII() {
        doReturn(40).when(lsf).ergebnis("Harald", "PM-Dungeon");
        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
```

::: notes
Erklärung der Elemente: TODO
`doReturn().when()` => `doReturn(wert).when(spy).methode()`
:::

[Demo [fhb.StudiSpyTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/testing/src/mockito/src/test/java/fhb/StudiSpyTest.java)]{.bsp}


## Wurde eine Methode aufgerufen?

```{.java size="scriptsize"}
public class VerifyTest {
    @Test
    public void testAnmelden() {
        LSF lsf = mock(LSF.class);
        Studi studi = new Studi("Harald", lsf);

        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

        assertTrue(studi.anmelden("PM-Dungeon"));

        verify(lsf).anmelden("Harald", "PM-Dungeon");

        verify(lsf, times(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, atLeast(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, atMost(1)).anmelden("Harald", "PM-Dungeon");

        verify(lsf, never()).ergebnis("Harald", "PM-Dungeon");

        verifyNoMoreInteractions(lsf);
    }
}
```

::: notes
Erklärung der Elemente: TODO
:::

[Demo [fhb.VerifyTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/testing/src/mockito/src/test/java/fhb/VerifyTest.java)]{.bsp}


## Fangen von Argumenten

```{.java size="scriptsize"}
public class MatcherTest {
    @Test
    public void testAnmelden() {
        LSF lsf = mock(LSF.class);
        Studi studi = new Studi("Harald", lsf);

        when(lsf.anmelden(anyString(), anyString())).thenReturn(false);
        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

        assertTrue(studi.anmelden("PM-Dungeon"));
        assertFalse(studi.anmelden("Wuppie?"));

        verify(lsf, times(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, times(1)).anmelden("Harald", "Wuppie?");

        verify(lsf, times(2)).anmelden(anyString(), anyString());
        verify(lsf, times(2)).anmelden(argThat(new MyHaraldMatcher()), anyString());
    }


    class MyHaraldMatcher implements ArgumentMatcher<String> {
        public boolean matches(String s) { return s.equals("Harald"); }
    }
}
```

::: notes
Erklärung der Elemente: TODO
:::

[Demo [fhb.MatcherTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/testing/src/mockito/src/test/java/fhb/MatcherTest.java)]{.bsp}


## Ausblick: PowerMock

Mockito sehr mächtig, aber unterstützt (u.a.) keine

*   Konstruktoren
*   private Methoden
*   final Methoden
*   static Methoden

\bigskip
\bigskip

=> Lösung: [PowerMock](https://github.com/powermock/powermock)







## Motivation

Mockito ist ein Mocking-Framework. Es simuliert das Verhalten eines realen
Objektes oder einer realen Methode.

Wofür brauchen wir denn jetzt so ein Mocking-Framework überhaupt?

Wir wollen die Funktionalität einer Klasse isoliert vom Rest testen können.
Dabei stören uns aber bisher so ein paar Dinge:

* Arbeiten mit den echten Objekten ist langsam. (zum Beispiel aufgrund von
  Datenbankenzugriffen)
* Objekte beinhalten oft komplexe Abhängigkeiten die in Tests schwer abzudecken
  sind.
* Manchmal existiert der zu testende Teil einer Applikation auch noch gar nicht,
  sondern es gibt nur die Interfaces.
* Oder es gibt unschöne Seiteneffekte beim Arbeiten mit den realen Objekten. Zum
  Beispiel könnte es sein, das immer eine E-Mail versendet wird, wenn wir mit
  einem Objekt interagieren.

In solchen Situationen wollen wir eine Möglichkeit haben das Verhalten eines
realen Objektes bzw. der Methoden zu simulieren möglichst ohne dabei die
originalen Methoden aufrufen zu müssen. (Manchmal möchte man das dennoch aber
dazu später mehr...)

Und genau hier kommt Mockito ins Spiel. Mockito hilft uns dabei uns von den
externen Abhängigkeiten zu lösen in dem es sogenannte Mocks, Stubs oder Spies
anbietet mit denen sich das Verhalten der realen Objekte simulieren/überwachen
und testen lässt.
Quelle: [Understanding mockito](https://medium.com/@ashrawan70/understanding-the-mockito-74cd7e5a77e4)

## Einführung

Mocking und das sogenannte stubbing sind die beiden Eckpfeiler zum Erstellen von
schnellen und einfachen JUnittests.

Mocks sind in JUnittests immer dann nützlich, wenn man externe Abhängigkeiten
hat, auf die der eigene Code zugreift. Das können zum Beispiel externe APIs sein
oder Datenbanken etc. Mocks helfen einem beim Testen nun dabei sich von diesen
externen Abhängigkeiten zu lösen und seine Softwarefunktionalität dennoch
schnell und effizient testen zu können ohne evtl. auftretende Verbindungsfehler
oder andere mögliche Seiteneffekte der externen Abhängigkeiten auszulösen.

Dabei simulieren Mocks die Funktionalität der externen APIs oder
Datenbankzugriffe. Auf diese Weise ist es möglich Softwaretests zu schreiben die
scheinbar die gleichen Methoden aufrufen, die sie auch im regulären
Softwarebetrieb nutzen würden, diese werden wie oben erwähnt allerdings für die
Tests nur simuliert.

Mocks stellen so, im Vergleich zu den umfangreichen Integrationstests, eine
schnelle und effiziente Testbarkeit dar.

**_Anmerkung_**: Ein Test der Daten in eine Datenbank schreibt oder von dieser
Daten einliest oder ein Test der eine JSON-Datei von einem Webservice oder
ähnlichem bezieht ist _kein_ Unittest. Siehe: [Teststufen VL:
testing-intro](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/testing/testing-intro.md#was-wann-testen-wichtigste-teststufen)

Er wird erst dann zu einem Unittest, wenn man diese externen Zugriffe weg mockt.

Mockito ist dabei ein sehr beliebtes, häufig in der Praxis anzutreffendes,
Mocking-Framework das einem bei der Erstellung von diesen Tests behilflich ist.

Quelle:

* [Stubbing-and-mocking-with-mockito](https://semaphoreci.com/community/tutorials/stubbing-and-mocking-with-mockito-2-and-junit)
* [Methods-of-mockito](https://www.javatpoint.com/methods-of-mockito)

## Aber was genau ist denn jetzt eigentlich Mocking?

Mocking ist ein Prozess zum Erzeugen von Objekten die ein Mock/Klon der realen
Objekte sind. Dabei bezeichnet Mocking eine Technik, die in Softwaretests
verwendet wird, in denen die gemockten Objekte anstatt der realen Objekte zu
Testzwecken genutzt werden. Die gemockten Objekte liefern dabei bei einem vom
Programmierer bestimmten (Dummy) Input, einen dazu passenden gelieferten (Dummy)
Output der durch seine vorhersagbare Funktionalität gut testbar ist.

Um das ganze Konzept des Mockens etwas besser verstehen zu können ist es
hilfreich vielleicht ein Paar weitere Begrifflichkeiten vorab zu klären auf die
wir in der Vorlesung stoßen werden.

Dabei ist es von Vorteil die drei Grundbegriffe Mock, Stub oder Spy, auf die wir
in der Vorlesung noch häufiger treffen werden, voneinander abgrenzen und
unterscheiden zu können.

## Dabei bezeichnet ein

* **Mock**: Eine Art Dummy oder Klon eines Objekts, das man mit Mockito anlegen
  kann und das dann in den Softwaretests anstelle, des realen Objekts in der
  Applikation genutzt wird. Diese Mocks werden von den Mocking-Frameworks
  erzeugt und, in den darauf aufbauenden Softwaretests, typischerweise für die
  sogenannte Verhaltensverifikation, auch "Behavior testing" genannt, genutzt.
* **Stub**: Sind Objekte die vordefinierte Werte enthalten, die in den
  Softwaretests abgefragt werden können. Des Weiteren enthalten Stubs nur ein
  absolutes Minimum an Methoden, die für den jeweiligen Test benötigten werden.
  Zudem können sie auch Methoden enthalten, die einem den Zugriff auf den
  internen Zustand eines Stubs gewähren, wenn dies nötigt ist. Man könnte
  eigentlich auch sagen das Stubs in den Tests generell zum verifizieren eines
  Zustandes genutzt werden.
* **Spy**: Ein Spy ist in Mockito eine Art Wrapper, der um ein Objekt gelegt
  wird. Dabei werden dann sämtliche Methodenaufrufe die eigentlich sonst von den
  realen Methoden eines Objekts ausgeführt worden wären an den Spion delegiert,
  der diese dann protokollieren, den State verändern und/oder eventuelle, von
  den Methoden getätigten Ausgaben kontrolliert verändern kann.

## Mockito Setup

Gradle: `build.gradle`

* ```java
    dependencies {
        testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
        testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
        testImplementation "org.mockito:mockito-core:3.+"
    }
  ```

Maven: `pom.xml`

* ```xml
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>4.5.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
  ```

## Folie 2

| Parameter         | Mock                                                                                                                                                    | Stub                                                                                           | Spy                                                                                                                                |
| ------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------ |
| Datenquelle       | Daten der Mocks werden in den Tests definiert                                                                                                           | Daten in Stubs sind hart codiert. Sie sind normalerweise eng mit der Testsuite verbunden.      | Spies sind partielle/halb gemockte Objekte. Spies werden ebenso wie Mocks in großen Testsuiten verwendet.                         |
| Erstellt von      | Werden normalerweise bei der Verwendung eines Mocking-Frameworks erstellt.                                                                              | Werden normalerweise von Hand kreiert                                                          | Werden normalerweise bei der Verwendung eines Mocking-Frameworks erstellt.                                                         |
| Verwendung        | Mocks werden meistens in großen Testsuiten verwendet. Mocks werden zum Erstellen eines kompletten Mocks oder eines Dummy Objekts verwendet.            | Stubs werden meistens in kleinen/überschaubaren Testsuiten verwendet.                         | Spies werden verwendet um partielle oder halb gemockte Objekte zu erzeugen. Spies werden meistens in großen Testsuiten verwendet. |
| Default Verhalten | Wenn gemockte Objekte verwendet werden ist deren Default Verhalten von Methoden (wenn diese nicht stubed sind) das sie gar nichts tun. (doNothing(...)) | Beinhalten meistens nur das absolute Minimum an Methoden, die für einen Test benötigt werden. | Wenn Spies verwendet werden ist deren default Verhalten von Methoden (die nicht stubbed sind) das sie die reale Methode aufrufen.  |

Quelle: [mock-vs-stub-vs-spy](https://www.javatpoint.com/mock-vs-stub-vs-spy)

## Folie 3

[Demo: WuppiWarenlagerStubTest]{.bsp}

Bei dem gezeigten Beispiel unseres `WuppiStores` sieht man, dass dieser
normalerweise von einem fertigen Warenlager die Wuppis beziehen möchte. Da
dieses Lager aber noch nicht existiert haben wir uns kurzerhand einfach einen
Stub von unserem `IWuppiWarenlager` Interface erstellt in dem wir zu
Testzwecken, händisch ein Paar Wuppis ins Lager geräumt haben.

Das funktioniert in diesem mini Testbeispiel ganz gut aber, wenn unsere Stores
erst einmal so richtig Fahrt aufnehmen und wir irgendwann weltweit Wuppis
verkaufen wird der Code des `IWuppiWarenlagers` wahrscheinlich sehr schnell viel
komplexer werden; was unweigerlich dann zu Maintenance-Problemen unserer
händisch angelegten Tests führt. Wenn wir zum Beispiel einmal eine Methode
hinzufügen wollen, die es uns ermöglicht nicht immer alle Wuppis aus dem Lager
zu ordern oder vielleicht noch andere Methoden, die Fluppis orderbar machen,
hinzufügen, müssen wir immer dafür sorgen, dass wir die getätigten Änderungen
händisch in den Stub des Warenlagers einpflegen.

Das will eigentlich niemand...

## Folie 4

Aber es gibt da einen Ausweg. Wenn es komplexer wird, verwenden wir Mocks.

Bislang haben wir noch keinen gebrauch von Mockito gemacht. Das ändern wir nun.

[Demo: WuppiWarenlagerMockTest]{.bsp}

Wie in diesem Beispiel gezeigt müssen wir nun keinen Stub mehr von Hand
erstellen, sondern überlassen dies Mockito.

```java
    IWuppiWarenlager lager=mock(IWuppiWarenlager.class);
```

Anschließend können wir, ohne die Methode `getAllWuppis()` implementiert zu haben,
dennoch so tun als, ob die Methode eine Funktionalität hätte.

```java
    // Erstellen eines imaginären Lagerbestands.
    List<String> wuppisImLager=Arrays.asList("GruenerWuppi","RoterWuppi");
    when(lager.getAlleWuppis()).thenReturn(wuppisImLager);
```

Wann immer nun die Methode `getAlleWuppis()` des gemockten Lagers aufgerufen
wird, wird dieser Aufruf von Mockito abgefangen und wie oben definiert
verändert. Das Ergebnis können wir abschließend einfach in unserem Test wie hier
zu sehen ist testen.

```java
    // Erzeugen des WuppiStores.
    WuppiStore wuppiStore=new WuppiStore(lager);

    // Bestelle alle Wuppis aus dem gemockten Lager List<String>
    bestellteWuppis=wuppiStore.bestelleAlleWuppis(lager);

    // Hat die Bestellung geklappt?
    assertEquals(2,bestellteWuppis.size());
```

## Folie 5

Manchmal möchten wir allerdings nicht immer gleich ein ganzes Objekt mocken aber
dennoch Einfluss auf die aufgerufenen Methoden eines Objekts haben um diese
testen zu können. Vielleicht gibt es dabei ja sogar eine Möglichkeit unsere
JUnittests, mit denen wir normalerweise nur Rückgabewerte von Methoden testen
können, zusätzlich auch das Verhalten also die Interaktionen mit einem Objekt
beobachtbar zu machen. Somit wären diese Interaktionen auch testbar.

Und genau dafür bietet Mockito eine Funktion. Der sogenannte Spy.

Dieser Spion erlaubt es uns nun zusätzlich das Verhalten zu testen. Siehe
hierzu: [BDD - Behavior Driven Development](https://de.wikipedia.org/wiki/Behavior_Driven_Development)

[Demo: WuppiWarenlagerSpyTest]{.bsp}

```java
    // Spion erstellen der unser wuppiWarenlager überwacht.
    this.wuppiWarenlager=spy(WuppiWarenlager.class);
```

Hier hatten wir uns einen Spion erzeugt mit dem sich anschließend das Verhalten
verändern

```java
    when(wuppiWarenlager.getAlleWuppis()).thenReturn(Arrays.asList(new Wuppi("Wuppi007")));
```

oder der Zugriff kontrollieren/testen ließ.

```java
    verify(wuppiWarenlager).addWuppi(normalerWuppi);
    verifyNoMoreInteractions(wuppiWarenlager);
```

Die normalen Testmöglichkeiten von JUnit runden unseren Test zudem ab.

```java
    assertEquals(1,wuppiWarenlager.lager.size());
```

## Folie 6

In Mockito gibt es zahlreiche Annotationen, die uns beim Erstellen unserer Mocks
und Spies behilflich sein können. Hier ein kleiner Überblick über die
wichtigsten in Mockito verwendeten Annotation.

`@Mock` wird zum Markieren des zu mockenden Objekts verwendet.

```java
    @Mock
    WuppiWarenlager lager;
```

`@RunWith(MockitoJUnitRunner.class)` dient dazu das Debugging zu verbessern und
sorgt dafür, dass unbenutzte Stubs im Test erkannt werden. Außerdem werden
dadurch alle mit `@Mock` markierten Mocks initialisiert. _**Anmerkung**_:
Die `@RunWith`-Annotation wird immer im Zusammenspiel mit der `@Mock`-Annotation
verwendet.

```java
    @RunWith(MockitoJUnitRunner.class)
    public class ToDoBusinessMock {...}
```

`@Spy` erlaubt das Erstellen von partiell gemockten Objekten. Dabei wird eine
Art Wrapper um das zu mockende Objekt gewickelt, der dafür sorgt, dass alle
Methodenaufrufe des Objekts an den Spy delegiert werden. Diese können über den
Spion dann abgefangen/verändert oder ausgewertet werden.

```java
    @Spy
    ArrayList<Wuppi> arrayListenSpion;
```

`@InjectMocks` erlaubt es Parameter zu markieren in denen Mocks und/oder Spies
injiziert werden. Mockito versucht dann, in dieser Reihenfolge, per
Konstruktorinjektion, Setterinjektion oder Propertyinjektion die Mocks zu
injizieren. Weitere Informationen darüber findet man
hier. [Mockito Dokumentation](https://javadoc.io/static/org.mockito/mockito-core/4.5.1/org/mockito/InjectMocks.html) _**
Anmerkung**_: Es ist aber nicht ratsam "Field- oder Setterinjection" zu nutzen,
da man nur bei der Verwendung von "Constructorinjection" sicherstellen kann, das
eine Klasse nicht ohne die eigentlich notwendigen Parameter instanziiert wurde.

```java
    @InjectMocks
    Wuppi fluppi;
```

`@Captor` erlaubt es einen die Argumente einer Methode abzufangen/auszuwerten.
Im Zusammenspiel mit Mockitos `verify()`-Methode kann man somit auch die einer
Methode übergebenen Parameter verifizieren.

```java
    @Captor
    ArgumentCaptor<String> argumentCaptor;
```

`@ExtendWith(MockitoExtension.class)` wird in JUnit5 verwendet, um die
Initialisierung von Mocks zu vereinfachen. Damit entfällt zum Beispiel die noch
unter JUnit4 nötige Initialisierung der Mocks durch einen Aufruf der
Methode `MockitoAnnotations.openMocks()` im Setup des Tests
(`@Before | @BeforeEach`)

Dabei gibt es zu den hier gezeigten Annotationen meist auch einen einfachen
Methodenaufruf der die gleiche Funktionalität besitzt.

Um zum Beispiel ein Mock eines Objekts zu erstellen, kann man entweder den Mock
mit dem Methodenaufruf `mock(KlasseDesTypsDesZuMockendenObjekts.class)`
erzeugen oder mit der Annotation `@Mock` wie in diesem Beispiel gezeigt:

```java
    @Mock
    KlasseDesTypsDesZuMockendenObjekts objektname;
```

Ebenso lassen sich mit der Annotation `@Spy` zum Beispiel Spione definieren:

```java
    @Spy
    List<String> spionListe=new ArrayList<String>();
```

Selbiges könnte man aber auch wie oben angesprochen mit einem Methodenaufruf
bewerkstelligen:

```java
    List<String> list=new ArrayList<String>();
        List<String> spionListe=spy(list);
```

## Folie 7 - `verify()`

Mit Hilfe der umfangreichen `verfiy()`-Methoden die uns Mockito mitliefert können wir unseren Code unter anderem auf unerwünschte Seiteneffekte testen. So ist es mit "verify" zum Beispiel möglich abzufragen, ob mit einem gemockten Objekt interagiert wurde, wie damit interagiert wurde, welche Argumente dabei übergeben worden sind und in welcher Reihenfolge die Interaktionen damit erfolgt sind.

Hier nur eine kurze Übersicht über das Testen des Codes mit Hilfe von Mockitos `verify()`-Methoden.

```java
    @Test
    public void testVerifyDasKeineInteraktionMitDerListeStattgefundenHat() {
        // Testet, ob die spezifizierte Interaktion mit der Liste
        // nie stattgefunden hat.
        verify(fluppisListe, never()).clear();
    }
```

```java
    @Test
    public void testVerifyReihenfolgeDerInteraktionenMitDerFluppisListe() {
        // Testet, ob die Reihenfolge der spezifizierten Interaktionen
        // mit der Liste eingehalten wurde.
        fluppisListe.clear();
        InOrder reihenfolge = inOrder(fluppisListe);
        reihenfolge.verify(fluppisListe).add("Fluppi001");
        reihenfolge.verify(fluppisListe).clear();
    }
```

```java
    @Test
    public void testVerifyFlexibleArgumenteBeimZugriffAufFluppisListe() {
        // Testet, ob schon jemals etwas zu der Liste hinzugefügt wurde.
        // Dabei ist es egal welcher String eingegeben wurde.
        verify(fluppisListe).add(anyString());
    }
```

```java
    @Test
    public void testVerifyInteraktionenMitHilfeDesArgumentCaptor() {
        // Testet, welches Argument beim Methodenaufruf übergeben wurde.
        fluppisListe.addAll(Arrays.asList("BobDerBaumeister"));
        ArgumentCaptor<List> argumentMagnet = ArgumentCaptor.forClass(FluppisListe.class);
        verify(fluppisListe).addAll(argumentMagnet.capture());
        List<String> argumente = argumentMagnet.getValue();
        assertEquals("BobDerBaumeister", argumente.get(0));
    }
```

[Demo: VerifyFluppisListeTest]{.bsp}

Diese Beispiele finden sie im übrigen auch in den beigefügten Sourcecodes dieser Vorlesung.

## Folie 8 - Behavior-driven development BDD

## Folie 9 - PowerMock

## Weiterführendes

### PowerMock provides more functionality

* mocking of static methods
* final classes
* final methods
* private methods
* constructor
* removal of static initializers

@see <https://www.javatpoint.com/mockito-powermock>

...

## Wrap-Up

* Gründliches Testen ist ebenso viel Aufwand wie Coden (siehe vorherige
  Vorlesungen über JUnit Tests).
* How to Setup.
* Unterschiede Mock > Stub > Spy.
* Einfaches Beispiel für einen Mock.
* Einfaches Beispiel für einen Stub.
* Einfaches Beispiel für einen Spy.
* Testen von Verhalten.
* Verifikation mit `when(...).then(...)` / `times(...)`
* Was macht der Mockito Arguemnt Captor.
* Dynamische Manipulation von Argumenten.
* Dynamische Rückgabewerte basierend auf den verarbeiteten Argumenten.
* // TODO

...

## NOTIZEN (Here be dragons)

## When to use @Mock and when @InjectMocks

// TODO

* [x] Done. @see <https://howtodoinjava.com/mockito/mockito-mock-injectmocks/>

## Examples

// TODO

* [ ] Beispiele erstellen.
* @see <https://www.javatpoint.com/examples-of-mockito-and-junit-in-eclipse-ide>

## Fakes vs. Dummys vs. Mock vs. Stub vs. Spy

// TODO

* [X]  done.
* @see <https://www.javatpoint.com/mockito>
* Fake vs... @see <https://www.martinfowler.com/articles/mocksArentStubs.html>

## Stub -> when then syntax

## Answer`<T>` interface of Mockito

// TODO

* [ ] Übersicht erstellen.
* @see <https://www.javadoc.io/doc/org.mockito/mockito-core/2.7>.
  9/org/mockito/stubbing/Answer.html
* @see <https://www.baeldung.com/mockito-behavior>

* doAnswer()
* when() then answer()

## Mockito Argument Matchers

* [x] Deprecated -> Done.
* @see <https://www.javadoc.io/doc/org.mockito/mockito-core/2.7>.
  17/org/mockito/Matchers.html

# verify for testing side effects

// TODO

* [x] Übersicht erstellen.
* @see <https://www.baeldung.com/mockito-verify>

## Mocking private methods with another dependency "PowerMock"?

// TODO

* [ ] Übersicht erstellen -> PowerMock
* @see <https://www.baeldung.com/powermock-private-method>

## Mockito Spies

// TODO

* [ ] Übersicht erstellen.
* @see <https://www.baeldung.com/mockito-spy>

## Mockito’s Mock Methods

// TODO

* [ ] Übersicht erstellen.
* @see <https://www.baeldung.com/mockito-mock-methods>

## Behavior-driven development (BDD)

// TODO

* [ ] Beispiel erstellen.
* @see <https://www.javatpoint.com/mockito-behavior-driven-development>

## Mockito Annotations overview with examples

// TODO

* [x] Übersicht erstellen -> Folie 6
* @see <https://www.javatpoint>.
* @see <https://www.javatpoint.com/mockito-annotations>

## Mockito JUnit Rules

// TODO

* [ ] Übersicht erstellen.
* @see <https://www.javatpoint.com/mockito-junit-rules>

# Codesnippets

// TODO

* [x] Beispiele erstellen.
* @see <https://blog.indrek.io/articles/getting-started-with-mockito/>

## Frage/Code snippet zu when(...).thenReturn(...)?

* // TODO

## Frage/Code snippet zu when(...).thenThrow(...)?

* // TODO

## Frage/Code snippet zu doReturn(...).when(...)?

* // TODO

## Frage/Code snippet zu doThrow(...).when(...)?

* // TODO

* [ ]

## Frage/Code snippet zu doAnswer(...).when(...)?

* // TODO

## Wie können "Answer" Methoden von Mockito verwendet werden?

* // TODO

## Wie verwendet man Spies und Reflections um private Attribute zu ändern?

* // TODO

## Mockito example

// TODO

* [ ] Beispiele erstellen.
* @see <https://entwickler.de/software-architektur/cocktail-gefallig>

## providing a Different Default Answer

// TODO

* [ ] Übersicht erstellen.
* @see <https://www.baeldung.com/mockito-mocksettings#providing-a-different>
  -default-answer

## AdditionalAnswers

// TODO

* [ ] Übersicht erstellen.
* @see <https://www.baeldung.com/mockito-additionalanswers#overview>

## Return Custom Value using Mockito

// TODO

* [ ] Übersicht erstellen.
* @see <http://www.javabyexamples.com/mockito-recipe-custom-return-with-answer>

### Calling the Real Method using Answer

// TODO

* [x] Beispiel erstellen.
* @see <http://www.javabyexamples>.
  com/mockito-recipe-custom-return-with-answer#call-real

## Spying or Mocking Abstract Classes

// TODO

* [ ] Beispiel erstellen.
* @see <https://www.javatpoint.com/mockito-spying-or-mocking-abstract-classes>

## How to mock a void method using Mockito?

// TODO

* [ ] Beispiel erstellen.
* @see <https://www.baeldung.com/mockito-void-methods>

## Wie werden externe Abhängigkeiten gemockt?

// TODO

* [x] Beispiel erstellen.
* siehe coding Beispiel.

## Mockitos internal Whitebox is depreacted but Powermock has one with extended capabilities

// TODO

* [x] Done weil deprecated.







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)


```
https://github.com/PM-Dungeon/PM-Lecture/pull/426
https://www.baeldung.com/tag/mockito/
https://www.baeldung.com/intro-to-powermock
https://www.baeldung.com/powermock-private-method

> > kriegen wir die praktikumsaufgabe auch direkt mit moskito hin,
>
> ja, bekommen wir auch hin...

dann lass uns das noch anpassen. ich habe ja nur 20 minuten (max 30 minuten), und da schafft man eigentlich grad mal so die wichtigsten dinge von mockito plus einen hinweis auf powermock. aber da noch auf powermock einzugehen, so dass die studis das im praktikum nutzen können, halte ich für nicht zielführend.

>
> https://www.baeldung.com/intro-to-powermock#:~:text=PowerMockito%20is%20a%20PowerMock's%20extension,final%2C%20static%20or%20private%20methods.
>
> > It provides capabilities to work with the Java Reflection API in a simple way to overcome the problems of Mockito, such as the lack of ability to mock final, static or private methods.
>
> Konstruktoren, final Methoden, static Methoden, partielles Mocking und Whitebox/Variablen.

das sollte ich zumindest als "ausblick" aufnehmen. danke!
```

:::
