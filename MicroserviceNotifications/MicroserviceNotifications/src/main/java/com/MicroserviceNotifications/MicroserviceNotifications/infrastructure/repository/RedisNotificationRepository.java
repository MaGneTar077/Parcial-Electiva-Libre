package com.MicroserviceNotifications.MicroserviceNotifications.infrastructure.repository;

import com.MicroserviceNotifications.MicroserviceNotifications.domain.entity.Notification;
import com.MicroserviceNotifications.MicroserviceNotifications.domain.repository.NotificationRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class RedisNotificationRepository implements NotificationRepository {

    private final RedisTemplate<String, Notification> redisTemplate;
    private static final String KEY = "NOTIFICATION";

    public RedisNotificationRepository(RedisTemplate<String, Notification> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Notification save(Notification notification) {
        redisTemplate.opsForHash().put(KEY, notification.getId(), notification);
        return notification;
    }

    @Override
    public Optional<Notification> findById(String id) {
        return Optional.ofNullable((Notification) redisTemplate.opsForHash().get(KEY, id));
    }

    @Override
    public List<Notification> findAll() {
        return redisTemplate.<String, Notification>opsForHash().values(KEY).stream()
                .map(obj -> (Notification) obj)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        redisTemplate.opsForHash().delete(KEY, id.toString());
    }

    @Override
    public List<Notification> findByEnviada(boolean enviada) {
        return findAll().stream()
                .filter(notification -> notification.isEnviada() == enviada)
                .toList();
    }
}