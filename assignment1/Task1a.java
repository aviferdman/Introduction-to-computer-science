import java.util.Scanner;

public class Task1a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int a = myScanner.nextInt();
			int b = myScanner.nextInt();
			int c = myScanner.nextInt();
			if ((a*a+b*b==c*c)&(0<a)&(a<=b)&(b<=c))
				System.out.println("yes");
			else
				System.out.println("no");
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
