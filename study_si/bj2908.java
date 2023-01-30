package my.day01.backjun;

import java.util.Scanner;

public class bj2908 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		a = (a % 10) * 100 + (a % 100 / 10) * 10 + (a / 100);  // 프로그래머 계싼기로 두들기면 거꾸로나옴
		
			
		b = (b % 10) * 100 + (b % 100 / 10) * 10 + (b / 100);
		
		System.out.println(a>b?a:b);
 
 
    }
}
