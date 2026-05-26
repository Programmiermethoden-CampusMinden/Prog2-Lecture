package dependency.using_di;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {
  @Test
  void createGradeMessage_usesInjectedGradeService() {
    // given
    GradeService fake = (_, modulName) -> modulName.equals("Programmieren 2") ? 1.3 : 4.0;
    Student student = new Student("123456", "Alex Muster", fake);

    // when
    String message = student.printGradeFor("Programmieren 2");

    // then
    assertEquals("Alex Muster hat im Modul Programmieren 2 die Note 1.3 erreicht", message);
  }
}
