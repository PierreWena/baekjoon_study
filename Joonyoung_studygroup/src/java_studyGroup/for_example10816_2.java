package myalgorithm;

import java.io.*;
import java.util.*;

public class for_example10816_2 {

	public static void main(String[] args) throws IOException { // 참고: https://chobo24.tistory.com/entry/

		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		
		StringTokenizer st;
		
		HashMap<Integer, Integer>hash = new HashMap<>();
		
		
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(bf.readLine());
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=1; i<=N; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			
			if(hash.get(num) == null) { // 아예 존재하지 않던 카드라면
				
				
				hash.put(num, 1); // 해쉬맵에 넣어준다
				
				
			}
			
			else {  // 이미 있던 거라면
				
				int count = hash.get(num);  // 카드의 갯수를 뜻하는 count를 카드 해쉬맵의 밸류로 매번 초기화
				
				hash.put(num, ++count);
				
				
				
			}
			
			
			
			
		}  //  end of for---------------------
		
		
		
		int M = Integer.parseInt(bf.readLine());
		
		st = new StringTokenizer(bf.readLine()); // 토큰이 날라가서 없어졋으니 다시 만든다
		
		
		
		for(int i=0; i<M; i++) {
			
			
			int num = Integer.parseInt(st.nextToken());
			
			
			if(hash.get(num) == null)  // 입력한 정수가 카드에 일치하지 않는다면
				
				
				sb.append(0 + " "); // sb에 계속 추가해줘나간다.
				
				
				
			
			
			else   // 일치한다면
				
				sb.append(hash.get(num) + " ");
				
				
			
			
			
			
		}
		
		
		
		System.out.println(sb.toString());
		
		 
		 
		
	} // end of main------------------

}
