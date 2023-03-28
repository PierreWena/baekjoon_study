package my.own.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SJH_10988 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int result = 1;
		
		for(int i=0; i<str.length()/2; i++) {						// 문자열 절반만큼 반복
			if( str.charAt(i) != str.charAt(str.length()-1-i) ) {	// 대칭된 알파벳 비교해서 다르면
				result = 0;											// 결과를 0으로 바꾸고 반복문 break
				break;
			}		
		}
		
		System.out.println(result);
		
	}

}
