// 백준 11654번 문제 아스키 코드, 아스키 코드에 대해 알아보는 문제 

package study1_17_1_20;

import java.util.Scanner;			// 키보드 사용하기 위해 import

public class ASCIIcode11654 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		//키보드 입력을 받기 위해 Scanner
		
		// 아스키 코드를 입력해서 몇번인지 확인해보자 
		
		String str = sc.nextLine();		// 문자열 을 키보드로부터 받아온다.
		char ch = str.charAt(0);		// 문자열을 쪼개서 본 것중에 index 번호 0번째 부분을 char 형 ch에 저장한다. 
		System.out.println(ch+0);		// ch + 0은 자동으로 int형으로 변경되기 때문에 아스키코드가 나온다.
		
		
		sc.close();		// 메모리 누수 방지를 위해 Scanner 더이상 사용 안함 
	}

}
