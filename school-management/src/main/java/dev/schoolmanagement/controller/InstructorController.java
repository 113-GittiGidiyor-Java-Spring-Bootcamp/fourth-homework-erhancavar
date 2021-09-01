package dev.schoolmanagement.controller;

import dev.schoolmanagement.DTO.InstructorDTO;
import dev.schoolmanagement.DTO.PermanentInstructorDTO;
import dev.schoolmanagement.DTO.VisitingResearcherDTO;
import dev.schoolmanagement.DTO.response.CreationSuccess;
import dev.schoolmanagement.DTO.response.DeletionSuccess;
import dev.schoolmanagement.DTO.response.UpdateSuccess;
import dev.schoolmanagement.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {
    InstructorService instructorService;

    @PostMapping("/visiting-researcher")
    public ResponseEntity<CreationSuccess<InstructorDTO>> saveVisitingResearcher(@RequestBody VisitingResearcherDTO instructorDTO) {
        return ResponseEntity.ok(new CreationSuccess<>(instructorService.save(instructorDTO)));
    }

    @PostMapping("/permanent-instructor")
    public ResponseEntity<CreationSuccess<InstructorDTO>> savePermanentInstructor(@RequestBody PermanentInstructorDTO instructorDTO) {
        return ResponseEntity.ok(new CreationSuccess<>(instructorService.save(instructorDTO)));
    }

    @GetMapping
    public ResponseEntity<List<InstructorDTO>> findAll() {
        return ResponseEntity.ok(instructorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDTO> findById(@PathVariable long id){
        return ResponseEntity.ok(instructorService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletionSuccess> delete(@PathVariable long id){
        instructorService.deleteById(id);
        return ResponseEntity.ok(new DeletionSuccess(id));
    }

    @PutMapping("/permanent-instructor")
    public ResponseEntity<UpdateSuccess<InstructorDTO>> update(@RequestBody PermanentInstructorDTO permanentInstructorDTO){
        return ResponseEntity.ok(new UpdateSuccess<>(instructorService.update(permanentInstructorDTO)));
    }

    @PutMapping("/visiting-researcher")
    public ResponseEntity<UpdateSuccess<InstructorDTO>> update(@RequestBody VisitingResearcherDTO visitingResearcherDTO){
        return ResponseEntity.ok(new UpdateSuccess<>(instructorService.update(visitingResearcherDTO)));
    }
}
