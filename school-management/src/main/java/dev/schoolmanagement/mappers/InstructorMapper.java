package dev.schoolmanagement.mappers;

import dev.schoolmanagement.DTO.InstructorDTO;
import dev.schoolmanagement.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper extends GenericMapper<Instructor, InstructorDTO> {
}
