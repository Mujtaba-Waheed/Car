//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################
//#####################################################
//IMPORTING LIBRARIES
//#####################################################
import java.text.SimpleDateFormat;
import java.util.Calendar;
//#####################################################
//CLASS BEGINS
//#####################################################
public class Transaction 
{
	//#####################################################
	//INSTANCE VARIABLES
	//#####################################################
	private int id; 
    private Calendar date; 
    private Car car; 
    private String salesName; 
    private String TransactionType; 
    private double price; 
  //#####################################################
  //SETTING UP CONSTRUCTOR - INITIALIZING INSTANCE VARIABLES
  //#####################################################
    public Transaction(Calendar date, Car car, String name, String TransactionType, double price, int ID) {
        this.date = date;
        this.setCar(car);
        this.salesName = name;
        this.TransactionType = TransactionType;
        this.setSalesPrice(price);
        this.id = ID;
    }
    //#####################################################
    //THIS METHOD DISPAYS ID, DATE, TYPE, SALESMAN, AND CAR SPECS
    //#####################################################
    public String display() 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        return  ("ID: " + id + " " + sdf.format(date.getTime()) + " " + TransactionType + " Salesperson: " + salesName + " Car: " + car.display());
    }
 
    //#####################################################
    //THIS METHOD SETS THE SALE PRICE
    //#####################################################
    public void setSalesPrice(double price) {
        this.price = price;
    }
    //#####################################################
    //THIS METHOD RETURNS THE SALES PRICE
    //#####################################################
    public double getPrice() {
        return price;
    }
    //#####################################################
    //THIS METHOD SETS THE CAR
    //#####################################################
    public void setCar(Car car) {
        this.car = car;
    }
    //#####################################################
    //THIS METHOD RETURNS THE CAR
    //#####################################################
    public Car getCar() {
        return car;
    }
    //#####################################################
    //THIS METHOD RETURNS THE DATE
    //#####################################################
    public Calendar getDate() {
        return date;
    }
    //#####################################################
    //THIS METHOD RETUNS TRANSACTION TYPE
    //#####################################################
      public String getTransactionType() {
          return TransactionType;
      }
    //#####################################################
    //THIS METHOD RETURNS THE IDENTIFICATION
    //#####################################################
    public int getID() {
        return id;
    }
    //#####################################################
    //THIS METHOD RETURNS SALES PERSON
    //#####################################################
    public String getSalesPerson() {
        return salesName;
    }
}