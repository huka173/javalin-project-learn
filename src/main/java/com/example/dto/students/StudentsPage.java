package com.example.dto.students;

import com.example.model.Student;
import java.util.List;

public class StudentsPage {
    private List<Student> students;
    private String search;

    public StudentsPage(List<Student> students, String search) {
        this.students = students;
        this.search = search;
    }

    public List<Student> getArrStudent() {
        return students;
    }

    public String getSearch() {
        return search;
    }
}
