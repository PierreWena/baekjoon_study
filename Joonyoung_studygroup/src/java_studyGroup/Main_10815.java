package myalgorithm;

import java.util.*;

public class Main_10815 {

	public static void main(String[] args) { 
		
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		
		Map<Integer, Integer>card = new HashMap<Integer, Integer>(); // 카드를 아예 해쉬맵으로 만들어버림
		
		
		
		
		
		
		
		for(int i=0; i<N; i++) {
			
			
			card.put(sc.nextInt(), 1); // 입력한 정수 N번의 시행동안 카드에 정수들을 계속 입력함
			
			
		}
		
		int M = sc.nextInt();
		
		
		for(int i=0; i<M; i++) {
			
			
			if(   card.get(sc.nextInt()) !=  null      ) {  // N번의 시행동안 정수를 입력하고 그 입력한 정수들이 이미 만들어놓은 해쉬맵 card에 있는지 get으로 불러오고
															// 그 값이 null이 아니면 즉 있으면
				
				System.out.print("1 ");		// 있다고 1찍음
				
				
			}
			
			

			else  {
			
				System.out.print("0 ");  // 없으면 0찍음
				
				
			}
	
	
		}
	
	
		
	
	
		//출처 : https://main.tistory.com/221
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		int[] cardNum = new int[N];
		
		
		
		
		for(int i =0; i<N; i++) {
			
			
			cardNum[i] = sc.nextInt();
	
			
		} // end of for-----------------------

		
		int M = sc.nextInt();
		
		int[]numArr = new int[M];
		
		for(int i=0; i<M; i++ ) {
			
			
			numArr[i] = sc.nextInt();
			
			
		}
		
		
		/////////////////////////////////////////////////
		
		
		boolean checkNum = false;
		
		
		
		for(int i=0; i<M; i++)   {
			
			
			
			for(int j=0; j<N; j++) {
				
				
				if(  numArr[i] == cardNum[j]  ) {
					
					
					
					
					
					checkNum = true;
					
					break;
					
					
				}
				
				
				else {
					
					checkNum = false;
					
					continue;
					
					
				}
				
				
				
			} // end of for-------------------------------------
				
				
			
			if(checkNum)
				
				sb.append(1 + " ");
			
			else if(!checkNum)
				
				sb.append(0 + " ");
		
		
		}// end of for----------------------
		
		
		System.out.println(sb.toString());
*/		
		
	} // end of main-------------------------------- // 시간 초과 (내풀이)

}
