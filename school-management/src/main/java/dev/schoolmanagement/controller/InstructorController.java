package dev.schoolmanagement.controller;

import dev.schoolmanagement.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {
    InstructorService instructorService;
}
