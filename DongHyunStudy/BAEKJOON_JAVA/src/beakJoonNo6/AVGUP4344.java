//백준 4344번 평균은 넘겠지, 과연 그럴까요?

package baekjoonNo4;

import java.util.Scanner;		//Scanner사용위해 import

public class AVGUP4344 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);				// 키보드 사용을 위해 Scanner
		
		int T = sc.nextInt();			//테스트 회수 키보드로 입력 

		int sum = 0,cnt = 0;			// sum, cnt 선언

		double avg = 0;					// double형 평균 선언
		
		int Student = 0;				// 학생 수 선언 
		
		for(int i=0;i<T;i++)			// 테스트번 반복
		{
			Student = sc.nextInt();		// 학생수 키보드로 입력
			
			int Jumsu [] = new int [Student];	// 점수 배열에 학생수 만큼 선언 
			
			for(int j=0; j<Student; j++)		// 학생수 만큼 반복
			{
				Jumsu[j] = sc.nextInt(); 		// 점수 키보드로 입력받음 
				sum += Jumsu[j];				// 점수 합계를 sum에 저장
				if(j==Student-1)				// 만약 마지막 번 돌아가고 있다면 
				{
					avg += (double)sum / (double)Student;		// 평균을 구한다. 합계 / 학생수
					for(int k = 0;k<Student; k++)				// 학생수 만큼 반복
					{
						if(Jumsu[k] > avg)						// 평균보다 점수가 높다면
						{
							cnt++;								//cnt를 1증가 
						}
					}
				}
			}
			//System.out.println(Math.round((double)cnt/(double)Student*100000)/1000.0 + "%");
			//위 처럼 하면 40.000%가 아니라 40.0%로 나오게 된다.
			System.out.printf("%.3f", (double)cnt/(double)Student*100);			// 평균을 넘긴 학생수 / 전체 학생수 *100 을 한다. 
																				//%.3f는 소수점 3자리까지 나타낼수있는 것이다,
			System.out.println("%");											//% 출력을 위해 
			cnt = 0;		// 다시 사용하기 위해 초기화
			Student = 0;
			avg = 0;
			sum = 0;
		}	
		sc.close();				//메모리 누수 방지 
	}

}
