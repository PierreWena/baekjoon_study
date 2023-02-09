package myalgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Forexample_1269_2 {

	public static void main(String[] args) throws IOException { // 참고 https://theash.tistory.com/entry/%EB%B0%B1%EC%A4%80-1269%EB%B2%88-%EB%8C%80%EC%B9%AD-%EC%B0%A8%EC%A7%91%ED%95%A9-%EC%9E%90%EB%B0%94java
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer>hashSet = new HashSet<>();
		
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int numA = Integer.parseInt(st.nextToken());
		
		int numB = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<numA; i++) {
			
			hashSet.add(Integer.parseInt(st.nextToken()));
			
			
			
		}
		
		int cnt = hashSet.size();   // 특정 길이를 반복문을 돌릴떄 변수로 지정해서 수행하는게 더 빠르다.
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<numB; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			
			if(!hashSet.contains(num)) { // hashSet에 입력한 값이 없으면 hashSet의 길이를 증가시킨다.
				
				cnt++;
				
				
			}
			
			else {  // 있으면, 즉 중복이면 hashSet의 길이를 그만큼 없애준다
				
				cnt--;
			}
			
			
		}
		

		
		bw.write(String.valueOf(cnt));  // 버퍼드라이터로 출력하는것도 빠르게 했다.
		
		bw.flush();
		
		bw.close();
		
		
		
		
		
		/*
		 * BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		 * 
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
		 * 
		 * Map<Integer , Integer>hash = new HashMap<>();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		 * 
		 * 
		 * int numA = Integer.parseInt(st.nextToken());
		 * 
		 * 
		 * int numB = Integer.parseInt( st.nextToken() ) ;
		 * 
		 * 
		 * int cnt = 0;
		 * 
		 * 
		 * 
		 * 
		 * st = new StringTokenizer(bf.readLine());
		 * 
		 * 
		 * for(int i=0; i<numA; i++) {
		 * 
		 * int A = Integer.parseInt(st.nextToken());
		 * 
		 * 
		 * hash.put( A , i );
		 * 
		 * 
		 * }// end of for----------------
		 * 
		 * 
		 * 
		 * st = new StringTokenizer(bf.readLine());
		 * 
		 * 
		 * 
		 * 
		 * for(int i=0; i<numB; i++) {
		 * 
		 * 
		 * int B = Integer.parseInt(st.nextToken());
		 * 
		 * 
		 * 
		 * 
		 * for( Integer keys : hash.keySet() ) {
		 * 
		 * 
		 * if( B == keys ) {
		 * 
		 * cnt++;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }// end of for----------------
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // 이건 틀린것 System.out.println(numA + numB - (2 * cnt));
		 * 
		 * int ans = numA + numB - (2 * cnt);
		 * 
		 * bw.write(ans); bw.flush(); bw.close();
		 * 
		 * 
		 */
		// 시간초과 왜? hash set 안써서? 이중 for문이 있어서? 아니면 왜 대체. hashSet을 안써서 시간초과 난듯
		// hashmap이나 다른것들은 안될거같음. 버퍼라이터를 써도 문제가생김
		
		
		
	}

}
