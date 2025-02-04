package com.example.dto.students;

import com.example.model.Student;

public class StudentPage {
    private Student student;

    public StudentPage(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
