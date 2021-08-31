package dev.schoolmanagement.repository;

import dev.schoolmanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}