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
            user.setOrganization_name(rs.getString("organisation_name"));
            user.setEmail_address(rs.getString("email_address"));
            user.setMobile_no(rs.getString("mobile_no"));
            user.setWebsite_address(rs.getString("web_address"));
            user.setPassword(rs.getString("password"));
            user.setCorporate_name(rs.getString("corporate_name"));
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
            user.setOrganization_name(rs.getString("organisation_name"));
            user.setEmail_address(rs.getString("email_address"));
            user.setMobile_no(rs.getString("mobile_no"));
            user.setWebsite_address(rs.getString("web_address"));
            user.setPassword(rs.getString("password"));
            user.setCorporate_name(rs.getString("corporate_name"));
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
            if (searchUsersByEmail(email) == null){
                return true;
            }else{
                return false;
            }
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
                         "`contact_name`, `contact_phone`, `organisation_name`, `email_address`, `mobile_no`, `web_address`, `password`, `corporate_name`, `is_admin`) " +
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


}