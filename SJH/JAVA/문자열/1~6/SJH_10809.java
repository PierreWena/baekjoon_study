package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_10809 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(char i='a'; i<='z'; i++) {
			
			int idx = -1;
			
			for(int j=0; j<S.length(); j++) {
				if( i == S.charAt(j) ) {
					idx = j;
					break;
				}
			}
			sb.append(idx + " ");
		}
		
		System.out.println(sb);
		
		sc.close();

	}

}
