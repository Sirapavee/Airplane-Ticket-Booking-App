package airplaneticketbooking;

public class AlertMessage {
      
      private static String alertMessage;
      
      public AlertMessage(){
            
      }
      
      public static String getAlertMessage() {
            return alertMessage;
      }
      
      public static void setAlertMessage(String alertMessage) {
            AlertMessage.alertMessage = alertMessage;
      }
}
