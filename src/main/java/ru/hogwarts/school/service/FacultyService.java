package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long generatedFacultyId = 0L;

    @PostConstruct
    void init() {
        ++generatedFacultyId;
        Faculty faculty1 = new Faculty("Иван", "red");
        faculty1.setId(generatedFacultyId);
        facultyMap.put(generatedFacultyId, faculty1);

        ++generatedFacultyId;
        Faculty faculty2 = new Faculty("Петр", "green");
        faculty2.setId(generatedFacultyId);
        facultyMap.put(generatedFacultyId, faculty2);

        ++generatedFacultyId;
        Faculty faculty3 = new Faculty("Илья", "blue");
        faculty3.setId(generatedFacultyId);
        facultyMap.put(generatedFacultyId, faculty3);
    }

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++generatedFacultyId);
        facultyMap.put(generatedFacultyId, faculty);
        return faculty;
    }

    public Faculty getFaculty(Long facultyId) {
        return facultyMap.get(facultyId);
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyMap.values();
    }

    public Collection<Faculty> getAllFacultyWhitColor(String color) {
        List<Faculty> facultyList = new ArrayList<>(getAllFaculty().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList()));
        return facultyList;
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())) {
            return facultyMap.put(faculty.getId(), faculty);
        }
        return null;
    }

    public Faculty deleteFaculty(Long facultyId) {
        if (facultyMap.containsKey(facultyId)) {
            return facultyMap.remove(facultyId);
        }
        return null;
    }
}
