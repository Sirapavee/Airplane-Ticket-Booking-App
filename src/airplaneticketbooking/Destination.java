package airplaneticketbooking;

public class Destination {
      String name,schedule,gate,remark;
      int flight;
      
      public Destination(){
            this.name = "Planet Doom";
            this.flight = 1;
            this.schedule = "1.00AM";
            this.gate = "H311";
            this.remark = "on time";
      }
      
      public Destination(String name,int flight,String schedule,String gate,String remark){
            this.name= name;
            this.flight = flight;
            this.schedule = schedule;
            this.gate = gate;
            this.remark = remark;
      }
      
      public String getName(){
            return name;
      }
      
      public int getFlight(){
            return flight;
      }
      
      public String getSchedule(){
            return schedule;
      }
      
      public String getGate(){
            return gate;
      }
      
      public String getRemark(){
            return remark;
      }
}
