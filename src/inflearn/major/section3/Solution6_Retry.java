package inflearn.major.section3;

import java.util.*;

import inflearn.major.section3.Solution5.Task;

import static java.util.stream.Collectors.toList;

class Solution6_Retry {
	public int solution(int n, int[][] meetings){
		int[] meetingRoomUsageCounts = new int[n];
		int[] meetingRooms = new int[n];
		
		List<Meeting> meetingList = new ArrayList<>();
		for (int[] meeting : meetings) {
			meetingList.add(new Meeting(meeting[0], meeting[1]));
		}
		meetingList.sort(Comparator.comparingInt(Meeting::getStartTime));
		
		
		int t=0, pos=0, usageCount=0, max=0;
		
		Queue<Meeting> Q = new PriorityQueue<Meeting>();
		while(usageCount < meetings.length) {
			while(pos<meetings.length && meetingList.get(pos).getStartTime() <= t) {
				Q.offer(meetingList.get(pos++));
			}
			
			if (!Q.isEmpty()) {
				int roomNumber =-1;
				for (int i=0; i<n; i++) {
					if (meetingRooms[i] <= t) {
						roomNumber = i;
						break;
					}
				}
				
				if (roomNumber != -1) {
					Meeting cur = Q.poll();
					meetingRooms[roomNumber] = t + cur.getDuration();
					meetingRoomUsageCounts[roomNumber]++;
					usageCount++;
					max = Math.max(max, meetingRoomUsageCounts[roomNumber]);
				}
			}
			
			
			t++;
		}
		
		for (int i=0; i<n; i++) {
			if (meetingRoomUsageCounts[i] == max) {
				return i;
			}
		}
		
		return 0;
	}

	public static void main(String[] args){
		Solution6_Retry T = new Solution6_Retry();
		System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
		System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
		System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
		System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
	}
	
	
	public static class Meeting implements Comparable<Meeting> {
		
		private final int startTime;
		
		private final int endTime;
		
		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		
		@Override
		public int compareTo(Meeting other) {
			return Integer.compare(this.startTime, other.startTime);
		}
		
		public int getStartTime() {
			return this.startTime;
		}
		
		public int getEndTime() {
			return this.endTime;
		}
		
		public int getDuration() {
			return this.endTime-this.startTime;
		}
		
		
	}
	
	
}