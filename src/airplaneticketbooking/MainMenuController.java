package airplaneticketbooking;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

      @FXML private Button A1;
      @FXML private Button A2;
      @FXML private Button A3;
      @FXML private Button A4;
      @FXML private Button A5;
      @FXML private Button A6;
      @FXML private Button A7;
      @FXML private Button A8;
      @FXML private Button A9;
      @FXML private Button B7;
      @FXML private Button B8;
      @FXML private Button B9;
      @FXML private Button C3;
      @FXML private Button C4;
      @FXML private Button C5;
      @FXML private Button C6;
      @FXML private Button C7;
      @FXML private Button C8;
      @FXML private Button C9;
      @FXML private Button D3;
      @FXML private Button D4;
      @FXML private Button D5;
      @FXML private Button D6;
      @FXML private Button D7;
      @FXML private Button D8;
      @FXML private Button D9;
      @FXML private Button E3;
      @FXML private Button E4;
      @FXML private Button E5;
      @FXML private Button E6;
      @FXML private Button E7;
      @FXML private Button E8;
      @FXML private Button E9;
      @FXML private Button F3;
      @FXML private Button F4;
      @FXML private Button F5;
      @FXML private Button F6;
      @FXML private Button F7;
      @FXML private Button F8;
      @FXML private Button F9;
      @FXML private Button G7;
      @FXML private Button G8;
      @FXML private Button G9;
      @FXML private Button H1;
      @FXML private Button H2;
      @FXML private Button H3;
      @FXML private Button H4;
      @FXML private Button H5;
      @FXML private Button H6;
      @FXML private Button H7;
      @FXML private Button H8;
      @FXML private Button H9;
      
      @FXML private Button showData;
      @FXML private Button exitBtn;
      @FXML private ToggleButton bookingBtn;
      @FXML private ToggleButton cancelingBtn;
      @FXML private ToggleGroup workingGroup;
      
      private Button[] notBookedBtns = new Button[52];
      private Button[] bookedBtns = new Button[52];
      private int count = 0;
      private ArrayList<String> customerList = new ArrayList<>();
      private String btnId = " ";
      private String bookedSeatID = " ";
      private String pressedBtn;
      private BufferedWriter writeFile;
      private FileReader readDeletedUser;
      private BufferedReader deletedUserReader;
      private String deletedUser;
      private String cusInfo;
      private File userData;
      
      @Override
      public void initialize(URL url, ResourceBundle rb) {
            notBookedBtns[0] = A1;
            notBookedBtns[1] = A2;
            notBookedBtns[2] = A3;
            notBookedBtns[3] = A4;
            notBookedBtns[4] = A5;
            notBookedBtns[5] = A6;
            notBookedBtns[6] = A7;
            notBookedBtns[7] = A8;
            notBookedBtns[8] = A9;
            notBookedBtns[9] = B7;
            notBookedBtns[10] = B8;
            notBookedBtns[11] = B9;
            notBookedBtns[12] = C3;
            notBookedBtns[13] = C4;
            notBookedBtns[14] = C5;
            notBookedBtns[15] = C6;
            notBookedBtns[16] = C7;
            notBookedBtns[17] = C8;
            notBookedBtns[18] = C9;
            notBookedBtns[19] = D3;
            notBookedBtns[20] = D4;
            notBookedBtns[21] = D5;
            notBookedBtns[22] = D6;
            notBookedBtns[23] = D7;
            notBookedBtns[24] = D8;
            notBookedBtns[25] = D9;
            notBookedBtns[26] = E3;
            notBookedBtns[27] = E4;
            notBookedBtns[28] = E5;
            notBookedBtns[29] = E6;
            notBookedBtns[30] = E7;
            notBookedBtns[31] = E8;
            notBookedBtns[32] = E9;
            notBookedBtns[33] = F3;
            notBookedBtns[34] = F4;
            notBookedBtns[35] = F5;
            notBookedBtns[36] = F6;
            notBookedBtns[37] = F7;
            notBookedBtns[38] = F8;
            notBookedBtns[39] = F9;
            notBookedBtns[40] = G7;
            notBookedBtns[41] = G8;
            notBookedBtns[42] = G9;
            notBookedBtns[43] = H1;
            notBookedBtns[44] = H2;
            notBookedBtns[45] = H3;
            notBookedBtns[46] = H4;
            notBookedBtns[47] = H5;
            notBookedBtns[48] = H6;
            notBookedBtns[49] = H7;
            notBookedBtns[50] = H8;
            notBookedBtns[51] = H9;
      }      
      
      @FXML
      public void press(ActionEvent event){
            try{
                  if(bookingBtn.isSelected()==true){
                        Object source = event.getSource();
                        if (source instanceof Button) {
                              Button clickedBtn = (Button) source; 
                              bookedSeatID = clickedBtn.getId();
                              System.out.println(clickedBtn.getId());
                        }
                        CreateFile bookedSeat = new CreateFile();
                        bookedSeat.openFile("temp\\Booked seat");     
                        bookedSeat.addText(bookedSeatID);
                        
                        Parent inputParent = FXMLLoader.load(getClass().getResource("CustomerInput.fxml"));
                        Scene input = new Scene(inputParent);
                        Stage alertWindow = new Stage();
                        alertWindow.initModality(Modality.APPLICATION_MODAL);
                        alertWindow.setTitle("Please input your information");
                        alertWindow.setScene(input);
                        alertWindow.showAndWait();
                        
                        CreateFile read = new CreateFile();
                        btnId = read.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\What button is pressed.txt");
                        
                        if(btnId.equals("submitBtn")){
                              Object source2 = event.getSource();
                              if (source2 instanceof Button) {
                                    Button clickedBtn = (Button) source2; 
                                    clickedBtn.setDisable(true);
                                    bookedBtns[count] = clickedBtn;
                                    btnId = bookedBtns[count].getId();
                                    count+=1;
                                    for(int i = 0;i<notBookedBtns.length;i++){
                                          if(notBookedBtns[i]==clickedBtn){
                                                notBookedBtns[i]=null;
                                                break;
                                          }
                                    }
                              }
                              
                              CreateFile infoRead = new CreateFile();
                              cusInfo = infoRead.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\customer info.txt");
                              customerList.add(cusInfo);
                        }
                        else if(btnId.equals("closeBtn")){
                              Object source3 = event.getSource();
                              if (source3 instanceof Button) {
                                    Button clickedBtn = (Button) source3; 
                                    clickedBtn.setDisable(false);
                              }
                        }
                  }
                  else if(cancelingBtn.isSelected()==true){
                        Object source = event.getSource();
                        if (source instanceof Button) {
                              Button clickedBtn = (Button) source; 
                              
                              CreateFile verifySeat = new CreateFile();
                              verifySeat.openFile("temp\\verify seat");
                              verifySeat.addText(clickedBtn.getId());
                              
                              Parent verifyParent = FXMLLoader.load(getClass().getResource("PassportCheck.fxml"));
                              Scene verify = new Scene(verifyParent);
                              Stage alertWindow = new Stage();
                              alertWindow.initModality(Modality.APPLICATION_MODAL);
                              alertWindow.setTitle("Please verify your passport ID");
                              alertWindow.setScene(verify);
                              alertWindow.showAndWait();
                              
                              CreateFile readState = new CreateFile();
                              pressedBtn = readState.readFile("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\verify state.txt");
                              
                              if(pressedBtn.equals("confirmBtn")){
                                    clickedBtn.setDisable(true);
                                    readDeletedUser = new FileReader("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\temp\\deleted customer.txt");
                                    deletedUserReader = new BufferedReader(readDeletedUser);
                                    deletedUser = deletedUserReader.readLine();
                                    for(int i = 0;i<customerList.size();i++){
                                          if(customerList.get(i)!=null){
                                                if(customerList.get(i).equals(deletedUser)){
                                                      customerList.remove(i);
                                                      break;
                                                }
                                          }
                                    }
                                    for(int i = 0;i<bookedBtns.length;i++){
                                          if(bookedBtns[i]==clickedBtn){
                                                bookedBtns[i]=null;
                                                break;
                                          }
                                    }
                                    for(int i = 0;i<notBookedBtns.length;i++){
                                          if(notBookedBtns[i]==null){
                                                notBookedBtns[i]=clickedBtn;
                                                break;
                                          }
                                    }
                              }
                              else if(pressedBtn.equals("cancelBtn")){
                                    Object source4 = event.getSource();
                                    if (source4 instanceof Button) {
                                          Button clickededBtn = (Button) source4; 
                                          clickededBtn.setDisable(false);
                                    }
                              }
                        }
                  }   
                  else if(bookingBtn.isSelected()!=true){
                        if(cancelingBtn.isSelected()!=true){
                              AlertMessage.setAlertMessage("Please select operation mode first!");
                              Parent alertParent = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
                              Scene alert = new Scene(alertParent);
                              Stage alertWindow = new Stage();
                              alertWindow.initModality(Modality.APPLICATION_MODAL);
                              alertWindow.setTitle("Oops");
                              alertWindow.setScene(alert);
                              alertWindow.showAndWait();
                        }
                  }
                  
                  userData = new File("user data.txt");
                  writeFile = new BufferedWriter(new FileWriter(userData,false));
                  for(int i = 0;i<customerList.size();i++){
                        writeFile.write(customerList.get(i));
                        writeFile.newLine();
                  }
                  writeFile.close();
            }catch(IOException ex){
                  System.out.println("An error occured "+ex);
            }
      }
      
      @FXML
      public void booking(ActionEvent event){
            for(int i = 0;i<notBookedBtns.length;i++){
                        if(notBookedBtns[i]!=null){
                              notBookedBtns[i].setDisable(false);
                        }
            }
            try{
                  for(int i = 0;i<bookedBtns.length;i++){
                        if(bookedBtns[i]!=null){
                              bookedBtns[i].setDisable(true);
                        }
                  }
            }catch(Exception ex){
                  System.out.println("An error occured "+ex);
            }
      }
      
      @FXML
      public void cancel(ActionEvent event){
            for(int i = 0;i<notBookedBtns.length;i++){
                        if(notBookedBtns[i]!=null){
                              notBookedBtns[i].setDisable(true);
                        }
            }
            try{
                  for(int i = 0;i<bookedBtns.length;i++){
                        if(bookedBtns[i]!=null){
                              bookedBtns[i].setDisable(false);
                        }
                  }
            }catch(Exception ex){
                  System.out.println("An error occured "+ex);
            }
      }
      
      @FXML
      public void showData(ActionEvent event){
            try {
                  Desktop.getDesktop().open(new File("D:\\Download\\Document\\[Java Project]\\6033662623_AirPlaneTicketBooking\\user data.txt"));
            } catch (FileNotFoundException ex) {
                  System.out.println("An error occured "+ex);
            } catch (IOException ex) {
                  System.out.println("An error occured "+ex);
            }
      }
      
      @FXML
      public void exit(ActionEvent event){
            Stage window = (Stage) exitBtn.getScene().getWindow();
            window.close();
      }
      
      public ArrayList<String> getCustomerList(){
            return customerList;
      }
      
      public void addCustomer(String customer){
            customerList.add(customer);
      }
}
