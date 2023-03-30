// 출처 : https://yoon1fe.tistory.com/183
import java.util.*;

class Solution {
    final int HIT = 1;
    final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>(cacheSize);    // 캐시를 리스트로 구현

        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();          // 대소문자 구분을 안하는 조건 때문에 소문자로 바꿔준다
            // hit
            if(cache.contains(city)) {                      // 캐시에 도시이름이 있으면
                answer += HIT;                              // HIT이므로 실행시간에 1(HIT)을 더한다
                cache.remove(city);                         // 캐시 교체 순서 갱신때문에 remove add
                cache.add(city);                            
            }
            // miss
            else {
                answer += MISS;                             // 캐시에 없으면 MISS이므로 실행시간에 5(MISS)를 더한다
                if(cacheSize != 0) {                        // 캐시가 비어있는가         
                    // 캐시가 가득 찬 경우 LRU 알고리즘 사용
                    if(cache.size() == cacheSize) {         // 캐시가 꽉차있으면
                        cache.remove(0);                    // 제일 먼저 캐시에 들어온걸 지운다
                    }              
                    cache.add(city);                        // 캐시가 비어있던 꽉차있던 캐시에 도시이름을 추가한다
                }
            }
        }

        return answer;
    }
}