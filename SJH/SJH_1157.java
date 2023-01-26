package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_1157 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine().toUpperCase();		// 문자열을 입력받아서 전부 대문자로 만든다
		
		int mostAlf = 0;								// 가장 많이 사용된 알파벳의 횟수를 세는 변수
		char result = '?';								// 가장 많이 사용된 알파벳
		
		// A부터 Z까지 알파벳이 사용된 횟수를 세고(count) 난 다음에 비교 
		for(char i='A'; i<='Z'; i++) {					// 알파벳 갯수만큼 반복
			
			int count = 0;								// 알파벳이 사용된 횟수를 세는 변수
			
			for(int j=0; j<str.length(); j++) {			// 문자열의 길이만큼 반복
				if( i==str.charAt(j) )					// 문자열의 한 글자가 지금 세고있는 알파벳과 같을 경우
					count++;							// 사용된 횟수를 더한다
			}
			
			if(count > mostAlf) {						// 지금 세고있는 알파벳이 제일 많이 사용됐을 경우 
				mostAlf = count;						// 제일 많이 사용된 횟수를 갱신해주고
				result = i;								// 가장 많이 사용된 알파벳으로 바꿔준다
			}
			else if(count == mostAlf) 					// 제일 많이 사용된 알파벳이 둘 이상일 경우
				result = '?';							// 가장 많이 사용된 알파벳을 '?'으로 바꿔준다
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(result);
		System.out.println(sb);							// 결과 출력
		
		sc.close();		

	}

}
