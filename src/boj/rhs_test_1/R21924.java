package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class R21924 {
	static int n;
	static long m, total=0;
	static ArrayList<ArrayList<Edge>> graph;
	static boolean[] visited;
	
	static long BFS(int v) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(v, 0));
		long sum = 0;
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			int now = cur.vex;
			int nowCost = cur.cost;
			if(visited[now]) continue;
			visited[now] = true;
			sum += nowCost;
			for(Edge ob : graph.get(now)) {
				if(visited[ob.vex] == false) {
					queue.offer(new Edge(ob.vex, ob.cost));
				}
			}
		}
		return sum;
	}
	
	static void process() {
		
		long answer = total-BFS(1);
		for(int i=1; i<=n; i++) {
			if(visited[i]==false) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		input();
		process();
		
	}
	
	static void input() {
		FastReader fr = new FastReader();
		
		n = fr.nextInt();
		m = fr.nextLong();
		graph = new ArrayList<ArrayList<Edge>>();
		visited = new boolean[n+1];
		
		for(int i=0; i<=n; i++) graph.add(new ArrayList<Edge>());
		
		for(int i=0; i<m; i++) {
			int a = fr.nextInt();
			int b = fr.nextInt();
			int c = fr.nextInt();
			total+=c;
			
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		
	}
	
	static class Edge implements Comparable<Edge> {
		public int vex;
		public int cost;
		public Edge(int vex, int cos) {
			this.vex = vex;
			this.cost = cos;
		}
		
		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
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