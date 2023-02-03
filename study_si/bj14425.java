package my.day01.backjun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class bj14425 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		int M = Integer.parseInt(sc.nextLine());
		
		Map<String, Integer> map = new HashMap<>();		
		int cnt = 0;

        for (int i = 0; i < N; i++) {
            map.put(sc.nextLine(), 1); // 키값이 중요 value 값 1로 고정하고 
        }
       
        for (int i = 0; i < M; i++) {
            String str = sc.nextLine();
            if (map.get(str) != null) {	// 위에 집합에 검색한 문자열이랑 겹치는게 있다면 카운트 올라감
                cnt++; 
	
            }
        }
		System.out.println(cnt);
		sc.close();

	}
}
