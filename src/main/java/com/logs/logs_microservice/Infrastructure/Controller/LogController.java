package com.logs.logs_microservice.Infrastructure.Controller;

import com.logs.logs_microservice.Aplication.Service.LogService;
import com.logs.logs_microservice.Domain.Entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Logs")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService){
        this.logService = logService;
    }

    @PostMapping
    public Log CreateLog(@RequestBody Log log){
        return logService.save(log);
    }
    @GetMapping
    public List<Log> GetAllLogs(){
        return logService.getAllLogs();
    }

    @GetMapping("/{Id}")
    public Optional<Log> GetLogById(@PathVariable String Id){
        return logService.getLogById(Id);
    }

    @GetMapping("/Type/{Type}")
    public List<Log> GetLogsByType(@PathVariable String Type){
        return logService.getLogByType(Type);
    }
}
