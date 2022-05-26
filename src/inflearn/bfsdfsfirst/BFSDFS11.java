package inflearn.bfsdfsfirst;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFSDFS11 {
    static int n;
    static int[] ch;
    static int[] dis;
    static ArrayList<ArrayList<Integer>> graph;

    public int BFS(int r){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(r);
        ch[r]=1;
        dis[r]=0;

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int nr = Q.poll();

                for(int num : graph.get(nr)){
                    if(ch[num] == 0) {
                        Q.offer(num);
                        ch[num]=1;
                        dis[num]=dis[nr]+1;
                    }
                }
            }
        }
        return 0;


    }

    public static void main(String[] args) {
        BFSDFS11 T = new BFSDFS11();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>());

        ch = new int[n+1];
        dis = new int[n+1];

        int m = sc.nextInt();

        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
        }

        ch[1]=1;

        T.BFS(1);

        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }

    }
}