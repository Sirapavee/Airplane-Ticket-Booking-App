package airplaneticketbooking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FlightInformationController implements Initializable {

      @FXML private TableColumn<Destination, String> destination;
      @FXML private TableColumn<Destination, Integer> flight;
      @FXML private TableColumn<Destination, String> schedule;
      @FXML private TableColumn<Destination, String> gate;
      @FXML private TableColumn<Destination, String> remark;
      @FXML private TableView<Destination> table;
      
      @Override
      public void initialize(URL url, ResourceBundle rb) {
            destination.setCellValueFactory(new PropertyValueFactory<>("name"));
            flight.setCellValueFactory(new PropertyValueFactory<>("flight"));
            schedule.setCellValueFactory(new PropertyValueFactory<>("schedule"));
            gate.setCellValueFactory(new PropertyValueFactory<>("gate"));
            remark.setCellValueFactory(new PropertyValueFactory<>("remark"));
            table.setItems(getDestination());
      }      
      
      public ObservableList<Destination> getDestination(){
            ObservableList<Destination> destinations = FXCollections.observableArrayList();
            destinations.add(new Destination("Wakanda",420,"10.00AM","W6","on time"));
            destinations.add(new Destination("Oasis",9999,"1.00PM","C9","on time"));
            destinations.add(new Destination("Jakku",88,"5.00AM","S8","on time"));
            destinations.add(new Destination("Arendelle",123,"10.00PM","E5","on time"));
            destinations.add(new Destination("Miramar",69,"9.00AM","M4","on time"));
            destinations.add(new Destination("Lothric",74,"2.00AM","D3","on time"));
            return destinations;
      }
}
