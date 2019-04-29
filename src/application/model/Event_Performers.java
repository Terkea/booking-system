package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Event_Performers {
    private IntegerProperty id;
    private IntegerProperty event_id;
    private IntegerProperty band_id;



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

    @Override
    public String toString() {
        return "Event_Performers{" +
                "id=" + id +
                ", event_id=" + event_id +
                ", band_id=" + band_id +
                '}';
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
