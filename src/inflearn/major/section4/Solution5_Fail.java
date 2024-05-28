package inflearn.major.section4;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution5_Fail {
	
	public int solution(int[][] board){
		int answer = 0;
		
		
		List<Integer> studentX = new ArrayList<>();
		List<Integer> studentY = new ArrayList<>();
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j]  == 1) {
					studentX.add(i);
					studentY.add(j);
				}
			}
		}
		
		
		studentY.sort((a, b) -> a-b);
		int x = studentX.get(studentX.size() / 2);
		int y = studentY.get(studentY.size() / 2);
		
		for (int p : studentX) answer += Math.abs(x - p);
		for (int p : studentY) answer += Math.abs(y - p);
		
		return answer;
	}

	public static void main(String[] args){
		Solution5_Fail T = new Solution5_Fail();
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
	}
	
	
}