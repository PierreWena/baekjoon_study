package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_2941 {
	
	public static void main (String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int cnt = 0;
		
		for(int i=0; i<str.length(); i++) {								// 문자열 길이만큼 반복
			
			char ch = str.charAt(i);
			
			if( i>0 && (ch == '-' || ch == '=' || ch == 'j') ) {		// 첫글자 제외 -, =, j 발견했을때
				System.out.println(str.substring(i-1, i+1));
				switch (str.substring(i-1, i+1)) {						// 2글자가
				case "c=":												// 크로아티아 알파벳이라면
				case "c-":
				case "d-":
				case "lj":
				case "nj":
				case "s=":
					cnt -= 1;											// 2개가 1글자이므로 1을 빼준다
					break;

				case "z=":												// z=일때
					if( i>1 && "dz=".equals(str.substring(i-2, i+1)) )	// 세글자가 존재하고 (i>1) dz=라면
						cnt -= 2;										// dz=가 1개이므로 2를 빼준다
					else
						cnt -= 1;
					break;
					
				default:
					break;
				}// end of switch
				
				
				
			}// end of if
			
			cnt++;											// 문자 갯수 1개 추가
			
			
			
		}// end of for
		
		System.out.println(cnt);
	
		sc.close();
	
	}// end of main
}
