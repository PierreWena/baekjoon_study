package my.day01.backjun;

import java.util.Scanner;

public class bj1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int cnt = 0;
        str = str.trim();//앞뒤 빈칸 제거
        Boolean checkEmpty = false; //빈칸만으로 이루어져있는지 검사
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i - 1) != ' ') {
                //띄어쓰기를 찾고 띄어쓰기 바로 앞의 문자가 빈칸이 아닌경우
                cnt++;
            }
            else
            	checkEmpty=true;
             if(!checkEmpty)
       
            System.out.println(cnt);
            }
      } 
}
