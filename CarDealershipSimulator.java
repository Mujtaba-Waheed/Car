//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################
//#####################################################
//IMPORTING LIBRARIES
//#####################################################
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
//#####################################################
//CLASS BEGINS
//#####################################################
public class CarDealershipSimulator {
    public static void main(String[] args) { 
    	//CREATS THE OBJECT
        CarDealership ShopCar = new CarDealership();  
        //INITIALIZE EMPPTY LSIT
        ArrayList<Car> cars = new ArrayList<Car>();
        try 
        {
            cars = read("cars"); //TEXT FILE
        } 

        catch (FileNotFoundException e) 
        {
            System.out.println("File Unavailable.");
        }
        catch(InputMismatchException p) 
        {
            System.out.println("CHECK INPUT FILE");
        }

        String COMMAND = " ";
        Scanner insert = new Scanner(System.in);
        while (!COMMAND.equals("Q")) {
        	COMMAND = insert.nextLine();
            String[] command1 = COMMAND.split(" ");
            try {
            if(command1[0].equalsIgnoreCase("RET") && (command1.length == 2))
            {
                String command2 = command1[1];
                Scanner check = new Scanner (command2);
                int transID = 0;
                try {
                    if(check.hasNextInt())
                    {
                        transID = check.nextInt();
                        ShopCar.returnCar(transID);
                    }
                    else 
                    {   
                        System.out.println("INVALID INPUT");
                    }
                } catch (NullPointerException e) 
                {
                    System.out.println(e.getMessage());
                }
                check.close();
            }
          //#####################################################
          //DISPLAYS INVENTORY
          //#####################################################
            else if (command1[0].equalsIgnoreCase("L")) {
            	ShopCar.displayInventory();
            	//#####################################################
            	//ADDS CAR
            	//#####################################################
            } else if (command1[0].equalsIgnoreCase("ADD")) {
            	ShopCar.addCars(cars);
            	//#####################################################
            	//QUITS THE PROGRAM
            	//#####################################################
            } else if (command1[0].equalsIgnoreCase("Q")) {
                return;
            }  
            else if (command1[0].equalsIgnoreCase("BUY") && (command1.length == 2)) {
                int VIN = 0;
                Scanner check = new Scanner(command1[1]);
                if(!check.hasNextInt())
                {
                    System.out.println("VIN NOT VALID");
                }
                else 
                {
                    try
                    {
                        VIN = Integer.parseInt(command1[1]);
                        System.out.println(ShopCar.buyCar(VIN));
                    }
                    catch(IllegalArgumentException A)
                    {
                        System.out.println(A.getMessage());
                    }
                    catch(IndexOutOfBoundsException A)
                    {
                        System.out.println(A.getMessage());
                    } 
                } 
                check.close();
            } 
          //#####################################################
          //FILTERS BY ELECTRIC COMMAND
          //#####################################################
            else if (command1[0].equalsIgnoreCase("FEL")) {
            	ShopCar.filterByElectric();
            } 
          //#####################################################
          //FILTERS CLEAR COMMAND
          //#####################################################
            else if (command1[0].equalsIgnoreCase("FCL")) {
            	ShopCar.filterClear();
            }
          //#####################################################
          //SORT BY MAX RANGE COMMAND
          //#####################################################
            else if (command1[0].equalsIgnoreCase("SMR")) {
                ShopCar.sortByMaxRange();
            } 
          //#####################################################
          //SORT BY SAFETY RANGE COMMAND
          //#####################################################
            else if (command1[0].equalsIgnoreCase("SSR")) {
                ShopCar.sortBySafetyRating();
            } 
          //#####################################################
          //SORT BY PRICE COMMAND
          //#####################################################
            else if (command1[0].equalsIgnoreCase("SPR")) {
            	ShopCar.sortByPrice();
            } 
          //#####################################################
          //GETS SALES STATISTICS COMMAND
          //#####################################################
            else if(command1[0].equalsIgnoreCase("SALES") && command1[1].equalsIgnoreCase("STATS"))
            {
                System.out.println(ShopCar.account.getSalesStats()); 
            }
          //#####################################################
          //GETS TOP SALESMAN COMMAND
          //#####################################################
            else if(command1[0].equalsIgnoreCase("SALES") && command1[1].equalsIgnoreCase("TOPSP"))
            {
            	ShopCar.account.HigestSaleName(); 
            }
          //#####################################################
          //DISPLAYS ALL SALESMAN NAMES
          //#####################################################
            else if(command1[0].equalsIgnoreCase("SALES") && command1[1].equalsIgnoreCase("TEAM"))
            {
                System.out.println(ShopCar.Team.displayAll()); 
            }
            else if(command1[0].equalsIgnoreCase("SALES") && (command1.length == 1))
            {
            	ShopCar.account.displayAll();
            }
        
            else if(command1[0].equalsIgnoreCase("SALES") && (command1.length == 2))
            {
                String line = command1[1];
                Scanner check = new Scanner(line);
                if(check.hasNextInt())
                {
                    int M = check.nextInt();
                    if(M >= 0 && M < 12)
                    {
                        ShopCar.account.transInmonth(M);
                    }
                    else 
                    {
                        System.out.println("MONTH IS INVALID");
                    }
                }
                else 
                {
                    System.out.println("INPUT IS INVALID");
                }
                check.close();
            }
          //#####################################################
          //FILTERS BY AWD COMMAND
          //#####################################################
            else if (command1[0].equalsIgnoreCase("FAW")) {
                ShopCar.filterByAWD();
            } else if (command1[0].equalsIgnoreCase("FPR") && (command1.length == 3)) {
                double maxPrice = Double.parseDouble(command1[2]);
                double minPrice = Double.parseDouble(command1[1]);
                if (minPrice < maxPrice && maxPrice > minPrice
                        && !(minPrice == maxPrice && minPrice > 0 && maxPrice > 0)) {
                    ShopCar.filterByPrice(minPrice, maxPrice);
                } else {
                    System.out.println("PRICE RANGE IS INVALID");
                }

            } 
            else if(command1.length == 0)
                {
                    System.out.println("INVALID COMMAND. PLEASE TYPE IN A VALID COMMAND.");
                }
            else {
                System.out.println("INVALID ARGUMENT. TRY AGAIN!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("COMMAND NOT PRODUCED. PLEASE TRY AGAIN");
        }
        }
    }

  //#####################################################
  //READS THE TEXT FILE AND THROWS EXCEPTIONS ACCORDINGLY
  //#####################################################
    public static ArrayList<Car> read(String filename) throws  InputMismatchException, FileNotFoundException
    {
      Scanner file =new Scanner(new File(filename));
   	  ArrayList<Car> cars=new ArrayList<Car>();
   	  while(file.hasNextLine())
   	  {
   		  String [] array=file.nextLine().split("\\s+");
   		  if (array.length==9)
   		  {
   			  cars.add(new Car(array[0],array[1],Car.MODELS.valueOf(array[2]),Vehicle.POWERS.valueOf(array[3]),Double.valueOf(array[4]),
   					  Integer.valueOf(array[5]),Boolean.valueOf(array[6]),Integer.valueOf(array[7]),Integer.valueOf(8)));
   		  }
   		  else if (array.length==11)
   		  {
   			  cars.add(new ElectricCar(array[0],array[1],Car.MODELS.valueOf(array[2]),Vehicle.POWERS.valueOf(array[3]),Double.valueOf(array[4]),
   					  Integer.valueOf(array[5]),Boolean.valueOf(array[6]),Integer.valueOf(array[7]),Integer.valueOf(8),array[9],Integer.valueOf(10)));
   		  }
   	  }
   	  file.close();
      return cars;
    }
}