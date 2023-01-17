// 백준 1330번 문제

package study01;

import java.util.Scanner;

public class Comparison {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);   //키보드로부터 출력 받아오기 
		
		int A = sc.nextInt();    //A에 키보드로 불러온 정수값 받아오기
		
		int B = sc.nextInt();    //B에 키보드로 불러온 정수값 받아오기
		
	
		if(A > B)			     //A가 B보다 클때
		{
			System.out.println(">");
		}
		else if (A < B)			 //B가 A보다 클때
		{
			System.out.println("<");
		}
		else					//A가 B랑 같을때
		{
			System.out.println("==");
		}
		
		sc.close();			//메모리 누수 방지 

	}

}