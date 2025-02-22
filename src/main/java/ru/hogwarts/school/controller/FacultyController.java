package ru.hogwarts.school.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.impl.FacultyServiceImpl;
import ru.hogwarts.school.service.impl.StudentServiceImpl;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/faculties")
//@AllArgsConstructor
@Tag(name="Контроллер факультетов", description = "Контроллер для работы с Факультетами")
public class FacultyController {

    public FacultyController() {
    }

    private FacultyServiceImpl facultyServiceImpl;
    private StudentServiceImpl studentServiceImpl;
    private StudentRepository studentRepository;
    private FacultyRepository facultyRepository;

    public FacultyController(FacultyServiceImpl facultyServiceImpl, StudentServiceImpl studentServiceImpl, StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.facultyServiceImpl = facultyServiceImpl;
        this.studentServiceImpl = studentServiceImpl;
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Collection<Faculty> findFaculties(@RequestParam(required = false)String color,
                                             @RequestParam(required = false)String name){
        if (color!=null&& !color.isBlank()){
            return facultyServiceImpl.findByColor(color);
        }
        if (name!=null && !name.isBlank()){
            return facultyServiceImpl.findByName(name);
        }
        return facultyServiceImpl.findAll();
    }


    //GET , POST, PUT, DELETE

    @PostMapping
    public Faculty addFaculty (@RequestBody Faculty faculty){
        return facultyServiceImpl.addFaculty(faculty);
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty (@PathVariable(name = "id") Long id,@RequestBody Faculty faculty){
        return facultyServiceImpl.updateFaculty(id, faculty);
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable(name = "id") Long id){
        return facultyServiceImpl.getFaculty(id);
    }

    @DeleteMapping ("/{id}")
    public void deleteFaculty (@PathVariable Long id){
        facultyServiceImpl.deleteFaculty(id);
    }

    @GetMapping
    public List<Faculty> getAll(){
        return facultyServiceImpl.getAll();
    }

//    @GetMapping Faculty getFacultyByStudentId(@PathVariable Long id){
//        return facultyRepository.findByFacultyId(id);
//    }

}
