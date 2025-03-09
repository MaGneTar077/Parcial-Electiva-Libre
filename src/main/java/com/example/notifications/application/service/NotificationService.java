package com.example.notifications.application.service;

import com.example.notifications.domain.Notification;
import com.example.notifications.domain.NotificationStatus;
import com.example.notifications.application.ports.NotificationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepositoryPort repository;

    public Notification createNotification(String templateId, String recipientEncrypted, String variables) {
        Notification notification = new Notification(
                UUID.randomUUID().toString(),
                templateId,
                recipientEncrypted,
                variables,
                NotificationStatus.PENDING
        );
        return repository.save(notification);
    }

    public Notification findById(String id) {
        return repository.findById(id);
    }
}