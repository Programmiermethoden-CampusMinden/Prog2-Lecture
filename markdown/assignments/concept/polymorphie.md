## Vererbung und dynamische Polymorphie

Erklären Sie folgenden Code. Welche Ausgabe würde man jeweils erhalten, wenn
man `a1`, `a2`, `a3` und `b1` mit Hilfe von `System.out.println()` ausgeben
würde? Begründen Sie Ihre Antwort!

```java
class A {
    int val = 0;

    A() { this(42); }
    A(int v) { val = v; }
    public String toString() { return String.valueOf(val); }
}
class B extends A {
    int val = 10;

    public static void main(String[] args) {
        A a1 = new A();    A a2 = new A(3);    A a3 = new B();    B b1 = new B();
    }
}
```

<!-- XXX
1) a1: 42 (Verkettung Konstruktoren für A)
2) a2: 3  (normaler Konstruktoraufruf für A)
3) a3: 42 (dynamische Polymorphie, B.val **verdeckt** A.val, toString ist nur in A impl: greift auf A.val zu)
4) b1: 42 (B.val verdeckt A.val, toString ist nur in A: greift auf A.val zu)

für B spendiert Java einen Default-Konstruktor!
-->


Was würde sich ändern, wenn die Klasse `B` den folgenden Konstruktor hätte?
Begründen Sie Ihre Antwort!

```java
    B() { super(); val = 9; }
```

<!-- XXX
Es würde sich (fast) NIX ändern :)

* A.val wird nach wie vor von B.val **verdeckt**.
* B.val würde mit 9 statt 10 initialisiert
-->


Was würde sich ändern, wenn die Klasse `B` zusätzlich folgende Methode hätte?
Begründen Sie Ihre Antwort!

```java
    public String toString(int val) { return String.valueOf(val); }
```

<!-- XXX
Es würde sich (fast) NIX ändern :)

B.toString(int) ist eine **Überladung** der von A geerbten B.toString(): würde bei
System.out.println() gar nicht aufgerufen
-->

[Sicherer Umgang mit Vererbung und dynamischer Polymorphie (Wiederholung, Vertiefung)]{.thema}
