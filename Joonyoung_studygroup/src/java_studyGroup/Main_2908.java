package myalgorithm;

import java.util.Scanner;

public class Main_2908 {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		int A = sc.nextInt();
		
		int B = sc.nextInt();
		
		
		int numA = (A/100) + (A%100 - ((A%100)%10)) + (((A%100))%10)*100; // A를 100으로 나눈 몫= 백의자리, A를 100으로 나눳을떄의 나머지에서  A를 100으로 나눈 나머지를 또 10으로 나눈 나머지를 빼면 A의 10의자리수 *10, A를 100으로 나눈 나머지를 또 10으로 나눈 나머지는 1의 자리이기때문에  
		int numB = (B/100) + (B%100 - ((B%100)%10)) + (((B%100))%10)*100; // ""

		if(numA> numB)
			
			
			System.out.println(numA);
		
		else if(numA < numB)
			
			System.out.println(numB);
		
	} // end of main-----------------------------------------------

}
