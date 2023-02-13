package my.own.quiz.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SJH_10816 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		Map<Integer, Integer> N_map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(N_map.containsKey(num))					// 이미 저장된 숫자라면
				N_map.put(num, N_map.get(num) + 1);		// 맵의 value 값을 +1 해준다
			else										// 아니라면
				N_map.put(num, 1);						// 앱에 값을 넣어준다
		}
		
		int M = sc.nextInt();
		
		sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			if( N_map.get(num) == null)					// 맵에 없는 숫자는
				sb.append("0 ");						// 0을 출력
			else
				sb.append(N_map.get(num)).append(" ");	// 맵에 있는 숫자는 value를 출력
		}
		System.out.println(sb);
		
		sc.close();

	}// end of main()

}
