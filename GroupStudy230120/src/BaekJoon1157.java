package baekjoon0127;

import java.util.Scanner;

public class BaekJoon1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[26];

        String str = sc.nextLine().toLowerCase();
        for (int i = 0 ; i < str.length(); i++) {
            alphabet[str.charAt(i) - 'a']++;
        }

        boolean bool = false;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                maxIndex = i;
                bool = false;
            } else if (alphabet[i] == max) {
                bool = true;
            }
        }

        if (bool) {
            System.out.println("?");
        } else {
            System.out.println((char)(maxIndex + 'A'));
        }

    }
}
