package com.example.dto.students;

import com.example.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
@Getter
public class StudentsPage {
    private List<Student> students;
    private String search;
    private String flash;
}
