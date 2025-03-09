package com.example.notifications.application.ports;
import com.example.notifications.domain.Notification;
public interface NotificationRepositoryPort {
    Notification save(Notification notification);
    Notification findById(String id);
}
