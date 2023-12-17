package org.example;

public class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}
