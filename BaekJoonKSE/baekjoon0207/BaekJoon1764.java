package BaekJoonKSE.baekjoon0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>(); //듣도 못한 사람이 저장될 셋

        for (int i = 0; i < N; i++) { //듣도 못한 사람 저장
            set.add(bf.readLine());
        }
        StringBuilder sb = new StringBuilder();

        ArrayList<String> al = new ArrayList<>(); // 듣도 보도 못한 사람 저장될 리스트


        for (int i = 0; i < M; i++) {  // 제시된 보도못한 사람이 듣도 못한 사람에 저장되었다면 듣도 보도 못한 사람
            String man = bf.readLine();
            if (set.contains(man)) {
                al.add(man);
            }
        }
        Collections.sort(al);  //  출력이 사전순이므로 정렬
        System.out.println(al.size());   // size = 듣도 보도 못한 사람 수
        for (String man : al) {
            sb.append(man).append('\n');
        }
        System.out.println(sb);
    }

}

