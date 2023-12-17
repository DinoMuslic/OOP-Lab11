package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentSystem {
    private static List<Student> students;

    public List<Student> getStudents() {
        if(this.students.size() == 0) {
            throw new EmptyStudentListException("Empty student list");
        }
        return this.students;
    }

    public StudentSystem(String filename) {
        try {
            students = readStudents(filename);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static List<Student> readStudents(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        ArrayList<String> students = (ArrayList<String>) bufferedReader.lines().collect(Collectors.toList());
        List<Student> studentList = new ArrayList<>();
        for(String student : students) {
            String[] line = student.split(",");
            Student temp = new Student(Integer.parseInt(line[0]), line[1], line[2], line[3], Double.parseDouble(line[4]));
            studentList.add(temp);
        }

        bufferedReader.close();
        return studentList;
    }

    public static Optional<Student> getStudentById(int id) throws StudentNotFoundException {
        for(Student student : students) {
            if(student.getId() == id) {
                return Optional.ofNullable(student);
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    public static Student getHighestGPAStudent() {
        if(students.size() == 0) {
            throw new EmptyStudentListException("List of students is empty");
        }

        Student highestGpaStudent = students.get(0);
        for(Student student : students) {
            if(student.getGpa() > highestGpaStudent.getGpa()) {
                highestGpaStudent = student;
            }
        }
        return highestGpaStudent;
    }

    public static Student getLongestNameStudent() {
        if(students.size() == 0) {
            throw new EmptyStudentListException("List of students is empty");
        }

        Student longestNameStudent = students.get(0);
        for(Student student : students) {
            if(student.getName().length() > longestNameStudent.getName().length()) {
                longestNameStudent = student;
            }
        }
        return longestNameStudent;
    }
}
