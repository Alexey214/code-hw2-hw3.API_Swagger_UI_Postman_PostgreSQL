package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty facultyTmp = facultyService.getFaculty(id);
        if (facultyTmp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyTmp);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty() {
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }

    @GetMapping("color/{color}")
    public ResponseEntity<Collection<Faculty>> getAllFacultyWhitAge(@PathVariable String color) {
        Collection<Faculty> facultyTmp = facultyService.getAllFacultyWhitColor(color);
        if (facultyTmp.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyTmp);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty facultyTmp = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(facultyTmp);
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty facultyTmp = facultyService.updateFaculty(faculty);
        if (facultyTmp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyTmp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        Faculty facultyTmp = facultyService.deleteFaculty(id);
        if (facultyTmp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyTmp);
    }
}
