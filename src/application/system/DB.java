package application.system;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

public class DB {

    private static Connection conn = null;

    private static final String DBNAME = "booking-system";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://localhost/" + DBNAME;


    public static void dbConnect() throws SQLException, ClassNotFoundException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load driver");
            e.printStackTrace();
            throw e;
        }

        System.out.println("Driver loaded");

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection to db failed!" + e);
            e.printStackTrace();
            throw e;
        }

        System.out.println("Connected to the DB");

    }

    public static void dbDisconnect() throws SQLException{
        try{
            if (conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch(Exception e){
            throw e;
        }
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");

            stmt = conn.createStatement();

            resultSet = stmt.executeQuery(queryStmt);

            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }

    public static void dbExecuteUpdate(String query) throws SQLException, ClassNotFoundException{
        Statement stmt = null;
        try{
            dbConnect();
            System.out.println("Select statement : " + query + "\n");

            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("There's a problem with the query: " + e + "\n");
        } finally {
            if (stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }
    }


}
