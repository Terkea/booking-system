package application.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Event_PerformersDAO {

    private static Event_Performers getEventPerformersFromResultSet(ResultSet rs) throws SQLException {
        Event_Performers event_performers = null;
        if (rs.next()){
            event_performers = new Event_Performers();
            event_performers.setId(rs.getInt("id"));
            event_performers.setBand_id(rs.getInt("band_id"));
            event_performers.setEvent_id(rs.getInt("event_id"));
        }
        return event_performers;
    }

    private static ObservableList<Event_Performers> getEventPerformersList(ResultSet rs) throws SQLException{
        ObservableList<Event_Performers> event_performersList = FXCollections.observableArrayList();

        while (rs.next()){
            Event_Performers event_performers = new Event_Performers();
            event_performers.setId(rs.getInt("id"));
            event_performers.setBand_id(rs.getInt("band_id"));
            event_performers.setEvent_id(rs.getInt("event_id"));
            event_performers.setUpForeignKeys();
            event_performersList.add(event_performers);
        }
        return event_performersList;
    }

    public static void insertEvent_performers(int event_id, int band_id) throws SQLException, ClassNotFoundException{
        String updateStmt = "INSERT INTO `event_performers`" +
                "(`event_id` , `band_id`) " +
                "VALUES\n" +
                "('" +event_id+ "', '" +band_id+ "');";
        System.out.println(updateStmt);
        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.err.println("Error occurred while INSERTING event performers Operation: " + e);
            System.err.println(updateStmt);
            throw e;
        }
    }

    public static ObservableList<Event_Performers> getAllPerformersByEventId (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM event_performers " +
                "WHERE event_id = " + id;
        try{
            ResultSet rsEvent = DB.dbExecuteQuery(selectStmt);
            ObservableList<Event_Performers> event_performersList = getEventPerformersList(rsEvent);

            return event_performersList;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a event performers by event id: " + id + " , error occured: " + e);
            throw e;
        }
    }
}
