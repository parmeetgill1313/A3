
/** ******************************************************************
 * Programmer:	sveinson
 * Class:  CS20S
 *
 * Assignment: Ax Qy
 * Program Name:  name of public class
 *
 * Description: brief description of program
 *
 * Input: data to be input
 *
 * Output: results to be output
 ********************************************************************** */
// import java libraries here as needed
import javax.swing.*;
import java.text.DecimalFormat;
import java.io.*; 					// import file io libraries

public class employeeClient {  // begin class

    public static void main(String[] args) throws IOException {  // begin main

        // ********* declaration of constants **********

        final double OVERTIME = 1.5;

        // ********** declaration of variables **********

        String strin;			// string data input from keyboard
        String strout;			// processed info string to be output
        String bannerOut;		// string to print banner to message dialogs
        String prompt;			// prompt for use in input dialogs
        String delim = "[ ]+";		// delimiter string for splitting input string
        
        String list[] = null;
        
        double wage;
        int hours;
        
        //******************Create Ojects*************
        
        //ConsoleReader console = new ConsoleReader(System.in);
        //DecimalFormat df = new DecimalFormat("00.00");
        BufferedReader fin = new BufferedReader(new FileReader("input.txt"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        ProgramInfo programInfo3 = new ProgramInfo(" A3" + "Q1");
        
        // ********** Print output Banner **********
        
        System.out.println(programInfo3.toString());
        fileBanner(fout);

        // ************************ get input **********************
            
        strin = fin.readLine();
        while(strin != null){
            list = strin.split(delim);
            
            wage = Double.parseDouble(list[1]);
            hours = Integer.parseInt(list[0]);
            
            employee Employee = new employee(wage, hours );
            
            strin = fin.readLine();
        }
        
        // ************************ processing ***************************

        
        
        // ************************ print output ****************************
        
        // ******** closing message *********
        
        System.out.println("end of processing");
        fout.format("%n%nend of processing.");

        // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer

    }  // end main

    //************************************************
    // Purpose: print an output banner to the output file
    // Interface: IN: PrintWriter
    // Returns: none
    // *****************************************************
    public static void fileBanner(PrintWriter fo) {
        fo.println("*******************************************");
        fo.println("Name:		Parmeet Gill");
        fo.println("Class:		CS30S");
        fo.println("Assignment:         Assignment 3 Q1");
        fo.println("*******************************************");
    } // end fileBanner
}  // end class
