package dev.schoolmanagement.repository;

import dev.schoolmanagement.entity.ExceptionLog;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExceptionLogRepository extends JpaRepository<ExceptionLog, Long> {
    List<ExceptionLog> findAllByType(String type);
    List<ExceptionLog> findAllByCreatedDate(Local creationDate);
}