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
        }
        return notification;
    }

    private static ObservableList<Notification> getNofiticationList(ResultSet rs) throws SQLException{
        ObservableList<Notification> notificationList = FXCollections.observableArrayList();

        while (rs.next()){
            Notification notification = new Notification();
            notification = new Notification();
            notification.setId(rs.getInt("id"));
            notification.setDetails(rs.getString("details"));
            notification.setUser_id(rs.getInt("user_id"));


            notificationList.add(notification);
        }
        return notificationList;
    }

    public static void insertNotification(int user_id, String details) throws SQLException, ClassNotFoundException{
        String updateStmt = "INSERT INTO `notification`" +
                "(`details`, `user_id`) " +
                "VALUES\n" +
                "('" +details+ "', '" +user_id+"');";
        System.out.println(updateStmt);
        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.err.println("Error occurred while INSERTING event notification Operation: " + e);
            System.err.println(updateStmt);
            throw e;
        }
    }

    public static ObservableList<Notification> getAllMyNotifications (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT *\n" +
                "FROM notification\n" +
                "WHERE user_id = " + id;
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Notification> notificationList = getNofiticationList(rsEvent);

            return notificationList;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a notification by event user_id: " + id + " , error occured: " + e);
            throw e;
        }
    }
}
