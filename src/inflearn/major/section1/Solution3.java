package inflearn.major.section1;

import java.util.*;
class Solution3 {
	
	final int[] dx = {-1, 0, 1, 0};
	final int[] dy = {0, 1, 0, -1};
	
	public int solution(int[][] board){
		int answer = 0;
		
		int[] hs = {0, 0}, dog = {0, 0};
		int hsd = 0, dogd = 0;
		
		int find = 0;
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (board[i][j] == 2) {
					hs[0] = i;
					hs[1] = j;
					find++;
				} else if (board[i][j] == 3) {
					dog[0] = i;
					dog[1] = j;
					find++;
				}
			}
			if (find == 2) {
				break;
			}
		}
		
		while(answer < 10000) {
			if(hs[0] == dog[0] && hs[1] == dog[1]) {
				break;
			}
			
			int hsnx = hs[0]+dx[hsd];
			int hsny = hs[1]+dy[hsd];
			
			if (
				hsnx >= 0 && hsnx < 10
				&& hsny >= 0 && hsny < 10
				&& board[hsnx][hsny] != 1
			) {
				hs[0] = hsnx;
				hs[1] = hsny;
			} else {
				hsd = (hsd+1) % 4;
			}
			
			
			int dognx = dog[0]+dx[dogd];
			int dogny = dog[1]+dy[dogd];
			
			if (
				dognx >= 0 && dognx < 10
				&& dogny >= 0 && dogny < 10
				&& board[dognx][dogny] != 1
			) {
				dog[0] = dognx;
				dog[1] = dogny;
			} else {
				dogd = (dogd+1) % 4;
			}
			
			answer++;
		}
		
		if (answer == 10000) {
			return 0;
		}
		
		return answer;		
	}
	
	

	public static void main(String[] args){
		Solution3 T = new Solution3();
		int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
		System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
		System.out.println(T.solution(arr2));
	}
}