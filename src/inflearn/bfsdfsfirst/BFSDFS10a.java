package inflearn.bfsdfsfirst;

import java.util.Scanner;
import java.util.ArrayList;

public class BFSDFS10a {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int n,answer=0;

    public void DFS(int num){
        if(num == n){
            /*
             * for(int i=1; i<=n; i++) if(ch[i]>0) System.out.print(i + " ");
             * System.out.println();
             */
            answer++;
        } else {
            for(int nv : graph.get(num)){
                if(ch[nv]==0) {
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSDFS10a T = new BFSDFS10a();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ch = new int[T.n+1];
        int m = sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
        }

        ch[1]=1;
        T.DFS(1);

        System.out.print(answer);
    }
}