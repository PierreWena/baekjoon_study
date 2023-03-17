package my.day01.backjun;

import java.util.Scanner;

public class bj바구니담기 {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt();
	int M = sc.nextInt();
	
	int[] basket = new int[N+1];
	int[] n_basket = new int [N+1];
	
	for(int i=1; i<=N; i++) {
		basket[i] = i;
		n_basket[i] = i;
	}
	
	for(int c=0; c<M; c++) {
		int i =sc.nextInt();
		int j =sc.nextInt();
		int k =sc.nextInt();
		int z = 0;
		for(int num=0; num<j-i+1; num++ ) {// i부터 j 까지 변동이 일어나니까 해당 횟수만큼 반복 
										   // 큰값 j에서 제일작은 i 빼고 +1 해야 반복횟수
			if(k+num<=j) { // 중간부터 끝까지
				n_basket[num+i] = basket[k+num];
			}
			else {// 시작부터 중간 이전까지
				n_basket[num+i] = basket[i+z];
				z++;// 맨앞에서부터 순서대로 복사하기 위해 z++해줌
			}
		}
		for(int a=1; a<=N; a++) {
			basket[a] = n_basket[a]; // 새로운 바구니와 현재 바구니 같게 만들어줌
		}
	}
	
	for(int i=1; i<=N; i++) {
		System.out.print(n_basket[i]+" ");
	}
	

	
	
	}
		
}