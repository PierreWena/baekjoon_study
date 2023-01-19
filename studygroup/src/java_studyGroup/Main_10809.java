package java_studyGroup;

import java.util.Scanner;

public class Main_10809 {

	public static void main(String[] args) {   //질문 필요
		
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
		int []numArr = new int[26];
		
		
		for(int i=0; i<numArr.length; i++) {
			
			numArr[i] = -1;                 // 이해가 안됨. 그냥 맞는 알파벳이 잇을경우만 -1에서 값이 변하게끔 한건지
			
			
		}
		
		String s = sc.nextLine();
		
		for(int i = 0; i<s.length(); i++) {
			
			char ch = s.charAt(i);
			 
			
			if(numArr[ch - 97] == -1) {
			
			numArr[ch - 97] = i;                  // 이해가 안됨. 맞는 알파벳이 없기떄문에 indexof를 할시에 -1이 되는거와 같다라고 생각하면 되는건지.
			
			
			}
		
		} // end of for----------------
		
		
		for (int i=0; i<numArr.length; i++) {
			
			System.out.print(numArr[i] + " ");
			
			
		}
		
		//	for(int val : arr) {	// 위와 똑같음
		//  System.out.print(val + " ");
		// }
	} // end of main----------------------------------
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		String atoz = "abcdefghijklmnopqrstuvwxyz";
//		
//		String s = sc.nextLine();
//		
//		int num = 0;
//		
//		String str = "";
//		
//	
//		
//		for(int i=0; i<atoz.length(); i++) {
//			
//			 for(int j=0; j<s.length(); j++) {
//				 
//				 if( atoz.charAt(i)== s.charAt(j) ) {
//					 
//					 num = s.indexOf(j);
//					 
//					 str += num + " ";
//					 
//					 break;
//				 }
//				 
//				 else {
//					 
//					 num = -1;
//					 
//					 
//					 
//				 }
//				 
//				 str += num + " ";
//				 
//			 }  // end of for--------------
//			 
//			 
//			
//		} // end of for----------------------------------
		

	}  


