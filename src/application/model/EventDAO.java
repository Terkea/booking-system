package application.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDAO {
    private static Event getEventFromResultSet(ResultSet rs) throws SQLException {
        Event event = null;
        if (rs.next()){
            event = new Event();
            event.setId(rs.getInt("id"));
            event.setName(rs.getString("name"));
            event.setLocation(rs.getString("location"));
            event.setDate(rs.getString("date"));
            event.setDescription(rs.getString("description"));
            event.setTickets_available(rs.getInt("tickets_available"));
            event.setTicket_price(rs.getDouble("ticket_price"));
            event.setStatus(rs.getBoolean("status"));
            event.setOrganizer_id(rs.getInt("organizer_id"));
            event.setEvent_type(rs.getString("event_type"));
        }
        return event;
    }

    private static ObservableList<Event> getEventList(ResultSet rs) throws SQLException, ClassNotFoundException{
        ObservableList<Event> eventList = FXCollections.observableArrayList();

        while (rs.next()){
            Event event = new Event();
            event.setId(rs.getInt("id"));
            event.setName(rs.getString("name"));
            event.setLocation(rs.getString("location"));
            event.setDate(rs.getString("date"));
            event.setDescription(rs.getString("description"));
            event.setTickets_available(rs.getInt("tickets_available"));
            event.setTicket_price(rs.getDouble("ticket_price"));
            event.setStatus(rs.getBoolean("status"));
            event.setOrganizer_id(rs.getInt("organizer_id"));
            event.setEvent_type(rs.getString("event_type"));

            eventList.add(event);
        }
        return eventList;
    }

    public static ObservableList<Event> getAllActiveEvents () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM event WHERE status = 1";
        try {
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Event> eventList = getEventList(rsEvent);

            return eventList;
        }catch (SQLException e){
            System.err.println("SQL select operation has failed: " + e );
            throw e;
        }
    }

    public static ObservableList<Event> getAllEvents () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM event WHERE status = 1";
        try {
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Event> eventList = getEventList(rsEvent);

            return eventList;
        }catch (SQLException e){
            System.err.println("SQL select operation has failed: " + e );
            throw e;
        }
    }

    public static ObservableList<Event> searchActiveEvent (String keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM event " +
                "WHERE name " +
                "LIKE \"%" + keyword + "\"" +
                "OR location " +
                "LIKE \"%" + keyword + "\"" +
                "AND status = 1";
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Event> eventList = getEventList(rsEvent);

            return eventList;
        }catch(SQLException e){
            System.out.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
            throw e;
        }
    }

    public static ObservableList<Event> searchEvent (String keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM event " +
                "WHERE name " +
                "LIKE \"%" + keyword + "\"" +
                "OR location " +
                "LIKE \"%" + keyword + "\"" +
                "WHERE status = 1";
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Event> eventList = getEventList(rsEvent);

            return eventList;
        }catch(SQLException e){
            System.out.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
            throw e;
        }
    }

    public static Event getEventByID (int keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM `event` " +
                "WHERE id = \"" + keyword + "\"";
//                "AND status = 1";
        try{
            ResultSet rs = DB.dbExecuteQuery(selectStmt);
            Event event = getEventFromResultSet(rs);

            return event;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
            System.err.println(selectStmt);
            throw e;
        }
    }

}
