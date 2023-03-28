package BaekJoonKSE.baekjoon0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder(); // 결과 출력용 StringBuilder

        for (int i = 0; i < C; i++) { //C번 반복
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken()); // N명의 학생수
            int[] scoreArr = new int[N]; // array에 학생별 성적 저장
            int sum = 0;
            for (int j = 0; j < N; j++) {
                scoreArr[j] = Integer.parseInt(st.nextToken()); // 성적 저장
                sum += scoreArr[j]; // 점수합산
            }
            double avg = (double)sum / N; // 평균 계산
            int overAvg = 0; // 평균넘는 학생수

            for (int j = 0; j < N; j++) { // 성적어레이 탐색하면서 비교
                if(scoreArr[j] > avg) {
                    overAvg++;
                }
            }
            double a = (Math.round((double)overAvg / N * 100 * 1000)) / 1000.0 ; //비율값의 3번째 자리까지 나오게 반올림
            sb.append(String.format("%.3f%%\n", a));
        }
        System.out.println(sb);

    }
}
