package dependency.using_di.gradeservices;

import dependency.using_di.GradeService;

public class DummyGradeService implements GradeService {

  @Override
  public double getGrade(String matrikelnummer, String modulName) {
    return 1.0; // immer sehr gut :)
  }
}
