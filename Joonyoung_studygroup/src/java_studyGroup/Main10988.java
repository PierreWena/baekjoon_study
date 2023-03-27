package myalgorithm;

import java.util.Scanner;

public class Main10988 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		
		String compare = "";
		
		
		for(int i=1; i<=word.length(); i++) {
			
			
			compare += word.charAt(word.length()-i); // charAt에 인덱스를 넣을떄 해당 인덱스는 음수값이 절대 들어갈수가없다. 따라서 뒤에서 부터 세줄때에는 길이-1부터 시작해서 charAt에 넣어줘야 거꾸로 읽어올수있다.
			
			
		}
		
		
		if(compare.equals(word)) {
			
			System.out.println(1);
		}
		
		else {
			
			System.out.println(0);
		}
		
	}

}
