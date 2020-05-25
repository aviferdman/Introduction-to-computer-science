import java.util.Scanner;

public class Task4a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int a = myScanner.nextInt(); 
			int b = myScanner.nextInt();
			int c = myScanner.nextInt();
			//find the GCD of a and b and save the value in b
			int r = a%b;
			while (r != 0) {
				a=b;
				b=r; 
				r = a%b;
			}
			//find the GCD of b (which is the GCS of a and b) and c and save the value in c
			r=b%c;
			while (r != 0) {
				b=c;
				c=r; 
				r = b%c;
			}
			System.out.println(c);
			
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
