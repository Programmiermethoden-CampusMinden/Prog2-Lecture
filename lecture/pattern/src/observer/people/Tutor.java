package observer.people;

import observer.Observer;

public class Tutor extends Student implements Observer {
  public Tutor(String name) {
    super(name);
  }

  @Override
  public void update(String grade) {
    IO.println("Tutor wurde benachrichtigt"); // TODO: use logging here
  }
}
