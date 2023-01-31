package BaekJoonKSE.baekjoon0130;

import java.io.IOException;

public class BaekJoon5622 {
    public static void main(String[] args) throws IOException {
        int ch = System.in.read();
        int sum = 0;
        while (ch != 10) {
            if (65 <= ch & ch <= 67) {
                sum += 3;
            } else if (68 <= ch & ch <= 70) {
                sum += 4;
            } else if (71 <= ch & ch <= 73) {
                sum += 5;
            } else if (74 <= ch & ch <= 76) {
                sum += 6;
            } else if (77 <= ch & ch <= 79) {
                sum += 7;
            } else if (80 <= ch & ch <= 83) {
                sum += 8;
            } else if (84 <= ch & ch <= 86) {
                sum += 9;
            } else if (87 <= ch & ch <= 90) {
                sum += 10;
            }
            ch = System.in.read();
        }
        System.out.println(sum);
    }

}
