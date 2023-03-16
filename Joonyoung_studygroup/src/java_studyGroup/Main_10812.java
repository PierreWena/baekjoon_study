package myalgorithm;

import java.util.Scanner;

public class Main_10812 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		sc.nextLine();
		
		String str = "";
		
		int []arr = new int[N];
		
		
		
		for(int i=0; i<N; i++) {
			
			arr[i] = i+1;
			
		}
		
		
		
		
		for(int A=0; A<M; A++) {
			
			int i = sc.nextInt();
			
			int j = sc.nextInt();
			
			int k = sc.nextInt();
			
			sc.nextLine();
			
             for(int num=k; num<j+1; num++) {
				
				str += arr[num]+ " ";
				
			}
			
			
			
			for(int num=i; num<k; num++) {
				
				
				str += arr[num] + " ";
			}
			
			
			
		}// end of for------------------------------------------
		
		
		
	} // end of main------------------------------

}
