package airplaneticketbooking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertBoxController implements Initializable {
      
      @FXML Button closeBtn;
      @FXML Label alertLabel;
     
      @Override
      public void initialize(URL url, ResourceBundle rb) {
            alertLabel.setText(AlertMessage.getAlertMessage());
      }   
      
      @FXML
      public void close(ActionEvent event){
            Stage window = (Stage) closeBtn.getScene().getWindow();
            window.close();
      }
}
