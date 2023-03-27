package myalgorithm;

import java.util.Scanner;

public class Main_4344 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int C = sc.nextInt();
		
		for(int i=0; i<C; i++) {
			
			int N = sc.nextInt();
			
			int[]scoreArr = new int[N];
			
			int sum = 0;
			
			int avg = 0;
			
			double cnt =0;
			
			for(int j=0; j<N; j++) {
				
				scoreArr[j] = sc.nextInt();
				
				sum += scoreArr[j];
				
			}
			
			avg = sum/N;
			
			for(int k=0; k<N; k++) {
				
				if(scoreArr[k] > avg) { // 평균보다 높으면
					
					cnt ++;  // 그 사람이 몇명인지 갯수를 세준다.
					
				}
				
			}
			
		
			 
			double round = (cnt/N)*100;
			
			String result = String.format("%.3f", round);	
			
			
			System.out.println(result+"%");
			
			
			
		}
		
	}

}
