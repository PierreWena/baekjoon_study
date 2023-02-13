package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_11720 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		String str = sc.nextLine();
		
		int result = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			result += str.charAt(i) - '0';	// 발상이 안닿아서 해답봄
		}
		
		sb.append(result);
		System.out.println(sb);
//		System.out.println(result);
		
		sc.close();

	}

}
