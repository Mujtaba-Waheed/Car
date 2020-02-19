//#####################################################
//MUJTABA WAHEED - 500900260 - CPS 209 A2             |
//#####################################################
//#####################################################
//IMPORTING LIBRARIES
//#####################################################
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
//#####################################################
//CLASS BEGINS
//#####################################################
public class SalesTeam 
{
	//#####################################################
	//INITIALIZING INSTANT VARIABLES
	//#####################################################
    LinkedList<String> salesName; 
    Random random1;
  //#####################################################
  //SETTING UP THE CONSTRUCTOR - LIST OF RANDOM SALESMAN
  //#####################################################
    public SalesTeam()
    {
    	salesName = new LinkedList<String>();
    	salesName.add("Tony Stark");
    	salesName.add("Steve Rogers");
    	salesName.add("Bruce Banner");
    	salesName.add("Natasha Romenoff");
    	salesName.add("Clint Barton");
    	salesName.add("Thor Odin");
    	salesName.add("Peter Parker");
    	salesName.add("Nick Fury");
        random1 = new Random();
    }
    //#####################################################
    //THIS METHOD RETURNS THE TEAM MEMBER TOTAL
    //#####################################################
    public int TEAM() 
    {
        return salesName.size();
    }
    //#####################################################
    //THIS METHOD DISPLAYS ALL THE MEMBERS IN THE SALES LIST MADE ABOUE
    //#####################################################
    public String displayAll() 
    {
        String PeopleName = "Team: ";
        ListIterator<String> iter = salesName.listIterator();
        for (int i = 0; i < salesName.size(); i++) 
        {
            String element = iter.next();
            PeopleName = PeopleName + element + " ";
        }
        return PeopleName;
    }
    //#####################################################
    //THIS METHOD RETURNS A RANDOM SALES PERSON
    //#####################################################
    public String getRandomName()
    {
        int R = random1.nextInt(6);
        return salesName.get(R);
    }
    //#####################################################
    //THIS METHOD RETURNS A SPECIFIC SALES PERSON
    //#####################################################
    public String getSpecificName(int i) 
    {
        return salesName.get(i);
    }
}