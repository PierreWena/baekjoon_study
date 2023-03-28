package baekjuntest;
import java.util.*;
import java.io.*;
	
public class Main10988 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		palindrome(str);
		
	} // End of main
	
	static void palindrome(String str) {	
		int length = str.length();
		
		for(int i=0; i<length/2; i++)	{
			char front = str.charAt(i);
			char back = str.charAt( (length-1)-i );
			
			if(front != back) {
				System.out.println(0);
				return;
			}
		}
	
		System.out.println(1);
		
	} // End of palindrome
} // End of class