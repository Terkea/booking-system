package application.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static User getUserFromResultSet(ResultSet rs) throws SQLException {
        User user = null;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setTitle(rs.getString("title"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setGender(rs.getString("gender"));
            user.setAddress_line(rs.getString("address_line"));
            user.setAddress_line2(rs.getString("address_line2"));
            user.setTown(rs.getString("town"));
            user.setCounty(rs.getString("county"));
            user.setPostcode(rs.getString("postcode"));
            user.setDob(rs.getString("dob"));
            user.setContact_name(rs.getString("contact_name"));
            user.setContact_phone(rs.getString("contact_phone"));
            user.setCorporate_organisation_name(rs.getString("corporate_organisation_name"));
            user.setEmail_address(rs.getString("email_address"));
            user.setMobile_no(rs.getString("mobile_no"));
            user.setWebsite_address(rs.getString("web_address"));
            user.setPassword(rs.getString("password"));
            user.setEvents_organiser_name(rs.getString("events_organiser_name"));
            user.setIs_admin(rs.getBoolean("is_admin"));
        }
        return user;
    }

    private static ObservableList<User> getUserList(ResultSet rs) throws SQLException, ClassNotFoundException{
        ObservableList<User> userList = FXCollections.observableArrayList();

        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setTitle(rs.getString("title"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setGender(rs.getString("gender"));
            user.setAddress_line(rs.getString("address_line"));
            user.setAddress_line2(rs.getString("address_line2"));
            user.setTown(rs.getString("town"));
            user.setCounty(rs.getString("county"));
            user.setPostcode(rs.getString("postcode"));
            user.setDob(rs.getString("dob"));
            user.setContact_name(rs.getString("contact_name"));
            user.setContact_phone(rs.getString("contact_phone"));
            user.setCorporate_organisation_name(rs.getString("corporate_organisation_name"));
            user.setEmail_address(rs.getString("email_address"));
            user.setMobile_no(rs.getString("mobile_no"));
            user.setWebsite_address(rs.getString("web_address"));
            user.setPassword(rs.getString("password"));
            user.setEvents_organiser_name(rs.getString("events_organiser_name"));
            user.setIs_admin(rs.getBoolean("is_admin"));

            userList.add(user);
        }
        return userList;
    }

    public static ObservableList<User> searchUsersByName (String keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM user " +
                "WHERE first_name " +
                "LIKE \"%" + keyword + "\"" +
                "OR last_name " +
                "LIKE \"%" + keyword + "\"";
        try{
            ResultSet rsUsers = DB.dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsUsers);

            return userList;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
            throw e;
        }
    }

    public static User searchUsersByEmail (String keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM `user` " +
                "WHERE email_address = \"" + keyword + "\"";
        try{
            ResultSet rs = DB.dbExecuteQuery(selectStmt);
            User user = getUserFromResultSet(rs);

            return user;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
            System.err.println(selectStmt);
            throw e;
        }
    }

    public static User searchUsersByID (int keyword) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM `user` " +
                "WHERE id = \"" + keyword + "\"";
        try{
            ResultSet rs = DB.dbExecuteQuery(selectStmt);
            User user = getUserFromResultSet(rs);

            return user;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
            System.err.println(selectStmt);
            throw e;
        }
    }

    public static ObservableList<User> getAllUsers () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM user";
        try {
            ResultSet rsUsers = DB.dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsUsers);

            return userList;
        }catch (SQLException e){
            System.err.println("SQL select operation has failed: " + e );
            throw e;
        }
    }


    public static ObservableList<User> getAllCorporateOrganisations () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * \n" +
                "FROM user\n" +
                "WHERE NOT (`corporate_organisation_name` = \"null\" \n" +
                "           OR `corporate_organisation_name` = \"NULL\" \n" +
                "           OR `corporate_organisation_name` = \"\");";
        try {
            ResultSet rsUsers = DB.dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsUsers);

            return userList;
        }catch (SQLException e){
            System.err.println("SQL select operation has failed: " + e );
            throw e;
        }
    }

    public static ObservableList<User> getAllEventOrganisers () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * \n" +
                "FROM user\n" +
                "WHERE NOT (`events_organiser_name` = \"null\" \n" +
                "           OR `events_organiser_name` = \"NULL\" \n" +
                "           OR `events_organiser_name` = \"\");";
        try {
            ResultSet rsUsers = DB.dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsUsers);

            return userList;
        }catch (SQLException e){
            System.err.println("SQL select operation has failed: " + e );
            throw e;
        }
    }

    public static ObservableList<User> getAllAgents () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * " +
                "FROM `user` " +
                "WHERE is_agent = true;";
        try {
            ResultSet rsUsers = DB.dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsUsers);

            return userList;
        }catch (SQLException e){
            System.err.println("SQL select operation has failed: " + e );
            throw e;
        }
    }

    public static ObservableList<User> getAllCustomers () throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT *\n" +
                "FROM user\n" +
                "WHERE (`corporate_organisation_name` = \"null\" OR `corporate_organisation_name` = \"NULL\" OR `corporate_organisation_name` = \"\" OR `corporate_organisation_name` = null)\n" +
                "AND\n" +
                "(`events_organiser_name` = \"null\" OR `events_organiser_name` = \"NULL\" OR `events_organiser_name` = \"\" OR `events_organiser_name` = null)\n" +
                "AND\n" +
                "is_admin = false\n" +
                "AND\n" +
                "is_admin = false;";
        try {
            ResultSet rsUsers = DB.dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsUsers);

            return userList;
        }catch (SQLException e){
            System.err.println("SQL select operation has failed: " + e );
            throw e;
        }
    }

    public static void deleteUser(int userId) throws SQLException, ClassNotFoundException{
        String stmt = "DELETE FROM user WHERE id = " + userId;

        try{
            DB.dbExecuteUpdate(stmt);
        }catch (SQLException e){
            System.err.println("Error during DELETE operation: " +e );
            throw e;
        }
    }

    public static boolean checkEmailUnique(String email){
        try {
            return searchUsersByEmail(email) == null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("checkEmailUnique error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("checkEmailUnique error");
        }
        return false;
    }

    public static void insertUser (String title, String first_name, String last_name, String gender, String address_line,
                                  String address_line2, String town, String county, String postcode, String dob,
                                  String contact_name, String contact_phone, String organization_name, String email_address,
                                  String mobile_no, String web_address, String password, String corporate_name, boolean is_admin) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "INSERT INTO `user` " +
                        "(`title`, `first_name`, `last_name`, `gender`, `address_line`, `address_line2`, `town`, `county`, `postcode`, `dob`, " +
                         "`contact_name`, `contact_phone`, `corporate_organisation_name`, `email_address`, `mobile_no`, `web_address`, `password`, `events_organiser_name`, `is_admin`) " +
                        "VALUES\n" +
                        "('" +title+ "', '" +first_name+ "', '" +last_name+ "', '"+gender+ "', '"+address_line+ "', '"+address_line2+ "', '"+town+ "', '"+
                        county+ "', '"+postcode+ "', '"+dob+ "', '"+contact_name+ "', '"+contact_phone+ "', '"+organization_name+ "', '"+email_address+ "', '"+
                        mobile_no+ "', '"+web_address+ "', '"+password+ "', '"+corporate_name+ "', "+is_admin+ ");";

//        System.out.println(updateStmt);

        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public void updateUser(User user){

        String query = "UPDATE user " +
                "SET title = '" + user.getTitle() + "', " +
                "first_name = '" + user.getFirst_name() + "', " +
                "last_name = '" + user.getLast_name() + "', " +
//                "gender = " + user.getGender() + ", " +
                "address_line = '" + user.getAddress_line() + "', " +
                "address_line2 = '" + user.getAddress_line2() + "', " +
                "town = '" + user.getTown() + "', " +
                "county = '" + user.getCounty() + "', " +
                "postcode = '" + user.getPostcode() + "', " +
                "dob = '" + user.getDob() + "', " +
                "contact_name = '" + user.getContact_name() + "', " +
                "contact_phone = '" + user.getContact_phone() + "', " +
                "corporate_organisation_name = '" + user.getCorporate_organisation_name() + "', " +
                "mobile_no = '" + user.getMobile_no() + "', " +
                "web_address = '" + user.getWebsite_address() + "' " +
                "WHERE id = '" + user.getId() + "';";
        try {
            DB.dbExecuteUpdate(query);
            System.out.println("Restart required to apply settings");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void updateUserPassword(int id, String password){

        String query = "UPDATE user " +
                "SET password = '" + password + "' " +
                "WHERE id = '" + id + "';";
        try {
            DB.dbExecuteUpdate(query);
            System.out.println("Restart required to apply settings");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkCorporateOrganization(int id){
        try {
            User attempt = searchUsersByID(id);
            return attempt.getCorporate_organisation_name() != null && !attempt.getCorporate_organisation_name().equals("null")
                    && !attempt.getCorporate_organisation_name().equals("NULL") && !attempt.getCorporate_organisation_name().isEmpty()
                    && !attempt.getCorporate_organisation_name().equals("");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkAdmin(int id){
        try {
            User attempt = searchUsersByID(id);
            return attempt.isIs_admin();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
