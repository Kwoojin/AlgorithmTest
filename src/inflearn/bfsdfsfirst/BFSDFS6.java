package inflearn.bfsdfsfirst;

import java.util.Scanner;

public class BFSDFS6 {
    static int n =0;
    static int[] chk;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        chk = new int[n+1];

        DFS(1);
    }

    static void DFS(int l){
        if(l>n) {
            String tmp = "";
            for(int i=1; i<=n; i++)
                if(chk[i]==1) tmp += (i+" ");
            if(tmp.length()>0) System.out.println(tmp);
            return;
        }
        else {
            chk[l]=1;
            DFS(l+1);
            chk[l]=0;
            DFS(l+1);
        }
    }
}