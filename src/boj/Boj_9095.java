package boj;

import java.util.Scanner;

public class Boj_9095 {
    static StringBuilder sb = new StringBuilder();
    static int L,cnt=0;

    static void DFS(int sum) {
        if(sum > L) {
          return;
        } else if (L == sum) {
            cnt++;
        } else {
            for(int i = 1; i< 4; i++){
                DFS(sum + i);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            cnt = 0;
            L = sc.nextInt();
            DFS(0);
            sb.append(cnt).append('\n');
        }

        System.out.println(sb.toString());
    }
}
