package myalgorithm;

import java.util.Scanner;

public class Main_2941 {

	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String inputStr = sc.nextLine();
		
		
		
		
		int count =0;
		
		String strSum = "";
		
		
		
		for(int i=0; i<inputStr.length()-1; i++ ) {
			
			strSum = "";
			
			
			
			strSum += inputStr.charAt(i) + inputStr.charAt(i+1); // 각 자릿수를 문자열결합한다.
			
			
			
			if(strSum.equals("c=")     ||   strSum.equals("c-") 
			   ||  strSum.equals("d-") || strSum.equals("lj")
			   || strSum.equals("nj")  || strSum.equals("s=")  // equals가 아니라 일일이 하나하나 대조를 해가면서
			    ) {											   // 대조를 하면서 같은지 확인햇어야 했는데 그러지 못했다
																			
				
			
				
				
				i++;
				
				
				
				
			}
			
			if (strSum.equals("dz="))  {   // 유일하게 글자가 3개이다 보니 대조를 하는과정에서 전체 문자열의 길이 -3까지 일경우에 대조를 하도록 해야한다.
				
				
				
				i +=2;                        
				
				
			}
			
			
			
			if((!strSum.equals("dz=") && strSum.equals("z=") )) {
				
				
				
				i++;
				
			}
			
			
			
			
			
		count++;
			
			
			
		} // end of for--------------------------------
		
		
		System.out.println(count);
		
		
		
	} // end of main------------------------------------------
}
