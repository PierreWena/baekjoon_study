package myalgorithm;

// 해답 출처: https://marrrang.tistory.com/59

//문제출처 :  https://school.programmers.co.kr/learn/courses/30/lessons/17680

import java.util.*;

public class Main_1chaCash {

	
		
		
		
		
//		public int solution(int cacheSize, String[] cities) {
//			
//			if(cacheSize == 0) {
//				
//				return cities.length * 5;
//			}
//			
//			
//			int answer = 0;
//			
//			List<String>ctList = new ArrayList<>();
//			
//			for(String city: cities) {
//				
//				city = city.toLowerCase();
//				
//				if(ctList.contains(city)) { // 캐시에 포함된 도시일경우
//					
//					ctList.remove(0);  // 처음 꺼를 삭제하고
//					ctList.add(city);  // 마지막에 넣어준다. 참조했으니까
//					
//					
//					answer += 1; // 점수증가
//				}
//				
//				
//				else {
//					
//					if(ctList.size() == cacheSize ) {
//						
//						ctList.remove(0);
//						
//					}
//					
//					ctList.add(city);
//					
//					answer += 5;
//					
//				}
//				
//				
//				
//				
//			}
//			
//			
//			
//			
//			
//			
//			
//			return answer;
//			
//		}
	
	
	
	
	public int solution(int cacheSize, String[] cities) {
		
		if(cacheSize==0) {
			
			return cities.length * 5;
			
		}
		
		
		int answer = 0;
		
		List<String>ctList = new ArrayList<>();
		
		for(String city: cities) {
			
			city = city.toLowerCase();
			
			if(ctList.contains(city)) {
				
				ctList.remove(city);
				ctList.add(city);
				
				answer += 1;
			}
			
			
			else {
				
				if(ctList.size() == cacheSize) {
					
					ctList.remove(0);
				}
				
				
				ctList.add(city);
				
				answer +=5;
			}
			
			
		}
		
		
		
			
			return answer;
		
	}
		
		
		
		
		
		
		
		public static void main(String[] args) { // main 메소드
			
			Scanner sc = new Scanner(System.in);
			
			
			Main_1chaCash cash = new Main_1chaCash();
			
			int a = sc.nextInt();
			
			int N = sc.nextInt(); 	
			
			sc.nextLine();
			
			String[] cities = new String[N];
			
			
			for(int i=0; i<N; i++) {
				
				cities[i] = sc.nextLine();
				
			}
			
			
			int time = cash.solution(a, cities);
			
			
			
			
			System.out.println(time);
			
			
		}
	


		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	Scanner sc = new Scanner(System.in);
		
		int cacheSize = sc.nextInt();
		
		String[]csArr = new String[cacheSize];
		
		int N = sc.nextInt();
		
		sc.nextLine();
		
		int cnt =0;
		

		
		String[]cities = new String[N]; 
		
		
		
		for(int i=0; i<N; i++) {
			
			cities[i] = sc.nextLine();
			
			
			if(cacheSize == 0) { // 캐시사이즈가 0이면 들어가는 모든값들이 cache miss가 되는꼴이다.
				
				cnt +=5;
				
			}
			
			
			else if(i < cacheSize) { // 처음 도시들을 넣을때, 즉 cache hit
				
				csArr[i] = 	cities[i];
				
				cnt += 5;
				
			}
			
			else if (i >= cacheSize) { 
				
				
				
				
				
				for(int j=0; j<cacheSize; j++) {
					
				
					if(cities[i].equalsIgnoreCase(csArr[j])) { // cache hit
						
						
						cnt ++;
						
					}
					
					
					else {   // cache miss
						
						csArr[i%cacheSize] = cities[i];  
						
						cnt +=5;
						
						break;
						
					}
					
					
				} // end of for---------------------
				
				
				
				
				
		
				
				
				
			}
				
				
				
				
				
			
			
		} // end of for-------------------
		
		
		
		System.out.println(cnt);
		
		*/
		

	
	
	


}
