package service;

import dao.NotificationDAO;
import model.Notification;

import java.util.List;

public class NotificationService {

    private NotificationDAO notificationDAO = new NotificationDAO();

    // Create Notification
    public boolean createNotification(Notification notification) {

        return notificationDAO.createNotification(notification);

    }

    // View All Notifications
    public List<Notification> getAllNotifications() {

        return notificationDAO.getAllNotifications();

    }

}