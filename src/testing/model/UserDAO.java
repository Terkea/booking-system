package testing.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static User getUserFromResultSet(ResultSet rs) throws SQLException{
        User user = null;
        if (rs.next()){
            user.setId(rs.getInt("id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setIp_address(rs.getString("ip_address"));
            user.setIs_admin(rs.getString("is_admin"));
            user.setCity(rs.getString("city"));
            user.setWebsite(rs.getString("website"));
            user.setStreet(rs.getString("street"));
        }
        return user;
    }

    public static ObservableList<User> getUserList(ResultSet rs) throws SQLException, ClassNotFoundException{
        ObservableList<User> userList = FXCollections.observableArrayList();

        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setIp_address(rs.getString("ip_address"));
            user.setIs_admin(rs.getString("is_admin"));
            user.setCity(rs.getString("city"));
            user.setWebsite(rs.getString("website"));
            user.setStreet(rs.getString("street"));

            userList.add(user);
        }
        return userList;
    }

    public static ObservableList<User> searchUsers (String keyword) throws SQLException, ClassNotFoundException {
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
            System.out.println("ERROR While searching for a User with: " + keyword + " name, error occured: " + e);
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
            System.out.println("SQL select operation has failed: " + e );
            throw e;
        }
    }

    public static void deleteUser(int userId) throws SQLException, ClassNotFoundException{
        String stmt = "DELETE FROM user WHERE id = " + userId;

        try{
            DB.dbExecuteUpdate(stmt);
        }catch (SQLException e){
            System.out.println("Error during DELETE operation: " +e );
            throw e;
        }
    }



}
