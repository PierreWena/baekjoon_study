//백준 1157번 문제 단어 공부, 주어진 단어에서 가장 많이 사용된 알파벳을 출력하는 문제

package beakJoonNo6;

import java.util.Scanner;

public class VocaStudy1157 {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);			// Scanner 사용으로 키보드 입력값을 받아올수 있는 준비를 함 

		String voca = sc.nextLine();				// 단어를 키보드로 입력해라 
		voca = voca.toUpperCase();					// 단어 입력받은것을 대문자로 바꿔라 
		
		String A[] = new String [voca.length()];	// A배열에 키보드로부터 받아온 단어 길이만큼 배열 크기를 정한다.

		int cnt =0 ,Result = 0;					// 변수 선언 
		int Go = 0;
		
		int T = voca.length();					// 테스트 할 단어의 길이만큼 반복문 하기 위해 선언 

		for(int i=0 ; i<T; i++)					// 단어의 길이만큼 반복 
		{
		    A[i] = voca.charAt(i)+"";			// 각 자리의 단어를 뽑아온후 A배열에 저장 
		}
		for(int i=0  ; i<T; i++)				// 다시 단어의 길이만큼 반복 
		{	
		    for(int j = i; j < T; j++)			// 이것을 한 이유는 같은 단어가 나오면 몇개인지 파악하고 가장 많을시 표시해주기 위해 나타냄			
		    {									// j가 i번째부터 단어 길이까지 반복
		    
		        if(A[i].equals(A[j]))			// 만약 A의 i번째 단어가 A의 j번째 단어와 같다면 
		        {
		          	cnt++;						// count를 올려준다.
		        }
		    }
		    if(i == 0)					// 0번째 돌아갈때는 
		    {
		    	Result = cnt;			// count 돌아간 만큼 결과값에 넣어주고 
		    	Go = i;					// GO변수에 i를 넣어줘서 A배열에 i번째를 표시해 주기 위해 설정하였다.
		    }  
		    else						// 0번째 이후에는 
		    {
		    	if(Result < cnt)		// 결과값이 count보다 작으면 다른 단어가 더 길다는 뜻이 되므로 
		    	{   		
		    		Go = i;				// 새로운 i를 Go에 넣어주고 
		    		Result = cnt;		// 결과값을 새로 변경해준다.
		    	} 
		    	else if(Result == cnt)	// 만약 결과값과 count 값이 같다면 
		    	{
		    		A[Go] = "?";		//A[Go] 배열에 ?를 넣어준다.
		    	}
		    }
		    cnt = 0;					// count는 반복할때마다 초기화 되어야 다시 count를 쓸 수 있다.
		}
		System.out.println (A[Go]);		// 출력
		
		sc.close();						// 스케너를 사용하지 않으므로 메모리 누수 방지 
	}
}


/*
 public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int[] count = new int[26];
        
        int max = -1;
        char result = '?';
        
        String s = sc.next();
        s = s.toUpperCase();
        
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'A']++;
            if(max < count[s.charAt(i) - 'A']){
                max = count[s.charAt(i) - 'A'];
                result = s.charAt(i);
            }else if(max == count[s.charAt(i) - 'A']){
                result = '?';
            }
        }
        System.out.println(result);
    }
}
*/