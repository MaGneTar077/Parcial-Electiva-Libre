package com.logs.logs_microservice.Aplication.Service;

import com.logs.logs_microservice.Domain.Ports.LogType;
import com.logs.logs_microservice.Domain.Ports.LogRepositoryPort;
import com.logs.logs_microservice.Domain.Entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {
    private final LogRepositoryPort logRepositoryPort;

    @Autowired
    public LogService(LogRepositoryPort logRepositoryPort) {
        this.logRepositoryPort = logRepositoryPort;
    }

    public Log save(Log log){
        return logRepositoryPort.save(log);
    }

    public List<Log>getAllLogs(){
        return logRepositoryPort.findAll();
    }

    public Optional<Log>getLogById(Long Id){
        return logRepositoryPort.findById(Id);
    }

    public List<Log>getLogByType(String Type){
        return logRepositoryPort.findByType(LogType.valueOf(Type));
    }
}
