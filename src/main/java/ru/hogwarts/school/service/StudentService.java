package ru.hogwarts.school.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hogwarts.school.model.Student;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private Map<Long, Student> studentMap = new HashMap<>();
    private Long generatedStudentId = 0L;

    @PostConstruct
    void init() {
        ++generatedStudentId;
        Student student1 = new Student("Иван", 10);
        student1.setId(generatedStudentId);
        studentMap.put(generatedStudentId, student1);

        ++generatedStudentId;
        Student student2 = new Student("Петр", 15);
        student2.setId(generatedStudentId);
        studentMap.put(generatedStudentId, student2);

        ++generatedStudentId;
        Student student3 = new Student("Илья", 20);
        student3.setId(generatedStudentId);
        studentMap.put(generatedStudentId, student3);
    }

    public Student createStudent(Student student) {
        student.setId(++generatedStudentId);
        studentMap.put(generatedStudentId, student);
        return student;
    }

    public Student getStudent(Long studentId) {
        return studentMap.get(studentId);
    }

    public Collection<Student> getAllStudent() {
        return studentMap.values();
    }

    public Collection<Student> getAllStudentWhitAge(int age) {
        List<Student> studentList = new ArrayList<>(getAllStudent().stream()
                .filter(student -> student.getAge() <= age)
                .collect(Collectors.toList()));
        return studentList;
    }

    public Student updateStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            return studentMap.put(student.getId(), student);
        }
        return null;
    }

    public Student deleteStudent(Long studentId) {
        if (studentMap.containsKey(studentId)) {
            return studentMap.remove(studentId);
        }
        return null;
    }
}
