package inflearn.major.section1;

import java.util.ArrayList;

class Solution5_2 {
	public static int solution(int[] nums){
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i=1; i<nums.length-1; i++) {
			if (nums[i-1] < nums[i] && nums[i+1] < nums[i] ) {
				list.add(i);
			}
		}
		
		for (int index: list) {
			int len = 1;
			
			int lt = index;
			while (lt > 0 && nums[lt-1] < nums[lt]) {
				len++;
				lt--;
			}
			
			
			int rt = index;
			while (rt < nums.length-1 && nums[rt+1] < nums[rt]) {
				len++;
				rt++;
			}
			
			if (answer < len) {
				answer = len;
			}
			
		}
				
		return answer;	
	}

	public static void main(String[] args){
		Solution5_2 T = new Solution5_2();
		System.out.println(Solution5_2.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
		System.out.println(Solution5_2.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(Solution5_2.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(Solution5_2.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}
