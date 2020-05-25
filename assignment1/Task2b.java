import java.util.Scanner;

public class Task2b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int n = myScanner.nextInt();
			int k = myScanner.nextInt();
			int reminder=1;
			//calculates the reminder for every divider of n!
			for(int i=1;i<=n;i=i+1){
				reminder=reminder*(i%k);
				reminder=reminder%k;
			}
			System.out.println(reminder);
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
