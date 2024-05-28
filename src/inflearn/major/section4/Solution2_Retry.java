package inflearn.major.section4;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution2_Retry {
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length / 2];
		int[] checked = new int[nums.length];
		
		Arrays.sort(nums);
		
		int pos = 0;
		for (int i=0; i<nums.length-1; i++) {
			if (checked[i] == 1) {
				continue;
			}
			
			
			answer[pos++] = nums[i];
			checked[i] = 1;
			
			for (int j=i+1; j<nums.length; j++) {
				if (checked[j] == 1) {
					continue;
				}
				
				if (nums[j] == nums[i]*2) {
					checked[j] = 1;
					break;
				}
				
			}
		}
	
		return answer;
	}

	public static void main(String[] args){
		Solution2_Retry T = new Solution2_Retry();
		System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
	
	
}