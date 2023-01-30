//백준 2941번 문제 크로아티아 알파벳, 크로아티아 알파벳의 개수를 세는 문제

package beakJoonNo6;

import java.util.Scanner;

public class CroatianAlphabet2941 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);			//키보드로 입력 받기위해 선언
		
		String str = sc.nextLine();					// 문자열로 키보드 값을 받아온다,
		
		str = str.trim().toLowerCase();				// 공백을 지우고 소문자로 표시 
		
		char ch[] = str.toCharArray();				// ch형태로 문자열 한개씩 저장 
		
		int cnt=0;									// 걸린 시간을 나타내기 위해 설정 
		
		if(str.length() <= 100)						// 단어 100개 이하일때 
		{
			for(int i=0;i<str.length(); i++)		// 문자열 길이만큼 반복
			{
				switch (ch[i]) {					// 문자열에서 뽑아온 단어가 
				case 'c':							// c이면 
					cnt++;							// cnt를 증가시킨다.
					if(i+1 == str.length())			// i+1이 문자열 길이와 같다면 
					{
						break;						// 더 추가하지 말고 나가자 
					}
					if(ch[i+1] == '-' || ch[i+1] == '=')	// i+1 번재가 -또는 =이면 
					{
						i++;						// 단어중복을 피하기 위해 i를 1증가시킨다.
					}
					
					break;							// 반복문 탈출!
						
				case 'd':							// d이면 
					cnt++;							// cnt를 증가시킨다.
					if(i+1 == str.length())			// i+1이 문자열 길이와 같다면 
					{
						break;						// 더 추가하지 말고 나가자 
					}
					if(ch[i+1] == '-')				// i+1 번재가 -이면 
					{				
						i++;						// 단어중복을 피하기 위해 i를 1증가시킨다.
					}
					else if(i+2 < str.length()) 	// i+2번째가 길이보다 작으면 실행 
					{
						if(ch[i+1] == 'z')			// i+1 번재가 z이면 
						{
							if(ch[i+2] == '=')		// i+2 번재가 =이면 
							{
								i += 2;				// 단어중복을 피하기 위해 i를 2증가시킨다.
							}
						}
					}
					
					break;							// 반복문 탈출!
					
				case 'l':							// l이면 
					cnt++;							// cnt를 증가시킨다.
					if(i+1 == str.length())			// i+1이 문자열 길이와 같다면 
					{
						break;						// 더 추가하지 말고 나가자 
					}
					if(ch[i+1] == 'j')				// i+1 번재가 j이면 
					{					
						i++;						// 단어중복을 피하기 위해 i를 1증가시킨다.
					}
					
					break;
					
				case 'n':							// n이면 
					cnt++;							// cnt를 증가시킨다.
					if(i+1 == str.length())			// i+1이 문자열 길이와 같다면 
					{
						break;						// 더 추가하지 말고 나가자 
					}
					if(ch[i+1] == 'j')				// i+1 번재가 j이면 
					{				
						i++;						// 단어중복을 피하기 위해 i를 1증가시킨다.
					}
					
					break;
	
				case 's':							// s이면 
					cnt++;							// cnt를 증가시킨다.
					if(i+1 == str.length())			// i+1이 문자열 길이와 같다면 
					{
						break;						// 더 추가하지 말고 나가자 
					}
					if(ch[i+1] == '=')				// i+1 번재가 =이면 
					{				
						i++;						// 단어중복을 피하기 위해 i를 1증가시킨다.
					}
					
					break;
					
				case 'z':							// z이면 
					cnt++;							// cnt를 증가시킨다.
					if(i+1 == str.length())			// i+1이 문자열 길이와 같다면 
					{
						break;						// 더 추가하지 말고 나가자 
					}
					if(ch[i+1] == '=')				// i+1 번재가 =이면 
					{					
						i++;						// 단어중복을 피하기 위해 i를 1증가시킨다.
					}
					
					break;
					
				default:							// 나머지이면  
					
					cnt++;							// cnt를 증가시킨다.
					break;
				}
			}
		}
		
		System.out.println(cnt);		//출력
		
		sc.close();						// 스커너 더이상 안쓰므로 메모리 누수 방지 
	}
}
