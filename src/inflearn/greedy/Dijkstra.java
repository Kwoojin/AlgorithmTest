package inflearn.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
	static int N,M;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] d;
	
	public static void main(String[] args) {
		input();
		process();
	}
	
	static void process() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(1, 0));
		d[1]=0;
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			int des = cur.des;
			int val = cur.val;
			if(val>d[des]) continue;
			for(Edge ob : graph.get(des)) {
				if(d[ob.des] > d[des] + ob.val) {
					d[ob.des] = d[des] + ob.val;
					queue.offer(new Edge(ob.des, d[ob.des]));
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			int val = d[i];
			if(val==Integer.MAX_VALUE) val=-1;
			System.out.println(i +" : " + val);
		}
		
	}
	
	static void input() {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		
		d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Edge>());
		
		while(M-- > 0) {
			int s = fr.nextInt();
			int e = fr.nextInt();
			int v = fr.nextInt();
			graph.get(s).add(new Edge(e,v));
		}
	}
	
	static class Edge implements Comparable<Edge> {
		public int des;
		public int val;
		public Edge(int des, int val) {
			this.des = des;
			this.val = val;
		}
		
		@Override
		public int compareTo(Edge ob) {
			return this.val - ob.val;
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			if(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}