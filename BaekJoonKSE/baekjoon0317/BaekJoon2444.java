package BaekJoonKSE.baekjoon0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2444 {

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N + i; j++) {
                if (j < N - 1 - i || j > N - 1 + i) {
                    sb.append(' ');
                } else {
                    sb.append('*');
                }
            }
            sb.append('\n');
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N * 2 - 1 - i ; j++) {
                if (j < i || j > N * 2 - 2 - i) {
                    sb.append(' ');
                } else {
                    sb.append('*');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
}
