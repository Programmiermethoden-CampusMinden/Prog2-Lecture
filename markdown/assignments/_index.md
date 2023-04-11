---
archetype: "chapter"
title: "Praktikum"
weight: 0

hidden: true
_build:
  render: always
  list: never
  publishResources: true
---


Hier finden Sie die Praktikumsaufgaben. Die Aufgaben sind in vier Themenbereiche sortiert:
"Basics", "Monster", "Loot" und "Bounty".

Anregungen für **Spielideen** können Sie beispielsweise in den folgenden Videos finden:
-   [Shattered Pixel Dungeon Rogue Beginners Guide Playthrough](https://youtu.be/qoc_tDN0QC4)
-   [Shattered Pixel Dungeon Duelist Update!](https://youtu.be/LgSjUWjQg0s)


## Gruppe "Basics"

| Aufgabe                                                                                         | Punkte | Abhängig von                                                                                                                                                                                                                                      |
|:------------------------------------------------------------------------------------------------|:-------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `[Fallen]({{< ref "/assignments/group_basics/fallen" >}})`{=markdown}                           | 5      |                                                                                                                                                                                                                                                   |
| `[Fähigkeiten]({{< ref "/assignments/group_basics/skills" >}})`{=markdown}                      | 10     |                                                                                                                                                                                                                                                   |
| `[Charakterklassen]({{< ref "/assignments/group_basics/charakterklassen" >}})`{=markdown}       | 5      | `["Nahkampf"]({{< ref "/assignments/group_monster/nahkampf" >}})`{=markdown} oder `["Fernkampf"]({{< ref "/assignments/group_monster/fernkampf" >}})`{=markdown} und `["Fähigkeiten"]({{< ref "/assignments/group_basics/skills" >}})`{=markdown} |
| `[Speichern und Laden]({{< ref "/assignments/group_basics/speichern_und_laden" >}})`{=markdown} | 5      |                                                                                                                                                                                                                                                   |
| `[JUnit (Gruppe Basics)]({{< ref "/assignments/group_basics/testen" >}})`{=markdown}            | 5      | `["Fallen"]({{< ref "/assignments/group_basics/fallen" >}})`{=markdown}                                                                                                                                                                           |
| `[Freie Aufgabe]({{< ref "/assignments/group_basics/freie_aufgabe" >}})`{=markdown}             | 10     |                                                                                                                                                                                                                                                   |


## Gruppe "Monster"

| Aufgabe                                                                                | Punkte | Abhängig von                                                                                                                                                   |
|:---------------------------------------------------------------------------------------|:-------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `[Monster]({{< ref "/assignments/group_monster/monster" >}})`{=markdown}               | 5      |                                                                                                                                                                |
| `[Fernkampf]({{< ref "/assignments/group_monster/fernkampf" >}})`{=markdown}           | 5      | `["Monster"]({{< ref "/assignments/group_monster/monster" >}})`{=markdown}                                                                                     |
| `[Nahkampf]({{< ref "/assignments/group_monster/nahkampf" >}})`{=markdown}             | 5      | `["Monster"]({{< ref "/assignments/group_monster/monster" >}})`{=markdown}                                                                                     |
| `[Boss-Monster]({{< ref "/assignments/group_monster/boss_monster" >}})`{=markdown}     | 5      | `["Monster"]({{< ref "/assignments/group_monster/monster" >}})`{=markdown}                                                                                     |
| `[Game-Over]({{< ref "/assignments/group_monster/gameover" >}})`{=markdown}            | 5      |                                                                                                                                                                |
| `[JUnit (Gruppe Monster)]({{< ref "/assignments/group_monster/testen" >}})`{=markdown} | 5      | `["Monster"]({{< ref "/assignments/group_monster/monster" >}})`{=markdown} oder `["Fernkampf"]({{< ref "/assignments/group_monster/fernkampf" >}})`{=markdown} |
| `[Freie Aufgabe)]({{< ref "/assignments/group_monster/freie_aufgabe" >}})`{=markdown}  | 10     |                                                                                                                                                                |


## Gruppe "Loot"

| Aufgabe                                                                                | Punkte | Abhängig von                                                                                                                                                 |
|:---------------------------------------------------------------------------------------|:-------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `[Items]({{< ref "/assignments/group_loot/item" >}})`{=markdown}                       | 5      |                                                                                                                                                              |
| `[Freundlicher NPC-Geist]({{< ref "/assignments/group_loot/npc" >}})`{=markdown}       | 5      |                                                                                                                                                              |
| `[Dialogsystem]({{< ref "/assignments/group_loot/dialogsystem" >}})`{=markdown}        | 5      |                                                                                                                                                              |
| `[Shop]({{< ref "/assignments/group_loot/shop" >}})`{=markdown}                        | 10     | `["Item"]({{< ref "/assignments/group_loot/item" >}})`{=markdown} und `["Dialogsystem"]({{< ref "/assignments/group_loot/dialogsystem" >}})`{=markdown}      |
| `[Monster-Schatzkisten]({{< ref "/assignments/group_loot/schatzkiste" >}})`{=markdown} | 5      | `["Monster"]({{< ref "/assignments/group_monster/monster" >}})`{=markdown} und `["Item"]({{< ref "/assignments/group_loot/item" >}})`{=markdown}             |
| `[Quests]({{< ref "/assignments/group_loot/quests" >}})`{=markdown}                    | 5      |                                                                                                                                                              |
| `[Lockpicking]({{< ref "/assignments/group_loot/lockpicking" >}})`{=markdown}          | 10     | `["Item"]({{< ref "/assignments/group_loot/item" >}})`{=markdown}                                                                                            |
| `[JUnit (Gruppe Loot)]({{< ref "/assignments/group_loot/testen" >}})`{=markdown}       | 5      | `["Quests"]({{< ref "/assignments/group_loot/quests" >}})`{=markdown} oder `["Dialogsystem"]({{< ref "/assignments/group_loot/dialogsystem" >}})`{=markdown} |
| `[Freie Aufgabe]({{< ref "/assignments/group_loot/freie_aufgabe" >}})`{=markdown}      | 10     |                                                                                                                                                              |


## Gruppe "Bounty"

| Aufgabe                                                                                                                            | Punkte |
|:-----------------------------------------------------------------------------------------------------------------------------------|:-------|
| [5P Bounty](https://github.com/Programmiermethoden/Dungeon/issues?q=is%3Aopen+is%3Aissue+label%3Abounty+-linked%3Apr+label%3A5P)   | 5      |
| [10P Bounty](https://github.com/Programmiermethoden/Dungeon/issues?q=is%3Aopen+is%3Aissue+label%3Abounty+-linked%3Apr+label%3A10P) | 10     |

_Hinweis_: Die Liste der Bounty-Aufgaben wird sich dynamisch verändern. Es wird vorkommen,
dass Aufgaben im Laufe des Semesters nicht mehr zur Verfügung stehen. Ebenso können im Laufe
des Semesters neue Aufgaben hinzu kommen. Nicht mehr angebotene Aufgaben können Sie nicht
mehr zur Bearbeitung wählen.

_Hinweis_: Für die Bounty-Aufgaben können Sie zusätzlich bis zu 3 Bonus-Punkte bekommen, wenn
Sie Ihre Lösung als [Pull-Request](https://github.com/Programmiermethoden/Dungeon/compare) im
[Dungeon-Repo](https://github.com/Programmiermethoden/Dungeon) einreichen und Ihr PR vom
Dungeon-Team akzeptiert (gemergt) wird. Es kann nur ein PR pro Bounty-Aufgabe gemergt werden,
die Entscheidung liegt beim Dozenten.
