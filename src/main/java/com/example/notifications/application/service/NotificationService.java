package com.example.notifications.application.service;
import  com.example.notifications.domain.Notification;
public class NotificationService {
    private final NotificationRepositoryPort repository;

    public Notification createNotification(String templateId, String recipientEncrypted, String variables) {
        Notification notification = new Notification(
                java.util.UUID.randomUUID().toString(),
                templateId,
                recipientEncrypted,
                variables,
                NotificationStatus.PENDING
        );
        return repository.save(notification);
    }
}
}
