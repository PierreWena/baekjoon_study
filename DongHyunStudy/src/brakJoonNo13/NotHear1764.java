// 백준 1764번 문제 듣보잡, 듣도 보도 못한 문제 

package brakJoonNo13;

import java.io.*;
import java.util.*;

public class NotHear1764 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
			// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼writer
			// Bufferedwriter 은 sysout을 대체하기 위해 사용 

			Map<String, Integer> map = new HashMap<String, Integer>() ;				//Map을 사용하기 위해 
			ArrayList<String> list = new ArrayList<>();								// ArrayList로 값을 저장하기 위해 

			StringTokenizer st = new StringTokenizer(br.readLine());;				// 스트링 토크를 사용하기 위해 한줄을 받아와서 공백기준으로 나눔 
			StringBuilder sb = new StringBuilder();									// 스트링 빌더를 사용하기 위해 

			int N = Integer.parseInt(st.nextToken());			// 듣도 못한 사람 테스트 할 값들을 받아오자 
			int M = Integer.parseInt(st.nextToken());			// 보도 못한 사람 테스트할 값들을 받아오자 
			int cnt = 0;										// 카운트를 나타내기 위해 선언 
			
			for(int i = 0; i < N ; i++ )						// N번 반복 듣도 못한 사람 테스트수 만큼 
			{
				map.put(br.readLine(), 1);						// map에 넣는다.
			}

			for(int j = 0 ; j < M; j++)							// M번 반복 보도 못한 사람 테스트수 만큼
			{
				String A = br.readLine();						// 값을 받아오기 위해 선언 
				
				if(map.get(A) != null)							// map에 키보드로 받아온 A값이 null이 아니라면 
				{
					cnt ++;										// 카운트를 올린다.
					// sb.append(map.get(A) + "\n");
					list.add(A);								// ArrayList에 A를 저장한다.
				}
			}
			
			// 추가부분 	
			Collections.sort(list);								// 오름차순으로 저장하는 명령어이다. (기억하자)
				
			
			// 추가부분
			for(String A : list) { 								// 확장형 for 문 리스트 전체 순회			
				sb.append(A).append("\n");						// 스트링 빌더에 A를 추가하고 그 다음 줄바꿈 한다.
			}
			
			bw.write(cnt + "\n" + sb.toString());				// 모니터에 출력하자 
			bw.close();											// 메모리 누수 방지를 위해  
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
