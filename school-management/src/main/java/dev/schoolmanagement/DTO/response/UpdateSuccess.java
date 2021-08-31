package dev.schoolmanagement.DTO.response;

import lombok.Getter;

@Getter
public class UpdateSuccess<T> extends SuccessResponse{
    private final T updatedData;
    public UpdateSuccess(T data) {
        super("Update successful");
        this.updatedData = data;
    }
}
