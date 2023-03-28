package my.day01.backjun;

import java.util.Scanner;

public class bj너의평점은 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 학점 * 과목평점
        double grade = 0;
        // 총학점
        double point = 0;

        for (int i = 0; i < 20; i++) {
            // 과목
            String subject = scanner.next();
            // 학점
            double a = scanner.nextDouble();
            // 평점
            String b = scanner.next();

            if (b.equals("A+")){
            	grade += a * 4.5;
                point += a;
            } else if (b.equals("A0")) {
            	grade += a * 4.0;
                point += a;
            }else if (b.equals("B+")) {
            	grade += a * 3.5;
                point += a;
            }else if (b.equals("B0")) {
            	grade += a * 3.0;
                point += a;
            }else if (b.equals("C+")) {
            	grade += a * 2.5;
                point += a;
            }else if (b.equals("C0")) {
            	grade += a * 2.0;
                point += a;
            }else if (b.equals("D+")) {
            	grade += a * 1.5;
                point += a;
            }else if (b.equals("D0")) {
            	grade += a * 1.0;
                point += a;
            }else if (b.equals("F")) {
            	grade += a * 0.0;
                point += a;
            }
        }

            System.out.printf("%.6f", grade / point);
    }
}
