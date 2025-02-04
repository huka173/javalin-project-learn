package com.example.dto.students;

import com.example.model.Student;
import java.util.List;

public class StudentsPage {
    private List<Student> arrStudent;

    public StudentsPage(List<Student> arrStudent) {
        this.arrStudent = arrStudent;
    }

    public List<Student> getArrStudent() {
        return arrStudent;
    }
}
