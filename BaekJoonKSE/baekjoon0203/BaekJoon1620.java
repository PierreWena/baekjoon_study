package BaekJoonKSE.baekjoon0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class BaekJoon1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {  // 두개의 맵에 각각 포켓몬 이름과 포켓몬 넘버를 교차해서 매핑
            String pokemon = bf.readLine();
            map1.put(pokemon, i);
            map2.put(i, pokemon);
        }

        StringBuilder sb = new StringBuilder(); // 주어진 값이 포켓몬의 이름이면 도감번호를 숫자면 포켓몬의 이름을 출력
        for (int i = 0; i < M; i ++) {
            String quiz = bf.readLine();
            if (Character.isDigit(quiz.charAt(0))) {
                sb.append(map2.get(Integer.parseInt(quiz))).append('\n');
            } else {
                sb.append(map1.get(quiz)).append('\n');
            }
        }
        System.out.println(sb);

    }
}