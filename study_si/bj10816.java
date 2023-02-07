package my.day01.backjun;

import java.util.HashMap;
import java.util.Scanner;

public class bj10816 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0, m = 0;
        
        n = sc.nextInt();
        
        int[] arr = new int[n]; //입력한 n개의 배열생성
      
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
        	arr[i] = sc.nextInt();
        	
        	if(map.containsKey(arr[i])) // key 값이 이미 있다면   containsKey :맵에 key값이 있는지 확인
        	{
        		map.put(arr[i],map.get(arr[i])+1); // 있던 key값의 value에 1을 더해서 다시 put
        	}
        	else
        	{
        		map.put(arr[i],1);
        	}
        }
        
        m = sc.nextInt();
        int[] marr = new int[m];
          
        for(int i=0;i<m;i++) // 출력
        {
        	marr[i] = sc.nextInt();
        	if(map.get(marr[i]) == null)
        	{
        		System.out.print(0+" ");
        	}
        	else
        	{
        		System.out.print(map.get(marr[i])+" ");
        	}
        	
        }

        sc.close();
}
}