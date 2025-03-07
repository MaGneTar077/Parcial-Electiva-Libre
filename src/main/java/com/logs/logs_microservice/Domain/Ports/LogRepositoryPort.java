package com.logs.logs_microservice.Domain.Ports;

import com.logs.logs_microservice.Domain.Entity.Log;

import java.util.List;
import java.util.Optional;

public interface LogRepositoryPort{
    Log save(Log log);
    List<Log> findAll();
    Optional<Log> findById(Long Id);
    List<Log> findByType(LogType Type);
}