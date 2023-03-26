package beakJoonNo6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class grade25206 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼 리더를 사용해보자 
		// 버퍼 리더선언 오리발, (new InputStreamReader(system.in 을 사용하여 입력을 받아온다.))
		
		String subject = "";					// 과목명	
		String grade = "";						// 학점
		String reating = "";					// 등급
		double result = 0;						// 결과 값 (학점 * 등급) 합을 구하고 나중에 다시 결과값을 받아옴
		float result2 = 0;						// 학점만 더하기 위해
		float float_grade = 0;					// float 형태로 받기 위해
		
		DecimalFormat format = new DecimalFormat("0.000000");		// 소수점 6자리까지 0이 있으면 표시하기위해
		
		for(int i = 0; i < 20; i++)				// 20 번 반복
		{
			StringTokenizer st = new StringTokenizer(br.readLine());		// 스트링토큰 사용 한줄마다 받아옴
			subject = st.nextToken();			// 과목입력
			grade = st.nextToken();				// 학점 입력
			reating = st.nextToken();			// 등급 입력
			
			float_grade = Float.parseFloat(grade);	// 스트링 토큰은 String 으로 받아오기 때문에 float 로 변환해서 저장 
			
			
			switch (reating) {					// 등급이 어떤거에 따라 달라진다.
			case "A+":
				result += float_grade * 4.5;	// 결과에다가 학점 * 등급
				result2 += float_grade;			// 학점만 더한다.
				break;
			case "A0":
				result += float_grade * 4.0;
				result2 += float_grade;
				break;
			case "B+":
				result += float_grade * 3.5;
				result2 += float_grade;
				break;
			case "B0":
				result += float_grade * 3.0;
				result2 += float_grade;
				break;
			case "C+":
				result += float_grade * 2.5;
				result2 += float_grade;
				break;
			case "C0":
				result += float_grade * 2.0;
				result2 += float_grade;
				break;
			case "D+":
				result += float_grade * 1.5;
				result2 += float_grade;
				break;
			case "D0":
				result += float_grade * 1.0;
				result2 += float_grade;
				break;
			case "F":
				result += float_grade * 0.0;
				result2 += float_grade;
				break;
				
			default:						// 등급이 P일경우 아무것도 안한다.
				break;
			}
		}
		
		result = result/result2;			// 결과에 (학점*등급)을 더한것을 / 총 학점을 한다.
		result = Math.round(result * 1000000) / 1000000.0;  // 결과를 소수점 6자리까지 나오게 하고 7자리는 반올림한다.
		 
		System.out.println(format.format(result));   // 결과를 소수점 6자리까지 강제로 표시한다 0 이여도 표시 

	}

}
