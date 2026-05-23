package observer.people;

public abstract class Person {
  protected final String name;

  Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "I'm " + name;
  }
}
