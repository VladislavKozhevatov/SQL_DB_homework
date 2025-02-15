package ru.hogwarts.school.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.service.StudentService;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name="Контроллер студентов", description = "Контроллер для работы со студентами")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //GET , POST, PUT, DELETE

    @PostMapping
    public Student addStudent (Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Метод добавления студента",description = "метод для добавления студента в репозиторий")
    public Student updateStudent (@PathVariable(name = "id") Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
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

}
