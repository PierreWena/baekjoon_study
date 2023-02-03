package BaekJoonKSE.baekjoon0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        boolean[] arr = new boolean[20_000_001];  // 나올 수 있는 숫자는 -10,000,000 ~ 10,000,000이므로 20,000,001 크기의 배열 생성
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(st.nextToken()) + 10_000_000; // 나온 숫자의 인덱스는 true 인덱스 0부터 -10,000,000임
            arr[index] = true;
        }
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int index = Integer.parseInt(st.nextToken()) + 10_000_000;
            if (arr[index]) { // 숫자카드가 나온 적 있으면 true 나온 적 없으면 false임
                sb.append('1').append(' ');
            } else {
                sb.append('0').append(' ');
            }
        }
        System.out.println(sb);

    }
}
