//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################

//#####################################################
//CLASS BEGINS
//#####################################################
public class Vehicle {
	//#####################################################
	//SETTING UP ENUM 
	//#####################################################
	public static enum POWERS
	{
		GAS_ENGINE,DIESEL_ENGINE,ELECTRIC_MOTOR;
	}
	//#####################################################
	//INSTANCE VARIABLES
	//#####################################################
	private String mfr; 
	private String color; 
	public POWERS power; 
	public int numWheels; 
	public int VIN=(int)(Math.random() * (499 - 100 + 1)) + 100;
	//#####################################################
	//INITIALIZING THE CONSTRUCTOR - INSTANCE VARIABLES
	//#####################################################
	public Vehicle(String mfr, String color, POWERS power, int numWheels) {
		this.mfr = mfr;
		this.color = color;
		this.power = power;
		this.numWheels = numWheels;

	}
	//#####################################################
	//THIS METHOD DISPLAYS VIN, MFR AND COLOR
	//#####################################################
	public String display() {
		return "VIN: " + VIN + " " + mfr + " " + color;
	}
	//#####################################################
	//THIS METHOD RETURNS THE VIN NUMBER
	//#####################################################
	public int getVIN() {
		return VIN;
	}
	//#####################################################
	//THIS METHOD RETURNS THE POWER
	//#####################################################
	public POWERS getPower() {
		return power;
	}
	//#####################################################
	//SET METHOD - SETS THE POWER
	//#####################################################
	public void setPower(POWERS power) {
		this.power = power;
	}
	//#####################################################
	//THIS METHOD RETURNS THE NUMBER OF WHEELS
	//#####################################################
	public int getNumWheels() {
		return numWheels;
	}
	//#####################################################
	//SET METHOD - SETS THE NUMBER OF WHEELS
	//#####################################################
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}

	//#####################################################
	//SET METHOD - SETS THE MANUFACTURER
	//#####################################################
	public void setMfr(String mfr) {
		this.mfr = mfr;
	}
	//#####################################################
	//THIS METHOD RETURNS THE MANUFACTURER
	//#####################################################
	public String getMfr() {
		return mfr;
	}
	//#####################################################
	//SET METHOD - SETS THE COLOR
	//#####################################################
	public void setColor(String color) {
		this.color = color;
	}
	//#####################################################
	//THIS METHOD RETURNS THE COLOR
	//#####################################################
	public String getColor() {
		return color;
	}
	//#####################################################
	//THIS METHOD COMPARES THIS VEHICLE TO OTHER VEHICLE - USING MFR, COLOR, NUMWHEELS AND VIN
	//#####################################################
	public boolean equals(Object other) {
		if (other != null) {
			Vehicle otherVehicle = (Vehicle) other;
			if (mfr.equals(otherVehicle.mfr) && color.equals(otherVehicle.color) && numWheels == otherVehicle.numWheels && VIN == otherVehicle.VIN){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}

}