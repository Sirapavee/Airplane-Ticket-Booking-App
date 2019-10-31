package airplaneticketbooking;

public class Customer {
      private String name,passportID,bookedSeat,route;
      private String customerInfo = " ";
      
      public Customer(String name,String passportID,String bookedSeat,String route){
            this.name = name;
            this.passportID = passportID;
            this.bookedSeat = bookedSeat;
            this.route = route;
      }
      
      public String getName(){
            return name;
      }
      
      public String getPassportID(){
            return passportID;
      }
      
      public String getBookedSeat(){
            return bookedSeat;
      }
      
      public String getRoute(){
            return route;
      }
      
      public void setName(String name){
            this.name = name;
      }
      
      public void setPassportID(String passportID){
            this.passportID = passportID;
      }
      
      public void setBookedSeat(String bookedSeat){
            this.bookedSeat = bookedSeat;
      }
      
      public void setRoute(String route){
            this.route = route;
      }
      
      public String customerInfoToString(){
            customerInfo = name+" "+passportID+" "+bookedSeat+" "+route;
            return customerInfo;
      }
}
