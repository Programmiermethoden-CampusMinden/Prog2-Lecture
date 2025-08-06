# Coding Conventions und Metriken

> [!NOTE]
>
> <details open>
>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Code entsteht nicht zum Selbstzweck, er muss von anderen Menschen
> leicht verstanden und gewartet werden können: Entwickler verbringen
> einen wesentlichen Teil ihrer Zeit mit dem **Lesen** von (fremdem)
> Code.
>
> Dabei helfen “Coding Conventions”, die eine gewisse einheitliche
> äußerliche Erscheinung des Codes vorgeben (Namen, Einrückungen, …). Im
> Java-Umfeld ist der “Google Java Style” bzw. der recht ähnliche “AOSP
> Java Code Style for Contributors” häufig anzutreffen. Coding
> Conventions beinhalten typischerweise Regeln zu
>
> - Schreibweisen und Layout
> - Leerzeichen, Einrückung, Klammern
> - Zeilenlänge, Umbrüche
> - Kommentare
>
> Die Beachtung von grundlegenden Programmierprinzipien hilft ebenso,
> die Lesbarkeit und Verständlichkeit zu verbessern.
>
> Metriken sind Kennzahlen, die aus dem Code berechnet werden, und
> können zur Überwachung der Einhaltung von Coding Conventions und
> anderen Regeln genutzt werden. Nützliche Metriken sind dabei NCSS
> (*Non Commenting Source Statements*), McCabe (*Cyclomatic
> Complexity*), BEC (*Boolean Expression Complexity*) und DAC (*Class
> Data Abstraction Coupling*).
>
> Für die Formatierung des Codes kann man die IDE nutzen, muss dort dann
> aber die Regeln detailliert manuell einstellen. Das Tool **Spotless**
> lässt sich dagegen in den Build-Prozess einbinden und kann die
> Konfiguration über ein vordefiniertes Regelset passend zum Google Java
> Style/AOSP automatisiert vornehmen.
>
> Die Prüfung der Coding Conventions und Metriken kann durch das Tool
> **Checkstyle** erfolgen. Dieses kann beispielsweise als Plugin in der
> IDE oder direkt in den Build-Prozess eingebunden werden und wird mit
> Hilfe einer XML-Datei konfiguriert.
>
> Um typische Anti-Pattern zu vermeiden, kann man den Code mit
> sogenannten *Lintern* prüfen. Ein Beispiel für die Java-Entwicklung
> ist **SpotBugs**, welches sich in den Build-Prozess einbinden lässt
> und über 400 typische problematische Muster im Code erkennt.
>
> Für die Praktika in der Veranstaltung Programmiermethoden wird der
> Google Java Style oder AOSP genutzt. Für die passende
> Checkstyle-Konfiguration wird eine minimale
> [checkstyle.xml](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle.xml)
> bereitgestellt (vgl. Folie “Konfiguration für das PM-Praktikum”).
>
> </details>
>
> <details>
>
> <summary><strong>🎦 Videos</strong></summary>
>
> - [VL Coding Conventions](https://youtu.be/nLAEak6Fwfk)
> - [Demo Formatter und Spotless](https://youtu.be/oCMwyDrPkFI)
> - [Demo Checkstyle](https://youtu.be/NR070ZimbH4)
> - [Demo Checkstyle: Konfiguration mit
>   Eclipse-CS](https://youtu.be/0ny6e6CNTF8)
> - [Demo SpotBugs](https://youtu.be/tSczcf_EOwI)
>
> </details>

## Coding Conventions: Richtlinien für einheitliches Aussehen von Code

=\> Ziel: Andere Programmierer sollen Code schnell lesen können

- **Namen, Schreibweisen**: UpperCamelCase vs. lowerCamelCase
  vs. UPPER_SNAKE_CASE
- **Kommentare** (Ort, Form, Inhalt): Javadoc an allen `public` und
  `protected` Elementen
- **Einrückungen und Spaces vs. Tabs**: 4 Spaces
- **Zeilenlängen**: 100 Zeichen
- **Leerzeilen**: Leerzeilen für Gliederung
- **Klammern**: Auf selber Zeile wie Code

Beispiele: [Sun Code
Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf),
[Google Java Style](https://google.github.io/styleguide/javaguide.html),
[AOSP Java Code Style for
Contributors](https://source.android.com/docs/setup/contribute/code-style)

## Beispiel nach Google Java Style/AOSP formatiert

``` java
package wuppie.deeplearning.strategy;

/**
 * Demonstriert den Einsatz von AOSP/Google Java Style ................. Umbruch nach 100 Zeichen |
 */
public class MyWuppieStudi implements Comparable<MyWuppieStudi> {
    private static String lastName;
    private static MyWuppieStudi studi;

    private MyWuppieStudi() {}

    /** Erzeugt ein neues Exemplar der MyWuppieStudi-Spezies (max. 40 Zeilen) */
    public static MyWuppieStudi getMyWuppieStudi(String name) {
        if (studi == null) {
            studi = new MyWuppieStudi();
        }
        if (lastName == null) lastName = name;

        return studi;
    }

    @Override
    public int compareTo(MyWuppieStudi o) {
        return lastName.compareTo(lastName);
    }
}
```

Dieses Beispiel wurde nach Google Java Style/AOSP formatiert.

Die Zeilenlänge beträgt max. 100 Zeichen. Pro Methode werden max. 40
Zeilen genutzt. Zwischen Attributen, Methoden und Importen wird jeweils
eine Leerzeile eingesetzt (zwischen den einzelnen Attributen *muss* aber
keine Leerzeile genutzt werden). Zur logischen Gliederung können
innerhalb von Methoden weitere Leerzeilen eingesetzt werden, aber immer
nur eine.

Klassennamen sind UpperCamelCase, Attribute und Methoden und Parameter
lowerCamelCase, Konstanten (im Beispiel nicht vorhanden)
UPPER_SNAKE_CASE. Klassen sind Substantive, Methoden Verben.

Alle `public` und `protected` Elemente werden mit einem
Javadoc-Kommentar versehen. Überschriebene Methoden müssen nicht mit
Javadoc kommentiert werden, müssen aber mit `@Override` markiert werden.

Geschweifte Klammern starten immer auf der selben Codezeile. Wenn bei
einem `if` nur ein Statement vorhanden ist und dieses auf die selbe
Zeile passt, kann auf die umschließenden geschweiften Klammern
ausnahmsweise verzichtet werden.

Es wird mit Leerzeichen eingerückt. [Google Java
Style](https://google.github.io/styleguide/javaguide.html#s4.2-block-indentation)
arbeitet mit 2 Leerzeichen, während
[AOSP](https://source.android.com/docs/setup/contribute/code-style#use-spaces-for-indentation)
hier 4 Leerzeichen vorschreibt. Im Beispiel wurde nach AOSP eingerückt.

Darüber hinaus gibt es vielfältige weitere Regeln für das Aussehen des
Codes. Lesen Sie dazu entsprechend auf [Google Java
Style](https://google.github.io/styleguide/javaguide.html) und auch auf
[AOSP](https://source.android.com/docs/setup/contribute/code-style)
nach.

## Formatieren Sie Ihren Code (mit der IDE)

Sie können den Code manuell formatieren, oder aber (sinnvollerweise)
über Tools formatieren lassen. Hier einige Möglichkeiten:

- IDE: Code-Style einstellen und zum Formatieren nutzen

- [google-java-format](https://github.com/google/google-java-format):
  `java -jar google-java-format.jar --replace *.java` (auch als
  IDE-Plugin)

- [**Spotless**](https://github.com/diffplug/spotless) in Gradle:

  ``` groovy
  plugins {
      id "java"
      id "com.diffplug.spotless" version "7.0.3"
  }

  spotless {
      java {
          // googleJavaFormat()
          googleJavaFormat().aosp()  // indent w/ 4 spaces
      }
  }
  ```

  Prüfen mit `./gradlew spotlessCheck` (Teil von `./gradlew check`) und
  Formatieren mit `./gradlew spotlessApply`

### Einstellungen der IDE’s

- Eclipse:
  - `Project > Properties > Java Code Style > Formatter`: Coding-Style
    einstellen/einrichten
  - Code markieren, `Source > Format`
  - Komplettes Aufräumen: `Source > Clean Up` (Formatierung, Importe,
    Annotationen, …) Kann auch so eingestellt werden, dass ein “Clean
    Up” immer beim Speichern ausgeführt wird!
- IntelliJ verfügt über ähnliche Fähigkeiten:
  - Einstellen über `Preferences > Editor > Code Style > Java`
  - Formatieren mit `Code > Reformat Code` oder `Code > Reformat File`

Die Details kann/muss man einzeln einstellen. Für die “bekannten” Styles
(Google Java Style) bringen die IDE’s oft aber schon eine
Gesamtkonfiguration mit.

**Achtung**: Zumindest in Eclipse gibt es mehrere Stellen, wo ein
Code-Style eingestellt werden kann (“Clean Up”, “Formatter”, …). Diese
sollten dann jeweils auf den selben Style eingestellt werden, sonst gibt
es unter Umständen lustige Effekte, da beim Speichern ein anderer Style
angewendet wird als beim “Clean Up” oder beim “Format Source” …

Analog sollte man bei der Verwendung von Checkstyle auch in der IDE im
Formatter die entsprechenden Checkstyle-Regeln (s.u.) passend
einstellen, sonst bekommt man durch Checkstyle Warnungen angezeigt, die
man durch ein automatisches Formatieren *nicht* beheben kann.

### Google Java Style und google-java-format

Wer direkt den [Google Java
Style](https://google.github.io/styleguide/javaguide.html) nutzt, kann
auch den dazu passenden Formatter von Google einsetzen:
[google-java-format](https://github.com/google/google-java-format).
Diesen kann man entweder als Plugin für IntelliJ/Eclipse einsetzen oder
als Stand-alone-Tool (Kommandozeile oder Build-Skripte) aufrufen. Wenn
man sich noch einen entsprechenden Git-Hook definiert, wird vor jedem
Commit der Code entsprechend den Richtlinien formatiert :)

### Spotless und google-java-format in Gradle

*Hinweis*: Bei Spotless in Gradle müssen je nach den Versionen von
Spotless/google-java-format bzw. des JDK noch Optionen in der Datei
`gradle.properties` eingestellt werden (siehe
[Demo](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/formatter/)
und [Spotless \> google-java-format
(Web)](https://github.com/diffplug/spotless/tree/main/plugin-gradle#google-java-format)).

**Tipp**: Die Formatierung über die IDE ist angenehm, aber in der Praxis
leider oft etwas hakelig: Man muss alle Regeln selbst einstellen (und es
gibt *einige* dieser Einstellungen), und gerade IntelliJ “greift”
manchmal nicht alle Code-Stellen beim Formatieren. Nutzen Sie Spotless
und bauen Sie die Konfiguration in Ihr Build-Skript ein und
konfigurieren Sie über den Build-Prozess.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/formatter/">Demo: Konfiguration Formatter (IDE), Spotless/Gradle</a></p>

## Metriken: Kennzahlen für verschiedene Aspekte zum Code

Metriken messen verschiedene Aspekte zum Code und liefern eine Zahl
zurück. Mit Metriken kann man beispielsweise die Einhaltung der Coding
Rules (Formate, …) prüfen, aber auch die Einhaltung verschiedener Regeln
des objektorientierten Programmierens.

### Beispiele für wichtige Metriken (jeweils Max-Werte für PM)

Die folgenden Metriken und deren Maximal-Werte sind gute Erfahrungswerte
aus der Praxis und helfen, den Code Smell “Langer Code” (vgl. [“Code
Smells”](smells.md)) zu erkennen und damit zu vermeiden. Über die
Metriken *BEC*, *McCabe* und *DAC* wird auch die Einhaltung elementarer
Programmierregeln gemessen.

- **NCSS** (*Non Commenting Source Statements*)
  - Zeilen pro Methode: 40; pro Klasse: 250; pro Datei: 300 *Annahme*:
    Eine Anweisung je Zeile …
- **Anzahl der Methoden** pro Klasse: 10
- **Parameter** pro Methode: 3
- **BEC** (*Boolean Expression Complexity*) Anzahl boolescher Ausdrücke
  in `if` etc.: 3
- **McCabe** (*Cyclomatic Complexity*)
  - Anzahl der möglichen Verzweigungen (Pfade) pro Methode + 1
  - 1-4 gut, 5-7 noch OK
- **DAC** (*Class Data Abstraction Coupling*)
  - Anzahl der genutzten (instantiierten) “Fremdklassen”
  - Werte kleiner 7 werden i.A. als normal betrachtet

Die obigen Grenzwerte sind typische Standardwerte, die sich in der
Praxis allgemein bewährt haben (vergleiche u.a. ([Martin
2009](#ref-Martin2009)) oder auch in [AOSP: Write short
methods](https://source.android.com/docs/setup/contribute/code-style#write-short-methods)
und [AOSP: Limit line
length](https://source.android.com/docs/setup/contribute/code-style#limit-line-length)).

Dennoch sind das keine absoluten Werte an sich. Ein Übertreten der
Grenzen ist ein **Hinweis** darauf, dass **höchstwahrscheinlich** etwas
nicht stimmt, muss aber im konkreten Fall hinterfragt und diskutiert und
begründet werden!

### Metriken im Beispiel von oben

``` java
    private static String lastName;
    private static MyWuppieStudi studi;

    public static MyWuppieStudi getMyWuppieStudi(String name) {
        if (studi == null) {
            studi = new MyWuppieStudi();
        }
        if (lastName == null) lastName = name;

        return studi;
    }
```

- BEC: 1 (nur ein boolescher Ausdruck im `if`)
- McCabe: 3 (es gibt zwei mögliche Verzweigungen in der Methode plus die
  Methode selbst)
- DAC: 1 (eine “Fremdklasse”: `String`)

*Anmerkung*: In Checkstyle werden für einige häufig verwendete
Standard-Klassen Ausnahmen definiert, d.h. `String` würde im obigen
Beispiel *nicht* bei DAC mitgezählt/angezeigt.

=\> Verweis auf LV Softwareengineering

## Tool-Support: Checkstyle

Metriken und die Einhaltung von Coding-Conventions werden
sinnvollerweise nicht manuell, sondern durch diverse Tools erfasst, etwa
im Java-Bereich mit Hilfe von
[**Checkstyle**](https://github.com/checkstyle).

Das Tool lässt sich [Standalone über
CLI](https://checkstyle.org/cmdline.html) nutzen oder als Plugin für
IDE’s ([Eclipse](https://checkstyle.org/eclipse-cs) oder
[IntelliJ](https://github.com/jshiell/checkstyle-idea)) einsetzen.
Gradle bringt ein eigenes
[Plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)
mit.

- IDE: diverse
  [Plugins](https://checkstyle.org/index.html#Related_Tools):
  [Eclipse-CS](https://checkstyle.org/eclipse-cs),
  [CheckStyle-IDEA](https://github.com/jshiell/checkstyle-idea)

- [CLI](https://checkstyle.org/cmdline.html):
  `java -jar checkstyle-10.2-all.jar -c google_checks.xml *.java`

- [Plugin
  “**checkstyle**”](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)
  in Gradle:

  ``` groovy
  plugins {
      id "java"
      id "checkstyle"
  }

  checkstyle {
      configFile file('checkstyle.xml')
      toolVersion '10.23.0'
  }
  ```

  - Aufruf: Prüfen mit `./gradlew checkstyleMain` (Teil von
    `./gradlew check`)
  - Konfiguration: `<projectDir>/config/checkstyle/checkstyle.xml`
    (Default) bzw. mit der obigen Konfiguration direkt im Projektordner
  - Report: `<projectDir>/build/reports/checkstyle/main.html`

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle/">Demo: IntelliJ, Checkstyle/Gradle</a></p>

## Checkstyle: Konfiguration

Die auszuführenden Checks lassen sich über eine
[XML-Datei](https://checkstyle.org/config.html) konfigurieren. In
[Eclipse-CS](https://checkstyle.org/eclipse-cs) kann man die
Konfiguration auch in einer GUI bearbeiten.

Das Checkstyle-Projekt stellt eine passende Konfiguration für den
[Google Java
Style](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
bereit. Diese ist auch in den entsprechenden Plugins oft bereits
enthalten und kann direkt ausgewählt oder als Startpunkt für eigene
Konfigurationen genutzt werden.

Der Startpunkt für die Konfigurationsdatei ist immer das Modul
“Checker”. Darin können sich “FileSetChecks” (Module, die auf einer
Menge von Dateien Checks ausführen), “Filters” (Module, die Events bei
der Prüfung von Regeln filtern) und “AuditListeners” (Module, die
akzeptierte Events in einen Report überführen) befinden. Der
“TreeWalker” ist mit der wichtigste Vertreter der FileSetChecks-Module
und transformiert die zu prüfenden Java-Sourcen in einen *Abstract
Syntax Tree*, also eine Baumstruktur, die dem jeweiligen Code unter der
Java-Grammatik entspricht. Darauf können dann wiederum die meisten
Low-Level-Module arbeiten.

Eine Reihe von [Standard-Checks](https://checkstyle.org/checks.html)
sind bereits in Checkstyle implementiert und benötigen keine weitere
externe Abhängigkeiten. Man kann aber zusätzliche Regeln aus anderen
Projekten beziehen (etwa via Gradle/Maven) oder sich eigene zusätzliche
Regeln in Java schreiben. Die einzelnen Checks werden in der Regel als
“Modul” dem “TreeWalker” hinzugefügt und über die jeweiligen Properties
näher konfiguriert.

Sie finden in der [Doku](https://checkstyle.org/checks.html) zu jedem
Check das entsprechende Modul, das Eltern-Modul (also wo müssen Sie das
Modul im XML-Baum einfügen) und auch die möglichen Properties und deren
Default-Einstellungen.

``` xml
<module name="Checker">
    <module name="LineLength">
        <property name="max" value="100"/>
    </module>

    <module name="TreeWalker">
        <module name="AvoidStarImport"/>
        <module name="MethodCount">
            <property name="maxPublic" value="10"/>
            <property name="maxTotal" value="40"/>
        </module>
    </module>
</module>
```

Alternativen/Ergänzungen: beispielsweise
[MetricsReloaded](https://github.com/BasLeijdekkers/MetricsReloaded).

<p align="right"><a href="https://youtu.be/0ny6e6CNTF8">Demo: Konfiguration mit Eclipse-CS, Hinweis auf Formatter</a></p>

## SpotBugs: Finde Anti-Pattern und potentielle Bugs (Linter)

- [**SpotBugs**](https://github.com/spotbugs/spotbugs) sucht nach über
  400 potentiellen Bugs im Code
  - Anti-Pattern (schlechte Praxis, “dodgy” Code)
  - Sicherheitsprobleme
  - Korrektheit

<!-- -->

- CLI: `java -jar spotbugs.jar options ...`

- IDE: [IntelliJ SpotBugs
  plugin](https://github.com/JetBrains/spotbugs-intellij-plugin),
  [SpotBugs Eclipse
  plugin](https://spotbugs.readthedocs.io/en/latest/eclipse.html)

- Gradle: [SpotBugs Gradle
  Plugin](https://github.com/spotbugs/spotbugs-gradle-plugin)

  ``` groovy
  plugins {
      id "java"
      id "com.github.spotbugs" version "5.0.6"
  }
  spotbugs {
      ignoreFailures = true
      showStackTraces = false
  }
  ```

  Prüfen mit `./gradlew spotbugsMain` (in `./gradlew check`)

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/spotbugs/">Demo: SpotBugs/Gradle</a></p>

## Konfiguration für das PM-Praktikum (Format, Metriken, Checkstyle, SpotBugs)

Im PM-Praktikum beachten wir die obigen Coding Conventions und Metriken
mit den dort definierten Grenzwerten. Diese sind bereits in der bereit
gestellten Minimal-Konfiguration für Checkstyle (s.u.) konfiguriert.

### Formatierung

- Google Java Style/AOSP: **Spotless**

Zusätzlich wenden wir den [Google Java
Style](https://google.github.io/styleguide/javaguide.html) an. Statt der
dort vorgeschriebenen Einrückung mit 2 Leerzeichen (und 4+ Leerzeichen
bei Zeilenumbruch in einem Statement) können Sie auch mit 4 Leerzeichen
einrücken (8 Leerzeichen bei Zeilenumbruch)
([AOSP](https://source.android.com/docs/setup/contribute/code-style)).
Halten Sie sich in Ihrem Team an eine einheitliche Einrückung (Google
Java Style *oder* AOSP).

Formatieren Sie Ihren Code vor den Commits mit **Spotless** (über
Gradle) oder stellen Sie den Formatter Ihrer IDE entsprechend ein.

### Checkstyle

- Minimal-Konfiguration für **Checkstyle** (Coding Conventions,
  Metriken)

Nutzen Sie die folgende **Minimal-Konfiguration** für **Checkstyle** für
Ihre Praktikumsaufgaben. Diese beinhaltet die Prüfung der wichtigsten
Formate nach Google Java Style/AOSP sowie der obigen Metriken. Halten
Sie diese Regeln ein.

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN" "https://checkstyle.org/dtds/configuration_1_3.dtd">

<module name="Checker">
  <property name="severity" value="warning"/>

  <module name="TreeWalker">
    <module name="JavaNCSS">
      <property name="methodMaximum" value="40"/>
      <property name="classMaximum" value="250"/>
      <property name="fileMaximum" value="300"/>
    </module>
    <module name="BooleanExpressionComplexity"/>
    <module name="CyclomaticComplexity">
      <property name="max" value="7"/>
    </module>
    <module name="ClassDataAbstractionCoupling">
      <property name="max" value="6"/>
    </module>
    <module name="MethodCount">
      <property name="maxTotal" value="10"/>
      <property name="maxPrivate" value="10"/>
      <property name="maxPackage" value="10"/>
      <property name="maxProtected" value="10"/>
      <property name="maxPublic" value="10"/>
    </module>
    <module name="ParameterNumber">
      <property name="max" value="3"/>
    </module>
    <module name="MethodLength">
      <property name="max" value="40"/>
    </module>
    <module name="Indentation">
      <property name="basicOffset" value="4"/>
      <property name="lineWrappingIndentation" value="8"/>
      <property name="caseIndent" value="4"/>
      <property name="throwsIndent" value="4"/>
      <property name="arrayInitIndent" value="4"/>
    </module>
    <module name="TypeName"/>
    <module name="MethodName"/>
    <module name="MemberName"/>
    <module name="ParameterName"/>
    <module name="ConstantName"/>
    <module name="OneStatementPerLine"/>
    <module name="MultipleVariableDeclarations"/>
    <module name="MissingOverride"/>
    <module name="MissingJavadocMethod"/>
    <module name="AvoidStarImport"/>
  </module>

  <module name="LineLength">
    <property name="max" value="100"/>
  </module>
  <module name="FileTabCharacter">
    <property name="eachLine" value="true"/>
  </module>
  <module name="NewlineAtEndOfFile"/>
</module>
```

Sie können diese Basis-Einstellungen auch aus dem
Programmiermethoden-CampusMinden/Prog2-Lecture-Repo direkt
herunterladen:
[checkstyle.xml](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle.xml).

Sie können zusätzlich gern noch die weiteren (und strengeren) Regeln aus
der vom Checkstyle-Projekt bereitgestellten Konfigurationsdatei für den
[Google Java
Style](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
nutzen. *Hinweis*: Einige der dort konfigurierten Checkstyle-Regeln
gehen allerdings über den Google Java Style hinaus.

### Linter: SpotBugs

- Vermeiden von Anti-Pattern mit **SpotBugs**

Setzen Sie zusätzlich **SpotBugs** mit ein. Ihre Lösungen dürfen keine
Warnungen oder Fehler beinhalten, die SpotBugs melden würde.

## Wrap-Up

- Code entsteht nicht zum Selbstzweck =\> Regeln nötig!
  - Coding Conventions

    - Regeln zu Schreibweisen und Layout
    - Leerzeichen, Einrückung, Klammern
    - Zeilenlänge, Umbrüche
    - Kommentare

  - Formatieren mit **Spotless**

  - Prinzipien des objektorientierten Programmierens (vgl. [“Code
    Smells”](smells.md))

    - Jede Klasse ist für genau **einen** Aspekt des Systems
      verantwortlich. (*Single Responsibility*)
    - Keine Code-Duplizierung! (*DRY* - Don’t repeat yourself)
    - Klassen und Methoden sollten sich erwartungsgemäß verhalten
    - Kapselung: Möglichst wenig öffentlich zugänglich machen

<!-- -->

- Metriken: Einhaltung von Regeln in Zahlen ausdrücken
- Prüfung manuell durch Code Reviews oder durch Tools wie **Checkstyle**
  oder **SpotBugs**
- Definition des
  [“PM-Styles”](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle.xml)
  (siehe Folie “Konfiguration für das PM-Praktikum”)

## 📖 Zum Nachlesen

- Martin ([2009](#ref-Martin2009))
- Inden ([2013, Kap. 13](#ref-Inden2013))
- Google Open Source ([2022](#ref-googlestyleguide))

------------------------------------------------------------------------

> [!TIP]
>
> <details>
>
> <summary><strong>✅ Lernziele</strong></summary>
>
> - k2: Ich kann verschiedene Coding Conventions erklären
> - k2: Ich kann die Metriken NCSS, McCabe, BEC, DAC erklären
> - k3: Ich kann das Tool Spotless zur Formatierung des Codes nutzen
> - k3: Ich kann das Tool Checkstyle zum Überprüfen von Coding Conventions und Metriken nutzen
> - k2: Ich kenne das Tool SpotBugs zum Vermeiden von Anti-Pattern
>
> </details>

------------------------------------------------------------------------

> [!NOTE]
>
> <details>
>
> <summary><strong>👀 Quellen</strong></summary>
>
> <div id="refs" class="references csl-bib-body hanging-indent"
> entry-spacing="0">
>
> <div id="ref-googlestyleguide" class="csl-entry">
>
> Google Open Source. 2022. „Google Java Style Guide“. 2022.
> <https://google.github.io/styleguide/javaguide.html>.
>
> </div>
>
> <div id="ref-Inden2013" class="csl-entry">
>
> Inden, M. 2013. *Der Weg zum Java-Profi*. 2. Aufl. dpunkt.verlag.
>
> </div>
>
> <div id="ref-Martin2009" class="csl-entry">
>
> Martin, R. 2009. *Clean Code*. mitp.
>
> </div>
>
> </div>
>
> </details>

------------------------------------------------------------------------

<img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png" width="10%">

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> df56b1c (lecture: remove explicit link to pdf version, 2025-07-23)<br></sub></sup></p></blockquote>
