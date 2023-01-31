package baekjuntest;
import java.util.Scanner;

public class Main5622 {
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
		
		String str = in.nextLine();
 
		int count = 0;
		int k = str.length();
        
		for(int i = 0; i < k; i++) {
        
			switch(str.charAt(i)) {
            
			case 'A' : case 'B': case 'C' : 
				count += 3; // 전화기 숫자 2부터 알파벳이 시작하기 때문에 3을 넣어준다.
				break;
                
			case 'D' : case 'E': case 'F' :
				count += 4; 
				break;
                
			case 'G' : case 'H': case 'I' :
				count += 5; 
				break;
                
			case 'J' : case 'K': case 'L' : 
				count += 6;
				break;
                
			case 'M' : case 'N': case 'O' :
				count += 7;
				break;
                
			case 'P' : case 'Q': case 'R' : case 'S' : 
				count += 8; 
				break;
                
			case 'T' : case 'U': case 'V' : 
				count += 9;
				break;
                
			case 'W' : case 'X': case 'Y' : case 'Z' : 
				count += 10;
				break;
			}
		}		
		System.out.print(count);
	}
}