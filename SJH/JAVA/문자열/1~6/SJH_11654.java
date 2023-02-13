package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_11654 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		char ch = str.charAt(0);
		
		StringBuilder sb = new StringBuilder();
		sb.append((int)ch);
		System.out.println(sb);
		sc.close();

	}

}
