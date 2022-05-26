package inflearn.bfsdfsfirst;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BFSDFS8 {
    int[] dis = {-1,1,5};
    int[] ch;

    public int BFS(int s, int e){
        Queue<Integer> Q = new LinkedList<>();
        ch = new int[10001];
        Q.offer(s);
        ch[s]=1;
        int L=0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int cur = Q.poll();
                for(int j=0; j<dis.length; j++){
                    int nx = cur+dis[j];
                    if(nx == e) return L+1;

                    if(cur+dis[2] < e) if(j==0 || j==1) continue;
                    if(cur > e) if( j==1 || j==2) continue;

                    if(nx>0 && nx<=10000 && ch[nx]==0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        BFSDFS8 T = new BFSDFS8();

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();


        System.out.print(T.BFS(s,e));
    }
}