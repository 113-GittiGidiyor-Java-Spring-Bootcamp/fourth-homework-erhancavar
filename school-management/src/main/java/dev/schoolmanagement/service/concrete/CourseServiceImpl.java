package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.Course;
import dev.schoolmanagement.repository.CourseRepository;
import dev.schoolmanagement.service.CourseService;
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
    public Course save(Course course) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(long id) {
        return null;
    }

    @Override
    public void delete(Course course) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Course update(Course course) {
        return null;
    }
}