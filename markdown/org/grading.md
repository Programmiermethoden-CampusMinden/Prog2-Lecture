---
archetype: lecture-cg
title: "Note und Credits"
author: "Carsten Gips (FH Bielefeld)"
weight: 3

hidden: true
---


## Prüfungsform

**Performanzprüfung, 7 ECTS**

-   **Praktische Teilleistung**:
    Durch die Bearbeitung der Praktikumsaufgaben sowie die Abgabe Ihrer Lösung vor dem
    Praktikum und die Vorstellung der Lösung im Praktikum sammeln Sie im Laufe des
    Semesters Punkte, die für die Berechnung der Note dieser Teilleistung genutzt werden.

    Notenspiegel:
    *   225P gesamt, 50P Puffer => “Krankheitsregelung”, 175P == 100%
    *   4.0: ab 60% v. 175P (105P), alle 4% nächste Teilnote, 1.0: ab 96% v. 175P (168P)

-   **Theoretische Teilleistung**:
    Die Prüfung für die theoretische Teilleistung wird als digitale Klausur über eine
    spezielle ILIAS-Instanz ("E-Assessment-Server") durchgeführt. Es wird in beiden
    Prüfungszeiträumen je ein Termin angeboten.
    Siehe auch `["Prüfungsvorbereitung"]({{< ref "/org/exams" >}})`{=markdown}.

-   **Gesamtnote**:
    Die beiden Leistungen (praktische und theoretische Teilleistung) werden separat im LSF
    erfasst und vom System automatisch zu einer Gesamtnote verrechnet (50% Praxis, 50%
    Theorie).

Wiederholer mit Parcours-Prüfung absolvieren stattdessen eine Parcoursprüfung. Bitte melden
Sie sich zeitnah per E-Mail beim Dozenten.


## Hinweise zum Praktikum

### Bearbeitung der Aufgaben

Sie bearbeiten alle Aufgaben in festen Teams zu je **drei Personen**. Jedes Team erarbeitet seine
**eigene** Lösung.

Wer Lösungen ganz oder teilweise von anderen Teams/Studierenden oder anderen Quellen übernimmt
und als eigene Lösung ab-/ausgibt, begeht einen Täuschungsversuch mit entsprechenden Konsequenzen
im Prüfungsverfahren.

### Abgabe der Lösungen

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

### Vorstellung der Lösung im Praktikum

Die Vorstellung Ihrer Lösung im Praktikum kann mit einem Medium Ihrer Wahl
stattfinden. Sie können zum Beispiel Ihren Bildschirm teilen und Ihre Lösung
erklären. Sie brauchen nicht extra eine Präsentation anfertigen!

### Peer-Feedback

Nach der Ablauf der Deadline wird Ihnen durch ILIAS ein oder mehrere Reviews
zugewiesen. Sie finden die Review-Kriterien (als Checklisten) und die
anzufertigenden Reviews im ILIAS - gehen Sie dazu im Praktikumsbereich auf
die jeweilige Aufgabe.

Während des Praktikums füllen Sie bitte die Review-Checklisten aus und stellen
Sie diese im ILIAS ein.

### Punktevergabe

Sie erhalten für jeden der 7 Meilensteine und jede der beiden Poster-Sessions
bis zu 4P:

-   1P für das Hochladen der Lösung im ILIAS
-   1P für das Vorstellen der Lösung im Praktikum
-   2P für das Erstellen des Peer-Feedbacks

Ihre Lösung muss nicht unbedingt 100% korrekt sein, muss aber eine intensive
Beschäftigung mit der jeweiligen Aufgabe erkennen lassen.

**Wichtig**: Beachten Sie, dass die Punkte aufeinander aufbauen: Ohne Abgabe
der Lösung im ILIAS können Sie Ihre Lösung nicht vorstellen und auch kein
Peer-Feedback abgeben.

Für die Poster gibt es zusätzlich je bis zu 10P, die nach inhaltlichen und
formalen Kriterien durch die Dozenten vergeben werden.

Damit können Sie maximal (7+2)x 4 + 2x 10 = 56 Punkte im Praktikum erreichen.

### Punktevergabe

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

### Lerntagebuch

Sie führen zu jeder Abgabe von Aufgaben aus dem Dungeon-Pool ein Lerntagebuch. Wenn dies komplett
nicht vorhanden ist oder nur ungenügend ausgearbeitet ist, bekommen Sie auf die gesamte Abgabe der
betreffenden Dungeon-Aufgaben keine Punkte.

Sie können sich das
[Template](https://github.com/Programmiermethoden/PM-Lecture/blob/master/markdown/org/lerntagebuch.md)
und ein
[ausgefülltes Beispiel](https://github.com/Programmiermethoden/PM-Lecture/blob/master/markdown/org/lerntagebuch_beispiel.md)
herunterladen.


## Wiederholer

Wer bereits früher in Programmiermethoden eine Prüfungsleistung abgelegt hat und diese Prüfung noch
nicht abgeschlossen hat, ist an die damalige Prüfungsform gebunden. Praktisch kann diese entweder
eine Wiederholung mit Performanzprüfung oder eine Wiederholung mit Parcoursprüfung bedeuten. Im ersten
Fall (Performanzprüfung) gelten die oben beschriebenen Regelungen, im zweiten Fall (Parcoursprüfung)
werden die Praktikumsaufgaben sowie die Klausur als Prüfungsstationen betrachtet und dafür eine Note
vergeben. Bitte melden Sie sich zeitnah per E-Mail beim Dozenten.
