package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class R21924V2 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        boolean[] chk = new boolean[N+1];

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) graph[i] = new ArrayList<Edge>();

        long preResult = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph[x].add(new Edge(y,val));
            graph[y].add(new Edge(x,val));
            preResult += val;
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(1, 0));

        long postResult = 0;
        while(!queue.isEmpty()) {
            Edge cur = queue.poll();
            if(chk[cur.target]) continue;
            chk[cur.target]=true;
            postResult += cur.value;

            for(Edge ob : graph[cur.target]) {
                if(!chk[ob.target]) {
                    queue.offer(ob);
                }
            }
        }

        long answer = preResult - postResult;
        for(int i=1; i<=N; i++) {
            if(chk[i] == false) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int target;
        int value;

        public Edge(int target, int value) {
            this.target = target;
            this.value = value;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.value - ob.value;
        }
    }
}