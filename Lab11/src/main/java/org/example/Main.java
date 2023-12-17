package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException, StudentNotFoundException {
        String filename = "students.csv";
        StudentSystem studentSystem = new StudentSystem(filename);

        /*Optional<Student> student = studentSystem.getStudentById(10);
        System.out.println(student);

        Student highestGpaStudent = studentSystem.getHighestGPAStudent();
        System.out.println(highestGpaStudent);

        Student longestNameStudent = studentSystem.getLongestNameStudent();
        System.out.println(longestNameStudent); */

    }
}