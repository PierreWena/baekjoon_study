// 프로그래머스 2단계 [1차] 캐시 문제 입니다.

import java.util.*;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        
       HashMap <String, Integer> Map1 = new HashMap<String, Integer>(); //<타입값(Key), 저장할 곳(Value)>
        int time = 0;           // 시간을 저장할 곳
        
        for(String cities1 : cities) {          // 확장 for문으로 도시 만큼 반복
            
            String str = cities1.toLowerCase();   // 소문자로 변경
              
            // hit일때 containsKey는 키, 값이 포함되었는지 여부 확인 가능
            if(Map1.containsKey(str)){
                time++;              // 1 초 증가
                Map1.put(str, 0);    // hit했으므로 index 0 번에 넣어줌 
            }
            // miss 이라면 
            else {
                time += 5;             // 5초 증가
                Map1.put(str, 0);      // 인덱스 0번에 넣어줌(데이터 추가)
                
                if(Map1.size() > cacheSize){ //캐시가 맵 사이즈보다 작으면
                      // map 에서 가장 큰 요소의 key 
                      String maxKey = Map1.entrySet().stream()      // straem 을 통한 map의 값을 가져오기 
                            .max(Comparator.comparingInt(Map.Entry::getValue)) // 키 값을 통해서 value 추출
                            .get().getKey();
                      Map1.remove(maxKey);         // 시간(value)이 가장 큰 요소 삭제

                }
             
            }
            // map의 각 요소마다 시간(value) 증가
            for (Map.Entry<String, Integer> next : Map1.entrySet()) {
            next.setValue(next.getValue() + 1);
            }
            
        }
        return time;   //시간 리턴
    }
}