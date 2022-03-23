---
type: lecture-cg
title: "Javadoc"
menuTitle: "Javadoc"
author: "Carsten Gips (FH Bielefeld)"
weight: 3
readings:
  - key: "Ullenboom2021"
    comment: "Kap. 23.4: Dokumentationskommentare mit Javadoc"
  - key: "googlestyleguide"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
assignments:
  - topic: sheet01
youtube:
  - link: "https://youtu.be/XYZ"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/XYZ"
---


## Dokumentation mit Javadoc

```java
/**
 * Beschreibung Beschreibung Beschreibung
 *
 * @author  Dagobert Duck
 * @version V1
 * @since   schon immer
 * @param   date   Tag, Wert zw. 1 .. 31
 * @return  nix (nur zur Demo)
 * @see     java.util.Calendar
 * @deprecated As of JDK version 1.1
 */
public void setDate(int date) {
    setField(Calendar.DATE, date);
}
```

[[Javadoc-Regeln an java.util.Date diskutieren; Doku für annotations.B generieren und diskutieren]{.bsp}]{.notes}


## Regeln für die Dokumentation mit Javadoc

*   Javadoc-Kommentare beginnen mit `/**` und enden mit `*/`
    *   Meist mit `*` am Anfang jeder Kommentarzeile: Wird von Javadoc ignoriert
*   Erste Zeile bei Methoden/Attributen geht in die "Summary", Rest in die "Details"
*   Annotationen für Autoren und Version: `@author`, `@version`, `@since`
*   Annotationen zur Erklärung der Parameter und der Rückgabewerte: `@param`, `@return`
*   Annotation zum Markieren als veraltet: `@deprecated`
    *   für Sichtbarkeit zur Laufzeit: normale Code-Annotation `@Deprecated`
*   Verweise mit `@see` bzw. `{@link ...}`
*   Generation der Doku mit `javadoc *.java` bzw. aus Eclipse:
    `File > Export > Javadoc`


## Wrap-Up
...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
