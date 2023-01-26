package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine().trim();			// 문자열을 입력받아서 앞뒤 공백을 제외한다
		
		if (str.isEmpty()) {						// 빈 문자열을 입력받았을 경우
			System.out.println(0);					// 0을 출력
			System.exit(0);							// 프로그램 강제종료
		}
		
		String[] arr = str.split(" ");				// 공백을 기준으로 문자열을 나눠서 배열로 저장한다
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(arr.length);						// 배열의 길이를 출력한다
		System.out.println(sb);
		
		sc.close();

	}

}
