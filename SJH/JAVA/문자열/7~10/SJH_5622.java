package my.own.quiz.baekjoon;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class SJH_5622 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();						// 문자열 입력받기
		
		int result = 0;
		
		for(int i=0; i<str.length(); i++) {				// 문자열 길이만큼 반복
			
			char ch = str.charAt(i);

			
			if(ch == 'Z')
				ch-=2;
			else if(ch >= 'S')							// PQRS, WXYZ는 4묶음이므로 Z는 -2, S~Y는 -1 해줬음
				ch--;

				
			result += (ch - 'A') / 3 + 3;				// 해당 알파벳에 - 'A'를 하고 3으로 나눈 몫에 +2하면 번호, +3하면 걸리는 시간
		}// end of for
		
		System.out.println(result);						// 결과 출력
		
		sc.close();

	}// end of main()

}
