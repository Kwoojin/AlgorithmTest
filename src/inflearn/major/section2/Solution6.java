package inflearn.major.section2;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution6 {
	public String[] solution(String[] reports, String times){
		String[] answer = {};
		
		String startTime = times.split(" ")[0];
		String endTime = times.split(" ")[1];
		
		int startHH = Integer.parseInt(startTime.split(":")[0]);
		int startMM = Integer.parseInt(startTime.split(":")[1]);
		
		int endHH = Integer.parseInt(endTime.split(":")[0]);
		int endMM = Integer.parseInt(endTime.split(":")[1]);
		
		List<Man> results = new ArrayList<>();
		
		for (String report: reports) {
			String name = report.split(" ")[0];
			String time = report.split(" ")[1];
			
			int hh = Integer.parseInt(time.split(":")[0]);
			int mm = Integer.parseInt(time.split(":")[1]);
			
			if (
				((startHH==hh && startMM<=mm) || startHH<hh)
				&& ((endHH==hh && endMM>=mm) || endHH>hh)
			) {
				results.add(new Man(name, hh, mm));
			}
		}
		
		
		return results
				.stream()
				.sorted()
				.map(m -> m.getName())
				.toArray(String[]::new);
	}

	public static void main(String[] args){
		Solution6 T = new Solution6();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
	
	public static class Man implements Comparable<Man> {
		private final String name;
		private final int hh;
		private final int mm;
		
		public Man(String name, int hh, int mm) {
			this.name = name;
			this.hh = hh;
			this.mm = mm;
		}
		
		@Override
		public int compareTo(Man ob) {
			if (this.hh == ob.hh) return this.mm - ob.mm;
			else return this.hh - ob.hh;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
}