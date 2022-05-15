package boj.rhs_test_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class R20166 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, K;
	static char[][] graph;
	static HashMap<String, Integer> result = new HashMap<>();

	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	static void DFS(int x, int y, String str) {
		str = str+graph[x][y];
		int L = str.length();
		result.put(str, result.getOrDefault(str, 0)+1);
		if(L==5) {
			return;
		} else {
			for(int i=0; i<dx.length; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx == -1) nx = N-1;
				if(nx == N) nx = 0;
				if(ny == -1) ny = M-1;
				if(ny == M) ny = 0;

				DFS(nx,ny,str);
			}
		}
	}


	public static void main(String[] args) {
		input();
		process();

	}

	static void process(){
		try {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					DFS(i, j, "");
				}
			}

			for(int p=0; p<K; p++) {
				String prob = br.readLine();
				bw.write(String.valueOf(result.get(prob)));
				bw.write('\n');
			}
			bw.flush();
			bw.close();

		} catch(IOException e) {

		}
	}

	static void input(){
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			graph = new char[N][M];
			for(int i=0; i<N; i++) {
				String tmp = br.readLine();
				for(int j=0; j<M; j++) {
					graph[i][j] = tmp.charAt(j);
				}
			}

		} catch(IOException e) {

		}
	}
}