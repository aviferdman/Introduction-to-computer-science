// You may not change or erase any of the lines and comments 
// in this file. You may only add lines in the designated 
// area.

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args){
 

            // ----------------- "A": write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int a1 = myScanner.nextInt(); 
			int b1 = myScanner.nextInt();
			int c1 = myScanner.nextInt(); 
			int d1 = myScanner.nextInt();
			int e1 = myScanner.nextInt();
			//check for the max number and save it in a1 and the min save in e1
			 if (b1>a1) {
				 int tmp = a1;
				 a1 = b1;
				 b1 = tmp;
			 }
			if (c1>d1) {
				int tmp = d1;
				d1 = c1;
				c1 = tmp;
			}
			 if (d1>a1) {
				 int tmp = a1;
				 a1 = d1;
				 d1 = tmp;
			}
			if (c1>b1) {
				int tmp = b1;
				b1 = c1;
				c1 = tmp;
			}
			if (e1>c1) {
				int tmp = c1;
				c1 = e1;
				e1 = tmp;
			}
			if (c1>a1) {
				int tmp = a1;
				a1 = c1;
				c1 = tmp;
			}
			System.out.println(e1);
			System.out.println(a1);
			
	
			
			
			
            // ----------------- "B" write your code ABOVE this line only ---------

       

    } // end of main
} //end of class Task5

