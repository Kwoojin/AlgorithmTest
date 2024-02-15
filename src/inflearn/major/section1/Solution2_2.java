package inflearn.major.section1;

import java.util.*;
class Solution2_2 {
	
	final int[] dx = {-1,0,1,0};
	final int[] dy = {0,1,0,-1};
	
	public int[] solution(int[][] board, int k){
		int[] answer = {0, 0};
		
		int d=1, n=0, x=0, y=0, len=board.length;
		
		while(n < k) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(
				nx >= 0 && nx < len
				&& ny >= 0 && ny < len
				&& board[nx][ny] == 0 
			) {
				x = nx;
				y = ny;
			} else {
				d = (d+1)%4;
			}
			
			n++;
		}
		
		answer[0] = x;
		answer[1] = y;
		
		return answer;
	}

	public static void main(String[] args){
		Solution2_2 T = new Solution2_2();
		int[][] arr1 = {
			{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
	}
}