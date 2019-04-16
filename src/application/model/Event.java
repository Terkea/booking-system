package application.model;

import javafx.beans.property.*;

public class Event {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty location;
    private StringProperty date;
    private StringProperty description;
    private IntegerProperty tickets_available;
    private DoubleProperty ticket_price;
    private BooleanProperty status;
    private IntegerProperty organizer_id;
    private StringProperty event_type;


    public Event() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.location = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.tickets_available = new SimpleIntegerProperty();
        this.ticket_price = new SimpleDoubleProperty();
        this.status = new SimpleBooleanProperty();
        this.organizer_id = new SimpleIntegerProperty();
        this.event_type = new SimpleStringProperty();
    }

    public Event(IntegerProperty id, StringProperty name, StringProperty location, StringProperty date, StringProperty description, IntegerProperty tickets_available, DoubleProperty ticket_price, BooleanProperty status, IntegerProperty organizer_id, StringProperty event_type) {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.location = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.tickets_available = new SimpleIntegerProperty();
        this.ticket_price = new SimpleDoubleProperty();
        this.status = new SimpleBooleanProperty();
        this.organizer_id = new SimpleIntegerProperty();
        this.event_type = new SimpleStringProperty();
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getTickets_available() {
        return tickets_available.get();
    }

    public IntegerProperty tickets_availableProperty() {
        return tickets_available;
    }

    public void setTickets_available(int tickets_available) {
        this.tickets_available.set(tickets_available);
    }

    public double getTicket_price() {
        return ticket_price.get();
    }

    public DoubleProperty ticket_priceProperty() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price.set(ticket_price);
    }

    public boolean isStatus() {
        return status.get();
    }

    public BooleanProperty statusProperty() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }

    public int getOrganizer_id() {
        return organizer_id.get();
    }

    public IntegerProperty organizer_idProperty() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id.set(organizer_id);
    }

    public String getEvent_type() {
        return event_type.get();
    }

    public StringProperty event_typeProperty() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type.set(event_type);
    }
}
