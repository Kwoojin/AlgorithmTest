package inflearn.bfsdfs_deep;

import java.util.Scanner;

public class BFSDFS2 {
    static int c, n;
    static int[] arr;
    static int max=Integer.MIN_VALUE;

    public void DFS(int len, int sum){
        if(n==len) {
            max = Math.max(sum,max);
            return;
        }
        else {
            if(sum+arr[len]<c) {
                DFS(len+1,sum+arr[len]);
            }
            DFS(len+1,sum);
        }
    }

    public static void main(String[] args) {
        BFSDFS2 T = new BFSDFS2();

        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];

        for(int i=0; i<n; i++) arr[i]=sc.nextInt();

        T.DFS(0, 0);

        System.out.print(max);
    }
}