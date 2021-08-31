package dev.schoolmanagement.controller;

import dev.schoolmanagement.DTO.CourseDTO;
import dev.schoolmanagement.DTO.response.CreationSuccess;
import dev.schoolmanagement.DTO.response.DeletionSuccess;
import dev.schoolmanagement.DTO.response.SuccessResponse;
import dev.schoolmanagement.DTO.response.UpdateSuccess;
import dev.schoolmanagement.entity.Course;
import dev.schoolmanagement.mappers.CourseMapper;
import dev.schoolmanagement.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
    CourseService courseService;
    CourseMapper courseMapper;

    @PostMapping
    public ResponseEntity<CreationSuccess<Course>> save(@RequestBody @Valid CourseDTO course) {
        return ResponseEntity.ok(new CreationSuccess<>(courseService.save(courseMapper.mapToEntity(course))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletionSuccess> deleteByID(@PathVariable long id){
        courseService.deleteById(id);
        return ResponseEntity.ok(new DeletionSuccess(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll(){
        List<CourseDTO> courses = courseService.findAll().stream().map(course -> courseMapper.mapToDTO(course)).collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }

    @PutMapping
    public ResponseEntity<UpdateSuccess<CourseDTO>> update(@RequestBody CourseDTO courseDTO){
        courseService.update(courseMapper.mapToEntity(courseDTO));
        return ResponseEntity.ok(new UpdateSuccess<>(courseDTO));
    }
}
