package com.biagioiorio.public_ip_logger_api.controller;

import com.biagioiorio.public_ip_logger_api.model.LogEntry;
import com.biagioiorio.public_ip_logger_api.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogEntryController {

    private final LogEntryRepository logEntryRepository;

    @Autowired
    public LogEntryController(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> logIp(@RequestBody LogEntry logEntry) {
        logEntry.setTimestamp(LocalDateTime.now());
        logEntryRepository.save(logEntry);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        return logEntryRepository.findAll();
    }


}
