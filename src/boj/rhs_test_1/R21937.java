package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class R21937 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<=n; i++) graph[i] = new ArrayList<Integer>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        int x = Integer.parseInt(br.readLine());

        int answer = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(visited[cur]) continue;
            visited[cur]=true;
            answer++;
            for(int num : graph[cur]) {
                if(!visited[num]) {
                    queue.offer(num);
                }
            }
        }

        System.out.print(answer);

    }
}
