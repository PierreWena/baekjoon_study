//백준 5622번 문제 다이얼, 규칙에 따라 문자에 대응하는 수를 출력하는 문제

package beakJoonNo6;

import java.util.Scanner;

public class Dialing5622 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);			//키보드로 입력 받기위해 선언
		
		String str = sc.nextLine();					// 문자열로 키보드 값을 받아온다,
		
		str = str.toUpperCase();					// 문자열을 대문자로 변환
		
		char ch []= str.toCharArray();				// 문자열을 char타입 배열로 변횐
		
		int cnt=0;									// 걸린 시간을 나타내기 위해 설정 
		
		if(2<=str.length()&& str.length()<=15)		// 2부터 15단어 길이까지 
		{
			for(int i=0;i<str.length(); i++)		// 문자열 길이만큼 반복
			{
				switch (ch[i]) {					//char타입인 것을 case로 확인해 시간 더함 
				case 'A': case 'B': case 'C':	//2일때 
					cnt += 3;
					break;

				case 'D': case 'E': case 'F':	//3일때 
					cnt += 4;
					break;

				case 'G': case 'H': case 'I':	//4일때 
					cnt += 5;
					break;

				case 'J': case 'K': case 'L':	//5일때 
					cnt += 6;
					break;

				case 'M': case 'N': case 'O':	//6일때 
					cnt += 7;
					break;

				case 'P': case 'Q': case 'R': case 'S':	//7일때 
					cnt += 8;
					break;

				case 'T': case 'U': case 'V':	//8일때 
					cnt += 9;
					break;

				case 'W': case 'X': case 'Y': case 'Z':	//9일때 
					cnt += 10;
					break;
					
				case ' ':		//1일때 
					cnt += 2;
					break;
					
				default:		// 0일때
					cnt += 11;
					break;
				}
			}
		}
		System.out.println(cnt);		//출력
		
		sc.close();						// 스커너 더이상 안쓰므로 메모리 누수 방지 
	}

}
