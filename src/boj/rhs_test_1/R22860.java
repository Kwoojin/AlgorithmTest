package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class R22860 {
    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int m = fr.nextInt();

        Folder main = new Folder("main");
        for(int i=0; i<n+m; i++) {
            String[] inputs = fr.nextLine().split(" ");
            String parent = inputs[0];
            String child = inputs[1];
            int type = Integer.parseInt(inputs[2]);

            Folder findFolder = getFolder(main, parent);
            if(type == 1) findFolder.addFolder(child);
            else findFolder.addFile(child);
        }

        int q = fr.nextInt();
        StringBuilder output = new StringBuilder();
        for(int i=0; i<q; i++) {
            String[] folders = fr.nextLine().split("/");
            String folderName = folders[folders.length-1];

            Folder findFolder = getFolder(main, folderName);
            HashSet<String> set = new HashSet<>();
            output.append(Folder.fileTypeTotalCount(findFolder, set) + " " + Folder.fileTotalCount(findFolder));
            output.append("\n");
        }
        System.out.print(output);
    }

    static Folder getFolder(Folder root, String name) {
        if(root.name.equals(name)) return root;
        else {
            for(int i=0; i<root.folders.size(); i++) {
                Folder findFolder = getFolder(root.folders.get(i), name);
                if(findFolder != null) return findFolder;
            }
        }
        return null;
    }

    static class Folder {
        String name;
        ArrayList<Folder> folders = new ArrayList<>();
        ArrayList<String> files = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void addFolder(String name) {
            folders.add(new Folder(name));
        }

        public void addFile(String name) {
            files.add(name);
        }

        public boolean isEmpty() {
            return (folders.size() + files.size()) == 0;
        }

        public static int fileTotalCount(Folder root) {
            int sum = root.files.size();
            for(int i=0; i<root.folders.size(); i++) {
                sum += fileTotalCount(root.folders.get(i));
            }
            return sum;
        }

        public static int fileTypeTotalCount(Folder root, HashSet<String> types) {
            root.files.stream()
                    .forEach(name -> types.add(name));
            for(int i=0; i<root.folders.size(); i++) {
                fileTypeTotalCount(root.folders.get(i), types);
            }
            return types.size();
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