package my.own.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class SJH_4344 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		DecimalFormat df = new DecimalFormat("0.000");
		
		for(int i=0; i<C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			int[] arr = new int[N];
			
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			
			int avr = sum/N;
//			System.out.println("평균 : " + avr);
			int cnt = 0;
			
			for(int k=0; k<N; k++) {
//				System.out.println("arr : " + arr[k]);
				if(arr[k]>avr) {
					cnt++;
//					System.out.println("cnt : " + cnt);
				}
			}
			
			double result = Math.round((double)cnt/N*100000)/1000.0;
			
			sb.append(df.format(result));
			sb.append("%\n");
			
		}
		
		System.out.println(sb);

	}

}
