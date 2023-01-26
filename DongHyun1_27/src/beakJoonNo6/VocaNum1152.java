//백준 1152번 문제 단어의 개수 , 단어의 개수를 구하는 문제 

package beakJoonNo6;

import java.util.Scanner;

public class VocaNum1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	//Scanner 로 키보드 입력을 받기위해 

		String Voca = sc.nextLine();		// Voca에 문자열타입으로 키보드에서 받아온다.
		
		int cnt = 0;						//카운트 변수 설정
		String str;							// 문자열 변수 설정
			
		str = Voca.trim();					//Voca에서 앞,뒤 공백을 제거 
		
		if(str.length() == 0)				// Voca에서 앞, 뒤 공백 지운 문자열 길이가 0이라면 (공백만 나오면 길이 0)
		{
			System.out.println("0");		// 0 출력
			System.exit(0);					//프로그램 종료
		}
		
		for(int i=0; i< str.length(); i++)	//반복문 문자열 길이만큼 반복
		{
			if(str.charAt(i) == ' ')		//i번째가 공백일때 
			{
				if(str.charAt(i+1) != ' ')	// i+1번째가 또 공백이 아니라면  
				{
					cnt++;					//카운트를 올린다.
				}
			}
		}
		
		System.out.println(cnt+1);			//출력 하고 공백개수보다 문자단어가 한개 더 많기 때문에 +1을 해준다.
		
		sc.close();							//키보드 입력 더이상 안쓰니 메모리 누수 방지 
	}	// end of public static void main(String[] args) 

}



/*
package beakJoonNo6;

import java.util.Scanner;

public class VocaNum1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		

		String Voca = sc.nextLine();
		
		Voca = Voca.trim();
		
		//System.out.println(Voca);
		
		String str_arr[] = Voca.split(" ");
		
		if(str_arr[0].equals("")) 
		{
			System.out.println(0);
		}
		else 
		{
			System.out.println(str_arr.length);
		}
		
		
		sc.close();
	}	// end of public static void main(String[] args) 

}*/

