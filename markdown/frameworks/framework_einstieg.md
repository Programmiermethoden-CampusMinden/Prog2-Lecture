---
type: lecture-cg
title: "Frameworks: Einstieg"
menuTitle: "Frameworks"
author: "André Matutat (FH Bielefeld)"
weight: 1
readings:
  - key: ""
tldr: |
  Frameworks sind ein Softwaregerüst, um wiederkehrende Softwarestrukturen schnell und einfach um die eigene Funktionalität zu erweitern.
  Im Gegensatz zu Libraries stellen sie keine einzelnen Funktionen bereits, die im eigene Code aufgerufen werden, sondern geben Strukturen vor, in denen der eigenen Code eingearbeitet werden muss.
outcomes:
  - k1: "Begriff Framework kennen gelernt"
  - k2: "Unterschied zwischen Frameworks und Libraries verstehen"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
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


## Motivation

Neben der eigentlichen Funktionalität werden an Softwareprodukte viele weitere Randbindungen gestellt.
Dies können Sicherheitsbindungen sein oder Anforderungen an die Art und Weise der Bereitstellung des Produktes, zum Beispiel als Webservice.
Viele dieser Anforderungen ähneln sich von Produkt zu Produkt und müssen dennoch immer wieder neu programmiert werden.

Für einen Webservice muss eine HTML-Schnittstelle bereitgestellt werden, die Anfragen annimmt, bearbeitet und die Antworten wieder zurückliefert.

## Was sind Frameworks?

Frameworks liefern die Rahmenstruktur und Architektur, um Programme für die verschiedenen Anwendungszwecke einfacher und effizient zu entwickeln. Sie legen dabei fest, WIE programmiert werden soll.

Frameworks stellen Code bereit, der an entsprechenden Stellen mit eigenen Klassen und Funktionen erweitert werden muss, um die eigentliche Funktion der Anwendung zu implementieren, sind dabei aber selbst keine eigenen Programme (vgl. PM-Dungeon).

Frameworks sind die Lückentexte der Programmierung. <!-- //Ich finde die Analogie eigentlich nicht schlecht, aber die muss besser eingebunden werden-->


## Unterschied zu Libraries

- Libraries stellen Funktionen bereit, die frei in der eigenen Implementierung genutzt werden können.
- Beispiele für Libraries
  - Auswerten von regulären Ausdrücken
  - Verwenden von Netzwerkprotokollen
  - Komplexe mathematischen Funktionen

- Frameworks geben eine Implementierung vor, die mit eigenen Verhalten erweitert werden kann/muss.
- Beispiele für Frameworks
  - Web Anwendungssysteme
  - GUI-Systeme
  - Testen von Software


![Unterschied zwischen Frameworks und Libraries grafisch veranschaulicht.](/images/frameworksVSlib.png)


## Verbreitete Frameworks

<!-- // Frage: Wie ausführlich den Anwendungszweck erklären? Teilweise ist das schon sehr spezifisch und für Einsteiger könnte es ein großes Buzzword Bingo werden. -->
| Framework | Anwendungszweck |
| --------- | --------------- |
| JUnit     | Testen von Software|
| Play      | Web Anwendungen |
| Spring    | Web Anwendungen und Enterprise Java-Applications|
| Hybernate | Datenbanken Anbindungen und Kommunikation    |
| libGDX    | Game Development|


## Vor- und Nachteile

<!-- Formatierung dieses Kaptitel? -->
+ Ermöglichen eine schnelle Implementierung umfangreicher Softwarekonstrukte
+ "Erzwingen" das Einhalten eines bestimmen Qualitätsstandards
+ Große Communitys
+/- Verstecken komplexe Zusammenhänge vor den Entwicklern
- Oftmals sehr umfangreich und schwer zu erlernen
- Fokus oft nicht mehr nur auf einem Anwendungsbereich (z.B Spring)
- Schließen sich oft gegenseitig aus
- Nicht alles, was sich Framework nennt, ist auch wirklich eins.
- Hype-Gefahr: Frameworks werden stark angepriesen, um dann fallen gelassen zu werden


## Wann sollte man Frameworks verwenden

- Wenn man bereits etablierte Anwendungen (wie Webservices) mit eigener Funktionalität anbieten möchte.

## Wie findet man ein passendes Framework

- Internetrecherche
- Foren
- GitHub/Open-Source-Projekte


## Wie starte ich mit einem Framework?

1. Webseite des Frameworks besuchen und prüfen, ob es für die eigenen Zwecke geeignet ist.
   - Beschreibung auf der Webseite analysieren.
   - Dokumentation überfliegen.
   - Beispielprojekte anschauen.
2. Hello World programmieren. <!-- https://javalin.io/tutorials/gradle-setup -->
3. Schrittweises erweitern der Startanwendung, bis ein Verständnis für das Framework erlangt wurde (mwe).

**Frameworks müssen gelernt werden.**

## Beispiel

Problem: Es soll eine interne Webanwendung bereitgestellt werden, die bei jedem Aufruf eine zufällige Zahl zurückgibt.

- Für Webanwendungen gibt es eine Vielzahl an Frameworks. Für dieses kleine Problem ist ein einfaches und schlankes Framework zu bevorzugen.
 <!-- Jetzt die Schritte 1 und 2 live vorführen -->
1. Das Framework [Javalin](https://javalin.io/) wirbt mit einer einfachen und schnellen Handhabung.
   - Die [Dokumentation](https://javalin.io/documentation) gibt bereits einen guten Einblick.
  => Javalin ist für das Problem gut geeignet.
2. [Javalin-Hello-World](https://javalin.io/tutorials/gradle-setup)  <!-- In der doc fehlt:  implementation 'org.slf4j:slf4j-simple:1.8.0-beta4' siehe src/javalin/JavalinHelloWorld -->
3. Anwendung erweitern. <!-- siehe /src/javalin/JavalinRandomNumber -->


## Wrap-Up

- Frameworks stellen einen Rahmen und eine Architektur für wiederkehrende Softwarestrukturen bereit.
- Frameworks sind keine Libraries.

<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
