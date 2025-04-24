CREATE DATABASE IF NOT EXISTS ip_logger CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ip_logger;

-- Table for logs
CREATE TABLE ip_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hashed_ip VARCHAR(255),
    timestamp DATETIME,
    user_agent TEXT,
    referer TEXT
);

