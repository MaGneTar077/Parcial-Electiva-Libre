package com.MicroserviceNotifications.MicroserviceNotifications.application.interfaces;

import com.MicroserviceNotifications.MicroserviceNotifications.domain.entity.Notification;

import java.util.List;

public interface NotificacionUseCase {
    Notification sendNotification(String destinatario, String asunto, String contenido);
    Notification getNotificationById(String id); // Cambiado a String
    List<Notification> getAllNotifications();
    List<Notification> getNotificationsByStatus(boolean enviada);
}
