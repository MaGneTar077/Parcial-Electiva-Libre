package com.example.notifications.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private String id;
    private String templateId;
    private String recipientEncrypted;
    private String variables; // JSON
    private NotificationStatus status;
}

enum NotificationStatus {
    PENDING, SENT, FAILED
}