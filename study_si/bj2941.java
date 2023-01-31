package my.day01.backjun;

import java.util.Scanner;

public class bj2941 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		sc.close();
		String cro[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		for(String a : cro) { // cro 배열에 있는 String들을 순서대로 꺼낸다  여기서 String a의 a는 cro String하나를 지칭							
							  // 입력한 단어 에 배열에 해당하는 word 가 있다면 replace로 /로 바꿔주어서 cro 안에 해당하는 2자리든 3자리든 모두
							  // 1자리 수인 / 걸로 변경하면 글자수 셀때 1개로 통일 되게한다음 출력
			word = word.replace(a, "/"); 
		}// end of for ----------------------
		System.out.println(word.length());
}//end of main ----------------------------------
}
