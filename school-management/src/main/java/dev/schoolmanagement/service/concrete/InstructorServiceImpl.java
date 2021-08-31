package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.Instructor;
import dev.schoolmanagement.repository.InstructorRepository;
import dev.schoolmanagement.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class InstructorServiceImpl implements InstructorService {
    InstructorRepository instructorRepository;

    @Override
    public Instructor save(Instructor instructor) {
        return null;
    }

    @Override
    public List<Instructor> findAll() {
        return null;
    }

    @Override
    public Instructor findById(long id) {
        return null;
    }

    @Override
    public void delete(Instructor instructor) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Instructor update(Instructor instructor) {
        return null;
    }
}