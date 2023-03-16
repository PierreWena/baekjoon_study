package myalgorithm;

import java.util.Scanner;

public class Main_2444 {

	public static void main(String[] args) {
		
		
// 정답출처 : https://ilpyoyang.tistory.com/120?category=444704		
		
		Scanner sc = new Scanner(System.in);
		

		int N = sc.nextInt();
		
		sc.nextLine();
		
		
		
		
		

		
		/*
		 * for (int i=1; i<= N ; i++) {
		 * 
		 * 
		 * 
		 * for(int j = 0; j<N-i; j++) {
		 * 
		 * 
		 * System.out.print(" ");
		 * 
		 * }
		 * 
		 * for (int j = 0; j < 2* i -1; j++) {
		 * 
		 * System.out.print("*");
		 * 
		 * }
		 * 
		 * 
		 * System.out.print("\n");
		 * 
		 * }
		 * 
		 * 
		 * for (int i=1; i<N; i++) { for(int j=0; j<i; j++) { System.out.print(" "); }
		 * 
		 * for(int j=0; j<2*N-2*i-1; j++) { System.out.print("*"); }
		 * System.out.print("\n");
		 * 
		 * 
		 * 
		 * }
		 */
		
		
	
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		for(int i=0; i<N; i++) {
			
			
			for(int j=0; j<N-i-1; j++) {
				
				System.out.print(" ");
				
			}
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
		}
		
		
		for(int i=1; i<N; i++ ) {
			
			
			for(int j=0; j<i; j++ ) {
				
				System.out.print(" ");
				
				
			}
			
			
			for(int j=0; j<2*N -2*i-1; j++) {
				
				System.out.print("*");
			}
			
			
			System.out.println();
			
		}
		
		
		sc.close();
		
		
		
		
	
		
		
/*		
 
 
 
 String s = "";
 
 
 
 for (int i=0; i< 2*N-1; i++) {
 
 	s += "*";
 
 }
 
		
		for (int i = 0; i < 2*N-1 ; i++ ) {
			
			
			
			
			
			
			
			if(i<N) {
			
				for(int j = 0; j < 2 * i + 1; j++) {
					
					
					System.out.print("*");
					
					
				}   // end of for---------
				
				System.out.println();
				
				
				
			
			}
			
			
			
			else {
				
				 for(int k = 2*N-3 ; k>0; k-=2 ) {
					 
					 System.out.print(s.substring(0,k));  
					 
					 System.out.println();
					 
					 cnt ++;
				 }
				 
				 if(cnt == N-1) {
					 
					 break;
					 
				 }
				
				
			}
			
			
		}  // end of for---------
		
		
		
	*/	
		
		

	} // end of main------------------------------------------

}
