package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.DTO.CourseDTO;
import dev.schoolmanagement.exceptions.EntityNotFoundException;
import dev.schoolmanagement.mappers.CourseMapper;
import dev.schoolmanagement.repository.CourseRepository;
import dev.schoolmanagement.service.CourseService;
import dev.schoolmanagement.utility.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    CourseMapper courseMapper;

    @Override
    @Transactional
    public CourseDTO save(CourseDTO course) {
        return courseMapper.mapToDTO(courseRepository.save(courseMapper.mapToEntity(course)));
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map((e) -> courseMapper.mapToDTO(e)).collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(long id) {
        return courseMapper.mapToDTO(courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Constants.COURSE_NOT_FOUND)));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        if (!courseRepository.existsById(id)) {
            throw new EntityNotFoundException(Constants.COURSE_NOT_FOUND);
        }
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CourseDTO update(CourseDTO course) {
        if (courseRepository.existsById(course.getId())) {
            throw new EntityNotFoundException(Constants.COURSE_NOT_FOUND);
        }
        return courseMapper.mapToDTO(courseRepository.save(courseMapper.mapToEntity(course)));
    }
}