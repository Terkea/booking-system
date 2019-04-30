package application.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationDAO {
    private static Notification getNotificationFromResultSet(ResultSet rs) throws SQLException {
        Notification notification = null;
        if (rs.next()){
            notification = new Notification();
            notification.setId(rs.getInt("id"));
            notification.setDetails(rs.getString("details"));
            notification.setUser_id(rs.getInt("user_id"));
            notification.setEvent_id(rs.getInt("event_id"));
        }
        return notification;
    }

    private static ObservableList<Notification> getNotificationList(ResultSet rs) throws SQLException{
        ObservableList<Notification> notificationList = FXCollections.observableArrayList();

        while (rs.next()){
            Notification notification = new Notification();
            notification.setId(rs.getInt("id"));
            notification.setDetails(rs.getString("details"));
            notification.setUser_id(rs.getInt("user_id"));
            notification.setEvent_id(rs.getInt("event_id"));
        }
        return notificationList;
    }

    public static void insertNotification(Notification notification) throws SQLException, ClassNotFoundException{
        String updateStmt = "INSERT INTO `notification`" +
                "(`details` , `event_id`, `user_id`) " +
                "VALUES\n" +
                "('" +notification.getDetails()+ "', '" +notification.getEvent_id()+ "', '" +notification.getUser_id() +"');";
        System.out.println(updateStmt);
        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.err.println("Error occurred while INSERTING event notification Operation: " + e);
            System.err.println(updateStmt);
            throw e;
        }
    }
}
