package my.own.quiz.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SJH_14425 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		sc.nextLine();									// 버퍼 비우기
		
		Map<String, Integer> S_map = new HashMap <>();	// 해쉬맵 선언
		
		for(int i=0; i<N; i++) {
			
			S_map.put(sc.nextLine(), 1);				// 집합 S에 문장 넣기
			
		}
		
		int result = 0;
		
		for(int i=0; i<M; i++) {
			
			if ( S_map.get(sc.nextLine()) != null )		// 집합 S에 문장이 있으면
				result++;								// 결과값 +1
		}
		
		System.out.println(result);						// 결과값 출력
		
		
		sc.close();

	}

}
