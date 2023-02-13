package my.own.quiz.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SJH_10815 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, Integer> N_map = new HashMap<>();		// HashMap 생성
		
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			N_map.put(sc.nextInt(), 1);						// 숫자카드 저장	
		}
		
		int M = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			
			if( N_map.get(sc.nextInt()) == null )			// 찾는 값이 없으면
				sb.append(0).append(" ");					// 0을  출력
			else
				sb.append(1).append(" ");					// 찾는 값이 있으면 1을 출력
		}
		
		
		
		System.out.println(sb);								// 결과 출력
		
		
		
		sc.close();

	}

}
