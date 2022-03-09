---
type: lecture-cg
title: "Logging"
menuTitle: "Logging"
author: "Carsten Gips (FH Bielefeld)"
weight: 1
readings:
  - key: "JDK-Doc"
    notes: "Kapitel 8: Java Logging Overview"
tldr: |
  TODO
outcomes:
  - k3: "Nutzung der Java Logging API im Paket `java.util.logging`"
  - k3: "Erstellung eigener Handler und Formatter"
quizzes:
  - link: "XYZ"
assignments:
  - topic: sheet01
youtube:
  - link: "https://youtu.be/XYZ"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/XYZ"
---


## Wie prüfen Sie die Werte von Variablen/Objekten?

1.  Debugging
    *   Beeinflusst Code nicht
    *   Kann schnell komplex und umständlich werden
    *   Sitzung transient -- nicht wiederholbar

\bigskip

2.  "Poor-man's-debugging" (Ausgaben mit `System.out.println`)
    *   Müssen irgendwann entfernt werden
    *   Ausgabe nur auf einem Kanal (Konsole)
    *   Keine Filterung nach Problemgrad -- keine Unterscheidung
        zwischen Warnungen, einfachen Informationen, ...

\bigskip

3.  **Logging**
    *   Verschiedene (Java-) Frameworks: \newline
        `java.util.logging` (JDK), *log4j* (Apache), *SLF4J*, *Logback*, ...


## Java Logging API -- Überblick

Paket `java.util.logging`

![](images/logging.png){width="80%"}

::: notes
Eine Applikation kann verschiedene Logger instanziieren. Die Logger bauen
per Namenskonvention hierarchisch aufeinander auf. Jeder Logger kann selbst
mehrere Handler haben, die eine Log-Nachricht letztlich auf eine bestimmte
Art und Weise an die Außenwelt weitergeben.

Log-Meldungen werden einem Level zugeordnet. Jeder Logger und Handler hat
ein Mindest-Level eingestellt, d.h. Nachrichten mit einem kleineren Level
werden verworfen.

Zusätzlich gibt es noch Filter, mit denen man Nachrichten (zusätzlich zum
Log-Level) nach weiteren Kriterien filtern kann.
:::

[Konsole: logging.LoggingDemo]{.bsp}


::: notes
## Erzeugen neuer Logger

```java
import java.util.logging.Logger;
Logger l = Logger.getLogger(MyClass.class.getName());
```

*   [**Factory-Methode**]{.alert} der Klasse `java.util.logging.Logger`

    ```java
    public static Logger getLogger(String name);
    ```

    => Methode liefert bereits **vorhandenen Logger** mit diesem Namen [(sonst neuen Logger)]{.notes}

*   [**Best Practice**]{.alert}: \newline
    Nutzung des voll-qualifizierten Klassennamen: `MyClass.class.getName()`
    *   Leicht zu implementieren
    *   Leicht zu erklären
    *   Spiegelt modulares Design
    *   Ausgaben enthalten automatisch Hinweis auf Herkunft (Lokalität) der Meldung
    *   **Alternativen**: Funktionale Namen wie "XML", "DB", "Security"
:::


## Ausgabe von Logmeldungen

```java
public void log(Level level, String msg);
```

\bigskip
\bigskip

*   Diverse Convenience-Methoden (Auswahl):

    ```java
    public void warning(String msg)
    public void info(String msg)
    public void entering(String srcClass, String srcMethod)
    public void exiting(String srcClass, String srcMethod)
    ```

\bigskip

*   Beispiel

    ```java
    import java.util.logging.Logger;
    Logger l = Logger.getLogger(MyClass.class.getName());
    l.info("Hello World :-)");
    ```


## Wichtigkeit von Logmeldungen: Stufen

*   `java.util.logger.Level` definiert 7 Stufen:
    *   `SEVERE`, `WARNING`, `INFO`, `CONFIG`, `FINE`, `FINER`, `FINEST` \newline
        (von höchster zu niedrigster Prio)
    *   Zusätzlich `ALL` und `OFF`

\bigskip

*   Nutzung der Log-Level:
    *   Logger hat Log-Level: Meldungen mit kleinerem Level werden verworfen
    *   Prüfung mit `public boolean isLoggable(Level)`
    *   Setzen mit `public void setLevel(Level)`

[Konsole: logging.LoggingLevel]{.bsp}

::: notes
=> Warum wird im Beispiel nach `log.setLevel(Level.ALL);` trotzdem nur
ab `INFO` geloggt? Wer erzeugt eigentlich die Ausgaben?!
:::


## Jemand muss die Arbeit machen ...

\bigskip

::: slides
![](images/logging.png){width="40%"}
:::

\bigskip

*   Pro Logger **mehrere** Handler möglich
    *   Logger übergibt nicht verworfene Nachrichten an Handler
    *   Handler haben selbst ein Log-Level (analog zum Logger)
    *   Handler verarbeiten die Nachrichten, wenn Level ausreichend

\smallskip

*   Standard-Handler: `StreamHandler`, `ConsoleHandler`, `FileHandler`

\smallskip

*   Handler nutzen zur Formatierung der Ausgabe einen `Formatter`
*   Standard-Formatter: `SimpleFormatter` und `XMLFormatter`

[Konsole: logging.LoggingHandler]{.bsp}

::: notes
=> Warum wird im Beispiel nach dem Auskommentieren von
`log.setUseParentHandlers(false);` immer noch eine zusätzliche Ausgabe
angezeigt (ab `INFO` aufwärts)?!
:::


## Ich ... bin ... Dein ... Vater ...

*   Logger bilden [**Hierarchie**]{.alert} über Namen
    *   Trenner für Namenshierarchie: "`.`" (analog zu Packages)  [=> mit jedem "`.`" wird eine weitere Ebene der Hierarchie aufgemacht ...]{.notes}
    *   Jeder Logger kennt seinen Eltern-Logger: `Logger#getParent()`
    *   Basis-Logger: leerer Name (`""`)
        *   Voreingestelltes Level des Basis-Loggers: `Level.INFO` (!)

\bigskip

*   Weiterleiten von Nachrichten
    *   Nicht verworfene Log-Aufrufe werden an Eltern-Logger weitergeleitet  [(Default)]{.notes}
        *   Abschalten mit `Logger#setUseParentHandlers(false);`
    *   Diese leiten  [an ihre Handler sowie]{.notes}  an ihren Eltern-Logger weiter (unabhängig von Log-Level!)

[Konsole: logging.LoggingParent; Tafel: Skizze Logger-Baum]{.bsp}


## Wrap-Up

*   Java Logging API im Paket `java.util.logging`
*   Logger über **Factory-Methode** der Klasse `Logger`
    *   Einstellbares Log-Level (Klasse `Level`)
    *   Handler kümmern sich um die Ausgabe, nutzen dazu Formatter
    *   Mehrere Handler je Logger registrierbar
    *   Log-Level auch für Handler einstellbar (!)
    *   Logger (und Handler) "interessieren" sich nur für Meldungen ab
        bestimmter Wichtigkeit
    *   Logger reichen nicht verworfene Meldungen defaultmäßig an
        Eltern-Logger weiter (rekursiv)







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO (what, where, license)
:::
