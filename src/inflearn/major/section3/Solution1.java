package inflearn.major.section3;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution1 {
	public int solution(int[] nums){
		int answer = 1;
		
		Arrays.sort(nums);
		
		int length = 1, previousNum = nums[0];
		for (int i=1; i<nums.length; i++) {
			int num = nums[i];
			if (num == previousNum+1) {
				length++;
				answer = Math.max(answer, length);
			} else if (num > previousNum+1) {
				length = 1;
			}
			
			previousNum = num;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
	
	
}