package inflearn.major.section2;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution4_Unsolved {
	
	public int solution(int[] nums, int m){
		int answer = 0;
		
		Map<Integer, Integer> sums = new HashMap<>();
		sums.put(0, 1);
		
		int sum = 0;
		
		for (int num: nums) {
			sum += num;
			
			if (sums.containsKey(sum-m)) {
				answer += sums.get(sum-m);
			}
			
			sums.put(sum, sums.getOrDefault(sum, 0)+1);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution4_Unsolved T = new Solution4_Unsolved();
		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
	
	
}