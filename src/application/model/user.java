package application.model;

public class user {
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String gender;
    private String dateOfBirth;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postCode;
    private String contactName;
    private String contactNumber;
    private String emailAddress;
    private String phoneNo;
    private String website;
    private String corporateName;
    private String password;

    //    CONSTRUCTOR
    public user(String firstName, String lastName, String title, String gender, String dateOfBirth,
                String address1, String address2, String town, String county, String postCode, String contactName,
                String contactNumber, String emailAddress, String phoneNo,
                String website, String corporateName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address1 = address1;
        this.address2 = address2;
        this.town = town;
        this.county = county;
        this.postCode = postCode;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.phoneNo = phoneNo;
        this.website = website;
        this.corporateName = corporateName;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getTown() {
        return town;
    }

    public String getCounty() {
        return county;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getWebsite() {
        return website;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public String getPassword() {
        return password;
    }

    public void test(){
        System.out.println("thats the power of extends");
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", town='" + town + '\'' +
                ", county='" + county + '\'' +
                ", postCode='" + postCode + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", website='" + website + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
