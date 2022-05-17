package boj.rhs_test_1;

import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class R21922 {
	static Queue<Node> queue = new LinkedList<>();
	static int n,m;
	static int[][] graph;
	
	static boolean[][] chk;
	static boolean[][][] visited;
	
	//µ¿(0), ¼­(1), ³²(2), ºÏ(3)
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static void BFS() {
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			int dir = changeDirection(graph[cur.x][cur.y], cur.dir);
			
			int ni = cur.x + dx[dir];
			int nj = cur.y + dy[dir];
			
			if(ni >= 0 && ni < n && nj >= 0 && nj < m && visited[ni][nj][dir]==false) {
				visited[ni][nj][dir]=true;
				chk[ni][nj]=true;
				queue.offer(new Node(ni,nj,dir));
			}
			
		}
	}
	
	static int changeDirection(int t, int d) {
		int init = d;
		switch (t) {
			case 1:
				if(d == 0) init = 1;
				else if(d == 1) init = 0; 
				break;
			case 2:
				if(d == 2) init = 3;
				else if(d == 3) init = 2;
				break;
			case 3:
				if(d == 0) init = 3;
				else if(d == 1) init = 2;
				else if(d == 2) init = 1;
				else if(d == 3) init = 0;
				break;
			case 4:
				if(d == 0) init = 2;
				else if(d == 1) init = 3;
				else if(d == 2) init = 0;
				else if(d == 3) init = 1;
				break;
		}
		return init;
	}
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		
		n = fr.nextInt();
		m = fr.nextInt();
		
		graph = new int[n][m];
		chk = new boolean[n][m];
		visited = new boolean[n][m][4];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				graph[i][j] = fr.nextInt();
				if(graph[i][j] == 9) {
					chk[i][j]=true;
					for(int k=0; k<4; k++) {
						int ni = i+dx[k];
						int nj = j+dy[k];
						if(ni>=0 && ni <n && nj>=0 && nj<m && visited[ni][nj][k]==false) {
							visited[ni][nj][k] = true;
							chk[ni][nj] = true;
							queue.offer(new Node(ni,nj,k));	
						}
					}
				}
			}
		}
		
		BFS();
		
		int answer=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(chk[i][j]) answer++;
			}
		}
		System.out.println(answer);
	}
	
	static class Node {
		public int x;
		public int y;
		public int dir;
		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
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
