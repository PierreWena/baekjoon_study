//백준 10809 알파벳 찾기, 한 단어에서 각 알파벳이 처음 등장하는 위치를 찾는 문제

package study1_17_1_20;
	
import java.util.Scanner;			// Scanner사용을 위해 util패키지에서 import

public class FindAlphabet10809 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	//Scanner 사용으로 키보드 입력을 받을수 있게 함 
		
		String alph[] = new String [26];		// 알파벳은 26글자이므로 배열선언 // 굳이 필요는 없음 이유는 알파벳
												//이 26글자인것은 모두가 아는 사실이니까 for문에 alph 길이 보다 26써도 됨 
		
		int result = 0;							// 결과값 선언 
		
		String str = sc.nextLine();				// 문자열을 키보드로부터 입력을 받는다.
		
		StringBuilder sb = new StringBuilder();	// 스트링 빌더를 사용하기 위해 선언 
		
		for(int i=0; i<alph.length; i++)		// 알파벳 숫자만큼 반복한다.
		{
			for(int j=0; j< str.length(); j++)	// 문자열 길이만큼 반복한다.
			{
				if(str.charAt(j) == i+97)		//각 하나하나의 글자가 아스키코드 97 ~ 122 인 알파벳 소문자인 경우를 확인한다.
				{
					result = j;					// j번째에 있다는 겻을 결과에 넣는다.
					break;						// 더이상 실행안해도 되므로 2번째 for문 탈출 
				}
				else							// 소문자가 아니거나 소문자를 사용하지 않았을 경우 
				{
					result = -1;				// 결과값을 -1로 넣는다.
				}
			}
			sb.append(result).append(" ");		// 스트링 빌더에 결과값과 공백을 추가(누적)시킨다.
		}
		System.out.println(sb.toString());		// 스트링 빌더에 있는 결과를 String타입으로 변경하여 출력한다.
		
		sc.close();								// Scanner를 더이상 사용 안하므로 메모리 누수 방지하기 위해 닫는다.
	}

}

////////////////////////////////////////////////// 
// 이 밑에는 정답을 맞춘뒤 다른 사람들이 푼것을 봤다.
//////////////////////////////////////////////////


/*
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 'z' - 'a' + 1;
        int[] sIndex = new int[cnt];
        Arrays.fill(sIndex, -1);

        String s = br.readLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'a';
            sIndex[index] = i;
        }

        for (int i = 0; i < sIndex.length; i++) {
            bw.write(sIndex[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
*/

/*
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 알파벳 배열 선언
//		char [] alphabet = new char[26];
//		for(int i = 0; i< 26; i++) {
//			alphabet[i] = (char)(i+97);
//		}
		
		int[] alphabetcnt = new int[26];
		for(int i=0; i<26; i++) {
			alphabetcnt[i] = -1;
		}
		
//		System.out.println(Arrays.toString(alphabetcnt));

		// 입력단어
		String S = sc.nextLine();
		

//		단어 쪼개기		
		for(int i=0; i<S.length(); i++) {
			char s = S.charAt(i);
			
			//있는지 검사하기 아스키코드 활용
			if(alphabetcnt[s-'a'] == -1) {
				alphabetcnt[s-'a'] = i;
			}
			
		}
		for(int arr: alphabetcnt) {
			System.out.print(arr + " ");
		}
		
		
//		for(int i=0; i<S.length(); i++) {
//			s[i] = S.charAt(i);
//		}
//		
//		for(int i=0; i<S.length(); i++) {
//			if(alphabet.equals(s)) {
//								
//			}
//		}

	}

}

*/
