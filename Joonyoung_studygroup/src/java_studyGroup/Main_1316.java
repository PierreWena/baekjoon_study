package myalgorithm;

import java.util.Scanner;

public class Main_1316 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		
		
		
		int count =0;
		
		
		for(int i=0; i<N; i++) {
			
			String inputStr = sc.nextLine();
			
			char[] chArr = null;
			
			
			for(int j=0; j<inputStr.length(); j++) {
				
				
			
					chArr[j] = inputStr.charAt(j); // 입력값의 각 자릿값을 char형 배열에넣어줌
					
					
					
					
					
					
			
			} // end of for----------------------
			
			
			boolean isWord = false;  // 그룹단어인지 아닌지 판별하는  isWord
			
			for(int k=0; k<chArr.length-2; k++) {
				
				
				
				
				if(chArr[k] == chArr[k+1] || chArr[k+1] == chArr[k+2]   ) { // 연속하는 두 자리가 같다면 isWord는 true
					
					
					isWord = true;
					
					
				}
				
				
				
				else if(chArr[k] != chArr[k+1] && chArr[k+1] != chArr[k+2] && chArr[k] == chArr[k+2] ) { // 반복문을 돌렸을떄의 처음자리와 두번쨰자리가 다르고 	
																										//두번쨰와 세번쨰 자리가 다르고 첫번쨰와 세번쨰 자리가 같으면 그건 false
				
				
					isWord = false;
				
				}
				
			
				else { // 이 외의 것은 어차피 false다
					
					isWord = false;
				}
				
			} // end of for------------------------------------------
			
			
			
			if(isWord) 
				count++;
			
			
			
			
			
			
			
			
		} // end of for----------------------------
		
		
		
		
		System.out.println(count);  // ^^ 널 포인터 익셉션 ^^
		
		
		
	} // end of main-----------------------------------------

}
