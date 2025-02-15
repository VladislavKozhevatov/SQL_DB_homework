package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exeption.FacultyNotFoundExeption;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;


import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


//    private final Map<Long, Faculty> repository = new HashMap<>();
//    private Long count = 0l;


    @Override
    public Faculty addFaculty(Faculty faculty) {
       return facultyRepository.save(faculty);
//        faculty.setId(++count);
//        repository.put(count,faculty);
//        return faculty;
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
      return facultyRepository.save(faculty);
//        checkExistFaculty(id);
//        faculty.setId(id);
//        repository.put(id,faculty);
//        return faculty;
    }

    @Override
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).get();
//        return repository.get(id);
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
//        checkExistFaculty(id);
//        repository.remove(id);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
//        return Collections.unmodifiableList(new ArrayList<>(repository.values()));
    }

//    public void checkExistFaculty(Long id) {
//        if (!repository.containsKey(id)) {
//            throw new FacultyNotFoundExeption("Факультет с переданным id не существует");
//        }
//    }

}
