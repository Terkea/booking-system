package application.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {
    private static Booking getBookingFromResultSet(ResultSet rs) throws SQLException {
        Booking booking = null;
        if (rs.next()){
            booking = new Booking();
            booking.setId(rs.getInt("id"));
            booking.setNumber_of_tickets(rs.getInt("number_of_tickets"));
            booking.setEvent_id(rs.getInt("event_id"));
            booking.setUser_id(rs.getInt("user_id"));
            booking.setPayment_id(rs.getInt("payment_id"));
        }
        return booking;
    }

    private static ObservableList<Booking> getEventList(ResultSet rs) throws SQLException, ClassNotFoundException{
        ObservableList<Booking> bookingList = FXCollections.observableArrayList();

        while (rs.next()){
            Booking booking = new Booking();
            booking.setId(rs.getInt("id"));
            booking.setNumber_of_tickets(rs.getInt("number_of_tickets"));
            booking.setEvent_id(rs.getInt("event_id"));
            booking.setUser_id(rs.getInt("user_id"));
            booking.setPayment_id(rs.getInt("payment_id"));

            bookingList.add(booking);
        }
        return bookingList;
    }

    private static ObservableList<Booking> getFullBookings(ResultSet rs) throws SQLException, ClassNotFoundException{
        ObservableList<Booking> bookingList = FXCollections.observableArrayList();

        while (rs.next()){
            Booking booking = new Booking();
            booking.setId(rs.getInt("id"));
            booking.setNumber_of_tickets(rs.getInt("number_of_tickets"));
            booking.setEvent_id(rs.getInt("event_id"));
            booking.setUser_id(rs.getInt("user_id"));
            booking.setPayment_id(rs.getInt("payment_id"));
            booking.setUpForeignKeys();
            bookingList.add(booking);
        }
        return bookingList;
    }

    public static ObservableList<Booking> getBookingsByUserID (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM booking " +
                "WHERE user_id ='" + id + "'";
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Booking> bookingList = getFullBookings(rsEvent);

//            for (int i = 0; bookingList.)


            return bookingList;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a Bookings with user_id: " + id + ", error occured: " + e);
            throw e;
        }
    }

    public static Booking getBookingBYID (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM `booking` " +
                "WHERE id = \"" + id + "\"";
        try{
            ResultSet rs = DB.dbExecuteQuery(selectStmt);
            Booking booking = getBookingFromResultSet(rs);
            booking.setUpForeignKeys();

            return booking;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a Booking with: " + id + " name, error occured: " + e);
            System.err.println(selectStmt);
            throw e;
        }
    }

    public static void insertBooking (int number_of_tickets, int event_id, int user_id, int payment_id) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "INSERT INTO `booking` " +
                "(`number_of_tickets`, `event_id`, `user_id`, `payment_id`) " +
                "VALUES\n" +
                "('" +number_of_tickets+ "', '" +event_id+ "', '" +user_id+ "', '"+payment_id+ "');";
        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.err.println("Error occurred while INSERTING PAYMENT Operation: " + e);
            System.err.println(updateStmt);
            throw e;
        }
    }


    public static ObservableList<Booking> searchMyBookings (String keyword, int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM booking " +
                "INNER JOIN event " +
                "ON `booking`.`event_id` = `event`.`id` " +
                "WHERE event.name " +
                "LIKE \"%" + keyword + "%\"" +
                " OR event.location " +
                "LIKE \"%" + keyword + "%\"" +
                " AND user_id = " + id;
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Booking> bookingList = getFullBookings(rsEvent);

            return bookingList;
        }catch(SQLException e){
            System.out.println("ERROR While searching for a booking with: " + keyword + " name, error occured: " + e);
            throw e;
        }
    }


    public static ObservableList<Booking> getAllMyUnpaidBookings (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM booking " +
                "INNER JOIN payment " +
                "ON `booking`.`payment_id` = `payment`.`id` " +
                "WHERE `payment`.`user_id` =  " + id +
                " AND `payment`.`status` = 0";
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Booking> bookingList = getFullBookings(rsEvent);

            return bookingList;
        }catch(SQLException e){
            System.out.println("ERROR While searching for a booking with: " + id + " id, error occured: " + e);
            throw e;
        }
    }

}
