package application.system;

import application.model.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;

import static com.sun.deploy.trace.Trace.flush;

public class Invoice_Generator {
    public static String generateInvoiceByBookingId(int bookingID){
        Booking currentBooking = null;
        User currentUser = null;
        Payment currentPayment = null;
        Event currentEvent = null;
        try {
            currentBooking = BookingDAO.getBookingBYID(bookingID);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            currentUser = UserDAO.searchUsersByID(currentBooking.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            currentPayment = PaymentDAO.getPaymentByID(currentBooking.getPayment_id());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            currentEvent = EventDAO.getEventByID(currentBooking.getEvent_id());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String fileName = currentBooking.getId() + "" + currentBooking.getEvent_id() + "" + currentBooking.getPayment_id();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(fileName + ".pdf")));
            document.open();

            Font title = new Font();
            title.setSize(25);
            Paragraph p = new Paragraph("Vikings Invoice" ,title);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            document.add(new Paragraph("\n"));

            Font info = new Font();
            info.setSize(10);
            Paragraph p2 = new Paragraph("Vikings" +
                    "\n" +
                    "Company address, \n" +
                    "Company city, county, postcode \n" +
                    "Company phone, website, contact info\n", info);
            p2.setAlignment(Element.ALIGN_LEFT);
            document.add(p2);

            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));

            Font bold = new Font();
            bold.setStyle(Font.BOLD);

            Paragraph p3 = new Paragraph("Bill to: \n" , bold);
            document.add(p3);
            p3.setAlignment(Element.ALIGN_BOTTOM);

            Paragraph p4 = new Paragraph(
                    currentUser.getTitle() + " " + currentUser.getFirst_name() + " " + currentUser.getLast_name() + "\n" +
                            currentUser.getAddress_line() +", \n" +
                            currentUser.getAddress_line2() + " \n" +
                            currentUser.getTown() + " " + currentUser.getCounty() + " \n" +
                            currentUser.getPostcode().toUpperCase(), info);
            document.add(p4);

            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));


            PdfPTable table = new PdfPTable(new float[]{3,3,3,3});
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setFixedHeight(50);
            table.setTotalWidth(PageSize.A4.getWidth());
            table.setWidthPercentage(100);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell("Event name");
            table.addCell("Tickets bought");
            table.addCell("Ticket price");
            table.addCell("Payment date and time");
            table.setHeaderRows(1);
            PdfPCell[] cells = table.getRow(0).getCells();
            for (int i = 0; i<cells.length;i++){
                cells[i].setBackgroundColor(BaseColor.GRAY);
            }

            table.addCell(currentEvent.getEvent_type() + " " + currentEvent.getName());
            table.addCell(currentBooking.getNumber_of_tickets() + "");
            table.addCell(currentEvent.getTicket_price() + " GBP");
            table.addCell(currentPayment.getDate_created());

            document.add(table);

            document.add(new Paragraph("\n"));
            double ammount = currentBooking.getNumber_of_tickets() * currentEvent.getTicket_price();
            double discount = 20.0/100.0;
            double totalAmmount = ammount-(ammount*discount);
            Paragraph p5 = new Paragraph("Sub total: " + ammount + " GBP \n");
            if (currentPayment.isDiscounted() == true){
                p5.add("Discounted: 20%");
            }else{
                p5.add("Discounted: 0%");
            }
            p5.setAlignment(Element.ALIGN_RIGHT);
            document.add(p5);
            document.add(new Paragraph("\n"));

            Font total = new Font();
            total.setStyle(Font.BOLD);
            Paragraph p6 = new Paragraph();
            if (currentPayment.isDiscounted() == true){
                p6.add("TOTAL AMMOUNT: " + totalAmmount + " GBP \n");
            }else{
                p6.add("TOTAL AMMOUNT: " + ammount + " GBP \n");
            }
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(p6);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
