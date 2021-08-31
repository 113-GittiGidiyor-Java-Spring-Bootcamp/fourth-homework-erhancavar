package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.Instructor;
import dev.schoolmanagement.exceptions.EntityNotFoundException;
import dev.schoolmanagement.exceptions.InstructorAlreadyExistsException;
import dev.schoolmanagement.repository.InstructorRepository;
import dev.schoolmanagement.service.InstructorService;
import dev.schoolmanagement.utility.Constants;
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
    @Transactional
    public Instructor save(Instructor instructor) {
        if (instructorRepository.existsById(instructor.getId())) {
            throw new InstructorAlreadyExistsException(Constants.INSTRUCTOR_ALREADY_EXISTS);
        }
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findById(long id) {
        return instructorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Constants.INSTRUCTOR_NOT_FOUND));
    }

    @Override
    public void delete(Instructor instructor) {
        if (!instructorRepository.existsById(instructor.getId())) {
            throw new EntityNotFoundException(Constants.INSTRUCTOR_NOT_FOUND);
        }
        instructorRepository.delete(instructor);
    }

    @Override
    public void deleteById(long id) {
        if (!instructorRepository.existsById(id)) {
            throw new EntityNotFoundException(Constants.INSTRUCTOR_NOT_FOUND);
        }
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        if (!instructorRepository.existsById(instructor.getId())) {
            throw new EntityNotFoundException(Constants.INSTRUCTOR_NOT_FOUND);
        }
        return instructorRepository.save(instructor);
    }
}