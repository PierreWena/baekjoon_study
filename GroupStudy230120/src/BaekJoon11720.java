import java.util.Scanner;

public class BaekJoon11720 {

    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextLine(); // 첫입력 버림

        for(int c : sc.nextLine().toCharArray()) { // 2번째 입력의 String을 CharArray로 만든 값을 하나씩 받음
            sum += c - '0'; // sum에 char - '0'의 값을 더함
        }
        System.out.println(sum); // sum 출력
    }
}
