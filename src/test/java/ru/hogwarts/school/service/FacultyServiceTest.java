//package ru.hogwarts.school.service;
//
//import org.junit.jupiter.api.Test;
//import ru.hogwarts.school.model.Faculty;
//
//import java.util.Collection;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static ru.hogwarts.school.constants.Constants.*;
//
//class FacultyServiceTest {
//
//    private final FacultyService out = new FacultyService(facultyRepository);
//
//    @Test
//    void createFaculty() {
//        Faculty result = out.createFaculty(DEFAULT_FACULTY1);
//        assertTrue(result.equals(DEFAULT_FACULTY1));
//        assertEquals(result, DEFAULT_FACULTY1);
//    }
//
//    @Test
//    void getFaculty() {
//        out.createFaculty(DEFAULT_FACULTY1);
//        Faculty result = out.getFaculty(DEFAULT_FACULTY_ID);
//        assertTrue(result.equals(DEFAULT_FACULTY1));
//        assertEquals(result, DEFAULT_FACULTY1);
//    }
//
//    @Test
//    void getAllFaculty() {
//        out.createFaculty(DEFAULT_FACULTY1);
//        Faculty result = out.getFaculty(DEFAULT_FACULTY_ID);
//        assertTrue(result.equals(DEFAULT_FACULTY1));
//        assertEquals(result, DEFAULT_FACULTY1);
//    }
//
//    @Test
//    void getAllFacultyWhitColor() {
//        out.createFaculty(DEFAULT_FACULTY1);
//        Collection<Faculty> result = out.getAllFacultyWhitColor(DEFAULT_FACULTY_COLOR);
//        assertTrue(result.equals(DEFAULT_COLLECTION_FACULTY));
//        assertEquals(result, DEFAULT_COLLECTION_FACULTY);
//    }
//
//    @Test
//    void updateFaculty() {
//        out.createFaculty(DEFAULT_FACULTY1);
//        Faculty result1 = out.updateFaculty(DEFAULT_FACULTY2);
//        assertTrue(result1.equals(DEFAULT_FACULTY1));
//        assertEquals(result1, DEFAULT_FACULTY1);
//
//        Faculty result2 = out.getFaculty(DEFAULT_FACULTY_ID);
//        assertEquals(result2, DEFAULT_FACULTY2);
//    }
//
//
//    @Test
//    void deleteFaculty() {
//        out.createFaculty(DEFAULT_FACULTY1);
//        Faculty result = out.deleteFaculty(DEFAULT_FACULTY_ID);
//        assertTrue(result.equals(DEFAULT_FACULTY1));
//        assertEquals(result, DEFAULT_FACULTY1);
//    }
//
//    @Test
//    void deleteNotFoundFaculty() {
//        out.createFaculty(DEFAULT_FACULTY2);
//        out.deleteFaculty(DEFAULT_FACULTY_ID);
//        Faculty result = out.getFaculty(DEFAULT_FACULTY_ID);
//        assertNull(result);
//    }
//}