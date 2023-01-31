package BaekJoonKSE.baekjoon0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = bf.readLine().split(" ");
        int numA = Integer.parseInt(new StringBuilder(strArr[0]).reverse().toString());
        int numB = Integer.parseInt(new StringBuilder(strArr[1]).reverse().toString());
        System.out.println(Math.max(numA, numB));

    }}
