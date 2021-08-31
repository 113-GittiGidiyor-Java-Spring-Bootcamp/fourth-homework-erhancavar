package dev.schoolmanagement.mappers;

import dev.schoolmanagement.DTO.CourseDTO;
import dev.schoolmanagement.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends GenericMapper<Course,CourseDTO>{

}
