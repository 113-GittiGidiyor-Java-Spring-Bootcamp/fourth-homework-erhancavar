package dev.schoolmanagement.DTO.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class SuccessResponse {
    @ApiModelProperty(example = "true", dataType = "Boolean")
    private final boolean success = true;
    @ApiModelProperty(example = "Course successfully saved", dataType = "String")
    private final String message;

    public SuccessResponse(String message) {
        this.message = message;
    }
}
