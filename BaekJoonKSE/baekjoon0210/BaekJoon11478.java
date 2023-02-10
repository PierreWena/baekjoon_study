package BaekJoonKSE.baekjoon0210;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
public class BaekJoon11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> arr = new HashSet<>();

        String s = bf.readLine();
        for (int i = 0; i < s.length(); i++) {  // i는 sbustring의 왼쪽 인덱스
            for (int j = i + 1; j <= s.length(); j++) { // j는 sbustring의 오른쪽 인덱스
                String tmp = s.substring(i, j);
                if (!arr.contains(tmp)) {
                    arr.add(tmp);
                }
            }
        }
        System.out.println(arr.size());

    }

}
