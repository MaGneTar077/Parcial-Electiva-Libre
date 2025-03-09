package com.example.notifications.infrastructure.adapters;
import com.example.notifications.domain.Notification;
import com.example.notifications.application.ports.NotificationRepositoryPort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisNotificationAdapter implements NotificationRepositoryPort {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String NOTIFICATION_KEY_PREFIX = "notification:";

    public RedisNotificationAdapter(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Notification save(Notification notification) {
        String key = NOTIFICATION_KEY_PREFIX + notification.getId();
        redisTemplate.opsForValue().set(key, notification);
        return notification;
    }

    @Override
    public Notification findById(String id) {
        String key = NOTIFICATION_KEY_PREFIX + id;
        return (Notification) redisTemplate.opsForValue().get(key);
    }
}