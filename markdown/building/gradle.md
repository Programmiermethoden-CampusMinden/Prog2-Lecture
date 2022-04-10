---
type: lecture-cg
title: "Build-Systeme: Gradle"
menuTitle: "Gradle"
author: "Carsten Gips (FH Bielefeld)"
weight: 3
readings:
  - key: "Gradle"
  - key: "Ullenboom2016"
  - key: "Inden2013"
tldr: |
  TODO

  *   Automatisieren von Arbeitabläufen
  *   Einstieg in Gradle

outcomes:
  - k3: "Schreiben und Verstehen einfacher Gradle-Skripte"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1062993&client_id=FH-Bielefeld"
    name: "Quiz Gradle (ILIAS)"
assignments:
  - topic: sheet01
youtube:
  - link: ""
    name: "VL "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL "
sketch: true
---


## Gradle: Eine DSL in Groovy

[DSL: _Domain Specific Language_]{.notes}

\bigskip

```{.groovy size="footnotesize"}
// build.gradle
plugins {
    id 'java'
    id 'application'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'junit:junit:4.13.2'
}

application {
    mainClass = 'fluppie.App'
}
```

::: notes
Dies ist mit die einfachste Build-Datei für Gradle.

Über Plugins wird die Unterstützung für Java und das Bauen von Applikationen aktiviert,
d.h. es stehen darüber entsprechende spezifische Tasks zur Verfügung.

Abhängigkeiten sollen hier aus dem Maven-Repository [MavenCentral](https://mvnrepository.com/repos/central)
geladen werden. Zusätzlich wird hier als Abhängigkeit für den Test (`testImplementation`)
die JUnit-Bibliothek in einer Maven-artigen Notation angegeben (vgl.
[mvnrepository.com](https://mvnrepository.com/)). (Für nur zur Übersetzung der Applikation
benötigte Bibliotheken verwendet man stattdessen das Schlüsselwort `implementation`.)

Bei der Initialisierung wurde als Package `fluppie` angegeben. Gradle legt darunter per
Default die Klasse `App` mit einer `main()`-Methode an. Entsprechend kann man über den
Eintrag `application` den Einsprungpunkt in die Applikation konfigurieren.
:::


:::::::::  notes

## Gradle-DSL

<!-- Für die Demos:
docker pull gradle
docker run --rm -it  -v "$PWD":/data -w /data  --entrypoint "bash"  gradle
docker run --rm -it  -v "$PWD":/data -w /data  -u "$(id -u):$(id -g)"  --entrypoint "bash"  gradle
-->

Ein Gradle-Skript ist letztlich ein in Groovy geschriebenes Skript.
[Groovy](https://groovy-lang.org/) ist eine auf Java basierende und auf
der JVM ausgeführte Skriptsprache. Seit einigen Versionen kann man die
Gradle-Build-Skripte auch in der Sprache Kotlin schreiben.


## Dateien

Für das Bauen mit Gradle benötigt man drei Dateien im Projektordner:

*   `build.gradle`: Die auf der Gradle-DSL beruhende Definition des Builds
    mit den Tasks (und ggf. Abhängigkeiten) eines Projekts.

    Ein Multiprojekt hat pro Projekt eine solche Build-Datei. Dabei können
    die Unterprojekte Eigenschaften der Eltern-Buildskripte "erben" und so
    relativ kurz ausfallen.

*   `settings.gradle`: Eine optionale Datei, in der man beispielsweise den
    Projektnamen oder bei einem Multiprojekt die relevanten Unterprojekte
    festlegt.

*   `gradle.properties`: Eine weitere optionale Datei, in der projektspezifische
    Properties für den Gradle-Build spezifizieren kann.


## Gradle Init

Um eine neue Gradle-Konfiguration anlegen zu lassen, geht man in einen Ordner
und führt darin `gradle init` aus. Gradle fragt der Reihe nach einige Einstellungen
ab:

```
$ gradle init

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 3

Split functionality across multiple subprojects?:
  1: no - only one application project
  2: yes - application and library projects
Enter selection (default: no - only one application project) [1..2] 1

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 1

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit Jupiter) [1..4] 1

Project name (default: tmp): wuppie
Source package (default: tmp): fluppie
```

Typischerweise möchte man eine Applikation bauen (Auswahl 2 bei der ersten Frage).
Als nächstes wird nach der Sprache des Projekts gefragt sowie nach der Sprache für
das Gradle-Build-Skript (Default ist Groovy) sowie nach dem Testframework, welches
verwendet werden soll.

Damit wird die eingangs gezeigte Konfiguration angelegt.


## Ordner

Durch `gradle init` wird ein neuer Ordner `wuppie/` mit folgender Ordnerstruktur
angelegt:

```
drwxr-xr-x 4 cagix cagix 4096 Apr  8 11:43 ./
drwxrwxrwt 1 cagix cagix 4096 Apr  8 11:43 ../
-rw-r--r-- 1 cagix cagix  154 Apr  8 11:43 .gitattributes
-rw-r--r-- 1 cagix cagix  103 Apr  8 11:43 .gitignore
drwxr-xr-x 3 cagix cagix 4096 Apr  8 11:43 app/
drwxr-xr-x 3 cagix cagix 4096 Apr  8 11:42 gradle/
-rwxr-xr-x 1 cagix cagix 8070 Apr  8 11:42 gradlew*
-rw-r--r-- 1 cagix cagix 2763 Apr  8 11:42 gradlew.bat
-rw-r--r-- 1 cagix cagix  370 Apr  8 11:43 settings.gradle
```

Es werden Einstellungen für Git erzeugt (`.gitattributes` und
`.gitignore`).

Im Ordner `gradle/` wird der Gradle-Wrapper abgelegt (s.u.). Dieser
Ordner wird normalerweise mit ins Repo eingecheckt. Die Skripte
`gradlew` und `gradlew.bat` sind die Startskripte für den Gradle-Wrapper
(s.u.) und werden normalerweise ebenfalls ins Repo mit eingecheckt.

Der Ordner `.gradle/` (erscheint ggf. nach dem ersten Lauf von Gradle
auf dem neuen Projekt) ist nur ein Hilfsordner ("Cache") von Gradle.
Hier werden heruntergeladene Dateien etc. abgelegt. Dieser Order
sollte **nicht** ins Repo eingecheckt werden und ist deshalb auch
per Default im generierten `.gitignore` enthalten. (Zusätzlich gibt es
im User-Verzeichnis auch noch einen Ordner `.gradle/` mit einem globalen
Cache.)

In `settings.gradle` finden sich weitere Einstellungen. Die eigentliche
Gradle-Konfiguration befindet sich zusammen mit dem eigentlichen Projekt
im Unterordner `app/`:

```
drwxr-xr-x 4 root root 4096 Apr  8 11:50 ./
drwxr-xr-x 5 root root 4096 Apr  8 11:49 ../
drwxr-xr-x 5 root root 4096 Apr  8 11:50 build/
-rw-r--r-- 1 root root  852 Apr  8 11:43 build.gradle
drwxr-xr-x 4 root root 4096 Apr  8 11:43 src/
```

Die Datei `build.gradle` ist die durch `gradle init` erzeugte (und
eingangs gezeigte) Konfigurationsdatei, vergleichbar mit `build.xml`
für Ant oder `pom.xml` für Maven. Im Unterordner `build/` werden die
generierten `.class`-Dateien etc. beim Build-Prozess abgelegt.

Unter `src/` findet sich dann eine Maven-typische Ordnerstruktur
für die Sourcen:

```
$ tree src/
src/
|-- main
|   |-- java
|   |   `-- fluppie
|   |       `-- App.java
|   `-- resources
`-- test
    |-- java
    |   `-- fluppie
    |       `-- AppTest.java
    `-- resources
```

Unterhalb von `src/` ist ein Ordner `main/` für die Quellen der Applikation (Sourcen
und Ressourcen). Für jede Sprache gibt es einen eigenen Unterordner, hier entsprechend
`java/`. Unterhalb diesem folgt dann die bei der Initialisierung angelegte Package-Struktur
(hier `fluppie` mit der Default-Main-Klasse `App` mit einer `main()`-Methode). Diese
Strukturen wiederholen sich für die Tests unterhalb von `src/test/`.

Wer die herkömmlichen, deutlich flacheren Strukturen bevorzugt, also unterhalb von `src/`
direkt die Java-Package-Strukturen für die Sourcen der Applikation und unterhalb von `test/`
entsprechend die Strukturen für die JUnit-Test, der kann dies im Build-Skript einstellen:

```groovy
sourceSets {
    main {
        java {
            srcDirs = ['src']
        }
        resources {
            srcDirs = ['res']
        }
    test {
        java {
            srcDirs = ['test']
        }
    }
}
```

## Ablauf eines Gradle-Builds

Ein Gradle-Build hat zwei Hauptphasen: Konfiguration und Ausführung.

Während der Konfiguration wird das gesamte Skript durchlaufen (vgl. Ausführung
der direkten Anweisungen eines Tasks). Dabei wird ein Graph erzeugt: welche
Tasks hängen von welchen anderen ab etc.

Anschließend wird der gewünschte Task ausgeführt. Dabei werden zuerst alle
Tasks ausgeführt, die im Graphen auf dem Weg zu dem gewünschten Task liegen.

Mit `gradle tasks` kann man sich die zur Verfügung stehenden Tasks ansehen.
Diese sind der Übersicht halber noch nach "Themen" sortiert.

Für eine Java-Applikation sind die typischen Tasks `gradle build` zum Bauen der
Applikation (inkl. Ausführen der Tests) sowie `gradle run` zum Starten der Anwendung.
Wer nur die Java-Sourcen compilieren will, würde den Task `gradle compileJava` nutzen.
Mit `gradle check` würde man compilieren und die Tests ausführen sowie weitere Checks
durchführen (`gradle test` würde nur compilieren und die Tests ausführen), mit `gradle jar`
die Anwendung in ein `.jar`-File packen und mit `gradle javadoc` die Javadoc-Dokumentation
erzeugen und mit `gradle clean` die generierten Hilfsdateien aufräumen (löschen).

Vergleiche auch
["Getting Started"](https://docs.gradle.org/current/userguide/getting_started.html),
["Building Java Applications Sample"](https://docs.gradle.org/current/samples/sample_building_java_applications.html),
["Building Java Applications with libraries Sample"](https://docs.gradle.org/current/samples/sample_building_java_applications_multi_project.html),
["Building Java Libraries Sample"](https://docs.gradle.org/current/samples/sample_building_java_libraries.html)
und
["Building Java & JVM projects"](https://docs.gradle.org/current/userguide/building_java_projects.html).


## Plugin-Architektur

Für bestimmte Projekttypen gibt es immer wieder die gleichen Aufgaben. Um hier
Schreibaufwand zu sparen, existieren verschiedene Plugins für verschiedene
Projekttypen. In diesen Plugins sind die entsprechenden Tasks bereits mit den
jeweiligen Abhängigkeiten formuliert. Diese Idee stammt aus Maven, wo dies
für Java-basierte Projekte umgesetzt ist.

Beispielsweise erhält man über das Plugin `java` den Task `clean` zum Löschen
aller generierten Build-Artefakte, den Task `classes`, der die Sourcen zu
`.class`-Dateien kompiliert oder den Task `test`, der die JUnit-Tests
ausführt ...

Sie können sich Plugins und weitere Tasks relativ leicht auch selbst definieren.


## Auflösen von Abhängigkeiten

Analog zu Maven kann man Abhängigkeiten (etwa in einer bestimmten Version
benötigte Bibliotheken) im Gradle-Skript angeben. Diese werden (transparent für
den User) von einer ebenfalls angegeben Quelle, etwa einem Maven-Repository,
heruntergeladen und für den Build genutzt. Man muss also nicht mehr die
benötigten `.jar`-Dateien der Bibliotheken mit ins Projekt einchecken.
Analog zu Maven können erzeugte Artefakte automatisch publiziert werden, etwa
in einem Maven-Repository.

Für das Projekt benötigte Abhängigkeiten kann man über den Eintrag `dependencies`
spezifizieren. Dabei unterscheidet man u.a. zwischen Applikation und Tests:
`implementation` und `testImplementation` für das Compilieren und Ausführen von
Applikation bzw. Tests. Diese Abhängigkeiten werden durch Gradle über die im
Abschnitt `repositories` konfigurierten Repositories aufgelöst und die entsprechenden
`.jar`-Files geladen (in den `.gradle/`-Ordner).

Typische Repos sind das Maven-Repo selbst (`mavenCentral()`) oder das Google-Maven-Repo
(`google()`).

Die Einträge in `dependencies` erfolgen dabei in einer Maven-Notation, die Sie
auch im Maven-Repo [mvnrepository.com](https://mvnrepository.com/) finden.


## Beispiel mit weiteren Konfigurationen (u.a. Checkstyle und Javadoc)

```groovy
plugins {
    id 'java'
    id 'application'
    id 'checkstyle'
}


repositories {
    mavenCentral()
}

application {
    mainClass = 'hangman.Main'
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

run {
    standardInput = System.in
}

sourceSets {
    main {
        java {
            srcDirs = ['src']
        }
        resources {
            srcDirs = ['res']
        }
    }
}

checkstyle {
    configFile = file(“${rootDir}/google_checks.xml”)
    toolVersion = '8.32'
}

dependencies {
    implementation group: 'org.apache.poi', name: 'poi', version: '4.1.2'
}

javadoc {
    options.showAll()
}
```

Hier sehen Sie übrigens noch eine weitere mögliche Schreibweise für das Notieren
von Abhängigkeiten: "`implementation group: 'org.apache.poi', name: 'poi', version: '4.1.2'`"
und "`implementation 'org.apache.poi:poi:4.1.2'`" sind gleichwertig, wobei die letztere
Schreibweise sowohl in den generierten Builds-Skripten und in der offiziellen Dokumentation
bevorzugt wird.


## Gradle und Ant (und Maven)

Vorhandene Ant-Buildskripte kann man nach Gradle importieren und ausführen
lassen. Über die DSL kann man auch direkt Ant-Tasks aufrufen. Siehe auch
["Using Ant from Gradle"](https://docs.gradle.org/current/userguide/ant.html).


## Gradle-Wrapper

Zur Ausführung von Gradle-Skripten benötigt man eine lokale Gradle-Installation.
Diese sollte für i.d.R. alle User, die das Projekt bauen wollen, identisch sein.
Leider ist dies oft nicht gegeben bzw. nicht einfach lösbar.

Zur Vereinfachung gibt es den Gradle-Wrapper `gradlew` (bzw. `gradlew.bat` für Windows).
Dies ist ein kleines Shellskript, welches zusammen mit einigen kleinen `.jar`-Dateien im
Unterordner `gradle/` mit ins Repo eingecheckt wird und welches direkt die Rolle des
`gradle`-Befehls einer Gradle-Installation übernehmen kann. Man kann also in Konfigurationskripten,
beispielsweise für Gitlab CI, alle Aufrufe von `gradle` durch Aufrufe von `gradlew` ersetzen.

Beim ersten Aufruf lädt `gradlew` dann die spezifizierte Gradle-Version herunter und speichert
diese in einem lokalen Ordner `.gradle/`. Ab dann greift `gradlew` auf diese lokale (nicht
"installierte") `gradle`-Version zurück.

`gradle init` erzeugt den Wrapper automatisch in der verwendeten Gradle-Version mit.
Alternativ kann man den Wrapper nachträglich über `gradle wrapper --gradle-version 6.5`
in einer bestimmten (gewünschten) Version anlegen lassen.

Da der Gradle-Wrapper im Repository eingecheckt ist, benutzen alle Entwickler damit
automatisch die selbe Version, ohne diese auf ihrem System zuvor installieren zu müssen.
Deshalb ist der Einsatz des Wrappers einem fest installierten Gradle vorzuziehen!

:::::::::

[[Live-Demo Gradle/Gradlew]{.bsp}]{.notes}


## Wrap-Up

*   Automatisieren von Arbeitsabläufen mit Build-Tools/-Skripten
*   Einstieg in **Gradle** (DSL zur Konfiguration)







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
