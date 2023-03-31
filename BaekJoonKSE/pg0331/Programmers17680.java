package Programmers.pg0331;

import java.util.LinkedList;

class Programmers17680 {
    public int solution(int cacheSize, String[] cities) {

        int time = 0;

        if (cacheSize > 0) {
            LinkedList<String> list = new LinkedList<>();
            for(String city : cities) {
                String city2 = city.toLowerCase();
                if(list.remove(city2)) { // hit
                    time++;
                } else { // miss
                    time += 5;
                    if(list.size() >= cacheSize) {
                        list.removeLast();
                    }
                }
                list.addFirst(city2);
            }
        } else { // 캐시가 0일때
            time = cities.length * 5;
        }

        return time;
    }
}