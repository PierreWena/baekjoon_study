package my.own.quiz.baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SJH_1620 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		sc.nextLine();												// 버퍼를 비워준다
		
		List<String> N_list = new ArrayList<>();
		Map<String, Integer> N_map = new HashMap<>();
		
		for(int i=0; i<N; i++) {									// N번 만큼
			String name = sc.nextLine();							// 포켓몬 도감에 작성할 포켓몬 이름 입력받기
			N_list.add(name);										// ArrayList에 작성
			N_map.put(name, i);										// HashMap에 작성
		}

		Pattern p = Pattern.compile("^[0-9]{1,6}$");				// 정규표현식 패턴 작성 1~6자리의 숫자
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			String src = sc.nextLine();								// src에 찾을 포켓몬 이름이나 번호 입력받기

			Matcher m = p.matcher(src);								// src가 정규식 패턴에 맞는지 확인
			boolean isNum = m.matches();
			
			if(isNum) {												// src가 숫자라면
				sb.append( N_list.get(Integer.parseInt(src)-1) );	// 해당 숫자에 해당하는 포켓몬 이름 출력 (index값은 0부터 시작하므로 0부터 찾기위해 -1을 해줬음)
			}
			else {													// src가 알파벳이라면
				sb.append( N_map.get(src)+1 );						// 해당 문자에 해당하는 포켓몬의 번호 출력 (index값은 0부터 시작하므로 1부터 시작할수있게 +1을 해줬음)
			}
			sb.append("\n");										// 줄바꿈 추가해주기
		}
		
		System.out.println(sb);										// 결과값 출력
		
		
		sc.close();

	}

}
