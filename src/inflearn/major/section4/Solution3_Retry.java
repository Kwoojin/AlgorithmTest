package inflearn.major.section4;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution3_Retry {
	public int solution(int[] nums, int k){
		int answer = 0;
		
		Arrays.sort(nums);
		
		int[][] compares = new int[nums.length/2][2];
		for (int i=0; i<nums.length; i+=2) {
			int round = i/2;
			compares[round][0] = round;
			compares[round][1] = nums[i+1] - nums[i];
		}
		
		Arrays.sort(compares, (a, b) -> a[1]==b[1] ? b[0]-a[0]: b[1]-a[1]);

		Set<Integer> rounds = new HashSet<>();
		for (int i=0; i<k; i++) {
			rounds.add(compares[i][0]);
		}
		
		
		for (int i=0; i<nums.length; i+=2) {
			int round = i/2;
			
			if (rounds.contains(round)) {
				answer += nums[i] > nums[i+1] ? nums[i] : nums[i+1];
			} else {
				answer += nums[i] < nums[i+1] ? nums[i] : nums[i+1];
			}
		}
		
			
				
		return answer;
	}

	public static void main(String[] args){
		Solution3_Retry T = new Solution3_Retry();
		System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
		System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
		System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
		System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
		System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
	}
	
	
}