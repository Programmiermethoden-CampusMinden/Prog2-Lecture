In den Vorgaben finden Sie eine einfache Implementierung für einen Taschenrechner mit Java-Swing.
Dieser Taschenrechner kann nur mit `int`-Werten rechnen.
Der Taschenrechner verfügt über keinerlei vordefinierte mathematische Operationen (Addieren, Subtrahieren etc.).

Erstellen Sie eigene mathematische Operationen, die `IOperation` implementieren. Jede Ihrer Klassen soll mit einer Annotation vermerkt werden, in welcher der Name der jeweiligen Operation gespeichert wird.

Der Taschenrechner lädt seine Operationen dynamisch über die statische Methode `OperationLoader.loadOperations` ein.
In den Vorgaben ist diese Methode noch nicht ausimplementiert. Implementieren Sie die Funktion so, dass sie mit Hilfe von Reflection Ihre Operationen einliest. Geben Sie dazu den Ordner an, in dem die entsprechenden `.class`-Dateien liegen. (Dieser Ordner soll sich außerhalb Ihres Java-Projekts befinden!)
Verändern Sie nicht die Signatur der Methode.


Ihre Operation-Klassen dürfen Sie nicht vorher bekannt machen. Diese müssen in einem vom aktuellen Projekt separierten Ordner/Projekt liegen.
