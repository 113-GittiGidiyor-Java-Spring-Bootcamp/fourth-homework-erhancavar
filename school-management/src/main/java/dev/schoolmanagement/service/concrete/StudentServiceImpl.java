package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.Student;
import dev.schoolmanagement.repository.StudentRepository;
import dev.schoolmanagement.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Student update(Student student) {
        return null;
    }
}