package baekjuntest;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main1269 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> hs = new HashSet<>();
		
		//2번째행 사이즈 3번째행 사이즈 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aNum = Integer.parseInt(st.nextToken());
		int bNum = Integer.parseInt(st.nextToken());
		int size = 0;
		int count = 0;
		
		//2번째행 값 받기
		StringTokenizer a = new StringTokenizer(br.readLine());
		for(int i=0; i<aNum; i++) {
			hs.add(Integer.parseInt(a.nextToken()));
		}
		
		//3번째행 값 받기
		StringTokenizer b = new StringTokenizer(br.readLine());
		for(int i=0; i<bNum; i++) {
			int value = Integer.parseInt(b.nextToken());
			if(hs.contains(value)) {
				count++;
			}
			else {
			hs.add(value);
			}
		}
		//a행 + b행 개수 -중복되는 값들
		bw.write(String.valueOf(aNum+bNum-count*2));
		bw.flush();
		bw.close();
	}
	
}
