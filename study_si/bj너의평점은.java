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
            // 과목이름
            String subject = scanner.next();
            // 받은점수
            double jumsu = scanner.nextDouble();
            // 등급
            String rank = scanner.next();

            if (rank.equals("A+")){
            	grade += jumsu * 4.5;
                point += jumsu;
            } else if (rank.equals("A0")) {
            	grade += jumsu * 4.0;
                point += jumsu;
            }else if (rank.equals("B+")) {
            	grade += jumsu * 3.5;
                point += jumsu;
            }else if (rank.equals("B0")) {
            	grade += jumsu * 3.0;
                point += jumsu;
            }else if (rank.equals("C+")) {
            	grade += jumsu * 2.5;
                point += jumsu;
            }else if (rank.equals("C0")) {
            	grade += jumsu * 2.0;
                point += jumsu;
            }else if (rank.equals("D+")) {
            	grade += jumsu * 1.5;
                point += jumsu;
            }else if (rank.equals("D0")) {
            	grade += jumsu * 1.0;
                point += jumsu;
            }else if (rank.equals("F")) {
            	grade += jumsu * 0.0;
                point += jumsu;
            }
        }
        	
            System.out.println( Math.round(grade / point * 1000000)/1000000.0 );
    }
}
