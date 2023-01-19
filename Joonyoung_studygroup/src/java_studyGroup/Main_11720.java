package java_studyGroup;

import java.util.Scanner;

public class Main_11720 {

	public static void main(String[] args) {  
		Scanner sc = new Scanner(System.in);
		
		int numLength = sc.nextInt();
		String strNum = sc.next();     // nextLine하면  StringIndexOutOfBoundsException 이 나온다
		sc.close();
		
		
		
		int sum =0;
		
		for(int i=0; i<numLength; i++) {
			
			
			
			
			sum += strNum.charAt(i) - '0';  //문자열의 인덱스 번지로 갖고온 문자형을 아스키코드를 이용해 정수로 변환할시 -48이나 -'0' 을 해줘야 한다.
			
		} // end of for--------------
		
		System.out.println(sum);
		
		
		
	}

}
