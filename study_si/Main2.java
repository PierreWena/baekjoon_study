package study_si;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		sc.close();
		String str="";
		int sum =0;
		for(int i=0; i<n; i++) {
			sum+= str.charAt(i) -'0';
			
		}
		System.out.println(sum);
	}

}
