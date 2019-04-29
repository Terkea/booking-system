package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class Event_Performers {
    private IntegerProperty id;
    private IntegerProperty event_id;
    private IntegerProperty band_id;
    private StringProperty band_name;



    public Event_Performers(){
        this.id = new SimpleIntegerProperty();
        this.event_id = new SimpleIntegerProperty();
        this.band_id = new SimpleIntegerProperty();
    }

    public Event_Performers(IntegerProperty id, IntegerProperty event_id, IntegerProperty band_id) {
        this.id = new SimpleIntegerProperty();
        this.event_id = new SimpleIntegerProperty();
        this.band_id = new SimpleIntegerProperty();
    }

    public void setUpForeignKeys(){
        try {
            this.band_name = new SimpleStringProperty(BandDAO.getBandByID(band_id).getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Event_Performers{" +
                "id=" + id +
                ", event_id=" + event_id +
                ", band_id=" + band_id +
                '}';
    }

    public String getBand_name() {
        return band_name.get();
    }

    public StringProperty band_nameProperty() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name.set(band_name);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getEvent_id() {
        return event_id.get();
    }

    public IntegerProperty event_idProperty() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id.set(event_id);
    }

    public int getBand_id() {
        return band_id.get();
    }

    public IntegerProperty band_idProperty() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id.set(band_id);
    }
}
