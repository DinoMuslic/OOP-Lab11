package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class StudentSystemTest {
    StudentSystem studentSystem = new StudentSystem("students.csv");

    @Test
    void testifStudentisPresent() {
        assertTrue(studentSystem.getStudents().size() > 0);
    }

    @Test
    void testStudentWithId100() throws StudentNotFoundException {
        Optional<Student> student = studentSystem.getStudentById(100);
        assertFalse(student.isEmpty());
    }

    @Test
    void testStudentNull() throws StudentNotFoundException {
        Optional<Student> student = studentSystem.getStudentById(55);
        assertTrue(student.isPresent());
    }

    @Test
    void testHighestGPAStudent() {
        Student student = studentSystem.getHighestGPAStudent();
        assertTrue(student.getName().equals("Mia Thomas"));
    }

    @Test
    void testExceptionForEmptyStudentList() {
        assertThrows(EmptyStudentListException.class, () -> {
            studentSystem.getStudents();
        });
    }

    @Test
    void testNamesArray() {
        List<Student> students = studentSystem.getStudents();
        String[] expectedNames = {"Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson"};
        String[] actualNames = new String[5];
        for(int i = 0; i < 5; i++) {
            actualNames[i] = students.get(i).getName();
        }
        assertArrayEquals(expectedNames, actualNames);
    }

    @Test
    void testSize() {
        assertTrue(studentSystem.getStudents().size() == 70);
    }

    @Test
    void testLargestName() {
        Student largestName = studentSystem.getLongestNameStudent();
        assertTrue(largestName.getName() != "Ava White");
    }

    @Test
    void  testStudents() {
        Student largestName = studentSystem.getLongestNameStudent();
        Student highestGPA = studentSystem.getHighestGPAStudent();

        assertTrue(!largestName.getName().equals(highestGPA.getName()));
    }

    @Test
    void testSameStudent() throws StudentNotFoundException {
        Optional<Student> studentID12 = studentSystem.getStudentById(12);
        Student highestGPA = studentSystem.getHighestGPAStudent();

        assertSame(studentID12, Optional.ofNullable(highestGPA));
    }
}