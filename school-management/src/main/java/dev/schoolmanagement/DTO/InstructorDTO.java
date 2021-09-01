package dev.schoolmanagement.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {
    @ApiModelProperty(dataType = "Long", example = "5", notes = "Creates a new entity if not mentioned.")
    private long id;
    private String name;
    private String phoneNumber;

}
