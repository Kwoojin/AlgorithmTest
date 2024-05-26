package inflearn.major.section2;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution7 {
	
	public String[] solution(String[] reports, int time){
		
		Map<String, Integer> results = new HashMap<>();
		Set<String> answer = new HashSet<>();
		
		
		for (String report: reports) {
			String[] info = report.split(" ");
			String name = info[0];
			int min = this.convertTime(info[1]);
			String type = info[2];
			
			if (type.equals("in")) {
				results.put(name, results.getOrDefault(name, 0)-min);
			} else {
				results.put(name, results.getOrDefault(name, 0)+min);
				if (results.get(name) > time) {
					answer.add(name);
				}
			}
		}
		
		return answer
			.stream()
			.sorted(String::compareTo)
			.toArray(String[]::new)
		;
	}

	public static void main(String[] args){
		Solution7 T = new Solution7();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));	
		System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
		System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
	}
	
	public int convertTime(String time) {
		int hh = Integer.parseInt(time.split(":")[0]);
		int mm = Integer.parseInt(time.split(":")[1]);
		
		return hh * 60 + mm;
		
	}
	
	
}