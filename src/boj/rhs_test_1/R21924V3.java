package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class R21924V3 {

    static int[] unf;

    static int find(int v) {
        if(v==unf[v]) return v;
        else return unf[v]=find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;

        long rst = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            rst += c;
            queue.offer(new Edge(a,b,c));
        }

        while(!queue.isEmpty()) {
            Edge ob = queue.poll();
            if(find(ob.a) != find(ob.b)) {
                union(ob.a, ob.b);
                rst -= ob.cos;
            }
        }

        int standard = find(1);
        for(int i=2; i<=n ;i++) {
            if(standard != find(i)) {
                rst = -1;
                break;
            }
        }

        System.out.println(rst);
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cos;

        public Edge(int a, int b, int cos) {
            this.a = a;
            this.b = b;
            this.cos = cos;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cos - ob.cos;
        }
    }
}