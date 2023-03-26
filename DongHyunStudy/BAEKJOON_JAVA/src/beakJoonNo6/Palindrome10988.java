package beakJoonNo6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome10988 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
		// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
		
		int cnt = 1;   // 단어가 1일때를 감안해서 초기값 1로 설정
		
		String str = br.readLine();				// 키보드로써 읽어온다

		
		for(int i = 0; i < str.length()/2; i++)			// 단어의 길이의 반만큼 돌린다. 홀수일경우 가운데 글자는 비교 할 필요 없으니 가능
		{
			if(str.charAt(i) != str.charAt(str.length() - i -1 ))	// 비교하기 예시 밑줄 
			{                //단어길이 5  반복회수  2  단어  level  비교 인덱스 번호   01   43
							 //단어길이 4  반복회수  2  단어  noon   비교 인덱스 번호   01   32
				cnt = 0;
				break;
			}
			else {
				cnt = 1;
			}
		}
		System.out.println(cnt);
	
		br.close();
	}

}
