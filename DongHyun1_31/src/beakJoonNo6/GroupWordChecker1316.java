//백준 1316번 문제 그룹 단어 체커, 조건에 맞는 문자열을 찾는 문제 
package beakJoonNo6;

import java.util.Scanner;

public class GroupWordChecker1316 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);			// Scanner 사용으로 키보드 입력값을 받아올수 있는 준비를 함 
		
		String Str_T = sc.nextLine();					//테스트할 회수를 문자열로 받아온다.
		
		int T = Integer.parseInt(Str_T);				// 테스트할 문자열을 int로 변경
		
		int cnt = 0;									// 초기값 설정
		String Voca[] = new String [T];					// 단어를 받아올 배열설정, T번 반복
		
		cnt = T;							// 문자열개수만큼 초기 cnt설정
		
		for(int i=0;i<T;i++)				// T번 반복
		{
			Voca[i] = sc.nextLine();		// 문자열로 문자를 키보드로부터 입력받음
			char ch[] = Voca[i].toCharArray();		// 단어 문자열을 ch에 한개씩 쪼개서 나타냄
			boolean [] check = new boolean [26];			// 알파벳 배열을 만들어서 이미 체크한 알파벳은 true로 바꿔준다. (boolean 배열의 초기값은 false)
			
			for(int j=0; j<Voca[i].length()-1; j++)	// j를 j문자열보다 1적게 반복한다. 이유는 ch[j+1]로 단어를 비교해줄것이기 때문에
			{
				if(ch[j] != ch[j+1])				// j번과 그 다음단어가 같지 않다면 
				{
					if(check[ch[j+1]-97]==true)		// j+1번재 단어를 true로 바꿔준다. // 이미 한번 체크된 알파벳일 경우 그룹단어가 되지 못하는 점
					{								//-97하는 이유는 j+1을 할경우 자동 int형으로 나오기에 아스키코드상 97은 a
						cnt--;						// 그룹단어가 아니라고 판단 될 경우 초기값인 단어의 수에서 1씩 빼준다.  전체-그룹단어가 아닐경우 = 그룹단어인 경우
						break;						// 그룹단어가 아니라고 판단될 시 즉시 break로 빠져나온다.
													//이것을 없으면 줄시 결과값이 -1,-3 등의 결과가 생길 수 있다. 여러번 반복해서 -1 되기떄문
					}
				}
				check[ch[j]-97]=true;			// 위의 처리가 다 끝났으면 해당 알파벳을 true처리 해주어 다음번에 반복되는경우 제외되도록 처리한다. 
												//-97은 아스키코드로 a가 97이니 -97해주어 a를 0으로 나오게함
			}
		}
		System.out.println(cnt);				//출력
		
		sc.close();
	}
}


// 실패

/*
package beakJoonNo6;

import java.util.Scanner;

public class GroupWordChecker1316 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String Str_T = sc.nextLine();
		
		int T = Integer.parseInt(Str_T);
		
		String str []= new String [T];
		
		int cnt=0;
		int cnt1 = 0;
		int re = 0;
		
		for(int i=0;i<T;i++)
		{
			str[i] = sc.nextLine();
			str[i] = str[i].toLowerCase();
			for(int j =0; j < str[i].length(); j++)
			{
				cnt++;
				char ch [] = str[i].toCharArray();
				//System.out.println(ch[j]);
				if(j+1 < str[i].length())
				{
					if(ch[j] == ch[j+1])
					{
						//System.out.println(cnt+"\t1");
					}
					else 
					{
						//System.out.println(cnt + "<-cnt" +j+"else문 투입 ");
						for(int k=0;k<str[i].length();k++)
						{
							//System.out.println(cnt + "<-cnt" + j+"  "+k+"for문 투입 ");
							if(k != j)
							{
								//System.out.println(ch[j] +"와"+ ch[k]+"는 같지 않음"+j+k);
								if(ch[j] == ch[k])
								{
									re = k;
									cnt = cnt -1 ;
									System.out.println(cnt+"\t2 -1 실행중이다.");
									break;
								}
							}
						}
						if(re != 0)
						{
							break;
						}
					}
					System.out.println(cnt+"<- cnt \t333");
				}
				else
				{
					if(j > 0)
					{
						for(int z=0; z<str[i].length()-1; z++)
						{
							if(ch[i] != ch[z+1])
							{
								if(ch[j] == ch[z])
								{
									cnt = 0;
									System.out.println("j와" + ch[j] + "j-" + ch[j-1] + "은 같습니다.");
								}
							}
							else
							{
								cnt--;
							}
							
						}
						
					}
					/*for(int z = 0; z < T; z++)
					{
						if(str[z].length() == 1)
						{
							cnt++;
							System.out.println("문자열 길이는 1입니다.");
						}
					}
					
					//System.out.println(cnt+"<= cnt 4444\n");
				}
				
				
				//System.out.println(cnt+"<= cnt 555555\n");
				re = 0;
				
			}
			if(cnt != 0)
			{
				cnt1++;
			}
			//System.out.println(cnt1);
			//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~`");
			cnt = 0;
		}
		System.out.println(cnt1);
		sc.close();
	}

}*/
