package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyUtil {

	public static String addDay(int n) {
		
		Calendar currentDate = Calendar.getInstance();	// 현재 날자와 시간을 얻어온다.
		
		currentDate.add(Calendar.DATE, n);		
	 // currentDate.add(Calendar.DATE, 1); 은 하루뒤를 말한다.
	 // ==> currentDate(현재날짜) 에서 두번째 파라미터에 입력해준 숫자(그 단위는 첫번째 파라미터인 것이다. 지금은 Calendar.DATE 이므로 날짜수이다.) 이것 만큼 더한다.
	 // ==> 위의 결과는 currentDate 값은 1일 더한 값으로 변한다.	
		
		SimpleDateFormat sdfmt = new SimpleDateFormat ("yyyy-MM-dd");
		return sdfmt.format(currentDate.getTime());  // calendat 클래스를 데이터 타입으로 바꿔주는 것이다.
	}
}
