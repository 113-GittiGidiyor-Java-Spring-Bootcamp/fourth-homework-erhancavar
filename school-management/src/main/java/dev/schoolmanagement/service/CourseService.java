package dev.schoolmanagement.service;

import dev.schoolmanagement.DTO.CourseDTO;

public interface CourseService extends BaseService<CourseDTO> {
    boolean checkVacancyStatus(Long courseId);
}