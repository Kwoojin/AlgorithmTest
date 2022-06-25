package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class R21943_fail_1 {
    static int N, P, Q;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> qlist = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    static void DFS(int L) {
        if(N == L) {
            int result=1;
            for(int i=0; i<=Q; i++) {
                int sum = qlist.get(i).stream().mapToInt(Integer::intValue).sum();
                if(sum == 0) return;
                result *= sum;
            }

            answer = Math.max(answer, result);
        } else {
            for(int i=0; i<=Q; i++) {
                qlist.get(i).add(arr[L]);
                DFS(L+1);
                qlist.get(i).remove(qlist.get(i).size()-1);
            }
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        N = fr.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = fr.nextInt();

        P = fr.nextInt();
        Q = fr.nextInt();

        for(int i=0; i<=Q; i++) qlist.add(new ArrayList<>());

        DFS(0);

        System.out.println(answer);
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}


