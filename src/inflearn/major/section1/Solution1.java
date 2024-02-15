package inflearn.major.section1;

import java.util.*;
class Solution1 {
	public char[] solution(int n, int[][] ladder){
		char[] answer = new char[n];
		
		// init
		for (int i=0; i<n ; i++) {
			answer[i] = (char)(65+i);
		}
		
		for (int i=0; i<ladder.length; i++) {
			for (int j=0; j<ladder[i].length; j++) {
				int start = ladder[i][j] -1;
				
				char tmp = answer[start];
				answer[start] = answer[start+1];
				answer[start+1] = tmp; 
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
	}
}