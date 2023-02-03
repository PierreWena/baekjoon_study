package my.day01.backjun;

import java.io.IOException;
import java.util.*;


public class bj10815 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(sc.nextInt(), 1); 	// map에 key값에 입력한 값을 숫자카드의 정수로 주고 모두 value 값으로 1을 줌
		}								// 상근이가 가지고있는 N개의 숫자값

		int M = sc.nextInt();  // 상근이의 숫자카드랑 비교할 M개의 정수
		for (int i = 0; i < M; i++) {
			if (map.get(sc.nextInt()) != null) { //map(상근이의 카드)에 동일한 키가 null이 아닌 같은게 있다면 "1 " 1하고 공백을주고
				System.out.print("1 ");			 
			} else {
				System.out.print("0 ");  // 없다면 0을 줌
			}
		}

	}

}
