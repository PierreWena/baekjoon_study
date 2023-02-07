package myalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main_1764 {  // https://chobo24.tistory.com/ 참고 

	public static void main(String[] args) throws IOException  {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		
		HashMap<String, Integer>hashMap = new HashMap<>();  // 듣도못한 사람들
		
		ArrayList<String>arrList = new ArrayList<>(); // 듣도 보도 못한 사람들의 총 인원
		
		
		
		String sum = "";
		
		
		for(int i = 0; i<N; i++) {
			
			
			hashMap.put(br.readLine(), i);
			
			
			
			
		} //end of for----------------------
		
		
		for(int i=0; i<M; i++) {
			
			
			String str = br.readLine();
			
			
			if(   hashMap.get(str)  != null) {
				
				
				
				arrList.add(str);
				
				
				
				
			}
			
			
		}//end of for----------------------
		
		
		Collections.sort(arrList);
		
		
		
		for(String strArr : arrList) {
			
			
			
			sum += strArr + "\n";
			
			
			
			
		}
		
		
		System.out.println(arrList.size()+ "\n" + sum   );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Map<String,Integer>hash = new HashMap<>();
//		
//		
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		int N = Integer.parseInt(st.nextToken());
//		
//		int M = Integer.parseInt(st.nextToken());
//		
//		
//		
//		
//		
//		int cnt = 0;
//		
//		String strSum = "";
//		
//		
//		for(int i=0; i<N; i++) {
//			
//			hash.put(br.readLine(), i);
//			
//			
//		} // end of for----------------
//		
//		
//		
//		List<String>keySet = new ArrayList<>(hash.keySet()); // 해쉬맵을 키값을 기준으로 정렬하는 방법
//		
//		keySet.sort(String ::compareTo); // 해쉬맵을 키값을 기준으로 정렬하는 방법
//		
//		
//		for(int i=0; i<M; i++) {
//			
//			String noSee = br.readLine();
//			
//			if(  hash.get(noSee) !=  null   ) { // 해쉬맵에 입력한 문자열을 너헜을떄의 index가 null이 아니면
//				
//				cnt++;
//				
//				
//				
//				
//					
//				strSum += noSee + "\n";
//					
//				
//				
//				
//				
//				
//				
//				
//			}
//			
//			
//			
//			
//		} // end of for------------------------------
//		
//		
//		
//		System.out.println(cnt + "\n" + strSum);    // 콜레션을 정렬하는과정에서 해쉬맵을 정렬하다가 오류가 나며, 시간초과가 계속떠서 포기
		
		

	}// end of main------------------------------------  

}
