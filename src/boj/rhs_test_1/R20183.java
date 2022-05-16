package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class R20183 {
	static int N, M, A, B;
	static long C;
	static List<Info> adj[];
	static long INF = 10000000000000001L;
	static long[] d;
	
	
	public static void main(String[] args) {
		input();
		process();
	}
	
	static boolean dijkstra(long x) {
		for(int i=1; i<=N; i++) d[i] = INF ;
		d[A] = 0;
		PriorityQueue<Info> queue = new PriorityQueue<>();
		queue.offer(new Info(A, 0));
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			if(d[cur.idx] != cur.length) continue;
			for (Info edge : adj[cur.idx]) {
				if(edge.length > x) continue;
				if(d[edge.idx] > d[cur.idx] + edge.length) {
					d[edge.idx] = d[cur.idx] + edge.length;
					queue.offer(new Info(edge.idx, d[edge.idx]));
				}
			}
		}
		return d[B] <= C;
	}
	
	static void process() {
        d = new long[N + 1];
        long left = 1, right = 1000000001, ans = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        if (ans == 1000000001) ans = -1;
        
		System.out.println(ans);
	}
	
    static class Info implements Comparable<Info> {
        int idx;
        long length;

        public Info(int idx, long length) {
            this.idx = idx;
            this.length = length;
        }

        @Override
        public int compareTo(Info o) {
            if (this.length > o.length) return 1;
            if (this.length == o.length) return 0;
            return -1;
        }
    }
	
	static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextLong();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        
        for (int i = 1; i <= M; i++) {
            int u, v;
            long t;
            u = scan.nextInt();
            v = scan.nextInt();
            t = scan.nextLong();
            adj[u].add(new Info(v, t));
            adj[v].add(new Info(u, t));
        }
	}
	
	static class FastReader {
		private BufferedReader br;
		private StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			if(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}