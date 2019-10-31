package airplaneticketbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerInputController implements Initializable {

      private boolean cancelBtnStatus;
      private String name,passportID,btnId;

      @FXML private TextField nameInput;
      @FXML private TextField passportIDInput;
      @FXML private Button submitBtn;
      @FXML private Button cancelBtn;

      @Override
      public void initialize(URL url, ResourceBundle rb) {
            // TODO
      }

      @FXML
      public void submit(ActionEvent event) {
            try {
                  if (nameInput.getText().trim().isEmpty() != true & passportIDInput.getText().trim().isEmpty() != true) {
                        if (passportIDInput.getText().trim().length() == 9) {
                              name = nameInput.getText();
                              passportID= passportIDInput.getText();
                              
                              CreateFile customerName = new CreateFile();
                              customerName.openFile("temp\\Customer Name");
                              customerName.addText(nameInput.getText().trim());
                              
                              CreateFile customerPassportID = new CreateFile();
                              customerPassportID.openFile("temp\\Passport ID");
                              customerPassportID.addText(passportIDInput.getText().trim());
                              
                              CreateFile submitBtnStatus = new CreateFile();
                              submitBtnStatus.openFile("temp\\What button is pressed");
                              Object source = event.getSource();
                              if (source instanceof Button) {
                                    Button clickedBtn = (Button) source; 
                                    btnId = clickedBtn.getId();
                              }
                              submitBtnStatus.addText(btnId);
                              
                              Stage window = (Stage) submitBtn.getScene().getWindow();
                              window.close();
                              
                              Parent showMessageParent = FXMLLoader.load(getClass().getResource("ShowTicketData.fxml"));
                              Scene showMessage = new Scene(showMessageParent);
                              Stage showWindow = new Stage();
                              showWindow.initModality(Modality.NONE);
                              showWindow.setTitle("Morazoom Ticket");
                              showWindow.setScene(showMessage);
                              showWindow.showAndWait();
                              
                              
                        } 
                        else if (passportIDInput.getText().trim().length() != 9) {
                              AlertMessage.setAlertMessage("Passport ID must be 9 digits!");
                              Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                              Scene alert = new Scene(alertParent);
                              Stage alertWindow = new Stage();
                              alertWindow.initModality(Modality.APPLICATION_MODAL);
                              alertWindow.setTitle("Oops");
                              alertWindow.setScene(alert);
                              alertWindow.showAndWait();
                        }
                  } 
                  else if (nameInput.getText().isEmpty() == true & passportIDInput.getText().trim().isEmpty() == true) {
                        AlertMessage.setAlertMessage("Please enter your name and passport ID!");
                        Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                        Scene alert = new Scene(alertParent);
                        Stage alertWindow = new Stage();
                        alertWindow.initModality(Modality.APPLICATION_MODAL);
                        alertWindow.setTitle("Oops");
                        alertWindow.setScene(alert);
                        alertWindow.showAndWait();
                  } 
                  else if (nameInput.getText().trim().isEmpty() == true & passportIDInput.getText().trim().isEmpty() != true) {
                        if (passportIDInput.getText().trim().length() == 9) {
                              AlertMessage.setAlertMessage("Please enter your name!");
                              Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                              Scene alert = new Scene(alertParent);
                              Stage alertWindow = new Stage();
                              alertWindow.initModality(Modality.APPLICATION_MODAL);
                              alertWindow.setTitle("Oops");
                              alertWindow.setScene(alert);
                              alertWindow.showAndWait();
                        } 
                        else if (passportIDInput.getText().trim().length() != 9) {
                              AlertMessage.setAlertMessage("Please enter your name and passport ID must be 9 digits!");
                              Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                              Scene alert = new Scene(alertParent);
                              Stage alertWindow = new Stage();
                              alertWindow.initModality(Modality.APPLICATION_MODAL);
                              alertWindow.setTitle("Oops");
                              alertWindow.setScene(alert);
                              alertWindow.showAndWait();
                        }
                  } 
                  else if (nameInput.getText().trim().isEmpty() != true & passportIDInput.getText().trim().isEmpty() == true) {
                        AlertMessage.setAlertMessage("Please enter your passport ID!");
                        Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                        Scene alert = new Scene(alertParent);
                        Stage alertWindow = new Stage();
                        alertWindow.initModality(Modality.APPLICATION_MODAL);
                        alertWindow.setTitle("Oops");
                        alertWindow.setScene(alert);
                        alertWindow.showAndWait();
                  }
            } catch (IOException ex) {
                  System.out.println("An error occured"+ex);
            }
      }

      @FXML
      public void close(ActionEvent event) {
            CreateFile closeBtnStatus = new CreateFile();
            closeBtnStatus.openFile("temp\\what button is pressed");
            Object source = event.getSource();
            if (source instanceof Button) {
                  Button clickedBtn = (Button) source; 
                  btnId = clickedBtn.getId();
            }
            closeBtnStatus.addText(btnId);
            
            Stage window = (Stage) cancelBtn.getScene().getWindow();
            window.close();
      }
}
