package inflearn.major.section7;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution1 {
	
	private int l;
	private int answer = Integer.MAX_VALUE;
	
	/**
	 * 틀린거임
	 */
	public void DFS(int[] nums, int index, int count) {
		if (index >= l-1) {
			answer = Math.min(count, answer);
			return;
		}
		if(nums[index]==0) return;
		
		for(int i=1; i<=nums[index]; i++) {
			DFS(nums, index+i, count+1);
		}
	}
	
	public int solution(int[] nums){
		l=nums.length;
		answer = Integer.MAX_VALUE;
		
		
//		DFS(nums, 0, 0);
		
		answer = 0;
		
		Queue<Integer> Q = new LinkedList<>();
		int[] checked = new int[l];
		
		Q.offer(0);
		checked[0]=1;
		
		while(!Q.isEmpty()) {
			int size = Q.size();
			
			for (int i=0; i<size; i++) {
				Integer index = Q.poll();
				for(int j=1; j<=nums[index]; j++) {
					int next = index+j;
					if (next == l-1) return answer +1;
					if (next < l && checked[next]==0) {
						checked[next]=1;
						Q.offer(next);
					}
				}
			}
			answer++;
		}
		return -1;
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
		System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
	}
	
	
	public class Position implements Comparable<Position> {
		
		private final int start;
		
		private final int end;
		
		public Position(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		
		@Override
		public int compareTo(Position other) {
			if (this.start == other. start) {
				return this.end - other.end;
			}
			return Integer.compare(this.start, other. start);
		}
		
		public int getStart() {
			return this.start;
		}
		
		public int getEnd() {
			return this.end;
		}
		
		
		
		
	}
	
}