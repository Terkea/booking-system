package application.util;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {

    private static Connection conn = null;
    private static final String DBNAME = "practice";
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

    public static ResultSet dbExecuteQuery(String query) throws SQLException, ClassNotFoundException{
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;

        try{
            dbConnect();
            System.out.println("Select statement : " + query + "\n");

            stmt = conn.createStatement();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        } catch(SQLException e){
            System.out.println("There's a problem with the query: " + e);
            throw e;
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
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
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("There's a problem with the query: " + e);
        } finally {
            if (stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

}
