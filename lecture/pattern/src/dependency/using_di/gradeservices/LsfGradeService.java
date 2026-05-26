package dependency.using_di.gradeservices;

import dependency.using_di.GradeService;
import dependency.using_di.Lsf;

public class LsfGradeService implements GradeService {
  private final Lsf lsf;

  public LsfGradeService(Lsf lsf) {
    this.lsf = lsf;
  }

  @Override
  public double getGrade(String matrikelnummer, String modulName) {
    return lsf.getGrade(matrikelnummer, modulName);
  }
}
