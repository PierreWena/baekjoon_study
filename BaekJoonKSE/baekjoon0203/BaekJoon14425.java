package BaekJoonKSE.baekjoon0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoon14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(bf.readLine());
        }

        int count = 0 ;
        for (int i = 0; i < M; i++) {
            if(set.contains(bf.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
