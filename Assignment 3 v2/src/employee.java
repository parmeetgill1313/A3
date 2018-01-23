
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

/* **********************************************************
 * Programmer:   Parmeet Gill
 * Class:       CS30S
 * 
 * Assignment:	A3 Employee Payroll
 *
 * Description:	calculates pay from  hours and wage, returns data for employee, 
 *              creates unique id for employee
 * *************************************************************
*/

 public class employee
 {  // begin class
 	
 	// *********** class constants **********
 	
            private final double OT = 1.5; //;Overtime pay modifier for employees with overtime
            private final int NormalpayHours = 40; //int for normal paid hours (40 hours)
            
 	// ********** instance variable **********
            
            private static int nextID = 1000;   //static int for next employee
            private int employee = 0;           //employee
            private double wage = 0;            //wage
            private int hours = 0;              //hours
            private double OTpay = 0;           //overtime pay
            private double pay = 0;             //normal pay for under 40 hours
          
            //BufferedReader fin = new BufferedReader(new FileReader("employeeData.txt"));
 	// ********** constructors ***********
            
            /********************************************************
            * Purpose:        Default constructor with no wage or 
            *                 hours, just the ID
            *         
            * Interface:
            *     in:         None
            *     out:        None
            ********************************************************/
            public employee () {
                employee = nextID++;
            }//end default constructor
            
            /********************************************************
            * Purpose:        provides wage and hours
            *         
            * Interface:
            *     in:         Wage and hours of the employee
            *     out:        None
        ********************************************************/
            public employee (int h, double w) {
                employee = nextID++;
                wage = w;  //wage
                hours = h; //hours
            }//end initialized constructor
            
 	// ********** accessors **********
            
            /********************************************************
            * Purpose:        Return ID of employee
            *         
            * Interface:
            *     in:         None
            *     out:        ID
            ********************************************************/
            public int getEmployee () {
                return employee;
            }//end getID
            
            /********************************************************
            * Purpose:        Return wage of employee
            *         
            * Interface:
            *     in:         None
            *     out:        wage
            ********************************************************/
            public double getWage() {
                return wage;
            }//end getWage
            
            /********************************************************
            * Purpose:        Return hours of employee
            *         
            * Interface:
            *     in:         None
            *     out:        hours
            ********************************************************/
            public int getHours() {
                return hours;
            }//end getHours
            
            /********************************************************
            * Purpose:        Returns total pay for the employees
            *         
            * Interface:
            *     in:         None
            *     out:        total pay
            ********************************************************/
            public double pay () {
                
               double totPay;   //total pay
               int OThours = 0; //OT hours
                
                if (hours > NormalpayHours) { //if statement for employees who have  worked overtime
                    OThours = hours - NormalpayHours; //OT hours calculation
                    OTpay = OThours * (wage * OT); //OT pay Calculation
                    pay = (hours - OThours) * wage; //normal pay calculation
                    totPay = pay + OTpay; //total pay calculation
                }//end if
                else { //else statement for employees who have not worked overtime
                    pay = hours * wage; //pay calculator
                    totPay = pay;       //tells pay
                }//end else
                return totPay; //return pay
            }//end pay
            
            /********************************************************
            * Purpose:   Return OT pay for employee
            *         
            * Interface:
            * in:         None
            * out:        Overtime pay
            ********************************************************/
            public double getOTPay () {
                double otPay = 0; //OT pay
                int otHours = hours - NormalpayHours; //OT hours calculation
                otPay = otHours * (wage * OT); //OT pay calculation
                return otPay; //returns OT pay
            }//end getOTPay
            
            /********************************************************
            * Purpose:        Return normal pay of employee
            *         
            * Interface:
            *     in:         None
            *     out:        Normal pay
            ********************************************************/
            public double getNormHourPay () {
                int normalHours = 0; 
                int OThours = hours - NormalpayHours; 
                normalHours = hours - OThours; 
                pay = normalHours * wage; //calculates normal hour pay / no OT
                
                return pay; //return normal pay
            }//end getNormHourPay
            
            /********************************************************
            * Purpose:        Override toString() function and return
            *                 employee's id, hours, wage, pay, 
            *                 OT pay, and total pay
            *         
            * Interface:
            *     in:         None
            *     out:        Data string
            ********************************************************/
            public String toString(){
                String info = ""; //employee data to be outputted
                
                DecimalFormat df = new DecimalFormat("###.##"); //decimal format
                
                info = ("Employee: " + (this.getEmployee()) + "\t");
                info += ("Hours: " + this.getHours() + "\t");
                info += ("Wage: $" + this.getWage() + "\t");
                info += ("Normal Hour Pay: $" + df.format(this.getNormHourPay()) + "\t");
                info += ("Overtime Pay: $" + df.format(this.getOTPay()) + "\t");
                info += ("Total Pay: $" + df.format(this.pay()) + "\t");

                return info; //return data
            }//end toString
            
 	// ********** mutators **********
 
 }  // end class