package application.database;

import java.sql.*;

public class database {
    public static void main(String[] args){
        String url = "jdbc:mysql://http://localhost:3306";
        String user = "root";
        String password = "your_password";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement query = conn.createStatement();
            String sql = "SELECT * FROM sex";
            ResultSet rs = query.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
