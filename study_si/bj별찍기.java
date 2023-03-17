package my.day01.backjun;

import java.util.Scanner;

public class bj별찍기 {

	public static void main(String[] args) {

	/*
	  [*]   i		j
	  		1	=>	1
	  		2	=>	3
	  		3	=>	5
	  		4	=>	7
	  		5	=>	9
	  	   i*2 -1 = j
	  	   
	  	   
	  [" "] i		j
	  	   	1	=>	4
	  	   	2	=>  3
	  	   	3	=>	2
	  	   	4	=>	1
	  	   	5	=>	0
	  	   	i + j = N
	  	   	j = N - i
	 	
	 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
	for(int i=1; i<=N; i++) {
		for(int j=N-i; j>0; j--) {	 // 공백이 하나씩 줄어드니까 j--감하고
			System.out.print(" "); // 공백부터 나오니까공백먼저
		}
		for(int j=0; j<i*2-1; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	for(int i=N-1; i>=1; i--) {	// 위에꺼를 뒤집으면 되서 출발점을 1에서 N으로 바꾸고 도착점을 N이랑 1이랑 바꿧는데 N-1 한이유는 
		for(int j=N-i; j>0; j--) {		// *9개 중간에 나오는걸 방지하기위해서
			System.out.print(" "); 
		}
		for(int j=0; j<i*2-1; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
		
		
		
		
		
		
		
		
		
	
	
	}
		
}
