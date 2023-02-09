// 백준 1269번 문제 , 대칭 차집합, 둘 중 한 집합에만 속하는 원소를 모두 구하는 문제

package brakJoonNo13;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SymmetricDifferentialSet1269 {

	public static void main(String[] args) {
		try {
			
			Map <String, Integer> Map = new HashMap<String, Integer>(); //<타입값(Key), 저장할 곳(Value)>
			// 저장할 곳은 필요가 없으므로 Integer을 한 후에는 모두 0으로 선언해 주었다.
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		// 버퍼 리더 쓰면서 Scanner보다 빠르게 해보자 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		// 버퍼 writer 쓰면서 sysout보다 빠르게 해보자 

			StringTokenizer st = new StringTokenizer(br.readLine());			// 스트링 토큰으로 공백마다 구분해서 사용하자 
			StringBuilder sb = new StringBuilder();								// 스트링 빌더로 모아보자 but 이 문제에서는 언써도 됐었다.
			
			int A = Integer.parseInt(st.nextToken());							// A집합 값을 받아오고 
			int B = Integer.parseInt(st.nextToken());							// B집합 값을 받아온다.
			int cnt = 0;														// 카운트를 위해 선언 
			int cnt2 = 0;
			
			st = new StringTokenizer(br.readLine());							// 스트링 토큰을 다시 사용하기 위해 
			
			for(int i=0; i < A; i++)											// A번 반복 
			{
				Map.put(st.nextToken(), 1);										// Map에 저장 
			}
			
			st = new StringTokenizer(br.readLine());							// 스트링 토큰을 다시 사용하기 위해 
			
			for(int j=0; j < B; j++)											// B번 반복
			{
				String C = st.nextToken();										// C값을 받아와서 A집합 값과 비교한다.
				if(Map.get(C) == null)											// 비교값이 없다면 
				{
					cnt++;														//cnt를 1 상승 
				}
				else															// 비교값이 있다면  
				{
					cnt2++;														//cnt를 1 상승 
				}
			}
			
			cnt = cnt + (Map.size() - cnt2); 									// A와 B의 대칭 차집합을 구하기 위해 
																				// cnt부분이 B-A,  (Map.size() - cnt2)부분이 A-B
			sb.append(cnt);														//스트링 빌더에 쌓아준다.
			
			bw.write(sb.toString());			//출력
			bw.close();
			br.close();
			
		
		} catch (IOException e) {				//오류
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
