package dev.schoolmanagement.repository;

import dev.schoolmanagement.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}