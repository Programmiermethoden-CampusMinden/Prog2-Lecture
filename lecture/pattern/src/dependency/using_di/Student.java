package dependency.using_di;

public class Student {
  private final String matrikelnummer;
  private final String name;
  private final GradeService gradeService; // Dependency

  // Dependency Injection
  public Student(String matrikelnummer, String name, GradeService gradeService) {
    this.matrikelnummer = matrikelnummer;
    this.name = name;
    this.gradeService = gradeService;
  }

  public String printGradeFor(String modulName) {
    double grade = gradeService.getGrade(matrikelnummer, modulName);
    return String.format("%s hat im Modul %s die Note %s erreicht", name, modulName, grade);
  }
}
