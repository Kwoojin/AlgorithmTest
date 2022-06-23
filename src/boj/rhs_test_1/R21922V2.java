package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;


public class R21922V2 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] chk;

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        chk = new int[N][M][4];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    for(int z=0; z<4; z++) {
                        queue.offer(new Node(i, j, z));
                        chk[i][j][z]=1;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];

            if(nx>=0 && nx < N && ny>=0 && ny < M) {
                int nd = direction(arr[nx][ny], cur.dir);
                if(chk[nx][ny][nd]==0) {
                    chk[nx][ny][nd]=1;
                    queue.offer(new Node(nx, ny, nd));
                }
            }
        }

        int result=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                boolean flag = false;
                for(int z=0; z<4; z++) {
                    if(chk[i][j][z]==1) {
                        flag=true;
                        break;
                    }
                }
                if(flag) result++;
            }
        }

        System.out.println(result);

    }

    static int direction(int v, int d) {

        // d 상, 하, 좌, 우
        //   0,  1, 2, 3

        switch(v) {
            case 1:
                if(d==2)
                    return 3;
                else if(d==3)
                    return 2;
                break;
            case 2:
                if(d==0)
                    return 1;
                else if(d==1)
                    return 0;
                break;
            case 3:
                if(d==0)
                    return 3;
                else if(d==1)
                    return 2;
                else if(d==2)
                    return 1;
                else if(d==3)
                    return 0;
                break;
            case 4:
                if(d==0)
                    return 2;
                else if(d==1)
                    return 3;
                else if(d==2)
                    return 0;
                else if(d==3)
                    return 1;
                break;
        }
        return d;
    }

    static class Node {
        int x;
        int y;
        int dir;
        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}