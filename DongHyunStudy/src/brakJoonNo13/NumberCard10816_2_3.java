// 백준 10815 문제 숫자 카드, 카드의 집합을 만들어 특정 카드가 집합에 있는지 빠르게 찾는 문제

package brakJoonNo13;

import java.io.*;
import java.util.*;


public class NumberCard10816_2_3 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
		// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼writer
		// Bufferedwritwe 은 sysout을 대체하기 위해 사용 
		
		try {
			int N = Integer.parseInt(br.readLine());		//br.readLine은 String 타입으로 int형으로 바꾼다.
			int aArr [] = new int [N];						// 배열 설정
			
			StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄마다 구분함
			
			for(int i = 0; i < N; i++)						// N개 만큼 반복
			{
				aArr[i] = Integer.parseInt(st.nextToken());		// 원래 nextToken 은 String타입이지만 int형으로 변경하기위해 사용
			}													// nextToken 은 StringTokenizer에서 구분한 것마다 넣어주는것
																// 객체에서 다음 토큰을 반환
			
			/////////////!!!!!!!!!!!!!!!!!!!!!!!!!///////////////
			Arrays.sort(aArr);  	// 숫자를 오름차순으로 정렬 시키는 것!
			
			int M = Integer.parseInt(br.readLine());	//br.readLine은 String 타입으로 int형으로 바꾼다.
			
			StringBuilder sb = new StringBuilder();		//스트링빌더를 사용한다.
			
			st = new StringTokenizer(br.readLine());	// 한 줄마다 구분함
			
			
			for(int i = 0; i < M; i++)					//M번 만큼 반복
			{
				// 여기서는 이진 탐색을 사용해야 한다. 
				// 이진 탐색의 개념은 다음과 같다.
				// https://velog.io/@delmasong/Algorithm-Binary-Search
				// https://yoongrammer.tistory.com/75
				
				int num = Integer.parseInt(st.nextToken());		// 원래 nextToken 은 String타입이지만 int형으로 변경하기위해 사용
				int A = 0;										// A은 N개가 0으로 최소부터 
				int B = N-1;									// B는 N-1 개가 최대 
																
				while(A <= B)									// 최대가 최소보다 같거나 크면 반복
				{
					// 이진 탐색 , 중간값을 비교해서 계속 찾는 값을 찾도록 반복회수를 줄인다.
					int mid = (A + B)/2;						// 최소 + 최대 /2 는 중간값
					
					if(aArr[mid] == num)						// 순서대로 나열한 배열의 가운데와 입력된 것이 같다면 
					{
						sb.append(1 + " ");						// 1을 넣고 " "를 스트링빌더에 넣는다.
						break;									// 탈출 
					}
					else if(aArr[mid] > num)					// 중간값이 입력값보다 크다면 
					{
						B = mid - 1;							// 최대값을 중간값 -1로 설정 
					}
					else										// 중간값이 입력값보다 작다면 
					{
						A = mid + 1;							// 최소값을 중간값 +1로 실행 
					}
					if(A > B)									// 최소값이 최대값보다 크다면 
					{											// 찾는 수가 없다는 뜻이므로 
						sb.append(0 + " ");						// 0과 " " 을 스트링 빌드에 대입 
						break;									// 탈출 
					}
				}
				//sb.append(binarySearch(aArr, num));				// binarySearch 은 이분타색을 해주는것이다.
			}														// binarySearch 처음 aArr 와 num 을 비교한다.
			
			bw.write(sb.toString());						// 출력하기 위해 
			bw.flush();										// 출력하기위해 
			br.close();										// 메모리 누수 방지 
			bw.close();
			
		} 
		catch (NumberFormatException e) {					//에러를 잡기위해 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
		
//                   ==> 시간초과  <===
		
		/*
		System.out.println("시작");
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 상근이가 가지고 있는 숫자 카드의 개수 
		int num [] = new int [N];
		
		for(int i=0;i<N;i++)
		{
			num[i] = sc.nextInt();
		}
		
		int M = sc.nextInt(); 		// 정수 M개의 숫자 카드 
		int num2 [] = new int [M];
		int result = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++)
		{
			num2[i] = sc.nextInt();
			for(int j = 0; j < N; j++)
			{
				if(num2[i] == num[j])
				{
					result = 1;
					break;
				}
				else
				{
					result = 0;
				}
			}
			sb.append(result + " ");
		}
		
		System.out.println(sb.toString());

		sc.close();
		
	}

}
*/