package boj;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj_15651 {

    static int N,M;
    static int[] arr;
    static BufferedWriter bw;

    static void DFS(int L) throws IOException {
        if(L==M){
            for(int num : arr) bw.write(String.valueOf(num) + " ");
            bw.write("\n");
        } else {
            for(int i=1; i<=N; i++){
                arr[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) throws  IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        sc.close();

        DFS(0);

        bw.flush();
        bw.close();
    }
}
