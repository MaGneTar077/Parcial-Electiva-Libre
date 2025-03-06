package com.logs.logs_microservice.Domain.Ports;

import com.logs.logs_microservice.Domain.Entity.Logs;
import com.logs.logs_microservice.Domain.LogType;

import java.util.List;
import java.util.Optional;

public interface LogRepositoryPort {
    List<Logs> findAllLogs();
    Optional<Logs> findById(Long Id);
    List<Logs> findByType(LogType Type);
    Logs save(Logs log);
}