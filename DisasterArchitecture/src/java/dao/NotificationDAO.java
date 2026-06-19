package dao;

import model.Notification;
import util.NotificationDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {

    // Create Notification
    public boolean createNotification(Notification notification) {

        String sql = "INSERT INTO notifications(user_id, message, notification_type, status) VALUES (?,?,?,?)";

        try {

            Connection conn = NotificationDBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, notification.getUserId());
            ps.setString(2, notification.getMessage());
            ps.setString(3, notification.getNotificationType());
            ps.setString(4, notification.getStatus());

            int row = ps.executeUpdate();

            return row > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    // View All Notifications
    public List<Notification> getAllNotifications() {

        List<Notification> notifications = new ArrayList<>();

        String sql = "SELECT * FROM notifications ORDER BY notification_id DESC";

        try {

            Connection conn = NotificationDBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Notification notification = new Notification();

                notification.setNotificationId(rs.getInt("notification_id"));
                notification.setUserId(rs.getInt("user_id"));
                notification.setMessage(rs.getString("message"));
                notification.setNotificationType(rs.getString("notification_type"));
                notification.setStatus(rs.getString("status"));

                notifications.add(notification);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return notifications;

    }

}