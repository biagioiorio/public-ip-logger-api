package com.biagioiorio.public_ip_logger_api.controller;

import com.biagioiorio.public_ip_logger_api.model.LogEntry;
import com.biagioiorio.public_ip_logger_api.repository.LogEntryRepository;
import com.biagioiorio.public_ip_logger_api.service.HashingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/r")
public class RedirectController {
    private final LogEntryRepository logEntryRepository;
    private final HashingService hashingService;

    @Autowired
    public RedirectController(LogEntryRepository logEntryRepository, HashingService hashingService) {
        this.logEntryRepository = logEntryRepository;
        this.hashingService = hashingService;
    }

    @GetMapping
    public ResponseEntity<Void> redirectAndLog(@RequestParam("to") String destinationUrl, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String hashedIp = hashingService.hashIp(ip);

        LogEntry logEntry = new LogEntry();
        logEntry.setHashedIp(hashedIp);
        logEntry.setUserAgent(userAgent);
        logEntry.setTimestamp(LocalDateTime.now());
        logEntryRepository.save(logEntry);

        return ResponseEntity.status(302)
                .header("Location", destinationUrl)
                .build();
    }
}
