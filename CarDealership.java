//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################
//#####################################################
//IMPORTING LIBRARIES
//#####################################################
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//#####################################################
//CLASS BEGINS
//#####################################################
public class CarDealership {
	//#####################################################
	//SETTING UP INSTANCE VAIABLES
	//#####################################################
	private ArrayList<Car> cars; 
	private boolean PRICE_FILTER;
	private boolean ELECTRIC_FILTER; 
	private boolean AWD_FILTER;
	private double maxPrice;
	private double minPrice;
	Random random1 = new Random();
	SalesTeam Team = new SalesTeam(); 
	AccountingSystem account = new AccountingSystem();

	//#####################################################
	//INITIALIZING CONSTRUCTOR
	//#####################################################   
	public CarDealership() {
		cars = new ArrayList<Car>();
	}
	//#####################################################
	//ADDs METHOD - ADD CARS INTO THE ARRAY LIST
	//#####################################################
	public void addCars(ArrayList<Car> newCars) {
		cars.addAll(newCars);
	}

	//#####################################################
	//BUY METHODS - BUYING CARS USING VIN - IF ALREADY BOUGHT - EXCEPTION THROWN
	//#####################################################
	public String buyCar(int VIN) 
	{
		if(cars.size() == 0) {
			throw new IndexOutOfBoundsException("THE LIST IS EMPTY");
		}

		boolean achieved = false; //to check if Car with the certain VIN is found
		Car CarBought = null;
		for(int i = 0; i < cars.size(); i++){
			Car car = cars.get(i);
			if(car.getVIN() == VIN){
				CarBought = car;
				achieved = true;
				cars.remove(i);
			}
		}
		if(!achieved) {
			throw new IllegalArgumentException("VIN UNAVAILABLE"); 
		}
		String person = Team.getRandomName();
		int day = random1.nextInt(31) + 1, month = random1.nextInt(11); 
		Calendar date = new GregorianCalendar(2019, month, day);
		return account.add(date, CarBought, person, "BUY", CarBought.getPrice()); 

	}
	//#####################################################
	//RETURN METHOD - links ID to PURCHASED CAR
	//#####################################################

	public void returnCar(int transaction)
	{
		Transaction TransPurchased = account.getTrans(transaction);
		if(TransPurchased != null)//
		{
			Car car = TransPurchased.getCar();
			int month = TransPurchased.getDate().get(Calendar.MONTH);
			int day = TransPurchased.getDate().get(Calendar.DAY_OF_MONTH);
			int newDin = 0, up = 28 - day;
			if(up >= 0)
			{
				newDin = day + up;
			}
			else 
			{
				newDin = day;
			}
			Calendar date = new GregorianCalendar(2019, month, newDin);
			System.out.println(account.add(date, car, TransPurchased.getSalesPerson(), "RET", TransPurchased.getPrice()));
			cars.add(car);
		}
		else 
		{
			throw new NullPointerException("ID NOT FOUND");
		}
	}
	//#####################################################
	//SET METHOD - CLEAR FILTER
	//#####################################################

	public void filterClear(){
		this.PRICE_FILTER = false;
		this.AWD_FILTER = false;
		this.ELECTRIC_FILTER = false;
	}
	//#####################################################
	//SET METHOD - SET ELECTRIC FILTER
	//#####################################################
	public void filterByElectric() {
		this.ELECTRIC_FILTER = true;
	}
	//#####################################################
	//SET METHOD - SETS FILTER BY PRICE
	//#####################################################

	public void filterByPrice(double minPrice, double maxPrice) {
		this.PRICE_FILTER = true;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
	}
	//#####################################################
	//SET METHOD - SETS AWD FILTER
	//#####################################################
	public void filterByAWD() {
		this.AWD_FILTER = true;
	}
	//#####################################################
	//SORTS LIST BY PRICE
	//#####################################################
	public void sortByPrice() {
		Collections.sort(cars);
	}

	//#####################################################
	//DISPLAY INVENTORY
	//##################################################### 
    public void displayInventory()
    {
  	  System.out.println("");
  	  
  	  for (int i = 0; i < cars.size(); i++)
  	  {
  		Car car = cars.get(i);
  		
  		if (PRICE_FILTER && (car.price < minPrice || car.price > maxPrice))
  		   continue;
  		
  		if (ELECTRIC_FILTER && car.power != Vehicle.POWERS.ELECTRIC_MOTOR)
  		   continue;
  		
  		if (AWD_FILTER && !car.AWD)
  		   continue;
  		
  		System.out.println(""+ i +" " + car.display());
  	  }
  	  System.out.println("");
    }
	//#####################################################
	//SORTING - SORT BY MAXIMUM RANGE
	//#####################################################
	public void sortByMaxRange()
	{
		Comparator<Car> maxRange=new Comparator<Car>() 
		{
			public int compare(Car car1,Car car2)
			{
				if (car1.maxRange > car2.maxRange )
					return 1;
				else if (car1.maxRange < car2.maxRange)
					return -1;
				else
					return 0;
			}
		};
		Collections.sort(cars,maxRange);
	}
	//#####################################################
	//SORT - SORT BY SAFETY RATING
	//#####################################################
	public void sortBySafetyRating()
	{
		Comparator<Car> safetyRating = new Comparator<Car>()
		{
			public int compare(Car car1,Car car2)
			{
				if (car1.safetyRating > car2.safetyRating )
					return 1;
				else if (car1.safetyRating < car2.safetyRating)
					return -1;
				else
					return 0;
			}
		};
		Collections.sort(cars,safetyRating);
	}
	//#####################################################
	//DISPLAY INVENTORY
	//##################################################### 
    public void displayInventory()
    {
  	  System.out.println("");
  	  
  	  for (int i = 0; i < cars.size(); i++)
  	  {
  		Car car = cars.get(i);
  		
  		if (PRICE_FILTER && (car.price < minPrice || car.price > maxPrice))
  		   continue;
  		
  		if (ELECTRIC_FILTER && car.power != Vehicle.POWERS.ELECTRIC_MOTOR)
  		   continue;
  		
  		if (AWD_FILTER && !car.AWD)
  		   continue;
  		
  		System.out.println(""+ i +" " + car.display());
  	  }
  	  System.out.println("");
    }

}