package com.MicroserviceNotifications.MicroserviceNotifications.infrastructure.mapper;

import com.MicroserviceNotifications.MicroserviceNotifications.domain.entity.Notification;
import java.time.LocalDateTime;

public class NotificationMapper {
    public static Notification toDomain(Notification notification) {
        Notification domainNotification = new Notification();
        domainNotification.setId(notification.getId());
        domainNotification.setDestinatario(notification.getDestinatario());
        domainNotification.setAsunto(notification.getAsunto());
        domainNotification.setContenido(notification.getContenido());
        domainNotification.setFechaCreacion(LocalDateTime.now());
        domainNotification.setEnviada(false);
        return domainNotification;
    }
}