package com.biagioiorio.public_ip_logger_api.repository;

import com.biagioiorio.public_ip_logger_api.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
    // Add Custom methods
}
