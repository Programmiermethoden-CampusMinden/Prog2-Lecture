package observer;

import java.util.List;
import observer.people.Lecturer;
import observer.people.Student;
import observer.people.Tutor;

public class Demo {
  public static void main(String[] args) throws InterruptedException {

    List<Observer> persons =
        List.of(
            new Lecturer("Frau Holle"),
            new Student("Heinz"),
            new Student("Karla"),
            new Tutor("Kolja"),
            new Student("Wuppie"));

    LSF lsf = new LSF();
    for (var p : persons) lsf.register(p);

    // Noten-Einträge im LSF passieren asynchron (nicht gezeigt)
    lsf.notifyGradings();
  }
}
