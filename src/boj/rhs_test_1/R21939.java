package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.HashMap;


public class R21939 {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        TreeSet<Problem> set = new TreeSet<Problem>();
        HashMap<Integer, Integer> levels = new HashMap<>();

        int n = fr.nextInt();
        for(int i=0; i<n; i++) {
            int p = fr.nextInt();
            int l = fr.nextInt();

            set.add(new Problem(p, l));
            levels.put(p,l);
        }

        int m = fr.nextInt();
        for(int i=0; i<m; i++) {
            String type = fr.next();
            switch(type) {
                case "recommend" :
                    int x = fr.nextInt();
                    if(x==1) {
                        sb.append(String.valueOf(set.last().p)+"\n");
                    } else {
                        sb.append(String.valueOf(set.first().p)+"\n");
                    }
                    break;
                case "add" :
                    int p = fr.nextInt();
                    int l = fr.nextInt();
                    set.add(new Problem(p, l));
                    levels.put(p,l);
                    break;
                case "solved" :
                    int sp = fr.nextInt();
                    int sl = levels.get(sp);
                    set.remove(new Problem(sp, sl));
                    levels.remove(sp);
                    break;
            }

        }

        System.out.println(sb.toString());
    }

    static class Problem implements Comparable<Problem>{
        int p;
        int l;
        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
        @Override
        public int compareTo(Problem ob) {
            if(this.l == ob.l) return this.p - ob.p;
            else return this.l - ob.l;
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
