package com.fiap.bemestar.api.controller;

import com.fiap.bemestar.api.model.LogEvent;
import com.fiap.bemestar.api.repository.LogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logs")
public class LogController {

    private final LogRepository repo;

    public LogController(LogRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<LogEvent> getAll() {
        return repo.findAll();
    }
}
