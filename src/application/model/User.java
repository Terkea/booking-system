package application.model;

import javafx.beans.property.*;

public class User {
    private IntegerProperty id;
    private StringProperty title;
    private StringProperty first_name;
    private StringProperty last_name;
    private StringProperty gender;
    private StringProperty address_line;
    private StringProperty address_line2; // default null
    private StringProperty town;
    private StringProperty county;
    private StringProperty postcode;
    private StringProperty dob;
    private StringProperty contact_name; // default null
    private StringProperty contact_phone; // default null
    private StringProperty organization_name; // default null
    private StringProperty email_address; // unique
    private StringProperty mobile_no;
    private StringProperty website_address; // default null
    private StringProperty password;
    private StringProperty corporate_name; // default null
    private BooleanProperty is_admin; // default null


    public User() {
        this.id = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.address_line = new SimpleStringProperty();
        this.address_line2 = new SimpleStringProperty();
        this.town = new SimpleStringProperty();
        this.county = new SimpleStringProperty();
        this.postcode = new SimpleStringProperty();
        this.dob = new SimpleStringProperty();
        this.contact_name = new SimpleStringProperty();
        this.contact_phone = new SimpleStringProperty();
        this.organization_name = new SimpleStringProperty();
        this.email_address = new SimpleStringProperty();
        this.mobile_no = new SimpleStringProperty();
        this.website_address = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.corporate_name = new SimpleStringProperty();
        this.is_admin = new SimpleBooleanProperty();
    }

    public User(IntegerProperty id, StringProperty title, StringProperty first_name, StringProperty last_name, StringProperty gender, StringProperty address_line, StringProperty address_line2, StringProperty town, StringProperty county, StringProperty postcode, StringProperty dob, StringProperty contact_name, StringProperty contact_phone, StringProperty organization_name, StringProperty email_address, StringProperty mobile_no, StringProperty website_address, StringProperty password, StringProperty corporate_name, BooleanProperty is_admin) {
        this.id = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.address_line = new SimpleStringProperty();
        this.address_line2 = new SimpleStringProperty();
        this.town = new SimpleStringProperty();
        this.county = new SimpleStringProperty();
        this.postcode = new SimpleStringProperty();
        this.dob = new SimpleStringProperty();
        this.contact_name = new SimpleStringProperty();
        this.contact_phone = new SimpleStringProperty();
        this.organization_name = new SimpleStringProperty();
        this.email_address = new SimpleStringProperty();
        this.mobile_no = new SimpleStringProperty();
        this.website_address = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.corporate_name = new SimpleStringProperty();
        this.is_admin = new SimpleBooleanProperty();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", title=" + title +
                ", first_name=" + first_name +
                ", last_name=" + last_name +
                ", gender=" + gender +
                ", address_line=" + address_line +
                ", address_line2=" + address_line2 +
                ", town=" + town +
                ", county=" + county +
                ", postcode=" + postcode +
                ", dob=" + dob +
                ", contact_name=" + contact_name +
                ", contact_phone=" + contact_phone +
                ", organization_name=" + organization_name +
                ", email_address=" + email_address +
                ", mobile_no=" + mobile_no +
                ", website_address=" + website_address +
                ", password=" + password +
                ", corporate_name=" + corporate_name +
                ", is_admin=" + is_admin +
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

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
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

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAddress_line() {
        return address_line.get();
    }

    public StringProperty address_lineProperty() {
        return address_line;
    }

    public void setAddress_line(String address_line) {
        this.address_line.set(address_line);
    }

    public String getAddress_line2() {
        return address_line2.get();
    }

    public StringProperty address_line2Property() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2.set(address_line2);
    }

    public String getTown() {
        return town.get();
    }

    public StringProperty townProperty() {
        return town;
    }

    public void setTown(String town) {
        this.town.set(town);
    }

    public String getCounty() {
        return county.get();
    }

    public StringProperty countyProperty() {
        return county;
    }

    public void setCounty(String county) {
        this.county.set(county);
    }

    public String getPostcode() {
        return postcode.get();
    }

    public StringProperty postcodeProperty() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode.set(postcode);
    }

    public String getDob() {
        return dob.get();
    }

    public StringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public String getContact_name() {
        return contact_name.get();
    }

    public StringProperty contact_nameProperty() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name.set(contact_name);
    }

    public String getContact_phone() {
        return contact_phone.get();
    }

    public StringProperty contact_phoneProperty() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone.set(contact_phone);
    }

    public String getOrganization_name() {
        return organization_name.get();
    }

    public StringProperty organization_nameProperty() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name.set(organization_name);
    }

    public String getEmail_address() {
        return email_address.get();
    }

    public StringProperty email_addressProperty() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address.set(email_address);
    }

    public String getMobile_no() {
        return mobile_no.get();
    }

    public StringProperty mobile_noProperty() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no.set(mobile_no);
    }

    public String getWebsite_address() {
        return website_address.get();
    }

    public StringProperty website_addressProperty() {
        return website_address;
    }

    public void setWebsite_address(String website_address) {
        this.website_address.set(website_address);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getCorporate_name() {
        return corporate_name.get();
    }

    public StringProperty corporate_nameProperty() {
        return corporate_name;
    }

    public void setCorporate_name(String corporate_name) {
        this.corporate_name.set(corporate_name);
    }

    public boolean isIs_admin() {
        return is_admin.get();
    }

    public BooleanProperty is_adminProperty() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin.set(is_admin);
    }
}
