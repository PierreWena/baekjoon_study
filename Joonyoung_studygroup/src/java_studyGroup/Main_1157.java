package myalgorithm;

import java.util.Scanner;

public class Main_1157 { 

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String inputstr = sc.next().toUpperCase();   // 입력값을 대문자로
		
		
		int[] countAlpha = new int[26];  // 알파벳 26개를 뜻하는 배열 길이 26개 count
		
		
		
		
		for(int i=0; i<inputstr.length(); i++) {
			
			int num = inputstr.charAt(i) - 'A' ;  // 각각의 자리의 알파벳을 A를 빼서 그만큼의 차이를 정수로 넣어둠
			
			
			countAlpha[num]++; //  count[0]은 A ,count[1]은 B , cout[2]는 C.... 식으로 각각의 알파벳을 인덱스로 표현하면서 
						  //  각 알파벳이 문자열에 있을떄마다 count[i]를 증가시켜줌.
			
			
			
			
		}
		
		int max = 0;   // 최대값 정수 max를 0으로 초기화하면서 최대값을 구할려고 한다
		
		char answerChr = '?';  // 일단 정답을 ?로 해두고  
		
		
		for(int i=0; i<countAlpha.length; i++) {
			
			
			if(max < countAlpha[i]) {
				
				max = countAlpha[i];  // 최대값은 count[i]가 가장 많을때의 값이니 해당 count[i]를 max 최대값으로 해둠
				
				answerChr = (char)(i+'A'); // 정답 answer는 그때의 인덱스 i + 문자형 'A'를 합한 아스키코드 알파벳이다.
				
				
				
			}
			
			else if( max == countAlpha[i]) { // 가장 많이 나온 알파벳이 더 있을경우
				
				
				answerChr ='?';   // -2라고 해도 되는듯 하다
				
			}
			
			
			
		} // end of for-----------------------------------
		
		
		System.out.println(answerChr);  // 정답 출력
		
		
	} // end of main------------------------------------------------------------------------

	
	
	//코드 해답 출처: https://jaejong.tistory.com/16
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		
//		
//		String inputStr = sc.next();  // 입력값
//		
//		inputStr = inputStr.toUpperrCase();  // 입력값을 다 소문자로
//		
//		String[] strArr = new String [inputStr.length()];   // 받은 소문자 입력값을 넣어줄 String형 배열
//		
//		String[] str = null;  // strArr 에서 각각의 index에 해당하는 알파벳을 제외한 문자열을 넣을 또 다른배열
//		
//		String answer = "";
//		
//		
//		for(int i=0; i<inputStr.length(); i++) {
//			
//			
//			strArr[i] = String.valueOf(inputStr.charAt(i));  // 입력받은 inputStr을 문자열에 넣어주게끔 한다.
//			
//			
//		
//			
//			
//			
//		}// end of for-----------------------------------------------------------------
//		
//		
//		for(int i=0; i<inputStr.length(); i++) {
//			
//			
//			
//			
//			
//			str[i] = inputStr.replaceAll(strArr[i], "");     // strArr[i] 해당 인덱스에 해당하는 문자를 제외한 문자열을 str[i] 인덱스에 각각 넣어준다.
//			
//			
//			
//			
//			
//			
//			
//		}  // end of for-----------------------------------------------------------------
//		
//		
//		
//		for(int i=0; i<inputStr.length()-1; i++) {
//			
//			if( strArr[i].equals(strArr[i+1])) {
//				
//				
//				continue;
//				
//				
//			}
//			
//			
//			
//			
//			
//			
//			
//			else if(str[i].length() == str[i+1].length()) {  // 해당 문자를 제외한 것들끼리의 길이가 같으면, 즉 문자열에서 해당 문자가 차지하는 숫자가 똑같으니 ?로 출력
//				
//				
//				answer = "?";
//				
//			}
//			
//
//
//			else {
//				
//				
//				answer =    (str[i].length()< str[i+1].length())?  strArr[i] :strArr[i+1]; // 문자를 제외한 길이가 짧다 = 문자가 그만큼 많이있다 라고 할수 있기떄문에 
//				                   															// 각 배열마다의 크기를 비교해서 가장 길이가 짧은 배열의 strArr[i]가 가장 많이 있는 문자다라는 삼항연산자를 작성.
//
//				
//				
//				
//				
//			}
//			
//			
//			
//			
//			
//			
//		} // end of for-----------------------------------------------------------------
//		
//		
//		
//		System.out.println(answer);
		
		
		
		
	
