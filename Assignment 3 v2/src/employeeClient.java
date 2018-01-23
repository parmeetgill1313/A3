/********************************************************************
 * Programmer:      P. Gill
 * Class:           CS30S
 *
 * Assignment:      A3 Employee Payroll
 *
 * Description:     Employee Payroll
 *
 * Input:          Hours and Wage from the file
 *
 * Output:         employee ID, hours, wage, normal pay hours, OT pay 
 *                 and gross pay for every employee from the file
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 			// import file io libraries
import java.util.ArrayList;
 

public class employeeClient {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
    
    // ********** declaration of variables **********
    	
    	String delim = "[ ]+";		// delimiter string for splitting input string
        String strin = "";      //input variable
        String input[] = null;  //array for splitting input
        double wage = 0;        //variable for wage
        int hours = 0;          //variable for hours
    	
    // create instances of objects for i/o and formatting
    
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("employeeData.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        
        ProgramInfo programInfo = new ProgramInfo("Assignment 3: Employee Payroll");
        DecimalFormat df = new DecimalFormat("###.##"); 
        
        ArrayList<employee> employees = new ArrayList<employee>();
    	
    // ********** Print output Banner **********
    
    	System.out.println(programInfo.toString()); //outputs program info
        fout.println(programInfo.toString());
        //outputs the program info for the output file
    	
    // ************************ get input **********************
    
        strin = fin.readLine(); //read in first line from employee data file
        
        while (strin != null) { 
        //while loop for reading in data and creating new 
        //employees from the data file
            input = strin.split(delim); //splits input
            hours = Integer.parseInt(input[0]); //parses input for hours
            wage = Double.parseDouble(input[1]); //parses input for wage
            employees.add(new employee(hours, wage)); //adds employee to array list
            strin = fin.readLine(); //reads in next line from the data file
        }//end while
            
    // ************************ processing ***************************
    
        //N/A
        
    // ************************ print output ****************************
    
        System.out.println("\nThere are " + employees.size() + " employees."); 
        fout.println("\nThere are " + employees.size() + " employees."); 

            //outputs the number of employees 
        
        for(employee i: employees) //output data for each employee
            System.out.println(i);
        
        System.out.println("\nEmployee 1's ID is: " + employees.get(0).getEmployee());
        System.out.println("Employee 2's normal pay is: $" + df.format(employees.get(1).getNormHourPay()));
        System.out.println("Employee 3's overtime pay is: $" + df.format(employees.get(2).getOTPay()));
        System.out.println("Employee 4's gross pay is: $" + df.format(employees.get(3).pay()));
        System.out.println("Employee 5's hours are: " + employees.get(4).getHours() + "\n");
        
        fout.println("\nEmployee 1's ID is: " + employees.get(0).getEmployee());
        fout.println("Employee 2's normal pay is: $" + df.format(employees.get(1).getNormHourPay()));
        fout.println("Employee 3's overtime pay is: $" + df.format(employees.get(2).getOTPay()));
        fout.println("Employee 4's gross pay is: $" + df.format(employees.get(3).pay()));
        fout.println("Employee 5's hours are: " + employees.get(4).getHours() + "\n");
    
        // ******** closing message *********
        
        System.out.println(programInfo.eoFile());
        fout.println("End Of Processing!");
        
        // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
}  // end class

