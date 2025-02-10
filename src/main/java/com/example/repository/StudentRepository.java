package com.example.repository;

import com.example.model.Student;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class StudentRepository {
    private static List<Student> entities = new ArrayList<>(List.of(
            new Student(1L, "Andrew", "Brown", "fwfw@gmail.com"),
            new Student(2L, "Jack", "Cock", "123@ya.ru"),
            new Student(3L, "Amar", "Loskich", "losk_ich@test.com")
    ));

    public static void save(Student student) {
        student.setId((long) entities.size() + 1);
        entities.add(student);
    }

    public static List<Student> search(String str) {
        var lowerStr = str.toLowerCase();
        return entities.stream()
                .filter(elem -> {
                    if (elem.getFirstName().toLowerCase().startsWith(lowerStr)
                            || elem.getLastName().toLowerCase().startsWith(lowerStr)) {
                        return true;
                    }

                    return false;
                })
                .toList();
    }

    public static Optional<Student> find(Long id) {
        return entities.stream()
                .filter(elem -> elem.getId().equals(id))
                .findAny();
    }
}
