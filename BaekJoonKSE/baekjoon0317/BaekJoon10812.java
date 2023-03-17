package BaekJoonKSE.baekjoon0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10812 {

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        for (int spin = 0; spin < m; spin++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = spin(i, j, k, arr);
        }
        StringBuilder sb = new StringBuilder();

        for (int val:arr) {
            sb.append(val + " ");
        }
        System.out.println(sb);



    }

    private static int[] spin(int i, int j, int k, int[] arr) {
        int[] arr2 = arr.clone();

        for(int idx = i - 1; idx <  i + j - k ; idx++) {
            arr2[idx] = arr[idx + (k - i)];
        }
        for(int idx = i + j - k; idx <= j - 1; idx++) {
            arr2[idx] = arr[idx - (j - k + 1)];
        }
        return arr2;
    }

}