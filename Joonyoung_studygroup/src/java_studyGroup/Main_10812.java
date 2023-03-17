package myalgorithm;

import java.util.Scanner;

public class Main_10812 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		sc.nextLine();
		
	
		
		int []arr = new int[N];
		
		int []brr = new int[N];
		
		
		for(int i=0; i<N; i++) {
			
			arr[i] = i+1;
			
		}
		
		for(int i=0; i<N; i++) {
			
			brr[i] = i+1;
			
		}
		
		
		
		
		
		for(int r=0; r<M; r++) {
			
			int i = sc.nextInt();
			
			int j = sc.nextInt();
			
			int k = sc.nextInt();
			
		
			for(int s=0; s<j-k+1; s++) {
				
				brr[ i - 1 + s] = arr[ k - 1 + s];
				
				
			}
			
            for(int A=0; A<k-i; A++) {
            	
            	brr[i + j - k + A]  = arr[ i - 1 + A];
            	
            }
            
            for(int num=0; num<N; num++) {
				arr[num]=brr[num];
			}
			
			
		}// end of for------------------------------------------
		
		
		for(int b=0; b<N; b++) {
			
			System.out.print(brr[b]+" ");
			
		}
		
		
		
	} // end of main------------------------------

}
