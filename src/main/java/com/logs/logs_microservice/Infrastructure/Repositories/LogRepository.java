package com.logs.logs_microservice.Infrastructure.Repositories;

import com.logs.logs_microservice.Domain.LogType;
import com.logs.logs_microservice.Domain.Entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Logs, Long> {
    List<Logs> findByType(LogType Type);
}
