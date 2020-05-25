import java.util.Scanner;

public class Task1b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int n= myScanner.nextInt();
			//check all the options, from 1 (because in case of 0 its obivious) until the number n
			for(int a=1;a<=n;a=a+1){
				for(int b=1;b<=n;b=b+1)
					for(int c=1;c<=n;c=c+1)
						if((a*a+b*b==c*c)&(a<=b))
							System.out.println(a+" "+b+" "+c);
			}
			
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
