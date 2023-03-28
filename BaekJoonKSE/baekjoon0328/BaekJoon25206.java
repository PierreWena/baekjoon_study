package BaekJoonKSE.baekjoon0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaekJoon25206 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Float> map = new HashMap<String, Float>() { //학점별 평점 매핑
            {
                put("A+", 4.5F);
                put("A0", 4.0F);
                put("B+", 3.5F);
                put("B0", 3.0F);
                put("C+", 2.5F);
                put("C0", 2.0F);
                put("D+", 1.5F);
                put("D0", 1.0F);
                put("F", 0.0F);
                put("P", 0.0F);
            }
        };

        float subjectCnt = 0F;
        float gradeSum = 0F;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            st.nextToken(); //과목명 버림
            float credit = Float.parseFloat(st.nextToken()); // 학점수
            String grade = st.nextToken(); // 등급

            if (!grade.equals("P")) { //패스가 아닐 경우만 카운트
                subjectCnt += credit; //총학점 누적
                gradeSum += credit * map.get(grade); // 등급에서 평점 가져와서 총평점 누적
            }
        }
        System.out.println(gradeSum / subjectCnt); // 결과 출력

    }

}