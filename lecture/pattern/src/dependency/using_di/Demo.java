package dependency.using_di;

import dependency.using_di.gradeservices.DummyGradeService;
import dependency.using_di.gradeservices.LsfGradeService;

public class Demo {
  public static void main(String[] args) throws InterruptedException {
    // Echtes LSF
    Lsf lsf = new Lsf();
    GradeService gradeService = new LsfGradeService(lsf);

    Student alex = new Student("123456", "Alex Muster", gradeService);
    alex.printGradeFor("Programmieren 2");

    // Dummy-LSF
    GradeService dummy = new DummyGradeService();
    Student chris = new Student("654321", "Chris Beispiel", dummy);
    chris.printGradeFor("Programmieren 2");
  }
}
