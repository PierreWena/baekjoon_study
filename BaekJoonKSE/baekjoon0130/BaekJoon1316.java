package BaekJoonKSE.baekjoon0130;
import java.io.*;

public class BaekJoon1316 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String s;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            s = bf.readLine();
            if (isGroup(s)) {
                cnt++;
            }
        }
        System.out.println(cnt);


    }

    static boolean isGroup(String s) {
        boolean[] arr1 = new boolean[26];
        arr1[s.charAt(0) - 'a'] = true;
        int index;
        for (int i = 1; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if ((s.charAt(i) != s.charAt(i - 1)) && arr1[index]) {
                return false;
            }
            arr1[index] = true;
        }
        return true;
    }
}
