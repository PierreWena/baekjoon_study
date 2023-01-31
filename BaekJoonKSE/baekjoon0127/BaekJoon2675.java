package BaekJoonKSE.baekjoon0127;

import java.util.Scanner;

public class BaekJoon2675 {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = sc.nextInt();
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(str.charAt(i));
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}

