package my.day01.backjun;

import java.util.*;

public class bj11478 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
 
        HashSet<String> Hset = new HashSet<>();
 
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (!Hset.contains(s.substring(i, j))) {
                    Hset.add(s.substring(i, j));
                }
            }
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append(Hset.size()+"\n");
        System.out.println(sb);
 
    }
}
