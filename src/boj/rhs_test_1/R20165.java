package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class R20165 {
	static int N,M, answer=0;
	static int[][] graph;
	static char[][] ch;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static void attack(int i, int j, int size, int ewsn) {
		if( i>=0 && i<N && j>=0 && j<M && size>0) {
			if(ch[i][j] == 'S') {
				ch[i][j]='F';
				answer++;
				size = Math.max(size, graph[i][j]);
			}
			int ni = i+dx[ewsn];
			int nj = j+dy[ewsn];
			attack(ni, nj, size-1, ewsn);
		}
	}
	
	static void defense(int i, int j) {
		ch[i][j] = 'S';
	}
	
	static int direction(char ewsn) {
		int next;
		if(ewsn == 'E') next=0;
		else if(ewsn == 'W') next=1;
		else if(ewsn == 'S') next=2;
		else next=3;
			
		return next;
	}

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			graph = new int[N][M];
			ch = new char[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					ch[i][j] = 'S';
				}
			}
			
			for(int v=0; v<R; v++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken())-1;
				int j = Integer.parseInt(st.nextToken())-1;
				int ewsn = direction(st.nextToken().charAt(0));
				attack(i, j, graph[i][j], ewsn);
				
				st = new StringTokenizer(br.readLine());
				i = Integer.parseInt(st.nextToken())-1;
				j = Integer.parseInt(st.nextToken())-1;
				defense(i, j);
			}
			
			bw.write(String.valueOf(answer));
			bw.write('\n');
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					bw.write(String.valueOf(ch[i][j]) + ' ');
				}
				bw.write('\n');
			}
			
			bw.flush();
			bw.close();
			
		} catch(IOException e) {
		}
	}
}
