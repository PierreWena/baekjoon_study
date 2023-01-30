package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_2908 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();					// 두 수 A, B 를 입력받기
		int B = sc.nextInt();

		String str_A = Integer.toString(A);		// A, B를 문자열로 바꾸기
		String str_B = Integer.toString(B);
		String rev_A = "", rev_B = "";
		
		for(int i=2; i>=0; i--) {
			rev_A += str_A.charAt(i);			// A, B 문자열을 뒤집기
			rev_B += str_B.charAt(i);
		}
		
		String result;
		
		if( Integer.parseInt(rev_A) > Integer.parseInt(rev_B) )	// 두 숫자를 비교해서 큰 숫자를 결과로 출력
			result = rev_A;
		else
			result = rev_B;
		
		System.out.println(result);
		
		sc.close();		

	}

}
