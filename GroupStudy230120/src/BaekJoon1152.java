package baekjoon0127;

import java.util.Scanner;

public class BaekJoon1152 {
    public static void main(String[] args) {
        String str = (new Scanner(System.in).nextLine().trim());
        if (str.equals("")) { //입력이 공백이면 단어가 0개
            System.out.println(0);
        } else { // 공백의 개수만큼 array 길이
            System.out.println(str.split(" ").length);
        }

    }
}
