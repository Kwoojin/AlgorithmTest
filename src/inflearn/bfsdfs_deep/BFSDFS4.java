package inflearn.bfsdfs_deep;

import java.util.Scanner;

public class BFSDFS4 {
    static int n,m;
    static int[] pm;

    public void DFS(int L){
        if(m==L) {
            System.out.println(pm[0] + " " + pm[1]);
        }
        else {
            for(int i=1; i<=n; i++){
                pm[L]=i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        BFSDFS4 T = new BFSDFS4();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pm = new int[m];

        T.DFS(0);

    }
}