package dev.schoolmanagement.repository;

import dev.schoolmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}