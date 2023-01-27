package my.day01.backjun;


import java.util.Scanner;

public class bj2675 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine()); //테스트 케이스의 개수입력
		
		for(int i=0; i<T; i++) {
			int R = Integer.parseInt(sc.nextLine()); //반복횟수R
			String S = sc.nextLine();                //문자열 S입력
			
			for(int j=0; j<S.length(); j++) {        //R =4 S = ABC 넣으면
				for(int a=0; a<R; a++){				 // AAAABBBBCCCC
					
					System.out.print(S.charAt(j));	// charAt으로 나태내준다
				}
			}
			System.out.println();// 각케이스마다 줄바꿈 
		}
	}//end of main()--------------------

}