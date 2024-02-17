package inflearn.major.section1;

import java.util.*;
class Solution4 {
	
	final int[] dx = {1, 0, -1, 0};
	final int[] dy = {0, 1, 0, -1};
	
	public int[] solution(int c, int r, int k){
		if (c * r < k) {
			return new int[] {0, 0};
		}
		
		int[] answer = new int[2];
		
		int x=0, y=0, d=0, cur=0;
		
		int[][] seat = new int[r][c];
		
		// 20 명 좌석 채워질 때까지
		while (cur < k) {
			
			
			if (seat[x][y] == 0) {
				seat[x][y] = cur++;
				continue;
			}
			
			
			int n = 0;
			while (n < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < r && ny >= 0 && ny < c && seat[nx][ny] == 0) {
					x = nx;
					y = ny;
					break;
				} else {
					d = (d+1) % 4;
				}
				
				n++;
			}
			
			if (n == 4) {
				answer[0] = 0;
				answer[1] = 0;
				return answer;
			}
			
			
			
		}
		
		answer[0] = y+1;
		answer[1] = x+1;
		
		return answer;
	}

	public static void main(String[] args){
		Solution4 T = new Solution4();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
