package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class R21941_fail_1 {

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        String s = fr.next();
        int size = s.length();
        ArrayList<IndexScore>[] strings = new ArrayList[size];
        for(int i=0; i<size; i++) strings[i] = new ArrayList<>();

        int n = fr.nextInt();
        while(n-- > 0) {
            String curStr = fr.next();
            int len = curStr.length();
            int score = fr.nextInt();
            if(len >= score) continue;

            int index = 0;
            while(index < size) {
                int pos = s.indexOf(curStr, index);
                if(pos == -1) break;
                else {
                    strings[pos].add(new IndexScore(len, score));
                    index = pos + 1;
                }
            }
        }

        int[] dy = new int[size+1];

        for(int i=0; i<size; i++) {
            dy[i+1] = Math.max(dy[i+1], dy[i]+1);
            for(int j=0; j<strings[i].size(); j++) {
                int len = strings[i].get(j).length;
                int score = strings[i].get(j).score;
                dy[i+len] = Math.max(dy[i+len], dy[i]+score);
            }
        }
        System.out.println(dy[size]);
    }

    static class IndexScore {
        int length;
        int score;
        public IndexScore(int length, int score) {
            this.length = length;
            this.score = score;
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

