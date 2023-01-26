//백준 2675문제 문자열반복, 각 문자를 반복하여 출력하는 문제 

package beakJoonNo6;

import java.util.Scanner;			// Scanner 사용을 위해 import

public class StringRepetition2675 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	//Scanner로 키보드 사용 가능하게 
		
		String T = sc.nextLine();				// 테스트 회수 문자열로 받자 
		int Test = Integer.parseInt(T);			// int 로 테스트 회수 변경 
		
		String result = "";						// 결과값 초기화
		
		for(int i =0; i < Test; i++)			// 테스트번 반복
		{
			int num = sc.nextInt();				// 몇번 반복할껀지 키보드로 입력
			String S = sc.nextLine();			// 문자열 입력
			
			for(int j =0; j < S.length(); j++)	// 문자열 길이 만큼 반복
			{
				for(int k=0; k < num; k++)		// 몇번 반복할껀지 숫자를 정한 만큼 반복
				{
					result += S.charAt(j);		// 결과에 인덱스 0부터 몇번 반복후 1...2...3으로 넘어감 즉 문자열 몇번 반복 
				}		
			}
			System.out.println(result.trim());	// 공백 제거 출력 
			result = "";						// 결과값 초기화
		}
	
		sc.close();								//Scanner 사용하지 않으므로 메모리 누수 방지 
	}

}
