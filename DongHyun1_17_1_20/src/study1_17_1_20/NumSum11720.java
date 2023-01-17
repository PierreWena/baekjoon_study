//백준 11720 숫자의 합, 정수를 문자열로 입력받는 문제. 
// Python처럼 정수 크기에 제한이 없다면 상관 없으나, 
// 예제 3은 일반적인 정수 자료형에 담기에 너무 크다는 점에 주목합시다.

package study1_17_1_20;

import java.util.Scanner;					// Scanner 사용을 위해 import

public class NumSum11720 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	// 키보드 입력받기 위해 Scanner

		String str = sc.nextLine();				// 문자열로 몇개의 자리수를 넣을건지 키보드 입력
		
		int num = Integer.parseInt(str);		// 문자열을 정수형으로 대입
		
		String str2 = sc.nextLine();			// 문자열로 num번 자리까지 일일이 키보드로 대입
		
		int num2[] = new int [str2.length()];	// 각 자리의 숫자를 알기 위해 배열 선언 
		
		int sum =0;							// 변수 선언 합계를 저장하기 위해 
		
		for(int i=0; i<num; i++)			// num 번 반복 
		{
			num2[i] = str2.charAt(i)-'0';	// num2에서 각자리를 하나씩 보기위해 설정 -'0'하는 이유는 문자열을 한 단어로 보고 -'0'
											// 하면 자동 int형으로 변경되어서 int형 결과값이 나온다. 
			sum += num2[i];					// 그 결과를 sum에 계속 누적 저장 
			
		}
		System.out.println(sum);			// 출력
		

		sc.close();			// Scanner를 사용하지 않는다는 말이며 메모리 누수 방지함 
	}

}
