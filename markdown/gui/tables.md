---
type: lecture-cg
title: "Swing: Tabellen"
menuTitle: "Swing: Tabellen"
author: "Carsten Gips (FH Bielefeld)"
weight: 5
readings:
  - key: "Java-SE-Tutorial"
    comment: "Creating Graphical User Interfaces > Creating a GUI With Swing"
  - key: "Ullenboom2021"
    comment: "Kap. 18: Einführung in grafische Oberflächen"
tldr: |
  TODO

    *   Komplexe Daten mit `JTable` anzeigen
    *   Swing-Komponenten (nicht nur `JTable`!) haben Datenmodelle,
        können separat erzeugt werden, haben eigene Listener, ...
    *   Trennung Daten und Anzeige: MVC-Pattern

outcomes:
  - k2: "Trennung von Anzeige und Daten: View und Model (MVC-Pattern)"
  - k3: "Anzeige von Tabellen mit JTable"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
youtube:
  - link: ""
    name: "VL Swing: Tabellen"
  - link: ""
    name: "Demo Swing: Tabellen"
  - link: ""
    name: "Demo Swing: Tabellen"
fhmedia:
  - link: ""
    name: "VL Swing: Tabellen"
---


## Einfache Tabelle mit festen Daten

*   Einfache Tabelle erzeugen:

    ```java
    public JTable(final Object[][] rowData,
       final Object[] columnNames)
    ```

*   Daten gleich mit erzeugen/übergeben:

    ```java
    Object[][] rowData = {
    { "Hein", "Bloed", new Integer(5) },
    { "Susi", "Studi", new Integer(2) } };
    ```

*   Tabellenkopf als einfaches Array:

    ```java
    Object[] columnNames = { "Vorname", "Name", "ect" };
    ```

*   Tabelle soll allen Platz im Container nutzen:

    ```java
    table.setFillsViewportHeight(true);
    ```

[Beispiel: java2d.swing.tabledemo.SimpleTableDemo]{.bsp}


## Selektierbare und sortierbare Tabelle

*   Tabelle sortierbar machen:

    ```java
    table.setAutoCreateRowSorter(true);
    ```

*   Selektion erkennen und reagieren mit MouseListener:

    ```java
    table.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            TableModel model = table.getModel();
            int c = table.getSelectedColumn();  // selektierte Spalte
            int r = table.getSelectedRow();     // selektierte Zeile
            model.getValueAt(r, c);         // Wert in Zeile r, Spalte c
    }});
    ```

[Beispiel: java2d.swing.tabledemo.SelectTableDemo]{.bsp}


## Einschub: MVC-Pattern

<!-- TODO ausarbeiten -->
TODO ausarbeiten (Abbildung ist nur Platzhalter)

![](images/MVC.png){width="80%"}


## Daten in separatem Modell

*   Modell muss von `AbstractTableModel` ableiten
*   Methoden zur Interaktion mit Tabelle implementieren!
*   Tabelle wird über Instanz von diesem Modell erzeugt
*   Tabelle ist View und Controller zugleich, trägt sich bei Erzeugung
    als Listener beim Modell ein
*   Modell muss die Tabelle über Änderungen an den Daten informieren:
    ```java
    fireTableCellUpdated(row, col);
    ```

\bigskip
=> Kapselung der Daten! Müssen nicht als Array o.ä. vorliegen!

[Beispiel: java2d.swing.tabledemo.ModelTableDemo]{.bsp}


## Modelleigenschaften

*   Korrekte Spalten-Typen und damit bessere Anzeige:

    ```java
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    ```

*   Spalten können gegen Editieren gesperrt werden:

    ```java
    public boolean isCellEditable(int row, int col) {
        return (col<2) ? false : true;
    }
    ```

*   Kontrolle über Änderung der Daten in `setValueAt()`

*   Daten können in beliebigem Format vorliegen! Interface nach
    "aussen" dennoch tabellenartig.


## Eigene Listener beim Modell registrieren

```java
TableModel m = table.getModel();
m.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        int changeType = e.getType();
        ...
    }
});
```

[Beispiel: java2d.swing.tabledemo.ModelListenerTableDemo]{.bsp}


## Wrap-Up

*   Fortgeschrittene Swing-Komponenten
    *   Komplexe Daten mit `JTable` anzeigen
    *   Swing-Komponenten (nicht nur `JTable`!) haben Datenmodelle,
        können separat erzeugt werden, haben eigene Listener, ...
*   Trennung Daten und Anzeige: MVC-Pattern







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
