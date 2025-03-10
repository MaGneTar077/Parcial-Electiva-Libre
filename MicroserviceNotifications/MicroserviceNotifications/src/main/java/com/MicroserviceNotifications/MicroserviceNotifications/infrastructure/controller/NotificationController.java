package com.MicroserviceNotifications.MicroserviceNotifications.infrastructure.controller;

import com.MicroserviceNotifications.MicroserviceNotifications.application.interfaces.NotificacionUseCase;
import com.MicroserviceNotifications.MicroserviceNotifications.domain.entity.Notification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificacionUseCase notificationUseCase;

    public NotificationController(NotificacionUseCase notificationUseCase) {
        this.notificationUseCase = notificationUseCase;
    }

    @PostMapping("/send")
    public Notification sendNotification(
            @RequestParam String destinatario,
            @RequestParam String asunto,
            @RequestParam String contenido) {
        return notificationUseCase.sendNotification(destinatario, asunto, contenido);
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable String id) {
        return notificationUseCase.getNotificationById(id);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationUseCase.getAllNotifications();
    }

    @GetMapping("/status/{enviada}")
    public List<Notification> getNotificationsByStatus(@PathVariable boolean enviada) {
        return notificationUseCase.getNotificationsByStatus(enviada);
    }
}
