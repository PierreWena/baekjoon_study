package my.day01.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		List<Integer> al = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine()); //다시
		for(int i = 0 ; i < a; i++)
			al.add( Integer.parseInt(st.nextToken()));
		int count = 0;
		st = new StringTokenizer(br.readLine()); // 다시
		for(int i = 0 ; i < b; i++){
			if(al.contains(Integer.parseInt(st.nextToken()))) //리스트에 al에 있다면
				count++;
		}

		System.out.println((b-count)+(a-count)); //대칭 차집함 개수 구해줌
	}
}
// 시간초과 ㅠㅠㅠ