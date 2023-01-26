package baekjuntest;

import java.util.Scanner;
public class Main11720 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String input = in.next();
		in.close();
		
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += input.charAt(i) - '0';
		}
		System.out.println(sum);
	}

}