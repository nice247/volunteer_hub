package com.vho.activ.service;

import com.vho.activ.models.Notification;
import com.vho.activ.repo.NotificationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private NotificationRepo notificationRepo;

    public Notification saveNotification(Notification notification) {
        return notificationRepo.save(notification);
    }
    public Notification getNotificationByRecipientId(Long volunteerId) {
        return notificationRepo.findNotificationByRecipient_VolId(volunteerId);
    }
}
