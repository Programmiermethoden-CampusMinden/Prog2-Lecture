
Betrachten Sie das folgende `IMonster`-Interface in den Vorgaben:

```java
public interface IMonster {
    String getVariety();
    int getXp();
    int getMagic();
    String makeNoise();
}
```

Leiten Sie von diesem Interface eine Klasse `Monster` ab. Nutzen Sie das Type-Object-Pattern
und erzeugen Sie verschiedene "Klassen" von Monstern, die sich in den Eigenschaften `variety`,
`xp` und `magic` unterscheiden und in der Methode `makeNoise()` entsprechend unterschiedlich
verhalten. Die Eigenschaft `xp` wird dabei von jedem Monster während seiner Lebensdauer selbst
verwaltet, die anderen Eigenschaften bleiben während der Lebensdauer eines Monsters konstant
(ebenso wie die Methode `makeNoise()`).

1.  Was wird Bestandteil des Type-Objects? Begründen Sie Ihre Antwort.
2.  Implementieren Sie das Type-Object und integrieren Sie es in die Klasse `Monster`.
3.  Implementieren Sie eine Factory-Methode in der Klasse für die Type-Objects, um ein neues
    Monster mit diesem Type-Objekt erzeugen zu können.
4.  Implementieren Sie einen "Vererbungs"-Mechanismus für die Type-Objects (nicht Vererbung
    im Java-/OO-Sinn!). Dabei soll eine Eigenschaft überschrieben werden können.
5.  Erzeugen Sie einige Monstertypen und jeweils einige Monster und lassen Sie diese ein
    Geräusch machen (`makeNoise()`).
6.  Ersetzen Sie das Type-Object durch ein selbst definiertes (komplexes) Enum.
