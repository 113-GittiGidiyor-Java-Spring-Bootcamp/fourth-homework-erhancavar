package dev.schoolmanagement.DTO;

import dev.schoolmanagement.entity.Instructor;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
public class CourseDTO {
    @ApiModelProperty(dataType = "Long", example = "5", notes = "Creates a new entity if not mentioned.")
    private long id;
    @ApiModelProperty(required = true, dataType = "String", example = "Math")
    @NotBlank(message = "Must be longer than 2 characters and cannot be empty.")
    @Size(min = 2, max = 10)
    private String name;
    @ApiModelProperty(required = true, dataType = "String", example = "M101")
    @NotBlank(message = "Must be longer than 2 characters and cannot be empty.")
    @Size(min = 2, max = 10)
    private String courseCode;
    @ApiModelProperty(required = true, dataType = "Float", example = "4.0")
    @Min(value = 1, message = "Cannot be lower then 1")
    private float creditScore;
    @ApiModelProperty(dataType = "Long", example = "12")
    private Long instructorID;;
}
