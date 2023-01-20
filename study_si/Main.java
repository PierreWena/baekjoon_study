package study_si;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char ch =sc.nextLine().charAt(0);    // 스트링으로 입력받은걸 charAt으로 문자로 변환
		int c = (int)ch;  //  int 로 문자에 대응하는 아스키 코드값으로 바꾸기
		
		System.out.println(c);
	}

}