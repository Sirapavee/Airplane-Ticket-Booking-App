package airplaneticketbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DecisionMenuController implements Initializable {
      
      private String route = "Bangkok-somewhere";
      
      @FXML private Button checnkFlightInfoBtn;
      @FXML private Button letsGoBtn;
      @FXML private Button exitBtn;
      @FXML private ComboBox<String> destinationChoice;
      
      @Override
      public void initialize(URL url, ResourceBundle rb) {
            destinationChoice.getItems().addAll("Bangkok-Wakanda", "Bangkok-Oasis", "Bangkok-Jakku","Bangkok-Arendelle","Bangkok-Miramar","Bangkok-Lothric");
      }      
      
      @FXML
      public void checkFlightInfo(ActionEvent event) {
            try {
                  Parent flightInfoParent = FXMLLoader.load(getClass().getResource("FlightInformation.fxml"));
                  Scene flightInfo = new Scene(flightInfoParent);
                  Stage flightInfoWindow = new Stage();
                  flightInfoWindow.initModality(Modality.WINDOW_MODAL);
                  flightInfoWindow.setTitle("Flight Information");
                  flightInfoWindow.setScene(flightInfo);
                  flightInfoWindow.showAndWait();
            } catch (IOException ex) {
                  System.out.println("An error occured");
            }
      }
      
      @FXML
      public void letsGo(ActionEvent event){
            try{
                  if(destinationChoice.getValue()!=null){
                        CreateFile routeChoice = new CreateFile();
                        routeChoice.openFile("temp\\Route");    
                        route = destinationChoice.getValue();
                        routeChoice.addText(route);
                        
                        Parent mainMenuParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                        Scene mainMenu = new Scene(mainMenuParent);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(mainMenu);
                        window.show();
                  }
                  else{
                        AlertMessage.setAlertMessage("Please select your destination!");
                        Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                        Scene alert = new Scene(alertParent);
                        Stage alertWindow = new Stage();
                        alertWindow.initModality(Modality.APPLICATION_MODAL);
                        alertWindow.setTitle("Oops");
                        alertWindow.setScene(alert);
                        alertWindow.showAndWait();
                  }
            }catch(IOException ex){
                  System.out.println("An error occured");
            }
      }
      
      @FXML
      public void exit(ActionEvent event){
            Stage window = (Stage) exitBtn.getScene().getWindow();
            window.close();
      }

      public String getRoute(){
            return route;
      }
}
