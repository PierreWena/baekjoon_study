// 백준 2908번 문재 상수, 숫자를 뒤집어서 비교하는 문제

package beakJoonNo6;

import java.util.Scanner;

public class Constant2908 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);			//키보드로 입력 받기위해 선언

		String num1 = sc.next();			// 문자열로 키보드로부터 숫자를 받아온다.
		String num2 = sc.next();
		String Return = "";					// 거꾸로 출력하기 위해 선언
		String Return2 = "";
		
		char[] chrArr = num1.toCharArray();		// char배열에 하나씩 저장 
		char[] chrArr2 = num2.toCharArray();
		for(int j=2;j>-1;j--)					// 2부터 0까지 반복
		{
			Return += chrArr[j];				// 키보드 입력값을 거꾸로 저장 
			Return2 += chrArr2[j];
		}
		int num3 = Integer.parseInt(Return);	// 문자열을 int형으로 변환
		int num4 = Integer.parseInt(Return2);
		if(num3 > num4)							// 첫번째 수가 크면 
		{
			System.out.println(num3);
		}
		else									// 두번째 수가 크면 
		{	
			System.out.println(num4);
		}
		sc.close();								// 스커너 더이상 안쓰므로 메모리 누수 방지 
	}

}
