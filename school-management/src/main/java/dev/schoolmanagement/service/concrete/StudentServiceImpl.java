package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.DTO.StudentDTO;
import dev.schoolmanagement.entity.Student;
import dev.schoolmanagement.exceptions.StudentAlreadyExistsException;
import dev.schoolmanagement.mappers.StudentMapper;
import dev.schoolmanagement.repository.StudentRepository;
import dev.schoolmanagement.service.StudentService;
import dev.schoolmanagement.utility.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;

    @Override
    public StudentDTO save(StudentDTO student) {
        return studentMapper.mapToDTO(studentRepository.save(studentMapper.mapToPersistable(student)));
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map((e)-> studentMapper.mapToDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(long id) {
        return studentMapper.mapToDTO(studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Constants.STUDENT_NOT_FOUND)));
    }

    @Override
    public void deleteById(long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException(Constants.STUDENT_NOT_FOUND);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO update(StudentDTO student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new EntityNotFoundException(Constants.STUDENT_NOT_FOUND);
        }
        return studentMapper.mapToDTO(studentRepository.save(studentMapper.mapToPersistable(student)));
    }
}