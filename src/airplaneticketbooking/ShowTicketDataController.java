package airplaneticketbooking;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ShowTicketDataController implements Initializable {

      private String name,passportID,seatNum,message,route;
      private PrintStream printInfo;
      
      @FXML private Label showText;
            
      @Override
      public void initialize(URL url, ResourceBundle rb) {
            try{
            CreateFile read = new CreateFile();
            name = read.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\Customer Name.txt");
            passportID = read.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\Passport ID.txt");
            seatNum = read.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\Booked seat.txt");
            route = read.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\Route.txt");
            
            showText.setText(getMessage());
            
            CreateFile ticket = new CreateFile();
            ticket.openFile("ticket");
            printInfo = new PrintStream(ticket.getFile());
            printInfo.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            printInfo.println("Morazoom Airline Ticket\n");
            printInfo.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            printInfo.println("Passenger's name : "+name+"\n");
            printInfo.println("Passport ID : "+passportID+"\n");
            printInfo.println("Seat no. : "+seatNum+"\n");
            printInfo.println("Route : "+route+"\n");
            printInfo.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            printInfo.println("Eventough our pilots are old \n");
            printInfo.println("But our planes are new *winky face*");
                  
            Customer customer = new Customer(name,passportID,seatNum,route);
            CreateFile customerInfo = new CreateFile();
            customerInfo.openFile("temp\\customer info");
            customerInfo.addText(customer.customerInfoToString());
            }catch(IOException ex){
                  System.out.println("a");
            }
      }      
      
      public String getMessage(){
            message = ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"+ 
                             "          Morazoom Airline Ticket\n"+
                             "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"+
                             "Passenger's name : "+name+"\n"+
                             "Passport ID : "+passportID+"\n"+
                              "Seat no. : "+seatNum+"\n"+
                              "Route : "+route+"\n"+
                              "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"+
                              "        Eventough our pilots are old \nBut our planes are new *winky face*");
            return message;
      }
}
