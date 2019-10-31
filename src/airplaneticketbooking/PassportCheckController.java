package airplaneticketbooking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class PassportCheckController implements Initializable {

      private String actualSeat, actualPass, verifyPass, verifySeat, btnId, btnPressedID,userInfo,deleteLine;
      private BufferedReader userInfoReader;
      private FileReader readUserInfo;

      @FXML private TextField passportIDVerify;
      @FXML private Button confirmBtn;
      @FXML private Button cancelBtn;

      @Override
      public void initialize(URL url, ResourceBundle rb) {
            CreateFile read = new CreateFile();
            verifySeat = read.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\verify seat.txt");
      }

      @FXML
      public void verify(ActionEvent event) {
            try {
                  CreateFile confirmBtnStatus = new CreateFile();
                  confirmBtnStatus.openFile("temp\\verify state");
                  Object source = event.getSource();
                  if (source instanceof Button) {
                        Button clickedBtn = (Button) source;
                        btnPressedID = clickedBtn.getId();
                  }
                  confirmBtnStatus.addText(btnPressedID);

                  if (passportIDVerify.getText().trim().isEmpty() != true) {
                        verifyPass = passportIDVerify.getText().trim();
                        
                        readUserInfo = new FileReader("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\user data.txt");
                        userInfoReader = new BufferedReader(readUserInfo);
                        
                        while((userInfo = userInfoReader.readLine())!=null){
                              String[] fragment = userInfo.split("\\s+");
                              actualPass = fragment[1];
                              actualSeat = fragment[2];
                              if(verifySeat.equals(actualSeat)){
                                    if (verifyPass.equals(actualPass)){
                                          CreateFile deletedCustomer = new CreateFile();
                                          deletedCustomer.openFile("temp\\deleted customer");
                                          deletedCustomer.addText(userInfo);
                                          
                                          Stage window = (Stage) confirmBtn.getScene().getWindow();
                                          window.close();
                                    }
                                    else if(!(verifyPass.equals(actualPass))){
                                          AlertMessage.setAlertMessage("Passport ID incorrect!");
                                          Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                                          Scene alert = new Scene(alertParent);
                                          Stage alertWindow = new Stage();
                                          alertWindow.initModality(Modality.APPLICATION_MODAL);
                                          alertWindow.setTitle("Oops");
                                          alertWindow.setScene(alert);
                                          alertWindow.showAndWait();
                                    }
                              }
                        }
                  } 
                  else if (passportIDVerify.getText().trim().isEmpty() == true) {
                        AlertMessage.setAlertMessage("Enter your passport ID first!");
                        Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                        Scene alert = new Scene(alertParent);
                        Stage alertWindow = new Stage();
                        alertWindow.initModality(Modality.APPLICATION_MODAL);
                        alertWindow.setTitle("Oops");
                        alertWindow.setScene(alert);
                        alertWindow.showAndWait();
                  }
            } catch (FileNotFoundException ex) {
                  System.out.println("An error occured " + ex);
            } catch (IOException ex) {
                  System.out.println("An error occured " + ex);
            }
      }

      @FXML
      public void cancel(ActionEvent event) {
            CreateFile closeBtnStatus = new CreateFile();
            closeBtnStatus.openFile("temp\\verify state");
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
