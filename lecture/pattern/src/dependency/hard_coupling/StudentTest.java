package dependency.hard_coupling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {
  @Test
  void createGradeMessage_usesHardCodedDependency() {
    // given
    Student student = new Student("123456", "Alex Muster");

    // when
    String message = student.printGradeFor("Programmieren 2");

    // then
    assertEquals("Alex Muster hat im Modul Programmieren 2 die Note 1.7 erreicht", message);
  }
}
