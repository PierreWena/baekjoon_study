package myalgorithm;






import java.util.Scanner;

public class Main_10816 {

	public static void main(String[] args) {
		
		
		// 참고: https://mishuni.tistory.com/
		
		
		Scanner sc = new Scanner(System.in);
		
		int[] numCard = new int[20000001]; 
		
		StringBuilder str = new StringBuilder();
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			
			
			++numCard[sc.nextInt() + 10000000];  // 입력한 정수를 정해진 범위내에서의 지정 배열 인덱스에 넣고 그 입력값이 중복되면 그만큼 계속 증가시켜준다.
			
			
			
		}
		
		int M = sc.nextInt(); 
		
		
		for(int i=0; i<M; i++) {
			
			
			str.append(numCard[sc.nextInt() + 10000000] + " ");  // 그 해당하는 배열의 정수를 내가 입력한값과 같다면 나오게끔 StringBuilder에 넣어줘서 출력할수있게끔한다
			
			
			
		}
		
		
		System.out.println(str.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int N = sc.nextInt();
		 * 
		 * Map<Integer,Integer>hash = new HashMap<>();
		 * 
		 * for(int i=0; i<N; i++) {
		 * 
		 * 
		 * hash.put(i, sc.nextInt());
		 * 
		 * 
		 * 
		 * } // end of for-----------------
		 * 
		 * 
		 * int M = sc.nextInt();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * for(int i=0; i<M; i++) {
		 * 
		 * 
		 * int count = 0;
		 * 
		 * int A = sc.nextInt();
		 * 
		 * 
		 * for(int j=0; j<N; j++) {
		 * 
		 * 
		 * if( hash.get(j) == A ) {
		 * 
		 * 
		 * count++;
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }// end of for-----------------------------
		 * 
		 * sb.append(count + " ");
		 * 
		 * 
		 * }// end of for---------------------------
		 * 
		 * 
		 * 
		 * System.out.println(sb.toString());
		 */
		// 내껀 시간 초과
		
	} // end of main-----------------------------

}
