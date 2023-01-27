package my.day01.backjun;

import java.util.Scanner;

public class bj1157 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); // 단어를 입력받고
		str.toUpperCase(); // 대문자로 바꿈
		
		int max = 0; // 최대빈도수
		char alphabet = 0; // 최대빈도문자
		
		int cnt[] = new int[26]; //알파벳의 빈도가 저장될 배열, 알파벳은 총 26개
		
		for(int i=0; i<str.length(); i++) {
			cnt[str.charAt(i)- 'A']++; //0~25 index에 해당 알파벳이 나타나면 개수를 증가시키나.
									   // 여기서 -'A' 를 한이유는 int 형으로 저장시키기 위하여소문자로 변경했었으면 -'a'
			if( max < cnt[str.charAt(i)-'A']) {//max 보다 더 많이 나온 알파벳이 있다면
				max = cnt[str.charAt(i)-'A'];  //그 알파벳이 새롭게 max가 되고
				alphabet = str.charAt(i);  	   // 그알파벳이 최대빈도문자 alphabet이 된다.
			}
			else if( max==cnt[str.charAt(i)-'A']) { // 동일 최대 빈도 숫자가 있다면
				alphabet = '?';						// alphabet은 ?로 출력
			}
		}//end of for ---------
		
		System.out.println(alphabet); // for문나와서 출력
	}//end of main()--------------------

}

