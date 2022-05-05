---
type: lecture-cg
title: "Note und Credits"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
hidden: true
---


## Prüfungsform: Performanzprüfung, 7 ECTS

::: notes
Die Performanzprüfung besteht aus **zwei Teilprüfungen**, die Sie unabhängig voneinander
absolvieren können: der **praktischen Teilleistung** und der **theoretischen Teilleistung**.

Dies sind zwei getrennte Prüfungsleistungen, für die Sie sich **jeweils separat im LSF**
anmelden müssen. Sie bekommen als Note für das Modul den gewichteten Mittelwert aus den
beiden Teilleistungen.

Diese Prüfungsform gilt automatisch für alle Studierenden in Programmiermethoden, die nicht
bereits früher unter einer anderen Prüfungsform in Programmiermethoden eine Prüfungsleistung
abgelegt oder begonnen haben (vgl. auch "Regelung für Wiederholer").
:::


### 1. Praktische Teilleistung

::: notes
Diese Prüfungsleistung absolvieren Sie im Praktikum. Es wird in diesem Semester zwei
verschiedene Typen von Aufgaben geben mit unterschiedlicher Gewichtung und Bearbeitung:
:::

1.  `[Pool "Dungeon"]({{< ref "/assignments/pool_dungeon" >}})`{=markdown} mit max. 125 Punkten (mind. 50 Punkte zum Bestehen)
    *   `[Gruppe A "Basics"]({{< ref "/assignments/pool_dungeon/group_a" >}})`{=markdown} (43 P)
    *   `[Gruppe B "Monster und Kampf"]({{< ref "/assignments/pool_dungeon/group_b" >}})`{=markdown} (37 P)
    *   `[Gruppe C "Items, Aufbewahrung und Handel"]({{< ref "/assignments/pool_dungeon/group_c" >}})`{=markdown} (45 P)
2.  `[Pool "Konzept"]({{< ref "/assignments/pool_concept" >}})`{=markdown} mit max. 100 Punkten (mind. 50 Punkte zum Bestehen)

Sie können sich zusätzliche Bonus-Punkte verdienen, wenn Sie am Dungeon-Framework mitarbeiten (siehe unten "Bonus-Punkte: Helfen im Framework").

::: notes
#### Bearbeitung

Für die Aufgaben aus dem Dungeon-Pool können Sie sich den Zeitpunkt der Bearbeitung
relativ frei auswählen; natürlich hängen aber bestimmte Aufgaben von anderen Aufgaben
ab.

Für die Aufgaben im Konzept-Pool ist dagegen jeweils eine feste Deadline angegeben, zu
der die Lösung erarbeitet, in Ihr Repo hochgeladen und im Praktikum vorgestellt werden
muss.

#### Workload

Pro **Woche** sollen Sie aus dem **Dungeon-Pool** selbst gewählte Aufgaben für **10 Punkte**
bearbeiten. Sie können auch mehr machen, aber wir limitieren die maximal erreichbare
Punkteanzahl hier auf _15 Punkte pro Woche_.

Parallel zum Dungeon-Pool bearbeiten Sie **jede Woche** ein **vorgegebenes Aufgabenblatt**
aus dem **Konzept-Pool** für je 10 Punkte.

#### Praktische Teilnote
:::

*   225P Gesamt, 50P Puffer => “Krankheitsregelung”, 175P == 100%
*   4.0: ab 60% v. 175P (105P), alle 4% nächste Teilnote, 1.0: ab 96% v. 175P (168P)

::: notes
Sie können in Summe maximal 225 Punkte erreichen. Die 100% für die Notenberechnung wird
auf 175 Punkte festgelegt. Damit haben Sie 50 Punkte Schlupf, falls Sie einmal erkranken
oder wegen anderer familiärer Angelegenheiten nicht zur Vorstellung Ihrer Lösung im Praktikum
erscheinen können.

**Achtung**: Sie müssen im Laufe des Semesters in **jedem Pool** die jeweils angegebene
Mindestanzahl der Punkte zum Bestehen erreichen, sonst haben Sie die praktische Teilleistung
insgesamt nicht bestanden.

Beachten Sie zusätzlich die "Hinweise zum Praktikum" (s.u.), die sich auf die Inhalte und die
formalen Aspekte Ihrer Abgaben beziehen.
:::


### 2. Theoretische Teilleistung

*   Erster Prüfungszeitraum: 2x digitale Prüfung: 1x im Semester ("E-Assessment") plus 1x in erster Prüfungsphase
*   Zweiter Prüfungszeitraum: _Eine_ digitale Klausur

::: notes
Die Prüfung für die theoretische Teilleistung wird als digitale Klausur über eine
spezielle ILIAS-Instanz ("E-Assessment-Server") durchgeführt.

Im ersten Prüfungszeitraum besteht die theoretische Prüfung aus zwei kürzeren Teilprüfungen
("E-Assessments") mit je 45 Minuten Dauer, die einmal etwa in der Mitte der Vorlesungszeit
und einmal in der ersten Prüfungsphase angeboten werden. Die Note ergibt sich dabei aus dem
Mittelwert der beiden Teilprüfungen.

Im zweiten Prüfungszeitraum besteht die theoretische Prüfung aus einer digitalen Klausur mit
90 Minuten Dauer.

Es wird jeweils rechtzeitig bekanntgegeben, ob die Prüfungen wie bisher im Home-Office durchgeführt
werden oder ob dafür Rechner der FH genutzt werden, d.h. eine Anwesenheit in den Räumen der FH am
Campus Minden notwendig ist. Die Termine in den Prüfungszeiträumen werden rechtzeitig vom Prüfungsamt
bekannt gegeben, für den Termin in der Vorlesungszeit siehe `[Fahrplan]({{< ref "/org/schedule" >}})`{=markdown}.
:::


### 3. Gesamtnote: Gewichteter Mittelwert der beiden Teilleistungen

**50% Praxis, 50% Theorie**

[[Hinweis Abgabeslots, Präsenz/Online]{.bsp}]{.slides}


## Hinweise zum Praktikum

### Bearbeitung, Teams

Sie bearbeiten alle Aufgaben in festen Teams zu je **drei Personen**. Jedes Team erarbeitet seine
**eigene** Lösung.

Wer Lösungen ganz oder teilweise von anderen Teams/Studierenden oder anderen Quellen übernimmt
und als eigene Lösung ab-/ausgibt, begeht einen Täuschungsversuch mit entsprechenden Konsequenzen
im Prüfungsverfahren.

### Abgabe per Git-Repo und Vorstellung im Praktikum

Das `[erste Blatt]({{< ref "sheet01" >}})`{=markdown} ist im
[ILIAS](https://www.fh-bielefeld.de/elearning/goto.php?target=exc_1037695&client_id=FH-Bielefeld)
abzugeben. Die Abgabe der anderen Aufgaben erfolgt über einen Pull- bzw. Merge-Request
in Ihrem nicht öffentlich sichtbaren Git-Repo, welches Sie sich zu Beginn des Semesters
einrichten. Dazu benötigen Sie entweder einen kostenfreien und ggf. anonymen GitHub-Account
oder Sie können alternativ den Gitlab-Server im Software-Labor nutzen, den Sie aus dem
FH-Netz bzw. über VPN erreichen und wo Sie sich mit Ihren normalen FH-Zugangsdaten einloggen
können ("LDAP"). Klonen Sie dazu eines der beiden bereitgestellten Vorgabe-Repos (siehe
`[Ressourcen > Vorgaben]({{< ref "/org/resources" >}})`{=markdown}) auf Ihren Rechner,
erstellen Sie sich auf [GitHub](https://github.com/) oder alternativ auf unserem Gitlab-Server
im SW-Labor (nur über VPN erreichbar) ein privates Repo für Ihr Team und tragen Sie dieses
Repo als weiteres Remote in Ihre Workingcopy ein. Geben Sie `jposselt`, `amatutat` und
`cagix` Schreibzugriff, damit wir die Pull-/Merge-Requests bearbeiten können.

Die Lösungen müssen jeweils **vor** dem Praktikum hochgeladen werden (Deadlines beachten!)
**und** **im** jeweiligen Praktikum von allen Teammitgliedern vorgestellt werden. Ohne diese
Rücksprache/Vorstellung gibt es keine Punkte.

Sofern nichts anderes bei den Aufgaben angegeben ist, sind die Aufgaben aus dem Konzept-Pool
stets bis **Dienstag 18:00 Uhr** per offenem Pull-/Merge-Request von Ihrem Feature-Branch in
den Master-Branch in Ihrem Repo abzugeben, als Assignee ist Jonas Posselt (`jposselt`) zu
setzen.

Die Aufgaben aus dem Dungeon-Pool sind ebenfalls per (separatem) Pull-Request abzugeben, dies
können Sie bis zum Beginn des Praktikums tun. Die Pull-/Merge-Requests werden von Jonas Posselt
zur angegebenen Deadline gemergt, eine spätere Abgabe ist nicht möglich.

Auftretende Merge-Konflikte werden wie "keine Abgabe" gewertet.

### Punkte und formale Abzüge

Für die sinnvolle Umsetzung der Aufgaben erhalten Sie die jeweils angegebenen (Teil-) Punkte.

Lösungen, die sich nicht kompilieren und/oder nicht ausführen lassen können höchstens wenige
Teilpunkte bekommen. Dito Lösungen, bei denen sich die Vorgabe-Tests (so vorhanden) nicht
kompilieren und/oder ausführen lassen. Stellen Sie vor Abgabe sicher, dass Ihr Code keine fest
codierten Dateien/Verzeichnisse enthält. Denken Sie daran, dass bei UNIX ebenso wie bei Java
zwischen Groß- und Kleinschreibung unterschieden wird, dass Dateinamen und Klassennamen korrekt
sein müssen, dass die angegebenen Methodensignaturen korrekt sein müssen usw. ...

Die Codequalität zählt. Selbst wenn Ihre Lösung eine perfekte Funktionalität aufweist, gibt es
Abzug für schlechte oder schlampige Programmierung. Dies betrifft u.a. fehlende/mangelhafte
Dokumentation, Verletzung von Namenskonventionen, uneinheitliche Formatierung,
schlechte Namen für Klassen/Methoden/Variablen/..., duplizierter Code, ...

Konkret können Sie für die Nichteinhaltung der formalen Kriterien folgende **Abzüge pro Abgabe**
"erreichen" (sofern das Thema bereits in der Vorlesung besprochen wurde und hier anwendbar ist):

*   ~~Keine/nicht ausreichende Tests: -4P~~
*   Kein/nicht ausreichendes Logging: -2P
*   Kein/nicht ausreichendes Javadoc: -2P
*   Code-Style nicht/nur ungenügend beachtet: -2P

**Hinweis**: Um den Arbeitsaufwand zu verringern, _müssen_ Sie für die Konzept- und Dungeon-Aufgaben
keine eigenen Tests erstellen, außer es wird auf dem Blatt bzw. in der Aufgabe explizit gefordert.
Für das Refactoring im Dungeon wäre es aber hilfreich, wenn Sie trotzdem passende Testsuiten erstellen.
Deshalb führen wir im Dungeon-Pool dedizierte Aufgaben ein, wo Sie Punkte für das Erstellen von Tests
für bestimmte Dungeon-Aufgaben bekommen können.

### Lerntagebuch für Dungeon-Aufgaben

Sie führen zu jeder Abgabe von Aufgaben aus dem Dungeon-Pool ein Lerntagebuch. Wenn dies komplett
nicht vorhanden ist oder nur ungenügend ausgearbeitet ist, bekommen Sie auf die gesamte Abgabe der
betreffenden Dungeon-Aufgaben keine Punkte.

Ihr Lerntagebuch sollte folgende Struktur haben (die HTML-Kommentare `<!-- -->` können/sollten Sie
entfernen):

```markdown
---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben XYZ, XYZ, XYZ und XYZ"
author:
-   "VORNAME NAME (EMAIL)"
-   "VORNAME NAME (EMAIL)"
-   "VORNAME NAME (EMAIL)"
---

<!--
Führen Sie zu jeder Woche zur Bearbeitung der Dungeon-Aufhaben ein
Lerntagebuch in Ihrem Team. Kopieren Sie dazu diese Vorlage und füllen
Sie den Kopf entsprechend aus.

Im Lerntagebuch sollen Sie Ihr Vorgehen bei der Bearbeitung der jeweiligen
Dungeon-Aufgaben vom ersten Schritt bis zur Abgabe der Lösung dokumentieren,
d.h. wie sind Sie die gestellte Aufgabe angegangen (und warum), was war
Ihr Plan und auf welche Probleme sind Sie bei der Umsetzung gestoßen und
wie haben Sie diese Probleme gelöst. Beachten Sie die vorgegebene Struktur.
Die zentrale Frage ist: Welche Techniken kenne ich und kann ich sinnvoll
für die Lösung der Aufgabe verwenden (und warum)?

Für jede Abgabe sollte ungefähr eine DIN-A4-Seite Text erstellt werden,
d.h. ca. 400 Wörter umfassen. Wer das Lerntagebuch nur ungenügend führt
oder es gar nicht mit abgibt, bekommt für die betreffende Abgabe 0 Punkte.

Checken Sie das Lerntagebuch mit in Ihr Projekt/Git-Repo ein.

Schreiben Sie den Text mit [Markdown](https://pandoc.org/MANUAL.html#pandocs-markdown).
Tipp: VSCode bringt einen vergleichsweise guten Markdown-Support (inkl. Preview)
bereits in der Grundinstallation mit.

Geben Sie das Lerntagebuch stets mit ab. Achtung: Wenn Sie Abbildungen
einbetten (etwa UML-Diagramme), denken Sie daran, diese auch abzugeben!
-->


# Aufgabe

<!--
Bitte hier die zu lösende Aufgabe kurz in eigenen Worten beschreiben.
-->

TODO


# Ansatz und Modellierung

<!--
Bitte hier den Lösungsansatz beschreiben:
-   Wie sollte die Aufgabe gelöst werden?
-   Welche Techniken wollten Sie einsetzen?
-   Wie sah Ihre Modellierung aus (UML-Diagramm)?
-   Worauf müssen Sie konkret achten?

=> Die zentrale Frage ist: Welche Techniken kenne ich und kann ich
sinnvoll für die Lösung der Aufgabe verwenden (und warum)?
-->

TODO


# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung **kurz** beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->

TODO


# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->

TODO
```

Sie können sich ein
[Template](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/org/lerntagebuch.md)
und ein
[ausgefülltes Beispiel](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/org/lerntagebuch_beispiel.md)
herunterladen.

### Nachbearbeitung Dungeon-Aufgaben

Wenn Sie bei den Dungeon-Aufgaben Abzüge bekommen, können Sie die Mängel nacharbeiten und in
einer anderen Woche vorstellen, um so die abgezogenen/nicht erreichten Punkte noch erhalten
zu können.

Dabei gilt die "Maximal-15-Punkte-pro-Woche-für-Dungeon-Aufgaben"-Regel, d.h. die nachgearbeiteten
Dungeon-Aufgaben werden in der Woche angerechnet, wo Sie die Nachbearbeitung abgeben und vorstellen.

### Zeitslots für Vorstellung

Wir werden mit jedem Team einen individuellen Abgabeslot in Ihrer Praktikumszeit vereinbaren,
damit Sie im Praktikum zielgerichtet zu Ihrer Abgabe kommen können und so Wartezeiten vermeiden.
Dazu gibt es vorbereitete Etherpads im ILIAS, wo Sie sich mit Ihrem Team für einen Abgabeslot
eintragen.

**Achtung**: Die Praktika werden in **Präsenz** durchgeführt. Falls Ihr Team ausnahmsweise nur
in Hybrid teilnehmen kann, wenden Sie sich bitte _zeitnah_ an den Dozenten.

### Verspätete Abgaben, Krankheit

Es gibt keine verspäteten Abgaben. Das sind 0P.

Bei Krankheit/familiären Notfällen: Es sind insgesamt 40 Punkte als "Puffer" für Notfälle oder
Krankheitsfälle eingeplant. Sie könnten also je nach Punktestand einmal eine Woche fehlen und
immer noch eine 1.0 erreichen.

Wenn die persönliche Ausnahmesituation länger vorliegen sollte, müssen ggf. andere Lösungen
gefunden werden, um das Semester erfolgreich abschließen zu können. Nehmen Sie in diesem Fall
zeitnah Kontakt zum Dozenten auf.

### Bonus-Punkte: Helfen im Framework

Sie können aktiv dabei helfen, das Dungeon-Framework weiterzuentwickeln und sich so Bonus-Punkte für das Praktikum verdienen.

Sie können entweder Fehler beheben bzw. Features implementieren, die Sie gerne im Dungeon sehen würden oder ein bereits bestehendes Issue mit dem Label "help wanted" bearbeiten.

Bei der Bepunktung betrachten wir nicht nur den Fix/Code selbst, sondern auch Ihren Umgang mit Git und die Qualität der Kommunikation innerhalb von GitHub (Issue-Beschreibungen, PR-Beschreibungen etc.) sowie den Umfang des Problems. Für einen akzeptierten PR können Sie bis zu 5 Bonus-Punkte erhalten. Es lohnt sich also, aktiv beim Gestalten des Frameworks mitzuhelfen.

Weitere Informationen darüber, wie Sie am Framework mitarbeiten können, finden Sie in der [Core-CONTRIBUTING.md](https://github.com/PM-Dungeon/core/blob/master/CONTRIBUTING.md).


## Regelung für Wiederholer

### Wiederholer mit Performanzprüfung

Wer bereits früher in Programmiermethoden eine Prüfungsleistung unter der Prüfungsform
"Performanzprüfung" abgelegt hat und diese Prüfung noch nicht abgeschlossen hat, belegt
die fehlenden Teilleistungen in diesem Semester.

Wenn Ihnen die **theoretische Teilleistung** fehlt, dann nehmen Sie an der Klausur teil
(d.h. für den ersten Prüfungszeitraum an den beiden kürzeren Prüfungen, für den zweiten
Prüfungszeitraum an der längeren E-Klausur).
Wenn bei Ihnen die **praktische Teilleistung** noch offen ist, nehmen Sie entsprechend am
Praktikum teil. Melden Sie sich für die jeweilige Teilleistung im LSF an.

### Wiederholer mit Parcours-Prüfung

Wer bereits früher in Programmiermethoden eine Prüfungsleistung unter der Prüfungsform
"Parcours-Prüfung" abgelegt hat und diese Prüfung noch nicht abgeschlossen hat, belegt
in diesem Semester sowohl das **Praktikum** als auch die **Klausur**.

Sie bekommen auf beide Teile eine (interne) Teilnote, die gemittelt die Note in der
Parcours-Prüfung ergeben.

Sie müssen sich entsprechend im LSF sowohl für die **praktische Teilleistung** als auch
für die **theoretische Teilleistung** anmelden. Bitte melden Sie sich zusätzlich zeitnah
per E-Mail beim Dozenten.
