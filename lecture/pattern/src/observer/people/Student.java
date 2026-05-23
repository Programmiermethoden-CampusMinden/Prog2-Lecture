package observer.people;

import observer.Observer;

public class Student extends Person implements Observer {
  public Student(String name) {
    super(name);
  }

  public String toString() {
    return super.toString();
  }

  @Override
  public void update(String grade) {
    IO.println("Studi wurde benachrichtigt: " + grade); // TODO: use logging here
  }
}
