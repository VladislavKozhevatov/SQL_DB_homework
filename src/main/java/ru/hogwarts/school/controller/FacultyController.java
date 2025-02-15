package ru.hogwarts.school.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.service.impl.FacultyServiceImpl;
import java.util.List;
import java.awt.*;


@RestController
@RequestMapping("/faculties")
@AllArgsConstructor
@Tag(name="Контроллер факультетов", description = "Контроллер для работы с Факультетами")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    //GET , POST, PUT, DELETE

    @PostMapping
    public Faculty addFaculty (Faculty faculty){
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty (@PathVariable(name = "id") Long id,@RequestBody Faculty faculty){
        return facultyService.updateFaculty(id, faculty);
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable(name = "id") Long id){
        return facultyService.getFaculty(id);
    }

    @DeleteMapping ("/{id}")
    public void deleteFaculty (@PathVariable Long id){
        facultyService.deleteFaculty(id);
    }

    @GetMapping
    public List<Faculty> getAll(){
        return facultyService.getAll();
    }

}
