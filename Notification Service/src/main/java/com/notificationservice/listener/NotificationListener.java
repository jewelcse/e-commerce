package com.notificationservice.listener;


import com.notificationservice.configuration.NotificationConfig;
import com.notificationservice.model.Notification;
import com.notificationservice.service.NotificationServiceImp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    private NotificationServiceImp notificationServiceImp;

    public NotificationListener(NotificationServiceImp notificationServiceImp){
        this.notificationServiceImp = notificationServiceImp;
    }


    @RabbitListener(queues = NotificationConfig.NOTIFICATION_QUEUE)
    public void getNotification(Notification notify) {
        Notification notification = new Notification();
        notification.setCustomerId(notify.getCustomerId());
        notification.setNotificationMessage(notify.getNotificationMessage());

        notificationServiceImp.saveNotification(notify);
        System.out.println(notify);
    }


}
