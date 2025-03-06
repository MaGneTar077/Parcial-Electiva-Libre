package com.logs.logs_microservice.Aplication.Services;

import com.logs.logs_microservice.Domain.LogType;
import com.logs.logs_microservice.Domain.Ports.LogRepositoryPort;
import com.logs.logs_microservice.Domain.Entity.Logs;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LogService {
    private LogRepositoryPort logRepositoryPort;

    @Autowired
    public LogService(LogRepositoryPort logRepositoryPort) {
        this.logRepositoryPort = logRepositoryPort;
    }

    public List<Logs>getAllLogs(){
      return logRepositoryPort.findAllLogs();
    }

    public Optional<Logs>getLogById(Long Id){
        return logRepositoryPort.findById(Id);
    }

    public List<Logs>getLogByType(String Type){
        return logRepositoryPort.findByType(LogType.valueOf(Type));
    }
}
