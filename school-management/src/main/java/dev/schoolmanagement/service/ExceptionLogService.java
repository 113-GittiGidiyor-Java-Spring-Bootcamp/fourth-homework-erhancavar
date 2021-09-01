package dev.schoolmanagement.service;


import dev.schoolmanagement.DTO.ExceptionLogDTO;

import java.time.Instant;
import java.util.List;


public interface ExceptionLogService extends LogService<ExceptionLogDTO> {
    List<ExceptionLogDTO> findAllByCreationDate(Instant creationDate);

    List<ExceptionLogDTO> findAllByType(String type);
}