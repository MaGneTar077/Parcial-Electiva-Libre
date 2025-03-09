package com.example.notifications;

import com.example.notifications.application.service.NotificationService;
import com.example.notifications.domain.Notification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final NotificationService notificationService;

    public AppRunner(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void run(String... args) {
        Notification notification = notificationService.createNotification(
                "SECURITY_LOGIN",
                "a1b2c3d4",
                "{\"fecha\": \"2023-10-05\"}"
        );

        System.out.println("Notificación guardada en Redis con ID: " + notification.getId());

        Notification retrievedNotification = notificationService.findById(notification.getId());
        if (retrievedNotification != null) {
            System.out.println("Notificación recuperada: " + retrievedNotification);
        } else {
            System.err.println("Error: No se pudo recuperar la notificación.");
        }
    }
}