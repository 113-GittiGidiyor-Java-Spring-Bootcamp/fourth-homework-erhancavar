package dev.schoolmanagement.controller;

import dev.schoolmanagement.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

}
