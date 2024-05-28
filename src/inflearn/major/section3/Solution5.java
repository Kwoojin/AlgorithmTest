package inflearn.major.section3;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution5 {
	
	public int[] solution(int[][] tasks){
		int[] answer = new int[tasks.length];
		
		
		Queue<Task> queue = new PriorityQueue<Task>();
		
		List<Task> taskList = new ArrayList<>();
		for (int i=0; i<tasks.length; i++) {
			taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
		}
		taskList.sort(Comparator.comparingInt(Task::getStartTime));

		
		int t= taskList.get(0).getStartTime(), pos = 0, order=0, curTaskEndTime=0;
		
		
		while(order < tasks.length) {
			while(pos < tasks.length && taskList.get(pos).getStartTime() == t) {
				queue.offer(taskList.get(pos));
				pos++;
			}
			
			if (curTaskEndTime <= t && !queue.isEmpty()) {
				Task current = queue.poll();
				answer[order++] = current.getId();
				curTaskEndTime = t + current.getWorkload();
			}
			
			t++;
		}
			
		return answer;
	}

	public static void main(String[] args){
		Solution5 T = new Solution5();
		System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
	}
	
	
	public static class Task implements Comparable<Task> {
		
		private final int id;
		
		private final int startTime;
		
		private final int workload;
		
		public Task(int id, int startTime, int workload) {
			this.id = id;
			this.startTime = startTime;
			this.workload = workload;
		}
		
		@Override
		public int compareTo(Task other) {
			if (this.workload == other.workload) {
				return Integer.compare(this.id, other.id);
			}
			return Integer.compare(this.workload, other.workload);
		}
		
		public int getId() {
			return this.id;
		}
		
		public int getStartTime() {
			return this.startTime;
		}
		
		public int getWorkload() {
			return this.workload;
		}
		
	}
	
	
}