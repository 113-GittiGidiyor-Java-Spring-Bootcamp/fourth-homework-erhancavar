package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.Course;
import dev.schoolmanagement.exceptions.CourseAlreadyExistsException;
import dev.schoolmanagement.exceptions.EntityNotFoundException;
import dev.schoolmanagement.repository.CourseRepository;
import dev.schoolmanagement.service.CourseService;
import dev.schoolmanagement.utility.StringConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;

    @Override
    @Transactional
    public Course save(Course course) {
        if (courseRepository.existsById(course.getId())) {
            throw new CourseAlreadyExistsException(StringConstants.COURSE_ALREADY_EXISTS);
        }
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(StringConstants.COURSE_NOT_FOUND));
    }

    @Override
    @Transactional
    public void delete(Course course) {
        if (!courseRepository.existsById(course.getId())) {
            throw new EntityNotFoundException(StringConstants.COURSE_NOT_FOUND);
        }
        courseRepository.delete(course);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        if (!courseRepository.existsById(id)) {
            throw new EntityNotFoundException(StringConstants.COURSE_NOT_FOUND);
        }
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        if (courseRepository.existsById(course.getId())) {
            throw new EntityNotFoundException(StringConstants.COURSE_NOT_FOUND);
        }
        return courseRepository.save(course);
    }
}