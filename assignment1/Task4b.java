import java.util.Scanner;

public class Task4b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int a = myScanner.nextInt(); 
			int b = myScanner.nextInt();
			int c = myScanner.nextInt();
			int r = a%b;
			int lcm = a*b;
			int lcm2;
			//find the GCD of a and b and saves the value in b
			while (r != 0) {
				a=b;
				b=r; 
				r = a%b;
			}
			// calculate the lcm of a and b
			lcm = lcm/b;
			lcm2 = lcm*c;
			//find the GCD of lcm(a,b) and c and save the value in c
			r = lcm%c;
			while (r != 0) {
				lcm=c;
				c=r; 
				r = lcm%c;
			}
			// calculate and print the lcm (a,b,c)
			System.out.println(lcm2/c);
			
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
