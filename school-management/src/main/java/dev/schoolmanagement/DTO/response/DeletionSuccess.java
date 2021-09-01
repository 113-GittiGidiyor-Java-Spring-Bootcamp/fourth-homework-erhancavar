package dev.schoolmanagement.DTO.response;

import lombok.Getter;

@Getter
public class DeletionSuccess extends SuccessResponse {
    public DeletionSuccess(Long id) {
        super("Entity with id " + id + " is successfully deleted");
    }
}
