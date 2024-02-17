package inflearn.major.section1;

import java.util.*;
class Solution6 {
	public int solution(int[][] fruit){
		int n = fruit.length;
		
		int[] result = new int[n];
		
		for (int i=0; i<fruit.length; i++) {
			if (result[i] > 0) {
				continue;
			}
			
			for (int j=i+1; j<fruit.length; j++) {
				if (result[j] > 0) {
					continue;
				}
				
				int[] one = getFruitResult(fruit[i]);
				int[] two = getFruitResult(fruit[j]);
				
				if (one[0] == two[0]) {
					continue;
				}
				
				int[] f1 = new int[] {fruit[i][0], fruit[i][1], fruit[i][2]};
				int[] f2 = new int[] {fruit[j][0], fruit[j][1], fruit[j][2]};
				
				f1[one[0]]++;
				f1[two[0]]--;
				f2[two[0]]++;
				f2[one[0]]--;
				
				int[] none = getFruitResult(f1);
				int[] ntwo = getFruitResult(f2);
				
				if (one[1] < none[1] && two[1] < ntwo[1] ) {
					result[i] = none[1];
					result[j] = ntwo[1];
					break;
				}
			}
			
			if (result[i] == 0) {
				result[i] = getFruitResult(fruit[i])[1];
			}
		}
		

		
		int answer = 0;
		for (int num : result) answer += num;
		
		
		return answer;
	}
	
	public int[] getFruitResult(int[] fruits) {
		int minIndex = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<fruits.length; i++) {
			if (min > fruits[i]) {
				min = fruits[i];
				minIndex = i;
			}
		}
		
		return new int[] {minIndex, min};
	}

	public static void main(String[] args){
		Solution6 T = new Solution6();
		System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
		System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));	
		System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
		System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
	}
	
	
	
}
