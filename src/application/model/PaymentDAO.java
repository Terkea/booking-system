package application.model;

import application.system.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO {
    private static Payment getEventFromResultSet(ResultSet rs) throws SQLException {
        Payment payment = null;
        if (rs.next()){
            payment = new Payment();
            payment.setId(rs.getInt("id"));
            payment.setAmmount(rs.getDouble("ammount"));
            payment.setCard_no(rs.getString("card_no"));
            payment.setExpire_date(rs.getString("expire_date"));
            payment.setCard_holder_name(rs.getString("card_holder_name"));
            payment.setCvs(rs.getString("cvs"));
            payment.setUser_id(rs.getInt("user_id"));
        }
        return payment;
    }

    private static ObservableList<Payment> getPaymentList(ResultSet rs) throws SQLException, ClassNotFoundException{
        ObservableList<Payment> paymentList = FXCollections.observableArrayList();

        while (rs.next()){
            Payment payment = new Payment();
            payment.setId(rs.getInt("id"));
            payment.setAmmount(rs.getDouble("ammount"));
            payment.setCard_no(rs.getString("card_no"));
            payment.setExpire_date(rs.getString("expire_date"));
            payment.setCard_holder_name(rs.getString("card_holder_name"));
            payment.setCvs(rs.getString("cvs"));
            payment.setUser_id(rs.getInt("user_id"));
            paymentList.add(payment);
        }
        return paymentList;
    }

    public static ObservableList<Payment> searchUserPayments (int id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * " +
                "FROM payment " +
                "WHERE user_id ='" + id + "'";
        try{
            ResultSet rsPayment = DB.dbExecuteQuery(selectStmt);
            ObservableList<Payment> paymentList = getPaymentList(rsPayment);

            return paymentList;
        }catch(SQLException e){
            System.err.println("ERROR While searching for a Payment with: " + id + " name, error occured: " + e);
            throw e;
        }
    }

    public static void insertPayment (double ammount, String card_no, String expire_date, String card_holder_name, String cvs, int user_id) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "INSERT INTO `payment` " +
                "(`ammount`, `card_no`, `expire_date`, `card_holder_name`, `cvs`, `user_id`) " +
                "VALUES\n" +
                "('" +ammount+ "', '" +card_no+ "', '" +expire_date+ "', '"+card_holder_name+ "', '"+cvs + "', '"+user_id+ "'";

        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.err.print("Error occurred while INSERTING PAYMENT Operation: " + e);



            
            throw e;
        }
    }
}
