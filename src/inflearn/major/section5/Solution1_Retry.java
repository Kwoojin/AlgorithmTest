package inflearn.major.section5;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution1_Retry {
	public int solution(int[] nums, int m){
		int answer = 0;
		
//		int[] dNums = Arrays.stream(nums)
//			.boxed()
//			.sorted((a, b) -> b-a)
//			.mapToInt(Integer::intValue)
//			.toArray();
//		;
		
		Arrays.sort(nums);
		
		int[] checked = new int[nums.length];

		for (int i=nums.length-1; i>=0; i--) {
			if (checked[i]==1) continue;
			
			checked[i] = 1;
			boolean flag = false;
			
			for (int j=i-1; j>=0; j--) {
				if (checked[j]==1) continue;
				
				if (nums[i] + nums[j] <= m) {
					checked[j]=1;
					answer++;
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				answer++;
			}
		}
		
		
		return answer;
	}

	public static void main(String[] args){
		Solution1_Retry T = new Solution1_Retry();
		System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
		System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
		System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
	}
	
}