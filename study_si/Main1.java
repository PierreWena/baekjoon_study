package study_si;
import java.util.Scanner;
public class Main1 {


	

		public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(char i='a'; i<='z'; i++) {
			sb.append(S.indexOf(i) + " ");
		}
		System.out.println(sb.toString());
		}
	}