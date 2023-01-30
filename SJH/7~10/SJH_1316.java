package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_1316 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		sc.nextLine(); 							// 버퍼를 비워준다
		
		int result = 0;
		
		for(int i=0; i<N; i++) {				// N개의 단어
			
			String str = sc.nextLine();			// 단어 입력
			
			Boolean isGroup = true;
			
			for(int j=0; j<str.length(); j++) { // 알파벳 갯수만큼 반복
				
				char ch = str.charAt(j);
				String str_sub = str.substring(str.indexOf(ch), str.lastIndexOf(ch));
				// 해당 알파벳의 시작과 끝을 기준으로 문자열을 만든다
				
				str_sub = str_sub.replaceAll(Character.toString(ch), "");
				// 문자열에서 해당 알파벳을 전부 없앤다
				
				if( str_sub.isEmpty() ) 		// 사이에 다른 알파벳이 안껴있었다면 텅 비어있다
					j = str.lastIndexOf(ch);	// 다음 알파벳을 검사한다
				else {							// 만약 다른 알파벳이 껴있다면
					isGroup = false;			// 그룹단어가 아니므로 false값을 준다
					break;						// 더이상 검사할 필요가 없어서 break로 빠져나온다
				}
				
			}// end of for
			
			if(isGroup)							// 그룹단어라면
				result++;						// 결과값에 +1
			
		}// end of for
		
		System.out.println(result);				// 결과값 출력
		
		sc.close();

	}// end of main

}
