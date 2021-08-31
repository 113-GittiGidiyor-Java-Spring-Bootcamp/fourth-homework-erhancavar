package dev.schoolmanagement.controller;

import dev.schoolmanagement.service.ExceptionLogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exception-logs")
@AllArgsConstructor
public class ExceptionLogController {
    ExceptionLogService exceptionLogService;
}
