package com.microservice.microservices.application.service;

import com.microservice.microservices.domain.entity.Transactions;

public interface NotificationSevice {
    void notify(Transactions transactions);
}
