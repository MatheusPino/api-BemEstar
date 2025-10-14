package com.fiap.bemestar.api.controller;

import com.fiap.bemestar.api.model.CheckIn;
import com.fiap.bemestar.api.model.LogEvent;
import com.fiap.bemestar.api.repository.CheckInRepository;
import com.fiap.bemestar.api.repository.LogRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/checkins")
public class CheckInController {

    private final CheckInRepository checkInRepo;
    private final LogRepository logRepo;

    public CheckInController(CheckInRepository checkInRepo, LogRepository logRepo) {
        this.checkInRepo = checkInRepo;
        this.logRepo = logRepo;
    }

    @GetMapping
    public List<CheckIn> getAll() {
        return checkInRepo.findAll();
    }

    @GetMapping("/{id}")
    public List<CheckIn> getByUser(@PathVariable String id) {
        return checkInRepo.findByUserIdOrderByCreatedAtDesc(id);
    }

    @PostMapping
    public CheckIn create(@RequestBody CheckIn checkIn) {
        checkIn.setCreatedAt(Instant.now());
        CheckIn saved = checkInRepo.save(checkIn);

        LogEvent log = new LogEvent();
        log.setAction("checkin_created");
        log.setUserId(saved.getUserId());
        log.setTimestamp(Instant.now());
        log.setDetails(Map.of("mood", saved.getMood(), "motivacao", saved.getMotivacao()));
        logRepo.save(log);

        return saved;
    }
}
