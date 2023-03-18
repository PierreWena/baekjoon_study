// 백준 2444번 문제 별찍기 -7 🌟

package beakJoonNo6;

import java.util.Scanner;			// 키보드 사용하기 위해 import

public class star2444 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		//키보드 입력을 받기 위해 Scanner
		
		int T = sc.nextInt();
		int cnt = 2;
		
		for (int i = 0 ; i < T*2-1; i++)	// T*2-1번 즉 10번 돌아가도록 반복
		{	
			if(i < T)
			{
				for(int j = i; j < T; j++)		// j가 i번 부터 테스트 T번까지 반복한다. ex) i =0이면 j도 0으로 들어가 5번 반복한다.
												// i = 1이면 j도 1이 들어가 4번 반복한다. 
				{	
					if(j != T-1) 				// 만약 j가 T-1번과 다르다면 실행한다. 즉 j 반복문이 마지막부분이 아니라면 실행한다는 뜻이다.
					{
						System.out.print(" ");		// 공백을 찍는다.  , 만약 j = T-1이 아니라면 T-1까지 j 반복문 마지막까지 싱행될것이다.
					}
					else						// j 반복문이 마지막 반복을 실행하고 있을때 실행한다. 즉 j = T-1 일때 실행한다.
					{
						for(int k = 0; k <= 2*i ; k++){		
							System.out.print("*");		// 별을 찍는다.
						}
					}
					
				}
			}
			else 
			{
				for(int z = 0; z < i-T+1; z++)	// i가 늘어날수록 반복회수가 많아짐
				{								
					System.out.print(" ");		// 별을 찍는다.
				}

				for(int k = T*2-1-cnt ; k > 0 ; k--){		// 별이 2개씩 빠지니까 반복할때마다 2개씩 빼줌

					System.out.print("*");		// 별을 찍는다.
				}

				cnt = cnt + 2; 
			}

			System.out.print("\n");			// 줄바꿈
		}
		sc.close();  //메모리 누수 방지 
	}
}