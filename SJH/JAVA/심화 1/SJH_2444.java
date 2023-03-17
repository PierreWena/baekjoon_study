package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_2444 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();				// N에 5입력 
		
		StringBuilder sb = new StringBuilder();

		for(int i=1; i<N*2; i++) {			// 줄갯수 9줄 N*2-1
			
			int num = i>N? N*2-i : i;		// 123454321
			
			for(int j=1; j<=N-num; j++) {	// 공백찍기 4 3 2 1 0 1 2 3 4
				sb.append(" ");
			}
			for(int k=1; k<num*2; k++) {	// 별찍기 1 3 5 7 9 7 5 3 1
				sb.append("*");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());
		
		sc.close();

	}

}
