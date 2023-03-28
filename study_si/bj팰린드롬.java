package my.day01.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj팰린드롬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringBuffer sb = new StringBuffer(str);
		String reversed_str = sb.reverse().toString();

		if (str.equals(reversed_str)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}
