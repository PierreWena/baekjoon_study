package myalgorithm;

import java.util.Scanner;

public class Main_2675 {  // 2675번 

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();  // 테스트 케이스를 몇개나 할것이냐
		
		
		int R;  // 각 테스트 케이스의 문자? 들을 몇번씩 반복할것이냐.
		
		String S;  // 문자열 s가 공백으로 주어짐
		
		String strSum = "" ;  // 다 돌린 문자들을 문자열 결합으로 다 모아서 출력할 String형 변수
		
		
		for(int i=0; i<T; i++) {  // 시행할 테스트 케이스의 개수만큼 반복문을 돌릴것이기떄문에 첫번쨰 반복문
			
			
			
			
			R = sc.nextInt();
			
			S = sc.nextLine();
			
			
			
		
			
			
			for(int j=0; j<S.length(); j++) { // 각 문자열들의 각 인덱스에 해당하는 하나하나의 문자들을 charAt을 써서 지정하고 그것들을
											  // char형 ch에 넣어주는 두번째 반복문.
				
				char ch = S.charAt(j);  // 
				
				
				
						
					
					for(int k=0; k<R; k++) { // 각 문자들을 R만큼 반복할것이기때문에 3중포문의 3번째.		
											//  R만큼 반복할떄까지 strSum에 문자열결합으로 계속 넣어준다..
						
						strSum +=ch;
						
						
					}// end of for-------------
					
					
			
				
				
				
				
				
				
				
				
				
			} // end of for------------------
			
			
			
			strSum += "\n";  // 입력값 하나하고 답이 출력되는것이 아니라 모두 입력값을 넣은후에	마지막에 한번에 출력되도록하기위함이다.
							 // 각각의 출력값을 한줄을 띄고 최종적으로 T, 테스트케이스의 갯수만큼의 줄로 출력되도록 하기위해서 \n을 한 문자열이	
							// 한 문자열이 끝날때마다 넣어줌으로써 출력준비는 끝이난다
				
			
			
		
			
			
			
			
			
			
			
			
	
			
			
		} // end of for-------------------
		
		
			
		
		
		
		System.out.println(strSum.replace(" ", "")); // 각 문자들의 반복횟수와 입력한 문자열사이의 공백들이 합쳐지는데 이걸없애기위해서
													 // replace 메소드로 마지막에 공백들을 한번에 다없애준다
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end of main---------------------------------------

}
