package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static ru.hogwarts.school.constants.Constants.*;
import static ru.hogwarts.school.constants.Constants.DEFAULT_COLLECTION_FACULTY;

class StudentServiceTest {

    private final StudentService out = new StudentService();

    @Test
    void createStudent() {
        Student result = out.createStudent(DEFAULT_STUDENT1);
        assertTrue(result.equals(DEFAULT_STUDENT1));
        assertEquals(result, DEFAULT_STUDENT1);
    }

    @Test
    void getStudent() {
        out.createStudent(DEFAULT_STUDENT1);
        Student result = out.getStudent(DEFAULT_STUDENT_ID);
        assertTrue(result.equals(DEFAULT_STUDENT1));
        assertEquals(result, DEFAULT_STUDENT1);
    }

    @Test
    void getAllStudent() {
        out.createStudent(DEFAULT_STUDENT1);
        Student result = out.getStudent(DEFAULT_STUDENT_ID);
        assertTrue(result.equals(DEFAULT_STUDENT1));
        assertEquals(result, DEFAULT_STUDENT1);
    }

    @Test
    void getAllStudentWhitAge() {
        out.createStudent(DEFAULT_STUDENT1);
        Collection<Student> result = out.getAllStudentWhitAge(DEFAULT_STUDENT_AGE);
        assertTrue(result.equals(DEFAULT_COLLECTION_STUDENT));
        assertEquals(result, DEFAULT_COLLECTION_STUDENT);
    }

    @Test
    void updateStudent() {
        out.createStudent(DEFAULT_STUDENT1);
        Student result1 = out.updateStudent(DEFAULT_STUDENT2);
        assertTrue(result1.equals(DEFAULT_STUDENT1));
        assertEquals(result1, DEFAULT_STUDENT1);

        Student result2 = out.getStudent(DEFAULT_STUDENT_ID);
        assertEquals(result2, DEFAULT_STUDENT2);
    }

    @Test
    void deleteStudent() {
        out.createStudent(DEFAULT_STUDENT1);
        Student result = out.deleteStudent(DEFAULT_FACULTY_ID);
        assertTrue(result.equals(DEFAULT_STUDENT1));
        assertEquals(result, DEFAULT_STUDENT1);
    }

    @Test
    void deleteNotFoundFaculty() {
        out.createStudent(DEFAULT_STUDENT2);
        out.deleteStudent(DEFAULT_STUDENT_ID);
        Student result = out.getStudent(DEFAULT_STUDENT_ID);
        assertNull(result);

    }
}