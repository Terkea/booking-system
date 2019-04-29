package application.model;

import application.system.DB;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BandDAO {
    private static Band getBandFromResultSet(ResultSet rs) throws SQLException {
        Band band = null;
        if (rs.next()){
            band = new Band();
            band.setId(rs.getInt("id"));
            band.setName(rs.getString("name"));
            band.setGenre_id(rs.getInt("genre_id"));
            band.setAgent_id(rs.getInt("agent_id"));
        }
        return band;
    }

    private static ObservableList<Band> getBandList(ResultSet rs) throws SQLException{
        ObservableList<Band> bandList = FXCollections.observableArrayList();

        while (rs.next()){
            Band band = new Band();
            band.setId(rs.getInt("id"));
            band.setName(rs.getString("name"));
            band.setGenre_id(rs.getInt("genre_id"));
            band.setAgent_id(rs.getInt("agent_id"));

            bandList.add(band);
        }
        return bandList;
    }

    public static ObservableList<Band> getAllBands () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM band";
        try{
            ResultSet rsBand = DB.dbExecuteQuery(selectStmt);
            ObservableList<Band> bandList = getBandList(rsBand);

            return bandList;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a bands error occured: " + e);
            throw e;
        }
    }

    public static Band getBandByID (IntegerProperty id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM `band` " +
                "WHERE id = \"" + id.getValue() + "\"";
        try{
            ResultSet rs = DB.dbExecuteQuery(selectStmt);
            Band band = getBandFromResultSet(rs);

            return band;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a Booking with: " + id.getValue() + " name, error occured: " + e);
            System.err.println(selectStmt);
            throw e;
        }
    }
}
