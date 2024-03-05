import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {

    private static List<Student> students;

    @BeforeAll
    public static void initClass() {
        students = new ArrayList<>();
    }

    @AfterAll
    public static void cleanClass() {
        students.clear();
    }

    @BeforeEach
    public void initMethod() {
        // First Student
        Student student1 = new Student("John Doe", 20);
        student1.enrollCourse("Math");
        student1.enrollCourse("English");
        student1.setGrade("Math", "A");
        students.add(student1);

        // Second Student
        Student student2 = new Student("Jane Doe", 22);
        student2.enrollCourse("History");
        student2.enrollCourse("Science");
        student2.setGrade("History", "B");
        students.add(student2);
    }

    @AfterEach
    public void cleanMethod() {
        students.clear();
    }

    @Test
    public void testDataCreation() {
        assertEquals(2, students.size());

        assertAll(
                () -> assertEquals("John Doe", students.get(0).getName()),
                () -> assertEquals(20, students.get(0).getAge()),
                () -> assertEquals(2, students.get(0).getEnrolledCourses().size()),
                () -> assertEquals("Math", students.get(0).getEnrolledCourses().get(0)),
                () -> assertEquals("English", students.get(0).getEnrolledCourses().get(1))
        );

        assertAll(
                () -> assertEquals("Jane Doe", students.get(1).getName()),
                () -> assertEquals(22, students.get(1).getAge()),
                () -> assertEquals(2, students.get(1).getEnrolledCourses().size()),
                () -> assertEquals("History", students.get(1).getEnrolledCourses().get(0)),
                () -> assertEquals("Science", students.get(1).getEnrolledCourses().get(1)),
                () -> assertEquals("B", students.get(1).getGrade("History"))
        );
    }

    @Test
    public void testStudentEnrollment() {
        Student student = new Student("Jane Doe", 22);
        student.enrollCourse("History");
        students.add(student);

        assertEquals(2, students.size());
        assertEquals(1, students.get(1).getEnrolledCourses().size());
        assertEquals("History", students.get(1).getEnrolledCourses().get(0));
    }

    @Test
    public void testStudentGrade() {
        assertEquals("A", students.get(0).getGrade("Math"));
        assertNull(students.get(0).getGrade("English")); // Assuming no grade set for English
    }
}