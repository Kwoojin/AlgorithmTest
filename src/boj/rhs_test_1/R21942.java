package boj.rhs_test_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class R21942 {

    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int getTimestamp(String date, String time) {
        String[] dt = date.split("-");
        int month = Integer.parseInt(dt[1]);
        int day = Integer.parseInt(dt[2]);

        for(int i=1; i<month; i++) day += days[i];

        String[] tm = time.split(":");
        int hour = Integer.parseInt(tm[0]);
        int minute = Integer.parseInt(tm[1]);

        minute += (day * 24 + hour) * 60;

        return minute;
    }

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        String[] init = fr.nextLine().split(" ");

        int n = Integer.parseInt(init[0]);
        int p = Integer.parseInt(init[2]);

        String[] returnDate = init[1].split("/");

        int day = Integer.parseInt(returnDate[0]);
        int hour = Integer.parseInt(returnDate[1].split(":")[0]);
        int minute = Integer.parseInt(returnDate[1].split(":")[1]);

        long returnTime = (day * 24 + hour) * 60 + minute;

        HashMap<String, HashMap<String, Long>> reservation = new HashMap<>();
        HashMap<String, Long> penalty = new HashMap<>();

        while(n-- > 0) {
            String[] inputs = fr.nextLine().split(" ");

            String part = inputs[2];
            String name = inputs[3];
            long time = getTimestamp(inputs[0], inputs[1]);

            if(!reservation.containsKey(name)) {
                reservation.put(name, new HashMap<String, Long>());
                reservation.get(name).put(part, time);
            } else {
                if(!reservation.get(name).containsKey(part)) {
                    reservation.get(name).put(part, time);
                } else {
                    long startTime = reservation.get(name).get(part);
                    long used = time - startTime;

                    if(returnTime < used) {
                        long result = (used - returnTime) * p;
                        penalty.put(name, penalty.getOrDefault(name, 0L)+result);
                    }
                    reservation.get(name).remove(part);
                }
            }
        }

        List<String> names = new ArrayList<>(penalty.keySet());
        StringBuilder output = new StringBuilder();
        if(names.size() > 0) {
            Collections.sort(names);

            names.stream()
                    .forEach(name -> output.append(name + " " + penalty.get(name) + "\n"));
        } else {
            output.append(-1);
        }

        System.out.println(output);
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


