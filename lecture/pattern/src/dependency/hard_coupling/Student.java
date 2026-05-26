package dependency.hard_coupling;

public class Student {
  private final String matrikelnummer;
  private final String name;

  public Student(String matrikelnummer, String name) {
    this.matrikelnummer = matrikelnummer;
    this.name = name;
  }

  public String printGradeFor(String modulName) {
    dependency.hard_coupling.Lsf lsf = new dependency.hard_coupling.Lsf(); // Harte Kopplung!
    double grade = lsf.getGrade(matrikelnummer, modulName);
    return String.format("%s hat im Modul %s die Note %s erreicht", name, modulName, grade);
  }
}
