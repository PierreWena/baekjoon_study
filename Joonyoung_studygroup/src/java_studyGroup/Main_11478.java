package myalgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

import java.util.Set;


public class Main_11478 {

	public static void main(String[] args) throws IOException { // 해쉬셋 기억안나서 참고...

		// https://velog.io/@serendipity-dev/%EB%B0%B1%EC%A4%80-11478-%EC%84%9C%EB%A1%9C-%EB%8B%A4%EB%A5%B8-%EB%B6%80%EB%B6%84-%EB%AC%B8%EC%9E%90%EC%97%B4%EC%9D%98-%EA%B0%9C%EC%88%98Java
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
		
		String S = br.readLine();
		
		int sLength = S.length();
		
		Set<String>hashSet = new HashSet<>();
		
		
	
		
		for(int i=0; i<sLength; i++) {   // 특정 길이를 반복문을 돌릴떄 변수로 지정해서 수행하는게 더 빠르다.
			
			
			for(int j=i+1; j<sLength; j++) {
				
					hashSet.add(S.substring(i,j));
				
					
				 
			}
			
			
		}
		
		int sz = hashSet.size();
		
		
		bw.write(String.valueOf(sz));
		
		bw.flush();
		
		bw.close();
			
			
			
		}  // end of main----------------------------------------------------

		
		
		

	}  

