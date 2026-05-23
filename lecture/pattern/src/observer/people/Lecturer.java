package observer.people;

import observer.Observer;

public class Lecturer extends Person implements Observer {
  public Lecturer(String name) {
    super(name);
  }

  @Override
  public void update(String grade) {
    IO.println("Lecturer wurde benachrichtigt"); // TODO: use logging here
  }
}
