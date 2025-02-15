package ru.hogwarts.school.service.impl;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.exeption.FacultyNotFoundExeption;
import ru.hogwarts.school.exeption.StudentNotFoundExeption;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.*;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

 //   private final Map<Long, Student> repository = new HashMap<>();
 //   private Long count = 0l;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
//        student.setId(++count);
//        repository.put(count, student);
//        return student;
    }

    @Override
    public Student updateStudent(Long id , Student student) {
        return studentRepository.save(student);
//        checkExistStudent(id);
//        student.setId(id);
//        repository.put(id,student);
//        return student;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
//        return repository.get(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
//        checkExistStudent(id);
//        repository.remove(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
//        return Collections.unmodifiableList(new ArrayList<>(repository.values()));
    }
//    public void checkExistStudent(Long id) {
//            if (!repository.containsKey(id)) {
//            throw new StudentNotFoundExeption("Студент с переданным id не существует");
//        }
//    }
}

