package com.logs.logs_microservice.Infrastructure.Repository;

import com.logs.logs_microservice.Domain.Ports.LogType;
import com.logs.logs_microservice.Domain.Entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByType(LogType Type);
}
