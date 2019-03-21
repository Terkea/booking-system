package testing.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private IntegerProperty id;
    private StringProperty first_name;
    private StringProperty last_name;
    private StringProperty email;
    private StringProperty gender;
    private StringProperty ip_address;
    private StringProperty is_admin;
    private StringProperty city;
    private StringProperty website;
    private StringProperty street;

    public User() {
        this.id = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.ip_address = new SimpleStringProperty();
        this.is_admin = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.website = new SimpleStringProperty();
        this.street = new SimpleStringProperty();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name=" + first_name +
                ", last_name=" + last_name +
                ", email=" + email +
                ", gender=" + gender +
                ", ip_address=" + ip_address +
                ", is_admin=" + is_admin +
                ", city=" + city +
                ", website=" + website +
                ", street=" + street +
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

    public String getFirst_name() {
        return first_name.get();
    }

    public StringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public StringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getIp_address() {
        return ip_address.get();
    }

    public StringProperty ip_addressProperty() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address.set(ip_address);
    }

    public String getIs_admin() {
        return is_admin.get();
    }

    public StringProperty is_adminProperty() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin.set(is_admin);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getWebsite() {
        return website.get();
    }

    public StringProperty websiteProperty() {
        return website;
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }
}
