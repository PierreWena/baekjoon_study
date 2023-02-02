// 백준 1620 나는야 포켓몬 마스터 이다솜, 맵을 사용하여 이름과 수를 연결짓는 문제

package brakJoonNo13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pokemon1621_2_3 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
			// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼writer
			// Bufferedwritwe 은 sysout을 대체하기 위해 사용 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			// HashMap은 Map인터페이스에 속해있는 컬렉션입니다
			
			HashMap <String, String> Map = new HashMap<String, String>(); //HashMap<타입, 타입>
			
			HashMap <String, String> Map2 = new HashMap<String, String>(); //HashMap<타입, 타입>
			
			
			//
			int N = Integer.parseInt(st.nextToken());		// 이것 다음 공백이 필요하므로 
			int M = Integer.parseInt(st.nextToken());		// 공백이후 숫자를 다시 쓰기위해 
			
			for(int i = 0; i < N ; i++)					// N번 반복 
			{
				String A = br.readLine();				// String타입 A를 받아옴 
				String B = Integer.toString(i+1);		// String타입 B를 i+1로 받아옴 
				Map.put(A, B);							// Map에 글자, 숫자로 저장
				Map2.put(B, A);							// Map2에 숫자, 글자로 저장 
			}
			
			StringBuilder sb = new StringBuilder();		//스트링 빌더 
			
			for(int j = 0; j < M ; j++)					// M번 반복
			{
				String str = br.readLine();				// 비교할 문자 입력
				
				if('0' <= str.charAt(0) && str.charAt(0) <= '9')	// str이 숫자라면 
				{
					sb.append(Map2.get(str)+"\n");		// 숫자를 비교해보고 문자를 나타냄 
				}
				else								// str이 숫자가 아니라면 
				{
					sb.append(Map.get(str)+"\n");	// 문자를 비교해보고 숫자를 나타냄 
				}
			}
			
			bw.write(sb.toString());				// 출력
			bw.flush();
			br.close();
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// 한 줄마다 구분함

	}

}
