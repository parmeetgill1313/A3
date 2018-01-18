/* **********************************************************
 * Programmer:	Rob Sveinson
 * Class:		CS20S
 * 
 * Assignment:	aX  qY
 *
 * Description:	describe the class you are creating
 *
 * 
 * *************************************************************
 */
 
 // import files here as needed
 
 
 public class employee
 {  // begin class
 	
 	// *********** class constants **********
 	
            private static int nextID = 1000; //id of next circle instatiated 
            private final double OTpayMOD = 1.5; 
            private final int NormalHours = 40; 
            
 	// ********** instance variable **********
 	
            private int id = 0;
            private double wage = 0;
            private int hours = 0;

            
 	// ********** constructors ***********
 	
            /********************************************************
            * Purpose:        create a new employee with default
            *                 properties 
            * Interface:
            *     in:         none
            *     out:        none
            ********************************************************/
            public employee(){
                id = nextID++;  //set id and increment next id
                wage = 0;
            }//end default constructor
            
            /********************************************************
            * Purpose:        create a new circle with default
            *                 properties 
            * Interface:
            *     in:         none
            *     out:        none
            ********************************************************/
            public employee(double w, int h){
                id = nextID++; //set id and increment next id
                wage = w;
                hours = h;
                System.out.println("ID: " + id + ", Waqe: " + wage + ", Hours: " + hours);
            }//end initiallized constructor
 
 	// ********** accessors **********
 	
            /********************************************************
            * Purpose:        get the radius of the circle 
            * Interface:
            *     in:         none 
            *     out:        radius
             ********************************************************/
            private double getWage(){
                 return wage;
             } // end getWage()
            
            /********************************************************
            * Purpose:        get the radius of the circle 
            * Interface:
            *     in:         none 
            *     out:        radius
            ********************************************************/
            private double getHours(){
                 return hours;
             } // end gethours()
            
            /********************************************************
            * Purpose:        get the radius of the circle 
            * Interface:
            *     in:         none 
            *     out:        radius
            ********************************************************/
            private double totPay(){
                
                double pay = 0;
                double OTpay = 0;
                double OThours = 0;
                double totPay = 0;
            
                if(hours > NormalHours){
                    OThours = (hours - NormalHours);
                    OTpay = OThours * (wage * OTpayMOD);
                    pay =+ (hours - OThours) * wage;
                }//end if
                else{
                    totPay = hours * wage;
                }//end else
                 return hours;
             } // end totPay()
            
            /********************************************************
            * Purpose:        get the radius of the circle 
            * Interface:
            *     in:         none 
            *     out:        radius
            ********************************************************/
            public double toString(int r){
                 System.out.println(this.totPay());
                 return r;
             } // end toString()
            
 	// ********** mutators **********
 
 }  // end class