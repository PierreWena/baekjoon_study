package BaekJoonKSE.baekjoon0120;

import java.util.Scanner;

public class BaekJoon10809 {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 'a' ; i <= 'z'; i++) { // 아스키코드의 a부터 z까지 순회
            sb.append(str.indexOf(i)).append(' '); //indexOf는 'char'를 인수로 받을 수 있음
        }                                          //str의 각 알파벳이 가장 먼저 나타나는 index를 sb에 append 없으면 -1 리턴
        System.out.println(sb); // sb에는 알파벳 순서별로 가장 먼저 나타나는 index가 담겨있음
    }
}
