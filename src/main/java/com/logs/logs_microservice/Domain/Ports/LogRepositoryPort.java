package com.logs.logs_microservice.Domain.Ports;

import com.logs.logs_microservice.Domain.LogType;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Optional;

public interface LogRepositoryPort {
    List<Log> findAll();
    Optional<Log> findById(Long Id);
    List<Log> findByType(LogType Type);
}
