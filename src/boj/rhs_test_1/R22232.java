package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Arrays;

public class R22232 {

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int m = fr.nextInt();

        MyFile[] files = new MyFile[n];

        for(int i=0; i<n; i++) {
            String[] inputs = fr.nextLine().split("\\.");
            files[i] = new MyFile(inputs[0], inputs[1]);
        }

        HashSet<String> extensions = new HashSet<>();
        for(int i=0; i<m; i++) {
            String input = fr.nextLine();
            extensions.add(input);
        }

        for(int i=0; i<n; i++) {
            if(extensions.contains(files[i].extension)) files[i].containExt = 1;
            else files[i].containExt = -1;
        }


        Arrays.sort(files);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(files)
                .forEach(file -> sb.append(file+"\n"));

        System.out.print(sb);
    }

    static class MyFile implements Comparable<MyFile>{

        String name;
        String extension;
        int containExt;

        public MyFile(String name, String extension) {
            this.name = name;
            this.extension = extension;
        }

        @Override
        public int compareTo(MyFile ob) {
            if(!name.equals(ob.name)) return name.compareTo(ob.name);
            else {
                if(containExt != ob.containExt)
                    return this.containExt - ob.containExt;
                else
                    return extension.compareTo(ob.extension);
            }
        }

        @Override
        public String toString() {
            return name + "." + extension;
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