package my.own.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SJH_1269 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num_A = Integer.parseInt(st.nextToken());				// A와 B의 원소 갯수 입력
		int num_B = Integer.parseInt(st.nextToken());
		
		Set<Integer> set_sd = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<num_A; i++) {
			set_sd.add(Integer.parseInt(st.nextToken()));			// 집합 A를 해쉬셋으로 만든다
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<num_B; i++) {
			
			int num_B_arg = Integer.parseInt(st.nextToken());		// 집합 B의 원소를 입력받는다
			if( !set_sd.remove(num_B_arg))							// 해쉬셋에 집합 B의 원소가 있으면 제거하고
				set_sd.add(num_B_arg);								// 없으면 해쉬셋에 추가한다
			
		}
		
		System.out.println(set_sd.size());							// 대칭차집합인 해쉬셋의 사이즈 출력
		
		br.close();
		
	}

}
