# Javadoc

> [!IMPORTANT]
>
> <details open>
>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit Javadoc kann aus speziell markierten Block-Kommentaren eine
> externe Dokumentation im HTML-Format erzeugt werden. Die
> Block-Kommentare, auf die das im JDK enthaltene Programm `javadoc`
> reagiert, beginnen mit `/**` (also einem zusätzlichen Stern, der für
> den Java-Compiler nur das erste Kommentarzeichen ist).
>
> Die erste Zeile eines Javadoc-Kommentars ist eine “Zusammenfassung”
> und an fast allen Stellen der generierten Doku sichtbar. Diese Summary
> sollte kurz gehalten werden und eine Idee vermitteln, was die Klasse
> oder die Methode oder das Attribut macht.
>
> Für die Dokumentation von Parametern, Rückgabetypen, Exceptions und
> veralteten Elementen existieren spezielle Annotationen: `@param`,
> `@return`, `@throws` und `@deprecated`.
>
> Als Faustregel gilt: Es werden **alle** `public` und `protected`
> Elemente (Klassen, Methoden, Attribute) mit Javadoc kommentiert. Alle
> nicht-öffentlichen Elemente bekommen normale Java-Kommentare (Zeilen-
> oder Blockkommentare).
> </details>

> [!TIP]
>
> <details open>
>
> <summary><strong>🎦 Videos</strong></summary>
>
> - [VL Javadoc](https://youtu.be/Qo2TTD593eQ)
>
> </details>

## Dokumentation mit Javadoc

``` java
/**
 * Beschreibung Beschreibung (Summary).
 *
 * <p>Hier kommt dann ein laengerer Text, der die Dinge
 * bei Bedarf etwas ausfuehrlicher erklaert.
 */
public void wuppie() {}
```

Javadoc-Kommentare sind (aus Java-Sicht) normale Block-Kommentare, wobei
der Beginn mit `/**` eingeleitet wird. Dieser Beginn ist für das Tool
`javadoc` (Bestandteil des JDK, genau wie `java` und `javac`) das
Signal, dass hier ein Kommentar anfängt, den das Tool in eine
HTML-Dokumentation übersetzen soll.

Typischerweise wird am Anfang jeder Kommentarzeile ein `*` eingefügt;
dieser wird von Javadoc ignoriert.

Sie können neben normalem Text und speziellen Annotationen auch
HTML-Elemente wie `<p>` und `<code>` oder `<ul>` nutzen.

Mit `javadoc *.java` können Sie in der Konsole aus den Java-Dateien die
Dokumentation generieren lassen. Oder Sie geben das in Ihrer IDE in
Auftrag … (die dann diesen Aufruf gern für Sie tätigt).

## Standard-Aufbau

``` java
/**
 * Beschreibung Beschreibung (Summary).
 *
 * <p> Hier kommt dann ein laengerer Text, der die Dinge
 * bei Bedarf etwas ausfuehrlicher erklaert.
 *
 * @param   date  Tag, Wert zw. 1 .. 31
 * @return  Anzahl der Sekunden seit 1.1.1970
 * @throws  NumberFormatException
 * @deprecated As of JDK version 1.1
 */
public int setDate(int date) {
    setField(Calendar.DATE, date);
}
```

- Erste Zeile bei Methoden/Attributen geht in die generierte “Summary”
  in der Übersicht, der Rest in die “Details”
  - Die “Summary” sollte kein kompletter Satz sein, wird aber wie ein
    Satz geschrieben (Groß beginnen, mit Punkt beenden). Es sollte nicht
    beginnen mit “Diese Methode macht …” oder “Diese Klasse ist …”. Ein
    gutes Beispiel wäre “Berechnet die Steuerrückerstattung.”
  - Danach kommen die Details, die in der generierten Dokumentation erst
    durch Aufklappen der Elemente sichtbar sind. Erklären Sie, wieso der
    Code was machen soll und welche Designentscheidungen getroffen
    wurden (und warum).
- Leerzeilen gliedern den Text in Absätze. Neue Absätze werden mit einem
  `<p>` eingeleitet. (Ausnahmen: Wenn der Text mit `<ul>` o.ä. beginnt
  oder der Absatz mit den Block-Tags.)
- Die “Block-Tags” `@param`, `@return`, `@throws`, `@deprecated` werden
  durch einen Absatz von der restlichen Beschreibung getrennt und
  tauchen in exakt dieser Reihenfolge auf. Die Beschreibung dieser Tags
  ist nicht leer - anderenfalls lässt man das Tag weg. Falls die Zeile
  für die Beschreibung nicht reicht, wird umgebrochen und die Folgezeile
  mit vier Leerzeichen (beginnend mit dem `@`) eingerückt.
  - Mit `@param` erklären Sie die Bedeutung eines Parameters (von links
    nach rechts) einer Methode. Beispiel:
    `@param   date   Tag, Wert zw. 1 .. 31`. Wiederholen Sie dies für
    jeden Parameter.
  - Mit `@return` beschreiben Sie den Rückgabetyp/-wert. Beispiel:
    `@return  Anzahl der Sekunden seit 1.1.1970`. Bei Rückgabe von
    `void` wird diese Beschreibung weggelassen (die Beschreibung wäre
    dann ja leer).
  - Mit `@throws` geben Sie an, welche “checked” Exceptions die Methode
    wirft.
  - Mit `@deprecated` können Sie im Kommentar sagen, dass ein Element
    veraltet ist und möglicherweise mit der nächsten Version o.ä.
    entfernt wird. (siehe nächste Folie)

=\> Dies sind die Basis-Regeln aus dem populären Google-Java-Style
([Google Open Source 2022](#ref-googlestyleguide)).

## Veraltete Elemente

``` java
/**
 * Beschreibung Beschreibung Beschreibung.
 *
 * @deprecated As of v102, replaced by <code>Foo.fluppie()</code>.
 */
@Deprecated
public void wuppie() {}
```

- Annotation zum Markieren als “veraltet” (in der generierten
  Dokumentation): `@deprecated`
- Für Sichtbarkeit zur Laufzeit bzw. im Tooling/IDE: normale
  Code-Annotation `@Deprecated`

Dies ist ein guter Weg, um Elemente einer öffentlichen API als
“veraltet” zu kennzeichnen. Üblicherweise wird diese Kennzeichnung für
einige wenige Releases beibehalten und danach das veraltete Element aus
der API entfernt.

## Autoren, Versionen, …

``` java
/**
 * Beschreibung Beschreibung Beschreibung.
 *
 * @author  Dagobert Duck
 * @version V1
 * @since   schon immer
 */
```

- Annotationen für Autoren und Version: `@author`, `@version`, `@since`

Diese Annotationen finden Sie vor allem in Kommentaren zu Packages oder
Klassen.

## Was muss kommentiert werden?

- Alle `public` Klassen
- Alle `public` und `protected` Elemente der Klassen

<!-- -->

- Ausnahme: `@Override` (An diesen Methoden *kann*, aber *muss* nicht
  kommentiert werden.)

Alle anderen Elemente bei Bedarf mit *normalen* Kommentaren versehen.

### Beispiel aus dem JDK: ArrayList

Schauen Sie sich gern mal Klassen aus der Java-API an, beispielsweise
eine `java.util.ArrayList`:

- Generierte Dokumentation: [zu “ArrayList”
  runterscrollen](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/package-summary.html)
  bzw.
  [direkt](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- Quellcode:
  [ArrayList.java](https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/ArrayList.java)

### Best Practices: Was beschreibe ich eigentlich?

Unter [Documentation Best
Practices](https://github.com/google/styleguide/blob/gh-pages/docguide/best_practices.md#documentation-is-the-story-of-your-code)
finden Sie eine sehr gute Beschreibung, was das Ziel der Dokumentation
sein sollte. Versuchen Sie, dieses zu erreichen!

Etwas technisch, aber ebenfalls sehr lesenswert ist der Style-Guide für
Java-Software [How to Write Doc Comments for the Javadoc
Tool](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)
von

1.  

## Wrap-Up

- Javadoc-Kommentare sind normale Block-Kommentare beginnend mit `/**`
- Generierung der HTML-Dokumentation mit `javadoc *.java`
- Erste Zeile ist eine Zusammenfassung (fast immer sichtbar)
- Längerer Text danach als “Description” einer Methode/Klasse
- Annotationen für besondere Elemente: `@param`, `@return`, `@throws`,
  `@deprecated`

<!-- -->

- Faustregel: Alle `public` und `protected` Elemente mit Javadoc
  kommentieren!

## 📖 Zum Nachlesen

- Ullenboom ([2021, 23.4](#ref-Ullenboom2021))
- Google Open Source ([2022, Kap. 7](#ref-googlestyleguide))
- 1

> [!NOTE]
>
> <details>
>
> <summary><strong>✅ Lernziele</strong></summary>
>
> - k2: Ich verstehe den Sinn von Javadoc-Kommentaren
> - k2: Ich kenne den typischen Aufbau von Javadoc-Kommentaren
> - k3: Ich kann sämtliche öffentlich sichtbaren Elemente mit Javadoc
>   dokumentieren
> - k3: Ich kann eine sinnvolle Summary schreiben
> - k3: Ich kann verschiedene Annotationen zur Dokumentation von
>   Parametern, Rückgabetypen, Exceptions, veralteten Elementen
>   einsetzen
> - k3: Ich kann die Dokumentation generieren
>
> </details>

> [!TIP]
>
> <details>
>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie die Javadoc einiger Klassen im Dungeon-Projekt:
> [dojo.rooms.LevelRoom](https://github.com/Dungeon-CampusMinden/Dungeon/blob/31c0e3aaf25eb412a33751c897df43eb21bf2744/dojo-dungeon/src/dojo/rooms/LevelRoom.java),
> [dojo.rooms.MonsterRoom](https://github.com/Dungeon-CampusMinden/Dungeon/blob/31c0e3aaf25eb412a33751c897df43eb21bf2744/dojo-dungeon/src/dojo/rooms/MonsterRoom.java),
> und
> [contrib.components.HealthComponent](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/components/HealthComponent.java).
>
> Stellen Sie sich vor, Sie müssten diese Klassen in einer Übungsaufgabe
> nutzen (das könnte tatsächlich passieren!) …
>
> Können Sie anhand der Javadoc verstehen, wozu die drei Klassen dienen
> und wie Sie diese Klassen benutzen sollten? Vergleichen Sie die
> Qualität der Dokumentation. Was würden Sie gern in der Dokumentation
> finden? Was würden Sie ändern?
> </details>

------------------------------------------------------------------------

> [!NOTE]
>
> <details>
>
> <summary><strong>👀 Quellen</strong></summary>
>
> <div id="refs" class="references csl-bib-body hanging-indent">
>
> <div id="ref-googlestyleguide" class="csl-entry">
>
> Google Open Source. 2022. „Google Java Style Guide“.
> <https://google.github.io/styleguide/javaguide.html>.
>
> </div>
>
> <div id="ref-Ullenboom2021" class="csl-entry">
>
> Ullenboom, C. 2021. *Java ist auch eine Insel*. 16. Aufl.
> Rheinwerk-Verlag.
> <https://openbook.rheinwerk-verlag.de/javainsel/index.html>.
>
> </div>
>
> </div>
>
> </details>

------------------------------------------------------------------------

<img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png" width="10%">

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

<blockquote><p><sup><sub><strong>Last modified:</strong> 95a02cf (markdown: switch to leaner yaml header (#1037), 2025-08-09)<br></sub></sup></p></blockquote>
