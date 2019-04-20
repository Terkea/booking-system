package application.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {
    private static Booking getEventFromResultSet(ResultSet rs) throws SQLException {
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

    public static ObservableList<Booking> searchActiveEvent (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM booking " +
                "WHERE name ='" + id + "'";
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Booking> bookingList = getEventList(rsEvent);

            return bookingList;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a Bookings with user_id: " + id + ", error occured: " + e);
            throw e;
        }
    }
}
