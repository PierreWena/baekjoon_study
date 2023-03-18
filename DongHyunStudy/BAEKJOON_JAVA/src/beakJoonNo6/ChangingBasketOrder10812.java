package beakJoonNo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ChangingBasketOrder10812 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
		// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼writer
		// Bufferedwriter 은 sysout을 대체하기 위해 사용 
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄마다 구분함
		
		StringBuilder sb = new StringBuilder();		//스트링빌더를 사용한다.
		
		int N = Integer.parseInt(st.nextToken());			// 테스트할 값들을 받아오자 
		int M = Integer.parseInt(st.nextToken());			// 테스트할 값들을 받아오자 
		int i = 0;											// 변수 선언 
		int j = 0;
		int k = 0;
		int tmp = 0;										// 임시로 저장할 변수 선언 
		int cnt = 0;										
		int space = 0;										// 공백을 나타내기 위해 
		
		int arr_N[] = new int[N];   // 배열 선언
		
		
		for(int z=0; z<N ; z++)  // 배열안에 값 넣어주기
		{
			arr_N[z] = z + 1;
		}
		
		
		for(int x=0; x<M; x++)
		{
			st = new StringTokenizer(br.readLine());	// 한 줄마다 구분함
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			int arr_tmp[] = new int[k-i];   /// 백업할 배열 설정
					
			// 백업
			for(int p=0; p<k-i; p++)
			{
				arr_tmp[p] = arr_N[i-1+p];	
			}
			
			// 나열
			for(int t=0; t<i-1; t++)
			{
				if(x==M-1)								// 마지막일때만 출력
				{
					if(space == 0)						// 공백을 위해 처음만 공백 없음
					{
						sb.append(arr_N[t]);
						space ++;
					}
					else {
						sb.append(" " + arr_N[t]);
					}		
				}	
			}
			
			// 교체
			for(int a=0; a<=j-i; a++)
			{	
				if( a < j-k+1)  							// 배열값을 교체하기 위해 
				{
					tmp = arr_N[i-1+a];						// 임시 변수에 저장하고 
					arr_N[i-1+a] = arr_N[k-1+a];			// 교체
					arr_N[k-1+a] = tmp;						// 임시 변수에서 저장된 값을 저장
					
					if(x==M-1)								// 마지막일때만 출력
					{
						if(space == 0)						// 공백을 위해 처음만 공백 없음
						{
							sb.append(arr_N[i-1+a]);
							space ++;
						}
						else {
							sb.append(" " + arr_N[i-1+a]);
						}
					}
				}
				else 										// 배열값 교체 안하는 부분
				{
					arr_N[a + i - 1] = arr_tmp[cnt++]; 		
					
					if(x==M-1)								// 마지막일때만 출력
					{	
						if(space == 0)						// 공백을 위해 처음만 공백 없음
						{
							sb.append(arr_N[a+i-1]);
							space++;
						}
						else {
							sb.append(" " + arr_N[a+i-1]);
						}	
					}
				}
			}
			cnt = 0;
			
			// 나열
			for(int t=j; t<N; t++)
			{
				if(x==M-1)								// 마지막일때만 출력
				{	
					if(space == 0)						// 공백을 위해 처음만 공백 없음
					{
						sb.append(arr_N[t]);
						space++;
					}
					else {
						sb.append(" " + arr_N[t]);

					}
				}	
			}
			space = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
