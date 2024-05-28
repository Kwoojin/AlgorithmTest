package inflearn.major.section5;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution3_Fail {

	public int solution(int n, int[] nums){
		int answer = 0;
		
		List<Range> range = new ArrayList<>();
		for (int i=0; i<nums.length; i++) {
			if (nums[i]==0) {
				continue;
			};
			
			int s = i-nums[i] < 0 ? 0 : i-nums[i];
			int e = i+nums[i] > n ? n : i+nums[i];
			
			range.add(new Range(s, e));
		}
		Collections.sort(range);
		
		int s=0, e=0, pos=0;
		while (pos < range.size()) {
			
			while(pos < range.size() && range.get(pos).getStart() <= s) {
				if (range.get(pos).getEnd() > e) {
					e = range.get(pos).getEnd();
				}
				pos++;
			}
			answer++;
			
			if (s==e) {
				return -1;
			}
			
			if (e==n) {
				return answer;
			}
				
			s = e;
			
		}
		
		
//		System.out.println(Arrays.toString(range));
		
		return answer;
	}

	public static void main(String[] args){
		Solution3_Fail T = new Solution3_Fail();
		System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
		System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));		
		System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
		System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
	}
	
	public static class Range implements Comparable<Range> {
		
		private final int start;
		
		private final int end;
		
		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		
		@Override
		public int compareTo(Range other) {
			if (this.start == other.start) {
				return this.end - other.end;
			}
			return this.start - other.start;
		}
		
		public int getStart() {
			return this.start;
		}
		
		public int getEnd() {
			return this.end;
		}
		
	}
	
}