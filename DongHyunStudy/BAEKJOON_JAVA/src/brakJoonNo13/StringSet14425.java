// 백준 14425 문제 문자열 집합, 수 대신 문자열을 저장하는 문제

package brakJoonNo13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringSet14425 {

	public static void main(String[] args) {
		
		
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄마다 구분함
			
			int N = Integer.parseInt(st.nextToken());		// 이것 다음 공백이 필요하므로 
			int M = Integer.parseInt(st.nextToken());		// 공백이후 숫자를 다시 쓰기위해 
			int cnt =0;					// 카운트 선언 
			
			Map <String, Integer> Map = new HashMap<String, Integer>(); //<타입값(Key), 저장할 곳(Value)>
			// 저장할 곳은 필요가 없으므로 Integer을 한 후에는 모두 0으로 선언해 주었다.
			
			for(int i=0; i< N; i++) 	// N번 반복
			{
				Map.put(br.readLine(),0);	// Map에 입력받는 String과 0을 넣어준다.
			}
			 
			for(int i=0; i<M; i++)		//M번 반복
			{
				if(Map.get(br.readLine()) != null)		// Map 안의 값 가져오기 근데 지금 입력받는 값이 Map에 없을시
				{										// null 인 것이다.
					cnt++;								// map에 입력받은 값이 있다면 카운트를 올린다.
				}
			}
			bw.write(cnt+"");							//출력
			bw.flush();
			br.close();
			bw.close();
			
		} 
		
		
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
