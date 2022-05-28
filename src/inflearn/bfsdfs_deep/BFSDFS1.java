package inflearn.bfsdfs_deep;

import java.util.Scanner;

public class BFSDFS1 {
    static int[] arr;
    static int n, total=0;
    static boolean answer = false;

    public void DFS(int v, int sum){
        if(answer) return;
        if(sum > total/2) return;
        if(n==v) {
            answer = (total/2 == sum);
            return;
        }
        else {
            DFS(v+1,sum+arr[v]);
            DFS(v+1,sum);
        }
    }


    public static void main(String[] args) {
        BFSDFS1 T = new BFSDFS1();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS(0,0);

        if(answer) System.out.print("YES");
        else System.out.print("NO");
    }
}

