package com.notificationservice.service;


import com.notificationservice.configuration.NotificationConfig;
import com.notificationservice.model.Notification;
import com.notificationservice.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImp implements NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationServiceImp(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }


    @Override
    public void saveNotification(Notification notify) {
        notificationRepository.save(notify);
    }
}
