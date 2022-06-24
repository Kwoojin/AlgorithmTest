package boj.rhs_test_1;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class R21938 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;
    static int n,m;
    static boolean[][] visited;

    static void DFS(int x, int y) {
        if(graph[x][y]==0) return;
        else {
            visited[x][y] = true;
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx <n && ny>=0 && ny<m) {
                    if(!visited[nx][ny]) {
                        DFS(nx,ny);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        n = fr.nextInt();
        m = fr.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int sum=0;
                for(int k=0; k<3; k++) {
                    sum += fr.nextInt();
                }
                graph[i][j] = sum/3;
            }
        }

        int t = fr.nextInt();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = (graph[i][j] >= t ? 255 : 0);
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j]==255 && !visited[i][j]) {
                    answer++;
                    DFS(i,j);
                }
            }
        }

        System.out.print(answer);
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
