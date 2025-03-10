package com.MicroserviceNotifications.MicroserviceNotifications.domain.repository;

import com.MicroserviceNotifications.MicroserviceNotifications.domain.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {
    Notification save(Notification notification);
    Optional<Notification> findById(String id);
    List<Notification> findAll();
    void deleteById(Long id);
    List<Notification> findByEnviada(boolean enviada);
}