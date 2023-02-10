package BaekJoonKSE.baekjoon0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BaekJoon1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = a + b;  // 집합 a와 b의 원소개수를 합함

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < a; i++) {
            set.add(Integer.parseInt(st.nextToken())); // 집합 A 원소를 set에 넣기
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < b; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) { // 집합 b의 원소가 a에 포함된다면
                count -= 2;  // 대칭차집합의 개수가 2개씩 줄어든다 (A-b에서 하나 B-A에서 하나씩 줄어듦)
            }
        }
        System.out.println(count);

    }
}
