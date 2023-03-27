package myalgorithm;

import java.util.Scanner;

public class Main_25206 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double sum = 0; // 학점에 등급에 해당하는 점수를 일일이 곱한값들의 합
		
		int sum_1 = 0;   // 학점의총합
		
		double avg = 0;  // 평균
		
		
		
		
		for(int i=0; i<20; i++) {
		
				String jungong = sc.next();  // nextLine으로 하면 인풋미스매치가 뜨면서 안되는데 이유가 궁금합니다.
				
				double hakjum = sc.nextDouble();
				
				String grade = sc.next();
				
				if("A+".equals(grade)) {
					
					double grade_1 = 4.5;
				
					sum += hakjum*grade_1;
					sum_1 += hakjum;
				}
				
				else if("A0".equals(grade)) {
					
					double grade_1 = 4.0;
				
					sum += hakjum*grade_1;
					sum_1 += hakjum;
				}
				
				else if("B+".equals(grade)) {
					
					double grade_1 = 3.5;
				
					sum += hakjum*grade_1;
					sum_1 += hakjum;

				}
				
				else if("B0".equals(grade)) {
									
					double grade_1 = 3.0;
				
					sum += hakjum*grade_1;
					sum_1 += hakjum;

				}
								
				else if("C+".equals(grade)) {
					
					double grade_1 = 2.5;
				
					sum += hakjum*grade_1;
					sum_1 += hakjum;

				}
								
				else if("C0".equals(grade)) {
					
					double grade_1 = 2.0;
				
					sum += hakjum*grade_1;
					sum_1 += hakjum;

				}
				
				else if("D+".equals(grade)) {
					
					double grade_1 = 1.5;
					
					sum += hakjum*grade_1;
					sum_1 += hakjum;

				}
				
				else if("D0".equals(grade)) {
					
					double grade_1 = 1.0;
				
					sum += hakjum*grade_1;
					sum_1 += hakjum;

				}
				
				else if("F".equals(grade)) {
					
					double grade_1 = 0.0;
	
					sum += hakjum * grade_1;
					sum_1 += hakjum;

				}
				
				else { // p는 계산에서 제외하므로 그냥 아무것도 안하게끔 한다
					
				}
				
				
				
		
		} // end of for----------------------
		
		
		avg = sum/sum_1;
		
		System.out.println(String.format("%.6f", avg));  // 소수점 6자리까지 보여주게한다.
		
	}

}
