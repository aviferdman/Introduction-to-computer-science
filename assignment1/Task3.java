import java.util.Scanner;

public class Task3 {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int n = myScanner.nextInt();
			int counter = 0;
			//check for the dividers of n, and for every divisor how many times it divides n
			for (int divisor=2;divisor<=n;divisor=divisor+1){
				while(n%divisor==0){
					counter=counter+1;
					n=n/divisor;
				}
			//print the divisor and how many times they divide n
				if (counter==1)
					System.out.println(divisor);
				if (counter>1)
					System.out.println(divisor+" "+counter);
				counter=0;		
			}
				
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
