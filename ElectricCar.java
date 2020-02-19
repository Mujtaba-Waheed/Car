//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################
//#####################################################
//CLASS BEGINS
//#####################################################
public class ElectricCar extends Car {
	//#####################################################
	//INITIALIZING INSTANT VARIABLES
	//#####################################################
    private int rechargeTime; 
    private String batteryType; 
  //#####################################################
  //SETTING UP CONSTRUCTORS WITH ALL THE VARIABLES
  //#####################################################
    public ElectricCar(String mfr, String color,  MODELS model, POWERS power,  double safetyRating, int maxRange, boolean AWD, double price, int rechargeTime, String batteryType, int numWheels) {
        super(mfr, color, model, power, safetyRating, maxRange, AWD, price, numWheels);
        this.rechargeTime = rechargeTime;
        this.batteryType = batteryType;
    }
    //#####################################################
    //THIS METHOD SETS THE BATTERY TYPE
    //#####################################################
      public void setBatteryType(String batteryType) {
          this.batteryType = batteryType;
      }
    //#####################################################
    //THIS METHOD GETS THE BATTERY TYPE
    //#####################################################
    public String getBatteryType() {
        return batteryType;
    }
    //#####################################################
    //THIS METHOD SETS THE RECHARGE TYPE
    //#####################################################
    public void setRechargeTime(int rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    //#####################################################
    //THIS METHOD GETS THE BATTERY TYPE
    //#####################################################
    public int getRechargeTime() {
        return rechargeTime;
    }

    //#####################################################
    //THIS METHOD SHOWS THE DISPLAY HOLDING ALL THE INSTANT VARIABLES
    //#####################################################
    public String display() {
        return super.display() + " EL, BAT: " + batteryType + " RCH " + rechargeTime;
    }
}