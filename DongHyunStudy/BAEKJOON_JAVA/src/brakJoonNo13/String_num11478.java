// 백준 11478번 문제 서로 다른 부분 문자열의 개수, 집합을 활용하여 중복을 제거하는 문제  

package brakJoonNo13;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class String_num11478 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 스케너 대신 사용
			
			Map<String, Integer> map = new HashMap<String, Integer>();	//Map 사용을 위해! 설정
			
			String A = br.readLine();		// 키보드로 입력값 받아옴
			
			
			for(int i=0; i<A.length(); i++)		// A길이까지 반복
			{
				for(int j = 0; j <A.length()-i; j++)	// A.length() -1 을 해주는 이유는 아래 주석의 예시를 보자 
				{										// map.put(A.substring(j,j+i+1), 1); 이 코드에서 j+i+1 부분에 오류가 발생한다.
														// 만약 문자열이 5개 길이를 가지고 있다고 보자 
					                                    // i가 1이되면 j가 4가 되었을때 j + i + 1 은 6으로 문자열 길이보다 초과하는 인덱스 번호를 가지게 된다.
														// 따라서 A.length() - i 번을 한다면 i가 1일때 j가 최대값인 3이 되어서 j + i +1 이 문자열 마지막 인덱스 5를 나타낼 수 있다. 
					
					map.put(A.substring(j,j+i+1), 1);	// substring은 문자열 자르기하는 것이다 ()에서 앞쪽은 시작 인덱스, 뒤쪽은 끝나는 인덱스 앞까지만을 표시한다.
														// j가 0일때 는 a , b, a, b ,c 가 된다.
														// 하지만 map은 key값은 고유하므로 a,b,c만 남게 된다. 그 이후에는 반복이다.
				}
			}
				
			System.out.println(map.size());				// map에 들어간 크기 만큼 구하면 서로 다른 부분 문자열의 개수를 구할 수 있다.
			
			br.close();					// 메모리 누수 방지 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
