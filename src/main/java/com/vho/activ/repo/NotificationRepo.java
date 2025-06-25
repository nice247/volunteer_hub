package com.vho.activ.repo;

import com.vho.activ.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {

    Notification findNotificationByRecipient_VolId(Long recipientId);
}
