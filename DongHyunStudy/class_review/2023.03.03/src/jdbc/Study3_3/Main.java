// 5번에 있는 모든 것을 실행시키는 메인 

package jdbc.day05.board.Study3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		InterTotalController ctrl = new TotalController();   // interface로 쓴 것을 TotalController 호출 
		
		Scanner sc = new Scanner(System.in);
				
		ctrl.menu_Start(sc);   // InterTotalController에 void menu_Start(Scanner sc);가 생성되어 실행 
		
		sc.close();
		System.out.println(">>> 프로그램 종료 <<<");
	} // end of public static void main(String[] args) {

}
