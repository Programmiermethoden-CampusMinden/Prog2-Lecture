---
archetype: assignment
title: "Fähigkeiten"
author: "André Matutat (FH Bielefeld)"
points: 10
weight: 2

hidden: true
---

## Ziel

In dieser Aufgabe sollen Sie den Levelaufstieg und verschiedene Fähigkeiten implementieren, die dann vom Spieler verwendet werden können.


## Fähigkeiten

In den Vorgaben ist bereits ein [Skill-System](https://github.com/Programmiermethoden/Dungeon/blob/master/game/src/ecs/systems/SkillSystem.java) und ein [Feuerball-Skill](https://github.com/Programmiermethoden/Dungeon/blob/master/game/src/ecs/components/skill/FireballSkill.java) implementiert.
Führen Sie eine Codeanalyse durch und erklären Sie die funktionalität 

Implementieren Sie ein Magie-Konzept. Der Spieler soll in der Lage sein verschiedene Zauber zu verwenden.

Beachten Sie dabei, dass es sich nicht um Zauber handelt, die Schaden verursachen. Zauber, die Monster anderweitig manipulieren, sind erlaubt.

Überlegen Sie sich zwei verschiedene Zaubersprüche wie Gedankenkontrolle oder Telekinese oder Upgrade von Waffen/Rüstungen.

-   Eine der Fähigkeiten soll eine Form von Ressourcenkosten haben. Sie verbraucht also Lebenspunkte, Ausdauerpunkte, [Mana-Punkte](https://de.wikipedia.org/wiki/Mana_(Spiele)) o.ä.

## Levelaufstieg

In den Vorgaben gibt es bereits ein [XP-System](https://github.com/Programmiermethoden/Dungeon/blob/master/game/src/ecs/systems/XPSystem.java) um Erfahrungspunkte zu sammeln und Level aufzusteigen. 
Führen Sie eine Codeanalyse durch und erklären Sie die funktionalität 

Verbessern Sie beim Levelaufstieg des Helden seine Charakterwerte und lassen Sie ihn die oben implementierten Zaubersprüche erlernen. 
