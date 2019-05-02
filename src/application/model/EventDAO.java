package application.model;

import application.system.DB;
import javafx.beans.property.IntegerProperty;
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

    public static ObservableList<Event> retrieveAllEvents () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM event";
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
                "WHERE (name " +
                "LIKE \"%" + keyword + "%\"" +
                "OR location " +
                "LIKE \"%" + keyword + "%\")" +
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

    public static Event getEventByIDProperty (IntegerProperty keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM `event` " +
                "WHERE id = \"" + keyword.getValue() + "\"";
//                "AND status = 1";
        try{
            ResultSet rs = DB.dbExecuteQuery(selectStmt);
            Event event = getEventFromResultSet(rs);
            System.out.println(keyword);
            return event;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a Event with: " + keyword + " name, error occured: " + e);
            System.err.println(selectStmt);
            throw e;
        }
    }

    public static ObservableList<Event> searchThroughAllEvents (String keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM event " +
                "WHERE name " +
                "LIKE \"%" + keyword + "%\"" +
                "OR location " +
                "LIKE \"%" + keyword + "%\"";
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Event> eventList = getEventList(rsEvent);

            return eventList;
        }catch(SQLException e){
            System.out.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
            throw e;
        }
    }


    public static void setStatusOn(int id){
        String query =  "UPDATE event\n" +
                "SET status = 1\n" +
                "WHERE id = " + id;
        try {
            DB.dbExecuteUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setStatusOff(int id){
        String query =  "UPDATE event\n" +
                "SET status = 0\n" +
                "WHERE id = " + id;
        try {
            DB.dbExecuteUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertEvent(Event event, boolean status) throws SQLException, ClassNotFoundException{
        String updateStmt = "INSERT INTO event\n" +
                "(`location`, `date`, `name`, `description`, `tickets_available`, `ticket_price`, `event_type`, `status`, `organizer_id`)\n" +
                "VALUES\n" +
                "('" +event.getLocation()+ "', '" +event.getDate()+ "', '" +event.getName()+ "', '"+event.getDescription()+ "', '"+event.getTickets_available()+
                "', '"+event.getTicket_price()+ "', '"+event.getEvent_type()+ "', "+ status + ", '"+ event.getOrganizer_id()+ "');";


        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static Event getLastEventCreatedByOrganiserID (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * \n" +
                "FROM event\n" +
                "WHERE\n" +
                "organizer_id = " + id +
                " ORDER BY id DESC\n" +
                "LIMIT 1";
        try{
            ResultSet rs = DB.dbExecuteQuery(selectStmt);
            Event event = getEventFromResultSet(rs);

            return event;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a Payment with: " + id + " user_id, error occured: " + e);
            System.err.println(selectStmt);
            throw e;
        }
    }

    public static void updateEvent(Event event, int organiser_id, int event_id){

        String query = "UPDATE event " +
                "SET " +
                "name = '" + event.getName() + "', " +
                "location = '" + event.getLocation() + "', " +
                "ticket_price = '" + event.getTicket_price() + "', " +
                "tickets_available = '" + event.getTickets_available() + "', " +
                "description = '" + event.getDescription() + "', " +
                "updated_by = '" + organiser_id + "' " +
                "WHERE id = '" + event_id + "';";
        try {
            DB.dbExecuteUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException{
        String stmt = "DELETE FROM event WHERE id = " + id;

        try{
            DB.dbExecuteUpdate(stmt);
        }catch (SQLException e){
            System.err.println("Error during DELETE operation: " +e );
            throw e;
        }
    }
}
