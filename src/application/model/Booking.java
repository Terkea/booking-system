package application.model;

import javafx.beans.property.*;

import java.sql.SQLException;

public class Booking {
    private IntegerProperty id;
    private IntegerProperty number_of_tickets;
    private IntegerProperty event_id;
    private IntegerProperty user_id;
    private IntegerProperty payment_id;
    private StringProperty event_name;
    private StringProperty event_date;
    private StringProperty location;
    private DoubleProperty ticket_price;
    private StringProperty user_first_name;
    private StringProperty user_last_name;



    public Booking(){
        this.id = new SimpleIntegerProperty();
        this.number_of_tickets = new SimpleIntegerProperty();
        this.event_id = new SimpleIntegerProperty();
        this.user_id = new SimpleIntegerProperty();
        this.payment_id = new SimpleIntegerProperty();
        this.event_name = new SimpleStringProperty();
        this.event_date = new SimpleStringProperty();
        this.location = new SimpleStringProperty();
    }

    public void setUpForeignKeys(){
        try {
            this.event_name = new SimpleStringProperty(EventDAO.getEventByIDProperty(event_id).getName());
            this.event_date = new SimpleStringProperty(EventDAO.getEventByIDProperty(event_id).getDate());
            this.location = new SimpleStringProperty((EventDAO.getEventByIDProperty(event_id).getLocation()));
            this.ticket_price = new SimpleDoubleProperty(((EventDAO.getEventByIDProperty(event_id).getTicket_price())));
            this.user_first_name = new SimpleStringProperty(UserDAO.searchUsersByID(user_id).getFirst_name());
            this.user_last_name = new SimpleStringProperty(UserDAO.searchUsersByID(user_id).getLast_name());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Booking(IntegerProperty id, IntegerProperty number_of_tickets, IntegerProperty event_id, IntegerProperty user_id, IntegerProperty payment_id) {
        this.id = new SimpleIntegerProperty();
        this.number_of_tickets = new SimpleIntegerProperty();
        this.event_id = new SimpleIntegerProperty();
        this.user_id = new SimpleIntegerProperty();
        this.payment_id = new SimpleIntegerProperty();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public double getTicket_price() {
        return ticket_price.get();
    }

    public String getUser_first_name() {
        return user_first_name.get();
    }

    public StringProperty user_first_nameProperty() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name.set(user_first_name);
    }

    public String getUser_last_name() {
        return user_last_name.get();
    }

    public StringProperty user_last_nameProperty() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name.set(user_last_name);
    }
    public DoubleProperty ticket_priceProperty() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price.set(ticket_price);
    }

    public String getEvent_name() {
        return event_name.get();
    }

    public StringProperty event_nameProperty() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name.set(event_name);
    }

    public String getEvent_date() {
        return event_date.get();
    }

    public StringProperty event_dateProperty() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date.set(event_date);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setInvoice(String invoice) {
        this.location.set(invoice);
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

    public int getNumber_of_tickets() {
        return number_of_tickets.get();
    }

    public IntegerProperty number_of_ticketsProperty() {
        return number_of_tickets;
    }

    public void setNumber_of_tickets(int number_of_tickets) {
        this.number_of_tickets.set(number_of_tickets);
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

    public int getUser_id() {
        return user_id.get();
    }

    public IntegerProperty user_idProperty() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id.set(user_id);
    }

    public int getPayment_id() {
        return payment_id.get();
    }

    public IntegerProperty payment_idProperty() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id.set(payment_id);
    }
}
