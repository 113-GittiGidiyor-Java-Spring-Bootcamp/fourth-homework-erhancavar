package dev.schoolmanagement.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ExceptionLogDTO {
    @NonNull
    private String type;
    @NonNull
    private String message;
    private Instant createdDate;
}
