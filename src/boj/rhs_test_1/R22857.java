package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class R22857 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int k = fr.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = fr.nextInt();

        int max=0, cur=0, cnt=0, lt=0;
        for(int rt=0; rt<n; rt++) {
            if(arr[rt] % 2 == 0) {
                cur++;
                max = Math.max(max, cur);
            } else {
                while(cnt >= k) {
                    boolean isEven = (arr[lt] % 2 == 0);
                    if(isEven) {
                        cur--;
                    } else {
                        cnt--;
                    }
                    lt++;
                }
                cnt++;
            }
        }

        System.out.println(max);
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