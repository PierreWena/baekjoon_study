package my.own.quiz.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SJH_1764 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		sc.nextLine();
		
		Set<String> N_set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			N_set.add(sc.nextLine());				// 듣도 못한 사람 명단을 맵으로 추가한다
		}
		
		List<String> NM_list = new ArrayList<>();	// 듣보잡 리스트 선언
		
		for(int i=0; i<M; i++) {
			String M_str = sc.nextLine();
			if( N_set.contains(M_str) )				// 입력받은 문자열이 듣도 못한사람에 있으면
				NM_list.add(M_str);					// 듣보잡 리스트에 추가한다
		}
		
		Collections.sort(NM_list);					// 듣보잡 명단 사전순 정렬
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(NM_list.size()).append("\n");		// 듣보잡 명수
		
		for( String list : NM_list )
			sb.append(list).append("\n");			// 듣보잡 인원 출력
		
		System.out.println(sb);
		
		sc.close();

	}

}
