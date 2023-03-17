package my.own.quiz.baekjoon;

import java.util.Scanner;

public class SJH_10812 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		
		// 바구니 배열 만들기
		int[] arr = new int[N];
		
		for(int i=0; i<N;i++) {
			arr[i] = i+1;
		}
		
		// 결과값으로 쓸 바구니 배열 만들기
		int[] result_arr = new int[N];
		
		for(int i=0; i<N;i++) {
			result_arr[i] = i+1;
		}
		
		
		// i j k 입력받기
		for(int rot=0; rot<M; rot++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			// 바구니 배열에서 빼올 인덱스 값(get), 결과값 배열에 넣을 인덱스 값(put)
			int put = i-1;
			int get = k-1;
			

			while(get<j) { // 중간값부터 끝값까지를 첫위치부터 넣는다
				result_arr[put++] = arr[get++];
			}
			
			get = i-1;		// get 값을 첫값으로 바꾸기
			
			while(get<k-1) { // 첫값부터 중간값-1까지를 넣는다
				result_arr[put++] = arr[get++];
			}
			
			// 바구니를 한번 다 바꿨으므로 중간저장
			for(int num=0; num<N; num++) {
				arr[num]=result_arr[num];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			sb.append(result_arr[i] + " ");
		}
		
		System.out.println(sb.toString());
		
		sc.close();
		
	}

}
