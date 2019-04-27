package application.model;

import javafx.beans.property.*;

public class Payment {
    private IntegerProperty id;
    private DoubleProperty ammount;
    private StringProperty card_no;
    private StringProperty expire_date;
    private StringProperty card_holder_name;
    private StringProperty cvs;
    private IntegerProperty user_id;
    private BooleanProperty status;
    private StringProperty description;
    private BooleanProperty discounted;


    public Payment(){
        this.id = new SimpleIntegerProperty();
        this.ammount = new SimpleDoubleProperty();
        this.card_no = new SimpleStringProperty();
        this.expire_date = new SimpleStringProperty();
        this.card_holder_name = new SimpleStringProperty();
        this.cvs = new SimpleStringProperty();
        this.user_id = new SimpleIntegerProperty();
        this.status = new SimpleBooleanProperty();
        this.description = new SimpleStringProperty();
        this.discounted = new SimpleBooleanProperty();
    }

    public Payment(IntegerProperty id, DoubleProperty ammount, StringProperty card_no, StringProperty expire_date, StringProperty card_holder_name, StringProperty cvs, IntegerProperty user_id, BooleanProperty status, StringProperty description) {
        this.id = new SimpleIntegerProperty();
        this.ammount = new SimpleDoubleProperty();
        this.card_no = new SimpleStringProperty();
        this.expire_date = new SimpleStringProperty();
        this.card_holder_name = new SimpleStringProperty();
        this.cvs = new SimpleStringProperty();
        this.user_id = new SimpleIntegerProperty();
        this.status = new SimpleBooleanProperty();
        this.description = new SimpleStringProperty();
    }

    public boolean isDiscounted() {
        return discounted.get();
    }

    public BooleanProperty discountedProperty() {
        return discounted;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted.set(discounted);
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

    public double getAmmount() {
        return ammount.get();
    }

    public DoubleProperty ammountProperty() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount.set(ammount);
    }

    public String getCard_no() {
        return card_no.get();
    }

    public StringProperty card_noProperty() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no.set(card_no);
    }

    public String getExpire_date() {
        return expire_date.get();
    }

    public StringProperty expire_dateProperty() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date.set(expire_date);
    }

    public String getCard_holder_name() {
        return card_holder_name.get();
    }

    public StringProperty card_holder_nameProperty() {
        return card_holder_name;
    }

    public void setCard_holder_name(String card_holder_name) {
        this.card_holder_name.set(card_holder_name);
    }

    public String getCvs() {
        return cvs.get();
    }

    public StringProperty cvsProperty() {
        return cvs;
    }

    public void setCvs(String cvs) {
        this.cvs.set(cvs);
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

    public boolean isStatus() {
        return status.get();
    }

    public BooleanProperty statusProperty() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status.set(status);
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
}
