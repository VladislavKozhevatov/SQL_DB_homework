package ru.hogwarts.school.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.service.impl.FacultyServiceImpl;
import ru.hogwarts.school.service.impl.StudentServiceImpl;

import java.awt.*;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name="Контроллер студентов", description = "Контроллер для работы со студентами")
public class StudentController {

    public StudentController() {
    }

    private StudentService studentService;
    private FacultyServiceImpl facultyServiceImple;
    private StudentServiceImpl studentServiceImple;
    private StudentRepository studentRepository;

    public StudentController(StudentService studentService, FacultyServiceImpl facultyServiceImple, StudentServiceImpl studentServiceImple, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.facultyServiceImple = facultyServiceImple;
        this.studentServiceImple = studentServiceImple;
        this.studentRepository = studentRepository;
    }

    //GET , POST, PUT, DELETE

    @PostMapping
    public Student addStudent (@RequestBody Student student){
        return studentService.addStudent(student);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Метод добавления студента",description = "метод для добавления студента в репозиторий")
    public Student updateStudent (@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name = "id") Long id){
        return studentService.getStudent(id);
    }

    @DeleteMapping ("/{id}")
    public void deleteStudent (@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("age_between")
    public ResponseEntity <Collection<Student>> getStudentsByAgeBetween(@RequestParam("min") int minAge, @RequestParam("max") int maxAge){
        Collection<Student> students = studentRepository.findByAgeBetween(minAge,maxAge);
        return ResponseEntity.ok(students);
    }

}
