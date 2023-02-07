package BaekJoonKSE.baekjoon0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class BaekJoon10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        Map<Integer, Integer> word = new HashMap<>();

        for (int i = 0; i < N; i++) {  //맵에다 숫자 카운트하며 집어넣기
            int tmp = Integer.parseInt(st.nextToken());
            if (word.containsKey(tmp)) {
                word.put(tmp, word.get(tmp) + 1);
            } else {
                word.put(tmp, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (word.containsKey(tmp)) {
                sb.append(word.get(tmp)).append(' ');
            } else {
                sb.append('0').append(' ');
            }

        }
        System.out.println(sb);
    }
}

