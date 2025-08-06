# Refactoring

> [!NOTE]
>
> <details open>
>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Refactoring bedeutet Änderung der inneren Struktur des Codes ohne
> Beeinflussung äußeren Verhaltens.
>
> Mit Hilfe von Refactoring kann man Code Smells beheben, und
> Lesbarkeit, Verständlichkeit und Wartbarkeit von Software verbessern.
>
> Es ist wichtig, immer nur einzelne Schritte zu machen und anschließend
> die Testsuite laufen zu lassen, damit nicht versehentlich Fehler oder
> Verhaltensänderungen beim Refactoring eingebaut werden.
>
> Prinzipiell kann man Refactoring manuell mit Search&Replace
> durchführen, aber es bietet sich an, hier die IDE-Unterstützung zu
> nutzen. Es stehen verschiedene Methoden zur Verfügung, die nicht
> unbedingt einheitlich benannt sein müssen oder in jeder IDE vorkommen.
> Zu den häufig genutzten Methoden zählen *Rename*, *Extract*, *Move*
> und *Push Up/Pull Down*.
>
> </details>
>
> <details>
>
> <summary><strong>🎦 Videos</strong></summary>
>
> - [VL Refactoring](https://youtu.be/n0RaQ_Qve0Y)
> - [Demo Refactoring: Rename](https://youtu.be/zZ2RGKRBVz4)
> - [Demo Refactoring: Encapsulate](https://youtu.be/PR4mEjBl_No)
> - [Demo Refactoring: Extract Method](https://youtu.be/4VbxgqZ68ng)
> - [Demo Refactoring: Move Method](https://youtu.be/Wr92Oboh05E)
> - [Demo Refactoring: Pull up](https://youtu.be/t24c88RshL8)
>
> </details>

## Was ist Refactoring?

> Refactoring ist, wenn einem auffällt, daß der Funktionsname `foobar`
> ziemlich bescheuert ist, und man die Funktion in `sinus` umbenennt.
>
>  Quelle: [“356:
> Refactoring”](http://altlasten.lutz.donnerhacke.de/mitarb/lutz/usenet/Fachbegriffe.der.Informatik.html#356)
> by [Andreas Bogk](mailto:andreas@andreas.org) on Lutz Donnerhacke:
> “Fachbegriffe der Informatik”

> Refactoring (noun): a change made to the internal structure of
> software to make it easier to understand and cheaper to modify without
> changing its observable behaviour.
>
>  ([Fowler 2011](#ref-Fowler2011), p. 53)

**Refactoring:** Änderungen an der **inneren Struktur** einer Software

- Beobachtbares (äußeres) Verhalten ändert sich dabei **nicht**
  - Keine neuen Features einführen
  - Keine Bugs fixen
  - Keine öffentliche Schnittstelle ändern (*Anmerkung*: Bis auf
    Umbenennungen oder Verschiebungen von Elementen innerhalb der
    Software)
- Ziel: Verbesserung von Verständlichkeit und Änderbarkeit

## Anzeichen, dass Refactoring jetzt eine gute Idee wäre

- Code “stinkt” (zeigt/enthält *Code Smells*)

  Code Smells sind strukturelle Probleme, die im Laufe der Zeit zu
  Problemen führen können. Refactoring ändert die innere Struktur des
  Codes und kann entsprechend genutzt werden, um die Smells zu beheben.

<!-- -->

- Schwer erklärbarer Code

  Könnten Sie Ihren Code ohne Vorbereitung in der Abgabe erklären? In
  einer Minute? In fünf Minuten? In zehn? Gar nicht?

  In den letzten beiden Fällen sollten Sie definitiv über eine
  Vereinfachung der Strukturen nachdenken.

- Verständnisprobleme, Erweiterungen

  Sie grübeln in der Abgabe, was Ihr Code machen sollte?

  Sie überlegen, was Ihr Code bedeutet, um herauszufinden, wo Sie die
  neue Funktionalität anbauen können?

  Sie suchen nach Codeteilen, finden diese aber nicht, da die sich in
  anderen (falschen?) Stellen/Klassen befinden?

  Nutzen Sie die (neuen) Erkenntnisse, um den Code leichter verständlich
  zu gestalten.

<div align="center">

> “Three strikes and you refactor.”
>
>  ([Fowler 2011](#ref-Fowler2011), p. 58): “The Rule of Three”

</div>

Wenn Sie sich zum dritten Mal über eine suboptimale Lösung ärgern, dann
werden Sie sich vermutlich noch öfter darüber ärgern. Jetzt ist der
Zeitpunkt für eine Verbesserung.

Schauen Sie sich die entsprechenden Kapitel in ([Passig und Jander
2013](#ref-Passig2013)) und ([Fowler 2011](#ref-Fowler2011)) an, dort
finden Sie noch viele weitere Anhaltspunkte, ob und wann Refactoring
sinnvoll ist.

## Bevor Sie loslegen …

1.  **Unit Tests** schreiben
    - Normale und ungültige Eingaben
    - Rand- und Spezialfälle

<!-- -->

1.  **Coding Conventions** einhalten
    - Sourcecode formatieren (lassen)

<!-- -->

1.  Haben Sie die fragliche Codestelle auch wirklich verstanden?!

## Vorgehen beim Refactoring

### Überblick über die Methoden des Refactorings

Die Refactoring-Methoden sind nicht einheitlich definiert, es existiert
ein großer und uneinheitlicher “Katalog” an möglichen Schritten.
Teilweise benennt jede IDE die Schritte etwas anders, teilweise werden
unterschiedliche Möglichkeiten angeboten.

Zu den am häufigsten genutzten Methoden zählen

- Rename Method/Class/Field
- Encapsulate Field
- Extract Method/Class
- Move Method
- Pull Up, Push Down (Field, Method)

### Best Practice

Eine Best Practice (oder nennen Sie es einfach eine wichtige Erfahrung)
ist, beim Refactoring langsam und gründlich vorzugehen. Sie ändern die
Struktur der Software und können dabei leicht Fehler oder echte Probleme
einbauen. Gehen Sie also langsam und sorgsam vor, machen Sie einen
Schritt nach dem anderen und sichern Sie sich durch eine gute Testsuite
ab, die Sie nach jedem Schritt erneut ausführen: Das Verhalten der
Software soll sich ja nicht ändern, d.h. die Tests müssen nach jedem
einzelnen Refactoring-Schritt immer grün sein (oder Sie haben einen
Fehler gemacht).

- Kleine Schritte: immer nur **eine** Änderung zu einer Zeit

- Nach **jedem** Refactoring-Schritt **Testsuite** laufen lassen

  =\> Nächster Refactoring-Schritt erst, wenn alle Tests wieder “grün”

- Versionskontrolle nutzen: **Jeden** Schritt **einzeln** committen

## Refactoring-Methode: Rename Method/Class/Field

### Motivation

Name einer Methode/Klasse/Attributs erklärt nicht ihren Zweck.

### Durchführung

Name selektieren, “`Refactor > Rename`”

### Anschließend ggf. prüfen

Aufrufer? Superklassen?

### Beispiel

**Vorher**

``` java
public String getTeN() {}
```

**Nachher**

``` java
public String getTelefonNummer() {}
```

## Refactoring-Methode: Encapsulate Field

### Motivation

Sichtbarkeit von Attributen reduzieren.

### Durchführung

Attribut selektieren, “`Refactor > Encapsulate Field`”

### Anschließend ggf. prüfen

Superklassen? Referenzen? (Neue) JUnit-Tests?

### Beispiel

**Vorher**

``` java
int cps;

public void printDetails() {
    System.out.println("Credits: " + cps);
}
```

**Nachher**

``` java
private int cps;

int getCps() { return cps; }
void setCps(int cps) {  this.cps = cps;  }

public void printDetails() {
    System.out.println("credits: " + getCps());
}
```

## Refactoring-Methode: Extract Method/Class

### Motivation

- Codefragment stellt eigenständige Methode dar
- “Überschriften-Code”
- Code-Duplizierung
- Code ist zu “groß”
- Klasse oder Methode erfüllt unterschiedliche Aufgaben

### Durchführung

Codefragment selektieren, “`Refactor > Extract Method`” bzw.
“`Refactor > Extract Class`”

### Anschließend ggf. prüfen

- Aufruf der neuen Methode? Nutzung der neuen Klasse?
- Neue JUnit-Tests nötig? Veränderung bestehender Tests nötig?
- Speziell bei Methoden:
  - Nutzung lokaler Variablen: Übergabe als Parameter!
  - Veränderung lokaler Variablen: Rückgabewert in neuer Methode und
    Zuweisung bei Aufruf; evtl. neue Typen nötig!

### Beispiel

**Vorher**

``` java
public void printInfos() {
    printHeader();
    // Details ausgeben
    System.out.println("name:    " + name);
    System.out.println("credits: " + cps);
}
```

**Nachher**

``` java
public void printInfos() {
    printHeader();
    printDetails();
}
private void printDetails() {
    System.out.println("name:    " + name);
    System.out.println("credits: " + cps);
}
```

## Refactoring-Methode: Move Method

### Motivation

Methode nutzt (oder wird genutzt von) mehr Eigenschaften einer fremden
Klasse als der eigenen Klasse.

### Durchführung

Methode selektieren, “`Refactor > Move`” (ggf. “Keep original method as
delegate to moved method” aktivieren)

### Anschließend ggf. prüfen

- Aufruf der neuen Methode (Delegation)?
- Neue JUnit-Tests nötig? Veränderung bestehender Tests nötig?
- Nutzung lokaler Variablen: Übergabe als Parameter!
- Veränderung lokaler Variablen: Rückgabewert in neuer Methode und
  Zuweisung bei Aufruf; evtl. neue Typen nötig!

### Beispiel

**Vorher**

``` java
public class Kurs {
    int cps;
    String descr;
}

public class Studi extends Person {
    String name;
    int cps;
    Kurs kurs;

    public void printKursInfos() {
        System.out.println("Kurs:    " + kurs.descr);
        System.out.println("Credits: " + kurs.cps);
    }
}
```

**Nachher**

``` java
public class Kurs {
    int cps;
    String descr;

    public void printKursInfos() {
        System.out.println("Kurs:    " + descr);
        System.out.println("Credits: " + cps);
    }
}

public class Studi extends Person {
    String name;
    int cps;
    Kurs kurs;

    public void printKursInfos() { kurs.printKursInfos(); }
}
```

## Refactoring-Methode: Pull Up, Push Down (Field, Method)

### Motivation

- Attribut/Methode nur für die Oberklasse relevant: **Pull Up**
- Subklassen haben identische Attribute/Methoden: **Pull Up**
- Attribut/Methode nur für eine Subklasse relevant: **Push Down**

### Durchführung

Name selektieren, “`Refactor > Pull Up`” oder “`Refactor > Push Down`”

### Anschließend ggf. prüfen

Referenzen/Aufrufer? JUnit-Tests?

### Beispiel

**Vorher**

``` java
public class Person { }

public class Studi extends Person {
    String name;
    public void printDetails() { System.out.println("name:    " + name); }
}
```

**Nachher**

``` java
public class Person { protected String name; }

public class Studi extends Person {
    public void printDetails() { System.out.println("name:    " + name); }
}
```

## Wrap-Up

Behebung von **Bad Smells** durch **Refactoring**

=\> Änderung der inneren Struktur ohne Beeinflussung des äußeren
Verhaltens

- Verbessert Lesbarkeit, Verständlichkeit, Wartbarkeit
- Immer nur kleine Schritte machen
- Nach jedem Schritt Testsuite laufen lassen
- Katalog von Maßnahmen, beispielsweise *Rename*, *Extract*, *Move*,
  *Push Up/Pull Down*, …
- Unterstützung durch IDEs wie Eclipse, Idea, …

## 📖 Zum Nachlesen

- Fowler ([2011](#ref-Fowler2011))
- Inden ([2013, Kap. 11](#ref-Inden2013))

------------------------------------------------------------------------

> [!TIP]
>
> <details>
>
> <summary><strong>✅ Lernziele</strong></summary>
>
> - k2: Ich kann den Begriff sowie die Notwendigkeit und das Vorgehen des/beim Refactoring erklären
> - k2: Ich kann die Bedeutung kleiner Schritte beim Refactoring erklären
> - k2: Ich kann die Bedeutung einer sinnvollen Testsuite beim Refactoring erklären
> - k2: Ich habe verstanden, dass ‘Refactoring’ bedeutet: Nur die innere Struktur ändern, nicht das von außen sichtbare Verhalten!
> - k3: Ich kann die wichtigsten Refactoring-Methoden anwenden: Rename, Extract, Move, Push Up/Pull Down
>
> </details>
>
> <details>
>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie das [Theatrical Players Refactoring
> Kata](https://github.com/emilybache/Theatrical-Players-Refactoring-Kata).
> Dort finden Sie im Unterordner
> [java/](https://github.com/emilybache/Theatrical-Players-Refactoring-Kata/tree/main/java)
> einige Klassen mit unübersichtlichem und schlecht strukturierten Code.
>
> Welche *Bad Smells* können Sie hier identifizieren?
>
> Beheben Sie die Smells durch die *schrittweise Anwendung* von den aus
> der Vorlesung bekannten Refactoring-Methoden. Denken Sie auch daran,
> dass Refactoring immer durch eine entsprechende Testsuite abgesichert
> sein muss - ergänzen Sie ggf. die Testfälle.
>
> **Real-Life Refactoring**
>
> Betrachten Sie das folgende Code-Beispiel, welches aus dem
> [Dungeon-Projekt](https://github.com/Dungeon-CampusMinden/Dungeon)
> stammt:
>
> ``` java
> public void shootFireBall() {
>     AmmunitionComponent heroAC =
>         hero.fetch(AmmunitionComponent.class)
>             .orElseThrow(() -> MissingComponentException.build(hero, AmmunitionComponent.class));
>     if (!heroAC.checkAmmunition()) return;
>     utils.Direction viewDirection =
>         convertPosCompDirectionToUtilsDirection(EntityUtils.getViewDirection(hero));
>     Skill fireball =
>         new Skill(
>             new FireballSkill(
>                 () -> {
>                 CollideComponent collider =
>                     hero.fetch(CollideComponent.class)
>                         .orElseThrow(
>                             () -> MissingComponentException.build(hero, CollideComponent.class));
>                 Point start = collider.center(hero);
>                 return start.add(new Point(viewDirection.x(), viewDirection.y()));
>                 }),
>             1);
>     fireball.execute(hero);
>     heroAC.spendAmmo();
>     waitDelta();
> }
> ```
>
> 1.  Analysieren Sie den Code und versuchen Sie zu verstehen, was hier
>     passiert. Welche Typen müssen die unterschiedlichen Operationen
>     haben (Parametertypen, Rückgabetypen)?
> 2.  Welche Funktionseinheiten können Sie identifizieren? Entwickeln
>     Sie Ideen, wie dieser Code zu mittels Refactoring lesbarer und
>     verständlicher gemacht werden kann. Nutzen Sie dabei möglichst
>     geschickt u.a. die Java-Stream-API und Optionals und überlegen
>     Sie, welche der Exceptions wirklich relevant sind …
> 3.  Kopieren Sie den Code in einen Editor (mit Syntaxunterstützung -
>     die IDE geht auch, wird aber wegen der fehlenden Klassen und
>     Variablen keine wirkliche Hilfe sein). Führen Sie das Refactoring
>     “zu Fuß” durch. Vergleichen Sie Ihr Ergebnis und den
>     ursprünglichen Code.
>
> (*Sie brauchen im Dungeon-Projekt nicht zu suchen, diese Code-Stelle
> ist längst bereinigt …*)
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
> <div id="ref-Fowler2011" class="csl-entry">
>
> Fowler, M. 2011. *Refactoring*. Addison-Wesley.
>
> </div>
>
> <div id="ref-Inden2013" class="csl-entry">
>
> Inden, M. 2013. *Der Weg zum Java-Profi*. 2. Aufl. dpunkt.verlag.
>
> </div>
>
> <div id="ref-Passig2013" class="csl-entry">
>
> Passig, K., und J. Jander. 2013. *Weniger schlecht programmieren*.
> O’Reilly.
>
> </div>
>
> </div>
>
> </details>

------------------------------------------------------------------------

<img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png" width="10%">

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

**Exceptions:**

- [“356:
  Refactoring”](http://altlasten.lutz.donnerhacke.de/mitarb/lutz/usenet/Fachbegriffe.der.Informatik.html#356)
  by [Andreas Bogk](mailto:andreas@andreas.org) on Lutz Donnerhacke:
  “Fachbegriffe der Informatik”

<blockquote><p><sup><sub><strong>Last modified:</strong> df56b1c (lecture: remove explicit link to pdf version, 2025-07-23)<br></sub></sup></p></blockquote>
