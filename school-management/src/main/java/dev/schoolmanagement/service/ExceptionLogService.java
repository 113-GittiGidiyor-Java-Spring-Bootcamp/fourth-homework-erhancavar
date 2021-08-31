package dev.schoolmanagement.service;


import dev.schoolmanagement.entity.ExceptionLog;

import java.util.List;


public interface ExceptionLogService extends LogService<ExceptionLog> {
    List<ExceptionLog> findAllByType(String type);

}