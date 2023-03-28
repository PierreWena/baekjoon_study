package BaekJoonKSE.baekjoon0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10988 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        boolean isPalindrome = true; // 플래그
        for (int i = 0; i < s.length() / 2; i++) { // 문자 길이의 절반만큼 반복
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {  // 맨앞과 맨뒤부터 한칸씩 인덱스 옮겨가며 비교
                isPalindrome = false; // 다른 경우 false
            }
        }

        if (isPalindrome) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}