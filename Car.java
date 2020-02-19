//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################
//#####################################################
//IMPORTING LIBRARIES
//#####################################################
import java.util.Comparator;
//#####################################################
//CLASS BEGINS - this is super class of class vehicle
//#####################################################
public class Car extends Vehicle implements Comparable <Car>
{
	//#####################################################
	//SETTING UP ENUM 
	//#####################################################
	  public static enum MODELS
	    {
	        SEDAN,SUV,SPORTS,MINIVAN;
	    }
	//#####################################################
	//Initializing instant variables
	//#####################################################
	public MODELS model; 
	public int maxRange; 
	public double safetyRating; 
	public boolean AWD; 
	public double price; 

	//#####################################################
	//INITIALIZING CONSTRUCTOR
	//#####################################################
	public Car(String mfr, String color, MODELS model,  POWERS power, double safetyRating, int maxRange, boolean AWD, double price, int numWheels) {
		super(mfr, color, power, numWheels); //super call for the Vehicle constructor method 
		this.safetyRating = safetyRating;
		this.maxRange = maxRange;
		this.AWD = AWD;
		this.price = price;
		this.model=model;
	}



	//#####################################################
	//DISPLAYS CAR INFO - INFO FROM SUPER CLASS - MODEL TYPE - PRICE - SAFETY - MAX RANGE
	//#####################################################
	public String display() {
		return super.display() + " " + model.name() + " " + price + "$ SF: " + safetyRating + " RNG:" + maxRange; 
	}

	//#####################################################
	//THIS METHOD RETURNS THE PRICE
	//#####################################################
	public double getPrice() {
		return price;
	}

	//#####################################################
	//THIS METHOD RETURNS FOR ALL WHEEL DRIVE
	//#####################################################
	public boolean getAWD() {
		return AWD;
	}

	//#####################################################
	//THIS METHOD RETURNS SAFETY RATING
	//#####################################################
	public double getSafetyRating() {
		return safetyRating;
	}

	//#####################################################
	//THIS METHOD RETURNS MAXIMUM RANGE
	//#####################################################
	public int getMaxRange() {
		return maxRange;
	}
	//#####################################################
	//COMPARE TO INTERFACE TO COMPARE PRICES OF TWO CARS
	//#####################################################
	public int compareTo(Car other) {
		if (price < other.price) {return -1;} 
		if (price > other.price) {return 1;}
		return 0;
	}
	//#####################################################
	//CHECKS IF THIS VEHICLE IS SAME TO OTHER VEHICLE BASED ON "MODEL" AND "AWD"
	//#####################################################
	public boolean equals(Object other) {
		Car car2 = (Car) other;
		if (super.equals(car2)) {
			if (this.model == car2.model && AWD == (car2.AWD)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	//#####################################################
	//THIS METHOD COMPARES SAFETY RATING OF CARS A AND B
	//#####################################################
	class CarSafetyRatingComparator implements Comparator<Car>
	{
		public int compare(Car a, Car b)
		{
			if (a.getSafetyRating() < b.getSafetyRating()) {return 1;}
			if (a.getSafetyRating() > b.getSafetyRating()) {return  -1;}
			else {return 0;}
		}
	}
	//#####################################################
	//THIS METHOD COMPARES MAX RANGE OF CARS A AND B
	//#####################################################
	class CarMaxRangeComparator implements Comparator<Car>
	{
		public int compare(Car a, Car b)
		{
			if (a.getMaxRange() < b.getMaxRange()) {
				return 1;}
			if (a.getMaxRange() > b.getMaxRange()) {
				return  -1;}
			else {
				return 0;}
		}
	}
}