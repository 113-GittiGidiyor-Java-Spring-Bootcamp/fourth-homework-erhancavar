package dev.schoolmanagement.DTO;

import dev.schoolmanagement.entity.Course;
import dev.schoolmanagement.entity.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class StudentDTO {
    @ApiModelProperty(dataType = "Long", example = "5", notes = "Creates a new entity if not mentioned.")
    private long id;
    private String name;
    private String address;
    private LocalDate birthday;
    private Gender gender;
    private Set<Course> courses;
}
