package myalgorithm;

import java.util.*;

public class Main_14425 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		
		sc.nextLine();
		
		String[] strArr = new String[M];
		
		
		
		Map<String, Integer> S = new HashMap<String ,Integer>();
		
		
		int count =0;
		
		for(int i=0; i<N; i++) {
			
			
			S.put(sc.nextLine(), 1);  // hashmap  집합 S에 N번 반복하면서 정수입력
			
		}
		
		
		
		for(int i=0; i<M; i++) {
			
			
			strArr[i] = sc.nextLine();    // 검사할 문자열들 M번 반복하면서 입력해준다
			
		}
		
		
		
		for(int i=0; i<M; i++) {
			
			
			if( S.get(strArr[i])  != null ) {    //  S에 strArr[i]의 값이 있으면 count를 증가
				
				
				count++;
				
			}
			
			
			else {						// 안해도 된다
				
				
				continue;
				
			}
			
			
			
			
		} // end of for-----------------------------------
		// 참고 : https://velog.io/@sukong/JS-Map%EA%B3%BC-Set
		
		
		
		
		
		System.out.println(count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt() , M = sc.nextInt();
		
		
		sc.nextLine();
		
		Map<String,Integer> S = new HashMap<String,Integer> ();
		
		
		Map<String,Integer> M_str = new HashMap<String,Integer> ();
		
		
		int cnt = 0;
		
		
		for(int i=0; i<N;  i++) {
			
			S.put(sc.nextLine(), 1);
			
			
			
		}// end of for--------------------------------------------------------
		
		
		
		for(int i=0; i<M; i++) {
			
			
			M_str.put(sc.nextLine(), 1);
			
			
			
			for(int j=0; j<N; j++ ) {
				
				
		   
					if (  S.get(j).equals(  M_str.get(i)   )   ){
						
						
						cnt ++;
						
						
						
						
					}
					
					else {
						
						
						
						continue;
					}
			
			}// end of for---------------------------
			
			
			
		 } // end of for---------------------------------
			
		
		
		System.out.println(cnt);
		
	*/		
// => 처음에는 4개가 나와야 되는게 포함된 문자갯수를 읽어오질 못해서 3개가뜨게 되어서 이렇게 코딩을 아예  바꾸니 널포인터 익셉션뜸 	(내풀이)		
		
		
		
		} // end of main()--------------------------------------
		
		
		
		
		
		
		
		
		
	}


