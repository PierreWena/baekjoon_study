package my.own.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class SJH_25206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double sum = 0;
		double score_sum = 0;
		double result = 0;
		
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			
			double score = Double.parseDouble(st.nextToken());
			
			score_sum += score;
			
			String grade = st.nextToken();
			
			double dbl_grade = 0;
			
			switch (grade) {
				case "A+":
					dbl_grade = 4.5;
					break;
					
				case "A0":
					dbl_grade = 4.0;
					break;
					
				case "B+":
					dbl_grade = 3.5;
					break;
					
				case "B0":
					dbl_grade = 3.0;
					break;
					
				case "C+":
					dbl_grade = 2.5;
					break;
					
				case "C0":
					dbl_grade = 2.0;
					break;
					
				case "D+":
					dbl_grade = 1.5;
					break;
					
				case "D0":
					dbl_grade = 1.0;
					break;

				case "P":
					score_sum -= score;
				case "F":
					dbl_grade = 0.0;
					break;
				
	
				default:
					break;
			}// end of switch
			
			sum += score * dbl_grade;
//			System.out.println("score : " + score);
//			System.out.println("dbl_grade : " + dbl_grade);
			
		}// end of for

		DecimalFormat df = new DecimalFormat("0.000000");
		
		result = Math.round(sum/score_sum*1000000)/1000000.0;
		
		System.out.println(df.format(result));
		
	} 

}
