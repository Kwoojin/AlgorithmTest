package inflearn.major.section7;

import java.util.*;

import java.util.stream.Collectors;

class Solution4 {
	
	final int[] dx = new int[] {0, 0, -1, 1};
	final int[] dy = new int[] {1, -1, 0, 0};
	
	
	public int solution(int[][] board){
		int answer = 0;
		
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {0, 0});
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				int[] current = queue.poll();
				int x = current[0];
				int y = current[1];
				
				for (int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if (nx == 6 && ny == 6) return answer +1; 
					if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny]==0) {
						board[nx][ny]=answer+1;
						queue.offer(new int[] {nx, ny});
					}
				}
				
			}
			answer++;
		}
		return -1;
	}

	public static void main(String[] args){
		Solution4 T = new Solution4();
		int[][] arr={{0, 0, 0, 0, 0, 0, 0}, 
				{0, 1, 1, 1, 1, 1, 0}, 
				{0, 0, 0, 1, 0, 0, 0}, 
				{1, 1, 0, 1, 0, 1, 1}, 
				{1, 1, 0, 1, 0, 0, 0}, 
				{1, 0, 0, 0, 1, 0, 0}, 
				{1, 0, 1, 0, 0, 0, 0}};
		System.out.println(T.solution(arr));
	}
	
}