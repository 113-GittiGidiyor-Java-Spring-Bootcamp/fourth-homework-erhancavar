package dev.schoolmanagement.repository;

import dev.schoolmanagement.entity.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLogRepository extends JpaRepository<ExceptionLog, Long> {
}