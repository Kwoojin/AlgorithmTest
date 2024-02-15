package inflearn.major.section1;

import java.util.*;
class Solution2 {
	public int[] solution(int[][] board, int k){
		
		int n = board.length;
		
		int[] cur = {0, 0};
		int[] dir = {0, 1}; 
		for (int i=0; i<k; i++) {
			int[] next = {cur[0]+dir[0], cur[1]+dir[1]};
			if (next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < n && board[next[0]][next[1]] == 0) {
				cur = next;
			} else {
				dir = nextDirection(dir);
			}
		}
		return cur;
	}

	public static void main(String[] args){
		Solution2 T = new Solution2();
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
	
	public static int[] nextDirection(int[] dir) {
		if (dir[0]==0 && dir[1]==1) {
			int[] tmp = {1, 0};
			return tmp;
		} else if (dir[0]==1 && dir[1]==0) {
			int[] tmp = {0, -1};
			return tmp;
		} else if (dir[0]==0 && dir[1]==-1) {
			int[] tmp = {-1, 0};
			return tmp;
		} else {
			int[] tmp = {0, 1};
			return tmp;
		}
	}
}