package backjun;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		String str= sc.nextLine();
		int sum =0;
		for(int i=0; i<n; i++) {
			sum+= str.charAt(i) -'0';
			
		}
		System.out.println(sum);
	}

}
