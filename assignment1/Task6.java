// You may not change or erase any of the lines and comments 
// in this file. You may only add lines.

import java.util.Scanner;

public class Task6 {


    public static void main(String[] args){


            // ----------------- write any code BELOW this line only --------
            // your code here (add lines)
			boolean isTask5True = true;
			// checks if Task5 is correct for 2^5 possibilities			
			for(int a=0;a<2&isTask5True;a=a+1){
				for(int b=0;b<2&isTask5True;b=b+1){
					for(int c=0;c<2&isTask5True;c=c+1){
						for(int d=0;d<2&isTask5True;d=d+1){
							for(int e=0;e<2&isTask5True;e=e+1){
								// saves the values of a,b,c,d,e in order not to interfere the loops
								int a1,b1,c1,d1,e1;						
								a1=a;
								b1=b;
								c1=c;
								d1=d;
								e1=e;
								
            // ----------------- write any code ABOVE this line only ---------
			
            // -----------------  copy here the code from Task 5 that is between
            // -----------------  the comments "A" and "B"
            // code from Task 5 here
			// the max value is a1 and the min is e1
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
            // -----------------  end of copied code from Task 5




            // ----------------- write any code BELOW this line only --------
            // your code here (add lines) 
			
								// these are the conditions to check if Task5 is false
								// if it's false print the original values a,b,c,d,e
								// the max value is a1 and the min is e1
								if((a1<b1)|(a1<c1)|(a1<d1)|(a1<e1)|(b1<e1)|(c1<e1)|(d1<e1)){
									
									isTask5True=false;
									System.out.println(a);
									System.out.println(b);
									System.out.println(c);
									System.out.println(d);
									System.out.println(e);
								}
							}
						}
					}
				}
									
			}
			// if the value of isTask5True stayed true, means Task 5 is correct
			if (isTask5True)
				System.out.println("verified");
            // ----------------- write any code ABOVE this line only ---------

    } // end of main
} //end of class Task6

