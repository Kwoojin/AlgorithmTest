package inflearn.bfsdfs_deep;

import java.util.Scanner;

public class BFSDFS3 {
    static int n,m;
    static Problem[] arr;
    static int max = Integer.MIN_VALUE;

    public void DFS(int L, int sum, int time){
        if (time>m) return;
        if(n==L) {
            max = Math.max(sum,max);
            return;
        }
        else {
            DFS(L+1,sum+arr[L].s,time+arr[L].t);
            DFS(L+1,sum,time);
        }
    }

    public static void main(String[] args) {
        BFSDFS3 T = new BFSDFS3();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new Problem[n];

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = new Problem(a,b);
        }

        T.DFS(0,0,0);

        System.out.print(max);
    }
}


class Problem {
    int s;
    int t;
    public Problem(int s, int t){
        this.s = s;
        this.t = t;
    }

}