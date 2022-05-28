package inflearn.bfsdfs_deep;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BFSDFS5 {
    static int[] coin;
    static int n, total;

    static int answer=Integer.MAX_VALUE;

    public int BFS(int value){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(value);
        int L=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                int cur = queue.poll();
                if(total == cur) return L;

                for(int j=0; j<n; j++){
                    int nc = cur+coin[j];
                    if(total >= nc) queue.offer(nc);
                }
            }
            L++;
        }
        return 0;
    }

    public void DFS(int L, int sum) {
        if(L>=answer) return;
        if(sum > total) return;
        else if( sum == total) {
            answer = L;
        } else {
            for(int i=n-1; i>=0; i--){
                //if(total>(sum+coin[n-1])) if(i!=n-1) continue;

                DFS(L+1, sum+coin[i]);
            }
        }
    }

    public static void main(String[] args) {
        BFSDFS5 T = new BFSDFS5();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coin = new int[n];
        for(int i=0; i<n; i++) coin[i] = sc.nextInt();

        //Arrays.sort(coin, Collections.reverseOrder());

        total = sc.nextInt();

        //System.out.print(T.BFS(0));

        T.DFS(0,0);
        System.out.print(answer);

    }
}