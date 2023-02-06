package brakJoonNo13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCard_2_10816 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
			// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼writer
			// Bufferedwriter 은 sysout을 대체하기 위해 사용 
			
			int N = Integer.parseInt(br.readLine());			// 테스트할 값들을 받아오자 
			
			HashMap <Integer , Integer> Map = new HashMap<Integer, Integer>(); //HashMap<타입, 타입>
			
			StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄마다 구분함
			
			StringBuilder sb = new StringBuilder();		//스트링빌더를 사용한다.
			
			for(int i = 0; i < N; i++)						// N개 만큼 반복
			{
				int A = Integer.parseInt(st.nextToken());			// 받아온 값을 공백 기준 하나씩 잘라본다.
				
				Map.put(A, Map.getOrDefault(A, 0) + 1);  // +1 값이 있다는 것을 표현하기 위해 
				// getOrDefault 는 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본값을 반환하는 메서드
				// getorDefault(Object key, V DefaultValue)
				// map.put(A는 키, A의 값이 존재하면 A의 값을 넣어줌, 없으면 기본인 0
				// 앞에 값이 동일한 것이 없는 경우에는 1로 통일하고 앞에 값이 있는 만큼 +1을 해준다
				// 이 문제에서 10이 3번 나오므로 첫번째는 1, 두번째는 2, 세번째는 3이므로 
				// 3을 저장한다.
			}
			
			
			int M = Integer.parseInt(br.readLine());				// 테스트할 값들을 받아오자 
			
			st = new StringTokenizer(br.readLine());				// 한 줄마다 구분함
			
			
			for(int i = 0; i < M; i++)								// N개 만큼 반복
			{
				int num2 = Integer.parseInt(st.nextToken());				// 받아온 값을 공백 기준 하나씩 잘라본다.		
				
				int result = Map.getOrDefault(num2, 0);
				// map.getorDefault에 1을 제외한 저장된 값이 있다면 출력하고 1이면 0으로 반환 
				
				sb.append(result+ " ");		//스트링 빌더 쌓는다.
				
			}
			bw.write(sb.toString());		//문자열로 출력 
			bw.close();
			br.close();	
		} 
		catch (NumberFormatException e) {				// 오류 잡기 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


/*    시간 초과 
public class NumberCard_2_10816 {

public static void main(String[] args) {
	
	try {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
		// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼writer
		// Bufferedwriter 은 sysout을 대체하기 위해 사용 
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		HashMap <Integer , Integer> Map = new HashMap<Integer, Integer>(); //HashMap<타입, 타입>
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄마다 구분함
		
		StringBuilder sb = new StringBuilder();		//스트링빌더를 사용한다.
		
		for(int i = 0; i < N; i++)						// N개 만큼 반복
		{
			int A = Integer.parseInt(st.nextToken());
			Map.put(A, Map.getOrDefault(A, 0) + 1);
			// getOrDefault 는 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본값을 반환하는 메서드
			// getorDefault(Object key, V DefaultValue)
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < M; i++)						// N개 만큼 반복
		{
			int num2 = Integer.parseInt(st.nextToken());
			if(Map.get(num2) == null)
			{
				sb.append("0"+" ");
			}
			else
			{		
				for(int j=0; j< Map.get(num2); j++)
				{
					cnt++;
				}
				sb.append(cnt+" ");
				cnt = 0;
				
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
		
		
		
	} 
	catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}
*/

/*   남들이 풀어본것 


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> cards = new HashMap<>(N);

        String[] card = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int val = cards.get(card[i]) == null ? 1 : cards.get(card[i]) + 1;
            cards.put(card[i], val);
        }

        int M = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        for (int i = 0; i< M; i++) {
            sb.append(cards.get(in[i]) == null ? 0 : cards.get(in[i]));
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
*/