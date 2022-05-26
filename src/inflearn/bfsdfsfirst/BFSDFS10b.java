package inflearn.bfsdfsfirst;

import java.util.Scanner;

public class BFSDFS10b {
    static int[][] graph;
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
            for(int i=1; i<=n; i++){
                if(graph[num][i]==1 && ch[i]==0) {
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSDFS10b T = new BFSDFS10b();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ch = new int[T.n+1];
        int m = sc.nextInt();

        graph = new int[T.n+1][T.n+1];
        for(int i=0;i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }

        ch[1]=1;
        T.DFS(1);

        System.out.print(answer);
    }
}
