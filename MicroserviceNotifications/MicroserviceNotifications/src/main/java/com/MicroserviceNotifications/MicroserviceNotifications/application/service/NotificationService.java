package com.MicroserviceNotifications.MicroserviceNotifications.application.service;

import com.MicroserviceNotifications.MicroserviceNotifications.application.interfaces.NotificacionUseCase;
import com.MicroserviceNotifications.MicroserviceNotifications.domain.entity.Notification;
import com.MicroserviceNotifications.MicroserviceNotifications.domain.repository.NotificationRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationService implements NotificacionUseCase {

    private final NotificationRepository notificationRepository;

    public NotificationService(@Qualifier("redisNotificationRepository") NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification sendNotification(String destinatario, String asunto, String contenido) {
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setDestinatario(destinatario);
        notification.setAsunto(asunto);
        notification.setContenido(contenido);
        notification.setFechaCreacion(LocalDateTime.now());
        notification.setEnviada(false);
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(String id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getNotificationsByStatus(boolean enviada) {
        return notificationRepository.findByEnviada(enviada);
    }
}