package dev.schoolmanagement.controller;

import dev.schoolmanagement.DTO.CourseDTO;
import dev.schoolmanagement.DTO.StudentDTO;
import dev.schoolmanagement.DTO.response.CreationSuccess;
import dev.schoolmanagement.DTO.response.DeletionSuccess;
import dev.schoolmanagement.DTO.response.UpdateSuccess;
import dev.schoolmanagement.service.StudentService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable @ApiParam(example = "5") long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CreationSuccess<StudentDTO>> save(@RequestBody @Valid StudentDTO studentDTO){
        return ResponseEntity.ok(new CreationSuccess<>(studentService.save(studentDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletionSuccess> delete(@PathVariable @ApiParam(example = "5") long id){
        studentService.deleteById(id);
        return ResponseEntity.ok(new DeletionSuccess(id));
    }

    @PutMapping
    public ResponseEntity<UpdateSuccess<StudentDTO>> update(@RequestBody @Valid StudentDTO studentDTODTO){
        return ResponseEntity.ok(new UpdateSuccess<>(studentService.update(studentDTODTO)));
    }

}
