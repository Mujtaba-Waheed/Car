//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################
//#####################################################
//IMPORTING LIBRARIES
//#####################################################
import java.util.Random;
import java.util.Calendar;
import java.text.DateFormatSymbols;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
//#####################################################
//CLASS STARTS        
//#####################################################
public class AccountingSystem
{
	Random random1; 
	private int transID; 
    private Map<Transaction, Integer> transactions; 
    private Set<Transaction> keySet;
    private Map<String, Integer> PersonSale; 
  //#####################################################
  //INITIALIZING CONSTRUCTOR
  //#####################################################
    public AccountingSystem() {
    	//reference variable for random objects
    	random1 = new Random();
    	// Map for transactions
        transactions = new HashMap<Transaction, Integer>(); 
        // keySet for transaction
        keySet = transactions.keySet();
      //reference variable for salesperson map
        PersonSale = new HashMap<String, Integer>();
    }
    //#####################################################
    //RETURNS TRANSACTION IDENTITY
    //#####################################################
    public int gettID() 
    {
        return transID;
    }
    //#####################################################
    //ADD CARS - CREATES ID USING RANDOM
    //#####################################################
    public String add(Calendar date, Car car, String name, String transactionType, double price) 
    {
        transID = random1.nextInt(99) + 1;
        Transaction transaction = new Transaction(date, car, name, transactionType, price, transID);
        if (transactionType.equalsIgnoreCase("BUY")) 
        {
            nameUpdate(name);
        }
    	transactions.put(transaction, transID);
        nameUpdate(name);
        return transaction.display();
        
    }
   
    //#####################################################
    //GIVES HIGHEST EARNING SALES PERSON
    //#####################################################
    public void HigestSaleName()
    {
        if(transactions.size() != 0)
        {
            int mostSold = 0;
            Set<String> keySet = PersonSale.keySet(); 
            for (String key1 : keySet)
            {
                int sold = PersonSale.get(key1);
                if (sold > mostSold)
                {
                    mostSold = sold;
                }
            }
            for (String key1 : keySet)
            {
                int sold = PersonSale.get(key1);
                if (sold == mostSold)
                {
                    System.out.println("Top SalesPerson IS: " + key1 + " " + sold);
                }
            }
        }
        else 
        {
            System.out.println("NO TRANSACTIONS DONE YET.");
        }
    }
    //#####################################################
    //UPDATES THE SALES PERSON
    //#####################################################

    public void nameUpdate(String Name)
    {
        int counter = 0;
        if(PersonSale.containsKey(Name)) 
        {
        	counter = PersonSale.get(Name) + 1;
            PersonSale.put(Name, counter);
        }
        else
        {
            PersonSale.put(Name, 1); 

        }

    }
    //#####################################################
    //THIS DISPLAYS ALL THE TRANSACTIONS
    //#####################################################
      public void displayAll()
      {
          if(transactions.size() != 0)
          {
              for (Transaction key1 : keySet)
              {
                  Transaction transaction = key1;
                  System.out.println(transaction.display());
              }
          }
          else 
          {
              System.out.println("NO TRANSACTIONS TO SHOW");
          }
      }
  //#####################################################
    //RETURNS TRANSACTIONS WHICH IS REQUIRED
    //#####################################################
    public Transaction getTrans(int id) 
    {
        boolean get = false;
        Transaction requiredTrans = null; //initialized
        for (Transaction key1 : keySet)
        {
            int ID = transactions.get(key1);
            if (id == ID) 
            {
                requiredTrans = key1;
                get = true;
            }
        }
        if(!get)
        {
            return null;
        }
        else 
        {
            return requiredTrans;
        }
    }

    //#####################################################
    //SHOWS THE TOTAL TRANSACTION IN A MONTH
    //#####################################################
    public int getMonthlyTotal(int M)
    {
        int sold = 0;
        for(Transaction key : keySet)
        {
            Transaction T = key;
            int month = T.getDate().get(Calendar.MONTH);
            if(month == M && (T.getTransactionType().equalsIgnoreCase("BUY")))
            {
                sold++;
            }
        }
        return sold;
    }
  //#####################################################
    //SHOWS ALL THE TRANSACTIONS DONE IN A MONTH
    //#####################################################
    public void transInmonth(int M)
    {
        boolean watch = false;
        for(Transaction key1 : keySet)
        {
            Transaction T = key1;
            int month = T.getDate().get(Calendar.MONTH);
            if(month == M)
            {
                System.out.println(T.display());
                watch = true;
            }
        }
        if(!watch)
        {
            System.out.println("NO TRANSACTIONS WERE MADE IN THIS MONTH");
        }
    }
    //#####################################################
    //RETURNS THE MONTH WITH MOST BUSINESS DONEE
    //#####################################################
    public String getBestMonth()
    {
        double mostSold = 0; 
        String busyMonth = "";
        for (int i = 0; i < 12; i++)
        {
            double totalSold = getMonthlyTotal(i);
            if (totalSold > mostSold)
            {
                mostSold = totalSold;
                busyMonth = getMonth(i);
                if(busyMonth == null)
                {
                    return "Month not found or exist";
                }
            }
        }
        return "Month with most business " + busyMonth + ": - " + mostSold;

    }
  //#####################################################
    //THIS METHOD RETURNS THE MONTH WHICH IS LINKED WITH THE INT J
    //#####################################################
    public String getMonth(int j) {
        if(j >= 0 && j < 12)
        {
            return new DateFormatSymbols().getMonths()[j];
        }
        else 
        {
            return null;
        }
    }
    //#####################################################
    //THIS METHOD RETUNS SALES STATISTICS - BEST MONTH AND SALES INFORMATION
    //#####################################################
    public String getSalesStats()
    {
        if(transactions.size() != 0){
            return getSalesInfo() + " " + getBestMonth();
        }
        else{
            return "There have been no transactions yet.";
        }
    }
    //#####################################################
    //THIS MOTHOD GETS THE SALES INFORMATION
    //#####################################################
    public String getSalesInfo()
    {
        double total = 0;
        int sold = 0, returned = 0;
        for (Transaction key1 : keySet)
        {
            Transaction transaction = key1;
            if(transaction.getTransactionType().equalsIgnoreCase("BUY")) {
            	total += transaction.getPrice();
            	sold++;
            }
            else {
            	returned++;
            }
        }
        double avg = total / 12;
        return "Total sales: " + total + " Total sold: " + sold + " Average sale: " + avg + 
        " Total returned: " + returned;
    }

    //#####################################################
    //CLASS ENDS
    //#####################################################
}
