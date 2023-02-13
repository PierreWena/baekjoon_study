package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_2675 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		short T = sc.nextShort();			// 테스트 케이스 갯수 T를 입력받는다
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {				// 테스트 케이스 T만큼 반복
			byte R = sc.nextByte();				// 반복 횟수 R을 입력받는다
			String S = sc.nextLine().trim();	// 문자열S를 입력받는다(공백은 제외)
			char[] arr = S.toCharArray();		// 문자열S를 배열arr로 변환 
			
			for(int j=0; j<arr.length; j++) { 
				for(int k=0; k<R; k++)			// 반복횟수 R만큼 문자를 반복한다
					sb.append(arr[j]);
			}
			
			sb.append("\n");					// 테스트 케이스마다 줄바꿈해준다
			
		}// end of for
		
		System.out.println(sb);					// 결과 출력
		
		sc.close();

	}// end of main

}
