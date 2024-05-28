package inflearn.major.section4;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution7 {
	public int solution(int[][] meetings){
		int answer = 0;
		
		List<Meeting> meetingList = new ArrayList<>();
		for (int i=0; i<meetings.length; i++) {
			meetingList.add(new Meeting(meetings[i][0], 1));
			meetingList.add(new Meeting(meetings[i][1], 0));
		}
		Collections.sort(meetingList);
		
		int count = 0;
		for (Meeting meeting : meetingList) {
			if (meeting.getType() == 1) {
				count++;
				answer = Math.max(count, answer);
			} else {
				count--;
			}
		}
	
    	return answer;
	}

	public static void main(String[] args){
		Solution7 T = new Solution7();
		System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
		System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
		System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
		System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
	}
	
	public static class Meeting implements Comparable<Meeting> {
		
		private final int time;
		
		private final int type;
		
		public Meeting(int time, int type) {
			this.time = time;
			this.type = type;
		}
		
		
		@Override
		public int compareTo(Meeting other) {
			if (this.time == other.time) {
				return Integer.compare(this.type, other.type);
			}
			return Integer.compare(this.time, other.time);
		}
		
		public int getType() {
			return this.type;
		}
	}
	
}