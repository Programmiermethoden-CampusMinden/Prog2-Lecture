---
type: lecture-cg
title: "Coding Conventions und Metriken"
menuTitle: "Coding Conventions"
author: "Carsten Gips (FH Bielefeld)"
weight: 5
readings:
  - key: "Martin2009"
  - key: "Inden2013"
    comment: "Kapitel 13: Programmierstil und Coding Conventions"
  - key: "googlestyleguide"
tldr: |
  Code entsteht nicht zum Selbstzweck, er muss von anderen Menschen leicht verstanden und
  gewartet werden können: Entwickler verbringen einen wesentlichen Teil ihrer Zeit mit dem
  **Lesen** von (fremdem) Code. Dabei helfen "Coding Conventions", die eine gewisse einheitliche
  äußerliche Erscheinung des Codes vorgeben (Namen, Einrückungen, ...). Die Beachtung von
  grundlegenden Programmierprinzipien hilft ebenso, die Lesbarkeit und Verständlichkeit zu
  verbessern.

  Metriken zur Überwachung der Einhaltung

  *   Coding Conventions
    *   Regeln zu Schreibweisen und Layout
    *   Leerzeichen, Einrückung, Klammern
    *   Zeilenlänge, Umbrüche
    *   Kommentare

  *   Metriken: Einhaltung von Regeln in Zahlen ausdrücken
  *   Prüfung manuell durch Code Reviews oder durch Tools, zB. Checkstyle

outcomes:
  - k2: "Erklären verschiedener Coding Conventions"
  - k2: "Erklären wichtiger Grundregeln des objektorientierten Programmierens"
  - k2: "Erklären der Metriken NCSS, McCabe, BEC, DAC"
  - k3: "Einhalten der wichtigsten Grundregeln des objektorientierten Programmierens"
  - k3: "Nutzung des Tools Checkstyle (Standalone, IDE-Plugins, Konfiguration)"
assignments:
  - topic: sheet05
youtube:
  - link: ""
    name: "VL Coding Conventions"
  - link: ""
    name: "Demo Formatter und Spotless"
  - link: ""
    name: "Demo Checkstyle"
  - link: ""
    name: "Demo Checkstyle: Konfiguration mit Eclipse-CS"
  - link: ""
    name: "Demo SpotBugs"
fhmedia:
  - link: ""
    name: "VL Coding Conventions"
---


## Coding Conventions: Richtlinien für einheitliches Aussehen von Code

=> Ziel: Andere Programmierer sollen Code schnell lesen können

\bigskip

*   **Namen, Schreibweisen**: UpperCamelCase vs. lowerCamelCase vs. UPPER_SNAKE_CASE
*   **Kommentare** (Ort, Form, Inhalt): Javadoc an allen `public` und `protected` Elementen
*   **Einrückungen und Spaces vs. Tabs**: 4 Spaces
*   **Zeilenlängen**: 100 Zeichen
*   **Leerzeilen**: Leerzeilen für Gliederung
*   **Klammern**: Auf selber Zeile wie Code

\bigskip
\smallskip

Beispiele: [Sun Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf),
[Google Java Style](https://google.github.io/styleguide/javaguide.html),
[AOSP Java Code Style for Contributors](https://source.android.com/setup/contribute/code-style)


## Coding Conventions: Beispiel nach Google Java Style/AOSP formatiert

```{.java size="scriptsize"}
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

::: notes
Dieses Beispiel wurde nach Google Java Style/AOSP formatiert.

Die Zeilenlänge beträgt max. 100 Zeichen. Pro Methode werden max. 40 Zeilen genutzt. Zwischen Attributen,
Methoden und Importen wird jeweils eine Leerzeile eingesetzt (zwischen den einzelnen Attributen _muss_
aber keine Leerzeile genutzt werden). Zur logischen Gliederung können innerhalb von Methoden weitere
Leerzeilen eingesetzt werden, aber immer nur eine.

Klassennamen sind UpperCamelCase, Attribute und Methoden und Parameter lowerCamelCase, Konstanten (im
Beispiel nicht vorhanden) UPPER_SNAKE_CASE. Klassen sind Substantive, Methoden Verben.

Alle `public` und `protected` Elemente werden mit einem Javadoc-Kommentar versehen. Überschriebene Methoden
müssen nicht mit Javadoc kommentiert werden, müssen aber mit `@Override` markiert werden.

Geschweifte Klammern starten immer auf der selben Codezeile. Wenn bei einem `if` nur ein Statement vorhanden
ist und dieses auf die selbe Zeile passt, kann auf die umschließenden geschweiften Klammern ausnahmsweise
verzichtet werden.

Es wird mit Leerzeichen eingerückt. [Google Java Style](https://google.github.io/styleguide/javaguide.html#s4.2-block-indentation)
arbeitet mit 2 Leerzeichen, während [AOSP](https://source.android.com/setup/contribute/code-style#use-spaces-for-indentation)
hier 4 Leerzeichen vorschreibt.

Darüber hinaus gibt es vielfältige Regeln für das Aussehen des Codes. Lesen Sie dazu entsprechend auf
[Google Java Style](https://google.github.io/styleguide/javaguide.html) und auch auf
[AOSP](https://source.android.com/setup/contribute/code-style) nach.
:::


## Formatieren Sie Ihren Code (mit der IDE)

*   IDE: Code-Style einstellen und zum Formatieren nutzen

*   [google-java-format](https://github.com/google/google-java-format):
    `java -jar google-java-format.jar --replace *.java`
    [(auch als IDE-Plugin)]{.notes}

*   [Spotless](https://github.com/diffplug/spotless) in Gradle:

    ```{.groovy size="scriptsize"}
    plugins {
        id "java"
        id "com.diffplug.spotless" version "6.5.0"
    }

    spotless {
        java {
            // googleJavaFormat()
            googleJavaFormat().aosp()  // indent w/ 4 spaces
        }
    }
    ```

    `./gradlew spotlessCheck` (Teil von `./gradlew build`) und `./gradlew spotlessApply`


::::::::: notes
### Einstellungen der IDE's:

*   Eclipse:
    *   `Project > Properties > Java Code Style > Formatter`: Coding-Style einstellen/einrichten
    *   Code markieren, `Source > Format`
    *   Komplettes Aufräumen: `Source > Clean Up` (Formatierung, Importe, Annotationen, ...)
        Kann auch so eingestellt werden, dass ein Clean Up immer beim Speichern ausgeführt wird!
*   IntelliJ verfügt über ähnliche Fähigkeiten:
    *   Einstellen über `Preferences > Editor > Code Style > Java`
    *   Formatieren mit `Code > Reformat Code` oder `Code > Reformat File`

**Achtung**: Zumindest in Eclipse gibt es mehrere Stellen, wo ein Code-Style eingestellt werden
kann ("Clean Up", "Formatter"). Diese sollten dann jeweils auf den selben Style eingestellt werden,
sonst gibt es unter Umständen lustige Effekte, da beim Speichern ein anderer Style angewendet wird
als beim Clean Up oder beim Format Source ...

Analog sollte man auch in der IDE die entsprechenden Checkstyle-Regeln passend einstellen, sonst
bekommt man Warnungen angezeigt, die man durch ein automatisches Formatieren nicht beheben kann.

### Google Java Style und google-java-format

Wer direkt den [Google Java Style](https://google.github.io/styleguide/javaguide.html) nutzt,
kann auch den dazu passenden Formatter von Google einsetzen:
[google-java-format](https://github.com/google/google-java-format).
Diesen kann man entweder als Plugin für IntelliJ/Eclipse einsetzen oder als Stand-alone-Tool
(Kommandozeile oder Build-Skripte) aufrufen. Wenn man sich noch einen entsprechenden
Git-Hook definiert, wird vor jedem Commit der Code entsprechend den Richtlinien formatiert :)

### Spotless und google-java-format in Gradle

_Hinweis_: Bei Spotless in Gradle müssen je nach den Versionen von Spotless/google-java-format
bzw. des JDK noch Optionen in der Datei `gradle.properties` eingestellt werden (siehe
[Demo](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/coding/src/formatter/) und
[Spotless > google-java-format](https://github.com/diffplug/spotless/tree/main/plugin-gradle#google-java-format)).
:::::::::

<!-- Für die Demo:
docker pull gradle
docker run --rm -it  -v "$PWD":/data -w /data  --entrypoint "bash"  gradle
-->

[Demo: Konfiguration Formatter IDE, [Spotless/Gradle](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/coding/src/formatter/)]{.bsp}


## Metriken: Kennzahlen für verschiedene Aspekte zum Code

::::::::: notes
Metriken messen verschiedene Aspekte zum Code und liefern eine Zahl zurück. Mit Metriken kann
man beispielsweise die Einhaltung der Coding Rules (Formate, ...) prüfen, aber auch die Einhaltung
verschiedener Regeln des objektorientierten Programmierens.

### Beispiele für wichtige Metriken (jeweils max-Werte)

Die folgenden Metriken und deren Maximal-Werte sind gute Erfahrungswerte aus der Praxis und helfen,
den Code Smell "Langer Code"  (vgl. `["Code Smells"]({{< ref "/coding/smells" >}})`{=markdown}) zu
erkennen und damit zu vermeiden. Über die Metriken _BEC_, _McCabe_ und _DAC_ wird auch die Einhaltung
elementarer Programmierregeln gemessen.
:::::::::

*   **NCSS** (_Non Commenting Source Statements_)
    *   Zeilen pro Methode: 40; pro Klasse: 250; pro Datei: 300 \newline
        _Annahme_: Eine Anweisung je Zeile ...
*   **Anzahl der Methoden** pro Klasse: 10
*   **Parameter** pro Methode: 3
*   **BEC** (_Boolean Expression Complexity_) \newline
    Anzahl boolescher Ausdrücke in `if` etc.: 3
*   **McCabe** (_Cyclomatic Complexity_)
    *   Anzahl der möglichen Verzweigungen (Pfade) pro Methode + 1
    *   1-4 gut, 5-7 noch OK
*   **DAC** (_Class Data Abstraction Coupling_)
    *   Anzahl der genutzten (instantiierten) "Fremdklassen"
    *   Werte kleiner 7 werden i.A. als normal betrachtet

::::::::: notes
Die obigen Grenzwerte sind typische Standardwerte, die sich in der Praxis allgemein bewährt haben
(u.a. [@Martin2009] oder auch in
[AOSP: Write short methods](https://source.android.com/setup/contribute/code-style#write-short-methods)
und [AOSP: Limit line length](https://source.android.com/setup/contribute/code-style#limit-line-length)).

Dennoch sind das keine absoluten Werte an sich. Ein Übertreten der Grenzen ist ein
**Hinweis** darauf, das **höchstwahrscheinlich** etwas nicht stimmt, muss aber im
konkreten Fall hinterfragt und diskutiert werden!

### Beispiel von oben

```java
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

*   BEC: 1 (nur ein boolescher Ausdruck im `if`)
*   McCabe: 3 (es gibt zwei mögliche Verzweigungen in der Methode plus die Methode selbst)
*   DAC: 1 (eine "Fremdklasse": `String`)
:::::::::

[[Beispiel: Metriken an MyWuppieStudi#getMyWuppieStudi]{.bsp}]{.slides}

\bigskip

=> Verweis auf LV Softwareengineering


## Tool-Support: Checkstyle

::::::::: notes
Metriken und die Einhaltung von Coding-Conventions werden sinnvollerweise nicht manuell,
sondern durch diverse Tools erfasst, etwa im Java-Bereich mit Hilfe von
[**Checkstyle**](https://github.com/checkstyle).

Das Tool lässt sich [Standalone über CLI](https://checkstyle.org/cmdline.html) nutzen
oder als Plugin für IDE's ([Eclipse](https://checkstyle.org/eclipse-cs) oder
[IntelliJ](https://github.com/jshiell/checkstyle-idea)) einsetzen. Gradle bringt ein
eigenes [Plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html) mit.
:::::::::

*   IDE: diverse [Plugins](https://checkstyle.org/index.html#Related_Tools):
    [Eclipse-CS](https://checkstyle.org/eclipse-cs),
    [CheckStyle-IDEA](https://github.com/jshiell/checkstyle-idea)

*   [CLI](https://checkstyle.org/cmdline.html):
    `java -jar checkstyle-10.2-all.jar -c google_checks.xml *.java`

*   [Plugin "checkstyle"](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)
    in Gradle:

    ```{.groovy size="scriptsize"}
    plugins {
        id "java"
        id "checkstyle"
    }

    checkstyle {
        configFile file('checkstyle.xml')
        toolVersion '10.2'
    }
    ```

    *   Aufruf: `./gradlew checkstyleMain` (Teil von `./gradlew check`)
    *   Konfiguration: `<projectDir>/config/checkstyle/checkstyle.xml` (Default)
        [bzw. mit der obigen Konfiguration direkt im Projektordner]{.notes}
    *   Report: `<projectDir>/build/reports/checkstyle/main.html`

<!-- Für die Demo:
docker pull gradle
docker run --rm -it  -v "$PWD":/data -w /data  --entrypoint "bash"  gradle
-->

[Demo: IntelliJ, [Checkstyle/Gradle](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/coding/src/checkstyle/)]{.bsp}


## Checkstyle: Konfiguration

::::::::: notes
Die auszuführenden Checks lassen sich über eine [XML-Datei](https://checkstyle.org/config.html)
konfigurieren. In [Eclipse-CS](https://checkstyle.org/eclipse-cs) kann man die Konfiguration
auch in einer GUI bearbeiten.

Das Checkstyle-Projekt stellt eine passende Konfiguration für den
[Google Java Style](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
bereit. Diese ist auch in den entsprechenden Plugins oft bereits enthalten und kann direkt
ausgewählt oder als Startpunkt für eigene Konfigurationen genutzt werden.

Der Startpunkt für die Konfigurationsdatei ist immer das Modul "Checker". Darin können sich
"FileSetChecks" (Module, die auf einer Menge von Dateien Checks ausführen), "Filters" (Module,
die Events bei der Prüfung von Regeln filtern) und "AuditListeners" (Module, die akzeptierte
Events in einen Report überführen) befinden. Der "TreeWalker" ist mit der wichtigste Vertreter
der FileSetChecks-Module und transformiert die zu prüfenden Java-Sourcen in einen
_Abstract Syntax Tree_, also eine Baumstruktur, die dem jeweiligen Code unter der Java-Grammatik
entspricht. Darauf können dann wiederum die meisten Low-Level-Module arbeiten.

Die [Standard-Checks](https://checkstyle.org/checks.html) sind bereits in Checkstyle implementiert
und benötigen keine weitere externe Abhängigkeiten. Die einzelnen Checks werden in der Regel als
"Modul" dem "TreeWalker" hinzugefügt und über die jeweiligen Properties näher konfiguriert. Sie
finden in der [Doku](https://checkstyle.org/checks.html) zu jedem Check das entsprechende Modul,
das Eltern-Modul (also wo müssen Sie das Modul im XML-Baum einfügen) und auch die möglichen
Properties und deren Default-Einstellungen.
:::::::::

```{.xml size="scriptsize"}
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

::: notes
Alternativen/Ergänzungen: [MetricsReloaded](https://github.com/BasLeijdekkers/MetricsReloaded).
:::

[Demo: Konfiguration mit Eclipse-CS, Hinweis auf Formatter]{.bsp}


## SpotBugs: Finde Anti-Pattern und potentielle Bugs (Linter)


<!-- TODO
https://github.com/spotbugs/spotbugs
[FindBugs/SpotBugs](https://github.com/spotbugs/spotbugs)

- Ziel: prüfen
- Überblick "Bugs" (evtl. am Beispiel?)
- Demo: Gradle

```
plugins {
    id "java"
    id "com.github.spotbugs" version "5.0.6"
}
spotbugs {
    ignoreFailures = true
    showStackTraces = false
}
spotbugsMain {
    reports {
        html {
            required = true
            outputLocation = file("$buildDir/reports/spotbugs.html")
        }
    }
}
```
-->

[SpotBugs](https://github.com/spotbugs/spotbugs), ...


CLI: `java -jar spotbugs.jar options ...`
[IntelliJ SpotBugs plugin](https://github.com/JetBrains/spotbugs-intellij-plugin)
[SpotBugs Eclipse plugin](https://spotbugs.readthedocs.io/en/latest/eclipse.html)
[SpotBugs Gradle Plugin](https://github.com/spotbugs/spotbugs-gradle-plugin)

`./gradlew spotbugsMain` (in `./gradlew check`)



<!-- Für die Demo:
docker pull gradle
docker run --rm -it  -v "$PWD":/data -w /data  --entrypoint "bash"  gradle
-->

[Demo: [SpotBugs/Gradle](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/coding/src/spotbugs/)]{.bsp}


## Konfiguration für das PM-Praktikum (Format, Metriken, Checkstyle, SpotBugs)

::: notes
Im PM-Praktikum beachten wir die obigen Coding Conventions und Metriken mit den dort definierten
Grenzwerten. Diese sind bereits in der Minimal-Konfiguration für Checkstyle (s.u.) konfiguriert.
:::

### Formatierung

*   Google Java Style/AOSP-Style: **Spotless**

::: notes
Zusätzlich wenden wir den [Google Java Style](https://google.github.io/styleguide/javaguide.html)
an. Statt der dort vorgeschriebenen Einrückung mit 2 Leerzeichen (und 4+ Leerzeichen bei Zeilenumbruch
in einem Statement) können Sie auch mit 4 Leerzeichen einrücken (8 Leerzeichen bei Zeilenumbruch)
([AOSP-Style](https://source.android.com/setup/contribute/code-style)). Halten Sie sich in Ihrem
Team an eine einheitliche Einrückung.

Formatieren Sie Ihren Code vor den Commits mit **Spotless** (über Gradle) oder stellen Sie den
Formatter Ihrer IDE entsprechend ein.
:::

### Checkstyle

*   Minimal-Konfiguration für **Checkstyle** (Coding Conventions, Metriken)

::: notes
Nutzen Sie die folgende **Minimal-Konfiguration** für **Checkstyle** für Ihre
Praktikumsaufgaben. Diese beinhaltet die Prüfung der wichtigsten Formate nach
Google Java Style/AOSP-Style sowie der obigen Metriken. Halten Sie diese Regeln
ein.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN" "https://checkstyle.org/dtds/configuration_1_3.dtd">

<module name="Checker">
  <property name="severity" value="warning"/>
  <module name="TreeWalker">
    <module name="AvoidStarImport"/>
    <module name="BooleanExpressionComplexity"/>
    <module name="JavaNCSS">
      <property name="methodMaximum" value="40"/>
      <property name="classMaximum" value="250"/>
      <property name="fileMaximum" value="300"/>
    </module>
    <module name="ClassDataAbstractionCoupling">
      <property name="max" value="6"/>
    </module>
    <module name="CyclomaticComplexity">
      <property name="max" value="7"/>
    </module>
    <module name="Indentation">
      <property name="basicOffset" value="4"/>
      <property name="lineWrappingIndentation" value="8"/>
      <property name="caseIndent" value="4"/>
      <property name="throwsIndent" value="4"/>
      <property name="arrayInitIndent" value="4"/>
    </module>
    <module name="MethodCount">
      <property name="maxTotal" value="10"/>
      <property name="maxPrivate" value="10"/>
      <property name="maxPackage" value="10"/>
      <property name="maxProtected" value="10"/>
      <property name="maxPublic" value="10"/>
    </module>
    <module name="MethodLength">
      <property name="max" value="40"/>
    </module>
    <module name="ParameterNumber">
      <property name="max" value="3"/>
    </module>
    <module name="MissingOverride"/>
    <module name="MissingJavadocMethod"/>
    <module name="ParameterName"/>
    <module name="ConstantName"/>
    <module name="MemberName"/>
    <module name="MethodName"/>
    <module name="TypeName"/>
    <module name="OneStatementPerLine"/>
    <module name="MultipleVariableDeclarations"/>
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

Sie können diese Basis-Einstellungen auch aus dem PM-Dungeon/PM-Lecture-Repo direkt herunterladen:
[checkstyle.xml](https://github.com/PM-Dungeon/PM-Lecture/tree/master/markdown/coding/src/checkstyle.xml).

Sie können zusätzlich gern noch die weiteren (und strengeren) Regeln aus der vom Checkstyle-Projekt
bereitgestellten Konfigurationsdatei für den
[Google Java Style](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
nutzen. _Hinweis_: Einige der dort konfigurierten Checkstyle-Regeln gehen allerdings über den
Google Java Style hinaus.
:::

### Linter: SpotBugs

*   Vermeiden von Anti-Pattern mit **SpotBugs**

::: notes
Setzen Sie zusätzlich **SpotBugs** mit ein. Ihre Lösungen dürfen keine Warnungen oder
Fehler beinhalten, die SpotBugs melden würde.
:::


## Wrap-Up

*   Code entsteht nicht zum Selbstzweck => Regeln nötig!
    *   Coding Conventions

        ::: notes
        *   Regeln zu Schreibweisen und Layout
        *   Leerzeichen, Einrückung, Klammern
        *   Zeilenlänge, Umbrüche
        *   Kommentare
        :::

    *   Formatieren mit **Spotless**

    *   Prinzipien des objektorientierten Programmierens

        ::: notes
        *   Jede Klasse ist für genau **einen** Aspekt des Systems verantwortlich.
            (_Single Responsibility_)
        *   Keine Code-Duplizierung! (_DRY_ - Don't repeat yourself)
        *   Klassen und Methoden sollten sich erwartungsgemäß verhalten
        *   Kapselung: Möglichst wenig öffentlich zugänglich machen
        :::

\bigskip

*   Metriken: Einhaltung von Regeln in Zahlen ausdrücken
*   Prüfung manuell durch Code Reviews oder durch Tools wie **Checkstyle** oder **SpotBugs**
*   Definition des "PM-Styles" (siehe Folie "Konfiguration für das PM-Praktikum")







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
