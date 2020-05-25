import java.util.Scanner;

public class Task4c {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int a = myScanner.nextInt(); 
			int b = myScanner.nextInt();
			int c = myScanner.nextInt();
			int d = myScanner.nextInt(); 
			int e = myScanner.nextInt();
			int f = myScanner.nextInt();
			//this condition is true just in the case when (a/b + c/d + e/f) = 1
			if((a*d*f+c*b*f+e*b*d)==b*d*f)
				System.out.println("yes");
			else
				System.out.println("no");
				
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
