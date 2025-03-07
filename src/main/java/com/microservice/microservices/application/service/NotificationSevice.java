package com.microservice.microservices.application.service;

import com.microservice.microservices.domain.entity.Transaction;

public interface NotificationSevice {
    void notify(Transaction transactions);
}
