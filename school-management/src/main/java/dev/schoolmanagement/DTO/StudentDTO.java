package dev.schoolmanagement.DTO;

import dev.schoolmanagement.entity.Course;
import dev.schoolmanagement.entity.Gender;
import dev.schoolmanagement.utility.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Student Data Transfer Object")
public class StudentDTO {
    @ApiModelProperty(dataType = "Long", example = "5", notes = "Creates a new entity if not mentioned.")
    private long id;
    @ApiModelProperty(example = "Osman", dataType = "String")
    @NotBlank(message = Constants.NAME_FORMAT_MESSAGE)
    @Min(value = 2, message = Constants.NAME_FORMAT_MESSAGE)
    private String name;
    @ApiModelProperty(example = "Sarıyer", dataType = "String")
    @NotBlank(message = Constants.NAME_FORMAT_MESSAGE)
    @Min(value = 4, message = Constants.NAME_FORMAT_MESSAGE)
    private String address;
    @ApiModelProperty(dataType = "LocalDate", example = "12-12-2019")
    @NotBlank
    private LocalDate birthday;
    @ApiModelProperty(dataType = "Gender", example = "FEMALE")
    @NotBlank(message = "Not a valid gender.")
    private Gender gender;
}
