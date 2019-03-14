package application.dbh;

import java.sql.*;

public class database {
    private Connection connection;
    private ResultSet results;

    public database(String dbName, String name, String password){

        //check that later on
        String url = "jdbc:mysql//localhost:3306/" + dbName;

        //set up the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                this.connection = DriverManager.getConnection(url, name, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doRead(){
        String query = "SELECT * FROM user";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
