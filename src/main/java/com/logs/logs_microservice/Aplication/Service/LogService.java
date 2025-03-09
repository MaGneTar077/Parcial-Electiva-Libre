package com.logs.logs_microservice.Aplication.Service;

import com.logs.logs_microservice.Domain.Entity.Log;
import com.logs.logs_microservice.Domain.Ports.LogRepositoryPort;
import com.logs.logs_microservice.Domain.Ports.LogType;
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
        log.setStatus(StatusMachine(log));
        return logRepositoryPort.save(log);
    }

    //get/set Status by machine IDK
    private int StatusMachine(Log log){
        if("ERROR".equals(log.getType())){
            return 500;
        }else if("POST".equals(log.getType())){
            return 201;
        }else{
            return 200;
        }
    }
    public List<Log> getAllLogs(){
        return logRepositoryPort.findAll();
    }

    public Optional<Log> getLogById(String Id){
        return logRepositoryPort.findById(Id);
    }

    public List<Log>getLogByType(String Type){
        try{
            LogType logType = LogType.valueOf(Type);
            return logRepositoryPort.findByType(Type);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Log invalid= " +Type);
        }
    }
}

