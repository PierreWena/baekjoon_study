package my.own.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SJH_11478 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str_S = br.readLine();
		
		br.close();
		
		Set<String> set_S = new HashSet<>();				
		
		
		for(int i=0; i<str_S.length(); i++) {				// i개 글자길이의 부분문자열을 구할 것이다
			
			for(int j=0; j<str_S.length(); j++) {			// j번째 index부터 j+i번째 인덱스까지의 부분문자열을 구할 것이다
				
				if(j+i+1 <= str_S.length())					// j+i+1 > str_S.length()일경우 StringIndexOutOfBoundsException이 뜬다
					
					set_S.add(str_S.substring(j,j+i+1));	// 부분문자열을 모두 hashset에 저장하면 중복은 알아서 덮어써진다
					
					
			}
		}
		
		System.out.println(set_S.size());					// 서로다른 부분 문자열 갯수 출력

	}

}
