package baekjuntest;

import java.util.Scanner;
//java.util.Scanner 클래스를 import한다.
public class Main10809 {
//접근제어자 public으로 Main 클래스를 선언한다.

	public static void main(String[] args) {
	// 접근제어자 public으로 메모리에 상주하게 리턴값이 없이 main 함수를 선언
		Scanner in = new Scanner(System.in);
		// Scanner 객체 in 선언
		int n = in.nextInt();
		// int형 변수 n를 선언하고 값을 입력받아 변수에 저장한다.
		String input = in.next();
		// String 객체 input를 선언하고 값을 입력받아 저장한다.
		in.close();
		// 객체 in 사용을 종료한다.
		
		int sum = 0;
		// int 형 변수 result를 선언하고 0으로 초기화한다.
		for (int i = 0; i < n; ++i) {
		// for 문을 선언한다.
			sum += input.charAt(i) - '0';
			// sum + input.charAt(i) - '0'를 연산한다.
		}
		System.out.println(sum);
		// result에 저장된 값을 출력한다.
	}
}