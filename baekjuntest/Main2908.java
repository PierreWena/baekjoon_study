package baekjuntest;
import java.util.Scanner;

public class Main2908 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = rn(in.nextInt());
        int b = rn(in.nextInt());

        System.out.println((a>b)? a:b);
    }

    static int rn(int num){
        String number = String.valueOf(num);
        String temp = "0";
        for (int i = 3; i > 0 ; i--) {
            temp += number.charAt(i-1);
        }
        return Integer.parseInt(temp);
    }
}