package inflearn.major.section7;

import java.util.*;

import java.util.stream.Collectors;

class Solution5 {
	
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};
	

	public int solution(int[][] board){
		int n = board.length;
		
		int[][] dist = new int[n][n];
		
		Queue<int[]> queue = new LinkedList<>();
		
		int emptyLoad = 0;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (board[i][j]==1) {
					queue.offer(new int[] {i, j});
					
					int L = 0;
					emptyLoad--;
					while(!queue.isEmpty()) {
						L++;
						int size = queue.size();
						for (int a=0; a<size; a++) {
							int[] cur = queue.poll();
							
							for (int b=0; b<4; b++) {
								int nx = cur[0] + dx[b];
								int ny = cur[1] + dy[b];
								
								if (nx >= 0 && nx < n 
										&& ny >= 0 && ny < n
										&& board[nx][ny] == emptyLoad+1
								) {
									board[nx][ny] = emptyLoad;
									dist[nx][ny] += L;
									queue.offer(new int[] {nx, ny});
								}
							}
						}
					}
				}
			}
		}
		
		
		int answer = Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (board[i][j] == emptyLoad) {
					answer = Math.min(answer, dist[i][j]);
				}
			}
		}
		
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	public static void main(String[] args){
		Solution5 T = new Solution5();
		System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
	}
	
}