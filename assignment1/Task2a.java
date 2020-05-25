import java.util.Scanner;

public class Task2a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int n = myScanner.nextInt();
			int factorial = 1;
				while(n!=0){
					factorial=factorial*n;
					n=n-1;
				}
				System.out.println(factorial);
			
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
