package inflearn.major.section1;

import java.util.*;
class Solution4_2 {
	
	private final int[] dx = {0, 1, 0, -1};
	private final int[] dy = {1, 0, -1, 0};
	
	public int[] solution(int c, int r, int k){
		if (c * r < k) {
			return new int[] {0, 0};
		}
		

		int[][] seat = new int[c][r];

		int cur=1, x=0, y=0, d=0, array=0;
		
		while(cur < k) {
			array++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			
			if (
				nx >= 0 && nx < c
				&& ny >= 0 && ny < r
				&& seat[nx][ny] == 0
			) {
				seat[x][y] = cur++;
				x = nx;
				y = ny;
			} else {
				d = (d+1) % dx.length;
			}
		}
	
		System.out.println(array);
		return new int[] {x+1, y+1};
	}

	public static void main(String[] args){
		Solution4_2 T = new Solution4_2();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
