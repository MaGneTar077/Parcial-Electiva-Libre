package com.logs.logs_microservice.Infrastructure.Reposiroty;

import com.logs.logs_microservice.Domain.Entity.Log;
import com.logs.logs_microservice.Domain.Ports.LogRepositoryPort;
import com.logs.logs_microservice.Domain.Ports.LogType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends MongoRepository<Log, String>, LogRepositoryPort {
    List<Log> findByType(LogType Type);
}
