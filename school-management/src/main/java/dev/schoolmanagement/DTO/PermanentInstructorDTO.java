package dev.schoolmanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermanentInstructorDTO extends InstructorDTO {
    private double fixedSalary;
}