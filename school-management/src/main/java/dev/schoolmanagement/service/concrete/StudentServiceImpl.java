package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.Student;
import dev.schoolmanagement.exceptions.StudentAlreadyExistsException;
import dev.schoolmanagement.repository.StudentRepository;
import dev.schoolmanagement.service.StudentService;
import dev.schoolmanagement.utility.StringConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        if (studentRepository.existsById(student.getId())) {
            throw new StudentAlreadyExistsException(StringConstants.STUDENT_ALREADY_EXISTS);
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(StringConstants.STUDENT_NOT_FOUND));
    }

    @Override
    public void delete(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new EntityNotFoundException(StringConstants.STUDENT_NOT_FOUND);
        }
        studentRepository.delete(student);
    }

    @Override
    public void deleteById(long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException(StringConstants.STUDENT_NOT_FOUND);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new EntityNotFoundException(StringConstants.STUDENT_NOT_FOUND);
        }
        return studentRepository.save(student);
    }
}